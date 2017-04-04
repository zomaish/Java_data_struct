package Strings;

import java.util.Arrays;

import Number.Factorial;

public class AllPermutations {

	
	String swap(String str, int l, int r) {
		
		char[] t = str.toCharArray();
		char tmp = t[l];
		t[l] = t[r];
		t[r] = tmp;
		
		return new String(t);
	}
	
	void swap(char[] t, int l, int r) {
		char tmp = t[l];
		t[l] = t[r];
		t[r] = tmp;
	}
	
	/**
	 * O(n*n!)
	 */
	void permuteNoDups(String str, int l, int r) {
		if(l == r) {
			System.out.println("Permutation is " + str);
		} else {
			for (int i=l; i<=r; i++) {
				str = swap(str, l, i);
				permuteNoDups(str, l+1, r);
				str = swap(str, l, i);
			}
		}
	}
	
	
	int findCeil(char[] a, char first, int l, int r) {
		
		int ceilIdx = l;
		
		for (int i=l+1; i<=r; i++) {
			if (a[i] > first && a[i] < a[ceilIdx]) {
				ceilIdx = i;
			}
		}
		
		return ceilIdx;
	}
	
	
	/**
	 * Time Complexity: O(n2 * n!)
	 *	Auxiliary Space: O(1)
	 */
	void sortedPerumtes(String str) {
		char[] t = str.toCharArray();
		Arrays.sort(t);
		
		int len = t.length;
		
		Boolean done = false;
		
		while(!done) {
			int i;
			
			for (i=len-2; i>=0; i--) {
				if(t[i] < t[i+1])
					break;
			}
			
			if (i == -1) {
				done = true;
			} else {
				
				int ceilIndex = findCeil(t, t[i], i+1, len-1);
				swap(t, i, ceilIndex);
				
				Arrays.sort(t, i+1, len-1);
			}
			
		}
	}
	
	
	public static void main(String[] args) {
        String str = "ABCD";
        int n = str.length();
        AllPermutations permutation = new AllPermutations();
//        permutation.sortedPerumtes(str);
    }
}
