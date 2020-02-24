package com.him.java8;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
	public static void main(String[] args) {
		Collection c;// default forEach added in iterable

		/*
		 * Multiple ways to iterate through collections for,advanced
		 * for,forEach,iterator,listIterator
		 */
		System.out.println("Multiple ways to iterate through collections");
		List<String> pointList = new ArrayList<>();
		pointList.add("A");
		pointList.add("B");

		HashMap<String, Integer> map = new HashMap<>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);

		// for
		for (Iterator<String> iterator = pointList.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
		// advanced For loop
		for (String string : pointList) {
			System.out.println(string);
		}
		// foreach iterate over a collection or stream available to all collection
		// classes except Map.
		pointList.forEach(p -> {
			System.out.println(p);
		});

		ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		Consumer<Integer> action = System.out::println;
		numberList.stream().filter(n -> n % 2 == 0).forEach(action);

		// foreach on map
		Consumer<Map.Entry<String, Integer>> action1 = System.out::println;
		map.entrySet().forEach(action1);
		// 2. Map keys
		Consumer<String> actionOnKeys = System.out::println;
		map.keySet().forEach(actionOnKeys);
		// 3. Map values
		Consumer<Integer> actionOnValues = System.out::println;
		map.values().forEach(actionOnValues);
		// custom action
		map.entrySet().forEach(entry -> {
			System.out.println("Key is : " + entry.getKey());
			System.out.println("Value is : " + entry.getValue());
		});

		// list iterator
		for (Iterator<String> iterator = pointList.listIterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}

		/* Function interface examples */
		TestFunctionalInterface2 t = (a, b) -> a + b;
		System.out.println(t.sum(10, 2));

		TestFunctionalInterface2 t2 = (a, b) -> {
			return a + b;
		};
		System.out.println(t2.sum(1, 2));

		TestFunctionalInterface t1 = () -> System.out.println(Instant.now());
		t1.printTime();

		ArrayList<String> st = new ArrayList<>();
		st.add("a");
		st.add("c");
		st.add("b");

		st.forEach(str -> System.out.println(str));
		st.forEach(System.out::println);

		Employee[] employees = { new Employee(1, "David"), new Employee(2, "Naveen"), new Employee(3, "Alex"),
				new Employee(4, "Richard") };

		System.out.println("Before Sorting Names: " + Arrays.toString(employees));
		Arrays.sort(employees, Employee::nameCompare);
		System.out.println("After Sorting Names " + Arrays.toString(employees));

		/* Method reference examples */

		// Method reference to static method – Class::staticMethodName
		Optional<Integer> max = Arrays.asList(1, 12, 433, 5).stream().reduce(Math::max);

		// Method reference to instance method from instance –
		// Instance::instanceMethodName
		max.ifPresent(System.out::println);

		// Method reference to instance method from class type –
		// Class::instanceMethodName
		List<String> sortedAlt = Arrays.asList("how", "are ", "you").stream().sorted(String::compareTo)
				.collect(Collectors.toList());

		// Reference to constructor – Class::new
		List<Integer> integers = IntStream.range(1, 100).boxed().collect(Collectors.toCollection(ArrayList::new));
		Optional<Integer> max1 = integers.stream().reduce(Math::max);
		max1.ifPresent(System.out::println);

		// Optionals
		Optional<Integer> canBeEmpty1 = Optional.of(5);
		canBeEmpty1.isPresent(); // returns true
		canBeEmpty1.get(); // returns 5

		Optional<Integer> canBeEmpty2 = Optional.empty();
		canBeEmpty2.isPresent();

		Optional<Integer> possible = Optional.empty();
		possible.ifPresent(System.out::println);
		// If you pass null in of(), then a NullPointerException is thrown immediately.
		possible = Optional.of(5);
		possible.ifPresent(System.out::println);
		possible = Optional.ofNullable(null);
		possible.ifPresent(System.out::println);
		possible = Optional.ofNullable(5);
		possible.ifPresent(System.out::println);

		/* Default/absent values and actions */
		// Assume this value has returned from a method
		Optional<Employee> employeeOptional = Optional.empty();

		// Now check optional; if value is present then return it,
		// else create a new Company object and retur it
		Employee company = employeeOptional.orElse(new Employee(1, "t"));

		// OR you can throw an exception as well
		Employee company1 = employeeOptional.orElseThrow(IllegalStateException::new);

		/* Rejecting certain values using the filter method */
		// employeeOptional.filter(name ->
		// "Finance".equals(name.getName())).ifPresent(() ->{
		// System.out.println("Finance is present");});
		// .ifPresent(() ->{ System.out.println("Finance is present");}));

		/* Streams in java */
		// Different ways to create streams

		// Stream.of(val1, val2, val3….)
		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		stream.forEach(p -> System.out.println(p));

		// Stream.of(arrayOfElements)
		stream = Stream.of(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		stream.forEach(p -> System.out.println(p));

		// Stream.generate() or Stream.iterate()
		Stream<Date> stream1 = Stream.generate(() -> {
			return new Date();
		});
		stream1.forEach(p -> System.out.println(p));

		// String chars or String tokens
		IntStream streamint = "12345_abcdefg".chars();
		streamint.forEach(p -> System.out.println(p));

		// OR

		Stream<String> stream2 = Stream.of("A$B$C".split("\\$"));
		stream2.forEach(p -> System.out.println(p));

		// List.stream()
		Stream<String> stream3 = pointList.stream();
		stream3.forEach(p -> System.out.println(p));

		// Convert streams to collections
		// Convert Stream to List – Stream.collect( Collectors.toList() )
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			list.add(i);
		}
		Stream<Integer> stream4 = list.stream();
		List<Integer> evenNumbersList = stream4.filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.print(evenNumbersList);

		// Convert Stream to array – Stream.toArray( EntryType[]::new )
		List<Integer> list1 = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			list1.add(i);
		}
		Stream<Integer> stream5 = list1.stream();
		Integer[] evenNumbersArr = stream5.filter(i -> i % 2 == 0).toArray(Integer[]::new);
		System.out.print(evenNumbersArr);

		// Stream Intermediate operations
		List<String> memberNames = new ArrayList<>();
		memberNames.add("Amitabh");
		memberNames.add("Shekhar");
		memberNames.add("Aman");
		memberNames.add("Rahul");
		memberNames.add("Shahrukh");
		memberNames.add("Salman");
		memberNames.add("Yana");
		memberNames.add("Lokesh");

		// filter
		memberNames.stream().filter((s) -> s.startsWith("A")).forEach(System.out::println);

		// map
		memberNames.stream().filter((s) -> s.startsWith("A")).map(String::toUpperCase).forEach(System.out::println);

		// sorted
		memberNames.stream().sorted().map(String::toUpperCase).forEach(System.out::println);

		// Terminal operations
		// foreach
		memberNames.forEach(System.out::println);

		// Stream.collect()
		List<String> memNamesInUppercase = memberNames.stream().sorted().map(String::toUpperCase)
				.collect(Collectors.toList());
		System.out.print(memNamesInUppercase);

		// Stream.match()
		boolean matchedResult = memberNames.stream().anyMatch((s) -> s.startsWith("A"));
		System.out.println(matchedResult);

		matchedResult = memberNames.stream().allMatch((s) -> s.startsWith("A"));
		System.out.println(matchedResult);

		matchedResult = memberNames.stream().noneMatch((s) -> s.startsWith("A"));
		System.out.println(matchedResult);

		// Stream.count()
		long totalMatched = memberNames.stream().filter((s) -> s.startsWith("A")).count();
		System.out.println(totalMatched);

		// Stream.reduce()
		Optional<String> reduced = memberNames.stream().reduce((s1, s2) -> s1 + "#" + s2);
		reduced.ifPresent(System.out::println);

		// Stream.findFirst()
		String firstMatchedName = memberNames.stream().filter((s) -> s.startsWith("L")).findFirst().get();
		System.out.println(firstMatchedName);
	}
}
