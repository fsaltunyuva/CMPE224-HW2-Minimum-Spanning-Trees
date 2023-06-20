//-----------------------------------------------------
// Title: Directed Depth First Search
// Author: Furkan Safa Altunyuva
// Section: 4
// Assignment: 2
// Description: This class uses Directed Depth First Search Algorithm from the Sedgewick's Algorithms book and lecture slides.
//-----------------------------------------------------
package Q1;

public class DirectedDFS {
    private boolean[] marked;
    boolean hasCycle;

    public DirectedDFS(DirectedGraph G, int s) {
        marked = new boolean[G.getV()];
        dfs(G, s);
    }

    private void dfs(DirectedGraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v))
            if (!marked[w]) dfs(G, w);
    }

    public boolean hasCycle(){
        return hasCycle;
    }

    public boolean visited(int v) {
        return marked[v];
    }

    public boolean isConnected(){
        boolean result = true;

        for(boolean value: marked){
            if(!value){
                result = false;
                break;
            }
        }

        return result;
    }

}