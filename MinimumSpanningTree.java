import java.util.*;

public class MinimumSpanningTree {
    
    //step1->create edge
    static class Edge{
        int src;//source
        int dest;//destination
        int wt;

        //constructor
       public Edge(int s,int d,int w){
        this.src=s;
        this.dest=d;
        this.wt=w;

       }
    }

    //create graph
    public static void createGraph(ArrayList<Edge>graph[])
{
    for(int i=0;i<graph.length;i++){
        //hr index pr empty arraylist create ki h
        graph[i]=new ArrayList<Edge>();//jb hm arraylist bnate h to starting m usme null value hoti h null ka mtlb undefined to ise remove krne k liye hm empty krenge arraylist ko fir usme ele dalenge
    //ager null m direct add krengye to error aayega

    }
    graph[0].add(new Edge(0,1,10));
    graph[0].add(new Edge(0,2,15));
    graph[0].add(new Edge(0,3,30));

    graph[1].add(new Edge(1,0,10));
    graph[1].add(new Edge(1,3,40));


    graph[2].add(new Edge(2,0,15));
    graph[2].add(new Edge(2,3,50));

    graph[3].add(new Edge(3,1,40));
    graph[3].add(new Edge(3,2,50));   
    }
    //class pair
    public static class pair implements Comparable<pair>{
        int node;
        int cost;

        public pair(int n,int c){
            this.node=n;
            this.cost=c;
        }

        @Override
         public int compareTo(pair p2){
            return this.cost-p2.cost;//sorting order->ascending 
        }
    }
    //algorithm of prim's algo and T.C of prim algo is ElogE
     public static void Prims(ArrayList<Edge>graph[],int V){
        PriorityQueue<pair>pq=new PriorityQueue<>();//pair class->int node,int cost and it is our non-mst
        boolean vis[]=new boolean[V];//mst
        pq.add(new pair(0,0));

        int mstCost=0;

        while(!pq.isEmpty()){
            pair curr=pq.remove();
            //check krna h kya ye curr visit to nhi h
            if(!vis[curr.node]){
                vis[curr.node]=true;
                  mstCost +=curr.cost;
                
                  //check neighbour
                  for(int i=0;i<graph[curr.node].size();i++){
                    Edge e=graph[curr.node].get(i);
                    if(!vis[e.dest]){
                        pq.add(new pair(e.dest,e.wt));
                    }
                  }

            }
        }
        System.out.println("minimum cost of mst: "+mstCost);
     }
    public static void main(String[] args) {
        int V=4;//total no of edges

        ArrayList<Edge>graph[]=new ArrayList[V];
    
        createGraph(graph);
        Prims(graph,V);
}
}