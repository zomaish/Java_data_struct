package Strings;

/**
 * if len[mirror] goes beyond L ?= (R-B's index)
 * if len[mirror] within L ?= len[mirror]
 * Expand beyond minimum length 1 & 2
 * @author zaidemeish
 *
 */
public class ManachersPalindrome {

	static void find(String str) {
		
		int len = 2*str.length() + 1;
		int[] lps = new int[len];
		lps[0] = 0;
		lps[1] = 1;
		
		int c = 1;
		int r = 2;
		int mirrorIdx;
		int diff = -1;
		int maxLen = 0;
		int center = 0;
		
		
		for(int i = 2; i<len; i++) {
			mirrorIdx = 2*c - i;
			lps[i] = 0;
			
			diff = r - i;
			
			if (diff > 0)
				lps[i] = Math.min(lps[mirrorIdx], diff);
			
			
			while(
					((i+lps[i]) < len && (i - lps[i]) > 0) &&
					( ((i+lps[i]+1)%2 == 0) ||
						(
							(((i+lps[i]+1)/2) < str.length()) &&
							(str.charAt((i+lps[i]+1)/2) == str.charAt((i-lps[i]-1)/2))
						)
					)
				) {
				lps[i]++;
			}
				
			if (lps[i] > maxLen) {
				maxLen = lps[i];
				center = i;
			}
			
			if (i + lps[i] > r) {
				c = i;
				r = i+lps[i];
			}
		}
		
		
		System.out.println("MaxLen " + maxLen + " __ " + center);
		
		int start = (center - maxLen)/2;
		int end = start + maxLen - 1;
		System.out.println("LPS of string is : " + start + " -- " + end);
		for(int i=start; i<=end; i++)
			System.out.print(str.charAt(i));
		}
		
	
	public static void main(String[] args) {
		String str = "babcbabcbaccba";
		find(str);
	}
}
