# Online Banking System

## Team: TeamWon
### Team Member:  Tian Lan, Jing Li, Cong Lin, Hao Fu, Lei Zhang.

## Tian Lan Project Journal
## Week 1 (11/4 - 11/10)
#### Task I work on:
I did some research on Spring MVC Framework and configure the the environment on
IntellJ IDEA. 

#### Planning to work:
I plan to do some research on the database, and I am currently thinking about NoSql
Mango DB database.

#### Task are blocked waiting on another team member:
No

#### XP Core Value Journal
##### Communication
Our team held a meeting during the first week, and I talk with all the teammates 
about my ideas to implement the project. They all believe that Spring is a great framework for our 
project and MangoDB database will be a good fit to store our date.

## Week 2 (11/11 - 11/18)
#### Task I work on:
I found out that MangoDB NoSql database is not a good option for our project, because the entities in 
our classes are closely related to each other. Therefore, the Mysql relational database would be a better 
options. I wrote the mysql database script and imported it to Spring MVC framework and they works very well.

#### Planning to work：
I plan to work on the sign in and sign up API next week.

#### Task are blocked waiting on another team member:
No 


#### XP Core Value Journal
##### Simplicity
The MVC framework is a very classic software design pattern. It separate each component of 
the system clearly and are loosely coupled. It is very easy to maintain and update. Most importantly,
It is a very simple pattern that can potentially eliminate many unnecessary and tedious code. 

## Week 3 (11/18 to 11/24)
#### Task I work on:
I work on the sign in and sign up API this week by creating a current customer filed in
CustomerService classes. 

#### Planning to work:
I plan to work on setting up one time or recurring payment API. 

#### Task are blocked waiting on another team member:
No

#### XP Core Value Journal
#### Courage
After we worked with MangoDB for our project, we realized that NoSql database is not a good fit 
to our project context, because the entities in our project are closely related. MySQl relational database
could be a great choice for our database. 


## Week4 (11/25 - 12/1)
#### Task I work on:
I work on setting up one time or recurring payment API. 

#### Planning to work：
I plan to deploy the project on AWS EKS. 

#### Task are blocked waiting on another team member:
No

#### XP Core Value Journal
##### Respect
In our team. we do expect each other even if we hold different point of views 
in API design and implementation. We exchange ideas and come up with a reasonable 
solution to resolve our difference. 


## Week5 (12/2 - 12/7)
#### Task I work on:
I work on the deploying the project on AWS deploy. 
#### Planning to work：
No, the project is completed 

#### Task are blocked waiting on another team member:
No

#### XP Core Value Journal
##### Feedback
In the development phase of our project, we are consistently receive the 
feedback from our testing result and professors recommendations. Since our
goal is to develop the best project that satisfy all the requirements. 

## Jing Li Project Journal

# Week1

## Finished this week:
    1. Had a meeting all team members to discuss the project in a high level picture
    2. Figured out what needs to be done
    3. Distributed jobs among teamates
    4. Installed developer tools and set up environment
    
## Plan for next week:
    1. Learn how to design and implement RESTful API
    2. Implement user login
    
### Obstacle:
    1. Not very familiar with the tools 
    
###  XP Core Values - Communication
     Our team communicate with each other frequently to make sure everyone is on the same page before
     we move on. We held meetings in person, via zoom and other chatting apps.

# Week2 

## Finished this week:
    1. Downloaded the starter code created by Tim
    2. Configure it to run successfully locally
    
## Plan for next week:
    1. Learn Spring Security
    2. Implement user login with hashed password
    
## Obstacles:
    1. No
    
###  XP Core Values - Simplicity
     We try out best to make our team as simple as possible. We have only 3 roles in Scrum (Team, ScrumMaster and Product Owner) on the team. Here we assume the product owner is the project spec.

# Week3

## Finished this week:
    Learn to implement REST Authentication with Spring Security and MongoDB
    
## Plan for next week:
    Integrate what I learned this week to our team project
    
## Obstacle:
    No
    
###  XP Core Values - Feedback
    Every week, our team holds a meeting to hear feedback. We understand that waiting until the end of sprint is too long to solicit feedbacks. Software development is an embodiment of the butterfly effect, where, especially early in the development process, minor changes can result in large differences downstream.

# Week4 - Jing Li

## Finished this week:
   We found MongoDB is not a great option for out project. Decided to use Mysql instead.
   
## Plan for next week:
  Implementing "View and search Transactions - for credits/debits/checks/fees - up to  last 18 months"
  
## Obstacls:
    No
    
###  XP Core Values - Courage
   During week3 we realized that MongoDB is not that a good choice for our application. We had the courage to make quite a change to our design.

# Week5 - Jing Li

## Finished this week: 
   Implemented "View and search Transactions - for credits/debits/checks/fees - up to  last 18 months"
     
## Plan for next week:
    Deploy out project to AWS.
    
## Obstacls:
    1. Not very familiar with the tools
    
### XP core values - Respect
   We surely respect everyone's opinion on the team. We think the collective wisdom is greater than an individual. We held meetings to make sure everyong's voice is heard.

## Lei Zhang Project Journal

# Week1 
11/04/2019 - 11/10/2019

Task I work on: Get familiar with Postman, MongoDB Compass and IntelliJ IDEA.

Planning to work: Implement the function of finding a customer.

Task are blocked waiting on another team member: No

XP Core Value Journal: communication
Our team held a zoom meeting at the first week. We all raised our ideas, and we all believe that Spring is a great framework for our project and we wanted to tyr MangoDB database to store our data.



# Week2
11/11/2019 - 11/17/2019

Task I work on: Know about what is JSON. Implement the function of finding a customer.

Planning to work: Add a Bank_Transaction table in mySQL. Create Transaction class in Model.

Task are blocked waiting on another team member: No

XP Core Value Journal: Simplicity
The MVC framework is a very classic software design pattern. It separate each component of the system clearly.



# Week3
11/18/2019 - 11/25/2019

Task I work on: Add a Bank_Transaction table in mySQL. Create Transaction class in Model.

Planning to work: Add Transaction Repository in DataAccessObject. Implement AdminService in Service. AdminService allows Admin to add transactions manually.

Task are blocked waiting on another team member: No

XP Core Value Journal: Courage
After we worked with MangoDB for our project, we realized that it is not a good fit to our project context, because the entities in our project are closely related. So we changed to MySQL.

# Week4
11/26/2019 - 12/01/2019

Task I work on: Add Transaction Repository in DataAccessObject. Implement AdminService in Service. AdminService allows Admin to add transactions manually.

Planning to work:Implement AdminController. The controller provides the API to Admins. Use Postman to test the API.

Task are blocked waiting on another team member: No

XP Core Value Journal: Respect 
We hold a meeting on Thursday in library, and we talked about confusions we met during the past week. Everybody talked about his or her own idea, and all other people listened carefully, even when our thoughts conflicked, we showed respect to each other.



# Week5
12/02/2019 - 12/07/2019

Task I work on: Implement AdminController. The controller provides the API to Admins. Use Postman to test the API.

Planning to work: none

Task are blocked waiting on another team member: No

XP Core Value Journal: Feedback
We hold last meeting before DEMO day, and shared feedback of each other's work together.

## Cong Lin Project Journal
## Week 1 (11/4 - 11/10)
#### Task I work on:

Understand the project requirements

#### Planning to work：

Assign tasks and make plans


#### Task are blocked waiting on another team member:

No

#### XP Core Value Journal
Communication
During this week, the team members carefully understood the project requirements 
and communicated with each other about the project contents. 
Effective communication is crucial in Week 1.




## Week 2 (11/11 - 11/18)
#### Task I work on:

Determine project plan and assign tasks

#### Planning to work：

Familiar with relevant tools

#### Task are blocked waiting on another team member:

No

#### XP Core Value Journal
Communication
During this week, team members communicated with each other about the 
content of the project, and then assigned tasks within the group.
Effective communication is crucial in Week 2.




## Week 3 (11/18 to 11/24)
#### Task I work on:

Familiar with SpringBoot and Postman

#### Planning to work:

Start working on the Account API

#### Task are blocked waiting on another team member:

No

#### XP Core Value Journal
Feedback
During the week, the team members learned the technical tools and 
reported the problems in the meeting.
Effective feedback is crucial in Week 3.




## Week4 (11/25 - 12/1)
#### Task I work on:

Working on the Account API


#### Planning to work：

Review projects with other team members


#### Task are blocked waiting on another team member:

No

#### XP Core Value Journal
Feedback
During this week, the team members completed their assigned 
tasks and reported the problems in the meeting.
Effective feedback is crucial in Week 4.






## Week5 (12/2 - 12/7)
#### Task I work on:
Review projects with other team members


#### Planning to work：
Prepare for the presentation

#### Task are blocked waiting on another team member:
No

#### XP Core Value Journal
Courage
During this week, the team members assigned the tasks of presentation 
to prepare for the presentation and the final work of the project.
Effective courage is crucial in Week 5.


## Hao Fu Project Journal 
## Week 1 (11/4 - 11/10)
#### Task I work on:
Discussed the split task I should work and did a little research how to 
implement the api.


#### Planning to work：
Plan to work on the api



#### Task are blocked waiting on another team member:
No

#### XP Core Value Journal
We had the meeting in the first week and talked about the split task and ideas about 
how to implement it

## Week 2 (11/11 - 11/18)
#### Task I work on:
Understand the api functionality and discuss with teammates and work on transfer controller

#### Planning to work：
Start to implement other part of api 

#### Task are blocked waiting on another team member:
No

#### XP Core Value Journal
I have more understanding about the Spring framework on controller and service layer.

## Week 3 (11/18 to 11/24)
#### Task I work on:
Finish the service part of api

#### Planning to work:
test the api on postman

#### Task are blocked waiting on another team member:
No

#### XP Core Value Journal
Service layer is the most important part of the api functionality,
it enables the logic to work properly. 

## Week4 (11/25 - 12/1)
#### Task I work on:
Finish the api functionality

#### Planning to work：
Plan to integrate with teammates api  

#### Task are blocked waiting on another team member:
No

#### XP Core Value Journal
I finished the implementation of the transfer API where everything goes well. 

## Week5 (12/2 - 12/7)
#### Task I work on:
Finish the own part of project 

#### Planning to work：
Prepare fo the presentation

#### Task are blocked waiting on another team member:
No

#### XP Core Value Journal
We worked on the team presentation and everything that needs to be done to make sure the presentation goes well. 













