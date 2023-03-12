package es.ieslavereda.model;

/**
 * Represents a black bishop chess piece.
 */
public final class AlfilNegro extends Alfil {

    /**
     * Instantiates a new black bishop.
     *
     * @param celda the celda
     */
    public AlfilNegro(Celda celda){
        super(PieceType.BLACK_ALFIL, celda);
    }

}
