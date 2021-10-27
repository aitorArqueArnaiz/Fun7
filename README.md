# Fun7
Outfit7 Software Engineer Expertise Test: Services
VideoGame backend for fake video game

Steps to implement application :

    1. Create a Hello World basic server for JAVA web API
    2. Think on how to construct the application (DDD, TDD, CQRS, etc ...)
    3. Implement as best as possible an efficient code in order to achieve the higher velocity and profit of google cloud
    4. Unit testing
    5. Integration testing
    6. Manual testing
    7. Dockerize the application

Technologies used :

    - JAVA JDK : corretto-1.8.0_312
    - Glass Fish server 4.1.1
    - Developement UI : IntelliJ

Operating system :

    - Windows 10 with JAvA runtime, glassfish 4..1 and JAVA jdk 1.8

Steps to RUN the application (tested with Windows 10) :

    - Pre - Requirements
        1. JAVA JDK corretto-1.8.0_312 in your system
        2. JAVA Runtime installed
        3. GlassFish 4.1.1 (link : https://download.oracle.com/glassfish/4.1.1)
        4. Import the users data base into mySQl local DB (db folder in solution)
        4. Compile and Run the application
        5. Call the endpoints with curl, navigator, postman , ... your choice !

Rest API calls for multiplayer :

Not implemented :

How to NOT implement it :
 - Global variables
 - Data base persistence

how I would implement it :
    - Using Google Cloud equivalent like AWS dynamo Data Base in RAM memory (or also a Redis maybe)
      That way the number of api calls could be saved in cloud and check would be efficient.
