package com.gbabler;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Slf4j
public class FunctionalInterfaceApplication {
	public static void main(String[] args) {

		Stream.generate(() -> new Random().nextInt()) //Supplier
				.limit(5)
				.forEach(System.out::println); //Consumer

		List<Integer> numbers = Arrays.asList(2,4,10,23,31, 42, 99);

		numbers.stream()
				.filter(number -> number % 2 == 0) //Predicate
				.map(number -> number.doubleValue()) //Function
				.reduce((n1, n2) -> n1 + n2) //BinaryOperator
				.ifPresent(System.out::println); //Consumer
	}
}
