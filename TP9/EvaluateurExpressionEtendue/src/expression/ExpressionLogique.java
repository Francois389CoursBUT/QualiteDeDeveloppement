/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expression;

import exception.ExpressionMalFormeeException;
import exception.OperateurException;
import java.util.List;

/**
 *
 * @author francois.desaintpala
 */
public class ExpressionLogique implements Expression{

    private char operateur;
    private List<Expression> operandes;

    public ExpressionLogique(char operateur, List<Expression> operandes) throws ExpressionMalFormeeException {
        if ((operateur != '&' && operateur != '|')
                || operandes.size() < 2) {
            throw new ExpressionMalFormeeException();
        } else {
            this.operateur = operateur;
            this.operandes = operandes;
        }
    }
    
    @Override
    public int evaluer() throws OperateurException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
