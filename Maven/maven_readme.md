# Maven
- Maven is a **build and dependency management tool** for Java based application development.

## Maven – Settings File
1. settings.xml file **contains configurations** that are not specific to a project, but are global in nature. 
2. It also contains information that is not meant to be distributed (e.g. passwords).

## Location of Maven Settings File(settings.xml)
Maven can have two settings files working at a time:
- The **Maven installation directory**: **$M2_HOME/conf/settings.xml [global settings]**
- The **user’s home directory**: **${user.home}/.m2/settings.xml [user settings]**
- Both files are optional. If **both files are present, the values in the user home settings file overrides the values from global settings file**.
-           <settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                                    http://maven.apache.org/xsd/settings-1.0.0.xsd">
                <localRepository/>
                <interactiveMode/>
                <usePluginRegistry/>
                <offline/>
                <pluginGroups/>
                <servers/>
                <mirrors/>
                <proxies/>
                <profiles/>
                <activeProfiles/>
            </settings>

| **ELEMENT NAME** |	**DESCRIPTION**  |                
| ---------------- | ------------------- |                                 
| localRepository |	Maven stores copies of plug-ins and dependencies locally in the `C:\Users\<your_user_name>\.m2\repository` folder. This element can be used to change the path of the local repository. |          
| interactiveMode |	As the name suggests, when this value is set to true, the default value, Maven interacts with the user for input. |          
| usePluginRegistry |	It decide that if Maven should use the `${user.home}/.m2/plugin-registry.xml` file to manage plugin versions. Its default value is false. |          
| offline |	When set to true, this configuration instructs Maven to operate in an offline mode. The default is false. |          
| pluginGroups | It contains a list of pluginGroup elements, each contains a groupId. The list is searched when a plugin is used and the groupId is not provided in the command line. This list automatically contains org.apache.maven.plugins and org.codehaus.mojo. |          
| servers |	Maven can interact with a variety of servers, such as Apache Subversion (SVN) servers, build servers, and remote repository servers. This element allows you to specify security credentials, such as the username and password, which you need to connect to those servers. |          
| mirrors |	As the name suggests, mirrors allow you to specify **alternate locations for your repositories**. |          
| proxies |	proxies contains the HTTP proxy information needed to connect to the Internet. |          
| profiles |	profiles allow you to **group certain configuration elements, such as repositories** and pluginRepositories. |          
| activeProfile |	The activeProfile allows you to **specify a default profile to be active for Maven to use**. |          

## Maven – Dependency Management
- dependency is another archive—JAR, ZIP, and so on—**which your current project needs in order to compile, build, test, and/or to run**. 
- The dependencies are gathered in the pom.xml file, inside of a `<dependencies>` tag.
- When you run a build or execute a maven goal, these dependencies are resolved, and are then loaded from the local repository. 
- If they are not present there, then Maven will download them from a remote repository and store them in the local repository. 
- You are allowed to manually install the dependencies as well.
- If pom.xml points to many artifacts of the same groupId, you should use properties in order to factorize the code for easy maintenance.
-           <properties>
                <junit.version>4.12</junit.version>
                <spring.version>4.3.5.RELEASE</spring.version>
            </properties>
            
                <dependencies>
                
                    <dependency>
                        <groupId>junit</groupId>
                        <artifactId>junit</artifactId>
                        <version>${junit.version}</version>
                        <scope>test</scope>
                    </dependency>
                    
                    <dependency>
                        <groupId>org.springframework</groupId>
                        <artifactId>spring-core</artifactId>
                        <version>${spring.version}</version>
                    </dependency>
                    
                </dependencies>

- ### External Dependency
1. Some times, one has to **refer jar files which are not in maven repository** (neither local, central or remote repository). 
2. Then we can **use these jars by placing them in project’s lib folder** and configure the external dependency like this:
3.      <dependency>
            <groupId>extDependency</groupId>                                                //  groupId and artifactId are both set to the name of the dependency
            <artifactId>extDependency</artifactId>
            <scope>system</scope>                                                           //  scope element value is set to system
            <version>1.0</version>
            <systemPath>${basedir}\war\WEB-INF\lib\extDependency.jar</systemPath>           //  refer to the location of the JAR file
        </dependency>

- ### Maven Dependency Tree
1. Using maven’s dependency:tree command, you can **view list of all dependencies into your project – transitively**. 
2. *Transitive dependency means that if A depends on B and B depends on C, then A depends on both B and C.*
3. ` mvn dependency:tree`

- ### Maven Dependency Exclusion
1. To resolve version mismatch issues, maven provides `<exclusion>` tag, in order **to break the transitive dependency**.
2. For example, when you have JUnit 4.12 in classpath and including DBUnit dependency, then you will need to remove JUnit 3.8.2 dependency. It can be done with exclusion tag.
3.      <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>                                  // 1st junit
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.dbunit</groupId>
            <artifactId>dbunit</artifactId>
            <version>${dbunit.version}</version>
            <scope>test</scope>
            <exclusions>
                <!--Exclude transitive dependency to JUnit-3.8.2 -->    
                <exclusion>
                    <artifactId>junit</artifactId>                          // 2nd junit
                    <groupId>junit</groupId>
                </exclusion>
            </exclusions>
        </dependency>

- ### Artifact Version Ranges
1. While including a dependency, you are free to specify a range of versions for any artifact. 
    - Parenthesis signs **( and ) hint an including range**
    - Brackets signs **[ and ] hint an excluding range**
    - Commas separate subsets

| **RANGE** |	**MEANING** |               
| --------- | ------------- |    
| 1.2 |	Version equals to 1.2 or is starting with 1.2 |             
| (,1.2] |	Any version less than 1.2. Version 1.2 included. x <= 1.2 |             
| (,1.2) |	Any version less than 1.2. Version 1.2 excluded. x < 1.2 |              
| [1.2] |	Only version 1.2 only.x == 1.0 |                
| [1.2,) |	Any version greater than 1.2. Version 1.2 included. x >= 1.2 |              
| (1.2,) |	Any version greater than 1.2. Version 1.2 excluded. x > 1.2 |               
| (1.2,2.2) |	Version between 1.2 and 2.2. Both excluded. 1.0 < x < 2.0 |             
| [1.2,2.2] |	Version between 1.2 and 2.2. Both included. 1.2 <= x <= 2.2 |               
| (,1.2],[2.2,) |	Version either less that 1.2 or greater than 2.2. Both included. x <= 1.2 or x >= 2.2 |        

## Maven Dependency Scopes
1. Maven dependency scope attribute is used to **specify the visibility of a dependency, relative to the different lifecycle phases (build, test, runtime etc)**.
2. Maven provides six scopes i.e. 
    - compile
    - provided
    - runtime
    - test
    - system
    - import
3. ### Maven dependency scope – compile
    - maven **default scope**
    - Dependencies with this scope are **available on the classpath** of the project
    - Dependencies with compile scope **are needed to build, test, and run the project**.
    - to **resolve the import statements** into your java classes sourcecode.
    -           <dependencies>
                    <dependency>
                        <groupId>log4j</groupId>
                        <artifactId>log4j</artifactId>
                        <version>1.2.14</version>
                        <!-- You can ommit this because it is default -->
                        <scope>compile</scope>
                    </dependency>
                </dependencies>

4. ### Maven dependency scope – provided
    - This scope is used to **mark dependencies that should be provided at runtime by JDK or a container**, hence the name. 
    - A good use case for this scope would be a **web application deployed in some container, where the container already provides some libraries itself**.
    - For example, a web server that already provides the Servlet API at runtime, thus in our project, those dependencies can be defined with the provided scope:
    -               <dependency>
                        <groupId>javax.servlet</groupId>
                        <artifactId>servlet-api</artifactId>
                        <version>2.5</version>
                        <scope>provided</scope>
                    </dependency>

5. ### Maven dependency scope – runtime (JDBC driver)
    - The dependencies with this scope are **required at runtime**.
    - they're **not needed for compilation of the project code**.
    - dependencies marked with the runtime scope **will be present in runtime and test classpath**, **but they will be missing from compile classpath**.
    - example of dependencies that should use the runtime scope is a **JDBC driver**:
    -            <dependency>
                    <groupId>mysql</groupId>
                    <artifactId>mysql-connector-java</artifactId>
                    <version>6.0.6</version>
                    <scope>runtime</scope>
                </dependency>

6. ### Maven dependency scope – test
    - This scope is used to indicate that dependency **isn't required at standard runtime of the application, but is used only for test purposes**.
    - The standard use case for this scope is adding test library like **JUnit** to our application:
    -           <dependency>
                    <groupId>junit</groupId>
                    <artifactId>junit</artifactId>
                    <version>4.12</version>
                    <scope>test</scope>
                </dependency>

7. ### Maven dependency scope – system
    - System scope is much **similar to the provided scope**. 
    - The main difference between those two scopes is that **system requires us to directly point to specific jar on the system**.
    - The important thing to remember is that building the p**roject with system scope dependencies may fail on different machines if dependencies aren't present** or are located in a different place than the one systemPath points to:
    -           <dependency>
                    <groupId>com.baeldung</groupId>
                    <artifactId>custom-dependency</artifactId>
                    <version>1.3.2</version>
                    <scope>system</scope>
                    <systemPath>${project.basedir}/libs/custom-dependency-1.3.2.jar</systemPath>
                </dependency>

8. ### Maven dependency scope – import
    - This scope was **added in Maven 2.0.9** and it's **only available for the dependency type pom**.
    - Import indicates that **this dependency should be replaced with all effective dependencies declared in it's POM**:
    -           <dependency>
                    <groupId>com.baeldung</groupId>
                    <artifactId>custom-project</artifactId>
                    <version>1.3.2</version>
                    <type>pom</type>
                    <scope>import</scope>
                </dependency>

9. ### Maven dependency transitivity resolution            
| **Dependency** |	**compile** |	**provided** |	**runtime** |	**test** |  
| -------------- | ------------ | -------------- | ------------ | ---------- |                         
| **compile** |	compile |	– |	runtime |	– |                                         
| **provided** |	provided |	– |	provided |	– |                                             
| **runtime** |	runtime |	– |	runtime |	– |                                         
| **test** |	test |	– |	test |	– | 
- For the **compile scope**, all dependencies with runtime scope will be pulled in with the runtime scope, in the project and all dependencies with the compile scope will be pulled in with the compile scope, in the project
- For the provided scope, both runtime and compile scope dependencies will be pulled in with the provided scope, in the project
- For the test scope, both runtime and compile scope transitive dependencies will be pulled in with the test scope, in the project
- For the runtime scope, both runtime and compile scope transitive dependencies will be pulled in with the runtime scope, in the project   


## Maven – POM File
1. POM **(Project Object Model)** is an XML file that **contains information about the project and configuration** details used by Maven to build the project i.e. sourcecode location, project dependencies etc. 
2. This file **must be named as pom.xml** and **placed under root folder** of project. 
3. When executing a task or goal, maven reads the POM, gets the needed configuration information, then executes the goal. 

### Super POM
1. POM files **maintain a parent-child relationship between them**. 
2. A**ny pom file, you create for your project will finally be extending this super pom file**. 
3. From maven 2.2 onwards, this is super pom file content.
4.     <project>
        <modelVersion>4.0.0</modelVersion>
        <name>Maven Default Project</name>
        
        <repositories>
            <repository>
            <id>central</id>
            <name>Maven Repository Switchboard</name>
            <layout>default</layout>
            <url>http://repo1.maven.org/maven2</url>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
            </repository>
        </repositories>
        
        <pluginRepositories>
            <pluginRepository>
            <id>central</id>
            <name>Maven Plugin Repository</name>
            <url>http://repo1.maven.org/maven2</url>
            <layout>default</layout>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
            <releases>
                <updatePolicy>never</updatePolicy>
            </releases>
            </pluginRepository>
        </pluginRepositories>
        
        <build>
            <directory>target</directory>
            <outputDirectory>target/classes</outputDirectory>
            <finalName>${artifactId}-${version}</finalName>
            <testOutputDirectory>target/test-classes</testOutputDirectory>
            <sourceDirectory>src/main/java</sourceDirectory>
            <scriptSourceDirectory>src/main/scripts</scriptSourceDirectory>
            <testSourceDirectory>src/test/java</testSourceDirectory>
            <resources>
            <resource>
                <directory>src/main/resources</directory>
            </resource>
            </resources>
            <testResources>
            <testResource>
                <directory>src/test/resources</directory>
            </testResource>
            </testResources>
        </build>
        
        <reporting>
            <outputDirectory>target/site</outputDirectory>
        </reporting>
        
        <profiles>
            <profile>
            <id>release-profile</id>
        
            <activation>
                <property>
                <name>performRelease</name>
                </property>
            </activation>
        
            <build>
                <plugins>
                <plugin>
                    <inherited>true</inherited>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-source-plugin</artifactId>
        
                    <executions>
                    <execution>
                        <id>attach-sources</id>
                        <goals>
                        <goal>jar</goal>
                        </goals>
                    </execution>
                    </executions>
                </plugin>
                <plugin>
                    <inherited>true</inherited>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-javadoc-plugin</artifactId>
        
                    <executions>
                    <execution>
                        <id>attach-javadocs</id>
                        <goals>
                        <goal>jar</goal>
                        </goals>
                    </execution>
                    </executions>
                </plugin>
                <plugin>
                    <inherited>true</inherited>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-deploy-plugin</artifactId>
        
                    <configuration>
                    <updateReleaseInfo>true</updateReleaseInfo>
                    </configuration>
                </plugin>
                </plugins>
            </build>
            </profile>
        </profiles>
        
        </project>

5. Few things to notice are:
    - Default repo is maven repository.
    - Default execution goal is ‘jar’.
    - Default source code location is src/main/java.
    - Default test code location is src/test/java.

### Minimal POM Configuration
1. The minimal POM configuration for any Maven project is extremely simple, which is as follows:
2.      <project>
            <modelVersion>4.0.0</modelVersion>
            <groupId>com.howtodoinjava</groupId>
            <artifactId>MavenExample</artifactId>
            <version>1.0.0</version>
        </project>
3. It requires:
    - project root
    - **modelVersion** – **should be set to 4.0.0**
    - **groupId** – the id of the project’s group.
    - **artifactId** – the id of the artifact (project)
    - **version** – the version of the artifact under the specified group

### Default POM Configuration
1. It **depends on the type of archtype**, you have selected. e.g. for a quickstart project, this is default generated pom.xml file.
2.     <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd;
            <modelVersion>4.0.0</modelVersion>
            
            <groupId>com.howtodoinjava.demo</groupId>
            <artifactId>MavenExamples</artifactId>
            <version>0.0.1-SNAPSHOT</version>
            <packaging>jar</packaging>
            
            <name>MavenExamples</name>
            <url>http://maven.apache.org</url>
        
            <properties>
                <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
            </properties>
        
            <dependencies>
                <dependency>
                <groupId>junit</groupId>
                <artifactId>junit</artifactId>
                <version>3.8.1</version>
                <scope>test</scope>
                </dependency>
            </dependencies>
        </project>

### POM hierarchy
- POM files** maintain a parent-child relationship** between them. 
- A **child POM file inherits all the configuration** elements from its parent POM file. 
- This is how Maven sticks to its design **philosophy, which is convention over configuration**.
- The pom file **used by project is obtained by merging the project pom file, parent pom file (if any) and super pom file**. 
- This pom file is known as effective pom file.
- To get the effective pom file used by project, type below command in project’s root folder:       
        `mvn help:effective-pom`

## Parent Pom (PROJECT OBJECT MODEL)
- Maven parent POM (or super POM) is used to structure the project **to avoid redundancies or duplicate configurations using inheritance between pom files**. 
- It helps in easy maintenance in long term.
- If any dependency or property is **configured in both parent and child POMs with different values then the child POM value will take the priority**.

1. ### Parent POM Contents
- A parent **POM can be declared with packaging pom**. 
- It is **not meant to be distributed** because it is only referenced from other projects.
- Maven parent pom can **contain almost everything and those can be inherited into child** pom files e.g
    - **Common data** – Developers’ names, SCM address, distribution management etc.
    - **Constants** – Such as version numbers
    - **Common dependencies** – Common to all child. It has same effect as writing them several times in individual pom files.
    - **Properties** – For example plugins, declarations, executions and IDs.
    - **Configurations**
    - **Resources**
2. ### Parent POM and Child POM Example
- To match a parent POM, Maven uses two rules:
    - There is a pom file in project’s root directory or in given relative path.
    - Reference from child POM file contains the same coordinates as stated in the parent POM file.

3. ### Parent POM
- Here parent POM has configured basic project information and two dependencies for JUnit and spring framework.
-           <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd;
                <modelVersion>4.0.0</modelVersion>
            
                <groupId>com.howtodoinjava.demo</groupId>
                <artifactId>MavenExamples</artifactId>
                <version>0.0.1-SNAPSHOT</version>
                <packaging>pom</packaging>
            
                <name>MavenExamples Parent</name>
                <url>http://maven.apache.org</url>
            
                <properties>
                    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
                    <junit.version>3.8.1</junit.version>
                    <spring.version>4.3.5.RELEASE</spring.version>
                </properties>
            
                <dependencies>
                
                    <dependency>
                        <groupId>junit</groupId>
                        <artifactId>junit</artifactId>
                        <version>${junit.version}</version>
                        <scope>test</scope>
                    </dependency>
                    
                    <dependency>
                        <groupId>org.springframework</groupId>
                        <artifactId>spring-core</artifactId>
                        <version>${spring.version}</version>
                    </dependency>
                    
                </dependencies>
            </project>

4. ### Child POM
- Now child POM need to refer the parent POM using parent tag and specifying groupId/artifactId/version attributes. 
- This pom file will inherit all properties and dependencies from parent POM and additionally can include extra sub-project specific dependencies as well.
-           <project xmlns="http://maven.apache.org/POM/4.0.0"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
            
                <!--The identifier of the parent POM-->
                <parent>
                    <groupId>com.howtodoinjava.demo</groupId>
                    <artifactId>MavenExamples</artifactId>
                    <version>0.0.1-SNAPSHOT</version>
                </parent>
            
                <modelVersion>4.0.0</modelVersion>
                <artifactId>MavenExamples</artifactId>
                <name>MavenExamples Child POM</name>
                <packaging>jar</packaging>
            
                <dependencies>        
                    <dependency>
                        <groupId>org.springframework</groupId>
                        <artifactId>spring-security</artifactId>
                        <version>${spring.version}</version>
                    </dependency>
                </dependencies>
            
            </project>

5. ### Parent POM Relative Path
- By **default, Maven looks for the parent POM first at project’s root, then the local repository, and lastly in the remote repository**. 
- If parent POM file is not located in any other place, then you can use code tag. This relative path shall be relative to project root.
-           <project xmlns="http://maven.apache.org/POM/4.0.0"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
            
                <!--The identifier of the parent POM-->
                <parent>
                    <groupId>com.howtodoinjava.demo</groupId>
                    <artifactId>MavenExamples</artifactId>
                    <version>0.0.1-SNAPSHOT</version>
                    <relativePath>../baseapp/pom.xml</relativePath>
                </parent>
            
                <modelVersion>4.0.0</modelVersion>
                <artifactId>MavenExamples</artifactId>
                <name>MavenExamples Child POM</name>
                <packaging>jar</packaging>
            
            </project>
