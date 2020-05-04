package model;

public class Reine extends AbstractPiece{

    public Reine(Couleur couleur_de_piece, Coord coord) {
        super("Reine", couleur_de_piece, coord);
    }

    public boolean isMoveOk(int xFinal,
                            int yFinal) {
        return ((coord.x-xFinal)*(coord.y-yFinal)==0) || (xFinal-this.getX() == yFinal - this.getY()) || (xFinal-this.getX() == this.getY()-yFinal);
    }
    public static void main(String args[]) {
        Pieces maReine = new Reine(Couleur.NOIR, new Coord(0,0));
        System.out.println(maReine);
        System.out.println("Peut bouger en ligne : " + maReine.isMoveOk(1,0));
        System.out.println("Peut bouger en diagonale : " + maReine.isMoveOk(1,1));
        System.out.println("Couleur : " + maReine.getCouleur());
        System.out.println("X : " + maReine.getX());
        System.out.println("Y : " + maReine.getY());
        System.out.println("Coordonnées avant déplacement : " + "["+maReine.getX() + "," + maReine.getY()+"]");
        maReine.move(1,0);
        System.out.println("Coordonnées après déplacement : " + "["+maReine.getX() + "," + maReine.getY()+"]");
        maReine.move(2,2);
        System.out.println("Coordonnées après déplacement interdit : " + "["+maReine.getX() + "," + maReine.getY()+"]");
    }
}
