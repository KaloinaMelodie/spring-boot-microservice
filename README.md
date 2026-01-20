# Microservices Architecture – Poste & Competence Management
## Modular Backend System for Modeling Organizational Roles and Skills

---

## Overview

**EN:**  
This project focuses on the design and implementation of a modular microservices architecture for managing organizational structures through **job roles (postes)** and **competences (skills)**.  
The system demonstrates how to build loosely coupled services that communicate reliably while remaining easy to maintain, evolve, and deploy.

The project was designed as a practical showcase of modern backend architecture principles, including service discovery, centralized configuration, fault tolerance, and containerized deployment.

**FR :**  
Ce projet porte sur la conception et la mise en œuvre d’une architecture microservices modulaire permettant de modéliser une organisation à travers la gestion des **postes** et des **compétences**.  
Le système illustre la mise en place de services faiblement couplés, capables de communiquer de manière fiable tout en restant faciles à maintenir, à faire évoluer et à déployer.

Le projet a été conçu comme une démonstration concrète des principes modernes d’architecture backend : découverte de services, configuration centralisée, tolérance aux pannes et déploiement conteneurisé.

---

## Project Objectives

**EN:**
- Model job roles and competences as independent business services
- Ensure clear separation of responsibilities between services
- Enable resilient inter-service communication
- Centralize configuration and infrastructure concerns
- Provide a production-style microservices setup that is easy to run locally

**FR :**
- Modéliser les postes et les compétences comme des services métiers indépendants
- Garantir une séparation claire des responsabilités entre les services
- Assurer une communication inter-services résiliente
- Centraliser la configuration et les aspects d’infrastructure
- Proposer une architecture microservices réaliste, facile à exécuter en local

---

## Scope and Usage

**EN:**  
The system is intended as a backend foundation that could be used by applications needing to manage organizational roles and skill mappings.  
It can serve as:
- A technical portfolio project
- A learning reference for microservices architecture
- A base for future extensions (authentication, persistence, external APIs)

**FR :**  
Le système est conçu comme une base backend pouvant être utilisée par des applications nécessitant la gestion de postes et de compétences.  
Il peut servir :
- De projet portfolio technique
- De référence pédagogique sur l’architecture microservices
- De base pour des extensions futures (authentification, persistance, APIs externes)

---

## Core Features

**EN:**
- Independent business services for postes and competences
- REST APIs exposed through a single API Gateway
- Dynamic service discovery using Eureka
- Centralized configuration management
- Fault-tolerant communication using circuit breakers
- Full Docker-based deployment

**FR :**
- Services métiers indépendants pour les postes et les compétences
- APIs REST exposées via un point d’entrée unique (API Gateway)
- Découverte dynamique des services avec Eureka
- Gestion centralisée de la configuration
- Communication tolérante aux pannes grâce aux circuit breakers
- Déploiement entièrement basé sur Docker

---

## Technical Architecture

**EN:**  
The architecture is built around a set of independent Spring Boot services, each responsible for a specific role within the system.

Main components:
- **Discovery Service** (Eureka): service registration and discovery
- **Config Service**: centralized configuration management
- **API Gateway**: single entry point for all client requests
- **Poste Service**: management of job roles
- **Competence Service**: management of skills

All client requests pass through the API Gateway, which routes them dynamically using service discovery rather than fixed URLs.

**FR :**  
L’architecture repose sur un ensemble de services Spring Boot indépendants, chacun ayant un rôle bien défini.

Composants principaux :
- **Service de découverte** (Eureka) : enregistrement et découverte des services
- **Service de configuration** : gestion centralisée des configurations
- **API Gateway** : point d’entrée unique pour les requêtes clientes
- **Poste Service** : gestion des postes
- **Competence Service** : gestion des compétences

Toutes les requêtes clientes transitent par l’API Gateway, qui effectue le routage de manière dynamique grâce à la découverte de services.

---

## Code Organization

**EN:**  
Each service follows a strict layered architecture to ensure clarity and maintainability.

**FR :**  
Chaque service respecte une architecture en couches stricte afin de garantir la lisibilité et la maintenabilité du code.

```text
com.example.service
├── controller    // Gestion des requêtes HTTP
├── dto           // Objets exposés via l’API
├── entities      // Entités JPA (usage interne)
├── mapper        // Conversion Entity ↔ DTO
├── repository    // Accès aux données
├── service       // Logique métier (interfaces + implémentations)
└── client        // Clients Feign pour appels inter-services
