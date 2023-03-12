package es.ieslavereda.model;

/**
 * Represents a white bishop chess piece.
 */
public final class AlfilBlanco extends Alfil {

    /**
     * Instantiates a new white bishop.
     *
     * @param celda the celda
     */
    public AlfilBlanco(Celda celda){
        super(PieceType.WHITE_ALFIL, celda);
    }

}
