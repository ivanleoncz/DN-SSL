# Android-DNSSL

### [under development - don't use it]

LoginApp that gives you the following message after successful login: **DON'T NUKE SSL!** 

SSL was created in order to promote (at least attempt) security for HTTP traffic.
A SSL Certificate verified by a CA, is the best choice. But if for some reason, you're using a Self-Signed SSL Certificate between your application and your webserver, DON'T NUKE THE SSL CERTIFICATES.

This application, shows you how to create a **Custom TrustManager** for your Android Application, considering your Self-Signed Certificate.

Android has (by default), has his own TrustManager, with a set of CA's. A Self-Signed Certificate, is not recognized by any of these CA's, unless the one that you used during the creation process.

When a Custom TrustManager is created, the application will accept the exchange of HTTP traffic coming from the source (webserver).

Here is one from dozens of questions where, many people, adivises you **TO NUKE ALL SSL CERTIFICATE, which is nonsense.**

* http://stackoverflow.com/questions/2012497/accepting-a-certificate-for-https-on-android/40112598#40112598
