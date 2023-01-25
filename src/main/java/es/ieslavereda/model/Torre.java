package es.ieslavereda.model;

import es.ieslavereda.TAD.ListaSE;
import es.ieslavereda.Tool;

public abstract class Torre extends Piece{

    private Coordenada[] coordenadas;

    private ListaSE lista;
    private boolean moved;

    public Torre(PieceType pieceType, Celda celda){
        super (pieceType, celda);
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

    public static Coordenada[] getNextMovesAsTorre(Piece p){
        Coordenada[] coordenadas = new Coordenada[0];
        Celda celda = p.getCelda();
        Tablero tablero = celda.getTablero();
        Color color = p.getColor();

        Coordenada original = celda.getCoordenada();
        Coordenada c;

        //Up
        c = original.up();
        while(tablero.getCelda(c)!=null && tablero.getCelda(c).isEmpty()) {
            coordenadas = Tool.add(coordenadas, c);
            c = c.up();
        }
        if(tablero.getCelda(c)!=null && tablero.getCelda(c).getPiece().getColor()!=p.getColor())
            coordenadas = Tool.add(coordenadas, c);

        //Down
        c = original.down();
        while(tablero.getCelda(c)!=null && tablero.getCelda(c).isEmpty()) {
            coordenadas = Tool.add(coordenadas, c);
            c = c.down();
        }
        if(tablero.getCelda(c)!=null && tablero.getCelda(c).getPiece().getColor()!=p.getColor())
            coordenadas = Tool.add(coordenadas, c);

        //Left
        c = original.left();
        while(tablero.getCelda(c)!=null && tablero.getCelda(c).isEmpty()) {
            coordenadas = Tool.add(coordenadas, c);
            c = c.left();
        }
        if(tablero.getCelda(c)!=null && tablero.getCelda(c).getPiece().getColor()!=p.getColor())
            coordenadas = Tool.add(coordenadas, c);

        //Right
        c = original.right();
        while(tablero.getCelda(c)!=null && tablero.getCelda(c).isEmpty()) {
            coordenadas = Tool.add(coordenadas, c);
            c = c.right();
        }
        if(tablero.getCelda(c)!=null && tablero.getCelda(c).getPiece().getColor()!=p.getColor())
            coordenadas = Tool.add(coordenadas, c);

        return coordenadas;
    }

    @Override
    public Coordenada[] getNextMoves(){
        return getNextMovesAsTorre(this);
    }

}
