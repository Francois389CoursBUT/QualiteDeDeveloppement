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
public class ExpressionEntiereBinaire implements Expression {

    private char operateur;
    private List<Expression> operandes;

    /**
     * Lève ExpressionMalFormeeException si opérateur autre que + ou *, ou
     * nombre d'opérandes < 2.
     */
    public ExpressionEntiereBinaire(char operateur, List<Expression> operandes)
            throws ExpressionMalFormeeException {
        if ((operateur != '-' && operateur != '/')
                || operandes.size() < 2) {
            throw new ExpressionMalFormeeException();
        } else {
            this.operateur = operateur;
            this.operandes = operandes;
        }
    }

    @Override
    public int evaluer() throws OperateurException {
        int result = operandes.get(0).evaluer();
        switch (operateur) {
        case '-':
            for (int i = 1; i < operandes.size(); i++) {
                result -= operandes.get(i).evaluer();
            }
            break;
        case '/':
            for (int i = 1; i < operandes.size(); i++) {
                result /= operandes.get(i).evaluer();
            }
            break;
        default:
            throw new OperateurException();
        }
        return result;
    }
}
