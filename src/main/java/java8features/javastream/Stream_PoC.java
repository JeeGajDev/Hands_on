package java8features.javastream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;


public class Stream_PoC {

	public Stream_PoC() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Java stream intermediate operations
		Stream<Integer> stream = Stream.of(1, 2, 3, 4);
		Stream<Integer> stream1 = Stream.of(new Integer[] { 1, 2, 3, 4 });

		List<Integer> myList = new ArrayList<>();
		for (int i = 0; i < 100; i++)
			myList.add(i);
		// sequential stream
		Stream<Integer> sequentialStream = myList.stream();
		// parallel stream
		Stream<Integer> parallelStream = myList.parallelStream();

		Stream<String> stream2 = Stream.generate(() -> {
			return "abc";
		});
		Stream<String> stream3 = Stream.iterate("abc", (i) -> i);

		LongStream is = Arrays.stream(new long[] { 1, 2, 3, 4 });
		IntStream is2 = "abc".chars();

		Stream<Integer> intStream = Stream.of(1, 2, 3, 4);
		List<Integer> intList = intStream.collect(Collectors.toList());
		System.out.println(intList); // prints [1, 2, 3, 4]

		intStream = Stream.of(1, 2, 3, 4); // stream is closed, so we need to create it again
		Map<Integer, Integer> intMap = intStream.collect(Collectors.toMap(i -> i, i -> i + 10));
		System.out.println(intMap); // prints {1=11, 2=12, 3=13, 4=14}

		intStream = Stream.of(1, 2, 3, 4);
		Integer[] intArray = intStream.toArray(Integer[]::new);
		System.out.println(Arrays.toString(intArray)); // prints [1, 2, 3, 4]

		List<Integer> myList1 = new ArrayList<>();
		for (int i = 0; i < 100; i++)
			myList1.add(i);
		Stream<Integer> sequentialStream1 = myList1.stream();

		Stream<Integer> highNums = sequentialStream.filter(p -> p > 90); // filter numbers greater than 90
		System.out.print("High Nums greater than 90=");
		highNums.forEach(p -> System.out.print(p + " "));
//prints "High Nums greater than 90=91 92 93 94 95 96 97 98 99 "

		System.out.println();
		Stream<String> names = Stream.of("aBc", "d", "ef");
		System.out.println(names.map(s -> {
			return s.toUpperCase();
		}).collect(Collectors.toList()));
//prints [ABC, D, EF]

		Stream<String> names2 = Stream.of("aBc", "d", "ef", "123456");
		List<String> reverseSorted = names2.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(reverseSorted); // [ef, d, aBc, 123456]

		Stream<String> names3 = Stream.of("aBc", "d", "ef", "123456");
		List<String> naturalSorted = names3.sorted().collect(Collectors.toList());
		System.out.println(naturalSorted); // [123456, aBc, d, ef]

		Stream<List<String>> namesOriginalList = Stream.of(Arrays.asList("Pankaj"), Arrays.asList("David", "Lisa"),
				Arrays.asList("Amit"));
//flat the stream from List<String> to String stream
		Stream<String> flatStream = namesOriginalList.flatMap(s -> s.stream());

		flatStream.forEach(System.out::print);

		System.out.println();

//Java stream terminal operations

		Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);

		Optional<Integer> intOptional = numbers.reduce((i, j) -> {
			return i * j;
		});
		if (intOptional.isPresent())
			System.out.println("Multiplication = " + intOptional.get()); // 120

		Stream<Integer> numbers1 = Stream.of(1, 2, 3, 4, 5);

		System.out.println("Number of elements in stream=" + numbers1.count()); // 5

		Stream<Integer> numbers2 = Stream.of(1, 2, 3, 4, 5);
		numbers2.forEach(i -> System.out.print(i + ","));
		System.out.println();
		Stream<Integer> numbers3 = Stream.of(1, 2, 3, 4, 5);
		System.out.println("Stream contains 4? " + numbers3.anyMatch(i -> i == 4));
//Stream contains 4? true
		Stream<Integer> numbers4 = Stream.of(1, 2, 3, 4, 5);
		System.out.println("Stream contains all elements less than 10? " + numbers4.allMatch(i -> i < 10));
//Stream contains all elements less than 10? true

		Stream<Integer> numbers5 = Stream.of(1, 2, 3, 4, 5);
		System.out.println("Stream doesn't contain 10? " + numbers5.noneMatch(i -> i == 10));
//Stream doesn't contain 10? true

		Stream<String> names4 = Stream.of("Pankaj", "Amit", "David", "Lisa");
		Optional<String> firstNameWithD = names4.filter(i -> i.startsWith("D")).findFirst();
		if (firstNameWithD.isPresent()) {
			System.out.println("First Name starting with D=" + firstNameWithD.get()); // David
		}
		

		List<Integer> myList_ = new ArrayList<>();
		for (int i = 0; i < 10; i++)
			myList_.add(i);
		//sum of all numbers
		System.out.println("Sum of all numbers=" + sumWithCondition(myList_, n -> true));
		//sum of all even numbers
		System.out.println("Sum of all even numbers=" + sumWithCondition(myList_, i -> i%2==0));
		//sum of all numbers greater than 5
		System.out.println("sum of all numbers > 5=" + sumWithCondition(myList_, i -> i>5));


	}

// 3 problems with the below approach
	private static int sumIterator(List<Integer> list) {
		Iterator<Integer> it = list.iterator();
		int sum = 0;
		while (it.hasNext()) {
			int num = it.next();
			if (num > 10) {
				sum += num;
			}
		}
		return sum;
	}
	/*
	 * 1. We just want to know the sum of integers but we would also have to provide
	 * how the iteration will take place, this is also called external iteration
	 * because client program is handling the algorithm to iterate over the list.
	 * 
	 * 2. The program is sequential in nature, there is no way we can do this in
	 * parallel easily.
	 * 
	 * 3. There is a lot of code to do even a simple task.
	 * 
	 * To overcome all the above shortcomings, Java 8 Stream API was introduced. We
	 * can use Java Stream API to implement internal iteration, that is better
	 * because java framework is in control of the iteration.
	 * 
	 * Internal iteration provides several features such as sequential and parallel
	 * execution, filtering based on the given criteria, mapping etc. Most of the
	 * Java 8 Stream API method arguments are functional interfaces, so lambda
	 * expressions work very well with them
	 */

	private static int sumStream(List<Integer> list) {
		return list.stream().filter(i -> i > 10).mapToInt(i -> i).sum();
	}

	/*
	 * Notice that above program utilizes java framework iteration strategy,
	 * filtering and mapping methods and would increase efficiency.
	 */
	

public static int sumWithCondition(List<Integer> numbers, Predicate<Integer> predicate) {
	    return numbers.parallelStream()
	    		.filter(predicate)
	    		.mapToInt(i -> i)
	    		.sum();
	}


private static int findSquareOfMaxOdd_sequestial(List<Integer> numbers) {
		int max = 0;
		for (int i : numbers) {
			if (i % 2 != 0 && i > 3 && i < 11 && i > max) {
				max = i;
			}
		}
		return max * max;
	}

public static int findSquareOfMaxOdd(List<Integer> numbers) {
		return numbers.stream()
				.filter(Stream_PoC::isOdd) 		//Predicate is functional interface and
				.filter(Stream_PoC::isGreaterThan3)	// we are using lambdas to initialize it
				.filter(Stream_PoC::isLessThan11)	// rather than anonymous inner classes
				.max(Comparator.naturalOrder())
				.map(i -> i * i)
				.get();
	}

	public static boolean isOdd(int i) {
		return i % 2 != 0;
	}
	
	public static boolean isGreaterThan3(int i){
		return i > 3;
	}
	
	public static boolean isLessThan11(int i){
		return i < 11;
	}


}
