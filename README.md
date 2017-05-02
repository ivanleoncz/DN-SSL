# Android-DNSSL

## [under development - don't use it]

### Purposes

* To provide a simple example of integration among technologies (Python, FLASK, MongoDB and Android).

* To demonstrate a basic concept when using Self-Signed Certificates: **DON'T NUKE SSL!**

### Introduction

SSL was created to promote (at least attempt) security for HTTP traffic.

A SSL Certificate verified/signed by a CA, is the best choice. But if for some reason, you're using a Self-Signed SSL Certificate, to guarantee security/encryption for the data transfered between your application and your webserver, DON'T NUKE THE SSL CERTIFICATE.

There are some questions on StackOverflow, with answers like "copy/paste this code to nuke the ssl certificates".

* http://stackoverflow.com/questions/2012497/accepting-a-certificate-for-https-on-android/40112598#40112598

If you're planning to create some sort of security for your application, to nuke Self-Signed SSL Certificates is totally against the principle
that you're trying to promote.


### How does it works?

This application, shows you how to create a **Custom TrustManager** for your Android Application, considering your Self-Signed Certificate.

Android has (by default), has his own **TrustManager**, with a set of CA's. A Self-Signed SSL Certificate, is not recognized by any of these CA's, unless the one that you used during the creation process. When a **Custom TrustManager** is created, the application will accept the exchange of HTTP traffic coming from the source (webserver).


