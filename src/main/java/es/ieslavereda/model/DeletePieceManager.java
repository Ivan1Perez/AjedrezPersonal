package es.ieslavereda.model;

import static com.diogonunes.jcolor.Ansi.colorize;

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
        String output="";

        for (Piece.PieceType pieceType : Piece.PieceType.values())
            output += colorize(" " + pieceType.getShape() + " ", pieceType.getColor().getAttribute(), Celda.ColorCelda.BLACK_CELL.getAttribute());

        output+="\n";

        for(Piece.PieceType pieceType : Piece.PieceType.values())
            output += colorize(" " + pieces.count(pieceType) + " ", pieceType.getColor().getAttribute(), Celda.ColorCelda.WHITE_CELL.getAttribute());

        return output;
    }
}
