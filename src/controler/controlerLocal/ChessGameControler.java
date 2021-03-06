package controler.controlerLocal;

import model.Coord;
import model.observable.ChessGame;
import controler.AbstractChessGameControler;

/**
 * @author francoise.perrin
 *
 *         Ce controleur local précise comment empêcher un joueur à qui ce n'est pas le tour 
 *         de jouer, de déplacer une image de pièce sur le damier
 *
 */
public class ChessGameControler extends AbstractChessGameControler {

	public ChessGameControler(ChessGame chessGame) {
		super(chessGame);
	}

	/* (non-Javadoc)
	 * @see controler.AbstractChessGameControler#isPlayerOK(model.Coord)
	 *
	 * cette méthode vérifie que la couleur de la pièce que l'utilisateur
	 * tente de déplacer est bien celle du jeu courant
	 * la vue se servira de cette information pour empêcher tout déplacement sur le damier
	 */
	@Override
	public boolean isPlayerOK(Coord initCoord) {

		System.out.println("Coordonnées pièces: " + initCoord);
		System.out.println("Color piece : " + chessGame.getPieceColor(initCoord.x, initCoord.y));
		System.out.println("Current player: " + chessGame.getColorCurrentPlayer());
		if(chessGame.getColorCurrentPlayer() == chessGame.getPieceColor(initCoord.x, initCoord.y)){
			System.out.println("Hello World!");
			return true;
		}
		else {
			System.out.println("nop");
			return false;
		}
	}

	private Coord getPieceCoord(int x, int y) {
		return new Coord(x/(700/8), y/(700/8));
	}

	/* (non-Javadoc)
	 * @see controler.AbstractChessGameControler#endMove(model.Coord, model.Coord, java.lang.String)
	 *
	 * Pas d'action supplémentaire dans un contrôleur local en fin de move
	 */
	@Override
	protected void endMove(Coord initCoord, Coord finalCoord,
						   String promotionType) {

	}


}