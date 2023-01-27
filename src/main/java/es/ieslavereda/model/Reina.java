package es.ieslavereda.model;

import es.ieslavereda.TAD.ListaSE;
import es.ieslavereda.Tool;

public abstract class Reina extends Piece{

    public Reina(PieceType pieceType, Celda celda){
        super(pieceType,celda);
    }

    @Override
    public ListaSE getNextMoves() {

        ListaSE coordinates1 = Torre.getNextMovesAsTorre(this);
        ListaSE coordinates2 = Alfil.getNextMovesAsAlfil(this);


        return coordinates1.addAll(coordinates2);
    }

}
