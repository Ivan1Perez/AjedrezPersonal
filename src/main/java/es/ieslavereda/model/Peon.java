package es.ieslavereda.model;

import es.ieslavereda.Tool;

public abstract class Peon extends Piece{

    private Coordenada[] coordenadas;
    private boolean moved;

    public Peon(PieceType pieceType, Celda celda){
        super (pieceType, celda);
        moved = false;
    }

    public boolean hasMoved() {
        return moved;
    }


    @Override
    public void moveTo(Coordenada c){
        super.moveTo(c);
        moved=true;

        if((getCelda().getCoordenada().getFila()==8) ||
        getCelda().getCoordenada().getFila()==1){
            transform();
        }
    }

    public abstract void transform();

    @Override
    public Coordenada[] getNextMoves() {
        coordenadas = new Coordenada[0];
        Coordenada position = getCelda().getCoordenada();
        Coordenada c;
        boolean up = false;

        //Up
        c = position.up();
        if(c==position.up())
        up = true;
        check(c);

        //Initial UpLeft
        c = position.upLeft();
        check(c);

        //Initial UpRight
        c = position.upRight();
        check(c);

        return coordenadas;
    }

    private void check(Coordenada c){
        Tablero tablero = getCelda().getTablero();

        if(tablero.getCelda(c)!=null){
            if(tablero.getCelda(c).isEmpty())
                coordenadas = Tool.add(coordenadas,c);
            else if (tablero.getCelda(c).getPiece().getColor()!=getColor())
                coordenadas = Tool.add(coordenadas, c);
        }
    }
}
