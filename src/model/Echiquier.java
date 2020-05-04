package model;
import java.util.LinkedList;
import java.util.List;

public class Echiquier implements BoardGames {

    private Jeu currentPlayer;
    private String message;
    private Jeu white;
    private Jeu black;
    public Echiquier(){
        this.white = new Jeu(Couleur.BLANC);
        this.black = new Jeu(Couleur.NOIR);
        this.currentPlayer = this.white;
    }

    public Couleur getColorCurrentPlayer(){
        return this.currentPlayer.getCouleur();
    }

    public String getMessage() {
        return this.message;
    }

    private void setMessage(String message) { this.message=message; }

    public Couleur getPieceColor(int x, int y) {
        if(this.white.isPieceHere(x,y)){
            return Couleur.BLANC;
        }
        else if(this.black.isPieceHere(x,y)) {
            return Couleur.NOIR;
        }
        else {
            return null;
        }
    }

    public List<PieceIHM> getPiecesIHM() {
        List<PieceIHM> list = new LinkedList<PieceIHM>();
        list.addAll(this.white.getPiecesIHM());
        list.addAll(this.black.getPiecesIHM());
        return list;
    }

    public boolean isEnd() {
        return this.white.getKingCoord()==null || this.black.getKingCoord()==null;
    }

    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
        /*
            TODO:
            Careful with capture and pieces on the way
         */
        this.setMessage("Interdit");
        if(!currentPlayer.isPieceHere(xInit,yInit)){
            return false;
        }
        else if( (xInit==xFinal && yInit==yFinal) || xFinal > 7 || xFinal < 0 || yFinal > 7 || yFinal < 0){
            return false;
        }
        else if(!currentPlayer.isMoveOk(xInit, yInit, xFinal, yFinal)){
            return false;
        }
        else if(currentPlayer.isPieceHere(xFinal,yFinal)){
            return false;
        }
        /*else if(piece on the way and is not cavalier){
            return false;
        }*/
        else {
            this.setMessage("OK");
            return true;
        }
    }

    public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
        if(isMoveOk(xInit,yInit,xFinal,yFinal)){
            currentPlayer.move(xInit,yInit,xFinal,yFinal);
            return true;
        }
        else {
            return false;
        }
    }

    public void switchJoueur() {
        if(this.currentPlayer.getCouleur()==Couleur.BLANC){
            this.currentPlayer=black;
        }
        else{
            this.currentPlayer=white;
        }
    }

    public String toString(){
        String string = "Jeu blanc:\n";
        string += white;
        string += "\n\nJeu noir::\n";
        string += black;
        return string;
    }

    public static void main (String args[]){
        Echiquier echiquier = new Echiquier();
        System.out.println(echiquier);
        System.out.println(echiquier.getColorCurrentPlayer());
        echiquier.switchJoueur();
        System.out.println(echiquier.getColorCurrentPlayer());
        System.out.println(echiquier.getPieceColor(0,0));
        echiquier.switchJoueur();
        System.out.println(echiquier.getPieceColor(0,0));
        System.out.println(echiquier.move(0,1,0,3));
        System.out.println(echiquier.move(0,3,0,3));
        System.out.println(echiquier.getPieceColor(0,0));

    }

}
