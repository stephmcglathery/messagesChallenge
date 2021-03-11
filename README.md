# Messages Challenge
This service solves the messages challenge 


## Getting Started
* Build project with:
  * mvn clean package
* Run project with:  
  * mvn spring-boot:run
* Hash Message
  * curl -X POST --header 'Content-Type: application/json' --header 'Accept: text/plain' -d 'foobar' 'http://ec2-34-220-91-231.us-west-2.compute.amazonaws.com:8080/demo/messages'
* Get Message
  * curl -X GET --header 'Accept: text/plain' 'http://ec2-34-220-91-231.us-west-2.compute.amazonaws.com:8080/demo/messages/c3ab8ff13720e8ad9047dd39466b3c8974e592c2fa383d4a3960714caef0c4f2'
* Swagger is available at http://ec2-34-220-91-231.us-west-2.compute.amazonaws.com:8080/swagger-ui.html 


## Built With
* [SpringBoot](https://spring.io/projects/spring-boot) 
* [Maven](https://maven.apache.org/)
