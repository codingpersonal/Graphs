//Assuming there are no loops in the graph.
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class PrintAllPathsFromSrcToDes {
	Graph g;
	Stack<String> visitedNodesInPath = new Stack<String>();

	public PrintAllPathsFromSrcToDes() {
		g = new Graph();
	}

	public void PrintAllPaths(String src, String des) {
		visitedNodesInPath.push(src);
		if (src == des) {
			System.out.println("Path found.");
			Iterator<String> iter = visitedNodesInPath.iterator();
			while (iter.hasNext()) {
				System.out.print(iter.next() + " ");
			}
			System.out.println("\n");
		} else {
			ArrayList<String> child = new ArrayList<>();
			child = g.outgoingNode.get(src);
			for (int i = 0; i < child.size(); i++) {
				PrintAllPaths(child.get(i), des);
			}
		}
		visitedNodesInPath.pop();
	}

	public static void main(String[] args) {
		PrintAllPathsFromSrcToDes p = new PrintAllPathsFromSrcToDes();
		p.PrintAllPaths("G", "Y");
	}

}
