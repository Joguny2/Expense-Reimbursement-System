# Expense-Reimbursement-System

## Overview
The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement

## Tools and Technologies
- Java 8
- Javalin Framework
- Gradle
- MongoDB
- ReactJS
- Git 
- Log4J
- JUnit

## Features
- An Employee can login
- An Employee can view the Employee Homepage
- An Employee can logout
- An Employee can submit a reimbursement request
- An Employee can view their pending reimbursement requests
- An Employee can view their resolved reimbursement requests
- An Employee can view their information
- An Employee can update their information
- An Employee receives an email when one of their reimbursement requests is resolved

- A Manager can login
- A Manager can view the Manager Homepage
- A Manager can logout
- A Manager can approve/deny pending reimbursement requests
- A Manager can view all pending requests from all employees
- A Manager can view all resolved requests from all employees and see which manager resolved it
- A Manager can view all Employees
- A Manager can view reimbursement requests from a single Employee
- A Manager can register an Employee, which sends the Employee an email with their username and temp password 


## Getting Started

To get this application setup:
1. Must have nodejs install.
2. Must have Java 8 runtime environment installed.
3. Must have MongoDB installed.

If the requirements are met, go ahead and clone the repo by using the following command:
```git clone https://github.com/Joguny2/Expense-Reimbursement-System```

Once the repository is cloned you will need to make sure the localhost:8080 and mongodb is running.
The functionalities of the frontend will not work if http://localhost:3000/ is not running. THe backend is running at port 8080.

## To run frontend program with npm
```npm install``` 
```npm start``` 

## To run the backend
```gradle clean```
```gralde build```
Run the main method in ERSWebApplication.java
