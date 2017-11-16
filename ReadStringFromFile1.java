import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ReadStringFromFile1 {

	public static void main(String[] args) {
		HashMap hm = new HashMap();
		HashMap hm1 = new HashMap();  
	      // Put elements to the map
	      //hm.put("Zara", new int(3434.34));
	     
		try {
			String s =readFile("C:\\Users\\anurag\\Desktop\\rural.txt");
			String token[]=s.split("\\s");
			
			for(int i=0;i<token.length;i++)
			{
				if(hm.get(token[i])!=null)
               {
					hm.put(token[i], new Double((double) hm.get(token[i]))+1);
                }
				else
				hm.put(token[i], new Double((double)1));
			}
			
			
			String s1 =readFile("C:\\Users\\anurag\\Desktop\\science.txt");
			String token1[]=s1.split("\\s");
			
			for(int i=0;i<token1.length;i++)
			{
				if(hm1.get(token1[i])!=null)
               {
					hm1.put(token1[i], new Double((double) hm1.get(token1[i]))+1);
                }
				else
				hm1.put(token1[i], new Double((double)1));
			}
			
			
		double mul1=0.5,mul2=0.5,a;
		//System.out.println(mul1);
			String s2 =readFile("C:\\Users\\anurag\\Desktop\\test1.txt");
			String token2[]=s.split("\\s");
		     for(int i=0;i<token2.length;i++)
		     {
		    	 a=(double)hm.get(token2[i])/1000;
		    	if(hm.get(token2[i])!=null&&a!=0)
		    	{	
		    		 System.out.println(mul1+" "+token2[i]+" "+a);
		    		 
		    		mul1=mul1*a;
		    		
		    	}
		    	
		    	if(hm1.get(token2[i])!=null) 
		    	{
		    		// System.out.println(mul2);
		    		mul2=mul2*(double)((double)hm.get(token2[i])/(double)1000.0);
		    	}
		     }
		  System.out.println(mul1+" "+mul2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static  String readFile(String file) throws IOException {
	    BufferedReader reader = new BufferedReader(new FileReader (file));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String         ls = System.getProperty("line.separator");

	    try {
	        while((line = reader.readLine()) != null) {
	            stringBuilder.append(line);
	            stringBuilder.append(ls);
	        }

	        return stringBuilder.toString();
	    } finally {
	        reader.close();
	    }
	}
	}