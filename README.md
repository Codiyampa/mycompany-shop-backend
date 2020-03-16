# myorder-backend
*This backend project allows users to order food online at restaurants.*

A stateless backend built with Quarkus framework and Java. It offers a REST API for communication with the frontend.

## Quarkus framework
Why did I decide to checkout the new Quarkus project?

There are several reasons which are very attractive.

- Hot Code Reload:    
    Changes in your project (including config files, classes) will automatically take effect. No dedicated recompiling and deployment necessary. This is a big plus for developer experience and faster development.

- Proven Standards:   
    Quarkus relies on established standards like Eclipse MicroProfile, JPA/Hibernate, JAX-RS/RESTEasy, Vert.x, Keycloak, Apache Camel, Apache Kafka and much more.

- Container First:    
    Minimal CPU and memory consumption + fast startup time.
  - Well integrated with Graal/SubstrateVM: You can decide to build with GraalVM (native, no JVM) or HotSpotVM (Bytecode, JVM). Both builds are a lot more lightweight than what Spring or Thorntail offer after optimizations.
  - Based on Netty: Netty is non-blocking and takes ~ 40% less CPU consumption per request than Tomcat (or can handle 46% more requests).
  - Netty together with GraalVM can reduce the CPU load by ~63% while the memory consumption can be reduced by ~85% compared with Thorntail.
  - Compare of boot time: 4.3 s (Spring Boot), 0.943 s (Quarkus JVM), 0.016 s (Quarkus native)
  - Source 1: [https://github.com/rmh78/quarkus-performance](https://github.com/rmh78/quarkus-performance)
  - Source 2: [https://quarkus.io/blog/runtime-performance/](https://quarkus.io/blog/runtime-performance/)
    
- Short Learning Curve:   
    Developers with Java EE experience will have a short learning curve. Quarkus also offers Spring API compatibility, which can be used for migrating Spring Boot services to Quarkus.

- Production Ready:    
    Backed by Red Hat. 4000 Stars on Github. Used in production at Lufthansa Technik, Vodafone Greece, Talkdesk, GoWithFlow and The Asiakastieto Group.

## REST API documentation
The REST API is documented with the OpenAPI specification.

Path to documentation: `src/main/resources/META-INF/openapi.yaml`

You can see the documentation with the help of Swagger UI in your browser: `http://localhost:8080/swagger-ui/`

## Installation
* You need maven, docker and postgres installed on your development environment

Set up local PostgreSQL database:   
url: `localhost` port: `5432` database: `postgres01` username: `quarkus01` password: `quarkpass01`

```
# Check maven and docker version
mvn -version // 3.6.3
docker version // 19.03.5

# Start running locally in dev mode
./mvnw compile quarkus:dev

# Build docker image with jvm mode
./mvnw package
docker build -f src/main/docker/Dockerfile.jvm -t myorder-backend-jvm .
docker run -i --rm -p 8080:8080 myorder-backend-jvm:latest

# Build docker image with native binary mode
./mvnw package
docker build -f src/main/docker/Dockerfile.native -t myorder-backend-native .
docker run -i --rm -p 8080:8080 myorder-backend-native:latest
```

You can access your running application with: `http://localhost:8080/`

## Source code structure
The architecture is based on some thoughts of Domain Driven Design and CQRS.

    .
    ├── src
    │   ├── test
    │   │   └── java
    │   │       └── at.mycompany.shop
    │   │           └── test
    │   └── main
    │       ├── docker
    │       ├── java
    │       │   └── at.mycompany.shop
    │       │       ├── application
    │       │       ├── architecture
    │       │       │    ├── repository
    │       │       │    └── web
    │       │       │        ├── mapper
    │       │       │        └── resource
    │       │       └── domain
    │       │           └── model
    │       │           │    ├── entity
    │       │           │    └── repository
    │       │           └── service
    │       └── resources
    │           ├── db.migration
    │           ├── META-INF
    │           │   ├── resources
    │           │   │   └── index.html
    │           │   └── openapi.yaml
    │           └── application.properties
    ├── pom.xml
    └── README.md
    
## Live Demo
Live demo of backend on Cloud Run: [https://quarkus-backend-5bwtxjcuiq-uc.a.run.app](https://quarkus-backend-5bwtxjcuiq-uc.a.run.app)   
Live demo of frontend on Firebase: [https://myorder-frontend.firebaseapp.com](https://myorder-frontend.firebaseapp.com)   

You can place an order and finally check your submitted order with:  
`curl -w "\n" https://quarkus-backend-5bwtxjcuiq-uc.a.run.app/v1/orders/{orderId}`

The backend is a docker container deployed on Cloud Run, which is serverless and fully managed. That means the backend scales automatically but also stops when there are no requests.
It may happen that you have to wait some seconds until the quarkus container is running, and the frontend is able to access the REST API.