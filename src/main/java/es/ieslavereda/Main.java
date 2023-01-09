package es.ieslavereda;

import es.ieslavereda.model.Color;
import es.ieslavereda.model.Coordenada;
import es.ieslavereda.model.Piece;

public class Main {
    public static void main(String[] args) {

//        Coordenada c = new Coordenada('c', 2);
//
//        Piece piece = new Piece(Piece.PieceType.BLACK_REINA);
//        System.out.println(piece);

        for(Piece.PieceType pieceType : Piece.PieceType.values())
            System.out.println(new Piece(pieceType));
    }
}