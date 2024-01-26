import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("2239d8d4-4a01-4d24-b475-2264f85e1e7a")
public class Matiere {
    @objid ("b8054543-2e54-404a-a7af-f5d93b24951a")
     String intitule;

    @objid ("62db92a2-7c59-438a-bc69-e7c3ee581293")
     List<Etudiant> etudiantsInscrits = new ArrayList<Etudiant> ();

    @objid ("ffe2c387-edf3-40df-8b45-6f27ff11fe44")
    Matiere(String intitule) {
    }

    /**
     * modifierNotes(): Afficher en boucle un menu indiquant l'ensemble des notes pour les étudiants inscrits dans cette matière avec la possibilité de les modifier.
     */
    @objid ("e9e76d16-0bc9-4b85-96f7-eb38fe43d048")
    void modifierNotes() {
    }

    /**
     * setEtudiantsInscrits() : Affecter les étudiants inscrits et intialiser leurs notes à -1.
     */
    @objid ("5072cf69-b575-4fe2-8de5-fa9221530fee")
    void setEtudiantsInscrits(List<Etudiant> etudiants) {
    }

}
