package Array;

import java.util.Arrays;

class LongestSpanSameSum {

	static void findLongestSpan(int[] arr, int[] arr2) {
		int n = arr.length;
		int maxLen = 0;
		int s1 = 0, s2 = 0;
		
		
		int[] diff = new int[2*n+1];
		Arrays.fill(diff, -1);
		
		
		for (int i=0; i<n; i++) {
	        // Update prefix sums
	        s1 += arr[i];
	        s2 += arr2[i];
	    
	        int currDiff = s1-s2;
			int diffIdx = n+currDiff;
	        
			
			System.out.println("diffIdx = " + diffIdx);
			
			if (currDiff == 0) {
				maxLen += 1;
			} else if (diff[diffIdx] == -1) {
				diff[diffIdx] = i;
			} else {
				int len = i - diff[diffIdx];
				 
	            // Update max len if needed
	            if (len > maxLen)
	                maxLen = len;
			}
			
			
	    }
		
		System.out.println("max len " + maxLen);
		
	}
	
	
	
	
	
	public static void main(String[] args) {
	    int[] arr = {0, 1, 0, 1, 1, 1, 1};
	    int[] arr2 ={1, 1, 1, 1, 1, 0, 1};
	    findLongestSpan(arr, arr2);
	}
}
