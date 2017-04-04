package Array;

public class MedianTwoSorted {

	static double findMedianSortedArrays(int[] a, int[] b) {
		int m = a.length;
		int n = b.length;
		
		if (m>n) return findMedianSortedArrays(b, a);
		if (n == 0) return (a[(m-1)/2] + a[m/2])/2;
		
		
		int l=0; int h = 2*n;
		
		while(l<=h) {
			int c2 = (l+h)/2;
			int c1 = m + n - c2;
			
			int L2 = c2 == 0 ? Integer.MIN_VALUE : b[(c2-1)/2];
			int L1 = c1 == 0 ? Integer.MIN_VALUE : a[(c1-1)/2];
			int R2 = c2 == 0 ? Integer.MAX_VALUE : b[c2/2];
			int R1 = c1 == 0 ? Integer.MAX_VALUE : a[c1/2];
			
			
			if (L2>R1) h = c2 - 1;
			else if (L1>R2) l = c2 + 1;
			else return (double) (Math.max(L1, L2) + Math.min(R1, R2))/2;
		}
		
		
		
		
		
		return -1;
	}

	public static void main(String[] args) {

		int a[] = { 5, 9 };
		int b[] = { 6, 10 };
		System.out.println(findMedianSortedArrays(a, b));
	}
}
