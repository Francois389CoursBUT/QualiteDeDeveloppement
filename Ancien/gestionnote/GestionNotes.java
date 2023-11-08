package gestionnote;

import exception.IdentificationException;
import java.io.*;
import java.util.Scanner;

public class GestionNotes {
        
  private static Utilisateur[] utilisateursEnregistres;
  private static String nomFichierDonnees = "donnees";
  private static String nomVerrouDonnees = "verrou_donnees";

  /**
   * Affiche en boucle le menu des opérations possibles pour un enseignant.
   * Opérations possibles : afficher et modifier les notes d'une matière qu'il enseigne.
   */    
  private static void sessionEnseignant(Enseignant enseignant) {
    Matiere[] matieres = enseignant.matieresEnseignees;
    Scanner scan = new Scanner(System.in);
    boolean finSession = false;
    String choix ;
    while (!finSession) {

      // 1. Menu pour choisir une des matières enseignées
      System.out.println("Sélectionnez la matière dont vous voulez manipuler les notes :");
      int n = 1;
      for(Matiere m: matieres) System.out.println("("+ n++ +") - "+ m.intitule);
      System.out.println("("+n+") - Quitter la session");
      System.out.print("Votre choix ? ");
      choix = scan.next();
      try {
        n = Integer.parseInt(choix);

      // 2. Si choix d'une matière
        if (n <= matieres.length) {
          // Matière choisie = matieres[n-1]
          matieres[n-1].modifierNotes();
        }

      // 3. Si choix de quitter la session
        else if (n == matieres.length+1) finSession = true;

      // 4. Choix en dehors des options du menu
        else System.out.println("Choix mal saisi !");
      }

      // 5. Le choix saisi n'est pas un entier
      catch(NumberFormatException e) {System.out.println("Choix mal saisi !");}
    }
  } 

  /**
   * Affiche toutes les notes d'un étudiant.
   */
  private static void sessionEtudiant(Etudiant etudiant) {
    System.out.print(etudiant.notesToString());
  }

  /**
   * Vérifie l'existence d'un utilisateur possédant un identifiant et un mot de passe pass 
   * donnés, et renvoie cet utilisateur s'il en existe. Lève IdentificationException sinon.
   */
  private static Utilisateur connecter(String identifiant, String motDePasse) 
          throws IdentificationException {
    for(Utilisateur u : utilisateursEnregistres) {
      if (u.identifiant.equals(identifiant) & u.motDePasse.equals(motDePasse))
        return u;
    }
    throw new IdentificationException();
  }

  /**
   * Initialiser toutes les données de l'application.
   * Si données enregistrées sur fichier, les charger.
   * Sinon, créer les données initiales.
   */
  private static void initialiserDonnees() throws IOException, ClassNotFoundException  {
    // 1. Cas données enregistrées sur fichier dont le nom est défini dans nomFichierdonnees
    if(new File(nomFichierDonnees).isFile()){
      ObjectInputStream donnees = new ObjectInputStream(new FileInputStream(nomFichierDonnees));
      utilisateursEnregistres = (Utilisateur[])donnees.readObject();
      donnees.close();
    }
    else {
    // 2. Cas données non déjà enregistrées
      //--- 2.1 Créer Matières
      Matiere math = new Matiere("Statistiques");
      Matiere java = new Matiere("Conception logicielle");
      Matiere coo = new Matiere("Programmation");
      Matiere anglais = new Matiere("Anglais");

      //--- 2.2 Créer Enseignants et matières enseignées
      Enseignant e1 = new Enseignant("DUPOND", "Paul", "dupondpaul", "123");
      e1.setMatieresEnseignees(math);
      Enseignant e2 = new Enseignant("MACHIN", "Rémy", "machinremy", "456");
      e2.setMatieresEnseignees(java, coo);
      Enseignant e3 = new Enseignant("JOHNSON", "Boris", "johnsonboris", "789");
      e3.setMatieresEnseignees(anglais);

      //--- 2.3 Créer Etudiants et matières auxquelles ils sont inscrits
      Etudiant et1 = new Etudiant("CARTIER", "Axel","cartieraxel","1");
      Etudiant et2 = new Etudiant("BARTHEZ", "Enzo","barthezenzo","2");
      Etudiant et3 = new Etudiant("MANOUKIAN", "Léa","manoukianlea","3");
      Etudiant et4 = new Etudiant("PETRUZZI", "Tony","petruzzitony","4");
      Etudiant et5 = new Etudiant("DUTRONC", "Maxime","dutroncmaxime","5");
      Etudiant et6 = new Etudiant("MONTALBAN", "Maéva","montalbanmaeva","6");
      math.setEtudiantsInscrits(et1, et2, et3);
      java.setEtudiantsInscrits(et1, et2, et3, et4, et5, et6);
      coo.setEtudiantsInscrits(et1, et2, et3, et4, et5, et6);
      anglais.setEtudiantsInscrits(et4, et5, et6);

      //--- 2.4 Créer Utilisateurs enregistrés
      utilisateursEnregistres = new Utilisateur[]{e1, e2, e3, et1, et2, et3, et4, et5, et6};
    }
  }
    
  /**
   * Enregisrer les données dans le fichier nomFichierdonnees sous la forme d'objets sérialisés
   * dans le dossier du projet.
   */
  private static void enregistrerDonnees() throws IOException {
    try {
        ObjectOutputStream donnees = new ObjectOutputStream(new FileOutputStream(nomFichierDonnees));
        donnees.writeObject(utilisateursEnregistres);
        donnees.close();
    }
    catch(IOException e) {
      System.out.println("Erreur sauvegarde ");
    }
  }

  /**
   * Pose un verrou (fermé) sur les données en créant un fichier dont le nom est défini 
   * dans nomVerrouDonnees.
   */
  private static void verrouillerDonnees() throws FileNotFoundException, IOException {
    new File(nomVerrouDonnees).createNewFile();
  }
   
  /**
   * Vérifie si les données sont verrouillées en testant si le fichier dont le nom est défini 
   * dans nomVerrouDonnees existe.
   * Renvoie true si vrai, false sinon.
   */
  private static boolean verrouDonneesFerme()  {
    return (new File(nomVerrouDonnees).isFile());
  }
  
  /**
   * Lève le verrouillage des données en supprimant le fichier dont le nom est défini 
   * dans nomVerrouDonnees.
   */
  private static void deVerrouillerDonnees() {
    new File(nomVerrouDonnees).delete();
  }
}
