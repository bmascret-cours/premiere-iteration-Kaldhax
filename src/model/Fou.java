package model;

public class Fou extends AbstractPiece {
    public Fou(Couleur couleur_de_piece, Coord coord) {
        super("Fou",couleur_de_piece,coord);
    }

    public boolean isMoveOk(int xFinal,
                            int yFinal) {
        return ( (xFinal-this.getX() == yFinal - this.getY()) || (xFinal-this.getX() == this.getY()-yFinal) );
    }
    public static void main(String args[]) {
        Pieces monFou = new Fou(Couleur.NOIR, new Coord(0,0));
        System.out.println(monFou);
        System.out.println("Peut bouger en ligne : " + monFou.isMoveOk(1,0));
        System.out.println("Peut bouger en diagonale : " + monFou.isMoveOk(1,1));
        System.out.println("Couleur : " + monFou.getCouleur());
        System.out.println("X : " + monFou.getX());
        System.out.println("Y : " + monFou.getY());
        System.out.println("Coordonnées avant déplacement : " + "["+monFou.getX() + "," + monFou.getY()+"]");
        monFou.move(1,1);
        System.out.println("Coordonnées après déplacement (1,1) : " + "["+monFou.getX() + "," + monFou.getY()+"]");
        monFou.move(0,0);
        System.out.println("Coordonnées après déplacement (-1,-1) : " + "["+monFou.getX() + "," + monFou.getY()+"]");
        monFou.move(3,3);
        System.out.println("Coordonnées après déplacement (3,3) : " + "["+monFou.getX() + "," + monFou.getY()+"]");
        monFou.move(6,0);
        System.out.println("Coordonnées après déplacement (3,-3) : " + "["+monFou.getX() + "," + monFou.getY()+"]");
    }
}
