package es.ieslavereda.model;

import es.ieslavereda.TAD.ListaSE;

public class DeletePieceManager implements IDeletePieceManager{

    private Piece.PieceType shape;

    @Override
    public void add (Piece piece) {
        ListaSE pieces = new ListaSE();

        pieces.addTail(piece.getCelda().getCoordenada());
        this.shape = piece.getShape();
    }

    @Override
    public int count(Piece.PieceType pieceType) {
        return 0;
    }

//    @Override
//    public Piece getLast() {
//        return null;
//    }

    @Override
    public Piece removeLast() {
        return null;
    }

    @Override
    public String toString(){
        return "Piezas eliminadas: " + shape;
    }

}
