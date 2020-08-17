# Google Summer of Code 2020 - OWASP

## OWASP iGNITA




### Project Overview

Building a Standalone Scanner and staging the results to detect OWASP TOP 10 Vulnerabilities and building plugins for IDE’s and Continuous Integration 

## Project Proposal 

As the increase of software development, billions of lines of code is being produced but the quality of the code is menacing thereby the vulnerability of applications are threatening, even though there are many tools to monitor applications for vulnerabilities it’s always too late. One of the solutions to this is to analyse and fix these vulnerable code while development, but there are only few tools available for scanning the code vulnerabilities.
OWASP iGNITA is a fine example for such a tool, but because of many third party dependencies, setting up the framework for testing is time consuming and a bit disorderd.

## Proposed Strategy

To overcome the above mentioned problems, It is a fine game plan to build an own standalone analyser to detect vulnerabilities where the OWASP iGNITA Scanner will be independent from tools such as OWASP SonarQube, which will make the Framework more light and easy to set up, and users won’t be restricted to the API provided by the sonarqube or other scanners of such. Also creating a plugin for IDE’s which will be a faster way to detect vulnerabilities. And dockerize the Framework so the set up time will be minimal and less hectic. This plugin will also be proposed to be integrated into  DevSecOps toolchain; github/jenkins/owasp appsec pipelines. Additionally a developer guide will be written with guidelines, templates and other titles for future collaborators.

Requirement which satisfy the Important Selection Criteria,

- Vulnerabilities it can detect (out of the OWASP Top Ten?) - Focused on top Ten
- Can it be integrated into the developer's IDE? - Plugin is proposed to be developed
- How hard is it to set up/use? - Dockerizing for easy setup
- Can it be run continuously and automatically? - Will be tested and added to pipeline in github

![Architecture](/assets/images/Architecture.png)
<em>High level architecture diagram</em>

### Features of the Analyzer
- The analyzer will initially focus on JAVA language
- Analyzer will be built to detect owasp top 10 vulnerabilities such as,
    - Injection
    - Broken Authentication
    - Sensitive Data Exposure
    - XEE
    - Broken Access Control
    - Security Misconfig
    - Cross site Scripting 
    - Insecure deserialization

### Timeline

| **Milestone** | **Tasks** | **Reporting** | **Week** | **Date** | **Status** |
| --- | --- | --- | --- | --- | --- |
| **1 - Analysis** |
| 1.1 | Analysis on other scanners which are currently support OWASP TOP 10 | None | 1 | 15/05/20 | COMPLETED |
| 1.2 | Analysis on the software architecture of similar scanners | Review architecture with mentor | 1 | 20/05/20 |COMPLETED |
| 1.3 | Analysis on plugins | Review development strategy with mentor | 2 | 25/05/20 |COMPLETED |
| 1.4 | Plan the detectors which will be built in GSOC period | Discuss with mentor | 2 | 30/05/20 |COMPLETED |
| **2 - Development** |
| 2.1 | Setting up environment | None | 3 | 01/06/20 |COMPLETED |
| 2.2 | Creating vulnerable samples | None | 5 | 15/06/20 |COMPLETED |
| 2.3 | Writing test classes | Mentor Review | 5 | 23/06/20 |COMPLETED |
| 2.4 | Configuring the detectors | None | 7 | 05/07/20 |COMPLETED |
| 2.5 | Creating Detector classes | Mentor Review | 8 | 10/07/20 | COMPLETED |
| 2.6 | Integrating into the Dashboard | None | 9 | 20/07/20 | COMPLETED |
| 2.7 | Modifying the scanner for the plugin structure | Mentor Review | 10 | 25/07/20 |COMPLETED |
| 2.8 | Modifying for scanner to be added to multiple pipelines | Mentor Review | 10 | 30/07/20 |COMPLETED |
| **3 - Testing** |
| 3.1 | Writing test cases | Mentor Review | 11 | 02/08/20 |COMPLETED |
| 3.2 | Testing detectors with sample code | Mentor Review | 12 | 09/08/20 |COMPLETED|
| 3.3 | Testing detectors for each developed vulnerability in know test set | None | 13 | 11/08/20 |COMPLETED |
| 3.4 | Testing with integrated dashboard | Mentor Review | 13 | 14/08/20 |COMPLETED |
| 3.5 | Testing the plugin | None | 14 | 16/08/20 |COMPLETED |
| **4 - Deployment** |
| 4.1 | Dockerizing the application with integrated scanner | Mentor Test | 14 | 18/08/20 |IN-PROGRESS |
| 4.2 | Deploying Docker Image | None | 14 | 19/08/20 |IN-PROGRESS |
| **5 - Documentation** |
| 5.1 | Documenting the Analyzer | Mentor Review | 14 | 21/08/20 |NOT STARTED |
| 5.2 | Documenting the Plugin | Mentor Review | 14 | 22/08/20 |NOT STARTED |
| 5.3 | Writing the Developer Guide | Mentor Review | 14 | 23/08/20 |NOT STARTED |




