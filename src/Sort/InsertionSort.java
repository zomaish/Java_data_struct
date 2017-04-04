package Sort;

class InsertionSort {
	
	void sort(int[] arr) {
		
		for (int i=1; i<arr.length; i++) {
			int j = i-1;
			int k = arr[i];
			
			while(j>=0 && arr[j] > k) {
				arr[j+1] = arr[j];
				--j;
			}
			arr[j+1] = k;
		}
	}
	
	static void printSortedArr(int[] arr) {
		for (int i=0; i<arr.length-1; i++) {
			System.out.print(arr[i] + ",");
		}
		
		System.out.print(arr[arr.length-1]);
	}

	public static void main(String[] args) {
		
		int[] arr = {2, 64, 34, 25, 12, 22, 11, 90};
		InsertionSort is = new InsertionSort();
		is.sort(arr);
		
		printSortedArr(arr);
	}
}
