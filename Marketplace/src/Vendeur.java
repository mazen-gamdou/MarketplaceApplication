import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class Vendeur extends User{

	 protected Contrat contrat;
	    public Vendeur(String login, String password, String type,String name){
	        super(login,password,type,name);
	      this.name=name;
	        
	    }
	    
	    
	    protected ArrayList<Produit> products = new ArrayList<Produit>();
	    
	    public void signContract() throws IOException{
	    	try (
	    			Scanner scanner = new Scanner(System.in)) {
	    	System.out.println("Would you like to sign the contract with us? yes/no");
	    	String choice = scanner.nextLine();
	    	if(choice.equals("yes"))
	    	{
	    		System.out.println("Provive the starting data");
	    		String start_date = scanner.nextLine();
	    		System.out.println("Provide the ending data");
	    		String end_date = scanner.nextLine();
	    		System.out.println("Your contract was created succefully");
	    		Contrat new_contrat = new Contrat(start_date,end_date);
	    		this.contrat=new_contrat;
	    		try {
	    			
	    		FileWriter writer = new FileWriter("contrats.csv",true);

        		writer.append(new_contrat.getNum());
        		
        		writer.append(',');
        		writer.append(start_date);
        		writer.append(',');
        		writer.append(end_date);
        		writer.append('\n');

        		writer.flush();
        		writer.close();
	    		}
	    		catch(Exception e) {}
        		
	    	}
	    	else
	    	{
	    		System.out.println("Sorry you need to sign a contract");
	    	}
	    	}
	    };
	    
	    public void ajouterProduit(){
	    	try (Scanner scanner = new Scanner(System.in)) {
	    	System.out.println("give the reference of the product");
	    	String ref = scanner.nextLine();
	    	System.out.println("give the descriptin of the product");
	    	String des = scanner.nextLine();	    	
	    	System.out.println("give the deliverycost of the product");
	    	String delivcost = scanner.nextLine();	    	
	    	    	
	    	
	    	System.out.println("give the price of the product");
	    	String prix = scanner.nextLine();	
    	
	    	Produit new_produit = new Produit(ref,des,Float.parseFloat(delivcost),"externe",Float.parseFloat(prix),this.name,"stock");
	    	
	    	this.products.add(new_produit);
	    	
    		FileWriter writer = new FileWriter("produits.csv",true);
    		
    		writer.append(ref);
    		writer.append(',');
    		writer.append(des);
    		writer.append(',');
    		writer.append(delivcost);

    		writer.append(',');
    		writer.append(prix);
    		writer.append(',');
    		writer.append(this.name);
    		writer.append(',');
    		writer.append("externe");
    		writer.append(',');
    		writer.append("stock");
    		writer.append('\n');

    		writer.flush();
    		writer.close();
    		
	    	}
	    	
	    	catch(Exception e) {System.out.println(e);}
	    };

	    public void supprimerProduit(){
	    	int myindex = -1;
	    	try (Scanner scanner = new Scanner(System.in)) {
	    	
	    		System.out.println("Give the reference you want to delete");
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
	    		lines.remove(myindex);
	    		for (String word : lines)
		    	{
	    			writer.write(word);	
	    			writer.write('\n');
		    	}
	    		writer.flush();
	    		writer.close();
	    		System.out.println("Product deleted from database");
	    		
	    		}
	    		else {
	    			System.out.println("Product with given reference not found");
	    		}
	    	}
	    	
	    	catch(Exception e)
	    	{System.out.println(e);
	    		
	    	}
	    	
	    }
	    public void modifierProduit(){
	    	int myindex = -1;
	    	try (Scanner scanner = new Scanner(System.in)) {
	    	System.out.println("give the reference of the product to modify");
	    	String ref = scanner.nextLine();
	    	System.out.println("give the new description of the product");
	    	String des = scanner.nextLine();	    	
	    	System.out.println("give the new deliverycost of the product");
	    	String delivcost = scanner.nextLine();	    	
	    	System.out.println("give the new price of the product");
	    	String prix = scanner.nextLine();	
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
    		lines.set(myindex,ref+","+des+","+delivcost+","+prix+",");
    		for (String word : lines)
	    	{
    			writer.write(word);	
    			writer.write('\n');
	    	}
    		writer.flush();
    		writer.close();
    		System.out.println("Product modified in database");
    		
    		}
    		else {
    			System.out.println("Product with given reference not found");
    		}
	    	}
    		catch(Exception e)
	    	{
	    		
	    	}
	    	
	    	}

	    public void afficheVentes(){
	    	
	    	try {
	    		BufferedReader reader;
	    		reader = new BufferedReader(new FileReader("produits.csv"));
	    		String line = null;
	    	
	    		int i=0;
	    		while ((line = reader.readLine()) != null) {
	    			if (i>0) {
	    			String [] produits =line.trim().split(",");
	    			if (produits[4].equals(this.name)) {
	    				System.out.println("Produit: " + line);
	    			
	    			}
	    		
	    		}
	    			i+=1;
	    		}
	    
	    		} catch (Exception e) {
	    			e.printStackTrace();
	    		}
	    	}
	    ;
	    
	    }

