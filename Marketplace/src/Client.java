import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client extends User{

	 
	    public Client(String login, String password, String type,String name){
	        super(login,password,type,name);
	      
	   
	        
	    }
	    
	    public void consulterProduit()
	    {
	    	
	    	try {
	    		BufferedReader reader;
	    		reader = new BufferedReader(new FileReader("produits.csv"));
	    		String line = null;
	    	
	    		int i=0;
	    		while ((line = reader.readLine()) != null) {
	    			if (i>0) {
	    			String [] produits =line.trim().split(",");
	    			if (produits[6].equals("stock")) {
	    				System.out.println("Produit: " + line);
	    			
	    			}
	    		
	    		}
	    			i+=1;
	    		}
	    
	    		} catch (Exception e) {
	    			e.printStackTrace();
	    		}
	    }
	    
	    
	    public void acheterProduit(){
	    	int myindex = -1;
	    	try (Scanner scanner = new Scanner(System.in)) {
	    	System.out.println("give the reference of the product to buy");
	    	String ref = scanner.nextLine();
	    	
	    	BufferedReader reader = new BufferedReader(new FileReader("produits.csv"));
    		List<String> lines = new ArrayList<>();
    		String line = null;
    		int i =0;
    		while ((line = reader.readLine()) != null) {
    			
    			String [] produits =line.trim().split(",");
    			lines.add(line);
    		if (ref.equals(produits[0]))
    		{
    		
    		myindex = i; 
    		
    		}
    		i=i+1;		 			
    			
    		}
    		
    		if(myindex != -1)
    		{FileWriter writer = new FileWriter("produits.csv",false);
    		String line_to_change=lines.get(myindex);
    		String [] words =line_to_change.trim().split(",");
    		
    		lines.set(myindex,ref+","+words[1]+","+words[2]+"," + words[3]+ "," + words[4]+"," + words[5] +","+"sold"+",");
    		for (String word : lines)
	    	{
    			writer.write(word);	
    			writer.write('\n');
	    	}
    		writer.flush();
    		writer.close();
    		
    		System.out.println("Commande bien passer, choisir un livreur :");
    		
	    	try {
	    		BufferedReader reader2;
	    		reader2 = new BufferedReader(new FileReader("connexion.csv"));
	    		String line2 = null;
	    		
	    		int j=0;
	    		while ((line2 = reader2.readLine()) != null) {
	    			if (j>0) {
	    			String [] users =line2.trim().split(",");
	    			
	    			if (users[3].equals("livreur")) {
	    				
	    				System.out.println(users[0]);
	    				
	    			}
	    		
	    		}
	    			j+=1;
	    		}
	    		String livreur = scanner.nextLine();
	    		
	     		FileWriter writer2 = new FileWriter("commands.csv",true);

        		writer2.append(ref);
        		writer2.append(',');
        		
        		writer2.append(this.name);
        		writer2.append(',');
        		writer2.append(livreur);
        		writer2.append(',');
        		writer2.append("En cours");
        		writer2.append('\n');
        		
        		writer2.flush();
        		writer2.close();
	    		
	    		
	    		} catch (Exception e) {
	    		System.out.println(e);
	    		}
    		}
    		else {
    			System.out.println("Product with given reference not found");
    		}
	    	}
    		catch(Exception e)
	    	{
	    		
	    	}
	    	
	    	}
	    
}
