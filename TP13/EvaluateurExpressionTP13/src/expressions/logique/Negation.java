/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expressions.logique;

import exceptions.ExpressionMalFormeeException;
import exceptions.FinTexteException;
import exceptions.OperateurException;
import expressions.FactoryExpressions;
import expressions.TexteExpression;
import expressions.interfaces.ExpressionLogique;

/**
 *
 * @author francois.desaintpala
 */
public class Negation implements ExpressionLogique{

    private ExpressionLogique operande;

    @Override
    public Negation construireExpression(TexteExpression te) throws ExpressionMalFormeeException {
        char c;
        int indexDepart =te.getIndex();
        try {
            // 1. Sauter les espaces éventuels
            c =te.caractereCourant();
            if (c==' ') c =te.caractereNonEspaceSuivant();
            // 2. Si le 1er caractère non espace n'est pas une parenthèse ouvrante, 
            // la Négtation est mal formée.
            if (c != '(') throw new ExpressionMalFormeeException();
            // 3. Sinon, si après la parenthèse ouvrante, le 1er caractère non espace est autre 
            // que '!', la Négation est mal formée.
            c =te.caractereNonEspaceSuivant();
            if (c != '!') {                 
               te.setIndex(indexDepart);
                throw new ExpressionMalFormeeException();
            }
            // 4. Sinon, vérifier que l'opérateur "!" est suivi d'un espace avant de
            // tenter de construire l'opérande puis l'expression Negation à renvoyer.
            else { 
                if (te.caractereSuivant()!=' ') 
                    throw new ExpressionMalFormeeException();
                ExpressionLogique operande = FactoryExpressions
                            .getInstance().construireExpressionLogique(te);
            // 6. Si l'opérande n'est pas suivi d'une parenthèse fermante, la Negation est 
            // mal formée. Sinon, contruire et renvoyer la Négation.
                c =te.caractereNonEspaceSuivant();
                if (c != ')') throw new ExpressionMalFormeeException();
                else {
                    Negation negation = new Negation();
                    negation.operande = operande;
                    return negation;
                }                
            }
        }
        catch(FinTexteException e) {
            throw new ExpressionMalFormeeException();
        }
    }

    @Override
    public Boolean evaluer() throws OperateurException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
