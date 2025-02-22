package com.java.example.dsa.he.easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SongsCount {

	public static void main(String args[]) throws Exception {
		// BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T > 0) {
			String[] numberStrArr = br.readLine().split(" ");
			long count = -1;
			String song = "";
			List<String> playList = Arrays.asList(numberStrArr);
			Map<String, Long> soungCountMap = playList.stream()
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

			Iterator<String> i = soungCountMap.keySet().iterator();
			while (i.hasNext()) {
				String iSong = i.next();
				if (count < soungCountMap.get(iSong)) {
					count = soungCountMap.get(iSong);
					song = iSong;
				}

			}

			System.out.println(song);
			T--;

		}

	}

}
