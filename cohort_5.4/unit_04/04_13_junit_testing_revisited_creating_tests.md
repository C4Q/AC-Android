# JUnit Testing Revisited - Creating Tests

## Objectives
* Fellows will review the concepts related to JUnit unit testing with Android Studio
* Fellows will create a testing suite with tests to confirm the effectiveness of specific methods

## Resources

# Lecture

JUnit 4 Testing involves the use of annotations and assert methods to setup, run, and confirm that all tests either pass or fail.

The most frequently used annotations for the testing environment are as follows:

* `@Test` - Marks the method as a test method
* `@Before` and `@After` - bookends each test method in the class
* `@BeforeClass` and `@AfterClass` - bookends all of the test methods in a JUnit test class

When you run the JUnit test class below, each method is run based on their particular annotation. The execution order is as follows:
  * Method annotated with @BeforeClass
  * Method annotated with @Before
  * First method annotated with @Test i.e. test1().
  * Method annotated with @After
  * Method annotated with @Before
  * Second method annotated with @Test i.e. test2().
  * Method annotated with @After
  * Method annotated with @AfterClass

### JUnit Assert methods

JUnit utilizes `assert` methods to confirm whether a class's methods provide expected return values based on particular inputs.

* Boolean

If you want to test the boolean conditions (true or false), you can use following assert methods

1. `assertTrue(condition)`
1. `assertFalse(condition)`

Here the condition is a boolean value.
Null object

If you want to check the initial value of an object/variable, you have the following methods:

1. `assertNull(object)`
1. `assertNotNull(object)`

Here object is a Java object e.g. assertNull(actual);

* Identical

If you want to check whether the objects are identical (i.e. comparing two references to the same java object), or different.

1. `assertSame(expected, actual)`, It will return true if expected == actual
1. `assertNotSame(expected, actual)`

* Assert Equals

If you want to test equality of two objects, you have the following methods

1. `assertEquals(expected, actual)`

It will return true if: expected.equals( actual ) returns true.

* Assert Array Equals

If you want to test equality of arrays, you have the following methods as given below:

`assertArrayEquals(expected, actual)`

Above method must be used if arrays have the same length, for each valid value for i, you can check it as given below:

`assertEquals(expected[i],actual[i])`
`assertArrayEquals(expected[i],actual[i])`

Fail Message

If you want to throw any assertion error, you have fail() that always results in a fail verdict.

`Fail(message);`

You can have assertion method with an additional String parameter as the first parameter. This string will be appended in the failure message if the assertion fails. E.g. fail( message ) can be written as

`assertEquals( message, expected, actual)`
    
### JUnit Testing in Practice

Please download [this project here](), unzip it, and run it in Android Studio. In the file `SillyTranslator.java`, we can see 10 different methods - all of which accept a `String` as an argument for its parameter, and a return type of `String`.

We will then go over how to set up the testing suite, prepare the environment, then compose tests for the first two methods. For the remainder of the methods, a fellow will be randomply selected to create a test for each method in the class `SillyTranslator.java` in `SillyTranslatorUnitTest.java`, in front of the class.

## Exercises

Please visit the canvas calendar for today's date, to find today's exercises.
