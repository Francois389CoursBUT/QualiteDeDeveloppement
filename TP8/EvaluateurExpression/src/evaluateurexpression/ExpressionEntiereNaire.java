import java.util.ArrayList;
import java.util.List;



public class ExpressionEntiereNaire implements Expression {
    
    private char operateur;

    
    private ArrayList<Expression> operandes = new ArrayList<Expression> ();

    /**
     * ExpressionEntiereNaire(): Lève ExpressionMalFormeeException si opérateur autre que + ou *, ou nombre d'opérandes < 2.
     * @param operateur
     * @param operandes
     * @throws ExpressionMalFormeeException
     */
    public ExpressionEntiereNaire(char operateur, ArrayList<Expression> operandes) throws ExpressionMalFormeeException {
        if (operandes.size() < 2) {
            throw new ExpressionMalFormeeException("Erreur : opérandes demandé, au moins 2, opérandes reçu, " + operandes.size());
        }
        if (operateur != '+' || operateur != '*') {
            throw new ExpressionMalFormeeException("Erreur : l'opérateur doit être '+' ou '*'");
        }
        this.operateur = operateur;
        for (Expression operande : operandes) {
            this.operandes.add(operande);
        }
    }

    /**
     * - evaluer() : Evalue les opérandes puis applique l'opérateur aux valeurs des opérandes et renvoie le résultat.
     * @return 
     * @throws OperateurException
     */    
    public int evaluer() throws OperateurException {
        int resultat = operateur == '+' ? 0 : 1;
        for (Expression operande : operandes) {
            switch(operateur){
            case '+':
                resultat += operande.evaluer();
                break;
            case '*':
                resultat *= operande.evaluer();
                break;
            }
        }
        return resultat;
    }

}
