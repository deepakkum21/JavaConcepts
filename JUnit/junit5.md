# JUnit5

## What??
- JUnit is a **unit testing framework** for Java programming language.

## Features
- JUnit is an **open source framework**, which is used for writing and running tests.
- **Provides annotations to identify test methods**.
- Provides **assertions for testing expected results**.
- Provides **test runners for running tests**.
- JUnit tests allow you to write codes faster, which increases quality.
- JUnit is elegantly simple. It is less complex and takes less time.
- JUnit tests can be run automatically and they check their own results and provide immediate feedback. There's no need to manually comb through a report of test results.
- JUnit tests can be organized into test suites containing test cases and even other test suites.
- JUnit shows test progress in a bar that is green if the test is running smoothly, and it turns red when a test fails.
- **creates a new test instance for every test case**.


## JUnit 5 vs JUnit 4
1. **JUnit 5 vs JUnit 4 – Annotations**  

| **FEATURE**	| **JUNIT 4**	| **JUNIT 5** |                            
| ------------- | ------------- | ----------- |                 
| Declare a test method |	@Test |	@Test |
| Execute before all test methods in the current class |	@BeforeClass |	@BeforeAll |
| Execute after all test methods in the current class |	@AfterClass |	@AfterAll |
| Execute before each test method |	@Before |	@BeforeEach |
| Execute after each test method |	@After |	@AfterEach |
| Disable a test method / class |	@Ignore |	@Disabled |
| Test factory for dynamic tests |	NA |	@TestFactory |
| Nested tests |	NA |	@Nested |
| Tagging and filtering |	@Category |	@Tag |
| Register custom extensions |	NA |	@ExtendWith |

2. **Method**
- **asertAll()** which accepts lambdas of all asert which you want to have i.e. list of assert.
-           assertAll(
                    () -> assertEquals(2, MathUtils.add(1,1)),
                    () -> assertEquals(6, MathUtils.add(5,1)),
                    () -> assertEquals(23, MathUtils.add(12,11)),
            );

3. **Architecture**
- **JUnit 4 has everything bundled into single jar file**.
- **Junit 5 is composed of 3 sub-projects** i.e. JUnit Platform, JUnit Jupiter and JUnit Vintage.
`JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage`
    - ### JUnit Platform
        - It defines the **TestEngine API for developing new testing frameworks that runs on the platform**.

    - ### JUnit Jupiter
        - It has **all new junit annotations and TestEngine implementation to run tests written with these annotations**.
        - being called jupiter as it is %th planet and junit5. 

    - ### JUnit Vintage
        - To **support running JUnit 3 and JUnit 4 written tests on the JUnit 5 platform**.

4. **Required JDK Version**
    - Junit **4 requires Java 5 or higher**.
    - Junit **5 requires Java 8 or higher**.   

5. **3rd Party Integration**
- In Junit 4, **there is no integration support for 3rd party plugins and IDEs**. They have to rely on reflection.
- **JUnit 5 has dedicated sub-project for this purpose i.e. JUnit Platform**. It defines the TestEngine API for developing a testing framework that runs on the platform.    

## Pom Dependency
-       <dependencies>
                <dependency>
                    <groupId>org.junit.jupiter</groupId>
                    <artifactId>junit-jupiter-engine</artifactId>
                    <version>5.4.0</version>
                    <scope>test</scope>
                </dependency>
                <dependency>
                    <groupId>org.junit.jupiter</groupId>
                    <artifactId>junit-jupiter-api</artifactId>
                    <version>5.4.0</version>
                    <scope>test</scope>
                </dependency>
        </dependencies>

## Maven Plugin
-       <build>
            <plugins>
                <plugin>
                    <artifactId>maven-surefire-plugin</artifactId>
                    <version>2.22.1</version>
                </plugin>
            </plugins>
        </build>


## JUnit 5 Annotations

| **ANNOTATION** |	**DESCRIPTION** |
| -------------- | ---------------- |                       
| @BeforeEach |	The annotated method will be run before each test method in the test class.|
| @AfterEach |	The annotated method will be run after each test method in the test class. |
| @BeforeAll |	The annotated method will be run before all test methods in the test class. This method must be static. **methods having this needs to be static since the method will be called before the class even is initiallized. so only by making it as static it can be called**. |
| @AfterAll |	The annotated method will be run after all test methods in the test class. This method must be static. |
| @Test |	It is used to mark a method as junit test |
| @DisplayName |	Used to provide any custom display name for a test class or test method |
| @Disabled |	It is used to disable or ignore a test class or method from test suite. |
| @Nested |	Used to create nested test classes |
| @Tag |	Mark test methods or test classes with tags for test discovering and filtering |
| @TestFactory |	Mark a method is a test factory for dynamic tests |
| @TestInstance | **accepts a enum (TestInstance.Lifecycle.PER_CLASS) to override the default behavior of creating a new test instance per method. In this case for @BeforeAll no need to have a static method**. |
| @DisplayName | to give a meaningful to your test case, by default the test case name is the method name | 
| @EnabledOnOs(OS.LINUX) | enabled on that certain OS |
| @EnabledOnJre(JRE.JAVA_11) | enabled for that certain JRE |
| @EnabledIf | |
| @EnabledIfSystemProperty | |
| @EnabledIfEnvironmentVariable | |

## JUnit 5 Test LifeCycle
- test lifecycle is **driven by 4 primary annotations i.e. @BeforeAll, @BeforeEach, @AfterEach and @AfterAll**. Along with it, each test method must be marked with @Test annotation. @Test annotation is virtually unchanged, although it no longer takes optional arguments.
- **In JUnit, for each test – a new instance of test is created**. 
- **@BeforeAll** and **@AfterAll annotations** – clear by their name – **should be called only once in entire tests execution cycle**. **So they must be declared static.**
- If their are **multiple methods annotated with same annotation (e.g. two methods with @BeforeAll) then their execution order is undetermined**.
-           public class AppTest {
                
                // should be called only conce and should be static
                @BeforeAll
                static void setup(){
                    System.out.println("@BeforeAll executed");
                }
                
                // can be called multiple times but order is not fixed
                @BeforeEach
                void setupThis(){
                    System.out.println("@BeforeEach executed");
                }
                
                @Test
                void testCalcOne() {
                    System.out.println("======TEST ONE EXECUTED=======");
                    Assertions.assertEquals( 4 , Calculator.add(2, 2));
                }
                
                @Test
                void testCalcTwo() {
                    System.out.println("======TEST TWO EXECUTED=======");
                    Assertions.assertEquals( 6 , Calculator.add(2, 4));
                }
                
                @AfterEach
                void tearThis(){
                    System.out.println("@AfterEach executed");
                }
                
                // should be called only conce and should be static
                @AfterAll
                static void tear(){
                    System.out.println("@AfterAll executed");
                }
            }

## JUnit 5 Assumptions
1. JUnit 5 Assumptions class **provides static methods to support conditional test execution based on assumptions**. 
2. A **failed assumption results in a test being aborted**. 
3. Assumptions are typically **used whenever it does not make sense to continue execution of a given test method**. eg. **it is irrelevant to run a test when a server is down. So, server condition can be put in assumeTrue()**. In test report, these test will be marked as passed.
4. JUnit jupiter Assumptions class has two such methods: 
    - **assumeFalse()**
        - validates the given assumption to false and if assumption is false – test proceed, otherwise test execution is aborted. It works just opposite to assumeTrue()
    - **assumeTrue()**.
        - validates the given assumption to true and if assumption is true – test proceed, otherwise test execution is aborted

### **A. Assumptions.assumeTrue()**
1. **validates the given assumption to true** and **if assumption is true – test proceed, otherwise test execution is aborted**.
2. It has following overloaded methods.
    - public static void assumeTrue(boolean assumption) throws TestAbortedException
    - public static void assumeTrue(boolean assumption, Supplier<String> messageSupplier) throws TestAbortedException
    - public static void assumeTrue(boolean assumption, String message) throws TestAbortedException
    - public static void assumeTrue(BooleanSupplier assumptionSupplier) throws TestAbortedException
    - public static void assumeTrue(BooleanSupplier assumptionSupplier, String message) throws TestAbortedException
    - public static void assumeTrue(BooleanSupplier assumptionSupplier, Supplier<String> messageSupplier) throws TestAbortedException
3.      package com.deepak.jnuit5;

        import org.junit.jupiter.api.Assumptions;
        import org.junit.jupiter.api.DisplayName;
        import org.junit.jupiter.api.Test;

        public class Demo {

            @Test
            @DisplayName("test for Dev Env")
            void testOnDev() {
                System.setProperty("ENV", "DEV");
                Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")));
                //remainder of test will proceed
                System.out.println("Dev test run success " + System.getProperty("ENV"));
            }
            
            @Test
            @DisplayName("test for Prod Env")
            void testOnProd() {
                System.setProperty("ENV", "PROD");
                Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")), Demo::message);  
                //remainder of test will be aborted
                System.out.println("prod test run success " + System.getProperty("ENV"));
            }
            
            private static String message () {
                return "TEST Execution Failed :: ";
            }
        }

### **B. Assumptions.assumeFalse()**
1. **validates the given assumption to false and if assumption is false – test proceed, otherwise test execution is aborted**. It works just opposite to assumeTrue().
2. It has following overloaded methods.
    - public static void assumeFalse(boolean assumption) throws TestAbortedException
    - public static void assumeFalse(boolean assumption, Supplier<String> messageSupplier) throws TestAbortedException
    - public static void assumeFalse(boolean assumption, String message) throws TestAbortedException
    - public static void assumeFalse(BooleanSupplier assumptionSupplier) throws TestAbortedException
    - public static void assumeFalse(BooleanSupplier assumptionSupplier, String message) throws TestAbortedException
    - public static void assumeFalse(BooleanSupplier assumptionSupplier, Supplier<String> messageSupplier) throws TestAbortedException
3.          public class AppTest {
                @Test
                void testOnDev() {
                    System.setProperty("ENV", "DEV");
                    Assumptions.assumeFalse("DEV".equals(System.getProperty("ENV")), AppTest::message);
                    //remainder of test will be aborted
                }
                
                @Test
                void testOnProd() {
                    System.setProperty("ENV", "PROD");
                    Assumptions.assumeFalse("DEV".equals(System.getProperty("ENV")));
                    //remainder of test will proceed
                    
                }
                
                private static String message () {
                    return "TEST Execution Failed :: ";
                }
            }

## JUnit 5 expected exception – assertThrows()
- **to test exception cases** you should use org.junit.jupiter.api.Assertions.assertThrows() method. 
### **1. Syntax of Junit 5 assertThrows()**
`public static <T extends Throwable> T assertThrows(Class<T> expectedType, Executable executable)`
- If **no exception is thrown, or if an exception of a different type is thrown, this method will fail.**
- **that exception of same types are allowed**. e.g. If you are expecting NumberFormatException and it throws IllegalArgumentException then also the test will PASS because **NumberFormatException extends IllegalArgumentException class**. 

### **2. JUnit 5 expected exception example**
-           @Test
            void testExpectedException() {                
                Assertions.assertThrows(NumberFormatException.class, () -> {
                    Integer.parseInt("One");
                }); 
            }
- Here executable code is Integer.parseInt("One") throws NumberFormatException if argument is not a valid number. In above code, "One" is not a valid number so code will throw exception, which the assertThrows() method expects – so the test passes.

### **3. Expecting super types of exception class**
- You can expect the super types of exception class as well. e.g. above test can be written with IllegalArgumentException also.
-           @Test
            void testExpectedExceptionWithSuperType() {            
                Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    Integer.parseInt("One");
                });            
            }

## JUnit 5 @RepeatedTest Annotation
- **enable to write repeatable test templates which could be run multiple times**. 
- The frequency can be configured as parameter to @RepeatedTest annotation.
-           @DisplayName("Add operation test")
            @RepeatedTest(5)
            void addNumber(TestInfo testInfo) {
                Calculator calculator = new Calculator();
                Assertions.assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
            }

- Invocation of a repeated test **behaves like the execution of a regular @Test** method with **full support for the same lifecycle callbacks** and extensions. It means that **@BeforeEach and @AfterEach annotated methods will be invoked where they fit in test life cycle**, for each individual invocation.
-           public class RepeatedTestExample {
                
                @BeforeAll
                public static void init(){
                    System.out.println("Before All init() method called");
                }
                
                @BeforeEach
                public void initEach(){
                    System.out.println("Before Each initEach() method called");
                }
            
                @DisplayName("Add operation test")
                @RepeatedTest(5)
                void addNumber(TestInfo testInfo, RepetitionInfo repetitionInfo) 
                {
                    System.out.println("Running addNumber test -> " + repetitionInfo.getCurrentRepetition());
                    Assertions.assertEquals(2, Calculator.add(1, 1), "1 + 1 should equal 2");
                }
                
                @AfterEach
                public void cleanUpEach(){
                    System.out.println("After Each cleanUpEach() method called");
                }
                
                @AfterAll
                public static void cleanUp(){
                    System.out.println("After All cleanUp() method called");
                }
            }
-           // output of above code
            Before All init() method called

            Before Each initEach() method called
            After Each cleanUpEach() method called

            Before Each initEach() method called
            Running addNumber test -> 1
            After Each cleanUpEach() method called

            Before Each initEach() method called
            Running addNumber test -> 2
            After Each cleanUpEach() method called

            Before Each initEach() method called
            Running addNumber test -> 3
            After Each cleanUpEach() method called

            Before Each initEach() method called
            Running addNumber test -> 4
            After Each cleanUpEach() method called

            Before Each initEach() method called
            Running addNumber test -> 5
            After Each cleanUpEach() method called

            After All cleanUp() method called
### **A.Custom Display Test Names**
1. Apart from specifying the number of repetitions, you **can give a custom display name to each repetition**. This custom display name **can be combination of static text + dynamic place holders**. Currently, 3 place holders are supported:
    - **{displayName}**: display name of the @RepeatedTest method.
    - **{currentRepetition}**: the current repetition count.
    - **{totalRepetitions}**: the total number of repetitions.
2.          public class JUnit5AnnotationsExample {
                @DisplayName("Add operation test")
                @RepeatedTest(value = 5, name = "{displayName} - repetition {currentRepetition} of {totalRepetitions}")
                void addNumber(TestInfo testInfo) {
                    Assertions.assertEquals(2, Calculator.add(1, 1), "1 + 1 should equal 2");
                }
            }

### **B. RepetitionInfo interface**
1. RepetitionInfo is **used to inject information about the current repetition of a repeated test into @RepeatedTest, @BeforeEach, and @AfterEach** methods.
2.          public class JUnit5AnnotationsExample {
                
                @BeforeEach
                public void initEach(RepetitionInfo info){
                    int currentRepetition = info.getCurrentRepetition();
                    int totalRepetitions = info.getTotalRepetitions();
                    //Use information as needed
                }
            
                @DisplayName("Add operation test")
                @RepeatedTest(value = 5, name="{displayName} :: repetition {currentRepetition} of {totalRepetitions}")
                void addNumber(TestInfo testInfo) {
                    Calculator calculator = new Calculator();
                    Assertions.assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
                }
                
                @AfterEach
                public void cleanUpEach(RepetitionInfo info){
                    int currentRepetition = info.getCurrentRepetition();
                    int totalRepetitions = info.getTotalRepetitions();
                    //Use information as needed
                }
            }

## JUnit 5 @Nested Tests
1. Unit Jupiter **@Nested annotation can be used to mark a nested class to be included in the test cases**.
2. When JUnit tests are executed, **Nested classes are not scanned for test methods**. We can **explicitly mark them to be scanned for test cases using @Nested** annotation.
3. Can give different display namest odifferent test cases in the innerclass.
-           public class NestedTestSimpleExample {
                @Test
                void test() {
                    System.out.println("Outer Class Test");
                }                
                @Nested
                class InnerClass {                    
                    @Test
                    void test() {
                        System.out.println("Inner Class Test");
                    }
                }
            }
            // If we remove @Nested annotation from the inner class, then the tests inside that will not be executed.

4. **JUnit Nested Tests Callback Methods**
- Nested test classes **can have their own @BeforeEach and @AfterEach methods**. 
- However, **if outer class @BeforeEach and @AfterEach methods will also get executed for nested class tests**. 
-           public class NestedTestSimpleExample {

                @BeforeAll
                static void setUpBeforeClass() throws Exception {
                    System.out.println("@BeforeAll - Outer Class");
                }

                @AfterAll
                static void tearDownAfterClass() throws Exception {
                    System.out.println("@AfterAll - Outer Class");
                }

                @BeforeEach
                void setUp() throws Exception {
                    System.out.println("@BeforeEach - Outer Class");
                }

                @AfterEach
                void tearDown() throws Exception {
                    System.out.println("@AfterEach - Outer Class");
                }
                
                @Test
                void test() {
                    System.out.println("Outer Class Test");
                }
                
                @Nested
                class InnerClass {
                    @BeforeEach
                    void setUp() throws Exception {
                        System.out.println("@BeforeEach - Inner Class");
                    }

                    @AfterEach
                    void tearDown() throws Exception {
                        System.out.println("@AfterEach - Inner Class");
                    }
                    
                    @Test
                    void test1() {
                        System.out.println("Inner Class Test 1");
                    }

                    @Test
		            void test2() {
			            System.out.println("Inner Class Test 2");
		            }
                }
            }

            // output
            @BeforeAll - Outer Class
            @BeforeEach - Outer Class
            Outer Class Test
            @AfterEach - Outer Class
            @BeforeEach - Outer Class
            @BeforeEach - Inner Class
            Inner Class Test 1
            @AfterEach - Inner Class
            @AfterEach - Outer Class
            @BeforeEach - Outer Class
            @BeforeEach - Inner Class
            Inner Class Test 2
            @AfterEach - Inner Class
            @AfterEach - Outer Class
            @AfterAll - Outer Class
- If we **want @BeforeAll and @AfterAll methods in the nested test** class, then we have to **explicitly set its lifecycle behavior to “per-class”**. The default behavior of JUnit test cases is “per-method”.
-           public class NestedExampleTest  {
                
                @BeforeAll
                static void setUpBeforeClass() throws Exception {
                    System.out.println("@BeforeAll - Outer Class");
                }

                @AfterAll
                static void tearDownAfterClass() throws Exception {
                    System.out.println("@AfterAll - Outer Class");
                }

                @BeforeEach
                void setUp() throws Exception {
                    System.out.println("@BeforeEach - Outer Class");
                }

                @AfterEach
                void tearDown() throws Exception {
                    System.out.println("@AfterEach - Outer Class");
                }

                @Test
                void outer_test() {
                    System.out.println("Outer Class test method");
                }

                @Nested
                @TestInstance(Lifecycle.PER_CLASS)
                class InnerClass {
                    @BeforeAll
                    void setUpBeforeClassInner() throws Exception {
                        System.out.println("@BeforeAll - Inner Class");
                    }

                    @AfterAll
                    void tearDownAfterClassInner() throws Exception {
                        System.out.println("@AfterAll - Inner Class");
                    }

                    @BeforeEach
                    void setUp() throws Exception {
                        System.out.println("@BeforeEach - Inner Class");
                    }

                    @AfterEach
                    void tearDown() throws Exception {
                        System.out.println("@AfterEach - Inner Class");
                    }

                    @Test
                    void inner_test1() {
                        System.out.println("Inner Class test method 1");
                    }
                    
                    @Test
                    void inner_test2() {
                        System.out.println("Inner Class test method 2");
                    }
                }
            }

            // OUTPUT
            @BeforeAll - Outer Class
            @BeforeEach - Outer Class
            Outer Class test method
            @AfterEach - Outer Class
            @BeforeAll - Inner Class
            @BeforeEach - Outer Class
            @BeforeEach - Inner Class
            Inner Class test method 1
            @AfterEach - Inner Class
            @AfterEach - Outer Class
            @BeforeEach - Outer Class
            @BeforeEach - Inner Class
            Inner Class test method 2
            @AfterEach - Inner Class
            @AfterEach - Outer Class
            @AfterAll - Inner Class
            @AfterAll - Outer Class

## using supplier for the assert messages
- Messages passed in the assert(expedcted, actual, message) is displayed when the test fails.
- But the parameter or the message is consumed and complied before checking the test passed or failed.
- if message parameter takes more resources and test passes no point of giving that message and wasting resources.
- So, we should use lazy message loading using lambda ie it will be executed when the test fails as it is like a method only.
` assertEquals(expected, actual, () -> System.out.println("Failed"));`

## JUnit 5 @Tag Annotation
- JUnit 5 @Tag can be **used to filter testcases from test plans**. 
- It can **help in create multiple different test plans for different environments**, different use-cases or any specific requirement. 
- You **can execute set of tests by including only those tagged tests in test plan** OR by **excluding other tests from test plan**.

### **1. @Tag Annotation Usage**
- We can apply the @Tag annotation on test class or test method or both.
-           @Tag("development")
            public class ClassATest {
                @Test
                @Tag("userManagement")
                void testCaseA(TestInfo testInfo) {
                }
            }
- We **can apply multiple tags on single test case as well**, so that you can include it in multiple test plans.
-           public class ClassATest {
                @Test
                @Tag("development")
                @Tag("production")
                void testCaseA(TestInfo testInfo) {
                }
            }

### **2. Create test plans with @IncludeTags and @ExcludeTags**
- We can **use @IncludeTags or @ExcludeTags annotations in your testplan to filter tests or include tests**.
-           //@IncludeTags example
            
            @RunWith(JUnitPlatform.class)
            @SelectPackages("com.deepak.junit5.examples")
            @IncludeTags("production")
            public class MultipleTagsExample {
            }
            
            //@ExcludeTags example
            
            @RunWith(JUnitPlatform.class)
            @SelectPackages("com.deepak.junit5.examples")
            @ExcludeTags("production")
            public class MultipleTagsExample {
            }
- **We CAN NOT include both @IncludeTags and @ExcludeTags annotations in single test plan.**
- To add **more than one tag, pass a string array of tags** in desired annotation.
-           @RunWith(JUnitPlatform.class)
            @SelectPackages("com.deepak.junit5.examples")
            @IncludeTags({"production","development"})
            public class MultipleTagsExample {
            }

## TestInfo and TestReporter  (injected interfaces)  (RepetitionInfo)
1. **TestInfo and TestReporter are java interfaces**, not classes. Should not worry about the underlying implementation, and **should use them directly**.
2. **TestInfo conatins info about the test**. 
    -   used to **inject information about the current test or container into to @Test, @BeforeEach, @AfterEach, @BeforeAll, and @AfterAll methods**
3. **TestReporter lets one access the log where the JUnit is reporting** and gives you access to log to that.
    -   can be **injected into methods of test classes annotated with @BeforeEach, @AfterEach, and @Test.**
4. TestInfo methods

    | **Methods** | **Description** |                   
    | ----------- | --------------- |                   
    | getDisplayName() | Get the display name of the current test or container |        
    | getTags() |Get the set of all tags for the current test or container. |       
    | getTestClass() | Get the Class associated with the current test or container, if available. |         
    | getTestMethod() | Get the Method associated with the current test, if available. |

5. TestReporter methods : **publishEntry()**

## JUnit 5 Test Suites
- Using JUnit 5 test suites, **one can run tests spread into multiple test classes and different packages**. 
- JUnit 5 provides two annotations: **@SelectPackages and @SelectClasses** to create test suites. Additionally, you can use other annotations for filtering test packages, classes or even test methods.
### **1. Create Test Suite with @SelectPackages**
- @SelectPackages **specifies the names of packages to select when running a test suite via @RunWith(JUnitPlatform.class)**.
    - `Specify Single Package`
        - Pass “packageName” as parameter to @SelectPackages annotation.
        -           RunWith(JUnitPlatform.class)
                    @SelectPackages("com.deepak.junit5.examples.packageA") 
                    public class JUnit5TestSuiteExample {
                    }
    - `Specify Multiple Packages`
        - **pass package names in parameter as string array** (inside curly braces {}) to @SelectPackages annotation.
        -           @RunWith(JUnitPlatform.class)
                    @SelectPackages({"com.deepak.junit5.examples.packageA","com.deepak.junit5.examples.packageB"}) 
                    public class JUnit5TestSuiteExample {
                    }

### **2. Create Test Suite with @SelectClasses**        
- @SelectClasses **specifies the classes to select when running a test suite via @RunWith(JUnitPlatform.class).**   
    - `Specify Single Class`
        - Pass ClassName.class as parameter to @SelectClasses annotation.
        -           @RunWith(JUnitPlatform.class)
                    @SelectClasses( ClassATest.class )
                    public class JUnit5TestSuiteExample {
                    }         
    - `Specify Multiple Classes`
        - Pass class names in parameter as array (inside curly braces {}) to @SelectClasses annotation.
        -           @RunWith(JUnitPlatform.class)
                    @SelectClasses( { ClassATest.class, ClassBTest.class, ClassCTest.class } )
                    public class JUnit5TestSuiteExample {
                    }     

### **3. @IncludePackages and @ExcludePackages**
- @SelectPackages causes all it’s sub-packages as well to be scanned for test classes. **If you want to exclude any specific sub-package, or include any package then you may use @IncludePackages and @ExcludePackages annotations**.
-               @RunWith(JUnitPlatform.class)
                @SelectPackages("com.deepak.junit5.examples")
                // This will add tests from test classes in com.deepak.junit5.examples.packageC only i.e. ClassCTest.
                @IncludePackages("com.deepak.junit5.examples.packageC")  
                public class JUnit5TestSuiteExample {
                }

                @RunWith(JUnitPlatform.class)
                @SelectPackages("com.deepak.junit5.examples")
                // add tests from test classes in com.deepak.junit5.examples but exclude all test classes from sub-package com.deepak.junit5.examples.packageC
                @ExcludePackages("com.deepak.junit5.examples.packageC")
                public class JUnit5TestSuiteExample {
                }

### **4. @IncludeClassNamePatterns and @ExcludeClassNamePatterns**
- Many times it is **not feasible to include all packages or test class names in select annotations**. In that case, you may give a broader package scope and appy filtering on which test classes to be included or excluded from suite.
- To specify test **class names patterns to exclude or include, you can use @IncludeClassNamePatterns and @ExcludeClassNamePatterns** annotations.
-               @RunWith(JUnitPlatform.class)
                @SelectPackages("com.deepak.junit5.examples")
                @IncludeClassNamePatterns({"^.*ATests?$"})
                public class JUnit5TestSuiteExample {
                }

                @RunWith(JUnitPlatform.class)
                @SelectPackages("com.deepak.junit5.examples")
                @ExcludeClassNamePatterns({"^.*ATests?$"})
                public class JUnit5TestSuiteExample {
                }

### **5. @IncludeTags and @ExcludeTags**
- **@IncludeTags**
    - This test suite will run all tests tagged with production inside package com.deepak.junit5.examples (and it’s sub-packages).
    -       @RunWith(JUnitPlatform.class)
            @SelectPackages("com.deepak.junit5.examples")
            @IncludeTags("production")
            public class JUnit5TestSuiteExample {
            }
- **@ExcludeTags** 
    - This test suite will exclude all tests tagged with development inside package com.deepak.junit5.examples (and it’s sub-packages).
    -       @RunWith(JUnitPlatform.class)
            @SelectPackages("com.deepak.junit5.examples")
            @ExcludeTags("development")
            public class JUnit5TestSuiteExample {
            }
