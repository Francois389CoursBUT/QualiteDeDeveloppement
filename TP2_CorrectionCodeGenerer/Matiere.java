import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("2239d8d4-4a01-4d24-b475-2264f85e1e7a")
public class Matiere {
     String intitule;

     List<Etudiant> etudiantsInscrits = new ArrayList<Etudiant> ();

    Matiere(String intitule) {
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
    }

}
