package es.ieslavereda.model;

import static com.diogonunes.jcolor.Ansi.colorize;

public class DeletePieceManagerOwn implements IDeletePieceManager{

    ListaDE<Piece> pieces;

    @Override
    public void add (Piece piece) {
        pieces.addTail(piece);
    }

    @Override
    public int count(Piece.PieceType pieceType){
        return pieces.count(pieceType);
    }

    @Override
    public Piece removeLast() {
        return pieces.removeTail();
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
