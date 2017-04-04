package Strings;

import java.lang.reflect.Array;

class KMPPatternMatching {

	
	
	void KMPSearch(String pat, String txt) {
		int m = pat.length();
		int n = txt.length();
		int[] lsp = new int[m];
		buildLPSArray(pat, lsp, m);
		
		int i = 0;
		int j = 0;
		
		while(i < n) {
			if (txt.charAt(i) == pat.charAt(j)) {
				i++;
				j++;
				
				if (j == m) {
					System.out.print("found a match at " + (i - m));
					j = 0;
				}
				
			} else if(i<n) {
				if (j != 0) {
					j = lsp[j-1];
				} else {
					i++;
				}
			}
			
		}
		
		
	}
	
	
	void buildLPSArray(String pat, int[] lps, int m) {
		int j = 0;
		int i = 1;
		
		lps[0] = 0;
		
		while(i < m) {
			
			if (pat.charAt(i) == pat.charAt(j)) {
				lps[i++] = ++j;
			} else {
				if (j != 0) {
					j = lps[j-1];
				} else {
					lps[i++] = j; 
				}
			}
		}
		
	}

	
	public static void main(String args[])
    {
        String txt = "AAAAAAAAAAAAAAAAAAAA";
        String pat = "AAAA";
        new KMPPatternMatching().KMPSearch(pat,txt);
    }
}
