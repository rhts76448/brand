# Brand

Database Creation
---
1.java -jar target/Brand-0.0.1-SNAPSHOT.jar db migrate config.yml

How to start the Brand application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/Brand-0.0.1-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:9000`

Health Check
---

To see your applications health enter url `http://localhost:9001/healthcheck`

1.you can see the http error in console