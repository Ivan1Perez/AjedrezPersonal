package es.ieslavereda.model;

import es.ieslavereda.TAD.ListaSE;
import es.ieslavereda.Tool;

public abstract class Caballo extends Piece{

    private ListaSE coordenadas;

    public Caballo(PieceType pieceType, Celda celda){
        super(pieceType, celda);
    }

    @Override
    public ListaSE getNextMoves() {
        coordenadas = new ListaSE();
        Coordenada position = getCelda().getCoordenada();
        Coordenada c;

        //UpLeft
        c = position.up().up().left();
        check(c);
        //UpRight
        c = position.up().upRight();
        check(c);
        //LeftUp
        c = position.left().left().up();
        check(c);
        //RightUp
        c = position.right().right().up();
        check(c);
        //LeftDown
        c = position.left().left().down();
        check(c);
        //RightDown
        c = position.right().right().down();
        check(c);
        //DownLeft
        c = position.down().down().left();
        check(c);
        //DownRight
        c = position.down().down().right();
        check(c);

        return coordenadas;
    }

    private void check(Coordenada c){
        Tablero tablero = getCelda().getTablero();

        if(tablero.getCelda(c)!=null){
            if(tablero.getCelda(c).isEmpty())
                coordenadas.addTail(c);
            else if (tablero.getCelda(c).getPiece().getColor()!=getColor())
                coordenadas.addTail(c);
        }
    }

}
