# Store Sales Application

## Screenshots

![Screenshot 2024-07-31 151056](https://github.com/user-attachments/assets/47e5e6b3-15a1-4dee-a810-71b15d458a1b)

![Screenshot 2024-07-31 151059](https://github.com/user-attachments/assets/d3f4c51c-10a3-4b21-af45-598cdda7eb7f)

![Screenshot 2024-07-31 151040](https://github.com/user-attachments/assets/4bd550b6-c4ab-4fcb-a5d3-8c53c2e93bc5)

![Screenshot 2024-07-31 151045](https://github.com/user-attachments/assets/3fe927b8-7549-4afa-a122-5e5b691705f6)

![Screenshot 2024-07-31 150643](https://github.com/user-attachments/assets/e51abf35-f789-44b3-88d3-f3e78b16f297)

![Screenshot 2024-07-31 151126](https://github.com/user-attachments/assets/40001a4a-9da6-4c89-9bb5-a78317243026)

## Overview

The Store Sales Application is a web-based platform for managing and visualizing sales data. It allows users to insert new sales records, view and filter existing sales records, and visualize sales data using charts. The application is built using HTML, CSS, JavaScript for the frontend, and Spring Boot for the backend.

## Features

- **Insert Sales Data:** Allows users to insert new sales records with details like item name, quantity, price, date, customer information, payment method, discount, and product category.
- **View Sales Data:** Displays a list of all sales records, which can be filtered by date range.
- **Sales Visualization:** Provides a bar chart to visualize total sales over time.

## Technologies Used

### Frontend

- HTML
- CSS
- JavaScript
- Chart.js

### Backend

- Spring Boot
- JPA (Java Persistence API)
- Hibernate
- RESTful Web Services

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Node.js and npm (for frontend dependencies)
- Spring Boot
- MySQL or any other preferred database

### Installation

1. **Clone the Repository:**
    ```bash
    git clone https://github.com/your-username/store-sales-application.git
    cd store-sales-application
    ```

2. **Backend Setup:**

    - Update the database configuration in `application.properties` located in `src/main/resources`:
        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/your-database
        spring.datasource.username=your-username
        spring.datasource.password=your-password
        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.show-sql=true
        ```
    - Run the Spring Boot application:
        ```bash
        ./mvnw spring-boot:run
        ```

3. **Frontend Setup:**

    - Navigate to the `frontend` directory:
        ```bash
        cd frontend
        ```
    - If you have a package.json file for frontend dependencies, install them using npm:
        ```bash
        npm install
        ```

4. **Running the Application:**

    - Start the Spring Boot application if not already running:
        ```bash
        ./mvnw spring-boot:run
        ```
    - Open `index.html` in your web browser to view the application.

## Project Structure

- `src/main/java/com/example/store`: Contains the Java source files.
    - `config`: Contains configuration files like CORS configuration.
    - `controller`: Contains RESTful web controllers.
    - `entity`: Contains entity classes.
    - `repo`: Contains repository interfaces.
    - `service`: Contains service classes for business logic.

- `src/main/resources`: Contains static resources and configuration files.
    - `static`: Contains HTML, CSS, and JavaScript files.
    - `application.properties`: Contains application configurations.

- `src/main/resources/static/css`: Contains the CSS styles.
- `src/main/resources/static/js`: Contains JavaScript files.

## Usage

1. **Insert Sales Data:**
   - Navigate to the "Insert Sales" page.
   - Fill in the sales form and click "Insert Sale".

2. **View Sales Data:**
   - Navigate to the "View Sales" page.
   - Use the date filters to filter sales records by date.
   - View the sales data in the table and bar chart.

## API Endpoints

- **Insert Sale:**
    - URL: `http://127.0.0.1:8080/api/sales/insert_sales`
    - Method: `POST`
    - Payload: JSON object containing sale details.

- **Get All Sales:**
    - URL: `http://127.0.0.1:8080/api/sales/all`
    - Method: `GET`
    - Query Params: `fromDate` and `toDate` (optional).

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Open a pull request.

## Contact

For any inquiries, please contact [abhisheknair0925@example.com](mailto:abhsiehknair0925@example.com) or +91 75928 61101.
