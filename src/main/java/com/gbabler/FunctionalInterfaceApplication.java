package com.gbabler;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

@Slf4j
public class FunctionalInterfaceApplication {
	public static void main(String[] args) {

		/**
		 * Functional Interfaces
		 * 1 - Supplier
		 * 2 - Predicate and BiPredicate
		 * 3 - Function and BiFunction
		 * 4 - UnaryOperator and BinaryOperator
		 * 5 - Consumer and BiConsumer
		 */

		/**
		 * SUPPLIER - FORNECEDOR
		 */
		Stream.generate(() -> new Random().nextInt())
				.limit(5)
				.forEach(System.out::println);


//		Optional<String> example = null;

//		NotFoundException
//		example.orElseThrow(() -> new RuntimeException("RuntimeException"));
//		example.orElseThrow(NotFound::new);

		/**
		 * CONSUMER e BICONSUMER - CONSUMIDOR
		 */

		Stream.generate(() -> new Random().nextInt())
				.limit(5)
				.forEach(number -> System.out.println(number)); //Consumer

		BiConsumer<Integer, Integer> printSum = (number1, number2) -> System.out.println(number1+number2);


		System.out.println(printSum);
		/**
		 * Predicate e BiPredicate
		 */

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		numbers.forEach(number -> System.out.println(number));

		BiPredicate<String, Integer> wordSizeIsValid = (word, size) -> {
			return word.length() == size;
		};

		boolean wordOneIsValid = wordSizeIsValid.test("Gabriel", 7);
		System.out.println(wordOneIsValid);

		boolean wordTwoIsValid = wordSizeIsValid.test("Babler", 7);
		System.out.println(wordTwoIsValid);


		/**
		 * Function e BiFunction
		 */


		numbers.stream()
				.map(number -> number + 2)
				.forEach(System.out::println);

		BiFunction<Integer, Integer, Integer> sumNumbers = (number1, number2) -> number1 + number2;
		Integer sumResult = sumNumbers.apply(1, 2);
		System.out.println(sumResult);

		BiFunction<Integer, Integer, Double> numberExponent = (number1, number2) -> Math.pow(number1, number2);
		Double exponentResult = numberExponent.apply(2, 2);
		System.out.println(exponentResult);

		/**
		 * UnaryOperator e BinaryOperator
		 */

		UnaryOperator<Integer> multiplyNumberByTwo = x -> x * 2;
		UnaryOperator<Integer> sumNumberByTwo = x -> x + 2;


		numbers.stream()
				.reduce((n1, n2) -> n1 + n2)
				.ifPresent(System.out::println);



		numbers.stream()
				.filter(number -> number % 2 == 0) //Predicate
				.map(Integer::doubleValue) //Function
				.reduce(Double::sum) //BinaryOperator
				.ifPresent(System.out::println); //Consumer

	}
}
