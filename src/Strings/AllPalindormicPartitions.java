package Strings;

import java.util.ArrayList;

import Strings.StringUtils;

class AllPalindormicPartitions {

	
	static void allPalPartitionsUtil(
			ArrayList<ArrayList<String>> allParts,
			ArrayList<String> currPart,
			int l,
			int r,
			String str) {
		
		if (l>r) {
			allParts.add((ArrayList<String>) currPart.clone());
			return;
		}
		
		for(int i=l; i<=r; i++) {
			if (StringUtils.isPalindrome(str, l, i)) {
				currPart.add(str.substring(l, i+1));
				allPalPartitionsUtil(allParts, currPart, i+1, r, str);
				
				currPart.remove(currPart.size()-1);
			}
		}
		
		
	}
	
	static void allPalPartitions(String str) {
		ArrayList<ArrayList<String>> allParts = new ArrayList<ArrayList<String>>();
		ArrayList<String> currPart = new ArrayList<String>();
		int n = str.length();
		
		allPalPartitionsUtil(allParts, currPart, 0, n-1, str);
		
		for (int i=0; i< allParts.size(); i++ ) {
			System.out.println("  ");
	        for (int j=0; j<allParts.get(i).size(); j++)
	           System.out.print(allParts.get(i).get(j) + " ");
	        
	    }
		
	}


	public static void main(String[] args) {
		String str = "nitin";
	    allPalPartitions(str);
	}
}
