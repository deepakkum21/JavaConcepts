# Spring Boot

##  What is spring boot?
1. Spring Boot is **not a framework**, it is a ***way to ease to create a stand-alone application with minimal or zero configurations***.
2. It is an **approach** to **develop a spring based application with very less configuration** ***avoiding some tedious development steps and boilerplate code***.
3. It **provides defaults for code** and **annotation configuration to quick start new spring projects within no time**.
4. Spring Boot leverages existing spring projects as well as Third party projects to develop production ready applications.
5. It **provides a set of Starter Pom** or Gradle build files which one can use to add required dependencies and also facilitate autoconfiguration.
6. Spring Boot automatically configures required classes depending on the libraries on its classpath. Suppose your application wants to interact with DB, if there are Spring Data libraries on classpath then it automatically sets up a connection to DB along with the Data Source class.

## What Spring Boot Isn’t?
1. Spring Boot is not a framework to write applications, it helps you to develop and build, package and deploy an application with minimal configuration or zero configuration.
2. It is not an application server(Servlet +EJB eg Jboss). But it’s the embedded servlet container that provides application server functionality, not Spring Boot itself.
3. Spring Boot doesn’t implement any enterprise Java specifications such as JPA or JMS. But it does support JPA by auto-configuring the appropriate beans for a JPA implementation (such as Hibernate)
**Note**:- ***In short, at its heart, Spring Boot is just Spring.***

## Pros of Spring Boot:
1. It is very **easy to develop Spring Based applications with Java** or Groovy.
2. Spring Boot **reduces lots of development time and increases productivity**.
3. It **avoids writing lots of boilerplate Code, Annotations and XML Configuration**.
4. It is very easy to integrate Spring Boot Application with its Spring Ecosystem like Spring JDBC, Spring ORM, Spring Data, Spring Security etc.
5. Spring Boot follows “Opinionated Defaults Configuration” Approach to reducing Developer effort
6. It **provides Embedded HTTP servers like Tomcat**, Jetty etc. to develop and test our web applications very easily.
7. It **provides CLI (Command Line Interface) tool to develop and test Spring Boot** (Java or Groovy) Applications from command prompt very easily and quickly.
8. Spring Boot **provides lots of plugins to develop and test Spring Boot Applications very easily using Build Tools like Maven** and Gradle
9. It **provides lots of plugins to work with embedded and in-memory Databases very easily**.

## Limitation of Spring Boot:
1. It is a **very tough and time-consuming process to convert existing or legacy** Spring Framework projects into Spring Boot Applications. It is applicable only for brand new/Greenfield Spring Projects.

## Getting started with Spring Boot
1. The Spring Team (The Pivotal Team) has provided the following three approaches.
    - Using the ***Spring Boot CLI Tool***
    - ***Spring STS IDE*** (Spring Tool Suite)
    - Using ***Spring Initializr*** (Website http://start.spring.io/)
2. We can develop two flavours of Spring-Based Applications using Spring Boot
    - Java-Based Applications
    - Groovy Applications

## Starters
1. Starters are a set of convenient dependency descriptors that you can include in your application.
2. The starters contain a lot of the dependencies that you need to get a project up and running quickly and with a consistent, supported a set of managed transitive dependencies.

| **Name** | **Description** |              
| -------- | --------------- |                                               
| spring-boot-starter-test	| Starter for testing Spring Boot applications with libraries including JUnit, Hamcrest and Mockito	|  
| spring-boot-starter-mobile	| Starter for building web applications using Spring Mobile	 | 
| spring-boot-starter-social-twitter	| Starter for using Spring Social Twitter	 | 
| spring-boot-starter-cache	| Starter for using Spring Framework’s caching support	|  
| spring-boot-starter-activemq	| Starter for JMS messaging using Apache ActiveMQ	 | 
| spring-boot-starter-jta-atomikos	| Starter for JTA transactions using Atomikos	 | 
| spring-boot-starter-aop	| Starter for aspect-oriented programming with Spring AOP and AspectJ	 | 
| spring-boot-starter-web	| Starter for building web, including RESTful, applications using Spring MVC. Uses Tomcat as the default embedded container	 | 
| spring-boot-starter-data-elasticsearch	| Starter for using Elasticsearch search and analytics engine and Spring Data Elasticsearch	|  
| spring-boot-starter-jdbc	| Starter for using JDBC with the Tomcat JDBC connection pool	 | 
| spring-boot-starter-batch	| Starter for using Spring Batch, including HSQLDB in-memory database	 | 
| spring-boot-starter-social-facebook	| Starter for using Spring Social Facebook	|  
| spring-boot-starter-web-services	| Starter for using Spring Web Services	 | 
| spring-boot-starter-jta-narayana	| Spring Boot Narayana JTA Starter	|  
| spring-boot-starter-thymeleaf	| Starter for building MVC web applications using Thymeleaf views	 | 
| spring-boot-starter-mail	| Starter for using Java Mail and Spring Framework’s email sending support	 | 
| spring-boot-starter-jta-bitronix	| Starter for JTA transactions using Bitronix	 | 
| spring-boot-starter-data-mongodb	| Starter for using MongoDB document-oriented database and Spring Data MongoDB	 | 
| spring-boot-starter-validation	| Starter for using Java Bean Validation with Hibernate Validator	 | 
| spring-boot-starter-jooq	| Starter for using jOOQ to access SQL databases. An alternative to spring-boot-starter-data-jpa or spring-boot-starter-jdbc	 | 
| spring-boot-starter-redis	| Starter for using Redis key-value data store with Spring Data Redis and the Jedis client. Deprecated as of 1.4 in favor of spring-boot-starter-data-redis	 | 
| spring-boot-starter-data-cassandra	| Starter for using Cassandra distributed database and Spring Data Cassandra	 | 
| spring-boot-starter-hateoas	| Starter for building hypermedia-based RESTful web application with Spring MVC and Spring HATEOAS	 | 
| spring-boot-starter-integration	| Starter for using Spring Integration	 | 
| spring-boot-starter-data-solr	| Starter for using the Apache Solr search platform with Spring Data Solr	 | 
| spring-boot-starter-freemarker	| Starter for building MVC web applications using Freemarker views	 | 
| spring-boot-starter-jersey	| Starter for building RESTful web applications using JAX-RS and Jersey. An alternative to spring-boot-starter-web	 | 
| spring-boot-starter	| Core starter, including auto-configuration support, logging and YAML	 | 
| spring-boot-starter-data-couchbase	| Starter for using Couchbase document-oriented database and Spring Data Couchbase	 | 
| spring-boot-starter-artemis	| Starter for JMS messaging using Apache Artemis	 | 
| spring-boot-starter-cloud-connectors	| Starter for using Spring Cloud Connectors which simplifies connecting to services in cloud platforms like Cloud Foundry and Heroku	 | 
| spring-boot-starter-social-linkedin	| Stater for using Spring Social LinkedIn	 | 
| spring-boot-starter-velocity	| Starter for building MVC web applications using Velocity views. Deprecated since 1.4	 | 
| spring-boot-starter-data-rest	| Starter for exposing Spring Data repositories over REST using Spring Data REST	 | 
| spring-boot-starter-data-gemfire	| Starter for using GemFire distributed data store and Spring Data GemFire	 | 
| spring-boot-starter-groovy-templates	| Starter for building MVC web applications using Groovy Templates views	 | 
| spring-boot-starter-amqp	| Starter for using Spring AMQP and Rabbit MQ	 | 
| spring-boot-starter-hornetq	| Starter for JMS messaging using HornetQ. Deprecated as of 1.4 in favor of spring-boot-starter-artemis	 | 
| spring-boot-starter-ws	| Starter for using Spring Web Services. Deprecated as of 1.4 in favor of spring-boot-starter-web-services	 | 
| spring-boot-starter-security	| Starter for using Spring Security	 | 
| spring-boot-starter-data-redis	| Starter for using Redis key-value data store with Spring Data Redis and the Jedis client	 | 
| spring-boot-starter-websocket	| Starter for building WebSocket applications using Spring Framework’s WebSocket support	 | 
| spring-boot-starter-mustache	| Starter for building MVC web applications using Mustache views	 | 
| spring-boot-starter-data-neo4j	| Starter for using Neo4j graph database and Spring Data Neo4j	 | 
| spring-boot-starter-data-jpa	| Starter for using Spring Data JPA with Hibernate	 |


## Essentials and Internals of Spring Boot Key Components:
But there are four core essentials or key components
1. ***Spring Boot Starters***- 
    - We just tell Spring Boot what kind of functionality we need; now it is responsibility of Spring Boot so that it will ensure that the libraries needed are added to the build.
    - **reduces build’s dependencies**
2. ***Spring Boot AutoConfigurator***- 
    - Spring Boot can automatically provide configuration for application functionality common to many Spring applications.
    - **reduces the Spring Configuration**
3. ***Spring Boot CLI***- 
    - This optional feature of Spring Boot lets you write complete applications with just application code, but no need for a traditional project build.
4. ***Spring Boot Actuator***- 
    - Gives us insight of application into what’s going on inside of a running Spring Boot application. (health metrics)

### ***1. Spring Boot Starters (reduces build’s dependencies)***    
- it combines all related jars into single jar file so that we can add only one jar file dependency to our build files. If we were to take advantage of Spring Boot starter dependencies, We could simply add the Spring Boot “web” starter (org.springframework.boot:spring-boot-starter-web) as a build dependency. This single dependency will transitively pull in all of those other dependencies so you don’t have to ask for them all.
- One thing we have to notice that by adding the “web” starter to our build, we’re specifying a type of functionality that your application needs. Here our app is a web application, so we add the “web” starter. Likewise, if our application will use JPA persistence, then we can add the “jpa” starter. If it needs security, we can add the “security” starter.
- Also note that **Spring Boot’s starter dependencies free us from worrying about which versions of these libraries we need.**
- Spring Boot Starter reduces defining many dependencies simplify project build dependencies.
- Spring Boot Starter simplifies project build dependencies.
- Spring Boot Starter sync version compatibilities of dependencies.

### ***2. Spring Boot AutoConfigurator (reduces the Spring Configuration)***
- The main responsibility of Spring Boot AutoConfigurator is to **reduce the Spring Configuration**. 
- If we develop Spring applications in Spring Boot, then We **don’t need to define single XML configuration and almost no or minimal Annotation configuration**. Spring Boot AutoConfigurator component will take care of providing that information.

### ***4. Spring Boot Actuator***
- the Actuator instead offers the **ability to inspect the internals of your application at runtime**. 
- **Providing Management EndPoints** to Spring Boot Applications.
- Spring Boot **Applications Metrics**.
- The Actuator **exposes this information** in two ways: 
    - *via web endpoints* 
    - *via a shell interface*.
- inner workings of application with Actuator as below:
    - **What beans have been configured** in the Spring application context
    - What decisions were made by Spring Boot’s auto-configuration
    - **What environment variables, system properties, configuration properties**, and command-line arguments are **available** to your application
    - The **current state of the threads** in and supporting your application
    - A trace of **recent HTTP requests** handled by your application
    - Various **metrics pertaining to memory usage, garbage collection, web requests, and data source usage**


## Spring Boot CLI installation and Hello World Example
1. The Spring Boot CLI is a command line tool that can be used if we want to quickly develop with Spring. 
2. It allows us to run Groovy scripts, which means that we have a familiar Java-like syntax, without so much boilerplate code. We can also bootstrap a new project or write your own command for it.
3. It is Spring Boot software to run and test Spring Boot applications from command prompt. When we run Spring Boot applications using CLI, then it internally uses Spring Boot Starter and Spring Boot AutoConfigurate components to resolve all dependencies and execute the application.
4. **Quick start Spring Boot CLI Hello World Example**
    -  Create an “app” Folder in our Local FileSystem to place our groovy scripts.
    - Create a file called app.groovy
    -               @RestController
                    class app{
                        @RequestMapping("/")
                        String home() {
                            "Hello World!"
                        }
                    }
    - To compile and run the application type:
        - `spring run app.groovy`
        - `spring run app.groovy —–server.port=9000` 


## @EnableAutoConfiguration Annotation in Spring Boot
1. This **auto-configures the beans that are present in the classpath**. 
2. This simplifies the developers work by **guessing the required beans from the classpath and configure it to run the application**. 
3. For example, if you have tomcat-embedded.jar in the classpath, then you will need a TomcatEmbeddedServletContainerFactory bean to configure the tomcat server. This will be searched and configured without any manual XML configurations.
4. it will be **used when scanning for @Entity classes**. It is generally **recommended that you place @EnableAutoConfiguration in a root package** so that all sub-packages and classes can be searched.
5. These @EnableAutoConfiguration **are Auto-configuration classes ie normal @Configuration annotated classes only.** 
6. These are `mentioned in the spring.factories file`. `Spring checks the spring.factories files under the folder META-INF in your project` or JAR file **to auto-configure the configuration classes**.
7. **@EnableAutoConfiguration Parameters**
    - `exclude` – Exclude the list of classes from the auto configuration.
    - `excludeNames` – Exclude the list of fully qualified class names from the auto configuration. 
        - eg. :- `@EnableAutoConfiguration(exclude={Book.class})`
8. This annotation ***tells Spring Boot to “guess” how you will want to configure Spring, based on the jar dependencies that you have added***. 
    - eg. spring-boot-starter-web added Tomcat and Spring MVC, the auto-configuration will assume that you are developing a web application and setup Spring accordingly.        


## @SpringBootApplication 
1. `@SpringBootApplication = @Configuration + @ComponentScan + @EnableAutoConfiguration`
2. @SpringBootApplication does the following things:
    - Because of **@Configuration annotation**, It `scans for @Bean methods to create beans`.
    - Because of **@ComponentScan annotation**, It `does component scanning` (Components means Beans annotated with @Component,@Service,@Repository,@Controller etc).
    - Because of **@EnableAutoConfiguration annotation**, It `triggers Spring Boot Auto-Configuration`.
3. When we **run MySpringBootAppApplication class main() method**, it make a calls to “SpringApplication.run()” method. Then this call done following things
    - This call is used to `create “AnnotationConfigEmbeddedWebApplicationContext”`.
    - This `“AnnotationConfigEmbeddedWebApplicationContext” instance is used to create an instance of “TomcatEmbeddedServletContainerFactory” class`.
    - This `“TomcatEmbeddedServletContainerFactory” is used to create an instance of “TomcatEmbeddedServletContainer” class`.
    - `“TomcatEmbeddedServletContainer” instance starts a Tomcat Container at default port number: 8080 and deploys our Spring Boot WebApplication`.
    -  images
                                                                                         

MySpringBootAppApplication class main() method => call SpringApplication.run() => create “AnnotationConfigEmbeddedWebApplicationContext => create “TomcatEmbeddedServletContainerFactory” => create “TomcatEmbeddedServletContainer” => starts a Tomcat Container on default port(if not mentioned in properties file) + deploys our Spring Boot WebApplication

## Spring Boot Initializr with Spring Boot CLI
- the Spring Boot CLI also has a few commands that can help us use the Initializr to kick-start development on a more traditional Java project.
- ***Syntax for Init Command:***
    1. `spring init [options] [location]`
        - After contacting the Initializr web application, the init command will conclude by downloading a demo.zip file with following default setting.
            - Default Build tool is “maven”.
            - Default Spring Initilizr service target URL: https://start.spring.io
            - Default project name: “demo”
            - Default maven type: “jar”
            - Default only baseline starter dependencies for Spring Boot and testing
    2. | **COMMAND DESCRIPTION** | **MAVEN CMD** | **GRADLE CMD** |     
       | ----------------------- | ------------- | -------------- |             
       | Using required dependencies on web project | spring init –dweb,jpa,security | spring init –dweb,jpa,security –build gradle | 
       | Change packaging (both Maven and Gradle builds will produce an executable JAR file) | spring init –dweb,jpa,security –build maven –p war | spring init –dweb,jpa,security –build gradle –p war |
       | Change application name | spring init –dweb, jpa, security –build maven –p war myapp.zip | spring init –dweb, jpa, security –build gradle –p war myapp.zip |
       | Specifying the Java version to compile with, and selecting a version of Spring Boot | spring init –dweb, jpa, security –build maven –java-version=1.7 –boot-version=1.3.0.RELEASE –p war myapp.zip | spring init –dweb, jpa, security –build gradle –java-version=1.7 –boot-version=1.3.0.RELEASE –p war myapp.zip |

## Customizing Spring Boot Auto Configuration
- two ways to influence auto-configuration:
    - `explicit configuration overrides`
    - `configuration with properties`.       
### ***1. Overriding auto-configured beans***
- Spring Boot **auto-configuration attempts to automatically configure your Spring application based on the jar dependencies** that you have added.
- If you can get what you need without it then why would you do extra work, writing and maintaining extra configuration code, but sometimes **there are many cases Spring Boot auto configuration is not good enough**.
- For example **one of the cases is when you’re applying security to your application**. Security in your application is one of major concern so it is not single fit for all because there are decisions around application security that Spring Boot has no business making for you even though Spring Boot provides auto configuration for some basic spring security things.
1. **For securing the application:**
    - Just adding Spring Security Starter to add spring security auto configuration to the application.
        -                   <dependency>
                                <groupId>org.springframework.boot</groupId>
                                <artifactId>spring-boot-starter-security</artifactId>
                            </dependency>
        - Rebuild your application and run it. It’s now a secure web application! The security starter adds Spring Security to the application’s classpath.
        - With Spring Security on the classpath, auto-configuration kicks in and a very basic Spring Security setup is created.
        - When open this application browser basic authentication is needed then user name is “user” and password is printed in logs.                        
2. **Custom security configuration in the application**
    - Basic **default configuration probably is not fit for your application because unlike authentication page and password is printed in the logs**. 
    - That is why you will prefer customized security configuration in the application. 
    - For overriding default spring boot auto configuration **just writing explicit XML based or Java based configuration in the application this means `writing a configuration class that extends WebSecurityConfigurerAdapter`**.
    -               @Configuration
                    @EnableWebSecurity
                    public class SecurityConfig extends WebSecurityConfigurerAdapter {

                        @Autowired
                        UserRepository userRepository;
                        
                        @Override
                        protected void configure(HttpSecurity http) throws Exception {
                            http
                            .authorizeRequests()
                            .antMatchers("/").access("hasRole(ADMIN)")
                            .antMatchers("/**").permitAll()
                            .and()
                            .formLogin()
                            .loginPage("/login")
                            .failureUrl("/login?error=true");
                        }

                        @Override
                        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
                            auth.userDetailsService(new UserDetailsService() {
                                @Override
                                public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                                    return userRepository.findUserName(username);
                                }
                            });
                        }
                    }

### ***2. Configuring with external properties***
1. Spring Boot allows you to `externalize your configuration so you can work with the same application code in different environments`. 
2. Can **use properties files, YAML files, environment variables, Java system properties, JNDI and command-line arguments to externalize configuration**. Spring Boot offers over 300 properties for auto configuration of beans in the application.
3. eg one of property when you start the application a banner is printed at log screen.                 
    - There are following ways to setting up this property when we run the application
    - | **WAYS FOR SETTING UP** | **COMMAND** |                              
      | ----------------------- | ----------- |                                   
      | Command Line Parameters | $ java -jar myapp-0.0.1-SNAPSHOT.jar --spring.main.show-banner=false | 
      | application.properties | spring.main.show-banner=false | 
      | application.yml |   spring:    main:      show-banner: false |
      | Setting property as an environment variable | $ export spring_main_show_banner=false | 

4. ***Spring Boot particular PropertySource order***
    - `@TestPropertySource` annotations **on your tests**.
    - `Command line arguments`.
    - Properties from SPRING_APPLICATION_JSON (inline JSON embedded in an environment variable or system property)
    - ServletConfig init parameters.
    - ServletContext init parameters.
    - JNDI attributes from java:comp/env.
    - `Java System properties` (System.getProperties()).
    - `OS environment variables`.
    - A RandomValuePropertySource that only has properties in random.*.
    - Profile-specific application properties outside of your packaged jar (application-{profile}.properties and YAML variants)
    - Profile-specific application properties packaged inside your jar (application-{profile}.properties and YAML variants)
    - **Application properties `outside` of your packaged jar** (application.properties and YAML variants).
    - **Application properties packaged `inside` your jar** (application.properties and YAML variants).
    - `@PropertySource annotations on your @Configuration classes`.
    - Default properties (specified using SpringApplication.setDefaultProperties)

5. the application.properties and application.yml files, they can reside in any of four locations:
    | **EXTERNALLY** | **INTERNALLY** |         
    | -------------- | -------------- |                         
    | **/config subdirectory** of the *directory from which the application is run* | `package named “config` |     
    | **directory from which the application is run** |  `root of the classpath` | 
    - an `application.properties file in a /config subdirectory will override` the **same properties set in an application.properties file in the application’s classpath**.
    - if you have both **application.properties and application.yml side by side** at the same level of precedence, properties in `application.yml will override those in application.properties`.

6. ***DISABLING TEMPLATE CACHING***
    - **Thymeleaf templates are cached by default that is why changes is never replicate unless you restart the application**.
    - `spring.thymeleaf.cache=false`
    - Other template caching can be turned off for Spring Boot’s
        - `spring.freemarker.cache` (Freemarker)
        - `spring.groovy.template.cache` (Groovy templates)
        - `spring.velocity.cache` (Velocity)

7. ***CONFIGURING A DATA SOURCE***
    - application.yml: if you’re using a MySQL database,
        -       spring:
                    datasource:
                        url: jdbc:mysql://localhost/dojdb
                        username: root
                        password: root  
                        driver-class-name: com.mysql.jdbc.Driver

8. ***Configuring with profiles***
    - When applications are deployed to different runtime environments, there are usually some configuration details that will differ.
        - eg. The details of a database connection, for instance, are likely different in a development environment than in a quality assurance environment, and different still in a production environment. 
        -           @Configuration
                    @Profile("production")
                    public class ProductionConfiguration {
                        // ...
                    }     
        - The @Profile annotation used here **requires that the “production” profile be active at runtime for this configuration to be applied**. If the **“production” profile isn’t active, this configuration will be ignored** and applied any default auto configuration.      

9. ***Activate profiles:***
    - Profiles can be activated by setting the spring.profiles.active property using any of the means available for setting any other configuration property.
    - `spring.profiles.active=production`              

10. ***Profile-specific properties:***
    1. If you’re using application.properties to express configuration properties, you **can provide profile-specific properties by creating additional properties files named with the pattern** “`application-{profile}.properties`”. 
    2. **Profile-specific properties are loaded from the same locations as standard application.properties**.
    3. ***profile-specific files always overriding the non-specific ones irrespective of whether the profile-specific files are inside or outside your packaged jar***.    
    4.              ## application-development.properties

                                logging.level.root=DEBUG

    5.              ## application-production.properties

                                logging.path=/opt/logs/
                                logging.file=MyApp.log
                                logging.level.root=WARN 

    6. ***Multi-profile YAML documents:***
        -           ## application.yml

                                logging:
                                    level:
                                        root: INFO
                                ---
                                spring:
                                    profiles: development
                                logging:
                                    level:
                                        root: DEBUG
                                ---
                                spring:
                                    profiles: production
                                logging:
                                    path: /opt/
                                    file: MyApp.log
                                    level:
                                        root: WARN  

## ***Customizing Spring Boot Default WhiteLabel error pages***   
### ***1. Disabling the Whitelabel Error Page***
-                   ## application.properties

                                server.error.whitelabel.enabled=false 
                                spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration
 
                                # for Spring Boot 2.0
                                # spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration 
- Or by adding this annotation to the main class:
    `@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})`

### ***2. Displaying Custom Error Pages***
1. **Add Thymeleaf template egine dependency**   
    -           <!-- Spring boot Thymeleaf -->
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-thymeleaf</artifactId>
                </dependency>
2. **create a custom HTML error page** snd `save the file as error.html`
    -     ## error.html      
                
                <!DOCTYPE html>
                <html>
                    <body>
                        <h1>Something went wrong! </h1>
                        <h2>Our Engineers are on it</h2>
                        <a href="/">Go Home</a>
                    </body>
                </html>
3.  **create a class that implements the ErrorController interface**
    -       ## MyErrorController.java

                        import org.springframework.boot.web.servlet.error.ErrorController;
                        import org.springframework.stereotype.Controller;
                        import org.springframework.web.bind.annotation.RequestMapping;

                        @Controller
                        public class MyErrorController implements ErrorController  {
                        
                            @RequestMapping("/error")
                            public String handleError() {
                                //do something like logging
                                return "error";
                            }
                        
                            @Override
                            public String getErrorPath() {
                                return "/error";
                            }
                        }
    - In the snippet above, we also annotate the class with @Controller and **create a mapping for the path that is returned by the getErrorPath()**. This way the **controller can handle calls to the /error path**.

    - In the **handleError(), we return the custom error page we created earlier**. If we trigger a 404 error now, it's our custom page that will be displayed.

4. **further enhance the handleError() to display specific error pages for different error types**
    -       ## MyErrorController.java
    
                        @Controller
                        public class MyErrorController implements ErrorController  {
                        
                            @RequestMapping("/error")
                            public String handleError(HttpServletRequest request) {
                                Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
                                
                                if (status != null) {
                                    Integer statusCode = Integer.valueOf(status.toString());
                                
                                    if(statusCode == HttpStatus.NOT_FOUND.value()) {
                                        return "error-404";
                                    }
                                    else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                                        return "error-500";
                                    }
                                }
                                return "error";
                            } 
                        
                            @Override
                            public String getErrorPath() {
                                return "/error";
                            }
                        }

## ***Logging Configuration in Spring Boot***
1. Logging is not the core requirement for any business application but we cannot ignore it because logging is very important part for any application for tracking information about application and helpful for developer in debugging the application.
2. Spring Boot provides `support for logging and uses Commons Logging for all internal logging, but leaves the underlying log implementation open.`
3. **Default configurations are provided for `Java Util Logging, Log4J2 and Logback`**.
4. By default, **if you use the `‘Starters’`, `Logback` will be used for logging**.
5. Can **set the logging level** in application.properties
    - `logging.level.root=DEBUG`
6. **Set logging pattern**
    -       ## application.yml    
                
                logging:
                    pattern:
                        console: %d{yyyy-MM-dd HH:mm:ss} - %msg%n
                        file: %d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n  

7. **Set logging output to file**
    -       ## application.yml 

                logging:
                    file: /logs/application-debug.log

8. **Color-coded logging output**
    - If your terminal supports ANSI, color output will be used to aid readability. You can `set spring.output.ansi.enabled value to either ALWAYS, NEVER or DETECT`
    -       ## application.yml 

                spring:
                    output:
                    ansi:
                        enabled: DETECT

### ***1. Default Logging Format in Spring Boot***
1. The default logs look like as below
    -           2020-01-22 20:31:48.201  INFO 10220 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat initialized with port(s): 8080 (http)
                2020-01-22 20:31:48.226  INFO 10220 --- [           main] o.apache.catalina.core.StandardService   : Starting service Tomcat
                2020-01-22 20:31:48.228  INFO 10220 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/8.5.3
                2020-01-22 20:31:48.485  INFO 10220 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
                2020-01-22 20:31:48.485  INFO 10220 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 2993 ms
    - **Date and Time**: Millisecond precision and easily sort able.
    - **Log Level**: ERROR, WARN, INFO, DEBUG or TRACE.
    - **Process ID**.
    - A **—** Separator to distinguish the start of actual log messages.
    - **Thread name**: Enclosed in square brackets (may be truncated for console output).
    - **Logger name**: This is usually the source class name (often abbreviated).
    - **Log Message**

2. The `default log level configured by logback is DEBUG` i.e any **messages logged at ERROR, WARN, INFO and DEBUG get printed on the console**.
3. `No need to add the logging dependency explicitly` **because dependency spring-boot-starter includes the dependencies for logging spring-boot-starter-logging**
4. The **spring-boot-starter-logging** `includes SLF4J and logback dependencies` with appropriate SLF4J wrappers for other logging libraries.
5. Syntax to get the logger object:
    - `private static final Logger logger = LoggerFactory.getLogger(ClassForWhichNeedLogger.class);`

### ***2. Customizing default Configuration for Logging:***
1. By **adding logback.xml file to the application we can override** the default logging configuration providing by the Spring Boot.
2. This **file place in the classpath (src/main/resources)** of the application for Spring Boot to pick the custom configuration.
3.                    ## logback.xml  

                                <?xml version="1.0" encoding="UTF-8"?>
                                <configuration>
                                    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
                                        <!-- Log message format -->
                                        <encoder>
                                            <pattern>
                                                %d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n
                                            </pattern>
                                        </encoder>
                                    </appender>

                                    <!-- Setting the root level of logging to INFO -->
                                    <root level="info">
                                        <appender-ref ref="STDOUT" />
                                    </root>
                                </configuration>
        
    - There are following things we have note:
        - We are **using a appender STDOUT using ConsoleAppender** which **prints to the console**
        - We are **giving pattern to the appender to build the log message**
        - Set up a **root logger which logs any message above INFO** level using the STDOUT appender

### ***3. Printing Logs into a File:***
1. **By default, Spring Boot will only log to the console and will not write log files**. 
2. If you **want to write log files** in addition to the console output you **need to set a logging.file or logging.path property in your application.properties**.
3. There are following cases for logging property:
    - If **No logging.path** and **No logging.file** `then Console only logging`.
    - If **No logging.path and Specify logging.file** `then writes to the specified log file`. Names can be an exact location or relative to the current directory.
    - If **Specify logging.path and No logging.file** `then writes spring.log to the specified directory`. Names can be an exact location or relative to the current directory.
4. `Log files will rotate when they reach 10 Mb` and as with console output, **ERROR, WARN and INFO level messages are logged by default**
    -               ## logback.xml  

                                <?xml version="1.0" encoding="UTF-8"?>
                                <configuration>
                                    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
                                        <!-- Log message format -->
                                        <encoder>
                                            <pattern> %d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n </pattern>
                                        </encoder>
                                    </appender>
                                    <!-- Need appender to write to file -->
                                    <appender name="FILE" class="ch.qos.logback.core.FileAppender">
                                        <!-- Name of the file where the log messages are written -->
                                        <file>MySpringBootApp.log</file>
                                        <encoder>
                                            <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
                                        </encoder>
                                    </appender>
                                    <logger name="com.deepak.service" level="warn">
                                        <appender-ref ref="FILE" />
                                    </logger>

                                    <!-- Setting the root level of logging to INFO -->
                                    <root level="info">
                                        <appender-ref ref="FILE" />
                                    </root>
                                </configuration> 

### ***4. Custom log configuration***
1. The various logging systems can be activated by including the appropriate libraries on the classpath, and further customized by providing a suitable configuration file in the root of the classpath, or in a location specified by the Spring Environment property logging.config.
    - **Logback** -> `logback-spring.xml, logback-spring.groovy, logback.xml or logback.groovy`
    - **Log4j2** -> `log4j2-spring.xml or log4j2.xml`
    - **JDK** (Java Util Logging) -> `logging.properties`
2. There are following properties we can use for custom log configuration
    - `logging.file` -> Used in default log configuration if defined for logging file name.
    - `logging.path` -> Used in default log configuration if defined for logging file path of directory.
    - `logging.pattern.console` -> The log pattern to use on the console.
    - `logging.pattern.file` -> The log pattern to use in a file.
    - `logging.pattern.level` -> The format to use to render the log level.
    - `logging.exception-conversion-word` -> The conversion word that’s used when logging exceptions.

## ***Spring boot exception handling***
Handling exceptions and errors in APIs and sending the proper response to the client is good for enterprise applications
### ***1. @Controller Advice***
- `to handle the exceptions globally.`

### ***2. @Exception Handler***
- used to `handle the specific exceptions and sending the custom responses to the client`.


## ***Working with SQL Databases in Spring Boot Application***
