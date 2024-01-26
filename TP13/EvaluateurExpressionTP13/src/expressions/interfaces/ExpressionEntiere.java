/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expressions.interfaces;

import exceptions.ExpressionMalFormeeException;
import exceptions.OperateurException;
import expressions.TexteExpression;

/**
 *
 * @author francois.desaintpala
 */
public interface ExpressionEntiere extends Expression{
    
     /**
     * Analyse et contruit une expression.
     * @param te : Texte de l'expression à construire.
     * @return : ExpressionEntiere construite.
     * @throws ExpressionMalFormeeException : Si te ne décrit pas une expression correcte.
     */
    @Override
    public ExpressionEntiere construireExpression(TexteExpression te)
            throws ExpressionMalFormeeException ;
    
    /**
     * Evalue et renvoie la valeur d'un expression correctement construite.
     * @return Valeur de l'expression
     * @throws OperateurException si opérateur non autorisé.
     */
    @Override
    public Integer evaluer() throws OperateurException ;
}
