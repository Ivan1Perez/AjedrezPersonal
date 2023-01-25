package es.ieslavereda.model;

import es.ieslavereda.TAD.ListaSE;
import es.ieslavereda.TAD.Node;

import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Ansi.colorize;


public abstract class Piece {
    private PieceType shape;

    protected Celda celda;
    private boolean moved;


    public Piece(PieceType shape, Celda celda){
        this.shape = shape;
        this.celda = celda;
        moved = false;
        putInYourPlace();
    }

    public void moveTo(Coordenada c){
        Tablero t = getCelda().getTablero();
        moved = true;

        // Check if the cell exists
        if(t.getCelda(c)!=null) {
            getCelda().setPiece(null);
            Celda celda = t.getCelda(c);
            celda.setPiece(this);
            this.celda = celda;
        }
    }

    public boolean hasMoved() {
        return moved;
    }

    public Celda getCelda() {
        return celda;
    }

    public Color getColor(){
        return shape.color;
    }

    public void putInYourPlace(){
        celda.setPiece(this);
    }

    @Override
    public String toString(){
//        return "Shape: " + shape.shape + "\n";
        return colorize(shape.toString(),shape.color.getAttribute(),celda.getColor().getAttribute());
    }

    public abstract ListaSE getNextMoves();

     enum PieceType {

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
