package com.java.example.stream;

public class StringUpperAndLower {
	public static void main(String[] args) {
		String lowerStr = "abcdef";
		String upperStr = "UVWXYZ";

		System.out.println(toChangeCase(lowerStr, false));
		System.out.println(toChangeCase(upperStr, true));
	}

	public static String toChangeCase(String upperString, boolean isUpper) {
		if (upperString == null || upperString.isEmpty())
			return "";

		StringBuilder sb = new StringBuilder();
		int diff = 'A' - 'a';
		char[] strChar = upperString.toCharArray();
		int count = 0;
		char ch = ' ';

		while (count < strChar.length) {
			if (isUpper)
				ch = (char) (strChar[count] - diff);
			else
				ch = (char) (strChar[count] + diff);
			sb.append(ch);
			count++;
		}

		return sb.toString();
	}

}
