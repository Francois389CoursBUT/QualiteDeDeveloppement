package expression;

public class ConstanteEntiere implements Expression {
    
    private final int valeur;
    
    public ConstanteEntiere(int valeur) {
        this.valeur = valeur;
    }

    /**
     * Renvoie la valeur de l'attribut valeur.
     * @return 
     */
    @Override
    public int evaluer() {
        return valeur;
    }

}
