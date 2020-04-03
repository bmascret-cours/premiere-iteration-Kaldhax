package model;

import java.util.List;
import tools.ChessPiecesFactory;

public class Jeu {

    private Couleur couleur;
    List<Pieces> pieces;

    public Jeu(Couleur couleur) {
        this.pieces = ChessPiecesFactory.newPieces(couleur);
    }

    private Pieces findPiece(int x, int y){
        for(Pieces piece : this.pieces) {
            if (piece.getX()==x && piece.getY()==y){
                return piece;
            }
        }
        return null;
    }

    public boolean capture(int xCatch, int yCatch){return false;}

    public Couleur getCouleur(){
        return this.couleur;
    }

    public Coord getKingCoord(){
        for (Pieces piece : this.pieces) {
            if(piece.getClass().getSimpleName().equals("Roi")){
                Coord coord = new Coord(piece.getX(),piece.getY());
                return coord;
            }
        }
        return null;
    }

    public Couleur getPieceColor(int x, int y){
        return findPiece(x,y).getCouleur();
    }

    public List<PieceIHM> getPieceIHM() {return null;}

    public String getPieceType(int x, int y){return "Change that!";}

    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal){
        return findPiece(xInit,yInit).isMoveOk(xFinal,yFinal);
    }

    public boolean isPawnPromotion(int xFinal, int yFinal){return false;}

    public boolean	isPieceHere(int x, int y){
        return (findPiece(x,y)==null);
    }

    public boolean	move(int xInit, int yInit, int xFinal, int yFinal){

    }

    public boolean	pawnPromotion(int xFinal, int yfinal, java.lang.String type){return false;}

    public void	setCastling(){}

    public  void setPossibleCapture(){}

    @Override
    public String toString(){
        String string = "";
        for(Pieces piece : this.pieces){
            string += piece;
            string += "\n";
        }
        return string;
    }

    public void undoCapture(){}

    public void undoMove(){}

    public static void main (String args[]){
        Jeu jeu = new Jeu(Couleur.BLANC);
        System.out.println(jeu);
    }
}
