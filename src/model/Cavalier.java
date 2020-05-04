package model;

import javax.swing.*;

public class Cavalier extends AbstractPiece {
    public Cavalier(Couleur couleur_de_piece, Coord coord) {
        super("Cavalier",couleur_de_piece,coord);
    }

    public boolean isMoveOk(int xFinal,
                            int yFinal) {
        return  (Math.abs(xFinal-this.getX()) == 1 && Math.abs(yFinal-this.getY()) == 2 ) || (Math.abs(xFinal-this.getX()) == 2 && Math.abs(yFinal-this.getY()) == 1);
    }

    public static void main(String args[]) {
        Pieces monCavalier = new Cavalier(Couleur.NOIR, new Coord(0,0));
        System.out.println(monCavalier);
        System.out.println("Peut bouger en ligne : " + monCavalier.isMoveOk(1,0));
        System.out.println("Peut bouger en diagonale : " + monCavalier.isMoveOk(1,1));
        System.out.println("Peut bouger en L : " + monCavalier.isMoveOk(2,1));
        System.out.println("Couleur : " + monCavalier.getCouleur());
        System.out.println("X : " + monCavalier.getX());
        System.out.println("Y : " + monCavalier.getY());
        System.out.println("Coordonnées avant déplacement : " + "["+monCavalier.getX() + "," + monCavalier.getY()+"]");
        monCavalier.move(1,1);
        System.out.println("Coordonnées après déplacement (1,1) : " + "["+monCavalier.getX() + "," + monCavalier.getY()+"]");
        monCavalier.move(0,0);
        System.out.println("Coordonnées après déplacement (-1,-1) : " + "["+monCavalier.getX() + "," + monCavalier.getY()+"]");
        monCavalier.move(1,2);
        System.out.println("Coordonnées après déplacement (1,2) : " + "["+monCavalier.getX() + "," + monCavalier.getY()+"]");
        monCavalier.move(2,0);
        System.out.println("Coordonnées après déplacement (1,-2) : " + "["+monCavalier.getX() + "," + monCavalier.getY()+"]");
        monCavalier.move(4,1);
        System.out.println("Coordonnées après déplacement (2,1) : " + "["+monCavalier.getX() + "," + monCavalier.getY()+"]");
        monCavalier.move(2,0);
        System.out.println("Coordonnées après déplacement (-2,-1) : " + "["+monCavalier.getX() + "," + monCavalier.getY()+"]");
    }
}
