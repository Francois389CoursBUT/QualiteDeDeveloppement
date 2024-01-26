import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("1e27709e-afc3-4c01-805d-3bfada090987")
public class Etudiant extends Utilisateur {
    @objid ("dba5b4c7-24b5-4e73-97f2-b8e20a77288b")
     List<Note> notes = new ArrayList<Note> ();

    /**
     * note(matiere): Recherche et en renvoie la note de l'étudiant dans la matière passée en paramètre. Renvoie -1 si l'étudiant n'a pas de note dans cette matière ou n'est pas inscrit à cette matière.
     */
    @objid ("43183031-28b8-4878-968b-51b728229293")
    float note(String matiere) {
    }

    /**
     * modifierNote(matiere, nouvelleNote) : Modifie la note de l'étudiant dans la matière indiquée en paramètre avec la valeur indiquée en paramètre. Ne fait rien si l'étudiant n'est pas inscrit à cette matière.
     */
    @objid ("8bdcf502-c311-458b-9e80-3845915fe164")
    void modifierNote(String matiere, float nouvelleNote) {
    }

    /**
     * notesToString(): Renvoyer une chaîne indiquant les notes de l'étudiant.
     */
    @objid ("8f4473d8-d14d-4525-9b9d-660a345b5e77")
    String notesToString() {
    }

    @objid ("05b4a55f-3327-44df-a4ed-b56369f3b9cd")
    Etudiant(String nom, String prenom, String id, String pass) {
    }

}
