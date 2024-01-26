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
import expressions.entiere.ExpressionEntiereNaire;
import expressions.interfaces.ExpressionEntiere;
import expressions.interfaces.ExpressionLogique;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author francois.desaintpala
 */
public class ExpLogiqueNaire implements ExpressionLogique{

    private LinkedList<ExpressionLogique> operandes;
    
    private char operateur;
    
    @Override
    public Boolean evaluer() throws OperateurException {
        boolean result = (boolean) operandes.get(0).evaluer();
        switch (operateur) {
            case '&':
                for(int i=1; i<operandes.size(); i++) {
                    result = result & (boolean)operandes.get(i).evaluer();
                }
                return result;
            case '|':
                for(int i=1; i<operandes.size(); i++) {
                    result = result | operandes.get(i).evaluer();
                }
                return result;
            default:
                throw new OperateurException();
        }
    }
    
    @Override
    public ExpLogiqueNaire construireExpression(TexteExpression te) 
            throws ExpressionMalFormeeException {
              char c;
        int indexDepart = te.getIndex();
        try {
            // 1. Sauter les espaces éventuels
            c = te.caractereCourant();
            if (c==' ') c = te.caractereNonEspaceSuivant();
            // 2. Si le 1er caractère non espace n'est pas une parenthèse ouvrante, l'expression naire est mal formée.
            if (c != '(') throw new ExpressionMalFormeeException();
            // 3. Sinon, sauter les espaces éventuels.
            c = te.caractereNonEspaceSuivant();
            // 4. Si, après la parenthèse ouvrante, le 1er caractère non espace est autre que '&' 
            // ou '|', l'expression naire est mal formée.
            if (c != '&' && c != '|') {
                te.setIndex(indexDepart);
                throw new ExpressionMalFormeeException();
            }
            // 5. Sinon, vérifier que l'opérateur est suivi d'un espace avant de
            // tenter de construire les opérandes puis l'expression naire à renvoyer.
            else { 
                char operateur = c;
                if (te.caractereSuivant()!=' ') 
                    throw new ExpressionMalFormeeException();
                // Construire opérandes
                // Le dernier opérande devant être suivi de ')', on boucle sur la construction
                // d'un opérande tant que le caractère courant est différent de ')'.
                LinkedList<ExpressionLogique> operandes = new LinkedList();
                while(c != ')') {
                    ExpressionLogique operande = FactoryExpressions
                            .getInstance().construireExpressionLogique(te); 
                    operandes.add(operande);
                    c = te.caractereNonEspaceSuivant();
                }
                ExpLogiqueNaire exp = new ExpLogiqueNaire();
                exp.operandes = operandes;
                exp.operateur = operateur;
                return exp;
            }
        }
        catch(FinTexteException e) {
            throw new ExpressionMalFormeeException();
        }
    }
}
