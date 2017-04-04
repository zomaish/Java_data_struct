package Number;

public class LCM {

	static int lcm(int arr[]) {
		int ans = arr[0];
		
		for (int i=1; i<arr.length; i++) {
			ans = (ans*arr[i]) / GCD.gcd(ans, arr[i]);
		}
		
		return ans;
	}
	
	public static void main(String args[]) {
		
		int arr[] = {2, 7, 3, 9, 4};
		System.out.println(lcm(arr));
	}
}
