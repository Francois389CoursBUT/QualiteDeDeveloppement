import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("3a4361b5-a635-4486-8a6a-3b7c003944b0")
public class Etudiant extends Utilisateur {
    @objid ("5c8a623d-13be-4c23-ae18-d0fda9f4f328")
     List<Note> note = new ArrayList<Note> ();

    @objid ("d93420e0-aa5c-49ec-aa17-e6617af45b15")
    Note getNote() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.note;
    }

    @objid ("60dfd43f-c45c-40ea-94a7-8ee6dd0bca28")
    void setNote(Note value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.note = value;
    }

}
