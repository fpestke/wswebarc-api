
# Web-Architektur-Workshop Backend-Part

Praxisbeispiel zur Generierung eines Services mit [swagger-codegen](https://github.com/swagger-api/swagger-codegen) und
Implementierung als Spring-Boot-Service.

## Generierung mit Swagger
Um ein Beispiel für einen Rest-Service mit etwas höherer Komplexität und umfangreicheren Objekten zu haben, wurde das Modell der Tesla-Owner-Api
ausgewählt, die [hier](https://app.swaggerhub.com/apis-docs/fehguy/tesla/2.0.2) in Swagger-Hub modelliert wurde.

1. Die zuhehörige Swagger-Yaml-Datei wurde von Swagger-Hub geladen und unter ```src/main/swagger``` gespeichert.
2. Die Generierungsvorschrift mit dem ```swagger-codegen-maven-plugin``` wurde an das Profil ```swagger-gen```gebunden, das defaultmäßig aktiviert ist.
3. mvn clean install generiert und übersetzt dann die Spring-Boot-App
4. src/main/generated sollte in Idea als `generated sources root` markiert werden, dann lässt sich die SpringBoot-Runkonfiguration leicht erstellen
5. Starten und [localhost:8080](http://localhost:8080) im Browser aufrufen, mit der Swagger-Api kann getestet werden.

## Dummy-Implementierung der Services
1. Streifzug durch die Sourcen und Swagger-Api-Annotationen
2. Verschieben des `ÀpiApiController`s nach src/main/java und Implementierung der folgenden Methoden 
    - GET /api/1/vehicles
    - GET /api/1/vehicles/{id}/data_request/charge_state
    - POST /api/1/vehicles/{id}/command/charge_start
    - POST /api/1/vehicles/{id}/command/charge_stop
3. Test der implementierten Methoden, z.B mit Postman
4. Actuator-URLs zeigen z.B. [localhost:8080/actuator/health](http://localhost:8080/actuator/health)
## Overview
This code was generated by the [swagger-codegen](https://github.com/swagger-api/swagger-codegen) project.
By using the [OpenAPI-Spec](https://github.com/swagger-api/swagger-core), you can easily generate an API stub.
This is an example of building API stub interfaces in Java using the Spring framework.

The stubs generated can be used in your existing Spring-MVC or Spring-Boot application to create controller endpoints
by adding ```@Controller``` classes that implement the interface. Eg:
```java
@Controller
public class PetController implements PetApi {
// implement all PetApi methods
}
```

You can also use the interface to create [Spring-Cloud Feign clients](http://projects.spring.io/spring-cloud/spring-cloud.html#spring-cloud-feign-inheritance).Eg:
```java
@FeignClient(name="pet", url="http://petstore.swagger.io/v2")
public interface PetClient extends PetApi {

}
```