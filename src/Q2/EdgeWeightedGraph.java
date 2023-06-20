//-----------------------------------------------------
// Title: Edge Weighted Graph Implementation
// Author: Furkan Safa Altunyuva
// Section: 4
// Assignment: 2
// Description: This class uses the modified Edge Weighted Graph Implementation from the Sedgewick's Algorithms book and lecture slides.
//-----------------------------------------------------
package Q2;

import java.util.ArrayList;

public class EdgeWeightedGraph {
    private final int V; //Vertex count
    private ArrayList<Edge>[] adj; //An array that stores ArrayLists in it

    public EdgeWeightedGraph(int V) {
        this.V = V;
        adj = new ArrayList[V]; //Initializing the adj with V
        for (int v = 0; v < V; v++)
            adj[v] = new ArrayList<Edge>();
    }

    public void addEdge(Edge e) {
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges(){
        ArrayList<Edge> b = new ArrayList<Edge>();
        for (int v = 0; v < V; v++)
            for (Edge e : adj[v])
                if (e.other(v) > v) b.add(e);
        return b;
    }

    public int getV() {
        return V;
    }

    public ArrayList<Edge>[] getAdj() {
        return adj;
    }
}
