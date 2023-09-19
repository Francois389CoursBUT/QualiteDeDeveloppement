package siteCommande;

import exception.CommandeException;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private static int compteurNumeros;

    protected String numero;

    private List<Commande> commande = new ArrayList<Commande> ();

    public Client() throws CommandeException{
        compteurNumeros++;
        numero = "CL" + compteurNumeros;
    }

    protected void ajouterCommande(String[] prods, int[] qtes, float[] prix) throws CommandeException {
        commande.add(new Commande(this, prods, qtes, prix));
    }

}
