import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	Graph g;
	ArrayList<String>visitedNodes = new ArrayList<>();
	Queue<String>bfs = new LinkedList<>();
	
	public BFS() {
		g = new Graph();
	}

	public void findBFS(String src){
		if(visitedNodes.contains(src)) {
			//do nothing. its already visited.
		} else {
			visitedNodes.add(src);
			//push src in the graph
			bfs.add(src);
			//add a null string after a level is parsed. to track of breadth.
			bfs.add(null);
			
			while(!(bfs.size() == 1 && bfs.peek()==null)) {
				String currNode = bfs.remove();
				if(currNode == null) {
					bfs.add(null);
				} else {
					System.out.print(currNode+" ");
					ArrayList child = g.outgoingNode.get(currNode);
					for(int i = 0; i < child.size(); i++) {
						if(!visitedNodes.contains(child.get(i))) {
							visitedNodes.add((String) child.get(i));
							bfs.add((String) child.get(i));
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		BFS b = new BFS();
		b.findBFS("A");
	}

}
