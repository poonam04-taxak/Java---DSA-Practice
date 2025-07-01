import java.util.*;

public class StrongltConnectedComponent {
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
    graph[0].add(new Edge(0,3));

    graph[1].add(new Edge(1,0));
    


    graph[2].add(new Edge(2,1));
    

    graph[3].add(new Edge(3,4));
       
    }

    //topological sorting
    public static void topSort(ArrayList<Edge> graph[],int curr,boolean vis[],Stack<Integer> s){
        //tc m normal dfs perform kro or jate jate curr node ko stack m push kr do
        vis[curr]=true;//dfs
        //visit all neighbours
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            //so our neighbour=e.dest
            if(!vis[e.dest]){
                topSort(graph,e.dest,vis,s);
            }

        }
        s.push(curr);
    }

    //dfs
    public static void dfs(ArrayList<Edge>graph[],int curr,boolean vis[]){
        vis[curr]=true;
        System.out.print(curr + "->");
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph,e.dest,vis);
            }
        }
    }
//T.C=O(V+E)
    public static void KosarajuAlgo(ArrayList<Edge> graph[],int V){
        //step1->get nodes in stack (topological sorting)
        Stack<Integer> s=new Stack<>();
        boolean vis[]=new boolean[V];
        //loop for jo vertices unvisited rh jati h unke liye topological sorting ko call kr do or usko bhi stack k ander store krwa lena h

        for(int i=0;i<V;i++){
            if(!vis[i]){
                topSort(graph,i,vis,s);
            }

        }
//T.C->O(V+E)
        //step2->make a transpose graph
        ArrayList<Edge> transposeGraph[]=new ArrayList[V];
     //initialization
    for(int i=0;i<graph.length;i++){
        vis[i]=false;//re-initialize
        transposeGraph[i]=new ArrayList<Edge>();

    }
    //purane graph pr loop lga kr sare edges nikal lete h
    //hr ak vertex pr jana h or uske neighbour wala edge nikal lo
    for(int i=0;i<V;i++){//ager mhuje kisi graph k sare edges nikal h to uske liye sare vertices pr loop chla do or sare neighbour nikal lo

        for(int j=0;j<graph[i].size();j++){
            Edge e=graph[i].get(j);//e.src->e.dest
   //reverse e.dest->e.src
   transposeGraph[e.dest].add(new Edge(e.dest,e.src));         
        }
        
    }
//T.C->O(V+E)
    //step3->stack se ak ak kr k node nikalo ,visit kro or neighbour visit ko  and print kr do
 //and perform dfs   
   while(!s.isEmpty()){
    int curr=s.pop();//curr ele remove 
    if(!vis[curr]){
        dfs(transposeGraph,curr,vis);
        System.out.println();
    }
    
   } 
    
    } 
    public static void main(String[] args) {
        int V=5;//total no of edges

        ArrayList<Edge>graph[]=new ArrayList[V];
    
        createGraph(graph);

        KosarajuAlgo(graph,V);

}
}