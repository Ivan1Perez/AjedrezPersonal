package es.ieslavereda.model;

import javax.print.DocFlavor;
import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Ansi.colorize;


public class Piece {
    private PieceType shape;

    private Celda celda;

    public Piece(PieceType shape, Celda celda){
        this.shape = shape;
        this.celda = celda;
    }

    @Override
    public String toString(){
//        return "Shape: " + shape.shape + "\n";
        return colorize(shape.toString(),shape.color.getAttribute(),celda.getColor().getAttribute());
    }

    public enum PieceType {

        BLACK_CABALLO ('♞', Color.BLACK),
        BLACK_ALFIL ('♝', Color.BLACK),
        BLACK_PEON('♟', Color.BLACK),
        BLACK_REINA('♛', Color.BLACK),
        BLACK_REY('♚', Color.BLACK),
        BLACK_TORRE('♜', Color.BLACK),
        WHITE_CABALLO ('♞', Color.WHITE),
        WHITE_ALFIL ('♝', Color.WHITE),
        WHITE_PEON('♟', Color.WHITE),
        WHITE_REINA('♛', Color.WHITE),
        WHITE_REY('♚', Color.WHITE),
        WHITE_TORRE('♜', Color.WHITE);

        private char shape;
        private Color color;

        PieceType(char shape,  Color color){
            this.shape = shape;
            this.color = color;
        }

        public char getShape() {
            return shape;
        }

        @Override
        public String toString(){
            return shape + "";
        }

    }

}
