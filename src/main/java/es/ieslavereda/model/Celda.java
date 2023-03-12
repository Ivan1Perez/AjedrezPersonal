package es.ieslavereda.model;

import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Ansi.colorize;

/**
 * The type Celda.
 */
public class Celda {

    private Tablero tablero;
    private ColorCelda color;
    private Coordenada coordenada;
    private Piece piece;
    private ColorCelda original;

    /**
     * Instantiates a new Celda.
     *
     * @param coordenada the coordenada
     * @param tablero    the tablero
     */
    public Celda(Coordenada coordenada, Tablero tablero) {
        this.coordenada = coordenada;
        this.tablero = tablero;
        this.piece = null;
        this.original = (
                (coordenada.getFila()-1)+coordenada.getCol()-'A')%2==0
                ?
                ColorCelda.WHITE_CELL
                :
                ColorCelda.BLACK_CELL;
        this.color = original;
    }

    /**
     * Gets tablero.
     *
     * @return the tablero
     */
    public Tablero getTablero() {
        return tablero;
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty(){
        if(piece == null)
            return true;
        return false;
    }

    /**
     * Gets coordenada.
     *
     * @return the coordenada
     */
    public Coordenada getCoordenada() {
        return coordenada;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public ColorCelda getColor() {
        return color;
    }

    /**
     * Sets piece.
     *
     * @param piece the piece
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    /**
     * Get piece piece.
     *
     * @return the piece
     */
    public Piece getPiece(){
        return piece;
    }

    /**
     * Highlight the color of the cells selected depending on the color of the piece it contains and if is on target
     */
    public void highlight(){
        if(piece!=null && original==ColorCelda.BLACK_CELL){
            color = ColorCelda.HIGHLIGHT_KILL_BLACK;
        }else if(piece!=null && original==ColorCelda.WHITE_CELL){
            color = ColorCelda.HIGHLIGHT_KILL_WHITE;
        }else if(piece==null && original==ColorCelda.BLACK_CELL){
            color = ColorCelda.HIGHLIGHT_BLACK;
        }else color = ColorCelda.HIGHLIGHT_WHITE;
    }

    @Override
    public int hashCode() {
        return getPiece().hashCode();
    }

    /**
     * The enum Color celda.
     */
    enum ColorCelda {
        /**
         * White cell color celda.
         */
        WHITE_CELL(Attribute.BACK_COLOR(180, 180, 180)),
        /**
         * Black cell color celda.
         */
        BLACK_CELL(Attribute.BACK_COLOR(100, 100, 100)),
        /**
         * Highlight white color celda.
         */
        HIGHLIGHT_WHITE(Attribute.BACK_COLOR(180, 180, 0)),
        /**
         * Highlight black color celda.
         */
        HIGHLIGHT_BLACK(Attribute.BACK_COLOR(130, 180, 0)),
        /**
         * Highlight kill white color celda.
         */
        HIGHLIGHT_KILL_WHITE(Attribute.BACK_COLOR(180, 0, 0)),
        /**
         * Highlight kill black color celda.
         */
        HIGHLIGHT_KILL_BLACK(Attribute.BACK_COLOR(130, 0, 0));

        private Attribute attribute;

        ColorCelda(Attribute attribute) {
            this.attribute = attribute;
        }

        /**
         * Gets attribute.
         *
         * @return the attribute
         */
        public Attribute getAttribute() {
            return attribute;
        }

    }

    /**
     * Reset color.
     */
    public void resetColor() {
        color = original;
    }

    @Override
    public String toString(){
        if(piece==null)
            return colorize("   ",color.getAttribute());
        return colorize(" ",color.getAttribute()) +
                    piece +
                colorize(" ",color.getAttribute());
    }

}
