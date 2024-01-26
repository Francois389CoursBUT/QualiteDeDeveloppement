package expressions;

public class ConstanteEntiere implements Expression {

    private int valeur;
   
    public  int evaluer() {
        return valeur;
    }
    
    /**
     * Analyse et contruit une expression entière constante.
     * Après avoir sauté les espaces éventuels, on extrait la 1ère chaîne de caractères terminée par un
     * espace, une parenthèse ouvrante, une parenthèse fermante ou la fin du texte. Cette chaîne est ensuite
     * convertie en entier si possible. En cas d'erreur, l'index de te est remis à sa position qu'il avait avant
     * la tentative de cette construction, puis l'exception NumberFormatException est levée.
     * @param te : Texte de l'expression à construire.
     * @return : ConstanteEntiere entière construite.
     * @throws NumberFormatException : Si te ne décrit pas une constante entière correcte.
     */
    public ConstanteEntiere construireExpression(TexteExpression te) 
                throws ExpressionMalFormeeException {
        // A COMPLETER : quasi-identique à la méthode Evaluateur.construireConstanteEntiere()
        // du TP11
        return null; // BOUCHON à supprimer
    }
}
