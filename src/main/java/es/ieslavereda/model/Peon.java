package es.ieslavereda.model;

import es.ieslavereda.TAD.ListaSE;
import es.ieslavereda.TAD.Node;
import es.ieslavereda.Tool;

import java.util.HashSet;
import java.util.Set;

public abstract class Peon extends Piece{

    private Set<Coordenada> coordenadas;
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
    public Set<Coordenada> getNextMoves() {
        coordenadas = new HashSet<>();
        Coordenada position = getCelda().getCoordenada();
        Coordenada c;
        boolean sameCol;

        if (getColor() != Color.BLACK) {
            sameCol = true;

            //Up
            c = position.up();
            check(c, sameCol);
            if(!moved) {
                c = position.up().up();
                check(c, sameCol);
            }

            sameCol = false;

            //Initial UpLeft
            c = position.upLeft();
            check(c, sameCol);

            //Initial UpRight
            c = position.upRight();
            check(c, sameCol);

        }else{
            sameCol = true;

            //Down
            c = position.down();
            check(c, sameCol);
            if(!moved) {
                c = position.down().down();
                check(c, sameCol);
            }

            sameCol = false;

            //Initial DownLeft
            c = position.downLeft();
            check(c, sameCol);

            //Initial DownRight
            c = position.downRigth();
            check(c, sameCol);
        }


        return coordenadas;
    }

    private void check(Coordenada c, boolean sameCol){
        Tablero tablero = getCelda().getTablero();

        if(tablero.getCelda(c)!=null){
            if(sameCol) {
                if (tablero.getCelda(c).isEmpty())
                    coordenadas.add(c);
            }else {
                if (!tablero.getCelda(c).isEmpty() && tablero.getCelda(c).getPiece().getColor() != getColor())
                    coordenadas.add(c);
            }
        }
    }
}
