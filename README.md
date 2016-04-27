# springrestsecuritycrud
I have used following technologies :

Spring Boot
Spring Rest
Spring Security
Spring Data JPA
maven
IDE: Eclipse/STS
OS: Ubuntu

and because it is a micro service you can use following commad for running it from the root directory of the project
mvn spring-boot:run

I have inlittilay populated some data in class : GotprintApplication

screen shots are also attached withh is email



Initially it will take some time to download jars and tomcat once that is done it will start the application on localhost port 8080

Once application is up and running you can use follwing curl commands from commnad promp to do crud operation


For Update:

curl -H "Content-Type: application/json" -X PUT -d '{
"id": 2,
"title": "My first note title update",
"note": "My First Note update",
"createTime": 1461737231000,
"lastUpdateTime": 1461737231000
}
' -u "a@a.a":a localhost:8080/update

For Read: 
curl -u "a@a.a":a localhost:8080/readnotes

For creating notes:

curl -H "Content-Type: application/json" -X POST -d '{
"id": 10,
"title": "My first created note title update",
"note": "My First created Note update",
"createTime": 1461737231000,
"lastUpdateTime": 1461737231000
}
' -u "a@a.a":a localhost:8080/createnotes


and finally for deleting :

curl -X -DELETE -u "a@a.a":a localhost:8080/delete/2

their are two user 
1. a@a.a
2. b@b.b
both are configured in springsecurity 


watch this project for integrating with Eureka and Apache zookeeper
