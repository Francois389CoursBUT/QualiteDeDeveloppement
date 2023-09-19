package gestionnote;

import java.util.ArrayList;
import java.util.List;

public class Enseignant extends Utilisateur {
     List<Matiere> matiereEnseignees = new ArrayList<Matiere> ();

    public Enseignant(String nom, String prenom, String motDePasse, String identifiant) {
        super(nom, prenom, motDePasse, identifiant);
    }
    
    void setMatieresEnseignees(List<Matiere> matieres) {
    }
}
