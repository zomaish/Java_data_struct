package Array;

import java.util.Arrays;

class TripletSumSmaller {

	
	static int countTriplets(int[] arr, int sum) {
		int n = arr.length;
		int ans = 0;
		
		Arrays.sort(arr);
		for(int i=0; i<n-2; i++) {
			int j = i+1, k = n-1;
			
			while(j<k) {
				if (arr[i] + arr[j] + arr[k] >=sum) {
					--k;
				} else {
					ans += (k-j);
					j++;
				}
			}
		}
		
		return ans;
	}
	
	
	static Boolean isTriplet(int[] arr) {
		
		Arrays.sort(arr);
		int n = arr.length;
		for(int i=0; i<n; i++)
			arr[i] = arr[i] * arr[i];
		
		for (int i=n-1; i>=2; i--) {
			int l=0, r = i-1;
			
			while(l<r) {
				int s = arr[l]+arr[r];
				if (s == arr[i]) 
					return true;
				
				if (s>arr[i])
					--r;
				else ++l;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		
	    int arr[] = {5, 1, 3, 4, 7};
	    
	    int sum = 12;
	    System.out.println(isTriplet(arr));

	}
}
