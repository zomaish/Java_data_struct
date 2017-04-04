package Strings;

import java.util.Arrays;

import Number.Factorial;

class StringUtils {
	
	static Boolean isPalindrome(String str) {
		
		String s = str.replaceAll("\\W", "").toLowerCase();
		return s.equals(reverseString(s));
	}
	
	static String reverseString(String str) {
		char[] c = str.toCharArray();
		for (int i=0; i<c.length/2; i++) {
			char temp = c[i];
			c[i] = c[c.length-1-i]; 
			c[c.length-1-i] = temp;
		}
		
		return new String(c);
	}
	
	public static Boolean isPalindrome(String str, int l, int r) {
		char[] t = str.toCharArray();
	    while (l < r)
	    {
	        if (t[l] != t[r])
	            return false;
	        l++;
	        r--;
	    }
	    return true;
	}

	static Boolean isAnagram(String str1, String str2) {
		
		int m = str1.length();
		if (m != str2.length()) {
			return false;
		}
		
		int[] count = new int[256];
		
		Arrays.fill(count, 0);
		
		for(int i=0; i<m; i++) {
			int charCode1 = (int) str1.charAt(i);
			int charCode2 = (int) str2.charAt(i);
			
			count[charCode1] = ++count[charCode1];
			count[charCode2] = --count[charCode2];
		}

		for(int i=0; i<256; i++) {
			if (count[i] != 0) {
				return false;
			}
		}
		
		return true;
	}
	
	static void populateAndIncreaseCount(int[] count, char[] str) {
		
		for(int i=0; i<str.length; i++) {
			int ascii = (int) str[i];
			count[ascii] = ++count[ascii];
		}
		for(int i=1; i<256; i++) {
			count[i] += count[i-1];
		}
	}
	
	static void updatecount(int[] count, int idx) {
		for(int i=idx; i<256; i++) {
			count[i] = count[i] - 1;
		}
	}
	
	
	/**
	 * o make them work for duplicate characters, find all the characters that are smaller 
	 * (include equal this time also), do the same as above but, 
	 * this time divide the rank so formed by p! where p is the count of occurrences of the repeating character.
	 */
	static int findRank(char[] str) {
		int len = str.length;
		int rank = 1;
		int mul = Factorial.fact(len);
		int[] count = new int[256];
		Arrays.fill(count, 0);
		
		
		populateAndIncreaseCount( count, str );
		
		for (int i=0; i<len; i++) {
			mul = mul/(len-i);
			
//			countRight = findSmallerRight(str, i, len-1);
			
			int ascii = (int) str[i];
			
			rank += mul*count[ascii - 1];
			
			updatecount (count, ascii);
		}
		
		return rank;
		
	}
	
	public static void main(String[] args) {
		
		String str = "A car, a man, a maraca";
		System.out.println("IsPalindrome "+ isPalindrome(str));
		
		System.out.println("IsAnagram "+ isAnagram("geeksforgeeks", "forgeeksgeeks"));
		

        String s = "string"; 
        System.out.print(findRank(s.toCharArray()));
	}

}
