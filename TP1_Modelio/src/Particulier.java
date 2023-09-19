import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * - toString() : Renvoie une chaine de caratére indiquant le numéro, le nom et le prenom du particulier
 */
@objid ("e850843b-8982-436d-a851-d94c829a73dd")
public class Particulier extends Client {
    @objid ("85609c56-685e-4c0a-9259-5a719ebce9af")
    private String nom;

    @objid ("5aa5dd68-7fb9-4c4a-b019-d7f9df2495bb")
    private String prenom;

    @objid ("ead369bb-0edd-4544-a61e-bc5bd46a6e82")
    Particulier(String nom, String prenom) {
    }

    @objid ("71579def-f104-4d7f-89bc-f9465f2c482d")
    public String toString() {
    }

}
