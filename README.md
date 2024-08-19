<h1 align = "center"> Assembly Language Interpreter with Spring Boot</h1>

<p align="center">
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-3.0.5-brightgreen.svg" />
</a>
<a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.0.6-brightgreen.svg" />
</a>
  

</p>
   
This project is a simple Spring Boot application that interprets a custom assembly-like language with three operations:

1. **MV (Move Constant to Register)**: Moves a constant value into a register.
2. **ADD (Add Registers or Add Register and Constant)**: Adds two registers together or adds a register and a constant.
3. **SHOW (Show Register Value)**: Displays the value of a specified register.

The application provides a REST API that accepts commands in the custom language, executes them, and returns the result.


<br>

## Framework Used
* Spring Boot

---
<br>

## Dependencies
The following dependencies are required to run the project:

* Spring Web
<br>

## Language Used
* Java

## Data Flow

1. The user at client side sends a request to the application through the API endpoints.
2. The API receives the request and sends it to the appropriate controller method.
3. The controller method makes a call to the method in service class.
4. The method in service class builds logic and retrieves or modifies data from the database, which is in turn given to controller class
5. The controller method returns a response to the API.
6. The API sends the response back to the user.

---

<br>


## API End Points 

The following endpoints are available in the API:



```
http://localhost:8080/POST /api/assembly/execute


Request Body Example

MV REG1 2000
MV REG2 4000
ADD REG1 REG2
ADD REG1 600
SHOW REG1


