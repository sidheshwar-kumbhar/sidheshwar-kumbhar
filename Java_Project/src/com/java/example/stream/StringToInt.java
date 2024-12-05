package com.java.example.stream;

public class StringToInt {
	public static void main(String[] args) {
		String numString = "42,94,96,729";
		System.out.println(getStringToInt(numString));
	}

	public static int getStringToInt(String numStr) {
		int number = 0;
		int count = 0;
		boolean isNegative = false;

		if (numStr == null || numStr.isEmpty()) {
			return -1;
		}

		char[] charArray = numStr.toCharArray();
		if (charArray[0] == '-') {
			isNegative = true;
			count++;
		}
		
		while (count < charArray.length) {
			if (Character.isDigit(charArray[count])) {
				number = number * 10;
				number = number + charArray[count] - '0';
			}
			count++;
		}

		if (isNegative)
			number = -number;
		return number;
	}
}