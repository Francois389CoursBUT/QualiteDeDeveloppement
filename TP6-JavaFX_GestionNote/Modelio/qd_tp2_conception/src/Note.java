import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("3b545c9e-ebdd-445d-a4bd-202a722ceef4")
public class Note {
    @objid ("a6b4baf0-fa51-439f-ae79-672b8e8bf973")
     float valeur;

    @objid ("32ae6502-b9ab-4478-961d-ad4868fe3451")
     Matiere matiere;

    /**
     * valeur : initialisée à -1 signifiant l'absence de note.
     */
    @objid ("2740c2db-06cf-4bfb-8ca0-fb3f600a3cfd")
    Note(Matiere matiere) {
    }

}
