package model;

public class Pion extends AbstractPiece implements Pions {

    boolean hasMoved;

    public Pion(Couleur couleur_de_piece, Coord coord) {
        super("Pion", couleur_de_piece, coord);
        this.hasMoved = false;
    }

    public boolean isMoveOk(int xFinal,
                            int yFinal) {
        if ((this.getX()-xFinal)!=0) {
            return false;
        }
        else {
            int movingDirection;
            if (this.getCouleur()==Couleur.NOIR) {
                movingDirection = 1;
            }
            else {
                movingDirection = -1;
            }
            if (this.hasMoved) {
                return ( (this.getY()-yFinal) == -movingDirection);
            }
            else {
                return ( ( (this.getY()-yFinal) == -2*movingDirection) || (this.getY()-yFinal) == -movingDirection);
            }
        }
    }

    @Override
    public boolean move(int x, int y) {
        if(isMoveOk(x,y)) {
            this.coord.x = x;
            this.coord.y = y;
            this.hasMoved = true;
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String args[]) {
        Pieces monPion = new Pion(Couleur.NOIR, new Coord(0,0));
        System.out.println(monPion);
        System.out.println("Peut bouger horizontalement : " + monPion.isMoveOk(1,0));
        System.out.println("Peut bouger en diagonale : " + monPion.isMoveOk(1,1));
        System.out.println("Peut bouger verticalement : " + monPion.isMoveOk(0,1));
        System.out.println("Couleur : " + monPion.getCouleur());
        System.out.println("X : " + monPion.getX());
        System.out.println("Y : " + monPion.getY());
        System.out.println("Coordonnées avant déplacement latéral : " + "[" + monPion.getX() + "," + monPion.getY()+"]");
        monPion.move(1,0);
        System.out.println("Coordonnées avant déplacement vertical (de 2) : " + "[" + monPion.getX() + "," + monPion.getY()+"]");
        monPion.move(0,2);
        System.out.println("Coordonnées après déplacement vertical (de 2) : " + "[" + monPion.getX() + "," + monPion.getY()+"]");
        monPion.move(0,3);
        System.out.println("Coordonnées après déplacement vertical (de 1) : " + "["+monPion.getX() + "," + monPion.getY()+"]");
        monPion.move(0,5);
        System.out.println("Coordonnées après déplacement vertical (de 2) : " + "["+monPion.getX() + "," + monPion.getY()+"]");
    }
}