package es.ieslavereda.model;

public abstract class Reina extends Piece{

    public Reina(PieceType pieceType, Reina cell){
        super(pieceType,cell);
    }

    @Override
    public Coordenada[] getNextMovements() {

        Coordenada[] coordinates1 = Torre.getNextMovesAsTorre(this);
        Coordenada[] coordinates2 = Alfil.getNextMovesAsAlfil(this);

        return Tool.merge(coordinates1,coordinates2);
    }

}
