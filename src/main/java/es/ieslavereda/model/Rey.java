package es.ieslavereda.model;

import es.ieslavereda.TAD.ListaSE;
import es.ieslavereda.Tool;

import java.util.HashSet;
import java.util.Set;

public class Rey extends Piece{

    private Set<Coordenada> coordenadas;
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


        /*Nota: El enroque consiste en mover el rey dos casillas hacia la torre en la primera
         fila del jugador, y luego mover la torre al escaque sobre que el rey ha cruzado.
         */
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

    private void checkEnroque(Coordenada c){
        Tablero tablero = getCelda().getTablero();
        int i = 0;

        //Enroque largo
        ListaSE aux = new ListaSE();
        aux.addTail(c.left());
        aux.addTail(c.left().left());
        aux.addTail(c.left().left().left());
        aux.addTail(c.left().left().left().left());

        while(tablero.getCelda(aux.get(i)).isEmpty() && i < aux.size()-1){
            i++;
        }

        //Si 'i' llega a la posición de la Lista anterior a donde está ubicada la Torre (3) avanzaremos al siguiente paso
        if(i==3){
            if(!tablero.getCelda(aux.get(aux.size()-1)).isEmpty() && !tablero.getCelda(aux.get(aux.size()-1)).getPiece().hasMoved()){
                coordenadas.add(c.left().left());
            }
        }

//----------------------------------------------------------------------------------------------------------------------

        //Enroque corto
        i = 0;

        aux = new ListaSE();

        aux.addTail(c.right());
        aux.addTail(c.right().right());
        aux.addTail(c.right().right().right());

        while(tablero.getCelda(aux.get(i)).isEmpty() && i < aux.size()-1){
            i++;
        }

        if(i==2){
            if(!tablero.getCelda(aux.get(aux.size()-1)).isEmpty() && !tablero.getCelda(aux.get(aux.size()-1)).getPiece().hasMoved()){
                coordenadas.add(c.right().right());
            }
        }
    }

}
