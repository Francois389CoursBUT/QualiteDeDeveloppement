package gestionnote;


import java.io.Serializable;


public abstract class Utilisateur implements Serializable {
    
    String nom;

    
    String prenom;

    
    String identifiant;

    
    String motDePasse;

    
  Utilisateur(String nom, String prenom, String identifiant, String motDePasse) {
    this.nom = nom;
    this.prenom = prenom;
    this.identifiant = identifiant;
    this.motDePasse = motDePasse;
  }

}
