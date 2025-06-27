import java.util.ArrayList;

public class CycleDetectionInDFS {
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
    graph[0].add(new Edge(0,2));

    graph[1].add(new Edge(1,0));


    graph[2].add(new Edge(2,3));

    graph[3].add(new Edge(3,0));  
    }

    //cycle detection   T.C->O(V+E)
    public static boolean isCycleDirected(ArrayList<Edge>graph[],boolean vis[],int curr,boolean rec[]){
        vis[curr]=true;
        rec[curr]=true;

        //loop for neighbours
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            //cycle condition
            if(rec[e.dest]){//ager neighbour rec stack k ander exist krta h to cycle h
                return true;

            }
  else if(!vis[e.dest]){
   if( isCycleDirected(graph,vis,e.dest,rec)){
    return true;
   }
  }
        }
        rec[curr]=false;
        return false;
    }
    public static void main(String[] args) {
        int V=4;//total no of edges

        ArrayList<Edge>graph[]=new ArrayList[V];
    
        createGraph(graph);

        boolean vis[]=new boolean[V];
        boolean rec[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){//jb tk sare neighbour visit nhi ho jate call iscycledetection
               boolean isCycle= isCycleDirected(graph,vis,0,rec);
                if(isCycle){//cycle exist to print kra do or break kr jao vnha se
                    System.out.println(isCycle);
                    break;
                }
            }
        }
    }
}
