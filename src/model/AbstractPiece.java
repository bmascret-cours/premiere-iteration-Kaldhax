package model;

public abstract class AbstractPiece implements Pieces {

    private String name;
    private Couleur couleur;
    protected Coord coord;

    public AbstractPiece(String name, Couleur couleur, Coord coord) {
        this.name = name;
        this.couleur = couleur;
        this.coord = coord;
    }


    public boolean capture() {
        this.coord.x = -1;
        this.coord.y = -1;
        return true;
    }

    public Couleur getCouleur() {
        return(this.couleur);
    }

    public int getX() {
        return(this.coord.x);
    }

    public int getY() {
        return(this.coord.y);
    }

    public abstract boolean isMoveOk(int xFinal, int yFinal);

    public boolean move(int x, int y) {
        if(((this.getX()!=x) || this.getY()!=y) && isMoveOk(x,y)) {
            this.coord.x = x;
            this.coord.y = y;
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return  this.name +
                " " + this.couleur +
                "{Coord=" + this.coord +
                '}';
    }
}
