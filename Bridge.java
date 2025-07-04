import java.util.*;
public class Bridge{


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
    graph[0].add(new Edge(0,3));


    graph[1].add(new Edge(1,0));
    graph[1].add(new Edge(1,2));


    graph[2].add(new Edge(2,0));
    graph[2].add(new Edge(2,1));

    graph[3].add(new Edge(3,0));
    graph[3].add(new Edge(3,4));
  //  graph[3].add(new Edge(3,5));   

    graph[4].add(new Edge(4,3));
//    graph[4].add(new Edge(4,5));

  //  graph[5].add(new Edge(5,3));
    //graph[5].add(new Edge(5,4));


}
//dfs
public static void dfs(ArrayList<Edge>graph[],int curr,boolean vis[],int dt[],int low[],int time,int par){
    vis[curr]=true;
    dt[curr]=low[curr]=++time;//starting m dt and low same honge
    //find neighbours
    for(int i=0;i<graph[curr].size();i++){
        Edge e= graph[curr].get(i);

        //now we have 3 cases of neighbours
        //1->ager dest ki value parent k equal h to kuch nhi krna 
        if(e.dest==par){
            continue;
        }
        //case 2->neighbour unvisited h
        else if(!vis[e.dest]){
            dfs(graph,e.dest,vis,dt,low,time,curr);
            //update low
            low[curr]=Math.min(low[curr],low[e.dest]);//low curr ki value ko comare krenge dest ki low se dono m s jo km hogi vo hi curr ki value hogi
            //check krengye kya abhi jis edge se gyi hu knhi vo hi to bridge nhi h
//Bridge condition
           if(dt[curr]<low[e.dest]){
            System.out.println("bridge is: "+curr + "-----"+ e.dest);

           }

        }
        //case 3->visited neighbour means there is no bridge
    
        else{
           low[curr]=Math.min(low[curr],dt[e.dest]);

        }
    }
}
public static void getBridge(ArrayList<Edge>graph[],int V){
    int dt[]=new int[V];
    int low[]=new int[V];
    int time=0;
    boolean vis[]=new boolean[V];

    for(int i=0;i<V;i++){
        if(!vis[i]){
            dfs(graph,i,vis,dt,low,time,-1);//-1 for parent at starting parent of node is -1

        }
    }

}
    public static void main(String[] args) {
        int V=5;//total no of edges

        ArrayList<Edge>graph[]=new ArrayList[V];
    
        createGraph(graph);

        getBridge(graph,V);
    }
}