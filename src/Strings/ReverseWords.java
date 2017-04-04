package Strings;

public class ReverseWords {

	static void reverse(char[] str) {
		int start = 0;
		for (int i=0; i<str.length; i++) {
			if (str[i] == ' ') {
				reverseStr(str, start, i-1);
				start = i+1;
			}
		}
		
		reverseStr(str, start, str.length-1);
		reverseStr(str, 0, str.length-1);
		
		System.out.println(new String(str));
	}
	
	static void reverseStr(char[] str, int start, int end) {
		int middle = (start+end)/2;
		for(int i=start; i<=middle; i++) {
			int lastC = end+start-i;
			
			char tmp = str[lastC];
			str[lastC] = str[i];
			str[i] = tmp;
		}
	}
	
	public static void main(String[] args) {
		String str = "the sky is blue";
		
		reverse(str.toCharArray());
	}
}
