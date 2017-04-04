package Array;

public class SlidingWindow {

	static void findZeroes(int[] arr, int m) {
		
		int wl = 0, wr = 0, bestWindow = -1;
		int n = arr.length;
		int countZeros = 0;
		int start = wl;
		
		for(int i=0; i<n; i++) {
			
			if (countZeros <=m) {
				if (arr[wr] == 0)
					++countZeros;
				
				++wr;
			}
			
			if (countZeros > m) {
				if (arr[wl] == 0)
					--countZeros;
				
				++wl;
			}
			
			if (wr-wl > bestWindow) {
				bestWindow = wr-wl;
				start = wl;
			}
		}

		// Print positions of zeroes in the widest window
		for(int i=0; i<bestWindow; i++) {
			 if (arr[start+i] == 0)
				 System.out.println(start + i);
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1};
		int m = 2;
		findZeroes(arr, m);
	}
}
