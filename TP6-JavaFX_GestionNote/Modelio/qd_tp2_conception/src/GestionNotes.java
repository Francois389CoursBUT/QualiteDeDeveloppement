import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("a9b44647-ee1b-42d8-afda-ff9f24fd65bd")
public class GestionNotes {
    @objid ("2e961b30-a55a-402f-9056-9bf9994afa30")
    private static String nomFichierDonnees;

    /**
     * <Enter note text here>
     */
    @objid ("4691d038-61d7-4328-997c-f701f6ecd5ed")
    private static List<Utilisateur> utilisateursEnregistres = new ArrayList<Utilisateur> ();

    /**
     * - nomFichierDonnees : chemin d'accès au fichier d'enregistrement des données.
     * - main(): Initialise les données puis affiche un menu permettant à l'utilisateur de se connecter et d'exécuter les opérations qu'il est autorisé à exécuter selon sa catégorie. Séquence des traitements effectués : 
     * 1. Appelle verrouDonneesFerme() pour determiner si les données sont verrouillées et attendre que le verrouillage soit levé.
     * 2. Appelle verrouillerDonnees() et initialiserDonnees() pour créer ou charger les données.
     * 3. Affiche un menu permettant à l'utilisateur de se connecter à l'aide de son identifiant et son mot de passe. 
     * 4. Appelle sessionEnseignant() ou sessionEtudiant() selon le type de l'utilisateur connecté si la connexion est réussie.
     * 5. Enregistre les données sur fichier et lève le verrouillage lorsque la session est terminée.
     */
    @objid ("238e9b18-a977-472b-ab18-9ba294ca9a7b")
    public static void main(List<String> args) {
    }

    /**
     * sessionEnseignant(e): Affiche en boucle le menu des opérations possibles pour un enseignant e. Opérations possibles : afficher, saisir ou modifier les notes d'une matière qu'il enseigne.
     */
    @objid ("0e2d87f5-749d-404d-8cfd-d7d7c1b233fc")
    private static void sessionEnseignant(Enseignant enseignant) {
    }

    /**
     * sessionEtudiant(e): Affiche toutes les notes d'un étudiant e.
     */
    @objid ("1147d208-fc23-4ca2-bcc1-70b027538d1c")
    private static void sessionEtudiant(Etudiant etudiant) {
    }

    /**
     * connecter(id,pass) : Vérifie l'existence d'un utilisateur possédant l'identifiant id et le mot de passe pass et renvoie cet utilisateur s'il en existe. Lève IdentificationException sinon.
     */
    @objid ("e13e00ed-0804-46af-8f82-aaa5eb49d72c")
    private static Utilisateur connecter(String identifiant, String motDePasse) throws IdentificationException {
    }

    /**
     * initialiserDonnees(): Initialiser toutes les données de l'application. Si données enregistrées sur fichier, les charger. Sinon, créer les données initiales.
     */
    @objid ("d9238d76-3cbe-442d-a788-dddb2f8bb643")
    private static void initialiserDonnees() {
    }

    /**
     * enregistrerDonnees(): Enregisrer les données dans le fichier "donnees" sous la forme d'objets sérialisés dans le dossier du projet.
     */
    @objid ("15be9cd8-45a3-44a4-896d-99baf68ca68c")
    private static void enregistrerDonnees() {
    }

    /**
     * verrouDonneesFerme(): Vérifie si les données sont verrouillées.
     */
    @objid ("25db6b76-64af-4acf-9f3c-c20c263fb942")
    private static boolean verrouDonneesFerme() {
    }

    /**
     * verrouillerDonnees(): Pose un verrou (fermé) sur les données.
     */
    @objid ("f292ecda-e01c-4840-a3a1-f22a0e10dece")
    private static void verrouillerDonnees() {
    }

    @objid ("2cc0ae11-6063-445d-b51b-585ce02ee729")
    private static void deverrouillerDonnees() {
    }

}
