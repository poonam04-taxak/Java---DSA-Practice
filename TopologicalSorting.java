import java.util.*;

public class TopologicalSorting {
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


    graph[2].add(new Edge(2,3));

    graph[3].add(new Edge(3,1));

    graph[4].add(new Edge(4,0));
    graph[4].add(new Edge(4,1));
    
    graph[5].add(new Edge(5,0));
    graph[5].add(new Edge(5,2));
    
    }
//T.C->O(V+E)
    //topological sorting->use dfs algo for this
    public static void topSort(ArrayList<Edge>graph[],int curr,boolean vis[],Stack<Integer>stack){
        vis[curr]=true;
        //all neighbours
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                topSort(graph,e.dest,vis,stack);
            }
        }
        stack.push(curr);
    }

    public static void  sort(ArrayList<Edge>graph[],int V){
        boolean vis[]=new boolean[V];
        Stack<Integer>stack=new Stack<>();
 
        //jb tk sare node visit nhi ho jate tb tk topsort call krna h or stack m add krna h
        for(int i=0;i<V;i++){
            if(!vis[i]){
                topSort(graph,i,vis,stack);
            }
        }
        while(!stack.isEmpty()){//jb tk stack empty nhi ho jati ele pop krate rho->get ans topological sorting
            System.out.print(stack.pop()+ "-> ");
        }
    }
    public static void main(String[] args) {
        int V=6;//total no of edges

        ArrayList<Edge>graph[]=new ArrayList[V];
    
        createGraph(graph);

        sort(graph,V);

          }
    }

