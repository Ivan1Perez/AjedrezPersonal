package es.ieslavereda.model;

import es.ieslavereda.TAD.ListaSE;
import es.ieslavereda.Tool;

public abstract class Alfil extends Piece{

    private ListaSE coordenadas;

    public Alfil(PieceType pieceType, Celda celda){
        super(pieceType, celda);
    }

    public static ListaSE getNextMovesAsAlfil(Piece p){
        ListaSE coordenadas = new ListaSE();
        Celda celda = p.getCelda();
        Tablero tablero = celda.getTablero();
        Color color = p.getColor();

        Coordenada original = celda.getCoordenada();
        Coordenada c;

        //UpLeft
        c = original.upLeft();
        while(tablero.getCelda(c)!=null && tablero.getCelda(c).isEmpty()) {
            coordenadas.addTail(c);
            c = c.upLeft();
        }
        if(tablero.getCelda(c)!=null && tablero.getCelda(c).getPiece().getColor()!=p.getColor())
            coordenadas.addTail(c);

        //UpRight
        c = original.upRight();
        while(tablero.getCelda(c)!=null && tablero.getCelda(c).isEmpty()) {
            coordenadas.addTail(c);
            c = c.upRight();
        }
        if(tablero.getCelda(c)!=null && tablero.getCelda(c).getPiece().getColor()!=p.getColor())
            coordenadas.addTail(c);

        //DownLeft
        c = original.downLeft();
        while(tablero.getCelda(c)!=null && tablero.getCelda(c).isEmpty()) {
            coordenadas.addTail(c);
            c = c.downLeft();
        }
        if(tablero.getCelda(c)!=null && tablero.getCelda(c).getPiece().getColor()!=p.getColor())
            coordenadas.addTail(c);

        //DownRight
        c = original.downRigth();
        while(tablero.getCelda(c)!=null && tablero.getCelda(c).isEmpty()) {
            coordenadas.addTail(c);
            c = c.downRigth();
        }
        if(tablero.getCelda(c)!=null && tablero.getCelda(c).getPiece().getColor()!=p.getColor())
            coordenadas.addTail(c);

        return coordenadas;
    }

    @Override
    public ListaSE getNextMoves(){
        return getNextMovesAsAlfil(this);
    }

}
