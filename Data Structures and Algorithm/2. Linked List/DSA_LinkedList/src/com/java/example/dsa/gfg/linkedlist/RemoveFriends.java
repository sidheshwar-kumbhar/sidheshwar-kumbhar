package com.java.example.dsa.gfg.linkedlist;

import java.util.*;


public class RemoveFriends {
	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t > 0) {
			int n = s.nextInt();
			int k = s.nextInt();
			int deleted = 0;
			
			Deque<Integer> deque = new ArrayDeque<>();
			
			
			for (int j = 0; j < n; j++) {
			    int current = s.nextInt();
			    while (deleted < k && !deque.isEmpty() && deque.peek() < current) {
			    	deque.pop();
			        deleted++;
			    }
			    deque.push(current);
			}
			while (deleted < k) {
				deque.pop();
			    deleted++;
			}
			
			while(!deque.isEmpty()) {
				System.out.print(deque.removeLast() + " ");
			}
			System.out.println("");
			
			t--;
		}

	}
}
