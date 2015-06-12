# dropwizard-ws
Dropwizard project using H2/Jerdey/Jackson

Instructions to run the project

Uncompress or zip file and issue

  mvn clean install

in the extracted folder.
To create the database issue the following command in the project root:

  java -jar project-application\target\project-application-0.0.1-SNAPSHOT.jar db migrate project-application\configuration.yml

To start the project run one of the following commands in the project root:
  
  java -jar project-application\target\project-application-0.0.1-SNAPSHOT.jar server project-application\configuration.yml

  mvn clean compile exec:java -pl project-application

Accessing the Web Services

Send a POST request to

  http://localhost:9090/application/{userId}

to load a profile with the following JSON body:

  {
      "id": 1
  }

There are three pre-created users with ids: 1,2 and 3.

To get a list of access history send a GET request to:
  
  http://localhost:9090/application/1/list


