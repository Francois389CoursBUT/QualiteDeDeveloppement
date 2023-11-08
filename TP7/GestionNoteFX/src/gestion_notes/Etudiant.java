package gestion_notes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Etudiant extends Utilisateur implements Serializable {

    List<Note> notes = new ArrayList<Note>();

    Etudiant(String nom, String prenom, String identifiant, String motDePasse) {
        super(nom, prenom, identifiant, motDePasse);
    }

    /**
     * Recherche et en renvoie la note de l'étudiant dans la matière passée en
     * paramètre. Renvoie -1 si l'étudiant n'a pas de note dans cette matière.
     */
    public float note(String matiere) {
        for (Note note : notes) {
            if (note.matiere.intitule.equals(matiere)) {
                return note.valeur;
            }
        }
        return -1;
    }

    /**
     * Modifie ou crée la note de l'étudiant dans la matière indiquée en
     * paramètre avec la valeur indiquée en paramètre.
     */
    public void modifierNote(String matiere, float nouvelleNote) {
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).matiere.intitule.equals(matiere)) {
                notes.get(i).valeur = nouvelleNote;
            }
        }
    }

    /**
     * Renvoie l'ensemble des notes de l'étudiant sous la forme d'une chaîne de
     * caractères. Forme de la chaîne renvoyée : pour chaque note, intitulé de
     * la matière suivi de la note suivi d'un retour à la ligne sauf pour la
     * dernière note.
     */
    public String notesToString() {
        String result = "";
        for (int i = 0; i < notes.size(); i++) {
            result += notes.get(i).matiere.intitule + " : ";
            if (notes.get(i).valeur != -1) {
                result += notes.get(i).valeur;
            }
            if (i < notes.size() - 1) {
                result += "\n"; // Retour à la ligne si non dernère note
            }
        }
        return result;
    }
}
