/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import exception.CommandeException;
import siteCommande.Client;
import siteCommande.Commande;
import siteCommande.Particulier;

/**
 *
 * @author francois.desaintpala
 */
public class Main {
    
    /** @param args inutilisé */
    public static void main (String[] args) {
        try {
            Particulier p = new Particulier("François", "de Saint Palais");
            System.out.println(p);
            String[] prod = {"PC"};
            int[] qtes = {1};
            float[] prix = {1001.1f};
            Commande commande = new Commande(p, prod, qtes, prix);
            System.out.println(commande);
        } catch (CommandeException e) {
            System.out.println(e);
        }
    }
}
