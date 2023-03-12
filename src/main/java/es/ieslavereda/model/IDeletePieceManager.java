package es.ieslavereda.model;

/**
 * The interface Delete piece manager.
 */
public interface IDeletePieceManager {

    /**
     * Add.
     *
     * @param piece the piece
     */
    void add(Piece piece);

    /**
     * Count int.
     *
     * @param pieceType the piece type
     * @return the int
     */
    int count(Piece.PieceType pieceType);

    /**
     * Gets last.
     *
     * @return the last
     */
//    Piece getLast();
    Piece removeLast();

    /**
     * Remove piece boolean.
     *
     * @param piece the piece
     * @return the boolean
     */
    boolean removePiece(Piece piece);

    /**
     * Gets all.
     *
     * @return the all
     */
    ListaDE<Piece> getAll();

}
