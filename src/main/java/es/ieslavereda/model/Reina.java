package es.ieslavereda.model;

import es.ieslavereda.TAD.ListaSE;
import es.ieslavereda.Tool;

public abstract class Reina extends Piece{

    public Reina(PieceType pieceType, Celda celda){
        super(pieceType,celda);
    }

    @Override
    public ListaSE getNextMoves() {

        ListaSE coordTorre = Torre.getNextMovesAsTorre(this);
        ListaSE coordAlfil = Alfil.getNextMovesAsAlfil(this);


        return coordTorre.addAll(coordAlfil);
    }

}
