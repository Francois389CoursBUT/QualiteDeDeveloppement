package expressions;

import exceptions.FinTexteException;
import exceptions.ExpressionMalFormeeException;
import expressions.entiere.ExpressionEntiereBinaire;
import expressions.entiere.ExpressionEntiereNaire;
import expressions.entiere.ConstanteEntiere;
import expressions.interfaces.Expression;
import expressions.interfaces.ExpressionEntiere;
import expressions.interfaces.ExpressionLogique;
import expressions.logique.Comparaison;
import expressions.logique.ExpLogiqueNaire;
import expressions.logique.Negation;
import java.util.ArrayList;

public class FactoryExpressions {
    
    private ArrayList<ExpressionEntiere> typesExpressionsEntieres; // instances de chaque type d'expression 
    private ArrayList<ExpressionLogique> typesExpressionsLogiques ; // instances de chaque type d'expression 
    
    
    private static FactoryExpressions instance = new FactoryExpressions();
       
    private FactoryExpressions() {
        typesExpressionsEntieres = new ArrayList();
        typesExpressionsEntieres.add(new ConstanteEntiere());
        typesExpressionsEntieres.add(new ExpressionEntiereNaire());
        typesExpressionsEntieres.add(new ExpressionEntiereBinaire());
        
        typesExpressionsLogiques = new ArrayList();
        typesExpressionsLogiques.add(new Comparaison());
        typesExpressionsLogiques.add(new Negation());
        typesExpressionsLogiques.add(new ExpLogiqueNaire());
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
     * @param expression
     * @return 
     * @throws exceptions.ExpressionMalFormeeException 
     */
    public Expression construireExpression(String expression) throws ExpressionMalFormeeException {
      TexteExpression te = new TexteExpression(expression);
      Expression result;
        try {
          result = construireExpressionEntiere(te);
        } catch (ExpressionMalFormeeException e) {
            result = construireExpressionLogique(te);
        }
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
    public ExpressionLogique construireExpressionLogique(TexteExpression te) 
                throws ExpressionMalFormeeException {
        for (ExpressionLogique exp: typesExpressionsLogiques) {
            try {
                return exp.construireExpression(te);
            }
            catch (ExpressionMalFormeeException e) {}
        }
        throw new ExpressionMalFormeeException();
    }
    /**
     * Tente de construire une expression d'un type dont une instance a été enregsitrée.
     * @param te : Texte de l'expression à construire.
     * @return : Expression construite.
     * @throws ExpressionMalFormeeException : Si te ne décrit pas une expression conforme
     */
    public ExpressionEntiere construireExpressionEntiere(TexteExpression te) 
                throws ExpressionMalFormeeException {
        for (ExpressionEntiere exp: typesExpressionsEntieres) {
            try {
                return exp.construireExpression(te);
            }
            catch (ExpressionMalFormeeException e) {}
        }
        throw new ExpressionMalFormeeException();
    }
}
