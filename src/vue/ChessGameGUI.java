package vue;

import controler.controlerLocal.ChessGameControler;
import model.Coord;
import model.PieceIHM;
import model.observable.ChessGame;
import tools.ChessImageProvider;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ChessGameGUI extends javax.swing.JFrame
                        implements java.awt.event.MouseListener,
                                    java.awt.event.MouseMotionListener,
                                    java.util.Observer {

    JLayeredPane layeredPane;
    JPanel chessBoard;
    JLabel chessPiece;
    int xAdjustment;
    int yAdjustment;
    ChessGameControler chessGameControler;

    public ChessGameGUI( java.lang.String name,
                  controler.controlerLocal.ChessGameControler chessGameControler,
                  java.awt.Dimension boardSize){

        this.chessGameControler = chessGameControler;

        //  Use a Layered Pane for this this application
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(boardSize);
        layeredPane.addMouseListener(this);
        layeredPane.addMouseMotionListener(this);

        //Add a chess board to the Layered Pane
        chessBoard = new JPanel();
        layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        chessBoard.setLayout( new GridLayout(8, 8) );
        chessBoard.setPreferredSize( boardSize );
        chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);

        for (int i = 0; i < 64; i++) {
            JPanel square = new JPanel( new BorderLayout() );
            chessBoard.add( square );

            int row = (i / 8) % 2;
            if (row == 0)
                square.setBackground( i % 2 == 0 ? Color.black : Color.white );
            else
                square.setBackground( i % 2 == 0 ? Color.white : Color.black );
        }
    }

    public void mouseClicked(java.awt.event.MouseEvent e){
    /*
        TODO
    */
    }

    public void mouseDragged(java.awt.event.MouseEvent e){
    /*
        TODO
    */
    /*
        Code found here: https://www.roseindia.net/java/example/java/swing/chess-application-swing.shtml
    */
        if (chessPiece == null) return;
        chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
    }

    public void mouseEntered(java.awt.event.MouseEvent e){
    /*
        TODO
    */
    }

    public void mouseExited(java.awt.event.MouseEvent e){
    /*
        TODO
    */
    }

    public void mouseMoved(java.awt.event.MouseEvent e){
    /*
        TODO
    */
    }

    public void mousePressed(java.awt.event.MouseEvent e){
    /*
        Code found here: https://www.roseindia.net/java/example/java/swing/chess-application-swing.shtml
    */
        if(chessGameControler.isPlayerOK(getPieceCoord(e.getX(),e.getY()))) {
            chessPiece = null;
            Component c = chessBoard.findComponentAt(e.getX(), e.getY());

            if (c instanceof JPanel)
                return;
            Point parentLocation = c.getParent().getLocation();
            xAdjustment = parentLocation.x - e.getX();
            yAdjustment = parentLocation.y - e.getY();
            chessPiece = (JLabel) c;
            chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
            chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
            layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
        }
    }

    public void mouseReleased(java.awt.event.MouseEvent e){
    /*
        TODO
    */
    /*
        Code found here: https://www.roseindia.net/java/example/java/swing/chess-application-swing.shtml
    */
        if(chessPiece == null) return;

        chessPiece.setVisible(false);
        Component c =  chessBoard.findComponentAt(e.getX(), e.getY());

        if (c instanceof JLabel){
            Container parent = c.getParent();
            parent.remove(0);
            parent.add( chessPiece );
        }
        else {
            Container parent = (Container)c;
            parent.add( chessPiece );
        }

        chessPiece.setVisible(true);
    }

    public void update(java.util.Observable arg0, java.lang.Object o){

        List<PieceIHM> piecesIHM = (List<PieceIHM>) o;

        for (PieceIHM piece : piecesIHM) {
            for (Coord coord : piece.getList()) {
                JLabel current = new JLabel( new ImageIcon(ChessImageProvider.getImageFile(piece.getTypePiece(), piece.getCouleur())));
                JPanel panel = (JPanel) chessBoard.getComponent(coord.x + coord.y * 8);
                panel.add(current);
            }
        }
    }

    private Coord getPieceCoord(int x, int y) {
        return new Coord(x/(700/8), y/(700/8));
    }

    public static void main(String[] args) {
        ChessGame chessGame = new ChessGame();
        ChessGameControler chessGameControler = new ChessGameControler(chessGame);
        Dimension dimension = new Dimension(900,900);
        JFrame frame = new ChessGameGUI("ChessGame",chessGameControler, dimension);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
        frame.pack();
        frame.setResizable(true);
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }

}
