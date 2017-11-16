import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

class Demo extends JFrame implements ActionListener{		     
		Container c; 	
		DefaultListModel<String> l1;
		DefaultListModel<String> l2;
		JLabel uLabel=new JLabel("Profit");   
		
		
		JTextField uname=new JTextField("1 1 1 1 1 ");  
		
		
		JButton loginbtn=new JButton("find");
		
		Demo()
		{
				c=this.getContentPane();   
				c.setLayout(null);    
				c.setBackground(Color.BLUE);  
			/*	try {
					BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\antriksh\\Desktop\\canstockphoto56761031"));
					JLabel picLabel = new JLabel(new ImageIcon(myPicture));
					c.add(picLabel);
				}
				catch(Exception e)
				{
					
				}
				*/
				
				
				
				uLabel.setBounds(100,50,100,40);     
				
				
				uname.setBounds(250,50,200,40);
				
				
				loginbtn.setBounds(280,390,140,50); 
				loginbtn.addActionListener(this);      
				
				Font f=new Font("Arial", Font.BOLD,18);  
				uLabel.setFont(f);
				
				uname.setFont(f);
				
				loginbtn.setFont(f);
				
				l1 = new DefaultListModel<>();  
				  System.out.println("ans."+myLoginForm.ans);
		          
		          
		          JList<String> list = new JList<>(l1);  
		         // list.setBounds(100,100, 75,75);  
		          list.setBounds(280,100,140,250);
		          c.add(list);  

		          l2 = new DefaultListModel<>();  
				  System.out.println("ans."+myLoginForm.ans);
		          
		          
		          JList<String> list2 = new JList<>(l2);  
		         // list.setBounds(100,100, 75,75);  
		          list2.setBounds(280,150,140,250);
		          c.add(list2);  
				
				
				// Step 15 : adding hand cursor on button
				Cursor cur=new Cursor(Cursor.HAND_CURSOR);
				loginbtn.setCursor(cur);   //applying cursor to the button
	
				c.add(uLabel);
				
				c.add(uname);
				
				c.add(loginbtn);       
		}		
 
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==loginbtn)
		{
			System.out.println("Hello");
			String[] username=uname.getText().toString().split("\\s");    

			 System.out.println(username[0]);
			for(int i=0;i<5;i++)
			{
				System.out.println(username[i]+" ");
				 HamiltonianCycle.a[i]=Integer.parseInt(username[i]);
				
			}HamiltonianCycle t=new HamiltonianCycle();
			// myLoginForm.username= {2,3};
			t.hamCycle(HamiltonianCycle.graph1);
			l1.addElement("Hamiltonian Cycle ");  
			for(int i=0;i<5;i++)
			l1.addElement(" "+HamiltonianCycle.path[i]); 
			
			l1.addElement("0");
				         // setVisible(true);
			t.quickSort(HamiltonianCycle.a, 0, 4);
		}	
	} 	
}


public class HamiltonianCycle
{
	final int V = 5;
	static int path[];
    static  int []a= new int[5];
	static int graph1[][] = {{0, 1, 0, 1, 0},
			{1, 0, 1, 1, 1},
			{0, 1, 0, 0, 1},
			{1, 1, 0, 0, 1},
			{0, 1, 1, 1, 0},
		};
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
		
			if (graph[path[pos - 1]][path[0]] == 1)
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

	
	void swap(int arr[], int k, int small) {
	    int temp;
	    temp = arr[k];
	    arr[k] = arr[small];
	    arr[small] = temp;
	}
	int partition(int arr[], int i, int j) {
	    int pivot = arr[j];
	    int small = i - 1;

	    for(int k = i; k < j; k++) {
	        if(arr[k] <= pivot) {
	            small++;
	            swap(arr, k, small);
	        }
	    }

	    swap(arr, j, small + 1);
	   System.out.println("Pivot ="+arr[small + 1]);
	    printArray(arr);
	    return small + 1;
	}
	void printArray(int arr[]) {
	    for (int i = 0; i < 5; i++)
	       System.out.println( arr[i]+" ");

	}
	
	void quickSort(int arr[], int i, int j) {
	    if(i < j) {
	        int pos = partition(arr, i, j);
	        quickSort(arr, i, pos - 1);
	        quickSort(arr, pos + 1, j);
	    }
	}
	
	
	public static void main(String args[])
	{
		Demo frame=new Demo();   
		frame.setVisible(true);
		frame.setTitle("Help Me");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100,100,700,1000);	
		
		
		
		HamiltonianCycle hamiltonian =
								new HamiltonianCycle();

	}
}

