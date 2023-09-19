package gestionnote;

import java.util.ArrayList;
import java.util.List;

public class Matiere {
    private String intitule;

     List<Etudiant> etudiantsInscrit = new ArrayList<Etudiant> ();

    public Matiere(String intitule) {
        this.intitule = intitule;
    }
     
    /**
     * modifierNotes(): Afficher en boucle un menu indiquant l'ensemble des notes pour les étudiants inscrits dans cette matière avec la possibilité de les modifier.
     */
    void modifierNotes() {
    }

    /**
     * setEtudiantsInscrits() : Affecter les étudiants inscrits et intialiser leurs notes à -1.
     */
    void setEtudiantsInscrits(List<Etudiant> etudiants) {
        for (Etudiant etudiant : etudiants) {
            etudiantsInscrit.add(etudiant);
        }
    }
}
