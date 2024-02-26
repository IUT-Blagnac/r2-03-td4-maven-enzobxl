public class Personne {
	
	String nom;
	String prenom;
	Personne pere;
	Personne mere;
	Personne conjoint;
	
	public Personne() {
		this.nom = "inconnu";
		this.prenom = "inconnu";
	}
	
	public Personne(String pfPrenom, String pfNom) {
		this.nom = pfNom;
		this.prenom = pfPrenom;
	}
	
}
