package gestionnote;

import java.util.ArrayList;
import java.util.List;



public class Etudiant extends Utilisateur  {
    
  List<Note> notes = new ArrayList<Note> ();

  Etudiant(String nom, String prenom, String identifiant, String motDePasse) {
    super(nom, prenom, identifiant, motDePasse);
  }

  /**
   * Recherche et en renvoie la note de l'étudiant dans la matière passée en paramètre.
   * Renvoie -1 si l'étudiant n'a pas encore de note dans cette matière ou n'est pas inscrit
   * à cette matière.
   */
  float note(String matiere) {
    for(Note note: notes) {
      if (note.matiere.intitule.equals(matiere)) return note.valeur;
    }
    return -1;
  }
  
  /**
     * Modifie ou crée la note de l'étudiant dans la matière indiquée en paramètre avec la valeur 
     * indiquée en paramètre. Ne fait rien si l'étudiant n'est pas inscrit à cette matière.
    */
  void modifierNote(String matiere, float nouvelleNote) {
    for(Note note: notes) {
      if (note.matiere.intitule.equals(matiere))
        note.valeur = nouvelleNote;
    }
  }
    
  /**
   * Renvoyer une chaîne indiquant les notes de l'étudiant.
   */ 
  String notesToString() {
    String result="--- Voici l'ensemble des notes de "
            + nom + " " + prenom +" :\n";
    for(Note note: notes) {
        result += note.matiere.intitule+ " : ";
        if (note.valeur == -1) result += "\n";
        else result += note.valeur+"\n";
    }
    return result;
  }
}
