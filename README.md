# Demo for Spring Boot with H2 database and JPA

This is a simple spring boot with H2 Database and JPA project which contain CRUD function.

Kindly checkout the **demo** folder as Maven Project, after that follow the below steps to start the application

Below are the steps to launch the application:
1. Find com.example.demo.DemoApplication class and run as Java Application
2. Currently the application is using server port : 8090 (This can be modified in application.properties)
3. Open the link http://localhost:8090/h2 to access the H2 database, the credential are as following (Note: password is empty)
   ![alt text](https://github.com/shiangyoung/moneylion/blob/main/images/h2_credential.jpg?raw=true)
4. You shall see the database contain "FEATURE" table after login as following
   ![alt text](https://github.com/shiangyoung/moneylion/blob/main/images/h2_after_login.jpg?raw=true)
5. If you need some sample data, you may go to demo/src/main/resources/db/insert_sample.sql. Copy whole content and paste to H2 to execute.
6. In order to verify the sample data has been inserted, you may execute below query to verify the records
   ```
   SELECT * FROM FEATURE;
   ```
7. For testing the API, I have added swagger UI that allow to test on the function using different HTTP Request Method. You may go to the link http://localhost:8090/swagger-ui.html , it will brings you to swagger page
8. You may click on the "Feature" tab, and it will drop down all the implemented API, below is the sample of the available API in this application
   ![alt text](https://github.com/shiangyoung/moneylion/blob/main/images/swagger_page.jpg?raw=true)
