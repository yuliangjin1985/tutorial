## Stream
### Sort
Here are some examples about how to sort in a stream.
#### 1. Sort an employee by name in ascending order, employees with the same name have to sort by salary in descending order.
 ```java
 public static void ordering(List<Employee> employees) {
 		employees.stream()
 				.sorted(Comparator.comparing((Employee e) -> e.getName()).thenComparing((Employee e) -> e.getSalary()).reversed()) //Here the reversed() will reverse both the name and salary order.
                 .sorted(Comparator.comparing((Employee e) -> e.getName()).thenComparing(Comparator.comparing((Employee::getSalary)).reversed()))
 				.forEach(System.out::println);
 	}
 ```
#### 2. (4, 5, -2, 0, -3, -1, -5, -4) -> expected output: [0, -1, -2, -3, -4, 4, -5, 5]
```java
static Comparator<Integer> integerComparator1 = (Integer a, Integer b) -> Math.abs(a) - Math.abs(b);
	static Comparator<Integer> integerComparator2 = (Integer a, Integer b) -> a - b;
	static Comparator<String> stringReverseComparator = (a, b) -> new StringBuilder(a).reverse().toString().compareTo(new StringBuilder(b).reverse().toString());

	public static void ordering1(List<Integer> list) {
		list.stream()
                .sorted(integerComparator1.thenComparing(integerComparator2))
				.forEach(System.out::print);
		System.out.println();
		list.stream()
				.sorted(Comparator.comparing((Integer a) -> Math.abs(a)).thenComparing((Integer a) -> a))
                .forEach(System.out::print);
	}
```
