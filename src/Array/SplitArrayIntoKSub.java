package Array;

import java.util.ArrayList;
import java.util.List;


//https://www.careercup.com/question?id=5725965217955840
//Given a sorted array with "n" elements, distributed them into "k" nearly equally weighing buckets.


public class SplitArrayIntoKSub {
	
	
	static void printList(List list) {
		
		for (int i=0; i<list.size(); i++) {
			
			List inner = (List) list.get(i);
			System.out.println("Printing " + i);
			for(int j = 0; j < inner.size(); j++) {
				System.out.print(inner.get(j) + ", ");
			}
			System.out.println("");
			System.out.println("Done printing " + i);
		}
			
	}
	
	public static List<List<Integer>> arraySplit(int[] arr, int k){
		List<List<Integer>> res = new ArrayList<>();
		int i = 0;
		for(i=arr.length-1; i>=(arr.length - k); i--){
			List<Integer> temp = new ArrayList<>();
			temp.add(arr[i]);
			
			res.add(temp);
			printList(res);
		}
		
		//int c = 0;
//		while(i>=0){
//			int c = getListIndexWithMinSum(res);
//			res.get(c).add(arr[i]);
//			i--;
//		}
		return res;
	}
	
	private static int getListIndexWithMinSum(List<List<Integer>> arr){
		int minIndex = 0;
		int minSum = Integer.MAX_VALUE;
		int i = 0;
		for(List<Integer> l:arr ){
			int currSum = sum(l);
			if(minSum > currSum){
				minSum = currSum;
				minIndex = i;
			}
			i++;
		}
		return minIndex;
	}
	
	private static int sum(List<Integer> arr){
		int sum = 0;
		for(int n: arr){
			sum += n;
		}
		return sum;
	}
	public static void main(String[] args){
		int[] arr = {1, 3, 6, 9, 10};
		List<List<Integer>> res = arraySplit(arr, 2);
//		for(List<Integer> l: res){
//			System.out.println(l);
//		}
	}

}
