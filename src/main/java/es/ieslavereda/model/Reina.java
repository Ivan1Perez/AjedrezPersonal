package es.ieslavereda.model;

import es.ieslavereda.Tool;

public abstract class Reina extends Piece{

    public Reina(PieceType pieceType, Celda celda){
        super(pieceType,celda);
    }

    @Override
    public Coordenada[] getNextMoves() {

        Coordenada[] coordinates1 = Torre.getNextMovesAsTorre(this);
        Coordenada[] coordinates2 = Alfil.getNextMovesAsAlfil(this);

        return Tool.merge(coordinates1,coordinates2);
    }

}
