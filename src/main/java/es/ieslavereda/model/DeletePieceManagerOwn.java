package es.ieslavereda.model;

import static com.diogonunes.jcolor.Ansi.colorize;

public class DeletePieceManagerOwn implements IDeletePieceManager{

    private ListaDE<Piece> pieces;

    public DeletePieceManagerOwn() {
        pieces = new ListaDE<>();
    }

    @Override
    public void add (Piece piece) {
        pieces.addTail(piece);
    }

    @Override
    public int count(Piece.PieceType pieceType){

        int count = 0;

        for (int i = 0 ; i < pieces.getSize() ; i++){
            if(pieces.get(i).getShape()==pieceType){
                count++;
            }
        }

        return count;
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
            output += colorize(" " + count(pieceType) + " ", pieceType.getColor().getAttribute(), Celda.ColorCelda.WHITE_CELL.getAttribute());

        return output;
    }

}
