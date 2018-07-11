# Spring4WithRestAPI

* Spring 4 + Java Configuration + Maven + Rest-API, Example
* Template example for Spring 4 + with pure Java Configuration (no XML), using Maven build tool.
* Spring4, Integration without using the web.xml and Spring_Servlet.xml file. 
* By using WebMvcConfigurerAdapter class and WebApplicationInitializer interface to replace above files.

> **###1. Technologies**
* Spring 4.0.6.RELEASE
* Maven 3.1
```java
 /*Necessary dependency to add to use jackson for json exchange*/
    <!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
			<version>2.0.0</version>
		</dependency>
```
* used @RestController
* used @RequestMapping(value = "/get/students", method = RequestMethod.GET)
* used @ResponseBody
* used @PathVariable("studentName") 
* used ResponseEntity<String>
* used @ExceptionHandler(Exception.class)

> **###2. To Run this project locally**
* $ git clone https://github.com/AkashChauhanSoftEngi/Spring4Rest
* $ mvn tomcat7:run

> **###3.  Access** 
* http://localhost:8080/Spring4Rest
