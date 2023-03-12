package es.ieslavereda.model;

import es.ieslavereda.TAD.ListaSE;
import es.ieslavereda.Tool;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * The Alfil class represents a bishop chess piece.
 */
public abstract class Alfil extends Piece{

    /**
     * Instantiates a new Alfil.
     * @param pieceType the type of the piece
     * @param celda the cell where the piece is located
     */

    public Alfil(PieceType pieceType, Celda celda){
        super(pieceType, celda);
    }

    /**
     * Returns a set with all the possible moves of a bishop piece in the board.
     * @param p the bishop piece
     * @return the set of possible moves
     */
    public static Set<Coordenada> getNextMovesAsAlfil(Piece p){
        Set<Coordenada> coordenadas = new HashSet<>();
        Celda celda = p.getCelda();
        Tablero tablero = celda.getTablero();
        Color color = p.getColor();

        Coordenada original = celda.getCoordenada();
        Coordenada c;

        //UpLeft
        c = original.upLeft();
        while(tablero.getCelda(c)!=null && tablero.getCelda(c).isEmpty()) {
            coordenadas.add(c);
            c = c.upLeft();
        }
        if(tablero.getCelda(c)!=null && tablero.getCelda(c).getPiece().getColor()!=p.getColor())
            coordenadas.add(c);

        //UpRight
        c = original.upRight();
        while(tablero.getCelda(c)!=null && tablero.getCelda(c).isEmpty()) {
            coordenadas.add(c);
            c = c.upRight();
        }
        if(tablero.getCelda(c)!=null && tablero.getCelda(c).getPiece().getColor()!=p.getColor())
            coordenadas.add(c);

        //DownLeft
        c = original.downLeft();
        while(tablero.getCelda(c)!=null && tablero.getCelda(c).isEmpty()) {
            coordenadas.add(c);
            c = c.downLeft();
        }
        if(tablero.getCelda(c)!=null && tablero.getCelda(c).getPiece().getColor()!=p.getColor())
            coordenadas.add(c);

        //DownRight
        c = original.downRigth();
        while(tablero.getCelda(c)!=null && tablero.getCelda(c).isEmpty()) {
            coordenadas.add(c);
            c = c.downRigth();
        }
        if(tablero.getCelda(c)!=null && tablero.getCelda(c).getPiece().getColor()!=p.getColor())
            coordenadas.add(c);

        return coordenadas;
    }

    @Override
    public Set<Coordenada> getNextMoves(){
        return getNextMovesAsAlfil(this);
    }

}
