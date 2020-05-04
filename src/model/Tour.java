package model;

public class Tour extends AbstractPiece{

    public Tour(Couleur couleur_de_piece, Coord coord) {
        super("Tour", couleur_de_piece, coord);
    }

    public boolean isMoveOk(int xFinal,
                            int yFinal) {
        boolean moveOk = ((coord.x-xFinal)*(coord.y-yFinal)==0);
        return moveOk;
    }
    public static void main(String args[]) {
        Pieces maTour = new Tour(Couleur.NOIR, new Coord(0,0));
        System.out.println(maTour);
        System.out.println("Peut bouger en ligne : " + maTour.isMoveOk(1,0));
        System.out.println("Peut bouger en diagonale : " + maTour.isMoveOk(1,1));
        System.out.println("Couleur : " + maTour.getCouleur());
        System.out.println("X : " + maTour.getX());
        System.out.println("Y : " + maTour.getY());
        System.out.println("Coordonnées avant déplacement : " + "["+maTour.getX() + "," + maTour.getY()+"]");
        maTour.move(1,0);
        System.out.println("Coordonnées après déplacement : " + "["+maTour.getX() + "," + maTour.getY()+"]");
        maTour.move(2,2);
        System.out.println("Coordonnées après déplacement interdit : " + "["+maTour.getX() + "," + maTour.getY()+"]");
    }
}
