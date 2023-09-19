import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("b9c1bade-97c0-4d2f-9b99-213182c1aca7")
public abstract class Utilisateur {
    @objid ("dcee55fd-923d-4ee1-aab0-8d2b10316189")
     String nom;

    @objid ("73a01eda-1ec9-484a-952d-576b030651c2")
     String prenom;

    @objid ("ef652c68-7337-46d5-b3ba-efdb72cadb9d")
     String identifiant;

    @objid ("bc888985-c118-4e03-bc5f-661e1fb93360")
     String motDePasse;

    @objid ("b69d04c9-5e14-42af-93d5-f14d72a6e82c")
    Utilisateur(String nom, String prenom, String identifiant, String motDePasse) {
    }

}
