package gestionnote;

import java.io.Serializable;

public class Note implements Serializable{
    
  float valeur;   
  Matiere matiere;

  /**
   * valeur : initialisée à -1 signifiant l'absence de note.
   */  
  Note(Matiere matiere) {
    valeur = -1;
    this.matiere = matiere;
  }

}
