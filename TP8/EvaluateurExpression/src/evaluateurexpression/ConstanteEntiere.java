package evaluateurexpression;


public class ConstanteEntiere implements Expression {
    
    private int valeur;

    
    public ConstanteEntiere(int valeur) {
        this.valeur = valeur;
    }

    /**
     * - evaluer() : Renvoie valeur.
     * @return 
     */
    public int evaluer() {
        return valeur;
    }

}
