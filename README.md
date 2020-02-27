# myorder-backend
*This backend project allows users to order food online at restaurants.*

A stateless backend built with Quarkus framework and Java. It offers a REST API for communication with the frontend.

## Quarkus framework
Why did I decide to checkout Quarkus?

There are several reasons which are very attractive in my eyes.

- Live Coding: Changes in your project (including config files, classes) will automatically take effect. No recompiling and deployment necessary. This is a big plus for developer experience and faster development.

- Proven Standards: Quarkus relies on established standards like Eclipse MicroProfile, JPA/Hibernate, JAX-RS/RESTEasy, Vert.x, Keycloack, Apache Camel, Apache Kafka and much more.

- Container First: minimal CPU and memory consumption + fast startup time.
  - Well integrated with Graal/SubstrateVM: You can decide to build with GraalVM (native, no JVM) or HotSpotVM (JVM). GraalVM brings a reduction of 60% in memory consumption under load and 80% in boot time compared with HotSpotVM. But also a build with HotSpotVM is already 50-60% more lightweight than what Spring offers after optimizations.
  - Compare of boot time: 4.3 s (Spring Boot), 0.943 s (Quarkus JVM), 0.016 s (Quarkus native) 
  - Quarkus is based on Netty: Netty takes ~ 40% less CPU consumption per request than Tomcat (or can handle 46% more requests).
  - Netty together with GraalVM reduces the CPU load by 75% while the memory consumption can be reduced by 70% compared with a Thorntail or Spring application.
    
- Fast Learning Curve: Developers with Java EE experience will have a short learning curve. Quarkus also offers Spring API compatibility, which can be used for migrating Spring Boot services to Quarkus.

- It's Production Ready: Backed by Red Hat. 4000 Stars on Github. Used in production at Lufthansa Technik, Vodafone Greece, Talkdesk, GoWithFlow and The Asiakastieto Group.

## REST API documentation
The REST API is documented with the OpenAPI specification in `src/main/resources/META-INF/openapi.yaml`

You can access the documentation with Swagger UI in your browser: `http://localhost:8080/swagger-ui/`

## Installation
* You need maven, docker and postgres installed on your development environment

PostgreSQL: url: `localhost` port: `5432` database: `postgres01` username: `quarkus01` password: `quarkpass01`

```
# Check maven and docker version
mvn -version // 3.6.3
docker version // 19.03.5

# Start running locally in dev mode
./mvnw compile quarkus:dev

# Build docker image with jvm
./mvnw package
docker build -f src/main/docker/Dockerfile.jvm -t myorder-backend-jvm .
docker run -i --rm -p 8080:8080 myorder-backend-jvm:latest

# Build docker image with native binary
./mvnw package
docker build -f src/main/docker/Dockerfile.native -t myorder-backend-native .
docker run -i --rm -p 8080:8080 myorder-backend-native:latest
```

You can access your running application with: `http://localhost:8080/`

## Live Demo
A demo of Quarkus is deployed on Cloud Run: `https://quarkus-backend-5bwtxjcuiq-uc.a.run.app`  
This demo frontend accesses the deployed demo backend: `https://myorder-frontend.firebaseapp.com`

You can place an order and finally check your submitted order with:  
`curl -w "\n" https://quarkus-backend-5bwtxjcuiq-uc.a.run.app/catalog/orders/{orderId}`

The demo above is a docker container deployed on Cloud Run, which is serverless and fully managed. That means the backend scales automatically but also stops when there are no requests.
It could happen that you have to wait some seconds until the quarkus container is running, and the products can be loaded by the frontend.