# Online Banking System

## Team: TeamWon
### Team Member:  Tian Lan, Jing Li, Cong Lin, Hao Fu, Lei Zhang.
## Architecture Diagram: 
<img src = "Diagrams/Architecture Diagram.jpg">

## EC2 Deployment Diagram
<img src = "Diagrams/EC2 Deployment Diagram.jpg">

## ECS Container Deployment Diagram
<img src = "Diagrams/ECS Container Deployment Diagram.jpg">


## Design Decision:
Our Design has implemented the Spring MVC Models, we have four different
components which are Model, Data Access Object, Service, and Controller. 
The model consists of all of the main entities in our systems. The Data
Access Object has the repositories for all the main entities, and they 
directly communicate with the database. The service component handles all 
the business logic of the system, and the controller take the request from the 
clients and maps it to the corresponding controller and then the controller 
pass the business logic to the service so that the service will process the 
input and execute the corresponding logic and return to the controllers. 


## Feature Set

1. Sign up and sign in new customers.
2. Create saving and checking account.
3. Close account.
4. Deposit money to account. 
4. Set up one time or recurring payment transactions.
5. Set up one time or recurring transfer transactions.
6. Admin transactions add fees to the customer account. 
