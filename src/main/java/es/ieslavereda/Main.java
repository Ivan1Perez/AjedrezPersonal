package es.ieslavereda;
//prueba ajedrez personal
import es.ieslavereda.TAD.ListaSE;
import es.ieslavereda.model.*;

//Check

public class Main {
    public static void main(String[] args) {

//        for(Piece.PieceType pieceType : Piece.PieceType.values())
//            System.out.println(new Piece(pieceType));

        Tablero t = new Tablero();
        t.placePieces();

//        t.getCelda(new Coordenada('C', 5)).getPiece().moveTo(new Coordenada('E', 3));
        System.out.println(t);

//        Coordenada[] coordenadas = t.getCelda(new Coordenada('D',7)).getPiece().getNextMoves();
//        t.highlight(coordenadas);
//        System.out.println(t);
//        t.highlight(coordenadas);
//
//        for(Coordenada c : coordenadas) {
//            System.out.print(c + " ");
//        }

        t.getCelda(new Coordenada('D', 7)).getPiece().moveTo(new Coordenada('D', 5));
        t.getCelda(new Coordenada('D', 2)).getPiece().moveTo(new Coordenada('D', 4));
        t.getCelda(new Coordenada('E', 2)).getPiece().moveTo(new Coordenada('E', 3));
        t.getCelda(new Coordenada('F', 2)).getPiece().moveTo(new Coordenada('F', 4));
        t.getCelda(new Coordenada('E', 7)).getPiece().moveTo(new Coordenada('E', 6));
        //Movemos la torre a propósito para comprobar que el método de enroque funciona correctamente
        t.getCelda(new Coordenada('H', 1)).getPiece().moveTo(new Coordenada('H', 5));
//        t.getCelda(new Coordenada('D', 1)).getPiece().moveTo(new Coordenada('H', 5));


        ListaSE coordenadas = t.getCelda(new Coordenada('D',1)).getPiece().getNextMoves();
        t.highlight(coordenadas);
        System.out.println(t);
        t.highlight(coordenadas);
//
        for(Coordenada c : coordenadas.toArray()) {
            System.out.print(c + " ");
        }
    }
}