package Strings;

class ShortestDistance {

	
	
	static int findShortestDist(String[] words, String w1, String w2) {
		int res = words.length;
		int idx = -1;
		
		Boolean isEq = w1.equals(w2); 
		for(int i=0; i<words.length; i++) {
			if(words[i].equals(w1) || words[i].equals(w2)) {
				if((idx > -1) && 
					(w1.equals(w2) || !words[i].equals(words[idx]))
						) {
					res = Math.min(res, i-idx);
					idx = i;
				} else {
					idx = i;
				}
			}
		}
	
		
		
		
		return res;
	}
	
	
	
	public static void main(String[] args) {
		/*
		 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
		 * 	Given word1 = “makes”, word2 = “coding”, return 1.
				Given word1 = "makes", word2 = "makes", return 3.
		 */
		
		String[] list = {"practice", "makes", "perfect", "coding", "makes"};
		
		System.out.print(findShortestDist(list, "makes", "makes"));

			
	}
}
