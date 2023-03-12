package es.ieslavereda.model;


/**
 * The type Torre blanca.
 */
public final class TorreBlanca extends Torre{

    /**
     * Instantiates a new Torre blanca.
     *
     * @param celda the celda
     */
    public TorreBlanca(Celda celda){
        super(PieceType.WHITE_TORRE,celda);
    }

}
