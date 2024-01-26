

import expressions.ExpressionMalFormeeException;
import expressions.FactoryExpressions;
import java.util.Scanner;


public class Evaluateur { 
     
    /**
     * Analyse, contruit puis évalue une expression entière constante ou naire.
     * L'abalyse et la construction sont déléguées à FactoryExpressions.
     * L'évaluation fait appel à la méthode Expression.evaluer().
     * @param texte : Chaîne de caractères décrivant l'expression à construire et évaluer.
     * @return : Valeur de l'expression construite. 
     * @throws ExpressionMalFormeeException : Si texte ne décrit pas une expression conforme.
     */
    public static int evaluer(String texte) throws ExpressionMalFormeeException {
      return FactoryExpressions.getInstance().construireExpression(texte).evaluer();
    }
    
    /**
     * Boucle sans fin (arrêtée de l'extérieur) permettant de :
     * - lire le texte d'une expression au clavier
     * - utiliser l'Evaluateur pour l'analyser et l'évaluer
     * - afficher le résultat ou un message d'erreur si l'expression est mal formée.
     */
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        while (true) {
            System.out.println("Saisir une expression :");
            try {        
                System.out.println("Valeur = "+evaluer(clavier.nextLine()));
            }
            catch(ExpressionMalFormeeException e) {
                  System.out.println("Erreur : expression incorrecte");
            }
        }
    }
}
