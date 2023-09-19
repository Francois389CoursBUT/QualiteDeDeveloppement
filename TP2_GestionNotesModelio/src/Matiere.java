import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("d114ec6f-2ca8-482c-9405-60a616fb8fb2")
public class Matiere {
    @objid ("b3ac3b8d-9175-4dc4-8024-f66b08675712")
    private String intitule;

    @objid ("67e2cbe4-c1c5-41b7-aa7d-70245d37a2b1")
     List<Etudiant> etudiantsInscrit = new ArrayList<Etudiant> ();

    @objid ("db1f521d-edc8-4571-adbb-48dc8a1b8184")
    String getIntitule() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.intitule;
    }

    @objid ("7564d7d8-3543-4614-a64c-8d22be2e318b")
    void setIntitule(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.intitule = value;
    }

}
