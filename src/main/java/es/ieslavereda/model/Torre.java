package es.ieslavereda.model;

import es.ieslavereda.TAD.ListaSE;
import es.ieslavereda.Tool;

import java.util.HashSet;
import java.util.Set;

public abstract class Torre extends Piece{


    private Set<Coordenada> coordenadas;
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

    public static Set<Coordenada> getNextMovesAsTorre(Piece p){
        Set<Coordenada> coordenadas = new HashSet<>();
        Celda celda = p.getCelda();
        Tablero tablero = celda.getTablero();
        Color color = p.getColor();

        Coordenada original = celda.getCoordenada();
        Coordenada c;

        //Up
        c = original.up();
        while(tablero.getCelda(c)!=null && tablero.getCelda(c).isEmpty()) {
            coordenadas.add(c);
            c = c.up();
        }
        if(tablero.getCelda(c)!=null && tablero.getCelda(c).getPiece().getColor()!=p.getColor())
            coordenadas.add(c);

        //Down
        c = original.down();
        while(tablero.getCelda(c)!=null && tablero.getCelda(c).isEmpty()) {
            coordenadas.add(c);
            c = c.down();
        }
        if(tablero.getCelda(c)!=null && tablero.getCelda(c).getPiece().getColor()!=p.getColor())
            coordenadas.add(c);

        //Left
        c = original.left();
        while(tablero.getCelda(c)!=null && tablero.getCelda(c).isEmpty()) {
            coordenadas.add(c);
            c = c.left();
        }
        if(tablero.getCelda(c)!=null && tablero.getCelda(c).getPiece().getColor()!=p.getColor())
            coordenadas.add(c);

        //Right
        c = original.right();
        while(tablero.getCelda(c)!=null && tablero.getCelda(c).isEmpty()) {
            coordenadas.add(c);
            c = c.right();
        }
        if(tablero.getCelda(c)!=null && tablero.getCelda(c).getPiece().getColor()!=p.getColor())
            coordenadas.add(c);

        return coordenadas;
    }

    @Override
    public Set<Coordenada> getNextMoves(){
        return getNextMovesAsTorre(this);
    }

}
