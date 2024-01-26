
package expressions;

public class FactoryExpressions {

    // A COMPLETER : 
    // Définir l'attribut typesExpressions où l'on enregistre chaque type d'expression géré
    // par la factory
    
    private static FactoryExpressions instance = new FactoryExpressions();
       
    private FactoryExpressions() {
        // A COMPLETER :
        // Enregistrer les types d'expression gérés par la factory
    }
    
    public static FactoryExpressions getInstance() {
        return instance;
    }
    
    /**
     * Tente de construire une expression fournie sous la forme d'une chaîne de caractères,
     * par appel à construireExpression(TexteExpression) puis vérifie que la fin de
     * l'expression coïncide avec la fin de la chaîne. 
     * Lève ExpressionMalFormeeException si l'expressiion est incorrecte syntaxiquement 
     * ou si la fin de l'expression ne coïncide pas avec la fin de la chaîne.
     */
    public Expression construireExpression(String expression) throws ExpressionMalFormeeException {
      // A COMPLETER
      return null; // BOUCHON à supprimer
    }
    
    /**
     * Tente de construire une expression d'un type dont une instance a été enregsitrée.
     * @param te : Texte de l'expression à construire.
     * @return : Expression construite.
     * @throws ExpressionMalFormeeException : Si te ne décrit pas une expression conforme
     */
    Expression construireExpression(TexteExpression te) throws ExpressionMalFormeeException {
      // A COMPLETER
      return null; // BOUCHON à supprimer
    }
}
     
            
