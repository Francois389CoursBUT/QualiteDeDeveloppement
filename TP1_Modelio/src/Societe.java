import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * - toString() : Renvoie une chaine de caratére indiquant le numéro et la raison sociale de la société
 */
@objid ("4c1476a5-3baf-4a6e-9167-96fc60d37a60")
public class Societe extends Client {
    @objid ("b2fca4de-a748-4bfa-880f-974c53c4f008")
    private String raisonSociel;

    @objid ("6e300dc6-f2a5-4524-9795-a218bedd5fe0")
    Societe(String raisonSocial) {
    }

    @objid ("62fb44c2-9be1-4171-8406-8c1c7a0e6d1f")
    public String toString() {
    }

}
