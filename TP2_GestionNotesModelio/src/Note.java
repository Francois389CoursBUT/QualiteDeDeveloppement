import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("c56b44db-6a76-45a9-b12d-52df98934958")
public class Note {
    @objid ("c13c9d82-cd18-4bcc-9329-8d6daa9669ee")
    private float valeur;

    @objid ("cfced2d6-e980-4995-a658-94533077041e")
     Matiere matiere;

    @objid ("34e83dc4-d405-44e0-99a1-5f92b602b66e")
    float getValeur() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.valeur;
    }

    @objid ("54864c00-7408-4263-93a5-45061396a303")
    void setValeur(float value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.valeur = value;
    }

}
