# InterCax Project 

Assumption made for assignment
- In order to keep database simple with minimal transactionality,
I've only used one table robot , which has state info stored as string.
  
- I could've done it via separating into 3 tables , once each for 
designed , tested & deployed , but then maintaining transactionality
  would have been a problem while altering. 
  
- E.g changing a designed robot to a tested bot.
  
- It can be done and if required , I'll need more time.

- I could only get limited time on Sunday , so have not performed 
unit tests & integrations tests , if required I'll need more time.
  
- I was a bit confused as to what was exact requirements of dashboard ,
for the rest api , so have just exposed openapi spec.
  
- url : http://localhost:8080/swagger-ui.html

- If a UI based custom dashboard is required , I'll need 2 days time , and some design to be able to build it.

- The database is hosted on render.com , it's a free tier database , so performance is not very well optimized.

- Resources folder contains table.sql file , which has scripts for creation of table & hibernate_sequence

