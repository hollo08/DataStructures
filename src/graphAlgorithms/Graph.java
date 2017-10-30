package graphAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	char value;
	List<Graph> adjacencyList;

	public Graph(char value) {
		this.value = value;
		this.adjacencyList = new ArrayList<Graph>();
	}

	public void addNode(Graph graph) {
		this.adjacencyList.add(graph);
	}

	public List<Graph> getNeighbours() {
		return adjacencyList;
	}
}
