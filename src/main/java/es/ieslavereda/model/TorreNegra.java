package es.ieslavereda.model;

/**
 * The type Torre negra.
 */
public final class TorreNegra extends Torre{

    /**
     * Instantiates a new Torre negra.
     *
     * @param celda the celda
     */
    public TorreNegra(Celda celda){
        super(Piece.PieceType.BLACK_TORRE,celda);
    }

}
