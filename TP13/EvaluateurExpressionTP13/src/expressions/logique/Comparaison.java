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
import expressions.interfaces.ExpressionEntiere;
import expressions.interfaces.ExpressionLogique;

/**
 *
 * @author francois.desaintpala
 */
public class Comparaison implements ExpressionLogique{

    private char comparateur;
    
    ExpressionEntiere gauche;
    
    ExpressionEntiere droite;

    @Override
    public Comparaison construireExpression(TexteExpression te) throws ExpressionMalFormeeException {
        char c;
        int indexDepart =te.getIndex();
        try {
            // 1. Sauter les espaces éventuels
            c =te.caractereCourant();
            if (c==' ') c =te.caractereNonEspaceSuivant();
            // 2. Si le 1er caractère non espace n'est pas une parenthèse ouvrante, 
            // la Comparaison est mal formée.
            if (c != '(') throw new ExpressionMalFormeeException();
            // 3. Sinon, sauter les espaces éventuels.
            c =te.caractereNonEspaceSuivant();
            // 4. Si, après la parenthèse ouvrante, le 1er caractère non espace est autre que '<',
            // '=' ou '>', la Comparaison est mal formée.
            if (c != '<' && c != '>' && c != '=') {
               te.setIndex(indexDepart);
               throw new ExpressionMalFormeeException();
            }
            // 5. Sinon, vérifier que l'opérateur est suivi d'un espace avant de
            // tenter de construire les opérandes puis l'expression Comparaison à renvoyer.
            else { 
                if (te.caractereSuivant()!=' ') 
                    throw new ExpressionMalFormeeException();
                char comparateur = c;
                te.caractereNonEspaceSuivant();
                ExpressionEntiere gauche = FactoryExpressions.getInstance().construireExpressionEntiere(te);
                te.caractereNonEspaceSuivant();
                ExpressionEntiere droite = FactoryExpressions.getInstance().construireExpressionEntiere(te);
            // 6. Si l'opérande droit n'est pas suivi d'une parenthèse fermante, la Comparaison est 
            // mal formée. Sinon, contruire et renvoyer la Négation.   
                c =te.caractereNonEspaceSuivant();
                if (c == ')') {
                    Comparaison comp = new Comparaison();
                    comp.comparateur = comparateur;
                    comp.gauche = gauche;
                    comp.droite = droite;
                    return comp;
                    
                } else throw new ExpressionMalFormeeException();
            }
        }
        catch(FinTexteException e) {
            throw new ExpressionMalFormeeException();
        }
    }

    @Override
    public Boolean evaluer() throws OperateurException {
        int g = (int)gauche.evaluer();
        int d = (int)droite.evaluer();
        if(comparateur == '=') return g == d;
        else if(comparateur == '<') return g < d;
        else if(comparateur == '>') return g > d;
        else throw new OperateurException();
    }
    
}
