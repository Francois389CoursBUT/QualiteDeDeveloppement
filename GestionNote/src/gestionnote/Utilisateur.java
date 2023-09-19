package gestionnote;

public class Utilisateur {
    private String nom;

    private String prenom;

    private String motDePasse;

    private String identifiant;
    
    public Utilisateur(String nom, String prenom, String motDePasse, String identifiant) {
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.identifiant = identifiant;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    

}
