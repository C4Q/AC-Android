# OOP Review

## Objectives
* Review what has been covered concerning the Java programming language since the second day of class

## Resources
* [CodingBat]()

### Primitive Data Types
There are 8 (eight) primitive data types in Java:
* `byte`
* `short`
* `int`
* `long`
* `float`
* `double`
* `char`
* `boolean`

All primitive data types are written in lower case.

* `char` and `int` values are effectively interchangeable up to a certain value
* integer division rounds down the value of dividing two whole numbers by each other


### Variable Assignment

Variables can hold either values, or references to objects in memory, depending on their static type. When we declare a variable named `number` of type `int`, we may do the following:

|type|variable name|
|:-:|:-:|
|int|number;|

If we were to print the contents of this value to the screen, we would get an error, because **it is not initialized**. We should assign it a value before we can make any real use of it.

Assignment requires an `=` operator, where we assign a value on the right of the `=`, to a variable of the appropriate data type on the left:

|type|variable name|assignment|value|
|:-:|:-:|:-:|:-:|
|int|number|=|25;|

When a value or reference has been assigned to a variable, we say that **it has been initialized**.

### Comparison Operators

When comparing numerical values, we can use the following operators:

|operator|name|
|:-:|:-:|
|==|equals to|
|>|greater than|
|<|less than|
|>=|greater than or equal to|
|<=|less than or equal to|
|!=|not equal to|

Numerical comparisons result to true/false, or boolean values.

### Logical Operators

Logical operators are used in logical expressions, i.e. - when comparing 1 or more boolean values, or expressions that resolve to boolean values:

|operator|name|
|:-:|:-:|
|&&|AND|
|\|\||OR|
|!|NOT|

`&&` expressions evaluate to `true` if ALL values compared are `true`. Otherwise, they evaluate to `false`.

`||` expressions evaluate to `true` if AT LEAST ONE of the values compared are `true`.

`!` expressions evaluate to the opposite boolean value to the original value given.

### Control Structures


