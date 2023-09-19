package siteCommande;

import exception.CommandeException;

public class Societe extends Client {
    
    private String raisonSocial;

    public Societe(String raisonSocial) throws CommandeException {
        super();
        this.raisonSocial = raisonSocial;
    }

    @Override
    public String toString() {
        return "Raison social : " + raisonSocial + " Numero : " + numero;
    }

}
