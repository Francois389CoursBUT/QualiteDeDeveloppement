import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("68be3516-f6ce-4aab-afb2-a79ab45aa3fd")
public class Commande {
    @objid ("b0dd837d-5069-4089-8a1e-e1c7f7d5c767")
    private static int compteurNumeros;

    @objid ("60cfbb24-1f3c-4224-a6a2-db3c75fc4f12")
    private int numéro;

    @objid ("0896e57b-88aa-43db-8dbc-e4b26bb90c1e")
    private String[] produits;

    @objid ("73049644-4e33-4084-87ac-b9bc761ac7f1")
    private int[] quantites;

    @objid ("a32ec671-6609-484b-93fc-273bf7735fc7")
    private float[] prixUnitaire;

    @objid ("4e1ea1de-55cd-4e09-87b8-8b9c8ec6e3b1")
    private Client client;

    @objid ("78668c0f-6d43-4f7d-914f-9fbf8ee6d4cd")
    public Commande(Client c, List<String> prods, List<Integer> qtes, List<Float> prix) throws CommandeException {
    }

    @objid ("5e1cd477-fc8a-41bc-a5d5-cd6f10f400a5")
    public String toString() {
    }

}
