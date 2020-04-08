import java.util.Iterator;
import java.util.LinkedList;

public class DFS {


    private int V;
    private LinkedList<Integer> adj[];

    DFS(int v){

        V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v ; i++)
            adj[i] = new LinkedList<>();
    }

    private void addEdge(int v , int w){
        adj[v].add(w);
    }

    void dfsHelper(int v , boolean[] visited){

        visited[v] = true;
        System.out.println(v + " ");

        Iterator<Integer> i = adj[v].listIterator();

        while(i.hasNext()){

            int n = i.next();
            if(!visited[n])
                dfsHelper(n,visited);
        }

    }

    void graphDFS(){

        boolean[] visited = new boolean[V];

        for(int i = 0; i < V; i++){

            if(visited[i] == false)
                dfsHelper(i,visited);
        }

    }

    public  static void main(String[] args){

        DFS g = new DFS(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,2);

        System.out.print("DFS of Graph");

        g.graphDFS();
    }

}
