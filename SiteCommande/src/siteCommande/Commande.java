package siteCommande;

import exception.CommandeException;
import java.util.List;

/**
 * Description
 * - compteurNumeros: Initialisé à 0, incrémenté à chaque création d'une nouvelle commande.
 * - numero: Numéro unique de la commande.
 * - produits, quantités, prix : Listes de libellés de produits, quantités et prix unitaires TTC correspondants.
 * - client: Client de la commande.
 * - Commande (c.prods.qtes, prix): 
 * Crée une nouvelle commande avec un numéro obtenu par 
 * incrémentation de compteur Numeros, le client c, les produits, 
 * quantités et prix unitaires TTC passés en paramètre. 
 * Lève CommandeException si listes vides ou de longueurs différentes. 
 * -toString(): Renvoie une chaîne de caractères indiquant 
 * le numéro de la commande, le client, les produits, les quantités, 
 * les prix unitaires TTC, les montants TTC correspondants et le total TTC.
 * @author francois.desaintpala
 */
public class Commande {
    
    private static int compteurNumeros = 0;

    private int numero;

    private String[] produits;

    private int[] quantites;

    private float[] prixUnitaire;

    private Client client;

    /**
     *
     * @param c
     * @param prods
     * @param qtes
     * @param prix
     * @throws CommandeException
     */
    public Commande(Client c, String[] prods, int[] qtes, float[] prix) throws CommandeException {
        if (   prods.length != qtes.length || qtes.length != prix.length
            || prods.length == 0 || qtes.length == 0 || prix.length == 0) {
            throw new CommandeException();
        }
        compteurNumeros++;
        
        client = c;
        produits = prods;
        quantites = qtes;
        prixUnitaire = prix;
        numero = compteurNumeros;
    }

    @Override
    public String toString() {
        float[] montantsTTC = new float[produits.length];
        float montantsTTCTotal  = 0;
        
        for (int i = 0; i < montantsTTC.length; i++) {
            montantsTTC[i] = quantites[i] * prixUnitaire[i];
            montantsTTCTotal += montantsTTC[i];
        }
        
        return    "Numéro : " + numero + " | Client : " + client 
                + "\nProduit : " + produits.toString()
                + "\nQuantité : " + quantites.toString() 
                + "\nPrix unitaire : " + prixUnitaire.toString() 
                + "\nPrix total par produit : " + montantsTTC.toString() 
                + "\nPrix Total : " + montantsTTCTotal;
    }

}