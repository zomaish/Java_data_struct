package Sort;

class MergeSort {

	void sort(int[] arr, int l, int r) {
		if (r > l) {
			int m = l + (r-l)/2;
			
			sort(arr, l, m);
			sort(arr, m+1, r);
			
			merge(arr, l, m, r);
		}
	}
	
	
	
	
	void merge(int[] arr, int l, int m, int r) {
		
		int leftLen = m-l+1;
		int rightLen = r-m;
		int[] L = new int[leftLen];
		int[] R = new int[rightLen];
		
		
		for (int i=0; i<leftLen; i++) {
			L[i] = arr[i+l];
		}
		
		for (int i=0; i<rightLen; i++) {
			R[i] = arr[i + m + 1];
		}
		
		
		int i = 0; 
		int j = 0;
		int k=l;
		
		while(i < leftLen && j < rightLen) {
			if(L[i] < R[j]) {
				arr[k++] = L[i++];
			} else {
				arr[k++] = R[j++];
			}
		}
		
		while(j < rightLen) {
			arr[k++] = L[j++];
		}
		
		while(i < leftLen) {
			arr[k++] = L[i++];
		}
		
	}
	
	
	static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
	
	public static void main(String[] args) {
		int[] arr = {9,8,5,96,948,3,12,4,2};
		
		MergeSort ms = new MergeSort();
		ms.sort(arr, 0, arr.length-1);
		
		printArray(arr);
	}

}

