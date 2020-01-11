# Spring core
- Spring is the **container of beans**
- Uses ***Factory Pattern***

## *The IoC container*
1. **IoC is also known as dependency injection** (DI).
2. 

## Dependency Injection
- Dependency injection (DI) is a **process whereby objects define their dependencies, that is, the other objects they work with**, only through **constructor arguments, arguments to a factory method, or properties** that are set on the object instance after it is constructed or returned from a factory method. 
- The **container then injects those dependencies when it creates the bean**. 
- This **process is fundamentally the inverse**, hence the **name Inversion of Control (IoC)**, of the **bean itself controlling the instantiation** or location of its dependencies on its own by using direct construction of classes, or the Service Locator pattern.
- DI exists in two major variants, 
    - **Constructor-based** dependency injection 
    - **Setter-based** dependency injection.
### *1. Constructor-based dependency injection*
- Constructor-based DI is **accomplished by the container invoking a constructor with a number of arguments**, each representing a dependency.
1. **Constructor argument resolution**
    -  If no potential ambiguity exists in the constructor arguments of a bean definition, then the order in which the constructor arguments are defined in a bean definition is the order in which those arguments are supplied to the appropriate constructor when the bean is being instantiated.
    -           package com.deepak;

                public class Foo {

                    public Foo(Bar bar, Baz baz) {
                        // ...
                    }
                }

                <beans>
                    <bean id="foo" class="com.deepak.Foo">
                        <constructor-arg ref="bar"/>
                        <constructor-arg ref="baz"/>
                    </bean>

                    <bean id="bar" class="com.deepak.Bar"/>

                    <bean id="baz" class="com.deepak.Baz"/>
                </beans>

2. **Constructor argument type matching**
    - the container can use type matching with simple types if you explicitly specify the type of the constructor argument using the type attribute
    -           package com.deepak;

                public class ExampleBean {

                    // Number of years to calculate the Ultimate Answer
                    private int years;

                    // The Answer to Life, the Universe, and Everything
                    private String ultimateAnswer;

                    public ExampleBean(int years, String ultimateAnswer) {
                        this.years = years;
                        this.ultimateAnswer = ultimateAnswer;
                    }
                }


                <bean id="exampleBean" class="com.deepak.ExampleBean">
                    <constructor-arg type="int" value="7500000"/>
                    <constructor-arg type="java.lang.String" value="42"/>
                </bean>

3. **Constructor argument index**
    - Use the index attribute to specify explicitly the index of constructor arguments
    -           package com.deepak;

                public class ExampleBean {

                    // Number of years to calculate the Ultimate Answer
                    private int years;

                    // The Answer to Life, the Universe, and Everything
                    private String ultimateAnswer;

                    public ExampleBean(int years, String ultimateAnswer) {
                        this.years = years;
                        this.ultimateAnswer = ultimateAnswer;
                    }
                }


                <bean id="exampleBean" class="com.deepak.ExampleBean">
                    <constructor-arg index="0" value="7500000"/>
                    <constructor-arg index="1" value="42"/>
                </bean>   

### *2. Setter-based dependency injection*
- normal setter 
    -           package com.deepak;

                public class SimpleMovieLister {

                    // the SimpleMovieLister has a dependency on the MovieFinder
                    private MovieFinder movieFinder;

                    // a setter method so that the Spring container can inject a MovieFinder
                    public void setMovieFinder(MovieFinder movieFinder) {
                        this.movieFinder = movieFinder;
                    }

                    // business logic that actually uses the injected MovieFinder is omitted...
                }

                class MovieFinder {
                    private String movieName;
                    private String category;

                    public String getMovieName() {
                        return movieName;
                    }

                    public void setMovieName(String movieName) {
                        this.movieName = movieName;
                    }

                    public String getCategory() {
                        return category;
                    }

                    public void setCategory(String category) {
                        this.category = category;
                    }                    
                }

                <beans>
                    <bean id="movieFinderBean" class="com.deepak.MovieFinder">
                        <property name="movieName" value="Iron Man"/>
                        <property name="category" value="Science-fiction"/>
                    </bean> 

                    <bean id="movieFinderBean" class="com.deepak.SimpleMovieLister">
                        <property name="movieFinder" ref="movieFinderBean"/>
                        <!--validating that the ref bean is present with the name or not using idref -->
                        <property name="movieFinder">
                            <idref="movieFinderBean"/>
                        </property>                            
                    </bean> 
                </beans>

- innerbeans setter :- if the bean is not needed anywhere else and is related to the particular bean
-   A `<bean/>` element inside the `<property/>` or <constructor-arg/> elements defines a so-called inner bean.
    -           <beans>
                    <bean id="movieFinderBean" class="com.deepak.SimpleMovieLister">
                        <property name="movieFinder">
                            <bean class="com.deepak.MovieFinder">
                                <property name="movieName" value="Iron Man"/>
                                <property name="category" value="Science-fiction"/>
                            </bean> 
                        </property>
                    </bean> 
                </beans>    

## Naming a Bean:
1. using **id**
    - it is recomended to use id as it can be used as validation that there is no other bean with the same name.                
    - `<bean id="beanNameId" class="com.deepak.Bean">`
2. using **name**
    - name attribute can also be used to give name to a bean.
    - But it doesnot help in validating, i.e. some other bean can also have same name.
    - `<bean id="beanNameId" class="com.deepak.Bean" name="otherNameForBean">`
3. using **alias**
    - through this we can give a bean another name
    - `<alias name="nameOfTheBean" alias="aliasNameOfTheBean"/>`

## XML shortcut with the p-namespace
- The **p-namespace enables you to use the bean element’s attributes, instead of nested** `<property/>` elements, to describe your property values and/or collaborating beans.
-               <beans xmlns="http://www.springframework.org/schema/beans"
                    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                    xmlns:p="http://www.springframework.org/schema/p"
                    xsi:schemaLocation="http://www.springframework.org/schema/beans
                        http://www.springframework.org/schema/beans/spring-beans.xsd">

                    <bean name="classic" class="com.deepak.ExampleBean">
                        <property name="email" value="foo@bar.com"/>
                    </bean>

                    <bean name="p-namespace" class="com.deepak.ExampleBean"
                        p:email="foo@bar.com"/>

                     <bean name="john-classic" class="com.com.deepak.Person">
                        <property name="name" value="John Doe"/>
                        <property name="spouse" ref="jane"/>
                    </bean>

                    <bean name="john-modern"
                        class="com.deepak.Person"
                        p:name="John Doe"
                        p:spouse-ref="jane"/>

                    <bean name="jane" class="com.deepak.Person">
                        <property name="name" value="Jane Doe"/>
                    </bean>
                </beans>

## XML shortcut with the c-namespace
- Similar to the XML shortcut with the p-namespace, the c-namespace, newly introduced in Spring 3.1, allows usage of inlined attributes for configuring the constructor arguments rather then nested constructor-arg elements.
-               <beans xmlns="http://www.springframework.org/schema/beans"
                    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                    xmlns:c="http://www.springframework.org/schema/c"
                    xsi:schemaLocation="http://www.springframework.org/schema/beans
                        http://www.springframework.org/schema/beans/spring-beans.xsd">

                    <bean id="bar" class="x.y.Bar"/>
                    <bean id="baz" class="x.y.Baz"/>

                    <!-- traditional declaration -->
                    <bean id="foo" class="x.y.Foo">
                        <constructor-arg ref="bar"/>
                        <constructor-arg ref="baz"/>
                        <constructor-arg value="foo@bar.com"/>
                    </bean>

                    <!-- c-namespace declaration -->
                    <bean id="foo" class="x.y.Foo" c:bar-ref="bar" c:baz-ref="baz" c:email="foo@bar.com"/>

                </beans>

## *Collections*
1. The following tags can be used to declare tags:
    - `<list/>   for   List`
    - `<set/>    for   Set`
    - `<map/>    for   Map`
    - `<props/>  for   Properties`  

    -           <beans xmlns="http://www.springframework.org/schema/beans"
                    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                    xsi:schemaLocation="http://www.springframework.org/schema/beans
                    http://www.springframework.org/schema/beans/spring-beans-2.5.xsd">

                    <bean id="CustomerBean" class="com.deepak.common.Customer">

                        <!-- java.util.List -->
                        <property name="lists">
                            <list>
                                <value>1</value>
                                <ref bean="PersonBean" />
                                <bean class="com.deepak.common.Person">
                                    <property name="name" value="deepakList" />
                                    <property name="address" value="address" />
                                    <property name="age" value="28" />
                                </bean>
                            </list>
                        </property>

                        <!-- java.util.Set -->
                        <property name="sets">
                            <set>
                                <value>1</value>
                                <ref bean="PersonBean" />
                                <bean class="com.deepak.common.Person">
                                    <property name="name" value="deepakSet" />
                                    <property name="address" value="address" />
                                    <property name="age" value="28" />
                                </bean>
                            </set>
                        </property>

                        <!-- java.util.Map -->
                        <property name="maps">
                            <map>
                                <entry key="Key 1" value="1" />
                                <entry key="Key 2" value-ref="PersonBean" />
                                <entry key="Key 3">
                                    <bean class="com.deepak.common.Person">
                                        <property name="name" value="deepakMap" />
                                        <property name="address" value="address" />
                                        <property name="age" value="28" />
                                    </bean>
                                </entry>
                            </map>
                        </property>

                        <!-- java.util.Properties -->
                        <property name="pros">
                            <props>
                                <prop key="admin">admin@nospam.com</prop>
                                <prop key="support">support@nospam.com</prop>
                            </props>
                        </property>

                    </bean>

                    <bean id="PersonBean" class="com.deepak.common.Person">
                        <property name="name" value="deepak1" />
                        <property name="address" value="address 1" />
                        <property name="age" value="28" />
                    </bean>

                </beans>        



                // Output
                lists=[
                    1, 
                    Person [address=address 1, age=28, name=deepak1], 
                    Person [address=address, age=28, name=deepakList]
                ] 

                maps={
                    key 1=1,
                    key 2=Person [address=address 1, age=28, name=deepak1], 
                    key 3=Person [address=address, age=28, name=deepakMap]
                }

                pros={admin=admin@nospam.com, support=support@nospam.com} 

                sets=[
                    1, 
                    Person [address=address 1, age=28, name=deepak1], 
                    Person [address=address, age=28, name=deepakSet]
                ]   

2. **Collection merging** 
- The Spring container also supports the merging of collections.
- One can define a parent-style *`<list/>, <map/>, <set/> or <props/>`* element, and have child-style *`<list/>, <map/>, <set/> or <props/>`* elements inherit and override values from the parent collection. 
- The **child collection’s values are the result of merging the elements of the parent and child collections, with the child’s collection elements overriding values specified in the parent collection**. 
-               <beans>
                    <bean id="parent" abstract="true" class="com.deepak.ComplexObject">
                        <property name="adminEmails">
                            <props>
                                <prop key="administrator">administrator@example.com</prop>
                                <prop key="support">support@example.com</prop>
                            </props>
                        </property>
                    </bean>
                    <bean id="child" parent="parent">
                        <property name="adminEmails">
                            <!-- the merge is specified on the child collection definition -->
                            <props merge="true">
                                <prop key="sales">sales@example.com</prop>
                                <prop key="support">support@example.co.uk</prop>
                            </props>
                        </property>
                    </bean>
                <beans>            


                // output
                administrator=administrator@example.com
                sales=sales@example.com
                support=support@example.co.uk

## Null and empty string values
1. **empty string values**
    -           <bean class="ExampleBean">
                    <property name="email" value=""/>
                </bean>
    - equivalent java code:-
                `exampleBean.setEmail("");`

2. **Null value**
    -           <bean class="ExampleBean">
                    <property name="email">
                        <null/>
                    </property>
                </bean>
    - equivalent java code:-
                `exampleBean.setEmail(null);`


## Lazy-initialized beans
1. **By default, ApplicationContext implementations eagerly create and configure all singleton beans as part of the initialization process**. 
2. Generally, this pre-instantiation is desirable, because errors in the configuration or surrounding environment are discovered immediately, as opposed to hours or even days later. 
3. When this behavior is not desirable, you **can prevent pre-instantiation of a singleton bean by marking the bean definition as lazy-initialized**. 
4. A **lazy-initialized bean tells the IoC container to create a bean instance when it is first requested**, rather than at startup.    
    -           <beans>
                    <bean id="lazy" class="com.deepak.ExpensiveToCreateBean" lazy-init="true"/>
                    <bean name="not.lazy" class="com.deepak.AnotherBean"/>
                </beans>
5. When the preceding configuration is consumed by an ApplicationContext, the **bean named lazy is not eagerly pre-instantiated** when the ApplicationContext is starting up, **whereas the not.lazy bean is eagerly pre-instantiated**.  
6. when a **lazy-initialized bean is a dependency of a singleton bean that is not lazy-initialized, the ApplicationContext creates the lazy-initialized bean at startup, because it must satisfy the singleton’s dependencies.** The lazy-initialized bean is injected into a singleton bean elsewhere that is not lazy-initialized.              
7. can also **control lazy-initialization at the container level** by **using the default-lazy-init attribute on the <`beans/>`** element 
    -           <beans default-lazy-init="true">
                    <!-- no beans will be pre-instantiated... -->
                </beans>

## Bean scopes
| **Scope** |	**Description** |       
| --------- | ----------------- |           
| *singleton* | (Default) Scopes a **single bean definition to a single object instance per Spring IoC container**. This singleton is different from the Singleton Pattern as a JVM can have multiple bean conatiner and each bean container can have its own singleton object of same type, but in Singleton Pattern only one instance of a particular class is created per ClassLoader. |     
| *prototype* | Scopes a single bean definition to any number of object instances. `<bean id="accountService" class="com.deepak.DefaultAccountService" scope="prototype"/>`. |      
| *request* | Scopes a single bean definition to the lifecycle of a single HTTP request; that is, each HTTP request has its own instance of a bean created off the back of a single bean definition. Only valid in the context of a web-aware Spring ApplicationContext. |        
| *session* | Scopes a single bean definition to the lifecycle of an HTTP Session. Only valid in the context of a web-aware Spring ApplicationContext. |      
| *application* | Scopes a single bean definition to the lifecycle of a ServletContext. Only valid in the context of a web-aware Spring ApplicationContext. |     
| *websocket* | Scopes a single bean definition to the lifecycle of a WebSocket. Only valid in the context of a web-aware Spring ApplicationContext. |        

### **1. The singleton scope  (for stateless beans)** 
1. Only one shared instance of a singleton bean is managed, and all requests for beans with an id or ids matching that bean definition result in that one specific bean instance being returned by the Spring container.
2. image
3. when you define a bean definition and it is scoped as a singleton, t**he Spring IoC container creates exactly one instance of the object defined by that bean definition**. This **single instance is stored in a cache of such singleton beans, and all subsequent requests and references for that named bean return the cached** object.
5.              <bean id="accountService" class="com.deepak.DefaultAccountService"/>
                <!-- the following is equivalent, though redundant (singleton scope is the default) -->
                <bean id="accountService" class="com.deepak.DefaultAccountService" scope="singleton"/>

6. **Singleton bean V/S the Singleton pattern**
    - Spring’s concept of a singleton bean differs from the Singleton pattern as defined in the Gang of Four (GoF) patterns book. 
    - The **GoF Singleton** hard-codes the scope of an object such that **one and only one instance of a particular class is created per ClassLoader**. 
    - The **scope of the Spring singleton is best described as per container and per bean**. 
    - This means that if you define **one bean for a particular class in a single Spring container, then the Spring container creates one and only one instance of the class defined by that bean definition**. 

### **2.The prototype scope (for all stateful beans)**
1. The non-singleton, prototype scope of bean deployment results in the **creation of a new bean instance every time a request for that specific bean is made**.
2. image
3. The following example defines a bean as a prototype in XML:
    `<bean id="accountService" class="com.foo.DefaultAccountService" scope="prototype"/>`


## Autowiring
1. Autowiring can significantly reduce the need to specify properties or constructor arguments.
2. **Autowiring modes**
    | **Mode** | **Explanation** |                       
    | -------- | --------------- |                                   
    | *no* | (Default) No autowiring. **Bean references must be defined via a ref element**. Changing the default setting is not recommended for larger deployments, because specifying collaborators explicitly gives greater control and clarity. To some extent, it documents the structure of a system. |
    | *byName* | Autowiring by **property name. Spring looks for a bean with the same name as the property that needs to be autowired**. For example, if a bean definition is set to autowire by name, and it contains a master property (that is, it has a setMaster(..) method), Spring looks for a bean definition named master, and uses it to set the property. `<bean id = "textEditor" class = "com.deepak.TextEditor" autowire = "byName">`|
    | *byType* | Allows a property to be autowired **if exactly one bean of the property type exists in the container**. If more than one exists, a fatal exception is thrown, which indicates that you may not use byType autowiring for that bean. If there are no matching beans, nothing happens; the property is not set. `<bean id = "textEditor" class = "com.deepak.TextEditor" autowire = "byType">`|
    | *constructor* | **Analogous to byType, but applies to constructor arguments**. If there is not exactly one bean of the constructor argument type in the container, a fatal error is raised. `<bean id = "textEditor" class = "com.deepak.TextEditor" autowire = "constructor">`|

## Bean definition inheritance
1. A bean definition can contain a lot of configuration information, including constructor arguments, property values, and container-specific information such as initialization method, static factory method name, and so on.
2. A child bean definition inherits configuration data from a parent definition. The child definition can override some values, or add others, as needed.
3. Spring Bean definition inheritance has nothing to do with Java class inheritance but the inheritance concept is same. You can define a parent bean definition as a template and other child beans can inherit the required configuration from the parent bean.
4. When you use XML-based configuration metadata, you indicate a child bean definition by using the parent attribute, specifying the parent bean as the value of this attribute.
    - Beans.xml
    -           <beans xmlns = "http://www.springframework.org/schema/beans"
                xmlns:xsi = "http://www.w3.org/2001/XMLSchema-instance"
                xsi:schemaLocation = "http://www.springframework.org/schema/beans
                http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

                    <bean id = "helloWorld" class = "com.deepak.HelloWorld">
                        <property name = "message1" value = "Hello World!"/>
                        <property name = "message2" value = "Hello Second World!"/>
                    </bean>

                    <bean id ="helloIndia" class = "com.deepak.HelloIndia" parent = "helloWorld">
                        <property name = "message1" value = "Hello India!"/>
                        <property name = "message3" value = "Namaste India!"/>
                    </bean>
                </beans> 
5. You can create a Bean definition template, which can be used by other child bean definitions without putting much effort. While defining a Bean Definition Template, you **should not specify the class attribute and should specify abstract attribute** and **should specify the abstract attribute with a value of true**
6. By making **abstract="true" the spring will not create a bean for that but will use it as a definition template**.
7. The **parent bean cannot be instantiated on its own because it is incomplete**, and it is also **explicitly marked as abstract**. When a definition is abstract like this, it is usable only as a pure template bean definition that serves as a parent definition for child definitions.
    - Beans.xml
    -           <beans xmlns = "http://www.springframework.org/schema/beans"
                xmlns:xsi = "http://www.w3.org/2001/XMLSchema-instance"
                xsi:schemaLocation = "http://www.springframework.org/schema/beans
                http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

                    <bean id = "beanTeamplate" abstract = "true">
                        <property name = "message1" value = "Hello World!"/>
                        <property name = "message2" value = "Hello Second World!"/>
                        <property name = "message3" value = "Namaste India!"/>
                    </bean>

                    <bean id = "helloIndia" class = "com.deepak.HelloIndia" parent = "beanTeamplate">
                        <property name = "message1" value = "Hello India!"/>
                        <property name = "message3" value = "Namaste India!"/>
                    </bean>
                
                </beans>  

    -           <beans xmlns:aop="http://www.springframework.org/schema/aop" xmlns:p="http://www.springframework.org/schema/p" 
                xmlns:security="http://www.springframework.org/schema/security" xmlns:tx="http://www.springframework.org/schema/tx" 
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.springframework.org/schema/beans" 
                xsi:schemalocation="http://www.springframework.org/schema/beans">
                
                    <bean class="com.deepak.beanDefInherit.tutorial.Triangle" id="parentTriangle">
                        <property name="pointA" ref="pointA"></property>
                    </bean>
                    <bean class="com.deepak.beanDefInherit.tutorial.Triangle" id="triangle1" parent="parentTriangle">
                        <property name="pointB" ref="pointB"></property>
                        <property name="pointC" ref="pointC"></property>
                    </bean>
                    
                    <bean class="com.deepak.beanDefInherit.tutorial.Triangle" id="triangle2" parent="parentTriangle">
                        <property name="pointB" ref="pointB"></property>
                    </bean>
                    
                    <bean class="com.deepak.beanDefInherit.tutorial.Point" id="pointA">
                        <property name="x" value="0"></property>
                        <property name="y" value="0"></property>
                    </bean>
                    
                    <bean class="com.deepak.beanDefInherit.tutorial.Point" id="pointB">
                        <property name="x" value="-20"></property>
                        <property name="y" value="0"></property>
                    </bean>
                    
                    <bean class="com.deepak.beanDefInherit.tutorial.Point" id="pointC">
                        <property name="x" value="20"></property>
                        <property name="y" value="0"></property>
                    </bean>
                </beans>  

## Singleton bean having prototype dependencies
1. Since all the dependecies are resolved at the time of bean creation do, the singleton bean having dependecy of prototype will also be intialized at the time of creation. So to **get the context by implementing ApplicationContextAware** so that by calling context.get() gets the new bean.
2. **BeanNameAware** **to get the name of the Bean**
3.              package com.deepak.contextAware.tutorial;

                import org.springframework.beans.BeansException;
                import org.springframework.beans.factory.BeanNameAware;
                import org.springframework.context.ApplicationContext;
                import org.springframework.context.ApplicationContextAware;

                public class Triangle implements ApplicationContextAware, BeanNameAware  {
                    private Point pointA;
                    private Point pointB;
                    private Point pointC;
                    private ApplicationContext context = null;
                    
                    /**
                    * @param pointA the pointA to set
                    */
                    public void setPointA(Point pointA) {
                        this.pointA = pointA;
                    }

                    /**
                    * @param pointB the pointB to set
                    */
                    public void setPointB(Point pointB) {
                        this.pointB = pointB;
                    }

                    /**
                    * @param pointC the pointC to set
                    */
                    public void setPointC(Point pointC) {
                        this.pointC = pointC;
                    }

                    public void draw() {
                        System.out.println("PointA is ("+pointA.getX()+", "+pointA.getY()+")");
                        System.out.println("PointB is ("+pointB.getX()+", "+pointB.getY()+")");
                        System.out.println("PointC is ("+pointC.getX()+", "+pointC.getY()+")");
                    }

                    @Override
                    public void setApplicationContext(ApplicationContext context) throws BeansException {
                        this.context = context;
                    }

                    @Override
                    public void setBeanName(String beanName)  {
                        System.out.println("Bean name is: "+beanName);
                    }
                }

## Lifecycle Callbacks
1. **Shutdown hooks**
    - to close the context when main() method ends(particulary for Desktop Application because in wen app or enterprise app the spring knows when to end)
    - to implement destroy method registering Shutdown hook is imp.
    - destroy() gets called when main() ends.
    - **AbstractApplicationContext class has the method to register Shutdownhook**.
    - `AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");`
    - `context.registerShutdownHook();`

2. **Initialization callbacks**
    - By **implementing interface InitializingBean** 
    - Implementing the org.springframework.beans.factory.InitializingBean interface **allows a bean to perform initialization work after all necessary properties on the bean are set by the container**. The InitializingBean interface **specifies exactly one method**:
    - `void afterPropertiesSet() throws Exception`
    -           public class Triangle implements InitializingBean {
                    @Override
                    public void afterPropertiesSet() throws Exception {
                        //To do some initialization works here
                        System.out.println("InitializingBean init method is called for Triangle");
                    }
                } 
    - **Use of the InitializingBean interface can be avoided** (and is discouraged since it unnecessarily **couples the code to Spring**)
    - XML-based configuration metadata, we **can use the init-method attribute to specify the name of the method that has a void no-argument signature**
    - `<bean class="com.deepak.callbackLifecycle.tutorial.Triangle" init-method="myInit" id="triangle"/>`
    -           public class Triangle {
                    public void myInit() {
                        //To do some initialization works here
                        System.out.println("My init method is called for Triangle");
                    }
                } 
      
3. **Destruction callbacks**
    - Implementing the org.springframework.beans.factory.**DisposableBean interface allows a bean to get a callback when the container containing it is destroyed**. 
    - The DisposableBean interface specifies one method.
    - `void destroy() throws Exception`
    -           public class Triangle implements DisposableBean {
                    @Override
                    public void destroy() throws Exception {
                        //To do some Destruction works here
                        System.out.println("DisposableBean destroy method is called for Triangle");
                    }
                }   
    - **Use of the DisposableBean marker interface can be avoided** (and is discouraged since it unnecessarily **couples the code to Spring**)  
    - XML-based configuration metadata, we **can use the destroy-method attribute to specify the name of the method that has a void no-argument signature.**  
    - `<bean class="com.deepak.callbackLifecycle.tutorial.Triangle" destroy-method="cleanUp" id="triangle"/>`
    -           public class Triangle {
                    public void cleanUp() {
                        //To do some Destruction works here
                        System.out.println("cleanUp method is called for Triangle");
                    }
                } 
4. **If want to have global init-method and destroy-method for all the bean having the same method name in all the bean for respective function**
    `<beans default-init-method="myInit" default-destroy-method="cleanUp" >   </beans>`
5. **Methods of InitializingBean and DisposableBean interface get priority over init-method and destroy-method**  .


## BeanPostProcessor
- *Recomended*: **To extend the framework related functionality** (configuration ralated coding)
- A BeanPostProcessor **gives you a chance to process an instance of a bean created by the IoC container after it’s instantiation and then again after the initialization life cycle event has occurred on the instance**.
- **A BeanPostProcessor methods executes after the init-method or afterPropertiesSet() of InitializingBean interface has executed**.
- You could use this to process fields that were set, perform validation on a bean, or even look up values from a remote resource to set on the bean as defaults.
- **Spring’s different AOP proxies for caching, transactions, etc. are all applied by BeanPostProcessor** .
- BeanPostProcessor interface has two method…
    1. `postProcessAfterInitialization(Object bean, String beanName)` 
        - **execute after initialization of each beans in the Spring IoC Container**.
    2. `postProcessBeforeInitialization(Object bean, String beanName)` 
        - **execute before initialization of each beans in the Spring IoC Container**.
- **Note:-** But this bean also has to be registered as bean in spring.xml file. and this will run for all the beans.
-               import org.springframework.beans.BeansException;
                import org.springframework.beans.factory.config.BeanPostProcessor;

                public class DisplayNameBeanPostProcessor implements BeanPostProcessor {  
                    @Override
                    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                        System.out.println("In After bean Initialization method. Bean name is "+beanName);
                        return bean;
                    }

                    @Override
                    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                        System.out.println("In Before bean Initialization method. Bean name is "+beanName);
                        return bean;
                    }
                }


## BeanFactoryPostProcessor
1. A   bean   factory    post-processor    is    a    java   class    which   i**mplements   the org.springframework.beans.factory.config.BeanFactoryPostProcessor** interface which has a method postProcessBeanFactory `public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException`
2. It is executed manually (in the case of the BeanFactory) or automatically (in the case of the ApplicationContext) to apply changes of some sort to an entire BeanFactory, after it has been constructed.
3. To use **this with a BeanFactory**, the **bean factory post-processor is manually executed** on it:
    -           XmlBeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
                PropertyPlaceholderConfigurer cfg = new PropertyPlaceholderConfigurer();
                cfg.setLocation(new FileSystemResource("databaseConfig.properties"));
                cfg.postProcessBeanFactory(factory);
4. To use **this with a ApplicationContext**, the **bean factory post-processor is automatically executed** on it:
    -           ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
5.              import org.springframework.beans.BeansException;
                import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
                import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
                import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
                import org.springframework.core.io.FileSystemResource;

                public class BeanFactoryPPDemo implements BeanFactoryPostProcessor  {
                    @Override
                    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
                        PropertyPlaceholderConfigurer cfg = new PropertyPlaceholderConfigurer();  
                        cfg.setLocation(new FileSystemResource("shape.properties"));  
                        cfg.postProcessBeanFactory(beanFactory); 
                        System.out.println("Bean factory post processor is initialized");
                    }
                }
6. **Spring includes a number of pre-existing bean factory post-processors**, such as given below.
    - *PropertyResourceConfigurer* 
    - *PropertyPlaceHolderConfigurer*
        - bean factory post-processor, is **used to externalize some property values from a BeanFactory definition, into another separate file in Java Properties** format
        - This is useful to **allow to developer to declare some key property as properties file**. 
        -       // datasource.properties
                jdbc.driverClassName=com.mysql.jdbc.Driver
                jdbc.url=jdbc:mysql://davproductionDB:3306
                jdbc.username=root
                jdbc.password=root

                // spring.xml
                <beans>
                    <bean class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close" id="dataSource">
                        <property name="driverClassName" value="${jdbc.driverClassName}" />
                        <property name="url" value="${jdbc.url}" />
                        <property name="username" value="${jdbc.username}" />
                        <property name="password" value="${jdbc.password}" />
                    </bean>

                    <bean class="org.springframework.beans.factory.config.PropertyPlaceHolderConfigurer" >
                        <property name="locations" value="datasource.properties">
                    </bean>
                </beans>

## The differences about BeanFactoryPostProcessor and BeanPostProcessor:
| **Sno** | **BeanFactoryPostProcessor** | **BeanPostProcessor** |                
| ------- | ---------------------------- | --------------------- |                
| 1. | A bean implementing BeanFactoryPostProcessor is **called when all bean definitions will have been loaded, but no beans will have been instantiated yet**. This allows for overriding or adding properties even to eager-initializing beans. This will let you have access to all the beans that you have defined in XML or that are annotated (scanned via component-scan). | A bean implementing BeanPostProcessor **operate on bean (or object) instances which means that when the Spring IoC container instantiates a bean instance then BeanPostProcessor interfaces do their work**. |
| 2. | BeanFactoryPostProcessor implementations are **"called" during startup of the Spring context after all bean definitions will have been loaded** |  BeanPostProcessor are **"called" when the Spring IoC container instantiates a bean** (i.e. during the startup for all the singleton and on demand for the proptotypes one). |

3. image