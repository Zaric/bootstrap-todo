# A Simple Todo app in Spring, JPA, JSP and Twitter Bootstrap

This is a simple web application that uses Spring MVC and Hibernate with Twitter Bootstrap. The code is a CRUD page that manipulates records for a single model object.

## Running the application locally

First build with:

    $mvn clean install

Then run it with:

    $java -jar target/dependency/webapp-runner.jar target/*.war

The application will be running at:

    http://localhost:8080/welcome	

Best way to run inside eclipse is webapp-runner (https://github.com/jsimone/webapp-runner).

The application needs a local Postgres installation. Heroku deployment is in progress.
