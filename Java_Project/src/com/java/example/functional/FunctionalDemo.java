package com.java.example.functional;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@FunctionalInterface
interface MyFunctionlInterface {
	public void print();
}

class Transaction {
	private String date;
	private int amount;

	public Transaction(String date, int amount) {
		this.date = date;
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}

interface Polygon {
	public void display();
}

public class FunctionalDemo {
	public static void main(String[] args) {
		MyFunctionlInterface myFunctional = () -> System.out.println("Hello");
		myFunctional.print();

		List<Integer> list = Arrays.asList(1, 5, 8, 9, 7, 3, 4);
		List<Integer> result = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());

		result.stream().forEach(System.out::println);

		Map<Boolean, Long> map = list.stream().collect(Collectors.groupingBy(n -> n % 2 == 0, Collectors.counting()));
		System.out.println(map);

		List<Integer> list3 = Stream.concat(result.stream(), list.stream()).sorted().collect(Collectors.toList());

		System.out.println(list3);

		List<Integer> list4 = list3.stream().distinct().collect(Collectors.toList());
		System.out.println(list4);

		int sum = list3.stream().distinct().reduce(0, (a, b) -> a + b);
		System.out.println(sum);

		List<Transaction> transactions = Arrays.asList(new Transaction("2022-01-01", 100),
				new Transaction("2022-01-01", 200), new Transaction("2022-01-02", 300),
				new Transaction("2022-01-02", 400), new Transaction("2022-01-03", 500));

		Map<String, Integer> sumByDay = transactions.stream()
				.collect(Collectors.groupingBy(Transaction::getDate, Collectors.summingInt(Transaction::getAmount)));
		System.out.println(sumByDay);

		Map<String, Integer> sumByDay1 = transactions.stream().collect(Collectors.groupingBy(Transaction::getDate,
				LinkedHashMap<String, Integer>::new, Collectors.summingInt(Transaction::getAmount)));
		System.out.println(sumByDay1);

		Polygon p1 = new Polygon() {
			public void display() {
				System.out.println("Inside an anonymous class.");
			}
		};
		p1.display();

		Thread t1 = new Thread() {
			public void run() {
				System.out.println("Hllo !");
			}
		};

		t1.start();

		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.submit(t1);
		executor.shutdown();
		
		ExecutorService executor1 = Executors.newSingleThreadExecutor();
		

	}

}
