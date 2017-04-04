package Array;

import java.util.*;

public class LongestContiguousElements {

	// This function prints all distinct elements
	static int findLength(int arr[]) {
		
		int maxLen = 1;
		
		for (int i=0; i<arr.length-1; i++) {
			int maxVal;
			int minVal = maxVal = arr[i];
			
			HashSet<Integer> set = new HashSet<>();
			
			set.add(arr[i]);
			
			for (int j = i+1; j<arr.length; j++) {
				
				if (set.contains(arr[j]))
					break;
				
				set.add(arr[j]);
				
				minVal = Math.min(minVal, arr[j]);
				maxVal = Math.max(maxVal, arr[j]);
				
				if (maxVal-minVal == j-i) {
					maxLen = Math.max(maxLen, j-i+1);
				}
				
			}
		}
		
		return maxLen;
		
	}

	// Driver method to test above method
	public static void main(String[] args) {
		int arr[] = { 10, 12, 12, 10, 10, 11, 10 };
		
//		int arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
		System.out.println("Length of the longest contiguous subarray is "
				+ findLength(arr));
	}

}
