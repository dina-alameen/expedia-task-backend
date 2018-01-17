
*Heroku URL >>>>>>>>>>  https://expedia-task-dina-al-ameen.herokuapp.com/

*Travis URL >>>>>>>>>>> https://travis-ci.org/dina-alameen/expedia-task-backend/

*Back End Project Repository URL >>>>>>> https://github.com/dina-alameen/expedia-task-backend

*Front End Project Repository URL >>>>>>> https://github.com/dina-alameen/expedia-task-frontend 
_____________________________________________________________________________________

*environment requirements :
- JDK 1.8 or above; download link >>> http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

- Node js and npm : 
    - download Node js and npm using this URL 'https://nodejs.org/en/download/'
    - open the terminal and run the following command "npm install -g @angular/cli"
    
- Apache maven 3; download link >>> https://maven.apache.org/download.cgi

- Git version control system; download link >>> https://git-scm.com/downloads

______________________________________________________________________________________

*please follow these instructions when setting up the environment : 
 
 1) Clone the back-end project with the following command >> git clone https://github.com/dina-alameen/expedia-task-backend.git
 2) Navigate to the project directory and run the following command >> mvn clean install
 3) After finishing the maven build, run this command to start app.
    >>> java -jar target/dependency/webapp-runner.jar --port 8080 target/*.war
 4) Open browser window and hit the project URL
_____________________________________________________________________________________

 * if you are intrested in seing the original front end code please follow the steps below : 
 ) Clone the front-end project with the following command >> git clone https://github.com/dina-alameen/expedia-task-frontend.git
 5) Navigate to the front end project and run the following command >> npm install
 6) From the same directory open the command line and Run the following command >> ng build --prod --base-href="."
 7) Navigate inside the generated dist folder, copy its content and paste them to the back end project folder in tomcat webapps.
 8) start your tomcat.
 9) Open browser window and hit the project URL
