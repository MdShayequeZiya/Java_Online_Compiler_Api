# Java Online Compiler

This is a simple Java Online Compiler project built with Spring Boot. It allows users to submit Java code, which is then compiled and executed on the server.

## Features

- **Code Compilation:** Users can submit Java code snippets for compilation.
- **Code Execution:** Compiled code is executed, and the results are returned.
- **Error Handling:** Detailed error messages are provided in case of compilation or runtime errors.

## Getting Started

These instructions will help you set up and run the Java Online Compiler on your local machine for development and testing purposes.

### Prerequisites

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- Your favorite IDE (e.g., [IntelliJ IDEA](https://www.jetbrains.com/idea/download/))

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/java-online-compiler.git



2. The application will be accessible at http://localhost:8080.

3. Use a tool like Postman to send POST requests to http://localhost:8080/api/compiler/compile with a JSON payload containing the Java code.

  Example JSON payload:

  {
    "code": "public class TempFile { public static void main(String[] args) { System.out.println(\"Hello, World!\"); }}"
  }

4. The response will include the compilation result or the execution output.
