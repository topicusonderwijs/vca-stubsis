# vca-stubsis

Dit probject bevat een voorbeeldkoppeling tussen een SIS en VCA.
Voor het bouwen van de code is een recente versie van Maven en Java 11 vereist.
Na het draaien van `mvn package`, kan de bouwde war gedeployed worden in een WildFly 17 application server.

Dit probject bestaat uit de volgende onderdelen:
```
├── pom.xml
└── src/main
        ├── java
        │   └── nl/topicus/cambo/stubsis
        │       ├── client
        │       │   ├── JacksonObjectMapperProvider.java 
        │       │   └── StubSISCamboClient.java           (Example REST client)
        │       ├── model
        │       │   └── *.java                            (VCA modeldefinities)
        │       ├── StubSISEndPoint.java                  (UI via een freemarker template en JAX-RS)
        │       └── StubSISJaxRsActivator.java            (Activeer JAX-RS)
        ├── resources
        │   └── nl/topicus/cambo/stubsis/stubsis.ftl      (HTML template voor de simpele UI)
        └── webapp
            └── WEB-INF
                ├── beans.xml                             (Activeer CDI)
                ├── jboss-web.xml                         (Deploy op /stubsis)
                └── web.xml                               (Activeer Servlet API)
```

Voor het draaien van StubSIS dienen de volgende system properties geset te worden:
 - `stubsis/tlscertbundle` De locatie van de Java Keystore met het (dummy) PKI-overheid-certificaat (met key).
 - `stubsis/tlscertpassword` Het wachtwoord voor de Keystore en de key.
 - `cambo/hostname` De FQNN waar VCA draait (bijvoorbeeld `test.centraalaanmeldenmbo.nl`).
