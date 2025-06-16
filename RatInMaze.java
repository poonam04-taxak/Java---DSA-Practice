public class RatInMaze {

    //function to check if current move is valid
    static boolean isSafe(int row,int col,int[][]maze,boolean[][] visited,int n){
        return (row>=0 && row<n && col>=0 && col<n && maze[row][col]==1 && !visited[row][col]);

    }

    //main recursive function to find all paths
    static void findPaths(int[][]maze,int row,int col,int n,String path,boolean[][]visited){
        //base case=if destinartion is reached
        if(row==n-1 && col==n-1){
            System.out.println(path);
            return;
        }

        //mark current cell as visited
        visited[row][col]=true;

        //try all 4 direction:D,L,R,U
          

         //move down
        if(isSafe(row+1,col,maze,visited,n))
        findPaths(maze,row+1,col,n,path + "D",visited);

        //move left
        if(isSafe(row,col-1,maze,visited,n))
        findPaths(maze,row,col-1,n,path +"L",visited);
       
        //move rigth
        if(isSafe(row,col+1,maze,visited,n))
        findPaths(maze,row,col+1,n,path + "R",visited);
       
        //move up
        if(isSafe(row-1,col,maze,visited,n))
        findPaths(maze,row-1,col,n,path + "U",visited);


        //backtrack:unmark the current cell
        visited[row][col]=false;
        
    }
    public static void main(String[] args) {
        //sample maze
        int[][] maze={
            {1,0,0,0},
            {1,1,0,1},
            {1,1,0,0},
            {0,1,1,1}
        };
        int n=maze.length;
        boolean[][] visited=new boolean[n][n] ;

        System.out.println("all possible paths from (0,0) to (n-1,n-1):");
         if (maze[0][0] == 1)
            findPaths(maze, 0, 0, n, "", visited);
        else
            System.out.println("No valid path - starting point is blocked.");
     //   findPaths(maze,0,0,n,"",visited);
    }
    
}
