import java.util.*;

public class BellmanFordAlgo {
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

    graph[1].add(new Edge(1,2,-4));


    graph[2].add(new Edge(2,3,2));

    graph[3].add(new Edge(3,4,4));
  
   // graph[4].add(new Edge(4,1,-1)); 
   graph[4].add(new Edge(4,1,-10));//here we have -ve wt cycle
}

     
    public static void Ford(ArrayList<Edge> graph[],int src,int V){
       int dist[]=new int[V];//create distance matrix or array
        //initialize all node with infinity in array
        for(int i=0;i<V;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        //sbse bhar wala loop V-1 tk chelega
        for(int k=0;k<V-1;k++){  //O(V)
            //sare edge nikalne k liye, T.C=dono loop ki->O(E)
            for(int i =0;i<V;i++){
                //for finding neighbour of each edge
                for(int j=0;j<graph[i].size();j++){
                    Edge e=graph[i].get(j);
                    int u=e.src;
                    int v=e.dest;

                    //relexation
                    if(dist[u]!=Integer.MAX_VALUE && dist[u]+e.wt<dist[v]){//here we write this bcoz java k ander ager infinity k ander +ve value ko jodengye to hmari value -ve ho jayegi
                        dist[v]=dist[u]+e.wt;
                    }

                }

            }
        }
          //detect -ve wt cycle
            //sare edge nikalne k liye, T.C=dono loop ki->O(E)
            for(int i =0;i<V;i++){
                //for finding neighbour of each edge
                for(int j=0;j<graph[i].size();j++){
                    Edge e=graph[i].get(j);
                    int u=e.src;
                    int v=e.dest;

                    //relexation
                    if(dist[u]!=Integer.MAX_VALUE && dist[u]+e.wt<dist[v]){//here we write this bcoz java k ander ager infinity k ander +ve value ko jodengye to hmari value -ve ho jayegi
                System.out.println("negative weight cycle");
                    }
                }
            }
        //print all distances
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i] + "->");
        }
        System.out.println();

    }
    public static void main(String[] args) {
        int V=5;//total no of edges

        ArrayList<Edge>graph[]=new ArrayList[V];
    
        createGraph(graph);
         
        Ford(graph,0,V);
}
}
