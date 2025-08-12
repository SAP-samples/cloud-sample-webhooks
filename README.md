# Use Alert Webhooks from Cloud to On-Premise Monitoring

[![REUSE status](https://api.reuse.software/badge/github.com/SAP-samples/cloud-sample-webhooks)](https://api.reuse.software/info/github.com/SAP-samples/cloud-sample-webhooks)

## Description
The cloud to on-premise project helps you configure a connection so that you can receive your alerts locally. This project contains two servlets, one used for the webhook functionality that is uploaded on the cloud, and another for the on-premise processing of the received alerts. For the connection between SAP BTP, Neo environment and the on-premise backend system, you need to configure a cloud connector and a destination.

## Requirements
- You have a global account and a subaccount.
See [Getting Started](https://help.sap.com/viewer/65de2977205c403bbc107264b8eccf4b/Cloud/en-US/144e1733d0d64d58a7176e817fa6aeb3.html).
- You have active resources (applications) to receive alerts for.
- You have installed Maven.
- You have downloaded and set up your Eclipse IDE, SAP BTP Tools for Java, and SDK. See [Setting Up the Development Environment](https://help.sap.com/viewer/ea72206b834e4ace9cd834feed6c0e09/Cloud/en-US/e815ca4cbb5710148376c549fd74c0db.html).
- You have set up Java Web Tomcat 9 as a runtime environment. See Java Web Tomcat 9 Runtime in [Set Up the Runtime Environment](https://help.sap.com/viewer/ea72206b834e4ace9cd834feed6c0e09/Cloud/en-US/7613f000711e1014839a8273b0e91070.html).
- You have downloaded and initially configured the Cloud Connector. For this tutorial, you can use the portable version. See [Cloud Connector](https://help.sap.com/viewer/cca91383641e40ffbe03bdc78f00f681/Cloud/en-US/e6c7616abb5710148cfcf3e75d96d596.html).

## Download and Installation
Download the project as a ZIP file and then extract it into a local folder. Finally, import the folder into Eclipse as a Maven project. See [Tutorial: Receive Alerts in Your On-Premise System Using Java Web Tomcat 9](https://developers.sap.com/tutorials/cp-monitoring-alerts-onpremise.html).

## Configuration
Build a WAR file from Eclipse and deploy it on SAP BTP, Neo environment. You also need to deploy the WAR locally on your on-premise system. Furthermore, you need to configure the cloud connector and the destination. See [Tutorial: Receive Alerts in Your On-Premise System Using Java Web Tomcat 9](https://developers.sap.com/tutorials/cp-monitoring-alerts-onpremise.html).

## Support
This project is 'as-is'. We do not provide support and will not make changes. You are welcome to make changes to improve the project but we are not available for questions or support of any kind.

## License
Copyright (c) 2025 SAP SE or an SAP affiliate company. All rights reserved.
This project is licensed under the Apache Software License, v. 2 except as noted otherwise in the LICENSE file. See [LICENSE](LICENSES/Apache-2.0.txt).



