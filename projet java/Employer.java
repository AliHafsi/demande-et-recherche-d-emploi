package employer;

public class Employer {
	private String nom;
	private int id;
	private String poste;
	private int salaire;
	
	public Employer(String nom,int id,String poste,int salaire){
		this.nom=nom;
		this.id=id;
		this.poste=poste;
	    this.salaire=salaire;
		
		}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public int getSalaire() {
		return salaire;
	}

	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}

}
