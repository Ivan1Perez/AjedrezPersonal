package es.ieslavereda;

import es.ieslavereda.model.*;

//cometn prueba

public class Main {
    public static void main(String[] args) {

//        for(Piece.PieceType pieceType : Piece.PieceType.values())
//            System.out.println(new Piece(pieceType));

        Tablero t = new Tablero();
        t.placePieces();

        Coordenada[] coordenadas = t.getCelda(new Coordenada('E',5)).getPiece().getNextMoves();
        t.highlight(coordenadas);
        System.out.println(t);
        t.highlight(coordenadas);

        for(Coordenada c : coordenadas) {
            System.out.print(c + " ");
        }

    }
}