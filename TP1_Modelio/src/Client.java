import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("edc03729-d22a-4a54-a11b-7345cb0f9c29")
public class Client {
    @objid ("3c3469fa-6ee0-423b-8624-0bf165f6976e")
    private static int compteurNumeros;

    @objid ("5f89b66d-03a2-4197-9604-43bbb59facce")
    protected String numero;

    @objid ("dfefdf22-9c57-4ec1-8c7c-e2f807829791")
    private List<Commande> commande = new ArrayList<Commande> ();

    @objid ("65b77dbf-1b23-4638-abac-cef4fe7d8d65")
    Client() throws CommandeException {
    }

    @objid ("960eccef-011f-429b-8e90-a5b5dbbb8c31")
    void ajouterCommande(List<String> prods, List<Integer> qtes, List<Float> prix) {
    }

}
