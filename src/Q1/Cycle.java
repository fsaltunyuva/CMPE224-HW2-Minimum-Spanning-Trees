//-----------------------------------------------------
// Title: Cycle
// Author: Furkan Safa Altunyuva
// Section: 4
// Assignment: 2
// Description: This class uses Depth-First Search to find the given graph has a cycle or not
//-----------------------------------------------------
package Q1;

public class Cycle {
    private boolean[] marked;
    boolean hasCycle;

    public Cycle(DirectedGraph G)
    {
        marked = new boolean[G.getV()];
        for(int s = 0; s < G.getV(); s++) {
            if(!marked[s])
                dfs(G, s, s);
        }
    }

    private void dfs(DirectedGraph G, int v, int parent) { //Standard dfs algorithm supported with hasCycle condition
        marked[v] = true;
        for (int w : G.adj(v))
            if (!marked[w]) dfs(G, w, v);
            else if (w != parent) hasCycle = true;
    }

    public boolean hasCycle(){return hasCycle;}

}
