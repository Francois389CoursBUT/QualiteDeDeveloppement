package gestion_notes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GestionNotes {

    private static Utilisateur[] utilisateursEnregistres;
    private static String nomFichierDonnees = "donnees";
    private static String nomVerrouDonnees = "verrou_donnees";

    /**
     * Vérifie l'existence d'un utilisateur possédant un identifiant et un mot
     * de passe pass données, et renvoie cet utilisateur s'il en existe. Lève
     * IdentificationException sinon.
     */
    public static Utilisateur connecter(String identifiant, String motDePasse)
            throws IdentificationException {
        for (Utilisateur u : utilisateursEnregistres) {
            if (u.identifiant.equals(identifiant) & u.motDePasse.equals(motDePasse)) {
                return u;
            }
        }
        throw new IdentificationException();
    }

    /**
     * Initialise toutes les données de l'application. Si données enregistrées
     * sur fichier, les charger. Sinon, créer les données initiales.
     */
    public static void initialiserDonnees() throws IOException, ClassNotFoundException {
        // 1. Cas données enregistrées sur fichier dont le nom est défini dans nomFichierdonnees
        if (new File(nomFichierDonnees).isFile()) {
            ObjectInputStream donnees = new ObjectInputStream(new FileInputStream(nomFichierDonnees));
            utilisateursEnregistres = (Utilisateur[]) donnees.readObject();
            donnees.close();
        } else {
            // 2. Cas données non déjà enregistrées
            //--- 2.1 Créer Matières
            Matiere math = new Matiere("Mathématiques");
            Matiere java = new Matiere("Programmation Java");
            Matiere coo = new Matiere("Conception Objet");
            Matiere anglais = new Matiere("Anglais");

            //--- 2.2 Créer Enseignants et matières enseignées
            Enseignant e1 = new Enseignant("DUPOND", "Paul", "dupondpaul", "123");
            e1.setMatieresEnseignees(math);
            Enseignant e2 = new Enseignant("MACHIN", "Rémy", "machinremy", "456");
            e2.setMatieresEnseignees(java, coo);
            Enseignant e3 = new Enseignant("JOHNSON", "Boris", "johnsonboris", "789");
            e3.setMatieresEnseignees(anglais);

            //--- 2.3 Créer Etudiants et matières auxquelles ils sont inscrits
            Etudiant et1 = new Etudiant("CARTIER", "Axel", "cartieraxel", "1");
            Etudiant et2 = new Etudiant("BARTHEZ", "Enzo", "barthezenzo", "2");
            Etudiant et3 = new Etudiant("MANOUKIAN", "Léa", "manoukianlea", "3");
            Etudiant et4 = new Etudiant("PETRUZZI", "Tony", "petruzzitony", "4");
            Etudiant et5 = new Etudiant("DUTRONC", "Maxime", "dutroncmaxime", "5");
            Etudiant et6 = new Etudiant("MONTALBAN", "Maéva", "montalbanmaeva", "6");
            math.setEtudiantsInscrits(et1, et2, et3);
            java.setEtudiantsInscrits(et1, et2, et3, et4, et5, et6);
            coo.setEtudiantsInscrits(et1, et2, et3, et4, et5, et6);
            anglais.setEtudiantsInscrits(et4, et5, et6);

            //--- 2.4 Créer Utilisateurs enregistrés
            utilisateursEnregistres = new Utilisateur[]{e1, e2, e3, et1, et2, et3, et4, et5, et6};
        }
    }

    /**
     * Enregisre les données dans le fichier "donnees" sous la forme d'objets
     * sérialisés dans le dossier du projet.
     */
    public static void enregistrerDonnees() {
        try {
            ObjectOutputStream donnees = new ObjectOutputStream(new FileOutputStream(nomFichierDonnees));
            donnees.writeObject(utilisateursEnregistres);
            donnees.close();
            System.out.println("====> Enregistrement sur fichier");
        } catch (IOException e) {
            System.out.println("Erreur sauvegarde ");
        }
    }

    /**
     * Pose un verrou (fermé) sur les données.
     *
     * @throws IOException
     */
    public static void verrouillerDonnees() throws IOException {
        new FileWriter(new File(nomVerrouDonnees)).close();
    }

    /**
     * Vérifie si les données sont verrouillées.
     *
     * @return true si oui, false sinon
     * @throws IOException
     */
    public static boolean verrouDonneesFerme() throws IOException {
        return (new File(nomVerrouDonnees).isFile());
    }

    /**
     * Lève le verrouillage des données.
     *
     * @throws IOException
     */
    public static void deVerrouillerDonnees() throws IOException {
        new File(nomVerrouDonnees).delete();
    }
}
