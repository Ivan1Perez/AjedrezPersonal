package es.ieslavereda.model;

import java.util.HashSet;
import java.util.Set;

/**
 * The type Peon.
 */
public abstract class Peon extends Piece{

    private Set<Coordenada> coordenadas;
    private boolean moved;

    /**
     * Instantiates a new Peon.
     *
     * @param pieceType the piece type
     * @param celda     the celda
     */
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

    /**
     * Transform.
     */
    public abstract void transform();

    @Override
    public Set<Coordenada> getNextMoves() {
        coordenadas = new HashSet<>();
        boolean whitesUp = getCelda().getTablero().isWhitesUp();

        if(!whitesUp){
            if (getColor() != Color.BLACK) {
                up();
            }else
                down();
        }else{
            if (getColor() != Color.BLACK) {
                down();
            }else
                up();
        }

        return coordenadas;
    }

    /**
     * Up.
     */
    public void up(){
        Coordenada position = getCelda().getCoordenada();
        Coordenada c;
        boolean sameColumn = true;

        c = position.up();
        check(c, sameColumn);
        if(!moved) {
            c = position.up().up();
            check(c, sameColumn);
        }

        sameColumn = false;

        //Initial UpLeft
        c = position.upLeft();
        check(c, sameColumn);

        //Initial UpRight
        c = position.upRight();
        check(c, sameColumn);
    }

    /**
     * Down.
     */
    public void down(){
        Coordenada position = getCelda().getCoordenada();
        Coordenada c;
        boolean sameColumn = true;

        //Down
        c = position.down();
        check(c, sameColumn);
        if(!moved) {
            c = position.down().down();
            check(c, sameColumn);
        }

        sameColumn = false;

        //Initial DownLeft
        c = position.downLeft();
        check(c, sameColumn);

        //Initial DownRight
        c = position.downRigth();
        check(c, sameColumn);
    }

    private void check(Coordenada c, boolean sameColumn){
        Tablero tablero = getCelda().getTablero();

        if(tablero.getCelda(c)!=null){
            if(sameColumn) {
                if (tablero.getCelda(c).isEmpty())
                    coordenadas.add(c);
            }else {
                if (!tablero.getCelda(c).isEmpty() && tablero.getCelda(c).getPiece().getColor() != getColor())
                    coordenadas.add(c);
            }
        }
    }
}
