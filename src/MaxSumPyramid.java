/*There is graph in shape of a pyramid, given a node, find the max sum from a node to its children.*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MaxSumPyramid {
	static HashMap<Integer, ArrayList<Integer>> outgoingNode = new HashMap<>();	
	
	public static int findMaxSum(int node) {
		ArrayList<Integer>currChild = outgoingNode.get(node);
		int max = 0;
		if(currChild != null) {
			for(int i = 0; i < currChild.size(); i++) {
				max = Math.max(max, findMaxSum(currChild.get(i)));
			}
		}
		return max + node;
	}

	public static void main(String[] args) {
			outgoingNode.put(3,new ArrayList<Integer>(Arrays.asList(9,4)));
			outgoingNode.put(9,new ArrayList<Integer>(Arrays.asList(1,8)));
			outgoingNode.put(4,new ArrayList<Integer>(Arrays.asList(8,2)));
			outgoingNode.put(1,new ArrayList<Integer>(Arrays.asList(6,5)));
			outgoingNode.put(8,new ArrayList<Integer>(Arrays.asList(5,10)));
			outgoingNode.put(2,new ArrayList<Integer>(Arrays.asList(10)));
			
			System.out.println(findMaxSum(1));
	}
}
