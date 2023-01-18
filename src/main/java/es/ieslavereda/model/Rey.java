package es.ieslavereda.model;

import es.ieslavereda.Tool;

public class Rey extends Piece{

    private Coordenada[] coordenadas;
    private boolean moved;

    public Rey(PieceType pieceType, Celda celda){
        super(pieceType, celda);
        moved = false;
    }

    public boolean hasMoved() {
        return moved;
    }

    @Override
    public void moveTo(Coordenada c) {
        super.moveTo(c);
        moved=true;
    }

    public Coordenada[] getNextMoves(){
        coordenadas = new Coordenada[0];
        Coordenada position = getCelda().getCoordenada();
        Coordenada c;

        //Up
        c = position.up();
        check(c);
        //Right
        c = position.right();
        check(c);
        //Left
        c = position.left();
        check(c);
        //Down
        c = position.down();
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
