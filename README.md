# 📦 Inventory System - BackEnd

This repository contains the source code for the **Inventory System** BackEnd, developed with **Java**, **Spring Boot**, and **MySQL** for efficient data management.

## 🛠️ Technologies Used

- **Java**: Primary language for the backend development.
- **Spring Boot**: Framework for building Java-based web applications.
- **MySQL**: Relational database for storing inventory data.

## 🚀 Installation and Setup

Follow these steps to configure and run the project locally:

1. Clone this repository:
   ```bash
   git clone https://github.com/javier04s/InventorySystem-Back.git
   ```
   
2. Navigate to the project directory:
   ```bash
   cd InventorySystem-Back
   ```

3. Install the required dependencies:
   ```bash
   mvn clean install
   ```
   
4. Configure your database settings in the `application.properties` file:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/inventory_db?createDatabaseIfNotExist=true
   spring.datasource.username=your-username
   spring.datasource.password=your-password
   ```

5. Run the application:
   ```bash
   mvn spring-boot:run
   ```

6. The API will be running at:
   ```arduino
   http://localhost:8080
   ```

## ⚠️ Important

To fully operate the Inventory System, you need to set up the **FrontEnd**. The FrontEnd is developed using **Angular** and is hosted in a separate repository. Please follow the instructions in the FrontEnd repository to complete the setup:  
[Inventory System - FrontEnd](https://github.com/javier04s/InventorySystem-Front)

## 📜 License

This project is licensed under the MIT License.
