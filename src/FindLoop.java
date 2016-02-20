import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

public class FindLoop {
	Graph g;
	Stack<String>visitedNodesInPath = new Stack();
	public FindLoop() {
		g = new Graph();
	}
	
	public void checkIfLoop(String src) {
		if(visitedNodesInPath.contains(src)){
			System.out.println("Loop found");
			Iterator<String> iter = visitedNodesInPath.iterator();
			while (iter.hasNext()){
			    System.out.print(iter.next()+" ");
			}
			System.out.println("\n");
		} else {
			visitedNodesInPath.push(src);
			ArrayList<String>child = new ArrayList<>();
			child = g.outgoingNode.get(src);
			
			for(int i = 0; i < child.size(); i++) {
				checkIfLoop(child.get(i));
				visitedNodesInPath.remove(child.get(i));
			}
			visitedNodesInPath.remove(src);
		}
	}
	
	public static void main(String[] args) {
		FindLoop f = new FindLoop();
		f.checkIfLoop("A");
	}

}
