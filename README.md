# Android-DNSSL

**Notice:** 

* HTTP requests: working 
* HTTPS requests: under develpment (I'm a little bit out of time with other projects...)


### Technologies

* Android/Java
* Python 3
* Flask
* MongoDB


### Purposes

* To demonstrate that you don't need ** TO NUKE SSL CERTIFICATES **

  * To nuke Self-Signed SSL Certificates is totally against the principle of security that you're planning to promote for your application. *

* To provide and example of integration among Python, FLASK, MongoDB and Android.


  * Use this example for your further projects and improve this example if you want to. Have fun :)! *


### A little bit of SSL...

Worth reading: http://info.ssl.com/article.aspx?id=10241

SSL was created to promote (at least attempt) security for HTTP traffic.

A SSL Certificate verified/signed by a CA, is the best choice. 
Nowadays, there are free CAs like Let's Encrypt (https://letsencrypt.org/), that can offer you very similar services as ther CAs, for free. But if for some reason, you're prefer to user a Self-Signed SSL Certificate, to guarantee security/encryption of the data transfered between your application and your webserver, DON'T NUKE THE SSL CERTIFICATE.

There are some questions (a lot of, actually) on StackOverflow with answers like "copy/paste this code to nuke the ssl certificates".

If you do not agree with this idea, go on with your reading :).


### How does it works?

This application, shows you how to create a **Custom TrustManager** for your Android Application, considering your Self-Signed Certificate.

By default, Android has his own **TrustManager**, with a set of CAs. A Self-Signed SSL Certificate, is not recognized by any of these CAs. When a **Custom TrustManager** is created, the application will accept the exchange of HTTP traffic coming from the source (webserver) to your Application (Android Device). 

It's like overriding this default set of CAs with your custom CA, although you can access other HTTPs links through your application, since that Android will ask you if you want to open the link with any of the browsers available on the system, which are beyond the context of the application which called them and then using the default set of CAs from Android.


