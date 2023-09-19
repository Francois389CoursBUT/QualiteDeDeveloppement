package gestionnote;

import java.util.ArrayList;
import java.util.List;

public class Etudiant extends Utilisateur {
     List<Note> note = new ArrayList<Note> ();

    public Etudiant(String nom, String prenom, String motDePasse, String identifiant) {
        super(nom, prenom, motDePasse, identifiant);
    }
    
    /**
     * note(matiere): Recherche et en renvoie la note de l'étudiant dans la matière passée en paramètre. Renvoie -1 si l'étudiant n'a pas de note dans cette matière ou n'est pas inscrit à cette matière.
     */
    float note(String matiere) {
        return 0.0f; //STUB
    }

    /**
     * modifierNote(matiere, nouvelleNote) : Modifie la note de l'étudiant dans la matière indiquée en paramètre avec la valeur indiquée en paramètre. Ne fait rien si l'étudiant n'est pas inscrit à cette matière.
     */
    void modifierNote(String matiere, float nouvelleNote) {
    }

    /**
     * notesToString(): Renvoyer une chaîne indiquant les notes de l'étudiant.
     */
    String notesToString() {
        return ""; //STUB
    }
}
