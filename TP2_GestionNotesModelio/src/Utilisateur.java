import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("bb67daa2-5905-46c8-923d-ea454f1bd151")
public class Utilisateur {
    @objid ("12ba971a-1be9-4323-b47e-dc1ecb9fce5a")
    private String nom;

    @objid ("e59d8657-a05d-4048-bb8c-25b7a73109b1")
    private String prenom;

    @objid ("e64e0955-c4fb-4590-8976-2d81878f4dbc")
    private String motDePasse;

    @objid ("3ae35a90-0ac1-4d50-be2a-284317bcf000")
    private String identifiant;

    @objid ("64f17edc-08a9-4581-a20c-463643783101")
    String getNom() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nom;
    }

    @objid ("dc38c83f-9d0f-485e-a179-32ecb30c06de")
    void setNom(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.nom = value;
    }

    @objid ("50658496-4ff1-4e4c-b1a8-4c9b8099aebc")
    String getPrenom() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.prenom;
    }

    @objid ("78e3df20-51bd-4f2c-b79c-704cc2da2823")
    void setPrenom(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.prenom = value;
    }

    @objid ("048a556f-c072-4dfb-9d6c-637fec3fe0cd")
    String getMotDePasse() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.motDePasse;
    }

    @objid ("52d678d2-dd34-4ddc-880d-1b5388e741ed")
    void setMotDePasse(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.motDePasse = value;
    }

    @objid ("16d74388-f611-4bc9-a3a5-759b9ff08031")
    String getIdentifiant() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.identifiant;
    }

    @objid ("41dc19f3-0197-45dc-a15d-be9805ec1767")
    void setIdentifiant(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.identifiant = value;
    }

}
