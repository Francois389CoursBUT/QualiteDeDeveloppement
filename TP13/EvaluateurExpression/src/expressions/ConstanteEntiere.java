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
        String texteConstante = "";
        int indexDepart = te.getIndex();
        char c;
        try {
        // 1. Sauter les espaces éventuels
            c = te.caractereCourant();
            if (c==' ') c=te.caractereNonEspaceSuivant();
        // 2. Construire une chaîne de caractères terminée par un espace, 
        // une parenthèse ouvrante, une parenthèse fermante ou la fin du texte (cas d'une expression
        // réduite à une constante seule).
            while (c != ' ' && c != '(' && c != ')') {
                texteConstante += c;             
                c = te.caractereSuivant();
            }
            if (c == '(' | c == ')') {
                // Si l'on s'est arrêté sur une parenthèse, repositionner l'index sur cette
                // parenthèse pour la suite de l'analyse (construction d'une expression naire)
                te.setIndex(te.getIndex()-1);
            }
        }
        catch (FinTexteException e) {
        }
        // 3. Tenter de convertir la chaîne lue en entier et renvoyer une ConstanteEntiere ayant pour valeur cet entier.
        try {
            ConstanteEntiere cte =new ConstanteEntiere();
            cte.valeur = new Integer(texteConstante);
            return cte;
            
        }
        catch(NumberFormatException e)  {
            // Si la conversion en entier échoue, repositionner l'index à sa valeur de départ 
            // et relancer la même exception.
            te.setIndex(indexDepart);
            throw new ExpressionMalFormeeException();
        }
    }
}
