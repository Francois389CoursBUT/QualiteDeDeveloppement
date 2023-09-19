import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("a464b4a6-ff9a-419f-a9e8-8d4610938e0d")
public class Enseignant extends Utilisateur {
    @objid ("d3097ac3-ff68-41ac-b48d-dd6dc4e03ef8")
     List<Matiere> matiereEnseignees = new ArrayList<Matiere> ();

}
