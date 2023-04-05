package es.ieslavereda.model;

import es.ieslavereda.TAD.ListaSE;
import es.ieslavereda.Tool;

import java.util.*;

/**
 * The type Rey.
 */
public class Rey extends Piece{

    private Set<Coordenada> coordenadas;
    private boolean moved;

    /**
     * Instantiates a new Rey.
     *
     * @param pieceType the piece type
     * @param celda     the celda
     */
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

    @Override
    public Set<Coordenada> getNextMoves(){
        coordenadas = new HashSet<>();
        Coordenada position = getCelda().getCoordenada();
        Coordenada c;

        //Up
        c = position.up();
        check(c);
        //UpLeft
        c = position.upLeft();
        check(c);
        //UpRight
        c = position.upRight();
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
        //DownLeft
        c = position.downLeft();
        check(c);
        //DownRight
        c = position.downRigth();
        check(c);


        //Enroque
        if(!moved) {
            checkEnroque(position);
        }

        return coordenadas;

    }

    private void check(Coordenada c){
        Tablero tablero = getCelda().getTablero();

        if(tablero.getCelda(c)!=null){
            if(tablero.getCelda(c).isEmpty())
                coordenadas.add(c);
            else if (tablero.getCelda(c).getPiece().getColor()!=getColor())
                coordenadas.add(c);
        }

    }

    private void checkEnroque(Coordenada c) {
        Tablero tablero = getCelda().getTablero();
        List<Coordenada> aux = new LinkedList<>();
        Coordenada coordAux = c.left();
        Coordenada nuevaPosicionRey;

        //Enroque izquierda
        while (!(coordAux.getCol()<'A' || coordAux.getCol()>'H')) {
            aux.add(coordAux);
            coordAux = coordAux.left();
        }

        if (!(tablero.getCelda(aux.get(aux.size() - 1)).isEmpty()) &&
                !(tablero.getCelda(aux.get(aux.size() - 1)).getPiece().hasMoved())) {
            nuevaPosicionRey = aux.get(1);
            enroqueAddCoordenadas(aux, tablero, nuevaPosicionRey);
        }


//----------------------------------------------------------------------------------------------------------------------

        //Enroque derecha
        coordAux = c.right();
        aux = new LinkedList<>();

        while (!(coordAux.getCol()<'A' || coordAux.getCol()>'H')) {
            aux.add(coordAux);
            coordAux = coordAux.right();
        }

        if (!(tablero.getCelda(aux.get(aux.size() - 1)).isEmpty()) &&
                !(tablero.getCelda(aux.get(aux.size() - 1)).getPiece().hasMoved())){
            nuevaPosicionRey = aux.get(1);
            enroqueAddCoordenadas(aux, tablero, nuevaPosicionRey);
        }
    }

    /**
     * Enroque add coordenadas.
     *
     * @param aux     the aux
     * @param tablero the tablero
     */
    public void enroqueAddCoordenadas(List<Coordenada> aux, Tablero tablero, Coordenada nuevaPosicionRey){
        boolean noPiecesInTheWay = true;
        int i = 0;

        while (i < aux.size() - 1 && noPiecesInTheWay) {
            if (!(tablero.getCelda(aux.get(i)).isEmpty()))
                noPiecesInTheWay = false;
            i++;
        }
        if(noPiecesInTheWay){
            coordenadas.add(nuevaPosicionRey);
        }
    }

}