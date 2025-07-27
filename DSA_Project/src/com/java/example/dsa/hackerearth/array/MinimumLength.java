/*
Problem
You are given two arrays 
 and 
, of length 
. You can select any subarray and then sort the elements in ascending order of that subarray for arrays 
 and 
.

Find the minimum length of the subarray you can choose to make 
 and 
 same after performing the operation. 
 and 
 are permutations of each other.

Input Format:

The first line contains an integer 
 denoting the number of test cases.
The first line of each test case contains an integer 
.
The next line of each test case contains 
 space-separated integers, elements of array 
.
The next line of each test case contains 
 space-separated integers, elements of array 
.
Output Format:

For each test case, print the minimum length of the subarray you can choose to make 
 and 
 same after performing the operation.

Constraints:


 

 

Sample Input
2
3
2 3 1 
2 1 3
4
1 1 2 1
2 1 1 1
Sample Output
2
3
Time Limit: 1
Memory Limit: 256
Source Limit:
	
*/

package com.java.example.dsa.hackerearth.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MinimumLength {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		while (n > 0) {
			int size = Integer.parseInt(br.readLine());
			String[] att1Str = br.readLine().split(" ");
			String[] att2Str = br.readLine().split(" ");
			int arr1[] = new int[size];
			for (int i = 0; i < size; i++) {
				arr1[i] = Integer.parseInt(att1Str[i]);
			}
			int arr2[] = new int[size];
			for (int i = 0; i < size; i++) {
				arr2[i] = Integer.parseInt(att2Str[i]);
			}

			System.out.println(getSubarray(arr1, arr2, size));
			n--;
		}
	}

	public static int getSubarray(int[] arr1, int[] arr2, int size) {
		int count = 0;
		int[] arrResult = new int[size];
		for (int i = 0; i < size; i++) {
			if (arr1[i] == arr2[i])
				arrResult[i] = 0;
			else
				arrResult[i] = 1;
		}
		int start = 0;
		int end = size - 1;

		while (start < end) {
			if (arrResult[start] == 0)
				start++;
			if (arrResult[end] == 0)
				end--;
			if (arrResult[start] == 1 && arrResult[end] == 1) {
				return (end - start) + 1;
			}
		}
		return count;
	}
}