import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

//MOCK INTERVIEW Question
/*
 * There are cities in a state. 
 * Every city is given a unique number. 
 * you are given a map of start city and the cities which it connects to. 
 * You are required to print all the possible paths of a user 
 * starting from a city and traveling to another city. 
 * you can assume that there are no cycles in the city DAG. */

public class CityQ {

	Stack<Integer> out = new Stack<>();

	public void printAllPaths(HashMap<Integer, List<Integer>> citiesMap, int start_city, int end_city) {

		out.push(start_city);
		if (start_city == end_city) {
			System.out.println(out);
		}
		else {		
			List<Integer> neighbours = new ArrayList<>();
			neighbours = citiesMap.get(start_city);
	
			if(neighbours != null) {
				for (int i = 0; i < neighbours.size(); i++) {
					printAllPaths(citiesMap, neighbours.get(i), end_city);
				}
			}
		}
		out.pop();
	}
	
	public static void main(String args[]) {
		CityQ cq = new CityQ();
		HashMap<Integer, List<Integer>> citiesMap = new HashMap<>();
		citiesMap.put(1,  Arrays.asList(2,3,6));
		citiesMap.put(2,  Arrays.asList(4,5));
		citiesMap.put(3,  Arrays.asList(2,6));
		citiesMap.put(4,  Arrays.asList(8));
		citiesMap.put(5,  Arrays.asList(6,7,8));
		citiesMap.put(6,  Arrays.asList(7));
		
		
		cq.printAllPaths(citiesMap, 1, 8);
	}

}
