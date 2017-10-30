package graphAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
	List<Graph> unvisited = new ArrayList<Graph>();
	List<Graph> visited = new ArrayList<Graph>();
	Stack<Graph> stack = new Stack<Graph>();

	public static void main(String[] args) {
		TopologicalSort obj = new TopologicalSort();
		obj.createGraph();
		obj.topologicalSort();
		while(!obj.stack.isEmpty()){
			System.out.println(obj.stack.pop().value);
		}
	}

	private void topologicalSort() {
		while (unvisited.size() != 0) {
			//Random rand = new Random();
			//Graph node = unvisited.get(rand.nextInt(unvisited.size()));
			Graph node = unvisited.get(unvisited.size() -1 );
			unvisited.remove(node);
			visited.add(node);
			topSortUtil(node);
			// List<Graph> childNodes = getUnivisitedChild(node);
		}
	}

	private void topSortUtil(Graph node) {
		List<Graph> neighbours = getUnivisitedChild(node);
		if (neighbours.size() != 0) {
			for (Graph neighbour : neighbours) {
				unvisited.remove(neighbour);
				visited.add(neighbour);
				topSortUtil(neighbour);
			}
		}
		stack.push(node);
	}

	private List<Graph> getUnivisitedChild(Graph node) {
		List<Graph> unvisitedchild = new ArrayList<Graph>();
		for (Graph child : node.getNeighbours())
			if (unvisited.contains(child))
				unvisitedchild.add(child);
		return unvisitedchild;
	}

	private void createGraph() {
		Graph graphA = new Graph('A');
		Graph graphB = new Graph('B');
		Graph graphC = new Graph('C');
		Graph graphD = new Graph('D');
		Graph graphE = new Graph('E');
		Graph graphF = new Graph('F');
		Graph graphG = new Graph('G');
		graphA.addNode(graphC);
		graphB.addNode(graphC);
		graphB.addNode(graphE);
		graphC.addNode(graphD);
		graphD.addNode(graphF);
		graphE.addNode(graphF);
		graphF.addNode(graphG);
		unvisited.add(graphA);
		unvisited.add(graphB);
		unvisited.add(graphC);
		unvisited.add(graphD);
		unvisited.add(graphE);
		unvisited.add(graphF);
		unvisited.add(graphG);
	}
}
