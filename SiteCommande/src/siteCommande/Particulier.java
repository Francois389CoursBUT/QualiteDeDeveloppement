package siteCommande;

import exception.CommandeException;

public class Particulier extends Client {
    
    private String nom;

    private String prenom;

    public Particulier(String nom, String prenom) throws CommandeException {
        super();
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Nom : " + nom + " | Prenom : " + prenom + " | Numéro : " + numero;
    }

}