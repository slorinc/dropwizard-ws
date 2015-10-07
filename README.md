# dropwizard-ws


Dropwizard project using H2/Jersey/Jackson/Tests

Instructions to run the project
--

Uncompress or zip file and issue

    mvn clean install

in the extracted folder.

To create the database issue the following command in the project root (file separator depends on your OS!):

    java -jar target\dropwizard-ws-0.0.1-SNAPSHOT.jar db migrate configuration.yml

To start the project run one of the following commands in the project root:
  
    java -jar target\dropwizard-ws-0.0.1-SNAPSHOT.jar server configuration.yml

or

    mvn clean compile exec:java

Accessing the Web Services
--

Send a POST request to

    http://localhost:9090/application/{userId}

to load a profile with the following JSON body:

    {
        "id": 1
    }

There are three pre-created users with ids: 1,2 and 3.

To get a list of access history send a GET request to:
  
    http://localhost:9090/application/1/list

Logging
--

Log files are created in the ./log/ folder:
  
 - application.log is the application log
 - access.log is the HTTP request log
