package Search;

class BinarySearch {
	

	int find(int[] arr, int t, int l, int r) {
		while(r >= l) {	
			int m = l + (r-l)/2;
			if (arr[m] == t) return m;
			if (arr[m] > t) r = m-1;
			else l = m+1;
		}
		
		return -1;
	}

	public static void main(String[] args) {
		
		BinarySearch bs = new BinarySearch();
		
		int[] arr = {2, 3, 4, 10, 40};
		int idx = bs.find(arr, 40, 0, arr.length -1);
		
		System.out.println(idx);
	}
}
