*environment requirements :
- JDK 1.8 or above; download link >>> http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

- Tomcat 8 server or any java EE server; download link >>> https://tomcat.apache.org/download-80.cgi

- Node js and npm : 
    - download Node js and npm using this URL 'https://nodejs.org/en/download/'
    - open the terminal and run the following command "npm install -g @angular/cli"
    
- Apache maven 3; download link >>> https://maven.apache.org/download.cgi

- Git version control system; download link >>> https://git-scm.com/downloads
______________________________________________________________________________________

*please follow these instructions when setting up the environment : 
 
 1) Clone the back-end project with the following command >> git clone https://github.com/dina-alameen/expedia-task-backend.git
 2) Navigate to the project directory and run the following command >> mvn clean install
 3) Extract the war file from the target folder and place it in your tomcat webapps folder 
 
 4) Clone the front-end project with the following command >> git clone https://github.com/dina-alameen/expedia-task-frontend.git
 5) Navigate to the front end project and run the following command >> npm install
 6) From the same directory open the command line and Run the following command >> ng build --prod --base-href="."
 7) Navigate inside the generated dist folder, copy its content and paste them to the back end folder in tomcat webapps.
 
 8) Start tomcat.
 9) Open browser window and hit the project URL
