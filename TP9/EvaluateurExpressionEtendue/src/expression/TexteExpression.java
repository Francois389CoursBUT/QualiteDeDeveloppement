package expression;


/**
   * TexteExpression est une classe auxiliaire pour parcourir la chaîne de caratères décrivant
   * une expression à analyser et évaluer.
   */

public class TexteExpression {
    private String texte; // Contient le texte décrivant une expression à évaluer
    private int index = 0; // Tête de lecture.
    public TexteExpression(String texteExpression) {
      this.texte = texteExpression; 
    }
    /** Renvoie le caractère à la position courante de l'index.
      * Lève FinTexteException si fin du texte atteinte.
      */   
    public char caractereCourant() throws FinTexteException {
        if(index<texte.length()) return texte.charAt(index);
        else throw new FinTexteException();
    }
    /**
     * Incrémente index de 1 et renvoie le caractère se trouvant à cette position de l'index.
     * Lève FinTexteException si fin du texte atteinte.
    */   
    public char caractereSuivant() throws FinTexteException {
        if(index<texte.length()-1) return texte.charAt(++index);
        else throw new FinTexteException();
    }
    /**
     * Incrémente  l'index jusu'au 1er caractère non espace et renvoie ce caractère.
     * Lève FinTexteException si fin du texte atteinte.
     */   
    public char caractereNonEspaceSuivant() throws FinTexteException {
        char c = caractereSuivant();
        while (c ==' ') c = caractereSuivant();
        return c;
    }

    public int getIndex() {
      return index;
    }

    public void setIndex(int index) {
      this.index = index;
    }
    
}
