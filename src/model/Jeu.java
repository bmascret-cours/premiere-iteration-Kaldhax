package model;

import java.util.List;
import java.util.LinkedList;
import tools.ChessPiecesFactory;

public class Jeu {

    private Couleur couleur;
    List<Pieces> pieces;

    public Jeu(Couleur couleur) {
        this.couleur = couleur;
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

    /**
     * @return une vue de la liste des pièces en cours
     * ne donnant que des accès en lecture sur des PieceIHM
     * (type piece + couleur + liste de coordonnées)
     */
    public List<PieceIHM> getPiecesIHM(){
        PieceIHM newPieceIHM = null;
        List<PieceIHM> list = new LinkedList<PieceIHM>();
        for (Pieces piece : pieces){
            boolean existe = false;
            // si le type de piece existe déjà dans la liste de PieceIHM
            // ajout des coordonnées de la pièce dans la liste de Coord de ce type
            // si elle est toujours en jeu (x et y != -1)
            for ( PieceIHM pieceIHM : list){
                if ((pieceIHM.getTypePiece()).equals(piece.getClass().getSimpleName())){
                    existe = true;
                    if (piece.getX() != -1){
                        pieceIHM.add(new Coord(piece.getX(), piece.getY()));
                    }
                }
            }
            // sinon, création d'une nouvelle PieceIHM si la pièce est toujours en jeu
            if (! existe) {
                if (piece.getX() != -1){
                    newPieceIHM = new PieceIHM(piece.getClass().getSimpleName(),
                            piece.getCouleur());
                    newPieceIHM.add(new Coord(piece.getX(), piece.getY()));
                    list.add(newPieceIHM);
                }
            }
        }
        return list;
    }

    public String getPieceType(int x, int y){return findPiece(x,y).getClass().getSimpleName();}

    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal){
        return findPiece(xInit,yInit).isMoveOk(xFinal,yFinal);
    }

    public boolean isPawnPromotion(int xFinal, int yFinal){
        Pieces piece = findPiece(xFinal,yFinal);
        if (piece.getClass().getSimpleName()=="Pion" && yFinal==7 && piece.getCouleur()==Couleur.NOIR){
            return true;
        }
        else if (piece.getClass().getSimpleName()=="Pion" && yFinal==0 && piece.getCouleur()==Couleur.BLANC){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean	isPieceHere(int x, int y){
        return !(findPiece(x,y)==null);
    }

    public boolean	move(int xInit, int yInit, int xFinal, int yFinal){
        if (isPieceHere(xInit,yInit)){
            return findPiece(xInit,yInit).move(xFinal,yFinal);
        }
        else {
            return false;
        }
    }

    public boolean	pawnPromotion(int xFinal, int yFinal, java.lang.String type){
        if(isPawnPromotion(xFinal,yFinal)){
            /*
                TODO:
                Promote.
             */
            return true;
        }
        else{
            return false;
        }
    }

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
        System.out.println((jeu.getPiecesIHM()));
    }
}
