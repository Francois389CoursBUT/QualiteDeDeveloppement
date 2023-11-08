package expression;

import exception.ExpressionMalFormeeException;
import exception.OperateurException;
import java.util.ArrayList;
import java.util.List;

public class ExpressionEntiereNaire implements Expression {
    
    private char operateur;
    
    private List<Expression> operandes = new ArrayList<Expression> ();

    /**
     * Lève ExpressionMalFormeeException si opérateur autre que + ou *, 
     * ou nombre d'opérandes < 2.
     */
    public ExpressionEntiereNaire(char operateur, List<Expression> operandes) 
            throws ExpressionMalFormeeException {
        if((operateur != '+' && operateur !='*') 
                || operandes.size() < 2)
            throw new ExpressionMalFormeeException();
        else {
            this.operateur = operateur;
            this.operandes = operandes;
        }
    }

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
          result *= operandes.get(i).evaluer();
        }
        return result;
      }
      else throw new OperateurException();
    }
}
