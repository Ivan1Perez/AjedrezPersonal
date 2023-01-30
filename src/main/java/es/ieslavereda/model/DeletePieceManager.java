package es.ieslavereda.model;

import es.ieslavereda.TAD.ListaSE;

public class DeletePieceManager implements IDeletePieceManager{

    private ListaDE pieces;

    public DeletePieceManager(){
        pieces = new ListaDE();
    }

    @Override
    public void add (Piece piece) {
        pieces.addHead(piece);
    }

    @Override
    public int count(Piece.PieceType pieceType) {
        return pieces.count(pieceType);
    }

//    @Override
//    public Piece getLast() {
//        return null;
//    }

    @Override
    public Piece removeLast() {
        return pieces.removeHead();
    }

    @Override
    public String toString() {
        return "Pieza eliminada: " + pieces;
    }
}
