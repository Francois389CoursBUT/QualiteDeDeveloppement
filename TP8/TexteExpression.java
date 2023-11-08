
/**
   * TexteExpression est une classe auxiliaire pour parcourir la chaîne de caratères décrivant
   * une expression à analyser et évaluer.
   */

public class TexteExpression {
    String texte; // Contient le texte décrivant une expression à évaluer
    int index = 0; // Tête de lecture.
    TexteExpression(String texteExpression) {
      this.texte = texteExpression; 
    }
    /** Renvoie le caractère à la position courante de l'index.
      * Lève FinTexteException si fin du texte atteinte.
      */   
    char caractereCourant() throws FinTexteException {
        if(index<texte.length()) return texte.charAt(index);
        else throw new FinTexteException();
    }
    /**
     * Incrémente index de 1 et renvoie le caractère se trouvant à cette position de l'index.
     * Lève FinTexteException si fin du texte atteinte.
    */   
    char caractereSuivant() throws FinTexteException {
        if(index<texte.length()-1) return texte.charAt(++index);
        else throw new FinTexteException();
    }
    /**
     * Incrémente l'index jusu'au 1er caractère non espace et renvoie ce caractère.
     * Lève FinTexteException si fin du texte atteinte.
     */   
    char caractereNonEspaceSuivant() throws FinTexteException {
        char c = caractereSuivant();
        while (c ==' ') c = caractereSuivant();
        return c;
    }
}
