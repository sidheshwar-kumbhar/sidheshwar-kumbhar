/*

Intersection Point in Y Shaped Linked Lists
Medium Accuracy: 55.77% Submissions: 21K+ Points: 4

Given two singly linked lists of size N and M, write a program to get the point 
where two linked lists intersect each other.

 

Example 1:

Input:
LinkList1 = 3->6->9->common
LinkList2 = 10->common
common = 15->30->NULL
Output: 15
Explanation:
Y ShapedLinked List

Example 2:

Input: 
Linked List 1 = 4->1->common
Linked List 2 = 5->6->1->common
common = 8->4->5->NULL
Output: 8
Explanation: 

4              5
|              |
1              6
 \             /
  8   -----  1 
   |
   4
   |
  5
  |
  NULL       
Your Task:
You don't need to read input or print anything. 
The task is to complete the function intersetPoint() which takes the pointer to 
the head of linklist1(head1) and linklist2(head2) as input parameters and returns data 
value of a node where two linked lists intersect. If linked list do not merge at any point, 
then it should return -1.
Challenge : Try to solve the problem without using any extra space.

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(1)
Constraints:
1 ≤ N + M ≤ 2*105
-1000 ≤ value ≤ 1000

 */
package com.java.example.dsa.gfg.linkedlist;

import com.java.example.dsa.Node;
import java.io.*;
import java.util.HashSet;

public class IntersectionPointinYShapedLinkedLists2 {

	Node head = null;
	Node tail = null;

	public void addToTheLast(Node node) {

		if (head == null) {
			head = node;
			tail = head;
		} else {
			tail.next = node;
			tail = node;
		}
	}

	/* Function to print linked list */
	void printList(PrintWriter out) {
		Node temp = head;
		while (temp != null) {
			out.print(temp.data + " ");
			temp = temp.next;
		}
		out.println();
	}

	/* Driver program to test above functions */
	public static void main(String args[]) throws IOException {

		/*
		 * Constructed Linked List is 1->2->3->4->5->6-> 7->8->8->9->null
		 */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(in.readLine().trim());

		while (t > 0) {
			String s[] = in.readLine().trim().split(" ");
			int n1 = Integer.parseInt(s[0]);
			int n2 = Integer.parseInt(s[1]);
			int n3 = Integer.parseInt(s[2]);
			IntersectionPointinYShapedLinkedLists2 llist1 = new IntersectionPointinYShapedLinkedLists2();
			IntersectionPointinYShapedLinkedLists2 llist2 = new IntersectionPointinYShapedLinkedLists2();
			IntersectionPointinYShapedLinkedLists2 llist3 = new IntersectionPointinYShapedLinkedLists2();

			s = in.readLine().trim().split(" ");
			int a1 = Integer.parseInt(s[0]);
			Node head1 = new Node(a1);
			Node tail1 = head1;

			for (int i = 1; i < n1; i++) {
				int a = Integer.parseInt(s[i]);
				tail1.next = (new Node(a));
				tail1 = tail1.next;
			}

			s = in.readLine().trim().split(" ");
			int b1 = Integer.parseInt(s[0]);
			Node head2 = new Node(b1);
			Node tail2 = head2;
			for (int i = 1; i < n2; i++) {
				int b = Integer.parseInt(s[i]);
				tail2.next = (new Node(b));
				tail2 = tail2.next;
			}

			s = in.readLine().trim().split(" ");
			int c1 = Integer.parseInt(s[0]);
			Node head3 = new Node(c1);
			tail1.next = head3;
			tail2.next = head3;
			Node tail3 = head3;
			for (int i = 1; i < n3; i++) {
				int c = Integer.parseInt(s[i]);
				tail3.next = (new Node(c));
				tail3 = tail3.next;
			}

			out.println(intersectPoint(head1, head2));
			t--;
		}
		out.close();
	}

	// Function to find intersection point in Y shaped Linked Lists.
	public static int intersectPoint(Node head1, Node head2) {
		HashSet<Node> set = new HashSet<>();
		while (head1 != null) {
			set.add(head1);
			head1 = head1.next;
		}

		while (head2 != null) {
			if (set.contains(head2)) {
				return head2.data;
			}
			head2 = head2.next;
		}
		return -1;
	}
}
