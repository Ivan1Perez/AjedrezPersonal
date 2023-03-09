package es.ieslavereda.model;

public interface IDeletePieceManager {

    void add(Piece piece);
    int count(Piece.PieceType pieceType);
//    Piece getLast();
    Piece removeLast();
    boolean removePiece(Piece piece);
    ListaDE<Piece> getAll();

}
