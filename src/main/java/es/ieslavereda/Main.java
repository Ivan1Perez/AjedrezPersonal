package es.ieslavereda;

import es.ieslavereda.model.*;

//cometn prueba

public class Main {
    public static void main(String[] args) {

//        for(Piece.PieceType pieceType : Piece.PieceType.values())
//            System.out.println(new Piece(pieceType));

        Tablero t = new Tablero();
        System.out.println(t);
       t.placePieces();
        System.out.println(t);

    }
}