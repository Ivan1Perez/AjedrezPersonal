package es.ieslavereda.model;

import es.ieslavereda.TAD.ListaSE;
import es.ieslavereda.Tool;

public class Rey extends Piece{

    private ListaSE coordenadas;
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
    public ListaSE getNextMoves(){
        coordenadas = new ListaSE();
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
                coordenadas.addTail(c);
            else if (tablero.getCelda(c).getPiece().getColor()!=getColor())
                coordenadas.addTail(c);
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

        while(tablero.getCelda(aux.get(i)).isEmpty() && i < aux.size()){
            i++;
        }
//        Coordenada[] checkEnroqueLargo = {
//                c.left(),
//                c.left().left(),
//                c.left().left().left(),
//                c.left().left().left().left()
//        };
//
//        if(!tablero.getCelda(checkEnroqueLargo[3]).isEmpty() && !tablero.getCelda(checkEnroqueLargo[3]).getPiece().hasMoved()) {
//            while (i < checkEnroqueLargo.length - 1 && tablero.getCelda(checkEnroqueLargo[i]).isEmpty()) {
//                i++;
//            }
//            //Si las 3 casillas del enroque largo están vacías se añadirá la coordenada.
//            if(i==3)
//                coordenadas = Tool.add(coordenadas, c.left().left());
//        }
//
//        i = 0;
//        //Enroque corto
//        Coordenada[] checkEnroqueCorto = {
//                c.right(),
//                c.right().right(),
//                c.right().right().right()
//        };
//
//        if(!tablero.getCelda(checkEnroqueCorto[2]).isEmpty() && !tablero.getCelda(checkEnroqueCorto[2]).getPiece().hasMoved()) {
//            while (i < checkEnroqueCorto.length - 1 && tablero.getCelda(checkEnroqueCorto[i]).isEmpty()) {
//                i++;
//            }
//            //Si las 3 casillas del enroque largo están vacías se añadirá la coordenada.
//            if(i==2)
//                coordenadas = Tool.add(coordenadas, c.right().right());
//        }
    }

}
