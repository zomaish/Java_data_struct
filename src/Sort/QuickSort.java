package Sort;

class QuickSort {

	void qsort(int[] arr, int l, int r) {
		if
		(r > l) {
			
			int pi = partition(arr, l, r);
			
			qsort(arr, l, pi-1);
			qsort(arr, pi+1, r);
		}
	}
	
	
	int partition(int[] arr, int l, int r) {
		int pivot = arr[r];
		int i = l-1;
		
		for (int j=l; j<=r-1; j++) {
			
			if (arr[j] <= pivot) {
				++i;
				swap(arr, i, j);
			}
		}
		
		swap(arr, i+1, r);
		return i+1;
	}
	
	void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
	
	
	
	static void printSortedArr(int[] arr) {
		for (int i=0; i<arr.length-1; i++) {
			System.out.print(arr[i] + ",");
		}
		
		System.out.print(arr[arr.length-1]);
	}

	public static void main(String[] args) {
		
		int[] arr = {4, 64, 34, 25, 12, 22, 11, 90};
		QuickSort qs = new QuickSort();
		qs.qsort(arr, 0, arr.length-1);
		
		printSortedArr(arr);
	}
}
