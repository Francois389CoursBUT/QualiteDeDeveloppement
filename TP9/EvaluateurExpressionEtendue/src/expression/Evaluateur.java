package expression;

import exception.ExpressionMalFormeeException;
import java.util.ArrayList;
import java.util.Scanner;

public class Evaluateur {
    
    private static TexteExpression texteExpression;
    private static final String EURREUR_EXEMPLE = "Expression mal formé, voici un exemple valide : ( * 2  2)";

    /**
     * Mémorise dans texteExpression le texte décrivant une expression passé en paramètre puis
     * appelle construireExpression() pour analyser ce texte et construire une réprésentation
     * interne (arborescente) de l'expression.
     * Si aucune erreur de syntaxe n'est détectée, elle évalue ensuite l'expression en se basant
     * sur sa représentation interne (évaluation des noeuds de l'arborescence puis application des
     * opérateurs) et renvoie le résultat. Lève ExpressionMalFormeeException sinon.
     * @param expression : texte de l'expression
     * @throws ExpressionMalFormeeException si erreur de syntaxe
     * @return Valeur de l'expression si correcte
     */
    
    public static int evaluer(String expression) 
            throws ExpressionMalFormeeException {
        
        // 1. Mémoriser dans l'attribut texteExpression le texte contenu dans le paramètre expression 
        texteExpression = new TexteExpression(expression);

        // 2. Analyser le texte et tenter de construire une représentation interne (arborescente)
        // de l'expression
        Expression exp = construireExpression();
      
        // 3. S'assurer que c'est la fin du texte avant d'évaluer l'expression construite
        try { 
            texteExpression.caractereNonEspaceSuivant();
            throw new ExpressionMalFormeeException(); // Cas non fin du texte
        }
        catch(FinTexteException e) {
            return exp.evaluer();
        }
    }

    /**
     * Analyser le texte mémorisé dans l'attribut texteExpression à partir de la position
     * courante de son index afin de construire soit une ConstanteEntiere, soit une
     * ExpressionNaire, en appelant construireConstanteEntiere() et constrruireExpEntiereNaire().
     * Lever ExpressionMalFormeeException si erreur de syntaxe.
     */
    
    private static Expression construireExpression() throws ExpressionMalFormeeException {
        // Tenter de construire une constante.
        // En cas d'échec, tenter de construire une expression naire.
        try {      
            return construireConstanteEntiere();
        }
        catch (NumberFormatException e) {
            try {
            return construireExpEntiereNaire();
            } catch (ExpressionMalFormeeException e1) {
                return construireExpEntiereBiaire();
            }
        }
    }

    /**
     * Analyser le texte mémorisé dans l'attribut texteExpression à partir de la position courante
     * de son index afin de construire une ConstanteEntiere avec la valeur entière correspondante.
     * Lever NumberFormatException si erreur de syntaxe.
     */
    
    private static ConstanteEntiere construireConstanteEntiere() throws NumberFormatException {
        
        String texteConstante = "";
        char c; // Variable de parcours du texte à analyser (mémorisé dans texteExpression).
        // indexDepart : sert à revenir au début du texte si la construction éhoue.
        int indexDepart = texteExpression.getIndex();
        
        try {
        
        // 1. Sauter les espaces éventuels
            c = texteExpression.caractereCourant();
            if (c==' ') c=texteExpression.caractereNonEspaceSuivant();
            indexDepart = texteExpression.getIndex();
            
        // 2. Construire une chaîne de caractères terminée par un espace, une parenthèse
        // ouvrante, une parenthèse fermante ou la fin du texte (cas d'une expression
        // réduite à une constante seule).
            while (c != ' ' && c != '(' && c != ')') {
                texteConstante += c;             
                c = texteExpression.caractereSuivant();
            }
            if (c == '(' | c == ')') {
                // Si l'on s'est arrêté sur une parenthèse, repositionner l'index sur cette
                // parenthèse pour la suite de l'analyse (construction d'une expression naire)
                texteExpression.
                        setIndex(texteExpression.getIndex()-1);
            }
        }
        catch (FinTexteException e) {
        }
        
        // 3. Tenter de convertir la chaîne lue en entier et renvoyer une ConstanteEntiere ayant
        // pour valeur cet entier.
        try {
            return new ConstanteEntiere(new Integer(texteConstante));
        }
        catch(NumberFormatException e)  {
            // Si la conversion en entier échoue, repositionner l'index à sa valeur de départ 
            // et relancer la même exception.
            texteExpression.setIndex(indexDepart);
            throw e;
        }
    }

    /**
     * Analyser le texte mémorisé dans l'attribut texteExpression à partir de la position courante
     * de son index afin de construire une ExpressionEntiereNaire, en appelant construireExpression()
     * pour construire les opérandes. Lever ExpressionMalFormeeException si erreur de syntaxe.
     */
    
    private static ExpressionEntiereNaire construireExpEntiereNaire() throws ExpressionMalFormeeException {
        
        char c; // Variable de parcours du texte à analyser (mémorisé dans texteExpression).
        // indexDepart : sert à revenir au début du texte si la construction éhoue.
        int indexDepart = texteExpression.getIndex();
        
        try {
            
            // 1. Sauter les espaces événtuels
            c = texteExpression.caractereCourant();
            if (c==' ') c = texteExpression.caractereNonEspaceSuivant();
            
            // 2. Si le 1er caractère non espace n'est pas une parenthèse ouvrante, l'expression
            // est mal formée.
            if (c != '(') throw new ExpressionMalFormeeException();
            
            // 3. Sinon, sauter les espaces éventuels après la parenthèse ouvrante.
            c = texteExpression.caractereNonEspaceSuivant();
            
            // 4. Si, après la parenthèse ouvrante, le 1er caractère non espace est autre que '+' 
            // ou '*', l'expression n-aire est mal formée.
            if (c != '+' && c != '*') {
                texteExpression.setIndex(indexDepart);
                throw new ExpressionMalFormeeException();
            }
            
            // 5. Sinon, vérifier que l'opérateur est suivi d'un espace avant de
            // tenter de construire les opérandes puis l'expression n-aire à renvoyer.
            else { 
                char operateur = c;
                if (texteExpression.caractereSuivant()!=' ') 
                    throw new ExpressionMalFormeeException();
                // Construire les opérandes. Le dernier opérande devant être suivi de ')', on
                // boucle sur la construction d'un opérande tant que le caractère courant est 
                // différent de ')'.
                ArrayList<Expression> operandes = new ArrayList();
                while(c != ')') {
                    Expression operande = construireExpression(); 
                    operandes.add(operande);
                    c = texteExpression.caractereNonEspaceSuivant();
                }            
                return new ExpressionEntiereNaire(operateur, operandes);
            }
        }
        catch(FinTexteException e) { 
            // 6. Si la fin du texte est atteinte avant d'avoir terminé la construction de l'expression
            // n-aire c'est qu'elle est syntaxiquement incorrecte.
            throw new ExpressionMalFormeeException();
        }
    }
    
    
    private static ExpressionEntiereBinaire construireExpEntiereBiaire() throws ExpressionMalFormeeException {
        
        char c; // Variable de parcours du texte à analyser (mémorisé dans texteExpression).
        // indexDepart : sert à revenir au début du texte si la construction éhoue.
        int indexDepart = texteExpression.getIndex();
        
        try {
            
            // 1. Sauter les espaces événtuels
            c = texteExpression.caractereCourant();
            if (c==' ') c = texteExpression.caractereNonEspaceSuivant();
            
            // 2. Si le 1er caractère non espace n'est pas une parenthèse ouvrante, l'expression
            // est mal formée.
            if (c != '(') throw new ExpressionMalFormeeException();
            
            // 3. Sinon, sauter les espaces éventuels après la parenthèse ouvrante.
            c = texteExpression.caractereNonEspaceSuivant();
            
            // 4. Si, après la parenthèse ouvrante, le 1er caractère non espace est autre que '+' 
            // ou '*', l'expression n-aire est mal formée.
            if (c != '-' && c != '/') {
                texteExpression.setIndex(indexDepart);
                throw new ExpressionMalFormeeException();
            }
            
            // 5. Sinon, vérifier que l'opérateur est suivi d'un espace avant de
            // tenter de construire les opérandes puis l'expression n-aire à renvoyer.
            else { 
                char operateur = c;
                if (texteExpression.caractereSuivant() != ' ') 
                    throw new ExpressionMalFormeeException();
                // Construire les opérandes. Le dernier opérande devant être suivi de ')', on
                // boucle sur la construction d'un opérande tant que le caractère courant est 
                // différent de ')'.
                ArrayList<Expression> operandes = new ArrayList();
                while(c != ')') {
                    Expression operande = construireExpression(); 
                    operandes.add(operande);
                    c = texteExpression.caractereNonEspaceSuivant();
                }            
                return new ExpressionEntiereBinaire(operateur, operandes);
            }
        }
        catch(FinTexteException e) { 
            // 6. Si la fin du texte est atteinte avant d'avoir terminé la construction de l'expression
            // n-aire c'est qu'elle est syntaxiquement incorrecte.
            throw new ExpressionMalFormeeException();
        }
    }
    
    /**
     * Boucle sans fin (arrêtée de l'extérieur) permettant de :
     * - lire le texte d'une expression au clavier
     * - utiliser l'Evaluateur pour l'analyser et l'évaluer
     * - afficher le résultat ou un message d'erreur si l'expression est mal formée.
     */
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        while (true) {
            System.out.print("Saisir une expression : ");
            try {        
                System.out.println("Valeur = " + evaluer(clavier.nextLine()));
            }
            catch(ExpressionMalFormeeException e) {
                  System.out.println("Erreur : expression incorrecte. " + EURREUR_EXEMPLE);
            }
        }
    }
}
