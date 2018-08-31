package com.sap.cloud.samples.web.hooks.http;

import java.io.Closeable;
import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import com.sap.core.connectivity.api.configuration.ConnectivityConfiguration;
import com.sap.core.connectivity.api.configuration.DestinationConfiguration;

public class BackendSystemClient implements Closeable {

    private String destinationName;
    private SCCHttpClient client;

    public BackendSystemClient(SCCHttpClient client, String destinationName) {
        this.client = client;
        this.destinationName = destinationName;
    }

    public void post(String content) throws IOException {
        HttpResponse response = client.execute(buildPostRequest(getDestinationUrl(), content));
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != HttpStatus.SC_OK) {
            throw new IOException("Backend system returned unexpected status code: " + statusCode);
        }
    }

    private HttpPost buildPostRequest(String url, String body) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(body));
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
        return httpPost;
    }

    private String getDestinationUrl() throws IOException {
        try {
            Context ctx = new InitialContext();
            ConnectivityConfiguration configuration =
                (ConnectivityConfiguration) ctx.lookup("java:comp/env/connectivityConfiguration");
            DestinationConfiguration destinationConfiguration = configuration.getConfiguration(destinationName);
            if (destinationConfiguration == null) {
                throw new IOException("Count not find destination with name: " + destinationName);
            }
            return destinationConfiguration.getProperty("URL");
        } catch (NamingException e) {
            throw new IOException("Naming exception occured while constructing context object", e);
        }
    }

    @Override
    public void close() throws IOException {
        client.close();
    }
}
