package gestion_notes;

import java.io.Serializable;

public class Note implements Serializable {

    float valeur;
    Matiere matiere;

    Note(Matiere matiere, float valeur) {
        this.matiere = matiere;
        this.valeur = valeur;
    }

}
