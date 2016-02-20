import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class DFS {
	Graph g;
	HashSet<String> visitedNodes = new HashSet<>();
	List<String> topoOrder = new LinkedList<>();

	public DFS() {
		g = new Graph();
	}

	public void printTopo(String src) {
		if (visitedNodes.contains(src)) {
			return;
		}

		visitedNodes.add(src);
		List<String> child = g.outgoingNode.get(src);
		for (int i = 0; i < child.size(); i++) {
			printTopo(child.get(i));
		}
		// insert at zero
		topoOrder.add(0, src);
	}

	public void printTopoMain() {
		// you call topo on every node so that nothing is left alone
		Iterator it = g.outgoingNode.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			printTopo((String) pair.getKey());
		}
	}

	public void findDFS(String src) {
		if (visitedNodes.contains(src)) {
			// do nothing. dont print it
		} else {
			System.out.print(src + " ");
			visitedNodes.add(src);
			ArrayList<String> child;
			child = g.outgoingNode.get(src);

			for (int i = 0; i < child.size(); i++) {
				findDFS(child.get(i));
			}
		}

	}

	public static void main(String args[]) {
		DFS dfs = new DFS();
		dfs.findDFS("A");
	}
}