package com.java.example.threads;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantlockDemo {

	public static void main(String[] args) {

		ReentrantLock lock = new ReentrantLock(true);

		ToDoTask ping = new ToDoTask("Ping", 5, lock);
		ToDoTask pong = new ToDoTask("Pong", 5, lock);

		Thread t1 = new Thread(ping);
		Thread t2 = new Thread(pong);

		t1.start();
		t2.start();

	}

}
