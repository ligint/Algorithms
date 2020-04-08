import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    private int V;
    private LinkedList<Integer> adj[];

    BFS(int v){

        V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v ; i++)
            adj[i] = new LinkedList();
    }

    void addEdge(int v , int w){

        adj[v].add(w);
    }

    void graphBFS(int s){

        boolean[] visited = new boolean[V];

        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);

        while(!q.isEmpty()){

            s = q.poll();
            System.out.println( " " + s + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()){

                int n = i.next();
                if(!visited[n]){
                    visited[n] = true;
                    q.add(n);
                }


            }
        }

    }

    public  static void main(String[] args){

        BFS g = new BFS(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,2);

        System.out.print("BFS of Graph");

        g.graphBFS(1);
    }

}
