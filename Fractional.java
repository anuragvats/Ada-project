
import javax.imageio.ImageIO;
import javax.swing.*;          
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
 
//Step 11 : Implementing ActionListener
class Demo extends JFrame implements ActionListener{		     
		Container c; 	
		DefaultListModel<String> l1;
		int graph[][] = new int[][]{{0, 24, 0, 0, 0, 0, 0, 48, 0},
            {23, 0, 84, 0, 0, 0, 0, 11, 0},
            {0, 48, 0, 74, 0, 44, 0, 0, 24},
            {0, 0, 27, 0, 96, 45, 0, 0, 0},
            {0, 0, 0, 96, 0, 167, 0, 0, 0},
            {0, 0, 46, 146, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {86, 11, 0, 0, 0, 0, 16, 0,67},
            {0, 0, 62, 0, 0, 0, 66, 77, 0}
           };
		JLabel Label=new JLabel("Money");   
		JLabel Label2 =new JLabel("Time");
		JLabel Label3 =new JLabel("Speed");
		JLabel Label4 =new JLabel("TimeLimit");
		
		JTextField money=new JTextField("1 20 15 30 24 54 21 32 18");  
		JTextField time_in_each_house=new JTextField("1 5 3 4 5 7 9 7 8");  
		
		
		JTextField speedofthief=new JTextField("10");  
		//JTextField time_in_each_house=new JTextField("0 2 3 5 5 6 9 7 8"); 
		JTextField maxtimeofthief=new JTextField("12");  
		
		JButton login=new JButton("Buy");
		
		Demo()
		{
				c=this.getContentPane();   
				c.setLayout(null);    
				c.setBackground(Color.BLUE);  
			
				
				
				Label.setBounds(100,50,100,40);     
				Label2.setBounds(100,140,100,40);
				Label3.setBounds(100,240,100,40);
				Label4.setBounds(100,340,100,40);
				
				money.setBounds(250,50,200,40);
				time_in_each_house.setBounds(250,140,200,40);
				speedofthief.setBounds(250,240,200,40);
				maxtimeofthief.setBounds(250,340,200,40);
				
				login.setBounds(280,390,140,50); 
				login.addActionListener(this);      
				
				Font f=new Font("Arial", Font.BOLD,24);  
				Label.setFont(f);
				Label2.setFont(f);
				Label3.setFont(f);
                Label4.setFont(f);
				money.setFont(f);
				time_in_each_house.setFont(f);
				speedofthief.setFont(f);
				maxtimeofthief.setFont(f);
				login.setFont(f);
				
				l1 = new DefaultListModel<>();  
				  System.out.println("ans."+Fractional.ans);
		          
		          
		          JList<String> list1 = new JList<>(l1);  
		         // list.setBounds(100,100, 75,75);  
		          list1.setBounds(280,450,140,50);
		          c.add(list1);  

				
				
				// Step 15 : adding hand cursor on button
				 //applying cursor to the button
	
				c.add(Label);
				c.add(Label2);
				c.add(Label3);
				c.add(Label4);
				c.add(money);
				c.add(time_in_each_house);
				c.add(speedofthief);
				c.add(maxtimeofthief);
				
				c.add(login);       
		}		
 
	public void actionPerformed(ActionEvent e){
		
		//	System.out.println("Hello");
			String[] usermoney=money.getText().toString().split("\\s");//the value in the text field will be store in usermoney    
			String[] time_in_house=time_in_each_house.getText().toString().split("\\s");
			String sp=speedofthief.getText().toString();
			Fractional.speedofthief=Integer.parseInt(sp);
			String kp=maxtimeofthief.getText().toString();
			Fractional.ti=Integer.parseInt(kp);
			
			 
			 
			// System.out.println(usermoney[0]);
			for(int i=0;i<9;i++)
			{
				System.out.println(usermoney[i]+" "+time_in_house[i]);
				Fractional.val[i]=Integer.parseInt(usermoney[i]);
				Fractional.time[i]=Integer.parseInt(time_in_house[i]);
			}Fractional t=new Fractional();
			
			t.dijsktra(graph, 0);
			l1.addElement("Maximum Profit "+Fractional.ans);  
				         
			
	} 	
}
 
public class Fractional{
	
	static int ti;
	static int ans;
    static final int V=9;
    static  int speedofthief;
    static  int val[]=new int[V];
    static  int time[]=new int[V] ;
    int dist[];
    // = {1 20 15 30 24 54 21 32 18}{1 2 3 5 5 6 9 7 8}
    int minDistance(int dist[], Boolean repeatset[])
    {
        
        int min = Integer.MAX_VALUE, min_index=-1;

        for (int v = 0; v < V; v++)
            if (repeatset[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

   
   void printSolution(int dist[], int n)
    
    
  {
   
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++)
        {
        	
        	 System.out.println(i+" tt "+dist[i]);	
       }
         
   }

   
    void dijsktra(int graph[][], int src)
    {
         dist = new int[V]; 

       
        Boolean repeatset[] = new Boolean[V];

        
        for (int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            repeatset[i] = false;
        }

       
        dist[src] = 0;

       
        for (int count = 0; count < V-1; count++)
        {
           
            int u = minDistance(dist, repeatset);

            
            repeatset[u] = true;

           
            for (int v = 0; v < V; v++)

               
                if (!repeatset[v] && graph[u][v]!=0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u]+graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

       for(int i=0;i<V;i++)
       {
    	   dist[i]=(dist[i]/speedofthief)+time[i];
       }
       
       int a[][]=new int[2][V];
       for(int i=0;i<V;i++)
       {
    	   a[0][i]=val[i];
    	   a[1][i]=dist[i];
       }
       int temp1,temp2;
       for(int i=0;i<V-1;i++)
       {
    	   for(int j=0;j<V-1;j++)
    	   {
    		   if((a[0][j]/a[1][j])<(a[0][j+1]/a[1][j+1]))
    		   {
    			   temp1=a[0][j];
    			   temp2=a[1][j];
    			   a[0][j]=a[0][j+1];
    			   a[1][j]=a[1][j+1];
    			   a[0][j+1]=temp1;
    			   a[1][j+1]=temp2;
    		   }
    	   }
       }
       
      /* for(int i=0;i<V;i++)
       {
    	   if(dist[i]!=0)
    	   dist[i]=(val[i]/dist[i]);
       }
       */
       
       
       printSolution(dist, V);
        find(ti,a,V);
    }

   
    void find(int W,int arr[][], int n)
    {
    	//W is the maximum time of thief to steal the money 
        //    sorting Item on basis of ration
    	//Arrays.sort(arr);
     
        //    Uncomment to see new order of Items with their ratio
        /*
        for (int i = 0; i < n; i++)
        {
            cout << arr[i].value << "  " << arr[i].weight << " : "
                 << ((double)arr[i].value / arr[i].weight) << endl;
        }
        */
     
        int curWeight = 0;  // Current weight in knapsack
        int finalvalue = 0; // Result (value in Knapsack)
     
        // Looping through all Items
        for (int i = 0; i < n; i++)
        {
            // If adding Item won't overflow, add it completely
            if (curWeight + arr[1][i] <= W)
            {
                curWeight += arr[1][i];
                finalvalue += arr[0][i];
            }
     
            // If we can't add current Item, add fractional part of it
            else
            {
                int remain = W - curWeight;
                finalvalue += arr[0][i] * ((double) remain / arr[1][i]);
                break;
            }
        }
        ans=finalvalue;
        
        // Returning final value
       // return finalvalue;
    }

    
    
	
	
	
	public static void main(String args[]){

		
		
		
		Demo frame=new Demo();   
		frame.setVisible(true);
		frame.setTitle("StealMan");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100,100,700,600);	
		
		


	}
}