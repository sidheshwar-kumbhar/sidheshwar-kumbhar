package com.java.exaple;

public class Solution2 {
	public static void main(String []args) {
		Solution2 solution = new Solution2();
		int [] arr = {2,1,6,4,3,7};
		System.out.println(solution.solution(arr));
		
	}
	
	public int solution(int[] A) {
        int slices = 0;
        int n = A.length;
        if(n == 0) {
        	return slices;
        }
     
        int prev = A[0];
        for(int i = 1; i < n; i++) {
        	if(prev < A[i]) {
        		slices++;
        	}
        	prev = A[i];
        }
        return slices;
    }
}
