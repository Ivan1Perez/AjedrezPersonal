package es.ieslavereda;

import es.ieslavereda.model.Coordenada;
import es.ieslavereda.model.Piece;

public class Main {
    public static void main(String[] args) {
        Coordenada c = new Coordenada('c', 2);

        Piece piece = new Piece('\u265C', "blanco");
        System.out.println(piece);
    }
}