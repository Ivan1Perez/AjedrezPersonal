package es.ieslavereda.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Tools.
 */
public class Tools {

    /**
     * Random int.
     *
     * @param max the max
     * @param min the min
     * @return the int
     */
    public static int random(int max, int min) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    /**
     * Get deleted pieces by color list.
     *
     * @param pieces the pieces
     * @param pawn   the pawn
     * @return the list
     */
    public static List<Piece> getDeletedPiecesByColor(ListaDE<Piece> pieces, Piece pawn){
        List<Piece> finalPieces = new ArrayList<>();

        for(int i = 0 ; i < pieces.getSize() ; i++){
            finalPieces.add(pieces.get(i));
        }

        finalPieces = finalPieces.stream()
                .filter(piece -> piece.getColor()==pawn.getColor())
                .filter(piece -> piece.getShape()!=pawn.getShape())
                .collect(Collectors.toList());

        return finalPieces;
    }

    /**
     * Add and remove process.
     *
     * @param selectedPiece   the selected piece
     * @param pawn            the pawn
     * @param deletedPieces   the deleted pieces
     * @param remainingPieces the remaining pieces
     */
    public static void addAndRemoveProcess(Piece selectedPiece, Piece pawn, ListaDE<Piece> deletedPieces,
                                           ListaDE<Piece> remainingPieces){
        remainingPieces.removePiece(pawn);
        deletedPieces.addHead(pawn);
        deletedPieces.removePiece(selectedPiece);
        remainingPieces.addHead(selectedPiece);
    }


}
