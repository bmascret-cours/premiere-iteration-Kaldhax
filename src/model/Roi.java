package model;

public class Roi extends AbstractPiece{
    public Roi(Couleur couleur_de_piece, Coord coord) {
        super("Roi",couleur_de_piece,coord);
    }

    public boolean isMoveOk(int xFinal,
                            int yFinal) {
        return ( Math.abs(xFinal-this.getX()) == 1 || Math.abs((yFinal-this.getY())) == 1 );
    }
    public static void main(String args[]) {
        Pieces monRoi = new Roi(Couleur.NOIR, new Coord(0,0));
        System.out.println(monRoi);
        System.out.println("Peut bouger en ligne : " + monRoi.isMoveOk(1,0));
        System.out.println("Peut bouger en diagonale : " + monRoi.isMoveOk(1,1));
        System.out.println("Couleur : " + monRoi.getCouleur());
        System.out.println("X : " + monRoi.getX());
        System.out.println("Y : " + monRoi.getY());
        System.out.println("Coordonnées avant déplacement : " + "["+monRoi.getX() + "," + monRoi.getY()+"]");
        monRoi.move(1,1);
        System.out.println("Coordonnées après déplacement (1,1) : " + "["+monRoi.getX() + "," + monRoi.getY()+"]");
        monRoi.move(0,0);
        System.out.println("Coordonnées après déplacement (-1,-1) : " + "["+monRoi.getX() + "," + monRoi.getY()+"]");
        monRoi.move(0,1);
        System.out.println("Coordonnées après déplacement (0,1) : " + "["+monRoi.getX() + "," + monRoi.getY()+"]");
        monRoi.move(1,1);
        System.out.println("Coordonnées après déplacement (1,0) : " + "["+monRoi.getX() + "," + monRoi.getY()+"]");
        monRoi.move(3,3);
        System.out.println("Coordonnées après déplacement (2,2) : " + "["+monRoi.getX() + "," + monRoi.getY()+"]");
        monRoi.move(3,1);
        System.out.println("Coordonnées après déplacement (0,-2) : " + "["+monRoi.getX() + "," + monRoi.getY()+"]");
    }
}
