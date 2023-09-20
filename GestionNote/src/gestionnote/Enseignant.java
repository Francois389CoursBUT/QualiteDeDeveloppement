package gestionnote;

import java.io.Serializable;

public class Enseignant extends Utilisateur implements Serializable{
    
  Matiere[] matieresEnseignees;

  Enseignant(String nom, String prenom, String identifiant, String motDePasse) {
    super(nom, prenom, identifiant, motDePasse);
  }

    public void setMatieresEnseignees(Matiere... matieresEnseignees) {
        this.matieresEnseignees = matieresEnseignees;
    }

}
