# Space Mission Telemetry Platform

## Overview

The Space Mission Telemetry Platform is a Microservices-based Spring Boot application designed to simulate the monitoring and management of space mission operations. The platform is divided into independent services, where each microservice performs a specific responsibility and communicates through an API Gateway.

This project demonstrates the implementation of Microservices Architecture using Spring Boot.



## Technologies Used

- Java 17
- Spring Boot
- Maven
- REST API
- Spring Boot Actuator
- IntelliJ IDEA
- Git
- GitHub



## Project Structure

```
Space-Mission-Telemetry-Platform
│
├── api-gateway
├── maintenance-service
├── mission-alert-service
├── orbital-registry-service
└── sensor-monitor-device
```

## Microservices

### 1. API Gateway

Acts as the single entry point for all client requests.

Project Name:
```
api-gateway
```

Responsibilities

- Routes incoming requests
- Centralized API access
- Future integration with Spring Cloud Gateway



### 2. Maintenance Service

Project Name:
```
maintenance-service
```

Port

```
8080
```

Responsibilities

- Handles maintenance-related operations
- Provides REST APIs for maintenance management



### 3. Orbital Registry Service

Project Name:
```
orbital-registry-service
```

Port

```
8081
```

Responsibilities

- Maintains orbital registry information
- Handles spacecraft registration data



### 4. Sensor Monitor Device

Project Name

```
sensor-monitor-device
```

Port

```
8082
```

Responsibilities

- Simulates spacecraft sensor monitoring
- Provides telemetry sensor data



### 5. Mission Alert Service

Project Name

```
mission-alert-service
```

Port

```
8083
```

Responsibilities

- Generates mission alerts
- Handles alert notifications



## Port Configuration

| Service | Port |
|----------|------|
| Maintenance Service | 8080 |
| Orbital Registry Service | 8081 |
| Sensor Monitor Device | 8082 |
| Mission Alert Service | 8083 |


## Architecture Diagram

```
                    +----------------------+
                    |       Client         |
                    +----------+-----------+
                               |
                               |
                     +---------v---------+
                     |    API Gateway    |
                     +---------+---------+
                               |
       -----------------------------------------------------
       |                  |                 |               |
       |                  |                 |               |
+------v------+   +-------v-------+ +-------v-------+ +-----v------+
| Maintenance |   |   Orbital     | | Sensor Monitor| |  Mission   |
|  Service    |   | Registry      | |    Device     | | Alert       |
|  Port 8080  |   | Port 8081     | | Port 8082     | | Port 8083   |
+-------------+   +---------------+ +---------------+ +-------------+
```

## Screenshots

All microservices were accessed and tested through the **API Gateway** running on **Port 8084**. The API Gateway acts as the single entry point for client requests and routes them to the appropriate microservice based on the configured routes. The following screenshots demonstrate successful **GET** and **POST** requests for each microservice through the API Gateway.

<img width="1918" height="1137" alt="Screenshot 2026-07-23 201220" src="https://github.com/user-attachments/assets/c2078e42-bd1c-44d0-a061-47f4584f152c" />
<img width="1917" height="1138" alt="Screenshot 2026-07-23 201426" src="https://github.com/user-attachments/assets/e934c3b5-cdf5-4737-988c-541dcc535c32" />
<img width="1918" height="1137" alt="Screenshot 2026-07-23 201514" src="https://github.com/user-attachments/assets/c4c3f707-56b5-427a-b38b-ddf5a1b5c847" />
<img width="1918" height="1141" alt="Screenshot 2026-07-23 201616" src="https://github.com/user-attachments/assets/5b6e6dec-7eb6-4d71-866b-d00f23bf86f5" />
<img width="1918" height="1137" alt="Screenshot 2026-07-23 201837" src="https://github.com/user-attachments/assets/1b8b382f-6e34-4f9b-87b2-804846dab21e" />
<img width="1918" height="1140" alt="Screenshot 2026-07-23 201859" src="https://github.com/user-attachments/assets/35e4a0ec-de69-455b-bc01-7e97d18645a9" />
<img width="1918" height="1138" alt="Screenshot 2026-07-23 202114" src="https://github.com/user-attachments/assets/6c88a1c2-b41f-433d-90a6-b3245820c92f" />
<img width="1918" height="1138" alt="Screenshot 2026-07-23 201955" src="https://github.com/user-attachments/assets/2c13650f-02ed-44f1-929c-dbeebacecaaf" />


## Future Enhancements

- Spring Cloud Gateway
- Service Discovery
- Config Server
- Load Balancing
- Circuit Breaker
- JWT Authentication
- Docker
- Kubernetes
- Monitoring Dashboard
- Database Integration


## Author

Mohamed Althaf

GitHub

https://github.com/Althaf2007
