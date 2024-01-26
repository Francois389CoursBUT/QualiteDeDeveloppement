package expressions;


public interface Expression {
    
    /**
     * Analyse et contruit une expression.
     * @param te : Texte de l'expression à construire.
     * @return : Expression construite.
     * @throws ExpressionMalFormeeException : Si te ne décrit pas une expression correcte.
     */
    public Expression construireExpression(TexteExpression te)
            throws ExpressionMalFormeeException ;
    
    /**
     * Evalue et renvoie la valeur d'un expression correctement construite.
     * @return Valeur de l'expression
     * @throws OperateurException si opérateur non autorisé.
     */
    public int evaluer() throws OperateurException ;
}
