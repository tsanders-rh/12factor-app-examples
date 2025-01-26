# **BadApp**

BadApp is a Java-based application designed to demonstrate what not to do when developing a cloud-native application. It intentionally violates the [12-factor app principles](https://12factor.net/) to highlight common anti-patterns and pitfalls in modern software development.

---

## **Features**
- Hardcoded configurations.
- Poor dependency management.
- Tight coupling of environments and code.
- Lack of scalability or modularity.

---

## **Table of Contents**
1. [Getting Started](#getting-started)
2. [Prerequisites](#prerequisites)
3. [Installation](#installation)
4. [Database Setup](#database-setup)
5. [Running the Application](#running-the-application)
6. [Known Issues](#known-issues)
7. [License](#license)

---

## **Getting Started**

BadApp is built with Java and Maven. To get started, clone this repository, set up the database, and compile the application.

---

## **Prerequisites**

Make sure you have the following installed:
- Java 17+
- Maven 3.6+
- MySQL 5.7+ or 8.0+
- Bash (for running the setup scripts on Linux/macOS)

---

## **Installation**

1. Clone this repository:
   ```bash
   git clone https://github.com/tsanders_rh/12factor-app-examples.git
   cd badapp
2. Build the project:
   ```bash
   mvn clean package
3. Verify that the build was successful and that the JAR file is located in the target/ directory.

