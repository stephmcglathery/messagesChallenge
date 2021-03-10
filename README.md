# Messages Challenge
This service solves the messages challenge 


## Getting Started
* Build project with:
  * mvn clean package
* Run project with:  
  * mvn spring-boot:run
* Hash Message
  * curl -X POST --header 'Content-Type: application/json' --header 'Accept: text/plain' -d 'thisIsMyMessage' 'http://ec2-52-32-175-169.us-west-2.compute.amazonaws.com:8080/demo/messages'
* Get Message
  * curl -X GET --header 'Accept: text/plain' 'http://ec2-52-32-175-169.us-west-2.compute.amazonaws.com:8080/demo/messages/89718cb7dda02c65e31938807ce470cd0325ac86fe6153626e5f1026ad102259'
* Swagger is available at http://localhost:8080/swagger-ui.html 


## Built With
* [SpringBoot](https://spring.io/projects/spring-boot) 
* [Maven](https://maven.apache.org/)
