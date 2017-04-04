package Sort;

public class BubbleSort {

	void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
	
	void sort(int[] arr) {		
		Boolean swapped = true;

		while(swapped) {
			swapped = false;

			for (int i=1; i<arr.length; i++) {
				if (arr[i] < arr[i-1]) {
					swap(arr, i, i-1);
					swapped = true;
				}
			}
		}
	}

	static void printSortedArr(int[] arr) {
		for (int i=0; i<arr.length-1; i++) {
			System.out.print(arr[i] + ",");
		}
		
		System.out.print(arr[arr.length-1]);
	}

	public static void main(String[] args) {
		
		int[] arr = {64, 34, 25, 12, 22, 11, 90};
		BubbleSort bs = new BubbleSort();
		bs.sort(arr);
		
		printSortedArr(arr);
	}
}
