import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("3741ace2-641a-458a-8aa0-ed33cef66d0c")
public class GestionNotes {
    /**
     * Chemin d'accés au fichier de donnée
     */
    @objid ("31e352dd-a72f-43cc-bd40-b6d0f6497da2")
    private String nomFichierDonnees;

    @objid ("0f75d688-c233-47d7-938f-ab87d624eb31")
     List<Utilisateur> utilisateur = new ArrayList<Utilisateur> ();

    @objid ("4ccefdf5-c58d-458a-8b5b-4bbde0f1e0f6")
    public static void main(List<String> args) {
    }

    /**
     * Renvoie true si les données sont utilisé par quelqu'un d'autre, false sinon
     */
    @objid ("3aa5c3c1-866c-4987-bc51-a112c249e2ee")
    public boolean donneesVerrouillees() {
    }

    /**
     * Verrouille les données
     */
    @objid ("2970ecd9-f016-41a6-9730-c41d28f5e80a")
    public void verrouillerDonnees() {
    }

    /**
     * Charge les fichier où sont sauvegarder les données
     * 
     */
    @objid ("bcb6828b-fc94-47bc-8a7f-b7a5ee29ddf3")
    public void chargerDonner() {
    }

    /**
     * Si l'identifiant et le mot de passe sont correct, renvoie l'Utilisateur qui demande à se connecter.
     * Sinon renvoie une exception
     */
    @objid ("30ba9996-455f-4e1a-91f9-91a875195d99")
    public Utilisateur connecter(String id, String mdp) throws IdentifiantsException {
    }

}
