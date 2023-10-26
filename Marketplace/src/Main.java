
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import com.opencsv.*;
import com.opencsv.CSVWriter;
import java.io.FileWriter;

public class Main {

	public static void main(String[] args) throws IOException {

		
		boolean exist = false;
		String current_type="";
		String current_user="";
		
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Pick a choice");
            System.out.println("1- Login ");
            System.out.println("2- Registration ");
            String choice1 = scanner.nextLine();
         
            
            if (choice1.equals("1"))
            {
            	
                System.out.println(" Enter username => ");
                String userName = scanner.nextLine();

                System.out.println(" Enter password => ");
                String password = scanner.nextLine();  
                
        		BufferedReader reader = new BufferedReader(new FileReader("connexion.csv"));
        		List<String> lines = new ArrayList<>();
        		String line = null;
        		while ((line = reader.readLine()) != null && !exist) {
        			String [] users =line.trim().split(",");
        			
        		if (userName.equals(users[1]) && password.equals(users[2]))
        		{System.out.println("welcome");
        		exist = true;
        		current_type = users[3];
        		current_user = users[0];
        		
        		}		
        		 			
        			
        		}
        		
        		if(current_type.equals("vendeur"))
        			
        		{   Vendeur new_vend = new Vendeur(userName,password,current_type,current_user);
        		
        			System.out.println("1- Signer contract");
        			System.out.println("2- Ajouter/Modifier/Supprimer un produit");
        			System.out.println("3- Suivre l'evolution des ventes");
        			String choice2 = scanner.nextLine();
        			switch(choice2) {
        			  case "1":
        				  new_vend.signContract();
        				  break;
        			  case "2":
        				System.out.println("1- Ajouter produit");
              			System.out.println("2- Supprimer produit");
              			System.out.println("3- Modifier produit");
              			String choice3 = scanner.nextLine();
              			switch(choice3) {
              				case "1":
              					new_vend.ajouterProduit();
              					break;
              				case "2":
              					new_vend.supprimerProduit();
              					break;
              				case "3":
              					new_vend.modifierProduit();
              					break;
              				default:
                			    // code block
              			}
              			
        			    break;
        			  case "3":
        				  new_vend.afficheVentes();	

        			  case "4":
        				  
        				  break;
        			  default:
        			    // code block
        			}
        			
        		
        		}	
        		if(current_type.equals("MarketPlace"))
        		{
        			MarketPlace new_mar = new MarketPlace(userName,password,current_type,current_user);
        			System.out.println("1- Ajouter un produit");
        			System.out.println("2- Ajouter un vendeur");
        			System.out.println("3- Afficher Chiffres D'affaires ");
        			System.out.println("4- Expéder une commande" );
        			String choice3 = scanner.nextLine();
        			switch(choice3) {
        			  case "1":
        				  new_mar.ajouterProduit();
        				  break;
        			  case "2":
        				  new_mar.ajouterVendeur();
        			  case "3":
        				  new_mar.AfficheChiffreAffaires();
        				  
        			break;
        			}
        			
        		}
        		if(current_type.equals("client"))
        		{
        			Client new_cli = new Client(userName,password,current_type,current_user);
        			
        			System.out.println("1- Consulter les produits");
        			System.out.println("2- Acheter Produit");
        			String choice4 = scanner.nextLine();
        			switch(choice4)
        			{
        			case "1":
        				new_cli.consulterProduit();
        				break;
        			case "2":
        				new_cli.acheterProduit();
        			}
        		
        		}
        		
        		if(current_type.equals("livreur"))
        		{
        			Livreur new_liv = new Livreur(userName,password,current_type,current_user);
        			
        			System.out.println("1- Afficher les commandes");
        			System.out.println("2- Confirmer Livraison");
        			String choice5 = scanner.nextLine();
        			switch(choice5)
        			{
        			case "1":
        				new_liv.afficherCommandes();
        				break;
        			
        			
        			case "2":
        				new_liv.confirmerLivraison();
        				break;
        			
        		}}
        		
        		
        			
            }
                        
            else if (choice1.equals("2"))
            { 	
            	System.out.println(" Enter your name => ");
            	String name = scanner.nextLine();       
            	
                System.out.println(" Enter username/login => ");
                String userName = scanner.nextLine();

                System.out.println(" Enter password => ");
                String password = scanner.nextLine();         	
            	

                System.out.println("Enter your type");
                String type = scanner.nextLine();
                
                
        		FileWriter writer = new FileWriter("connexion.csv",true);

        		writer.append(name);
        		writer.append(',');
        		
        		writer.append(userName);
        		writer.append(',');
        		writer.append(password);
        		writer.append(',');
        		writer.append(type);
        		writer.append('\n');
        		
        		writer.flush();
        		writer.close();
                
            	
            }
            else
            {
                System.out.println("Not a valid choice.");
                
            }
            }
		
	}
            
                    
		
}
