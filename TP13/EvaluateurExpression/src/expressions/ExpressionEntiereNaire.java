package expressions;

import java.util.ArrayList;
import java.util.List;


public class ExpressionEntiereNaire implements Expression {
 
    private char operateur;
    private List<Expression> operandes = new ArrayList<Expression> ();
    
    /**
     * Evalue les opérandes puis applique l'opérateur aux valeurs des opérandes et renvoie
     * le résultat. 
     * Lève OperateurException si opérateur non autorisé.
     */   
    public int evaluer() throws OperateurException {
      int result = operandes.get(0).evaluer();
      if(operateur == '+') {
        for(int i=1; i<operandes.size(); i++) {
          result += operandes.get(i).evaluer();
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
     * saute les espaces éventuels, puis on tente de lire le caractère '+' ou '*' qui reprsente un opérateur.
     * En cas de succès, on tente de construire les opérandes par appel à la méthode construireExpression().
     * En cas d'erreur, l'index de te est remis à sa position qu'il avait avant la tentative de cette construction, 
     * puis l'exception ExpressionMalFormeeException est levée.
     * @param te : Texte de l'expression à construire.
     * @return : Expression entière naire construite.
     * @throws ExpressionMalFormeeException : Si te ne décrit pas une expression entière naire conforme.
     */
    public ExpressionEntiereNaire construireExpression(TexteExpression te) 
                throws ExpressionMalFormeeException {
        char c;
        int indexDepart = te.getIndex();
        try {
            // 1. Sauter les espaces événtuels
            c = te.caractereCourant();
            if (c==' ') c = te.caractereNonEspaceSuivant();
            // 2. Si le 1er caractère non espace n'est pas une parenthèse ouvrante, l'expression naire est mal formée.
            if (c != '(') throw new ExpressionMalFormeeException();
            // 3. Sinon, sauter les espaces éventuels.
            c = te.caractereNonEspaceSuivant();
            // 4. Si, après la parenthèse ouvrante, le 1er caractère non espace est autre que '+' 
            // ou '*', l'expression naire est mal formée.
            if (c != '+' && c != '*') {
                te.setIndex(indexDepart);
                throw new ExpressionMalFormeeException();
            }
            // 5. Sinon, vérifier que l'opérateur est suivi d'un espace avant de
            // tenter de construire les opérandes puis l'expression naire à renvoyer.
            else { 
                char operateur = c;
                if (te.caractereSuivant()!=' ') throw new ExpressionMalFormeeException();
                // Construire opérandes
                // Le dernier opérande devant être suivi de ')', on boucle sur la construction
                // d'un opérande tant que le caractère courant est différent de ')'.
                ArrayList<Expression> operandes = new ArrayList();
                while(c != ')') {
                    Expression operande = 
                            FactoryExpressions.getInstance().construireExpression(te); 
                    operandes.add(operande);
                    c = te.caractereNonEspaceSuivant();
                }            
                ExpressionEntiereNaire exp = new ExpressionEntiereNaire();
                exp.operateur = operateur;
                exp.operandes = operandes;
                return exp;
            }
        }
        catch(FinTexteException e) {
            throw new ExpressionMalFormeeException();
        }
    }
}
