package expressions;

import java.util.ArrayList;

public class FactoryExpressions {
    
    private ArrayList<Expression> typesExpressions; // instances de chaque type d'expression 
    
    private static FactoryExpressions instance = new FactoryExpressions();
       
    private FactoryExpressions() {
        typesExpressions = new ArrayList();
        typesExpressions.add(new ConstanteEntiere());
        typesExpressions.add(new ExpressionEntiereNaire());
        typesExpressions.add(new ExpressionEntiereBinaire());
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
      TexteExpression te = new TexteExpression(expression);
      Expression result = construireExpression(te);
      // S'assurer que c'est la fin du texte avant de renvoyer l'expression construite.
      try { 
        te.caractereNonEspaceSuivant(); 
        throw new ExpressionMalFormeeException(); // Cas non fin du texte
      }
      catch(FinTexteException e) { // Cas fin du texte
        return result; 
      } 
    }
    
    /**
     * Tente de construire une expression d'un type dont une instance a été enregsitrée.
     * @param te : Texte de l'expression à construire.
     * @return : Expression construite.
     * @throws ExpressionMalFormeeException : Si te ne décrit pas une expression conforme
     */
    Expression construireExpression(TexteExpression te) 
                throws ExpressionMalFormeeException {
        for (Expression exp: typesExpressions) {
            try {
                return exp.construireExpression(te);
            }
            catch (ExpressionMalFormeeException e) {}
        }
        throw new ExpressionMalFormeeException();
    }
}
