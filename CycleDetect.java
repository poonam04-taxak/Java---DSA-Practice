import java.util.*;

public class CycleDetect {
    
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
    graph[0].add(new Edge(0,4));

    graph[1].add(new Edge(1,0));
    graph[1].add(new Edge(1,2));
    graph[1].add(new Edge(1,4));


    graph[2].add(new Edge(2,1));
    graph[2].add(new Edge(2,3));

    graph[3].add(new Edge(3,2));   

    graph[4].add(new Edge(4,0));
    graph[4].add(new Edge(4,1));
    graph[4].add(new Edge(4,5));

    graph[5].add(new Edge(5,4));
}
//T.C->O(V+E)
//detect cyle by using DFS in undirected graph
public static boolean isCycleUnd(ArrayList<Edge>graph[],boolean vis[],int curr,int parent){
    vis[curr]=true;
    for(int i=0;i<graph[curr].size();i++){
        Edge e=graph[curr].get(i);//get dest of e

        //cycle conditions
        if(vis[e.dest] && e.dest!=parent){
            //ager e.dest(neighbiur) visted h or vo (dest) apka parent nhi h to cycle 100% h
              return true;
        }
        else if(!vis[e.dest]){
       //ager neighbour visted nhi h to vist kro ager cycle h to true
       if(isCycleUnd(graph,vis,e.dest,curr)){
        return true;//cycle exist
       }
        }
    }
        return false;
    
}
    public static void main(String[] args) {
        int V=6;//total no of edges

        ArrayList<Edge>graph[]=new ArrayList[V];
    
        createGraph(graph);

      System.out.println(isCycleUnd(graph,new boolean[V],0,-1));
    }
}

