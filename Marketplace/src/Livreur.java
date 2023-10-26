import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Livreur extends User{

    public Livreur(String login, String password, String type,String name){
        super(login,password,type,name);
      
  
    }
    
    public void afficherCommandes()
    {
    	try {
    		BufferedReader reader;
    		reader = new BufferedReader(new FileReader("commands.csv"));
    		String line = null;
    	
    		int i=0;
    		while ((line = reader.readLine()) != null) {
    			if (i>0) {
    			String [] commands =line.trim().split(",");
    			if (commands[2].equals(this.name)) 
    			{
    				System.out.println("Commande : " + line);
    			
    			}
    		
    		}
    			i+=1;
    		}
    
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	
    }
    public void confirmerLivraison(){
    	int myindex = -1;
    	try (Scanner scanner = new Scanner(System.in)) {
    		
    	System.out.println("give the reference of the product delivered");
    	String ref = scanner.nextLine();
    	
    	BufferedReader reader = new BufferedReader(new FileReader("commands.csv"));
		List<String> lines = new ArrayList<>();
		String line = null;
		int i =0;
		while ((line = reader.readLine()) != null) {
			
			String [] commands =line.trim().split(",");
			lines.add(line);
		if (ref.equals(commands[0]))
		{
		
		myindex = i; 
		
		}
		i=i+1;		 			
			
		}
		
		if(myindex != -1)
		{FileWriter writer = new FileWriter("commands.csv",false);
		String line_temp = lines.get(myindex);
		String [] words =line_temp.trim().split(",");
		
		lines.set(myindex,ref+","+words[1]+","+words[2]+","+"Livré"+",");
		for (String word : lines)
    	{
			writer.write(word);	
			writer.write('\n');
    	}
		writer.flush();
		writer.close();
		System.out.println("Commande confirmée");
		
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
