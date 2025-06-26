
import java.util.*;
public class WeightedGraph{

    //step1->create edge
    static class Edge{
        int src;//source
        int dest;//destination
        int wt;//weight

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
    graph[0].add(new Edge(0,2,2));

    graph[1].add(new Edge(1,2,10));
    graph[1].add(new Edge(1,3,0));


    graph[2].add(new Edge(2,0,2));
    graph[2].add(new Edge(2,1,10));
    graph[2].add(new Edge(2,3,-1));

    graph[3].add(new Edge(3,1,0));
    graph[3].add(new Edge(3,2,-1));   
    }
    public static void main(String[] args) {
        int V=4;//total no of edges

        ArrayList<Edge>graph[]=new ArrayList[V];
    
        createGraph(graph);

        //print neighbours of 2 vertex
        System.out.println("neighbours of vertex 2 and their weight are:");
        for(int i=0;i<graph[2].size();i++){
            Edge e=graph[2].get(i);
            System.out.println("->" +e.dest + " , " +e.wt);//e sourse h to ye 2 hi rhega dest change hoga

        }
    }
}