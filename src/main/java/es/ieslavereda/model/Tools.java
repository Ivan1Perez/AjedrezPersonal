package es.ieslavereda.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Tools {

    public static int random(int max, int min) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

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

    public static void addAndRemoveProcess(Piece selectedPiece, Piece pawn, ListaDE<Piece> deletedPieces,
                                           ListaDE<Piece> remainingPieces){
        remainingPieces.removePiece(pawn);
        deletedPieces.addHead(pawn);
        deletedPieces.removePiece(selectedPiece);
        remainingPieces.addHead(selectedPiece);
    }


}
