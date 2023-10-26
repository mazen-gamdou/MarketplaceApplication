import java.util.Date;

public class Produit{
    private String ref;
    private String description;
    private Float deliveryCost;

    private String type;
    private Float prix;
    private String vendeur;
    private String status;
    
    public Produit(String ref, String description,Float deliveryCost,String type,Float prix,String vendeur,String statut)
    {
    	this.ref=ref;
    	this.description=description;
    	this.deliveryCost=deliveryCost;
    
    	this.type=type;
    	
    }
    
    
    
    
    
	public String getVendeur() {
		return vendeur;
	}





	public void setVendeur(String vendeur) {
		this.vendeur = vendeur;
	}





	public String getStatus() {
		return status;
	}





	public void setStatus(String status) {
		this.status = status;
	}





	public Float getPrix() {
		return prix;
	}





	public void setPrix(Float prix) {
		this.prix = prix;
	}





	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Float getDeliveryCost() {
		return deliveryCost;
	}
	public void setDeliveryCost(Float deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

    
    
}