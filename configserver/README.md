# Configuration Service: Centralized Configuration Management

## Introduction

This service acts as a **centralized configuration server**, leveraging **Spring Cloud Config** to manage application properties across all environments in a distributed system. By externalizing configurations, the system ensures easier maintenance, scalability, and environment-specific setups.

## Runtime Configuration Refresh with Spring Cloud Bus

To maintain synchronized configurations across all services in real time, this service uses **Spring Cloud Bus**. Acting as a communication layer, it broadcasts configuration change events to all subscribed microservices. This approach eliminates the need for manual service restarts and ensures consistent updates across the ecosystem.

### Key Benefits:
- **Centralized Event Broadcasting**: Efficiently sends refresh events to all connected services.
- **Dynamic Configuration Updates**: Services dynamically adjust to updated properties at runtime.
- **Scalability**: Supports large-scale distributed systems with seamless event propagation.

## Dynamic Updates with Spring Cloud Config Monitor

The **Spring Cloud Config Monitor** library extends functionality by enabling event-based triggers for configuration changes. It introduces the `/monitor` endpoint, which listens for incoming events and triggers updates across the system.

### How It Works:
1. **Webhook Integration**: External systems, like **GitHub**, send push notifications to the `/monitor` endpoint via webhooks after every change in the configuration repository.
2. **Event Propagation**: The Config Service identifies updated configurations and broadcasts events using Spring Cloud Bus, ensuring all services stay synchronized.


### Advantages:
- **Automated Notifications**: Reduces the need for manual intervention.
- **Faster Updates**: Changes are propagated almost instantly.
- **Version Control Integration**: Ensures traceability and transparency of configuration changes.

## Features of the Configuration Service

- **Centralized Property Management**: Manage all application configurations from a single repository.
- **Environment-Specific Properties**: Load configurations tailored for specific environments like dev, test, or production.
- **Dynamic Updates**: Reflect configuration changes in real time without requiring application restarts.
- **Scalable Architecture**: Supports communication across multiple microservices in large distributed systems.

## Prerequisites

1. **RabbitMQ**: This service uses RabbitMQ as the message broker for broadcasting events. Ensure RabbitMQ is installed and configured.
2. **Git Configuration Repository**: A Git repository must be set up to host application properties.
3. **Webhook Configuration**: For push-based updates, configure webhooks in the Git repository.

This setup ensures your microservices ecosystem remains consistent, dynamically configurable, and easy to manage.
