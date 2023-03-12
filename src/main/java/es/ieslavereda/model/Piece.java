package es.ieslavereda.model;

import es.ieslavereda.TAD.ListaSE;
import es.ieslavereda.TAD.Node;

import com.diogonunes.jcolor.Attribute;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.diogonunes.jcolor.Ansi.colorize;


/**
 * The type Piece.
 */
public abstract class Piece {
    private PieceType shape;

    /**
     * The Celda.
     */
    protected Celda celda;
    private boolean moved;
    private int code;
    private static int codeIncrement;

    /**
     * Instantiates a new Piece.
     */
    public Piece() {
    }

    /**
     * Instantiates a new Piece.
     *
     * @param shape the shape
     * @param celda the celda
     */
    public Piece(PieceType shape, Celda celda){
        this.shape = shape;
        this.celda = celda;
        moved = false;
        code = codeIncrement++;
        putInYourPlace();
    }

    /**
     * Move to.
     *
     * @param c the c
     */
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

    /**
     * Has moved boolean.
     *
     * @return the boolean
     */
    public boolean hasMoved() {
        return moved;
    }

    /**
     * Gets celda.
     *
     * @return the celda
     */
    public Celda getCelda() {
        return celda;
    }

    /**
     * Get color color.
     *
     * @return the color
     */
    public Color getColor(){
        return shape.color;
    }

    /**
     * Gets shape.
     *
     * @return the shape
     */
    public PieceType getShape() {
        return shape;
    }

    /**
     * Put in your place.
     */
    public void putInYourPlace(){
        celda.setPiece(this);
    }

    @Override
    public int hashCode() {
        return code;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Piece){
            Piece aux = (Piece) obj;
            return aux.getShape()==getShape() && aux.getColor()==getColor();
        }
        return false;
    }

    @Override
    public String toString(){
//        return "Shape: " + shape.shape + "\n";
        return colorize(shape.toString(),shape.color.getAttribute(),celda.getColor().getAttribute());
    }

    /**
     * Gets next moves.
     *
     * @return the next moves
     */
    public abstract Set<Coordenada> getNextMoves();

    /**
     * The enum Piece type.
     */
    enum PieceType {
        /**
         * Black torre piece type.
         */
        BLACK_TORRE('♜', Color.BLACK),
        /**
         * Black caballo piece type.
         */
        BLACK_CABALLO ('♞', Color.BLACK),
        /**
         * Black alfil piece type.
         */
        BLACK_ALFIL ('♝', Color.BLACK),
        /**
         * Black reina piece type.
         */
        BLACK_REINA('♛', Color.BLACK),
        /**
         * Black rey piece type.
         */
        BLACK_REY('♚', Color.BLACK),
        /**
         * Black peon piece type.
         */
        BLACK_PEON('♟', Color.BLACK),

        /**
         * White torre piece type.
         */
        WHITE_TORRE('♜', Color.WHITE),
        /**
         * White caballo piece type.
         */
        WHITE_CABALLO ('♞', Color.WHITE),
        /**
         * White alfil piece type.
         */
        WHITE_ALFIL ('♝', Color.WHITE),
        /**
         * White reina piece type.
         */
        WHITE_REINA('♛', Color.WHITE),
        /**
         * White rey piece type.
         */
        WHITE_REY('♚', Color.WHITE),
        /**
         * White peon piece type.
         */
        WHITE_PEON('♟', Color.WHITE);


        private char shape;
        private Color color;

        PieceType(char shape,  Color color){
            this.shape = shape;
            this.color = color;
        }

        /**
         * Gets shape.
         *
         * @return the shape
         */
        public char getShape() {
            return shape;
        }

        /**
         * Gets color.
         *
         * @return the color
         */
        public Color getColor() {
             return color;
         }

         @Override
        public String toString(){
            return shape + "";
        }

    }

}
