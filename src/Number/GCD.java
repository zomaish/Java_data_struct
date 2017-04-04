package Number;

class GCD {
	
	static int gcd(int a, int b) {
		if (a == 0)
			return b;
		
		return gcd(b%a, a);
	}
	
	static int reduce(int a, char b[]) {
		int mod = 0;
		
		for (int i=0; i<b.length; i++) {
			mod = (mod*10 + (b[i]|0)) %a;
			System.out.println(mod);
		}
		
		return mod;
	}
	
	static int gcdLarge(int a, char b[]) {
		int num = reduce(a, b);
		
		return gcd(a, num);
	}


	public static void main(String args[]) {
	
		int a = 1221;
		 
	    // second number is represented as string because
	    // it can not be handled by integer data type
	    char b[] = (new String("1234567891011121314151617181920212223242526272829")).toCharArray();
	 
	   System.out.println(gcdLarge(a, b));
		
	}
}
