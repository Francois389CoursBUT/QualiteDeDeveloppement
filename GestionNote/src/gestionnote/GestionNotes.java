package gestionnote;

import exception.IdentifiantsException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class GestionNotes {
    /**
     * <Enter note text here>
     */
    private static ArrayList<Utilisateur> utilisateursEnregistres = new ArrayList<Utilisateur>();
    
    /**
     * Chemin d'accés au fichier de donnée
     */
    private String nomFichierDonnees;
    
    private static Scanner entree = new Scanner(System.in);


    /**
     * - nomFichierDonnees : chemin d'accès au fichier d'enregistrement des
     * données. - main(): Initialise les données puis affiche un menu permettant
     * à l'utilisateur de se connecter et d'exécuter les opérations qu'il est
     * autorisé à exécuter selon sa catégorie. Séquence des traitements
     * effectués : 
     * 1. Appelle verrouDonneesFerme() pour determiner si les
     * données sont verrouillées et attendre que le verrouillage soit levé. 
     * 2. Appelle verrouillerDonnees() et initialiserDonnees() pour créer ou
     * charger les données. 
     * 3. Affiche un menu permettant à l'utilisateur de se connecter à 
     * l'aide de son identifiant et son mot de passe. 
     * 4. Appelle sessionEnseignant() ou sessionEtudiant() selon le 
     * type de l'utilisateur connecté si la connexion est réussie. 
     * 5. Enregistre les données sur
     * fichier et lève le verrouillage lorsque la session est terminée.
     */
    public static void main(String[] args) throws IdentifiantsException{
        String id = "";
        String mdp = "";
        boolean connexionReussie = false;
        boolean quitter = false;
        int choix;
        /* Attendre que les données doit déverrouillé */
        if (verrouDonneesFerme()) {
            System.out.println("Donnée utiliser veillez patienter");
        }
        while (verrouDonneesFerme()) {            
            
        }
        /* Verrouille les données */
        verrouillerDonnees();
        
        initialiserDonnees();
        
        System.out.println(
"  _____             _    _                 _   _         _             \n"+
" / ____|           | |  (_)               | \\ | |       | |            \n"+
"| |  __   ___  ___ | |_  _   ___   _ __   |  \\| |  ___  | |_  ___  ___ \n"+
"| | |_ | / _ \\/ __|| __|| | / _ \\ | '_ \\  | . ` | / _ \\ | __|/ _ \\/ __| \n"+
"| |__| ||  __/\\__ \\| |_ | || (_) || | | | | |\\  || (_) || |_|  __/\\__ \\ \n"+
" \\_____| \\___||___/ \\__||_| \\___/ |_| |_| |_| \\_| \\___/  \\__|\\___||___/ \n\n"
);
        
        /* MENU de CHOIX */
        do {
            System.out.println("(1) - Se connecter\n" + 
                               "(2) - Quitter\n");
            System.out.println("Votre choix ? :");
            choix = entree.nextInt();
            if (entree.hasNextLine()) {entree.nextLine();}
            switch (choix) {
            case 1:
                /* Demandez à l'utilisateur ses informations de connexions */
                Utilisateur user = null;
                do { 
                    try {
                    System.out.print("Saisissez votre identifiant : ");
                    id = entree.next();
                    if (entree.hasNextLine()) {entree.nextLine();}

                    System.out.print("Entrez votre mot de passe : ");
                    mdp = entree.next();
                    if (entree.hasNextLine()) {entree.nextLine();}

                    user = connecter(id, mdp);
                    connexionReussie = true;
                    } catch (IdentifiantsException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Recomencez !");
                        connexionReussie = false;
                    }
                } while (!connexionReussie);

                System.out.println("Bienvenue " + user.getNom());

                if (user.getClass() == Enseignant.class) {
                    sessionEnseignant((Enseignant) user);
                } else if (user.getClass() == Etudiant.class) {
                    sessionEtudiant((Etudiant) user);
                }
                break;
           
            case 2:
                quitter = true;
                System.out.println("A bientôt, ( ﾟдﾟ)つ Bye");
                break;
            }
                    
            
        } while (!quitter);
        
        
        
        
        
        
        enregistrerDonnees();
        
        deverrouillerDonnees();
        
        
    }

    /**
     * sessionEnseignant(e): Affiche en boucle le menu des opérations possibles
     * pour un enseignant e. Opérations possibles : afficher, saisir ou modifier
     * les notes d'une matière qu'il enseigne.
     */
    private static void sessionEnseignant(Enseignant enseignant) {
    }

    /**
     * sessionEtudiant(e): Affiche toutes les notes d'un étudiant e.
     */
    private static void sessionEtudiant(Etudiant etudiant) {
    }

    /**
     * initialiserDonnees(): Initialiser toutes les données de l'application. Si
     * données enregistrées sur fichier, les charger. Sinon, créer les données
     * initiales.
     */
    private static void initialiserDonnees() {
        try {
            //chargerDonner();
            /* STUB */
            Enseignant DP = new Enseignant("Dupond", "Paul", "123456789", "paul.dupond");
            Enseignant MR = new Enseignant("Machin", "Rémy", "123", "remy.machin");
            Enseignant JB = new Enseignant("Johnson", "Boris", "456", "boris.johnson");
            
            Matiere stat = new Matiere("Statisitique");
            Matiere conception = new Matiere("Conception logicielle");
            Matiere programation = new Matiere("Programmation");
            Matiere anglais = new Matiere("Anglais");
            
            Matiere[] matierEnseigner = {stat};
            DP.setMatieresEnseignees(Arrays.asList(matierEnseigner));
            
            MR
            
            /* Fin STUB */
        } catch (Exception e) {
            //TODO Créer les données
        }
    }

    /**
     * enregistrerDonnees(): Enregisrer les données dans le fichier "donnees"
     * sous la forme d'objets sérialisés dans le dossier du projet.
     */
    private static void enregistrerDonnees() {
    }

    /**
     * verrouDonneesFerme(): Vérifie si les données sont verrouillées.
     */
    private static boolean verrouDonneesFerme() {
        return false ;//STUB
    }

    private static void deverrouillerDonnees() {
    }
    
    /**
     * @return true si les données sont utilisé par quelqu'un d'autre, false
     * sinon
     */
    private static boolean donneesVerrouillees() {
        return true;
    }
    /**
     * Verrouille les données
     */
    private static void verrouillerDonnees() {
    }

    
    /**
     * Si l'identifiant et le mot de passe sont correct, renvoie l'Utilisateur
     * qui demande à se connecter. Sinon renvoie une exception
     *
     * @param id L'identifiant du compte auquel on veut se connecter
     * @param mdp Le mot de passe du compte auquel on veut se connecter
     * @return L'utilisateur si l'identifiant et le mot de passe sont correct
     * @throws exception.IdentifiantsException Si l'identifiant ou le mot de
     * passe est incorrect
     */
    private static Utilisateur connecter(String id, String mdp) throws IdentifiantsException {
        for (Utilisateur utilisateursEnregistre : utilisateursEnregistres) {
            if (utilisateursEnregistre.getIdentifiant().equals(id)) {
                if (!utilisateursEnregistre.getMotDePasse().equals(mdp)) {
                    throw new IdentifiantsException("Mot de passe incorrect");
                }
                return utilisateursEnregistre;
            }
        }
        throw new IdentifiantsException("Identifiant incorrect, aucun utilisateur à ce nom");
    }

}
