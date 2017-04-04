package Array;

import java.util.HashMap;
import java.util.Map;


/**
 * Motivation: Numerical similarity measure between 2 ranked lists (ranked movie lists)
 * Purchase recommendations
 * Count of Range Sum
 * Max Number of inversions per list is n(n-1) / 2
 * 
 * Always i < j where A[i] > A[j]
 * 
 * @author zaidemeish
 *
 */
class CountInversions {
	
	static class Counter {
		public int c;
		
		public Counter() {
			c = 0;
		}
	}
	
	int count(int arr[], int temp[], int l, int r, Counter c) {
	
		if(r > l) {
			int mid = l + (r-l)/2;
			
			c.c = count(arr, temp, l, mid, c);
			c.c += count(arr, temp, mid+1, r, c);
			
			c.c += merge(arr, temp, l, mid, r, c);
			
		}
		
		return c.c;
	}
	
	
	int merge(int arr[], int temp[], int l, int m, int r, Counter c) {
		int countInv = 0;

		int i = l, j = m, k = l;
		
		while(i<=(m -1) && j<=r){
//			System.out.println(k + " --- " + j);
			if(arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else { 
				countInv += m-i;
				temp[k++] = arr[j++];
			}
		}
		
		while(j <= r) {
			temp[k++] = arr[j++];
		}
		
		while(i<=(m -1)) {
			temp[k++] = arr[i++];
		}
		
		for (i=l; i <= r; i++)
		    arr[i] = temp[i];
		 
		
		return countInv;
	}
	
	
	
	public static void main(String[] args) {
		int[] arr = {9,8,5,96,948,3,12,4,2};
		
		CountInversions ms = new CountInversions();
		int[] temp = new int[arr.length];
		Counter c = new Counter();
		
		int res = ms.count(arr, temp, 0, arr.length-1, c);
		
		System.out.println(res);
	}

}
