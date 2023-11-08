package expression;

import exception.OperateurException;

public interface Expression {
    /**
     * Evalue l'expression et renvoie sa valeur.
     * Lève OperateurException si opérateur non autorisé.
     * @return 
     * @throws exception.OperateurException 
     */
    int evaluer() throws OperateurException;

}
