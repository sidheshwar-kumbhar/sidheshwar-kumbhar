package com.java.example.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamApiUse {
	public static void main(String[] args) {

		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(1, "Yanksha", 28, 123, "F", "HR", "Blore", 2020));
		empList.add(new Employee(2, "Francesca", 29, 120, "F", "HR", "Hyderabad", 2015));
		empList.add(new Employee(3, "Ramesh", 30, 115, "M", "HR", "Chennai", 2014));
		empList.add(new Employee(4, "Melanie", 32, 125, "F", "HR", "Chennai", 2013));
		empList.add(new Employee(5, "Padma", 22, 150, "F", "IT", "Noida", 2013));
		empList.add(new Employee(6, "Milad", 27, 140, "M", "IT", "Gurugram", 2017));
		empList.add(new Employee(7, "Uzma", 26, 130, "F", "IT", "Pune", 2016));
		empList.add(new Employee(8, "Ali", 23, 145, "M", "IT", "Trivandam", 2015));
		empList.add(new Employee(9, "Ram", 25, 160, "M", "IT", "Blore", 2010));

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

		System.out.println(empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,
				Collectors.maxBy(Comparator.comparing(Employee::getSalary)))));
		
		List<Employee> empList2 = empList.stream().filter(e -> e.getAge() > 20).toList();

		empList2.forEach(System.out::println);
		
	}
}