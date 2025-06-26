
import java.util.*;

public class DisconnectedGraph {
   //step1->create edge
    static class Edge{
        int src;//source
        int dest;//destination

        //constructor
       public Edge(int s,int d){
        this.src=s;
        this.dest=d;

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
    graph[0].add(new Edge(0,1));
    graph[0].add(new Edge(0,2));

    graph[1].add(new Edge(1,0));
    graph[1].add(new Edge(1,3));


    graph[2].add(new Edge(2,0));
    graph[2].add(new Edge(2,4));

    graph[3].add(new Edge(3,1));
    graph[3].add(new Edge(3,4)); 
    graph[3].add(new Edge(3,5));
    
    graph[4].add(new Edge(4,2)); 
    graph[4].add(new Edge(4,3)); 
    graph[4].add(new Edge(4,5));
    
    graph[5].add(new Edge(5,3)); 
    graph[5].add(new Edge(5,4)); 
    graph[5].add(new Edge(5,6));

    graph[6].add(new Edge(6,5)); 
    }

    //use BFS for traversal

    public static void bfs(ArrayList<Edge> graph[],int V,boolean vist[],int start){
        //create a queue
        Queue<Integer> q=new LinkedList<>();
        
     //add starting point in queue
     q.add(start);
     //loop jb tk queue empty nhi ho jata ele remove krte jao print krte jao or visit krte jao
     while(!q.isEmpty()){
        //remove current from queue
        int curr=q.remove();
        //ager curr ko abhi tk visit nhi kiya h to visit array m dalo do ager visit ho chuka h to direct queue se remove kr do
        if(vist[curr]==false){
            System.out.print(curr+ "-> ");
            vist[curr]=true;
 
            //curr k sare neighbour ko queue m add kr dengye
            for(int i=0;i<graph[curr].size();i++){
                Edge e=graph[curr].get(i);
                q.add(e.dest);
            }

        }
     }
    } 

    //DFS traversal
    public static void dfs(ArrayList<Edge> graph[],int curr,boolean vist[]){
        System.out.print(curr+ "-> ");
        vist[curr]=true;

        //visit neighbours
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(vist[e.dest]==false)
            dfs(graph,e.dest,vist);
        }

    }
    public static void main(String[] args) {
        int V=7;//total no of edges

        ArrayList<Edge>graph[]=new ArrayList[V];
    
        createGraph(graph);

        boolean vist[]=new boolean[V];
        //T.C=O(V+E)

        //if dfs is also discoonected graph then use these:
        for(int i=0;i<V;i++){
            if(vist[i]==false){
                dfs(graph,i,vist);
            }
        }
   
      //  dfs(graph,0,vist);
        

        System.out.println();
}
}