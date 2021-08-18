
    Spring Framework
        - Core
        - Spring Boot
        - REST API using spring webmvc
        - Spring Data
            - MYSQL DB
            - Mongo DB
        - Documentation
        - Logging
        - Testing 
        - Microservices
            - Spring Cloud
        
   Containerization
        - Docker
   CI - using Gitlab
       - overview of Jenkins
       
       
 =================================================================
 
 https://docs.spring.io/spring-framework/docs/current/reference/html/core.html
 
 
 
 Multilayered
 ------------
    - Presentation layer
 
    - Business/Service Layer
   
    - Data Access Layer
        - DAO classes (Data Access objects)
            Database
 
 
 
 
 Dependency
 
    LoginService
    
        authenticateUser(credential) {
            UserDao dao = new ......
            dao.connectToDB
            dao.getUserCredentials
            match the credentials and generate JWT
        
        } 
            
        
        
    UserDao
        userid, pass, url
        - connectToDB
        - getUserCredentials(id)
        
        
        
        
  How does a class gets its dependency
    - Create dependency objects using new
    - Service locator pattern
        Lookup for dependencies
        
    - Some other framework/program provides/injects the dependencies
 
       Dependency Injection
    
       Inversion of Control
       
       
       
       
  Spring IOC Container
   ----------------------
   
   - responsible for creating and maintaining lifecycle of objects needed by the application
   - Beans
   
   
   BeanFactory
        Core container with DI
 
   ApplicationContext
        Built over BeanFactory with extra features( Internationalization, ....) and more suitable for enterprise application
        
           - ClassPathXMLApplicationContext
           - FileSystemXMLApplicationContext
           - AnnotationConfigApplicationContext
           - WebApplicationContext
           ....
   
   Configuration Metadata
   ----------------------
    - XML based
    - Annotation based
    - Java Based
 
 
 
   Dependency Injection
   --------------------
   
   - Constructor based injection
   - Setter based injection
   
   - Field Injection
   
 
   Scope of beans
   --------------
   singleton 
    - default scope
    - only one object is created
    - Created when container starts
    
    lazy-init=true  attribute will make container not to create the bean at startup
   
   prototype
    - New object is created everytime your app asks for it
    - created only when required
    
    
   scopes available in web aware application contexts 
   --------------------------------------------------
   request, session, application.
   
   
   
   Lifecycle callbacks
   -------------------
   init-method, destroy-method
   InitializingBean, DisposableBean
   



   Autowiring
   ----------
    - automatically find dependencies and inject them in to the objects   
   
   
   byName
    - find a bean with the same name as the property and inject it
   byType
        - find a bean of that type and inject it
        
        Setter based - byName and byType
   
   constructor
   
   
   injecting collections
   ---------------------
   
   <list>
   <set>
   <map>
   <props>
   
   
   
   
   Exercise
   --------
   
   Create a maven project with spring context dependency
   
   - create interface GreetingMessage with method getMessage()
          
        with multiple implementations -- HelloGreetingMessage, MorningGreetingMessage .....
        
   - Create a class Greeter having a GreetingMessage Dependency
       - have a method displayMessage
       
       
   Use XML Based Configuration for bean creation and dependency injection
   - try out setter based. constructor based injection and autowiring
   
   
   
   Annotation Based
   ----------------
   
   Stereotype annotations
   - over a class for creating beans
        - @Component (generic)
            - @Service
            - @Repository
            - @Controller
            - @RestController
            
            
            
  @Autowired
    - put over a constructor, setter or a property 
   
   
  @Required
  
  
  @Value - to assign values to the properties
  @PropertySource - reading properties from a file
  @Scope
  @Primary
  
  @Qualifier - to inject a specific bean
  
  @PostConstruct/@PreDestroy - initialization and destruction
   
   
   
   Java Based Configuration
   -------------------------
   
   A java class represents the configuration
    - a config class is created containing the configuration of beans to be created and injected in place of an xml
   
   @Configuration
        - over the class containing configuration
        
   
   @Bean 
        - over methods to create beans
        - the method should return the required bean
   
   
   
   
   
  Web Services
  ------------
  
  functionalities provided over the network typically internet for consumption by applications/programs
  
  
  SOAP Based
  
        - Simple object access protocol
        - specification
            - XML form
                envelope
                headers
                body
    
  
  
  
  
  REST Web Services
  
  REST principles
    - Representational state transfer
    
    
    - Resource 
        - any info,  data, object, Database
    
    - every resource shoud be identifiable with a unique URI
           /api/trains
            /api/station
            
    - Standard operations over this resource
        GET - getting info
        POST - adding 
        PUT - updating/replacing
        DELETE - deleting
    
    - exchange representations in any format decided by the provider and consumer
            - json, xml, plain text
            {
                "trno": 101,
                "name": "kk",
                links: [
                          api/trains/101
                       ]
            
            }
                
            
    - Messages between consumer/provider should also contain metadata about the request/response
        - type of content  - Content-type
        - status
        - date
        
        
        HTTP header
        accept, content-type
        
        
    - Cacheable and stateless
    
    - HATEOS
        - Hypermedia as the Engine of Application State
        
        
        
        
    Richardson Maturity Model
        - level 0
        - level 1,2 and 3
     
     
     
   MyContactAPP
   ------------
   Resources
    - Contacts
    
   URI
      - api/v1/contacts
      
   Operations
        GET     api/v1/contacts  all contacts
        POST    api/v1/contacts
        DELETE  api/v1/contacts
        
        GET     api/v1/contacts/{contactId}      - api/v1/contacts/1 , api/v1/contacts/2
        GET     api/v1/contacts?catg=friends
        
   Representation of the resource
   json - accept and send json req and responses
   
   
   Spring webflux
   --------------
   - Reactive paradigm
    - Non blocking IO's
   
   
   
   Spring webmvc
   -------------
   
   - Spring MVC is built over Servlet API
   
   
   
    Front Controller - Dispatcher Servlet
    
    Handler Mapping 
    - Maintains a registry of the url path and the handler(Method inside a Controller class) 
    which processes that URL
   

   
   Spring Boot
   -----------
   Help you quickly create a production ready Web project 
   
    - Lot of configuration are automatically done
    - Opinionated approach - starter-dependencies - convention over configuration
    - Autoconfiguration
        - based on the dependencies, jar files (MySQL Connector, Jackson json)
    - Embedded Servers
        - Tomcat, Netty, Undertow
    - Automatic Health indicators. metric for the application
    
    
    https://start.spring.io/ 
    Initializer to create spring boot projects
    
    
    
       Http GET    ----> /api/info ---->        apiInfo() 
       
       
       
   
   
   Steps to create a Spring Boot REST API project
   ----------------------------------------------
   1. Create a project from Sprint Initializer - dependency - spring web
   2. Download the project and open in IntelliJ
   
   3. Optionaly can configure port number in application.properties
   
   4. Create a Class and make it a RestController in a controller package.
   
   
   5. create handler methods in the controller class and provide appropriate mapping using webmvc annotations
        @GetMapping("endpoint path/url") , @PostMapping ....... 
   
   
   
   
   ContactsAPI
   -----------
   
   /contacts                GET     200
   /contacts                POST    201     ResponseEntity
   /contacts/{id}           DELETE  204     @PathVariable  -- /contacts/101 /contacts/102 /contacts/103 
   /contacts                PUT     200
   /contacts/{id}           GET     200
   /contact?category=xxxx   GET 200     @RequestParam
   
   Error Messages
   ----------------
   Handling Exception in a Rest API
   
   When a Contact is not found
    404 - Contact Not found
    
   When contact Already exists
    409 - Contact already exists
    
    
    Global Exception handler class
        @ControllerAdvice   
        
        + for each exception
            method annotated with @ExceptionHandler
   
   
   JDBC
   ----
   java database connectivity api
   
   - lot of repetitive code(boilerplate code)
   - db drivers - software for connecting and querying the db 
   
   - load the driver
   - create a connection
   - create object where you can put the query - Statement
   - assign values to the columns
   - Execute the query 
   - get the results through a object call resultset
   - process this resultset to get the data from the columns
   - close the connection
   - handle any exception
   
   
   
   
   Spring Data JPA (Java Persistence API)
   --------------------------------------
   
   - create a connection with DB
   - provide method for querying
   - provides annotations for mapping objects with tables
   - provide a separate query language independent of DB vendor
   
   JPA - Hibernate, Toplink , Ibatis 
   
   ORM Framework (Object relational mapping)
   
   Customer Class
        id,name, email
   
   Customer object = new ...
   
   
   regd_Customer
        cust_id, cust_name, cust_email
   
   ORM(Hibernate)
   ----
   - Provide a way to configure and do the mapping
   - map the table with the class and the columns with the class properties
   - Map association between tables and classes
   - map the class property as a primary key in the table
   
   - run the queries in an OO way
    - provides methods using which CRUD can be performed
   
        save(obj), delete(obj)
   - JPQL (Java Persistence Query Language)
    - independent of the actual database Query language
    - convert these JPQL queries in to actual SQL queries based on dialect
   
   - Based on the mapping, you can ask the framework 
            - to create the tables
            - update the tables 
            - validate the existing tables
    
   - allows you to do association mapping between classes with one to one, one to many, many to many 
   
   - abstract the repetitive tasks like creating conection, closing connection, processsing result and converting in to object .......
   
   
   Hibernate Architecture
   -----------------------
   
   SessionFactory - creates the session, has the mapping of all the tables and classes
   Session - represents the connection
   Transaction - to manage Db transactions/ multiple queries in a LUW/ 
   Configuration - contains all the config info of mappings
   Query        - create queries and using JPQL
   Criteria     - writing queries in a OO way
   
   
   Data Jpa : https://docs.spring.io/spring-data/jpa/docs/2.5.1/reference/html/#reference
   MySQl URL: https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-reference-driver-name.html
   Application properties reference:
    https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#application-properties.data 
    
    Query keywords
    https://docs.spring.io/spring-data/jpa/docs/2.5.1/reference/html/#repository-query-keywords
   
   Spring data JPA
   ---------------
    CrudRepository - interface
        - PagingAndSortingRepository
            - JpaRepository
   
   
   Create Spring boot project with dependencies
        - web
        - data jpa (default orm is hibernate)
        - MySQl connector - Driver

        - h2 db
   

  
  
  - Documentation of API using Swagger
  - Unit Testing REST API using Spring test
  
  - JPA Mappings
  
  
  - Documentation of API using Swagger
  
  Open API specification
  
  - Document the API automatically
  - Client UI for interact with the Rest API
  
  
  Add swagger dependencies
  <!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger2 -->
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
</dependency>

<!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui -->
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.9.2</version>
</dependency>

  
  
  Add an annotation in the configuration class
  @EnableSwagger2
 
 
 For Customized documentation, Swagger provides a class Docket 
  
  
  Create a Bean of Docket and do the customization
  
  
  
  Lombok 
    - used for autogenerating code for getter, setters, constructors, toString()......
    
  Add lombok dependency in your project
  Add Lombok plugin in Intellij
  
  
  
  Unit Testing of REST API using Spring test module
  -------------------------------------------------
  
  Testing Data Layer: 
  
  (With Embedded Database( added embedded db dependency in pom.xml)
  
  @DataJpaTest
  @ExtendWith(SpringExtension.class)

  
  With Actual Database instead of Embedded
    @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

    configure properties in applicaion.properties  
  
  
  Testing Service Layer:
  --------------------- 
  
  Mocking using Mockito
  
    - create mock objects
    - configure the method responses from the mock object
   
   
 @MockitoExtension  
   
   
   In Service layer. we have  dep on Repository
    - Using Mockito, we will mock the repository object and its responses
   
   
   https://gitlab.stackroute.in/stack_mccts007_java/maincourse_java_jfse_mc04_testing_different_layers_of_spring_boot_exercise
   
   
   Controller
   ----------
   
    MockMvc
        - used to send httprequests to the end points of an api/app
        
    @WebMvcTest(controllers=.....)
        - creating only a specific beans related to the controller layer
    
    @Mockbean
        - for creating mock beans in the test container
   
   
        
  @SpringBootTest
    - typically used for integration testing
    - Creates all the beans in the application in the test container  
  
  
  
  Java Code Coverage (JaCoCo)
  ---------------------------
  
  https://mkyong.com/maven/maven-jacoco-code-coverage-example/
  
  
  
  Reference : http://logback.qos.ch/manual/index.html
  props : https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#application-properties
  
  Logging
  --------
  
  System.out.println(.........)  --- 
  
  messages about events happening in application are called as logs
  
  
  Logging Frameworks:
  
  - levels of messages
  
  - to write messages to different destination
  
  - To disable some level of messages
  
  - To customize the format of message 
  
  
   - JDK util Logging
   - Log4j
     - Log4j - 2
   - Logback 
        - default in spring boot
   
   
   slf4j - Simple logging facade for Java - specification
        
            log4J, logback implements slf4j api
   
   
   Logging levels
   --------------
   
    trace - debug - info - warn - error
    
    info --> all info, warn and error messages will be logged
   debug ---> all debug, info, warn and error messages will be logged
   
   
   
   Logger
   ------
   helps to log messages
   - LoggerFactory
   
    logger.info(..message...);
    
   
   root logger - level info
     
     com.learn...   level info can be change to any other level
   
   
   Destinations
   ------------
   provides appenders
    - log message to diffent destinations
    - console, file, database, html ......
   
   
   Format
   -------
   provides Encoders
   - help you to format messages based on a given pattern
   
   
   Logger configuration can be done in multiple ways
    - using application.properties/yaml
    - creating a xml file logback.xml in resources folder
   
   
   
   
   logback.xml
<configuration>

  <property name="USER_HOME" value="/home/sebastien" />

  <appender name="FILE" class="ch.qos.logback.core.FileAppender">
    <file>${USER_HOME}/myApp.log</file>
    <encoder>
      <pattern>%msg%n</pattern>
    </encoder>
  </appender>

  <root level="debug">
    <appender-ref ref="FILE" />
  </root>
</configuration>





MICROSERVICES
-------------

Monolith architecture

Ecommerce
    - product management
    - Inventory management
    - Order Management
    - Payment processing
    - Authentication and authorization
    - Shipping services
    - Recommendation engine
    - ......
    

During development,All functionalities are distributed in to module,
    ITS A SINGLE DEPLOYMENT UNIT

Deployment
    - JAR, WAR -- deployed to server
    
    OK with small sized application
        - minimal changes
        
Applications are Dynamic
    - lot of changes being done
    - lot of testing
    - many deployment in a day/week
    
    
With Large Monoliths
    - Code base is very huge and hard to understand by a single developer/new team member
        - takes time to load in IDE
    - Making Changes become difficult
        - test lot of code before deployment
    - Deployment
        - takes time to deploy on server
        - continuos integration/deployment becomes difficult
        
    - tied to a technology/Framework
        - cannot adopt new technolies as per your need
        
    - Hiring skilled resources(people)    
    
    - Scaling
        - add new server with your application installed behind a Load Balancer
        - whole application has to be scaled up or down
    
    - whole app is running under a single process
    
 
 Microservices (Architecture)
 ----------------------------
 
    - Application is made of small and independent services(collection of services ) That are
        - they are autonomous
        - can be developed, tested and deployed independently
        - interact with each other to acive the final functionality
        - Organized around business capabilities
        - Owned by a small team
    
    Adv: 
        rapid, frequent and reliable delivery of large, complex applications
        It also enables an organization to evolve its technology stack.
    
    
 Microservice Patterns
 ---------------------
 
  API Gateway
  -----------
      - Single entry point for your application
      - Common functionalities can be performed here - Offloading
            - Authetication, cahing, ....
            
      - Composition
            - send request to multiple services based on the functionality needed
            
            
            
  Service Registration and Discovery
  ----------------------------------
    
    - Is a service running in a server which maintains the registry of microservices
    - Each microservice will register itself with service discovery
    - A microservice get the network location of other service by checking with Service Discovery
    
    
    
 Database per Service
 ---------------------
    - separate database
    - loosely coupled and independently testable, deployable
    
    
 Communication patterns
 ----------------------
    - Synchronous communication
        - RestTemplate, (Feign Client) in spring
        - service waits for the response
    
    - Asynchronous communication
        - through a message broker
        - Producer/consumer
        
 Centralized Configuration
        
      
 Spring Cloud
 ------------
  - Various project which will help you to implement microservice patterns easily with some configurations
  
  - Netflix
        - Eureka - Service R & D
        - Zuul   - API Gateway --(Deprecated)
  
  - Gateway
        API Gateway
        
  - Configuration
     - central configuration for all microservice
             
 
    
Service Registration and Discovery
  ----------------------------------
  
  Spring Cloud Netflix: 
  
    Eureka Server:
    
    - Create a spring web proj with Eureka server dependency
    
    - add annotation @EnableEurekaServer
    
    - add follwoing properties
    
    eureka.client.register-with-eureka=false
    eureka.client.fetch-registry=false
    
    
    Eureka Client:
        - Add eureka client dependency in pom of your service to be registered
        
        - Add annotation @EnableDiscoveryClient
        
        - add following properties
        spring.application.name=<servicename>
     
        eureka.client.register-with-eureka=true
        eureka.client.fetch-registry=true
        eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/
    

Spring Cloud Gateway
---------------------
    - Reactive Library of Spring
    - Non Blocking
    
    - Lesser reources/ threads used by API gateway
    
    - Netty - default server used by Reactive spring

Uses
    - routing to microservices
    - aggregating functionalites of multiple microservice
    Offloading:
        - Authentication/Authorization
        - Global configuration like CORS (Cross origin request)



Implementation:
   - Add dependencies
        - cloud gateway
        - Eureka client
        - Spring boot actuator

    - Add in application properties
    
            
spring:
  application:
    name: api-gateway-service
    
eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
  serviceUrl:
    defaultZone: http://localhost:8761/eureka/  


Do the route configuration using either yaml or java based config






























   
   
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
       
 
