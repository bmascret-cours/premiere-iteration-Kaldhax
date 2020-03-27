package model;

public abstract class AbstractPiece implements Pieces {

    private name;
    private couleur;
    private coord;

    public AbstractPiece(Couleur couleur, Coord coord) {
        self.couleur = couleur;
        self.coord = coord;
    }


    public boolean capture() {
        self.x = -1;
        self.y = -1;
    }

    public boolean Couleur getCouleur() {
        return(self.couleur);
    }

    public boolean int getX() {
        return(self.coord.x);
    }

    public boolean int getY() {
        return(self.coord.y);
    }

    public abstract boolean isMoveOk(int xFinal, int yFinal);

    public boolean move(int x, int y) {
        if(isMoveOk(x,y)) {
            self.coord.x = x;
            self.coord.y = y;
            return true;
        }
        else {
            return false;
        }
    }




}
