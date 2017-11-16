import java.util.*;
import java.lang.*;
import java.io.*;
 
class dsaproject1
{
int i;
int  parent[];   
    static final int V=9;
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
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++)
{        a++;
            System.out.println(a+" --> "+dist[i]);
}
    }
 
    void dijkstra(int graph[][], int src)
    {
        int dist[] = new int[V];
 parent  = new int[V];
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
                        dist[u]+graph[u][v] < dist[v]) {  
                    dist[v] = dist[u] + graph[u][v];
                   parent[v]=u;
                }
        }
 
        for(i=0;i<V;i++)
System.out.println(i+" "+parent[i]);
    }
 
    public static void main (String[] args)
    {
int b=0,x=1,m,p;
int z,w;

Scanner cin = new Scanner(System.in);
       int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                                  {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                  {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                  {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                  {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                  {0, 0, 4, 14, 10, 0, 2, 0, 0},
                                  {0, 0, 0, 0, 0, 2, 0, 1, 6},
                                  {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                  {0, 0, 2, 0, 0, 0, 6, 7, 0}
                                 };

        dsaproject1 t = new dsaproject1();
while(x==1)
{
System.out.print("enter station");
b=cin.nextInt();
t.dijkstra(graph, b);
w=cin.nextInt();

p=t.parent[w];
while(p!=-1)
{
System.out.println((char)(p+'A')+"*");
p=t.parent[p];
}


System.out.print("wish to continue");
System.out.println("press 1");
x=cin.nextInt();
}
    }
}
