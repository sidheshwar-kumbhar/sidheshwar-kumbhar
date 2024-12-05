package com.java.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamApiUse {
	public static void main(String[] args) {
		List<Integer> number = Arrays.asList(3, 6, 1, 2, 3, 4, 5);
		List<Integer> square = number.stream().map(x -> x * x).collect(Collectors.toList());
		System.out.println(square.toString());

		List<Integer> result = number.stream().filter(x -> x == 5).collect(Collectors.toList());
		System.out.println(result.toString());

		Set<Integer> sorted = number.stream().sorted((x, y) -> y.compareTo(x)).collect(Collectors.toSet());
		System.out.println(sorted.toString());

		number.stream().sorted((x, y) -> y.compareTo(x)).forEach(x -> System.out.println(x));

		List<String> list = Arrays.asList("Geeks", "for", "GeeksQuiz", "GeeksforGeeks", "GFG");
		List<String> filterdName = list.parallelStream().filter(x -> x.startsWith("G")).collect(Collectors.toList());
		System.out.println(filterdName.toString());

	}
};