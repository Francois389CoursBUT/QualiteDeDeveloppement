


public class TexteExpression {
    /**
     * - texte : Contient le texte décrivant une expression à évaluer
     */
    
    private String texte;

    /**
     * - index : Tête de lecture.
     */
    
    private int index = 0;

    /**
     * Construit une instance contenant un texte représentant une Expression et positionne index au début du texte.
     * @param texteExpression
     */
    
    public TexteExpression(String texteExpression) {
        this.texte = texteExpression;
    }

    
    public int getIndex() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.index;
    }

    
    public void setIndex(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.index = value;
    }

    /**
     *  - caractereCourant : Renvoie le caractère à la position courante de l'index.
     * @return 
     * @throws FinTexteException
     */
    
    public char caractereCourant() throws FinTexteException {
        if (texte.length() <= index) throw new FinTexteException();
        return texte.charAt(index);
    }

    /**
     * caractereSuivant() : incrémente index de 1 et renvoie le caractère se trouvant à cette position de l'index.
     * @return 
     * @throws FinTexteException
     */
    
    public char caractereSuivant() throws FinTexteException {
        if (texte.length() - 1 <= index) throw new FinTexteException();
        index ++;
        return caractereCourant();
    }

    /**
     *  - caractereNonEspaceSuivant() : Incrémente  l'index jusu'au 1er caractère non espace et renvoie ce caractère.
     * @return 
     * @throws FinTexteException
     */
    
    public char caractereNonEspaceSuivant() throws FinTexteException {
        char charSuivant;
        do {            
            charSuivant = caractereSuivant();
        } while (charSuivant == ' ');
        return caractereCourant();
    }

}
