# Practical Final Review

### `Comparable` and `Comparator`

`Comparable` and `Comparator` are both interfaces, and can be used to sort collection elements.

However, there are many differences between Comparable and Comparator interfaces, which are described below:

|Comparable|Comparator|
|:--|:--|
|Comparable provides a single sorting sequence. In other words, we can sort the collection on the basis of a single element such as id, name, and price|The Comparator provides multiple sorting sequences. In other words, we can sort the collection on the basis of multiple elements such as id, name, price, etc.|
|Comparable affects the original class, i.e., the actual class is modified|Comparator doesn't affect the original class, i.e., the actual class is not modified|
|Comparable provides compareTo() method to sort elements|Comparator provides compare() method to sort elements|
|Comparable is present in java.lang package|A Comparator is present in the java.util package|
|We can sort the list elements of Comparable type by `Collections.sort(List)` method|We can sort the list elements of Comparator type by `Collections.sort(List, Comparator)` method|

### 
