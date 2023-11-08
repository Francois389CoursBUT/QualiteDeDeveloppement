import java.util.ArrayList;
import java.util.Scanner;

public class Evaluateur {
   
  /**
   * Traitement récursif de la chaîne à analyser contenue dans le paramètre TexteExpression te :
   * - Cas terminal : 1er caractère non espace <> '('. La chaîne doit correspondre à une constante,
   * alors on tente de la convertir en entier et on renvoie sa valeur.
   * - Cas récursif : 1er caractère non espace = '('. La chaîne doit correspondre à une expression
   * n-aire. Alors on cherche son opérateur (+ ou *), on cherche ensuite à obtenir récusivement les
   * valeurs de ses opérandes, puis on les aditionne ou on les multiplie (selon l'opérateur) et on
   * renvoie le résultat.
   * - Lève ExpressionMalFormeeException si l'expression n'est pas syntaxiquement correcte.
   */
  static int analyserEtEvaluer(TexteExpression te) throws ExpressionMalFormeeException {
    try {
      int result = 0; // Résultat final (réinitialisé à 1 si multiplication)     
      char operateur;
      
      // 1. Sauter les espaces éventuels en débutde chaîne
      char c = te.caractereCourant();
      if(c ==' ') c = te.caractereNonEspaceSuivant();
      
      // 2. Cas 1er caractère non espace <> '(' : il doit s'agir d'une constante entière
     
      if (c!='(') {
        // 2.1 Construire une chaîne terminée par un espace, une parenthèse ouvrante, une parenthèse
        // fermante ou la fin du texte (cas d'une expression réduite à une constante).
        String texteConstante = ""+c;
        try {        
            c = te.caractereSuivant(); 
            while (c != ' ' && c != '(' && c != ')') {
                texteConstante += c;             
                c = te.caractereSuivant();
            }
            // Si l'on s'est arrêté sur une parenthèse, repositionner l'index sur cette
            // parenthèse pour la suite de l'analyse (construction d'une expression naire)
            if (c == ')' || c == '(') te.index--;
        }
        catch (FinTexteException e) {   } // Fin de l'expression = fin de la constante       
        // 2.2 Tenter de convertir en entier la chaîne lue et renvoyer une sa valeur.
        try {
            result = Integer.parseInt(texteConstante);
        }
        catch(NumberFormatException e)  {
            // Si la conversion en entier échoue, l'expression est incorrecte 
            throw new ExpressionMalFormeeException();
        }       
      }
      
      // 3. Cas 1er caractère non espace = '(' : il doit s'agir d'une expression N-aire + ou *
      
      else try {
        // 3.1 Déterminer l'opérateur + ou *
        c = te.caractereNonEspaceSuivant();
        if (c !='+' && c !='*') throw new ExpressionMalFormeeException();
        else operateur = c;
        // 3.2 vérifier que l'opérateur est suivi d'un espace.
        if (te.caractereSuivant()!=' ') throw new ExpressionMalFormeeException();
        // 3.3 Déterminer les opérandes. Le dernier opérande devant être suivi de ')', on boucle
        // sur la construction d'un opérande tant que le caractère courant est différent de ')'.
        ArrayList<Integer> operandes = new ArrayList();
        while(c != ')') {
            int operande = analyserEtEvaluer(te); 
            operandes.add(operande);
            c = te.caractereNonEspaceSuivant();
        }
        if (operandes.size()<2) throw new ExpressionMalFormeeException();
        // 3.4 Evaluer l'expression
        if (operateur =='+') for (int x: operandes) result +=x;
        if (operateur =='*') {
          result = 1;
          for (int x: operandes) result *=x;
        }
      }
      catch(FinTexteException e) {
        // 3.5 Cas fin de texte atteinte avant la fin de l'expression 
        throw new ExpressionMalFormeeException();
      }
      // 4. Retour résultat
      return result;
    }
    catch(NumberFormatException | FinTexteException  e) {
      throw new ExpressionMalFormeeException();
    }
  }
  
  /** Boucle effectuant le traitement suivant :
   * . Demander à l'utilisateur soit de saisir une expression à évaluer sous la forme d'une chaîne
   *   de caractères, soit d'arrêter.
   * . Appeler analyserEtEvaluer() pour analyser et évaluer l'expression saisie.
   * . Afficher la valeur de l'expression si elle est syntaxiquement correcte, ou un message d'erreur
   *   sinon.
   */  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String expression;
    boolean fin = false;
    while (!fin) {
      System.out.println("Saisir une expression ou $ pour terminer :");
      expression = scanner.nextLine();
      if (expression.equals("$")) fin = true;
      // Analyser et évaluer et afficher son résultat ou erreur si expression incorrecte
      else try {
        TexteExpression te = new TexteExpression(expression);
        int result = analyserEtEvaluer(te);
        // Si expression évaluée avec succès, s'assurer que la fin de la chaîne correspond à la fin
        // de l'expression analysée (éviter des expressions comme : "123 56", "(+ 1 2))", "(* 2 5) 10".
//        try {
//          te.caractereNonEspaceSuivant();
//          // Si FinTexteException n'est pas levée : la chaîne contient des caractères non espace
//          // après la fin de l'expression évaluée
//          System.out.println("Erreur de syntaxe");
//        }
//        catch(FinTexteException ex) {
//          // Si FinTexteException est levée : plus de caractère non espace après la fin de 
//          // l'expression évaluée
          System.out.println("Résultat = "+result);
//        }
      }
      catch(ExpressionMalFormeeException e) {
        System.out.println("Erreur de syntaxe");
      }
    }
  }
}
