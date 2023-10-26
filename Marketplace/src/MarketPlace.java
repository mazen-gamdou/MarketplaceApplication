import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarketPlace extends User{

	
	
	public MarketPlace(String login, String password, String type,String name) {
		super(login, password, type,name);
		
	}
	protected ArrayList<Produit> products = new ArrayList<Produit>();
	protected ArrayList<Vendeur> vendeurs = new ArrayList<Vendeur>();
	
	
	
	public void ajouterProduit() {
		
		try (Scanner scanner = new Scanner(System.in)) {
	    	System.out.println("Donner la référence du produit");
	    	String ref = scanner.nextLine();
	    	System.out.println("Donner la Déscription du produit");
	    	String des = scanner.nextLine();	    	
	    	System.out.println("Donner le DeliveryCost du produit");
	    	String delivcost = scanner.nextLine();	    	
	    	System.out.println("Donner le prix du produit");
	    	String prix = scanner.nextLine();	    
	    	
	    	
	    	
	    	Produit new_produit = new Produit(ref,des,Float.parseFloat(delivcost),"interne",Float.parseFloat(prix),this.name,"stock");
	    	this.products.add(new_produit);
	    	
    		FileWriter writer = new FileWriter("produits.csv",true);
    		System.out.println("I am here");
    		writer.append(ref);
    		writer.append(',');
    		writer.append(des);
    		writer.append(',');
    		writer.append(prix);

    		writer.append(',');
    		writer.append(delivcost);
    		
    		writer.append('\n');

    		writer.flush();
    		writer.close();
    		
	    	}
	    	
	    	catch(Exception e) {}
		
		
	}
	
public void ajouterVendeur() {
		
		try (Scanner scanner = new Scanner(System.in)) {

	    	System.out.println("Donner le nom du vendeur");
	    	String nom = scanner.nextLine();
	    	
	    	System.out.println("Donner le login du vendeur");
	    	String log = scanner.nextLine();
	    	System.out.println("Donner un mot de passe à votre vendeur");
	    	String pwd = scanner.nextLine();	    	
	    	
	    	Vendeur new_vend= new Vendeur(log,pwd,"vendeur",nom);
	    	
	    	
	    	FileWriter writer = new FileWriter("connexion.csv",true);

    		writer.append(nom);
    		writer.append(',');
    		
    		writer.append(log);
    		writer.append(',');
    		writer.append(password);
    		writer.append(',');
    		writer.append("vendeur");
    		writer.append('\n');
    		
    		writer.flush();
    		writer.close();
	    	
	    	
	    	
	    	
	    	
	    	System.out.print("Done");

	    	this.vendeurs.add(new_vend);
	    	
	    	new_vend.signContract();
	    	
	    	
		}
    	
    		
	    	
	    	
	    	catch(Exception e) {System.out.println(e);
	    	}
		
		
	}

public void AfficheChiffreAffaires()
{
	try {
	BufferedReader reader;
	reader = new BufferedReader(new FileReader("produits.csv"));
	String line = null;
	float chiffreAffaires=0;
	int i=0;
	while ((line = reader.readLine()) != null) {
		if (i>0) {
		String [] produits =line.trim().split(",");
		if (produits[5]=="interne") {
				chiffreAffaires+=Float.parseFloat(produits[2]);
		}
		else {
				chiffreAffaires+=Float.parseFloat(produits[2])*0.1;
		}
	}
		i+=1;
	}
	System.out.println(chiffreAffaires);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

	



}
