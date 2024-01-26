import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("132574bd-708e-4574-8bc5-6bff816c69ae")
public class Enseignant extends Utilisateur {
    @objid ("e7b5e0de-9293-422d-9df6-d39c615cec6a")
     List<Matiere> matieresEnseignees = new ArrayList<Matiere> ();

    @objid ("b47a142f-9d18-4a25-9783-07671f6fa8df")
    void setMatieresEnseignees(List<Matiere> matieres) {
    }

    @objid ("1a9e0f3b-2f04-485d-925c-69ac1d139bd0")
    Enseignant(String nom, String prenom, String id, String pass) {
    }

}
