package com.java.exaple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

class Solution {
	
	public static void main(String []args) {
		Solution solution = new Solution();
		System.out.println(solution.solution(null));
	}
	
    public int solution(int[] A) {
    	 int n = A.length;
         int min = 1;
         HashSet<Integer> set = new HashSet<>();
         if(n > 0){
      	  for(int i = 0; i < n; i++){
            if(!set.contains(A[i])){
            	set.add(A[i]);
            }
          }
      	 while(set.contains(min)){
         	min++;
         }
      	  
         }
      	return min;
    }
}
