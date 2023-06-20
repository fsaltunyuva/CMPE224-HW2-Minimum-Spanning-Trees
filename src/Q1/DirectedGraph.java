//-----------------------------------------------------
// Title: Directed Graph Implementation
// Author: Furkan Safa Altunyuva
// Section: 4
// Assignment: 2
// Description: This class uses the modified implementation of Directed Graph from the Sedgewick's Algorithms book and lecture slides.
//-----------------------------------------------------
package Q1;

import java.util.ArrayList;

public class DirectedGraph {
    private final int V; //Vertex count
    private ArrayList<Integer>[] adj; //An array that stores ArrayLists in it

    public DirectedGraph(int V) {
        this.V = V;
        adj = new ArrayList[V]; //Initializing the adj
        for (int v = 0; v < V; v++)
            adj[v] = new ArrayList<Integer>();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int getV() {
        return V;
    }

    public ArrayList<Integer>[] getAdj() {
        return adj;
    }

}