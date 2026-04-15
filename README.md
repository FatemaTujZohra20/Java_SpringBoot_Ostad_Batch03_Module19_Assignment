**Module 19 Assignment**

**Title: Build project and push**

# 🏛️ University Enrollment System

## 🚀 Project Overview

This project is a high-standard implementation of a `Spring Boot 3` application, designed to manage university membership
records. While the core academic requirement was the implementation of a `Person` class, this repository expands into a 
robust Layered Architecture to showcase enterprise-ready `configurations` and industry best practices.

Developed on a `Unix-based environment (Linux-Ubuntu)`, the project lifecycle is managed entirely through a 
`CLI-first` approach. By utilizing the `Spring Initializr` for scaffolding and the terminal for `build automation` and 
version control, the system ensures high environment consistency and repository integrity.


### **1. Project Initialization**

The project was scaffolded using the following configurations:

- **Project Name:** UniEnroll

- **Framework:** Spring Boot 3.5.13

- **Build Tool:** Maven (via Maven Wrapper)

- **Java Version:** 21

- **Dependencies:** Spring Web, Spring Boot DevTools

- **OS Environment:** Ubuntu (Linux)

### 🐙 **2. Git Initialization & First Push**

   Following the assignment requirements, the project was initialized locally and linked to the remote GitHub 
   repository. This was launched by navigating to the `UniEnroll` directory and executing `git init` to establish a local
   repository. After staging the auto-generated `Spring Initializr` files with `git add .`, the first `snapshot` was recorded 
   using the required `git commit -m "Init"` message. Finally, the local repository was linked to the remote GitHub server 
   via `git remote add origin`, and the codebase was pushed to the `main branch` to establish the cloud-based version history.

#### **Commands used in the terminal:**

```Bash
# Navigate to the project directory
cd UniEnroll

# Initialize the local repository
git init

# Stage all auto-generated files from Spring Initializr
git add .

# Create the initial snapshot with the required message
git commit -m "Init"

# Set the default branch to main
git branch -M main

# Link the local repo to GitHub
git remote add origin git@github.com:FatemaTujZohra20/Java_SpringBoot_Ostad_Batch03_Module19_Assignment.git

git push -u origin main
```

## **🖥️ CLI-Driven Workflow**

Adhering to modern DevOps standards, all operations—from initial scaffolding to the final build—are executed via 
the terminal. This approach guarantees that the `Fat JAR artifact`, specifically `UniEnroll-0.0.1-SNAPSHOT.jar`, 
is produced in a clean, reproducible environment. This encapsulates the entire application—including 
its dependencies and the `embedded Tomcat server`—embodying the `"Write Once, Run Anywhere" (WORA)` philosophy.


## 🏗️ Build, Package, and Execution

The flow from Build to Run the application in short:
- Make wrapper executable: `chmod +x mvnw`

- Clean and Package: `./mvnw clean package`

- Run the Application: `java -jar target/UniEnroll-0.0.1-SNAPSHOT.jar`

#### **Explanation:**

The project utilizes the Maven Wrapper (mvnw) to ensure environment consistency. Once the build pipeline is complete,
the application is ready for deployment as a single, portable, executable unit.

### 1. Maven Lifecycle & Development Commands

- `./mvnw clean`: **The Fresh Start.** Deletes the `target/` directory to remove stale bytecode and ensure the build
  starts from a pristine state.
- `./mvnw spring-boot:run`: **Rapid Development.** Compiles the code and launches the Spring Context directly.
  This is the preferred method for testing changes in real-time without manual packaging.
- `./mvnw package`: **The Pipeline.** Executes the full `build lifecycle (Validate → Compile → Test)`. Upon success,
  it bundles the application into a self-contained **Fat JAR (Java Archive)** `UniEnroll-0.0.1-SNAPSHOT.jar` located
  in the `target/` folder.

### 🏃 Running the Application (From Project Root - Production Style)

We always need to make wrapper executable before interacting by using the following command:
```bash
chmod +x mvnw
```
The Root Directory is the main folder that contains the pom.xml file and while working with `maven wrapper - mvnw`.
All build commands should be executed from the project root directory where the pom.xml resides
to ensure proper dependency resolution.

#### **💡 Why the Root?**

The `Maven Wrapper (mvnw)` needs to read the `pom.xml` to understand the project's dependencies
(like Spring Boot 3 and Spring Security 6, etc) and the packaging rules. If we run it inside a subfolder like
`src/main/java`, the terminal will give an error saying `"command not found"` or `"cannot find pom.xml"`.

After running `./mvnw package`, we can deploy the application anywhere that has Java installed.
This bypasses Maven and runs the compiled artifact directly.

Now after the build is successful, we can run the specific artifact to launch the generated artifact from the terminal:

```bash
# Execute the self-contained Spring Boot JAR
java -jar target/UniEnroll-0.0.1-SNAPSHOT.jar
```

## ⚙ The Git Commit Workflow

**(Commit messages flow for code snippets)**

I followed the **Conventional Commits** standard to maintain a clear, readable project history.

Examples of Git commits I did:

For `Person` model:

```bash
# From root directory --> go to the following directory by writing command in the terminal:
cd src/main/java/com/chronicle/uni_enroll/UniEnroll/

# create the "model" package and create the class "Person" inside the package and 
# then write the encapsulation and serialization part and commit it to git -->

# firstly, go inside the "model" package:
cd model/
# Secondly, add the "Person" class from this place to git using the following command: 
git add Person.java

# Thirdly, commit it to git with a commit message in the following way:
git commit -m "feat: implement encapsulated abstract Person model with @Serial versioning"

# Fourthly, Go back to the root directory where the pom.xml exists, 
# because we will find the maven wrapper (mvnw) script there by following command:
cd ../../../../../../../../

# To check if the pom.xml exists in that directory, run the following command to know 
# if we are in the right directory because we need to be in the root directory:
ls 
# It will show the pom.xml file exists if it is the root directory.

# Fifthly, now we need to write the following command in the terminal to see the "Build" result:
./mvnw clean compile
# If the <BUILD SUCCESS> result comes then the result is okay and then we can push it to the git:
git push
```


## 🏗️ Architectural Rationale: Why Layers?

To exceed the basic requirements, I implemented a Three-Tiered Architecture. In a `professional environment`,
a domain class like `Person` does not exist in isolation; it requires a `surrounding ecosystem` to handle requests,
process logic, and manage state.

### **1. Separation of Concerns (SoC)**

By decoupling the application into Controller, Service, and Model layers, we ensure that each component
has a `"Single Responsibility"`:

- The Model defines what the data is.
- The Service defines how the data is processed (Business Logic).
- The Controller defines how the data is exposed to the world (Web/API).

This separation makes the project modular. For example, if we decided to change from a REST API to a GraphQL API,
we would only need to modify the Controller layer—the Service and Model logic would remain untouched.

### **2. Scalability and Maintenance**

A flat project structure becomes unmanageable as it grows. Following the Standard `Maven/Spring Directory Convention`
ensures that as more entities (like Course, Department, or Enrollment) are added, the project remains organized.
This structure is the `"industry language"` of Java developers, making it easy for other engineers to navigate
the codebase.

### **3. Inversion of Control (IoC) & Dependency Injection**

By using Spring-managed layers `(@Service, @RestController)`, the application leverages `IoC`.
Instead of manually instantiating objects `(e.g., new UniversityService())`, the Spring Container manages
the lifecycle of these components. This makes the application loosely coupled and significantly easier to
Unit Test using frameworks like `Mockito`.

### **4. Defensive API Design**

Implementing a Service layer allows for a `"buffer zone"`. In this project, the Service layer returns
`Unmodifiable Lists`. This is a critical security and integrity pattern; it prevents the Web layer from
accidentally or maliciously modifying the internal data store without going through proper business validation.

### **📂 Detailed Layer Responsibilities**

| Layer            | Responsibility                                                                                                                                               | Key Annotations / Patterns                         |
|------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------|
| Web (Controller) | Acts as the entry point for HTTP traffic. Handles request mapping, consumes JSON input, and produces standardized API responses.                             | @RestController, @GetMapping                       |
| Service          | The "Brain" of the application. Orchestrates business logic, manages internal state, seeds initial data, and enforces security through defensive API design. | @Service, Singleton Pattern, Defensive Programming |
| Model (Domain)   | Defines the blueprint for data. Focuses on strong typing, inheritance hierarchies, and protecting data integrity through encapsulation.                      | abstract, extends, Serializable, @Serial           |


### **Conclusion:** 
- Developed with a focus on modularity, clean code, and enterprise-grade Spring Boot patterns
- Submitted as part of the Module 19 Assignment — Demonstrating proficiency in Maven lifecycles and Git version control.


