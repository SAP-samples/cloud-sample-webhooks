package com.sap.cloud.samples.web.hooks.web;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BackendSystemServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rootDir = getServletContext().getRealPath("/");
        File file = new File(rootDir + "alert_" + System.currentTimeMillis() + ".json");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                BufferedReader reader = req.getReader()) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
            }
        }
    }
}