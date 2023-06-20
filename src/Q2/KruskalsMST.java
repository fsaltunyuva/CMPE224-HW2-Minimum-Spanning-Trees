//-----------------------------------------------------
// Title: Kruskal's Minimum Spanning Tree Algorithm
// Author: Furkan Safa Altunyuva
// Section: 4
// Assignment: 2
// Description: This class uses the modified Kruskal's MST Algorithm from the Sedgewick's Algorithms book and lecture slides.
//-----------------------------------------------------
package Q2;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KruskalsMST {

    private Queue<Edge> mst = new LinkedList<Edge>(); //Using Java's Queue structure to store edges

    public KruskalsMST(EdgeWeightedGraph G)
    {
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(); //Using Java's Priority Queue structure to set the priority among edges
        for(Edge e: G.edges()){
            pq.add(e);
        }
        UnionFind uf = new UnionFind(G.getV());
        while (!pq.isEmpty() && mst.size() < G.getV()-1)
        {
            Edge e = pq.poll();
            int v = e.either(), w = e.other(v);
            if (!uf.find(v, w))
            {
                uf.unite(v, w);
                mst.add(e);
            }
        }
    }
    public Iterable<Edge> edges()
    { return mst; }
}
