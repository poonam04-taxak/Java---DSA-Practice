import java.util.*;
public class DijkstraAlgo {

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
    graph[0].add(new Edge(0,1,2));
    graph[0].add(new Edge(0,2,4));

    graph[1].add(new Edge(1,3,7));
    graph[1].add(new Edge(1,2,1));


    graph[2].add(new Edge(2,4,3));

    graph[3].add(new Edge(3,5,1));

    graph[4].add(new Edge(4,3,2));
    graph[4].add(new Edge(4,5,5));   
    }

    //pair class
    public static class pair implements Comparable<pair>{
//comparable->interface in  java        
        int node;
        int dist;//distance

        public pair(int n,int d){
            this.node=n;
            this.dist=d;

        }
        //logic -> how to compare pairs
        @Override
        public int compareTo(pair p2){//compareto fun can return three type of values ->0,+ve,-ve
//if it return -ve vlue then it means this wala piar chota h,0->dono equal h,+ve->this wala bda h

            return this.dist-p2.dist;//jiska distance chota ho vo phle aaye //ascending
            //return p2.dist-this.dist;//descending

        }
    }

//T.C->O(E+ ElogV),ElogV->priority queue T.C

    public static void dijkstra(ArrayList<Edge>graph[],int src,int V){
    PriorityQueue<pair> pq=new PriorityQueue<>();//ques->pq k ander pair to store ho gya pr isye kaise pta ki priority kise deni h distance ko ya node ko isliye hm implement krenge comparable ko
    int dist[]=new int[V];
    //initalization
    for(int i=0;i<V;i++){
        if(i!=src){//0
            dist[i]=Integer.MAX_VALUE;//infinity
        }
    }
    boolean vis[]=new boolean[V];
    
    //add node in queue
    pq.add(new pair(0,0));
     
    while(!pq.isEmpty()){
        pair curr=pq.remove();//shortest dist wala pair remove kiya h[0,0] remove and vist=true
     if(!vis[curr.node]){
        vis[curr.node]=true;

        //then update its neighbour
        for(int i=0;i<graph[curr.node].size();i++)
{
    Edge e=graph[curr.node].get(i);
    int u=e.src;
    int v=e.dest;//weight
    //relaxation
    if(dist[u]+e.wt<dist[v]){
        //update v
        dist[v]=dist[u]+e.wt;
        pq.add(new pair(v,dist[v]));
    }

} 
    } 
    }
    for(int i=0;i<V;i++){
        System.out.print(dist[i]+ "->");
    }
    System.out.println();
}
    public static void main(String[] args) {
        int V=6;//total no of edges

        ArrayList<Edge>graph[]=new ArrayList[V];
    
        createGraph(graph);

        dijkstra(graph,0,V);
    }
}
