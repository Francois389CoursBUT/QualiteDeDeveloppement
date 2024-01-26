package expressions;

/**
 * Classe permettant de parcourir un texte décrivant une expression.
 */
public class TexteExpression {
    private String texte; // Texte décrivant une expression
    private int index; // Tête de lecture
    
    /**
     * Construit une instance contenant un texte et positionne index au début du texte.
     * @param texte : Texte décrivant une expression.
     */
    public TexteExpression(String texte) {
        this.texte = texte;
        index = 0;
    }
    
    /**
     * Tente de déplacer de renvoyer le caractère correspondant à la position courante de l'index.
     * @return Caractère courant.
     * @throws FinTexteException si fin du texte atteinte.
     */
    public char caractereCourant() throws FinTexteException {          
        if(index<texte.length()) return texte.charAt(index);
        else throw new FinTexteException();
    }
    /**
     * Tente de déplacer l'index d'une position à droite et de renvoyer le caractère correspondant.
     * @return Caractère suivant.
     * @throws FinTexteException si fin du texte atteinte.
     */
    public char caractereSuivant() throws FinTexteException {          
        if(index<texte.length()-1) return texte.charAt(++index);
        else throw new FinTexteException();
    }
    /**
     * Incrémente l'index jusu'au 1er caractère non espace et renvoie ce caractère s'il en existe.
     * @return Caractère courant.
     * @throws FinTexteException si fin du texte atteinte.
     */
    public char caractereNonEspaceSuivant() throws FinTexteException {          
        char c = caractereSuivant();
        while (c ==' ') c = caractereSuivant();
        return c;
    }

    /**
     * Renvoie la valeur de l'index.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Modifie la valeur de l'index.
     */
    public void setIndex(int index) {
        this.index = index;
    }
}
