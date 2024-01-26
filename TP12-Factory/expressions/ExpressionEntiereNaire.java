package expressions;

import java.util.ArrayList;
import java.util.List;


public class ExpressionEntiereNaire implements Expression {
 
    private char operateur;
    private List<Expression> operandes = new ArrayList();
    
    /**
     * Evalue les opérandes puis applique l'opérateur aux valeurs des opérandes et renvoie
     * le résultat. 
     * Lève OperateurException si opérateur non autorisé.
     */  
    public int evaluer() throws OperateurException {
        int result = (int)operandes.get(0).evaluer();
        if(operateur == '+') {
            for(int i=1; i<operandes.size(); i++) {
              result += (int)operandes.get(i).evaluer();
            }
            return result;
        }   
        else if(operateur == '*') {
            for(int i=1; i<operandes.size(); i++) {
              result *= (int)operandes.get(i).evaluer();
            }
            return result;
        }
        else throw new OperateurException();
    }
    
    /**
     * Analyse et contruit une expression entière n-aire.
     * Après avoir sauté les espaces éventuels, on tente de lire une parenthèse ouvrante. En cas de succès, on
     * saute les espaces éventuels, puis on tente de lire le caractère '+' ou '*' qui représente un opérateur.
     * En cas de succès, on tente de construire les opérandes par appel à la méthode construireExpression()
     * de FactoryExpressions.
     * En cas d'erreur, l'index de te est remis à sa position qu'il avait avant la tentative de cette construction, 
     * puis l'exception ExpressionMalFormeeException est levée.
     * @param te : Texte de l'expression à construire.
     * @return : Expression entière naire construite.
     * @throws ExpressionMalFormeeException : Si te ne décrit pas une expression entière naire conforme.
     */
    public ExpressionEntiereNaire construireExpression(TexteExpression te) 
                throws ExpressionMalFormeeException {
        // A COMPLETER : quasi-identique à la méthode Evaluateur.construireExpEntiereNaire()
        // du TP11
        return null; // BOUCHON à supprimer
    }
}
