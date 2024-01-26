package expressions;

public class ExpressionEntiereBinaire implements Expression {
 
    private char operateur;
    private Expression gauche, droite;
 
    /**
     * Si operateur = '-', calculer gauche-droite et envoyer le résultat.
     * Si operateur = '/', calculer division entière gauche/droite et envoyer le résultat. 
     * L'erreur division par 0 sera automatiquement levée si droite = 0.
     * Lève OperateurException si opérateur non autorisé.
     */
    public int evaluer() throws OperateurException {
        int g = gauche.evaluer();
        int d = droite.evaluer();
        if (operateur == '-') return g - d;
        else if (operateur == '/') return g / d;
        else throw new OperateurException();
    }
    
    /**
     * Analyse et contruit une expression entière binaire.
     * Après avoir sauté les espaces éventuels, on tente de lire une parenthèse ouvrante. En cas de succès, on
     * saute les espaces éventuels, puis on tente de lire le caractère '-' ou '/' qui reprsente un opérateur.
     * En cas de succès, on tente de construire les opérandes gauche et droite par appel à la méthode construireExpression().
     * En cas d'erreur, l'index de te est remis à sa position qu'il avait avant la tentative de cette construction, 
     * puis l'exception ExpressionMalFormeeException est levée.
     * @param te : Texte de l'expression à construire.
     * @return : Expression entière binaire construite.
     * @throws ExpressionMalFormeeException : Si te ne décrit pas une expression entière binaire conforme.
     */
    public ExpressionEntiereBinaire construireExpression(TexteExpression te) 
                throws ExpressionMalFormeeException {
        char c;
        int indexDepart = te.getIndex();
        try {
            // 1. Sauter les espaces événtuels
            c = te.caractereCourant();
            if (c==' ') c = te.caractereNonEspaceSuivant();
            // 2. Si le 1er caractère non espace n'est pas une parenthèse ouvrante, 
            // l'expression binaire est mal formée.
            if (c != '(') throw new ExpressionMalFormeeException();
            // 3. Sinon, sauter les espaces éventuels.
            c = te.caractereNonEspaceSuivant();
            // 4. Si, après la parenthèse ouvrante, le 1er caractère non espace est autre que '-' 
            // ou '/', l'expression binaire est mal formée.
            if (c != '-' && c != '/') {
                te.setIndex(indexDepart);
                throw new ExpressionMalFormeeException();
            }
            // 5. Sinon, vérifier que l'opérateur est suivi d'un espace avant de
            // tenter de construire les opérandes gauche et droite puis l'expression binaire à renvoyer.
            else { 
                char operateur = c;
                if (te.caractereSuivant()!=' ') throw new ExpressionMalFormeeException();
                Expression gauche = FactoryExpressions.getInstance()
                        .construireExpression(te); 
                te.caractereSuivant(); 
                Expression droite = FactoryExpressions.getInstance()
                        .construireExpression(te);
                // Vérifier que l'opérande droite est suivi de ')'
                if(te.caractereNonEspaceSuivant()!=')') throw new ExpressionMalFormeeException();
                ExpressionEntiereBinaire exp = new ExpressionEntiereBinaire();
                exp.operateur = operateur;
                exp.gauche = gauche; exp.droite = droite;
                return exp;
            }
        }
        catch(FinTexteException e) {
            throw new ExpressionMalFormeeException();
        }
    }
}
