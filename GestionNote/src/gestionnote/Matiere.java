package gestionnote;

import java.io.Serializable;
import java.util.Scanner;

public class Matiere implements Serializable{
    
  String intitule;
  Etudiant[] etudiantsInscrits;
  Matiere(String intitule) {
    this.intitule = intitule;
  }

  /**
   * Afficher en boucle un menu indiquant l'ensemble des notes pour les étudiants inscrits
   * dans une matière (this) avec la possibilité de les modifier.
   */   
  void modifierNotes() {
    float note;
    Scanner scan = new Scanner(System.in);
    boolean finModifications = false;
    String choix ;
    while (!finModifications) {

      // 1. Menu affichant les étudiants et notes (dans la matière)

      System.out.println("--- Modification des notes de la matière "+intitule);
      System.out.println("Sélectionnez l'étudiant dont vous voulez modifier la note");
      int n = 1;
      for(Etudiant etudiant: etudiantsInscrits) {
        System.out.print("("+ n++ +") - "+ etudiant.nom+" "
                +etudiant.prenom + " : ");
        note = etudiant.note(intitule);
        if (note != -1) System.out.println(note);
        else System.out.println("");
      }
      System.out.println("("+n+") - Retour au choix des matières");
      System.out.print("Votre choix ? ");
      choix = scan.next();
      try {
        n = Integer.parseInt(choix);

      // 2. Si choix d'un étudiant, saisie et modification de sa note

        if (n <= etudiantsInscrits.length) {
          // Etudiant choisi = etudiantsInscrits[n-1]

          System.out.print("Note de "+etudiantsInscrits[n-1].nom + " "
                  + etudiantsInscrits[n-1].prenom+" en "+intitule+" ? ");
          try {
            note = Float.parseFloat(scan.next());
            if (note >= 0 && note <= 20) 
              etudiantsInscrits[n-1].modifierNote(intitule, note);
            else System.out.println("Note mal saisie !");
          }
          catch(NumberFormatException e) {System.out.println("Note mal saisie !");}
        }

      // 3. Si choix de terminer les modifications des notes (pour cette matière)

        else if (n == etudiantsInscrits.length+1) finModifications = true;

      // 4. Si choix en dehors des options du menu

        else System.out.println("Choix mal saisi !");
      }

      // 5. Le choix saisi n'est pas un entier

      catch(NumberFormatException e) {System.out.println("Choix mal saisi !");}
    }
  }

  /**
   * Affecter l'ensemble des étudiants inscrits dans une matière (this) et initialiser leur note dans
   * cette matière à -1, valeur qui signifie l'absence de note et qu'un enseignant pourra modifier.
   */
  void setEtudiantsInscrits(Etudiant... etudiants) {
    etudiantsInscrits = etudiants;
    for(Etudiant etudiant: etudiants)
      etudiant.notes.add(new Note(this));
  }

}
