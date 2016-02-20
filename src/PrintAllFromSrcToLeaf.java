import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class PrintAllFromSrcToLeaf {
	Graph g;
	Stack<String> visitedNodesInPath = new Stack<String>();

	public PrintAllFromSrcToLeaf() {
		g = new Graph();
	}

	public void printAllPathTillLeaf(String src) {
		visitedNodesInPath.push(src);
		ArrayList<String> child = new ArrayList<>();
		child = g.outgoingNode.get(src);
		if (child.isEmpty()) {
			// means this is a leaf node.
			// so print the stack till now.
			Iterator<String> iter = visitedNodesInPath.iterator();
			while (iter.hasNext()) {
				System.out.print(iter.next() + " ");
			}
			System.out.println("\n");
			visitedNodesInPath.pop();
		} else {
			for(int i=0; i < child.size(); i++) {
				printAllPathTillLeaf(child.get(i));
			}
			visitedNodesInPath.pop();
		}

	}

	public static void main(String[] args) {
		PrintAllFromSrcToLeaf p = new PrintAllFromSrcToLeaf();
		p.printAllPathTillLeaf("A");
	}

}
