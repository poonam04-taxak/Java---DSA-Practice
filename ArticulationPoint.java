import java.util.*;

public class ArticulationPoint {
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
     graph[0].add(new Edge(0,2));
      graph[0].add(new Edge(0,3));

    graph[1].add(new Edge(1,0));
    graph[1].add(new Edge(1,2));


    graph[2].add(new Edge(2,0));
    graph[2].add(new Edge(2,1));
    

    graph[3].add(new Edge(3,0));
    graph[3].add(new Edge(3,4));
    
     graph[4].add(new Edge(4,3));
    }
//T.C=O(V+E)
    public static void dfs(ArrayList<Edge>graph[],int curr,int par,int dt[],int low[],boolean vis[],int time,boolean ap[])
    {
        vis[curr]=true;
        dt[curr]=low[curr]=++time;
        int children=0;

        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            int neigh=e.dest;

            //case 1->if parent is equal to neighbour do nothing
            if(par==neigh){
                continue;
            }
           //case 2->neighbour already visited by another node so no ap will form
           //to low ko update ke dengye
           // // Back edge
           else if(vis[neigh]){
                low[curr]=Math.min(low[curr],dt[neigh]);
           }
     else{      //case3->if unvisited then visit it and udate low 
           dfs(graph,neigh,curr,dt,low,vis,time,ap);
           low[curr]=Math.min(low[curr],low[neigh]);
        //AP condition
        if(dt[curr]<=low[neigh] && par!=-1){
            ap[curr]=true;
        }
        children++;
        }
    }
    //starting node condition 
    if(par==-1 && children>1){
        ap[curr]=true;
    }
    }

    public static void getAp(ArrayList<Edge>graph[],int V){
        int dt[]=new int[V];
        int low[]=new int[V];
        boolean vis[]=new boolean[V];
        boolean ap[]=new boolean[V];//check krne k liye ki konsa node ap h ya nhi h
        int time=0;

        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(graph,i,-1,dt,low,vis,time,ap);
            }
        }
        for(int i=0;i<V;i++){
            if(ap[i]){
            System.out.println("AP IS: "+ i);
        }
    }
}

    public static void main(String[] args) {
        int V=5;//total no of edges

        ArrayList<Edge>graph[]=new ArrayList[V];
    
        createGraph(graph);
    getAp(graph,V);
    }   
}
