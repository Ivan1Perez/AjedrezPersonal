package es.ieslavereda.model;

public class Piece {
    private char shape;
    private String color;

    public Piece(char shape, String color){
        this.shape = shape;
        this.color = color;
    }

    @Override
    public String toString(){
        return "Shape: " + shape + "\n" +
                "Color: " + color + "\n";
    }
}
