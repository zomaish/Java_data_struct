package Array;

class SubarrayLeastAvg {
	
	public static void findMinAvgSubarray(int[] arr, int k) {
		
		int minSum = 0;
		int currSum = 0;
		int startIdx = 0;
		
		for (int i=0; i<k; i++)
			minSum += arr[i];
		
		currSum = minSum;
		
		for(int i=k; i<arr.length; i++) {
			
			currSum += arr[i] - arr[i-k];
			
			if (minSum>currSum) {
				minSum = currSum;
				startIdx = i-k+1;
			}
		}
		
		
		System.out.println(startIdx + " TO " + (startIdx+k-1));
				
				
	}
	
	public static void main(String[] args) {
		
		int[] arr = {3, 7, 90, 20, 10, 50, 40};
	    int k = 3; // Subarray size
	    findMinAvgSubarray(arr, k);
	}

}
