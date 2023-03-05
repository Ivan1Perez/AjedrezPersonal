package es.ieslavereda.model;

import java.util.ArrayList;
import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;

public class DeletePieceManagerStandar implements IDeletePieceManager{

    private List<Piece> pieces;

    public DeletePieceManagerStandar(){
        pieces = new ArrayList<>();
    }

    @Override
    public void add (Piece piece) {
        pieces.add(piece);
    }

    @Override
    public int count(Piece.PieceType pieceType) {

        int count = 0;


        for (int i = 0 ; i < pieces.size() ; i++){
            if(pieces.get(i).getShape()==pieceType){
                count++;
            }
        }

        return count;
    }

//    @Override
//    public Piece getLast() {
//        return null;
//    }

    @Override
    public Piece removeLast() {
        return pieces.remove(pieces.size());
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
