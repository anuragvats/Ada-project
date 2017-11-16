import java.util.*;
import java.lang.*;
import java.io.*;

class Project
{
	 
    static final int V=9;
    int parent[];
    static final int Speed=20;
    static final int val[] = {0, 20, 15, 30, 24, 54, 21, 32, 18};
    int time[] = {0, 2, 3, 5, 5, 6, 9, 7, 8};
    int minDistance(int dist[], Boolean sptSet[])
    {
        
        int min = Integer.MAX_VALUE, min_index=-1;

        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

   
    void printSolution(int dist[], int n)
    {
    	char a='@';
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++)
        {
        	a++;
        	 System.out.println(a+" tt "+dist[i]);	
        }
           
    }

  
    void dijkstra(int graph[][], int src)
    {
        int dist[] = new int[V]; 
 
        parent=new int[V];
       
        Boolean sptSet[] = new Boolean[V];

        
        for (int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

       
        dist[src] = 0;
        parent[src]=-1;
       
        for (int count = 0; count < V-1; count++)
        {
           
            int u = minDistance(dist, sptSet);

            
            sptSet[u] = true;

           
            for (int v = 0; v < V; v++)
            	
            	
                if (!sptSet[v] && graph[u][v]!=0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u]+graph[u][v] < dist[v])
                {
                	dist[v] = dist[u] + graph[u][v];
                	parent[v]=u;
                }
                    
        }
        
        for(int i=0;i<V;i++)
        {
     	   System.out.println(i+" "+parent[i]);
        }
        
      /*  printSolution(dist, V);
       for(int i=0;i<V;i++)
       {
    	   dist[i]=(dist[i]/Speed)+time[i];
       }
       
        
        find(val,dist,24);*/
    }

   
    public void find(int val[], int wt[], int W){
        int K[][] = new int[val.length+1][W+1];
        for(int i=0; i <= val.length; i++){
            for(int j=0; j <= W; j++){
                if(i == 0 || j == 0){
                    K[i][j] = 0;
                    continue;
                }
                if(j - wt[i-1] >= 0){
                    K[i][j] = Math.max(K[i-1][j], K[i-1][j-wt[i-1]] + val[i-1]);
                }else{
                    K[i][j] = K[i-1][j];
                }
            }
        }
        int j=W;
        
        for(int i=val.length; i>0 ;i--)
        {
        	if(K[i][j]!=K[i-1][j])
        	{
        		System.out.println(i+" "+K[i][j]+" "+wt[i-1]);
        		j=j-wt[i-1];
        	}
        	
        	/*
        	for(int j=0;j<=W;j++)
        	{
        		System.out.print(K[i][j] +" ");
        	}
        	System.out.println();
        	*/
        }
        System.out.println(K[val.length][W]);
       // return K[val.length][W];
    }

    
    
	public static void main (String[] args)
	{
		
	   int graph[][] = new int[][]{{0, 34, 0, 0, 0, 0, 0, 38, 0},
	                              {43, 0, 84, 0, 0, 0, 0, 11, 0},
	                              {0, 48, 0, 74, 0, 44, 0, 0, 24},
	                              {0, 0, 67, 0, 96, 14, 0, 0, 0},
	                              {0, 0, 0, 96, 0, 106, 0, 0, 0},
	                              {0, 0, 46, 146, 10, 0, 2, 0, 0},
	                              {0, 0, 0, 0, 0, 2, 0, 1, 6},
	                              {86, 11, 0, 0, 0, 0, 16, 0,67},
	                              {0, 0, 62, 0, 0, 0, 66, 77, 0}
	                             };
	    Project t = new Project();
	  	    t.dijkstra(graph, 0);
	  //  Scann s
	  //  char a1=s.;
	  //  int x=a1-'A';
	  	    int x=3;
	    int a=t.parent[x];
	    while(a!=-1)
	    {
	    	System.out.print((a)+" ");
	    	a=t.parent[a];
	    }
	}
}