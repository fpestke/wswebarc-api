
# Web-Architektur-Workshop Backend-Part

Praxisbeispiel zur Generierung eines Services mit [swagger-codegen](https://github.com/swagger-api/swagger-codegen) und
Implementierung als Spring-Boot-Service.
Erstellung eines Docker-Images und Deployment in eine Kubernetes-Plattform.

## Generieren mit Swagger
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

## Docker-Integration
1. Dockerfile ansehen
    ```dockerfile
    FROM  openjdk:11.0.5-jdk-slim
    
    VOLUME /tmp
    ARG JAR_FILE=target/*.jar
    COPY ${JAR_FILE} app.jar
    
    LABEL SERVICE_CHECK_HTTP=/actuator/health
    EXPOSE 8080
    ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
    ```
2. docker build
    ```
     docker build -t ws-crs/ev-backend .
    ```
3. docker run
    ```
    docker run -p 8081:8080 -d --name ev-backend -t ws-crs/ev-backend 
    ```
4. Testen mit [localhost:8081](http://localhost:8081)
5. Hilfreiche Befehle:
    ```
    docker inspect ev-backend
    docker logs -f ev-backend
    docker ps
    docker stop ev-backend
    docker rm ev-backend
    ```
6. Deployment, siehe Kubernetes on GCP

## Kubernetes (lokal mit minikube)
Voraussetzung: minikube installieren
siehe https://kubernetes.io/docs/tasks/tools/install-minikube/
(bedingt eine Hypervisor-Installation, z.B. virtualbox)
1. minikube starten
    ```
    minikube start
    ```
2. kubectl context auf minikube setzen (nur nötig bei mehreren konfigurietren k8s-Clustern)
    ```
    kubectl config use-context minikube
    ```
2. container in minikube starten 
    ```
    kubectl run ev-backend --image=gcr.io/elite-droplet-256314/ws-crs/ev-backend:latest
    ``` 
4. Hat es geklappt?
    ```
    kubectl get pods
    ```
5. Service erstellen, um feste IP-Adresse zu haben
```
    kubectl expose deployment ev-backend --type=NodePort --name=ev-backend-service --port=8080
    kubectl get service ev-backend-service oder:
    minikube service ev-backend-service --url
    (Zugriff auf die Url, oder CLUSTER-IP:8080)
```

## Kubernetes on GCP
1. Installation von gcloud (benötigt Python)
siehe https://cloud.google.com/sdk/install
2. gcloud initialisieren
    ```
    gcloud init --console-only (ggf. vorher Proxykonfiguration vornehmen)
    ```
3. Verbindung zum Cluster, in GCP-Oberfläche Verbinden auswählen und dann Shell-Befehl kopieren und ausführen
4. ev-backend Image in GCP-ContainerRegistry pushen (GCR ist als public definiert, um ein pull ohne Login zu ermöglichen.)
    ```
    gcloud auth configure-docker
    docker tag ws-crs/ev-backend gcr.io/[PROJECT-ID]/ws-crs/ev-backend  (PROJECT-ID ist Projekt, das in GCP erstellt wurde, also elite-droplet-256314)
    docker push gcr.io/[PROJECT-ID]/ws-crs/ev-backend
    ```
5. Deployment in GKE auf GCP
    ```
    kubectl run ev-backend --image=gcr.io/elite-droplet-256314/ws-crs/ev-backend:latest
    kubectl get po
    ``` 
6. Service erzeugen, diesmal vom Typ Loadbalancer, um auch externe Zugriffe zu ermöglichen
    ```
    kubectl expose deployment ev-backend --type=NodePort --name=ev-backend-service --port=8080
    kubectl get service ev-backend-service
    (Browser-Zugriff über EXTERNAL-IP:8080)
   ```
7. Wie können andere Container auf den Service zugreifen?
    ```
    kubectl get po
    kubectl exec POD-NAME -- env (keine Env-Variable vorhanden, da Service noch nicht erstellt war, als Pod gestartet wurde.)
    kubectl delete po POD-NAME
    kubectl get po (neuer Pod???)
    kubectl exec NEUER-POD-NAME -- env (Env-Var EV_BACKEND_SERVICE_SERVICE_HOST und PORT)
    ``` 
8. Skalieren auf zweiten Pod, warum wurde Pod restartet?:
    ```
    kubectl get rs
    kubectl scale --replicas=2  deploy/ev-backend
    kubectl get po
    ```
9. Redeploy
   ```
   application.properties ändern zu Info-Version
   mvn und docker-build tag und deploy
   Trick: kubectl patch deployment ev-backend -p "{\"spec\": {\"template\": {\"metadata\": { \"labels\": {  \"redeploy\": \"$(date +%s)\"}}}}}"
   kubectl get rs
   kubectl get po
   ```
10. YAML Konfig
    ```
    Kann abgerufen werden, zum Beispiel über:
    kubectl get deploy ev-backend -o yaml --export
    kubectl get service ev-backend-service -o yaml --export
    #service auf NodePort wechseln
    kubectl apply -f k8s.ev-backend-service.service.yaml
    ```  
11. Ingress Service
    ```
    kubectl apply -f k8s.ingress.yaml  
    kubectl get ingresses
    (DNS-Eintrag für IP-Adresse des ingress services eintragen)
    http://ws-crs.dyndns.org/actuator/info
    ``` 