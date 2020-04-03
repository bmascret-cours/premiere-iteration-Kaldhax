package model;
import java.util.List;

public class Echiquier implements BoardGames {

    public Echiquier(){

    }

    public Couleur getColorCurrentPlayer(){
        /*
            TODO:
            Change that !
         */
        return Couleur.BLANC;
    }

    public String getMessage() {
        return "Change that!";
    }

    public Couleur getPieceColor(int x, int y) {
        /*
            TODO:
            Change that!
         */
        return Couleur.BLANC;
    }

    public List<PieceIHM> getPiecesIHM() {
        /*
            TODO:
            Change that !
         */
        return null;
    }

    public boolean isEnd() {
        return false;
    }

    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
        return false;
    }

    public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
        return false;
    }

    public void switchJoueur() {
        ;
    }

    public String toString(){
        return "Change that!";
    }


}
