package com.java.example.threads;

import java.util.concurrent.locks.ReentrantLock;

public class ToDoTask implements Runnable {

	private ReentrantLock lock;
	private String name;
	private int counter;

	public ToDoTask(String name, int counter, ReentrantLock lock) {
		this.name = name;
		this.counter = counter;
		this.lock = lock;
	}

	public void run() {
		int counter = 1;
		while (counter <= this.counter) {
			this.pingpong(counter);
			counter = counter + 1;
		}

	}

	public void pingpong(int counter) {
		lock.lock();
		try {
			Thread.sleep(500);
			System.out.println(this.name + " (" + counter + ")");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
