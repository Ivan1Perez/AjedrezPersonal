package es.ieslavereda.model;

public interface IDeletePieceManager {

    void add(Piece piece);
    int count(Piece.PieceType pieceType);
    Piece getLast();

}
