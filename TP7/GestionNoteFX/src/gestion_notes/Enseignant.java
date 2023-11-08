package gestion_notes;

public class Enseignant extends Utilisateur {

    Matiere[] matieresEnseignees;

    Enseignant(String nom, String prenom, String identifiant, String motDePasse) {
        super(nom, prenom, identifiant, motDePasse);
    }

    void setMatieresEnseignees(Matiere... matieres) {
        this.matieresEnseignees = matieres;
    }

    public Matiere[] getMatieresEnseignees() {
        return matieresEnseignees;
    }

}
