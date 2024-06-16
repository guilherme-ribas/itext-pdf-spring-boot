# PDF Generation Project with Java Spring Boot and iText

This project is a simple application developed with Java Spring Boot that uses the iText library to generate PDFs containing texts and tables.

## Features

- PDF file generation.
- Inclusion of texts in the PDF.
- Creation of tables in the PDF.

## Technologies Used

- **Java 17**: Programming language.
- **Spring Boot 2.5.4**: Framework for building Java applications.
- **iText 5**: Library for creating and manipulating PDF documents.

## Prerequisites

- JDK 17 or higher installed.
- Maven installed.

## How to Run the Project

1. Clone the repository to your local machine:
    ```bash
    git clone https://github.com/guilherme-ribas/itext-pdf-spring-boot.git
    ```
2. Navigate to the project directory:
    ```bash
    cd your-repository
    ```
3. Compile and run the project using Maven:
    ```bash
    mvn spring-boot:run
    ```
4. The application will be available at `http://localhost:8080`.

## Endpoints

### Generate PDF

- **URL**: `/api/pdf/generate`
- **Method**: `GET`
- **Description**: Generates a PDF with texts and a table and returns it as a response.


