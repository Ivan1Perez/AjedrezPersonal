package es.ieslavereda;

import es.ieslavereda.model.*;

//cometn prueba

public class Main {
    public static void main(String[] args) {

//        for(Piece.PieceType pieceType : Piece.PieceType.values())
//            System.out.println(new Piece(pieceType));

        Tablero b = new Tablero();
        Celda c1 = new Celda(new Coordenada('A',1),b);
        Celda c2 = new Celda(new Coordenada('G',6),b);
        Piece p1 = new Piece(Piece.PieceType.BLACK_REINA,c1);
        Piece p2 = new Piece(Piece.PieceType.BLACK_REINA,c2);
        c1.highlight();
        c2.highlight();
        System.out.println(""+c1+c2);
        c1.setPiece(p1);
        c2.setPiece(p2);
        System.out.println();

        c1.highlight();
        c2.highlight();
        System.out.println(""+c1+c2);
        c1.resetColor();
        c2.resetColor();
        System.out.println();
        System.out.println(""+c1+c2);

    }
}