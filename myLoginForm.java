
import javax.imageio.ImageIO;
import javax.swing.*;          
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
 
//Step 11 : Implementing ActionListener
class frameDemo extends JFrame implements ActionListener{		     
		Container c; 	
		DefaultListModel<String> l1;
		DefaultListModel<String> l2;
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
		JLabel uLabel=new JLabel("Profit");   
		JLabel pLabel =new JLabel("Time");
		JLabel sLabel =new JLabel("Speed");
		JLabel kLabel =new JLabel("knapsack_Weight");
		
		JTextField uname=new JTextField("0 20 15 30 24 54 21 32 18");  
		JTextField pass=new JTextField("0 2 3 5 5 6 9 7 8");  
		
		
		JTextField speed=new JTextField("20");  
		//JTextField pass=new JTextField("0 2 3 5 5 6 9 7 8"); 
		JTextField kweight=new JTextField("24");  
		
		JButton loginbtn=new JButton("Help Me");
		
		frameDemo()
		{
				c=this.getContentPane();   
				c.setLayout(null);    
				c.setBackground(Color.GREEN);  
			/*	try {
					BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\anurag\\Desktop\\canstockphoto56761031"));
					JLabel picLabel = new JLabel(new ImageIcon(myPicture));
					c.add(picLabel);
				}
				catch(Exception e)
				{
					
				}
				*/
				
				
				
				uLabel.setBounds(10,50,100,40);     
				pLabel.setBounds(10,140,100,40);
				sLabel.setBounds(10,240,100,40);
				kLabel.setBounds(10,340,100,40);
				
				uname.setBounds(450,50,200,40);
				pass.setBounds(450,140,200,40);
				speed.setBounds(450,240,200,40);
				kweight.setBounds(450,340,200,40);
				
				loginbtn.setBounds(280,390,140,50); 
				loginbtn.addActionListener(this);      
				
				Font f=new Font("Arial", Font.BOLD,18);  
				uLabel.setFont(f);
				pLabel.setFont(f);
				sLabel.setFont(f);
                kLabel.setFont(f);
				uname.setFont(f);
				pass.setFont(f);
				speed.setFont(f);
				kweight.setFont(f);
				loginbtn.setFont(f);
				
				l1 = new DefaultListModel<>();  
				  System.out.println("ans."+myLoginForm.ans);
		          
		          
		          JList<String> list = new JList<>(l1);  
		         // list.setBounds(100,100, 75,75);  
		          list.setBounds(280,450,140,50);
		          c.add(list);  
                 
		          l2 = new DefaultListModel<>();  
				  System.out.println("ans."+myLoginForm.ans);
		          
		          
		          JList<String> list2 = new JList<>(l2);  
		         // list.setBounds(100,100, 75,75);  
		          list2.setBounds(280,510,140,250);
		          c.add(list2);    
				
				
				// Step 15 : adding hand cursor on button
				Cursor cur=new Cursor(Cursor.HAND_CURSOR);
				loginbtn.setCursor(cur);   //applying cursor to the button
	
				c.add(uLabel);
				c.add(pLabel);
				c.add(sLabel);
				c.add(kLabel);
				c.add(uname);
				c.add(pass);
				c.add(speed);
				c.add(kweight);
				
				c.add(loginbtn);       
		}		
 
	public void actionPerformed(ActionEvent e){
		//Step 14 : performing login action
		if(e.getSource()==loginbtn)
		{
			System.out.println("Hello");
			String[] username=uname.getText().toString().split("\\s");    
			String[] password=pass.getText().toString().split("\\s");
			String sp=speed.getText().toString();
			 myLoginForm.Speed=Integer.parseInt(sp);
			String kp=kweight.getText().toString();
			 myLoginForm.ti=Integer.parseInt(kp);
			
			 
			 
			 System.out.println(username[0]);
			for(int i=0;i<9;i++)
			{
				System.out.println(username[i]+" "+password[i]);
				myLoginForm.val[i]=Integer.parseInt(username[i]);
				myLoginForm.time[i]=Integer.parseInt(password[i]);
			}myLoginForm t=new myLoginForm();
			// myLoginForm.username= {2,3};
			t.dijkstra(graph, 0);
			l1.addElement("Maximum Profit "+myLoginForm.ans);  
			
			
			
			
			myLoginForm t1=new myLoginForm();
			// myLoginForm.username= {2,3};
			t1.hamCycle(graph);
			l2.addElement("Hamiltonian Cycle ");  
			for(int i=0;i<9;i++)
			l2.addElement(" "+myLoginForm.path[i]); 
			
			l2.addElement("0");
				         // setVisible(true);
			/*if(username.equals("umesh") && password.equals("1234"))       
			{
				JLabel success=new JLabel("Login Success");          
				success.setBounds(280,300,140,50);
				c.add(success);
			}
			else
			{
				JLabel msg=new JLabel("Invalid User Name or password");       
				msg.setBounds(280,300,400,50);                        
				c.add(msg);
			}	*/
		}	
	} 	
}
 
public class myLoginForm{
	
	static int ti;
	static int ans;
    static final int V=9;
    static  int Speed;
    static  int val[]=new int[V];
    static  int time[]=new int[V] ;
	static int path[];

    // = {0 20 15 30 24 54 21 32 18}{0 2 3 5 5 6 9 7 8}
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

       
        Boolean sptSet[] = new Boolean[V];

        
        for (int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

       
        dist[src] = 0;

       
        for (int count = 0; count < V-1; count++)
        {
           
            int u = minDistance(dist, sptSet);

            
            sptSet[u] = true;

           
            for (int v = 0; v < V; v++)

               
                if (!sptSet[v] && graph[u][v]!=0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u]+graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

       for(int i=0;i<V;i++)
       {
    	   dist[i]=(dist[i]/Speed)+time[i];
       }
       
        printSolution(dist, V);
        find(val,dist,ti);
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
        ans=K[val.length][W];
        System.out.println(K[val.length][W]);
       // return K[val.length][W];
    }

    
    boolean isSafe(int v, int graph[][], int path[], int pos)
	{
		
		if (graph[path[pos - 1]][v] == 0)
			return false;

		
		for (int i = 0; i < pos; i++)
			if (path[i] == v)
				return false;

		return true;
	}

	
	boolean hamCycleUtil(int graph[][], int path[], int pos)
	{
		
		if (pos == V)
		{
		
			if (graph[path[pos - 1]][path[0]]>0)
				return true;
			else
				return false;
		}

		for (int v = 1; v < V; v++)
		{
			
			if (isSafe(v, graph, path, pos))
			{
				path[pos] = v;

				
				if (hamCycleUtil(graph, path, pos + 1) == true)
					return true;

				
				path[pos] = -1;
			}
		}

		
		return false;
	}

	
	int hamCycle(int graph[][])
	{
		path = new int[V];
		for (int i = 0; i < V; i++)
			path[i] = -1;

		
		path[0] = 0;
		if (hamCycleUtil(graph, path, 1) == false)
		{
			System.out.println("\nSolution does not exist");
			return 0;
		}

		printSolution(path);
		return 1;
	}

	
	void printSolution(int path[])
	{
		System.out.println("Solution Exists: Following" +
						" is one Hamiltonian Cycle");
		for (int i = 0; i < V; i++)
			System.out.print(" " + path[i] + " ");

	
		System.out.println(" " + path[0] + " ");
	}

	
	
	
	
	public static void main(String args[]){

		
		
		
		frameDemo frame=new frameDemo();   
		frame.setVisible(true);
		frame.setTitle("Help Me");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100,100,700,1000);	
		
		myLoginForm b=new myLoginForm();
		
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

           b.hamCycle(graph);
	}
}