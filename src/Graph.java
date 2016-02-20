import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Graph {
	HashMap<String, ArrayList<String>> outgoingNode = new HashMap<>();
	public Graph() {
		outgoingNode.put("A",new ArrayList<String>(Arrays.asList("B","C","D")));
		outgoingNode.put("B",new ArrayList<String>(Arrays.asList("E","F")));
		outgoingNode.put("C",new ArrayList<String>(Arrays.asList("F")));
		outgoingNode.put("D",new ArrayList<String>(Arrays.asList("Y")));
		outgoingNode.put("E",new ArrayList<String>(Arrays.asList("G")));
		outgoingNode.put("F",new ArrayList<String>(Arrays.asList("X","Y")));
		outgoingNode.put("G",new ArrayList<String>(Arrays.asList()));
		outgoingNode.put("X",new ArrayList<String>(Arrays.asList()));
		outgoingNode.put("Y",new ArrayList<String>(Arrays.asList()));
	
	}
}
