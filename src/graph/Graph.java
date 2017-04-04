package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

import LinkedList.LinkedList;
import LinkedList.LinkedList.Node;

public class Graph {

	ArrayList<LinkedList> adj;
	int V;

	public Graph(int v) {
		V = v;
		adj = new ArrayList<LinkedList>(V);
		for (int i = 0; i < V; i++) {
			adj.add(i, new LinkedList());
		}

	}

	void addEdge(int v, int e) {
		adj.get(v).add(e);
	}

	void depthFirstSearch(int v) {
		Boolean[] visited = new Boolean[V];
		Arrays.fill(visited, false);
		depthFirstSearchUtil(v, visited);
	}

	void depthFirstSearchUtil(int v, Boolean[] visited) {
		if (visited[v] == true) {
			return;
		}

		System.out.println(v);
		visited[v] = true;

		Node n = adj.get(v).head;

		while (n != null) {
			depthFirstSearchUtil(n.getData(), visited);
			n = n.getNext();
		}
	}

	void breadthFirstSearch(int v) {
		Boolean[] visited = new Boolean[V];
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();

		Arrays.fill(visited, false);

		q.add(v);

		while (q.size() > 0) {
			int curr = q.pop();

			System.out.println(curr);
			Node n = adj.get(curr).head;

			while (n != null) {
				if (visited[n.getData()] != true) {
					q.push(n.getData());
					visited[n.getData()] = true;
				}

				n = n.getNext();
			}

		}

	}

	public static void main(String[] args) {

		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(1, 3);
		g.addEdge(2, 1);
		g.addEdge(2, 3);
		g.addEdge(2, 2);

		g.depthFirstSearch(0);

		g.breadthFirstSearch(0);
	}

}
