package es.ieslavereda.model;

import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Celda {

    private Tablero tablero;
    private ColorCelda color;
    private Coordenada coordenada;
    private Piece piece;
    private ColorCelda original;

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

    public ColorCelda getColor() {
        return color;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece(){
        return piece;
    }

    public void highlight(){
        if(piece!=null && original==ColorCelda.BLACK_CELL){
            color = ColorCelda.HIGHLIGHT_KILL_BLACK;
        }else if(piece!=null && original==ColorCelda.WHITE_CELL){
            color = ColorCelda.HIGHLIGHT_KILL_WHITE;
        }else if(piece==null && original==ColorCelda.BLACK_CELL){
            color = ColorCelda.HIGHLIGHT_BLACK;
        }else color = ColorCelda.HIGHLIGHT_WHITE;
    }

    private enum ColorCelda {
        WHITE_CELL(Attribute.BACK_COLOR(180, 180, 180)),
        BLACK_CELL(Attribute.BACK_COLOR(100, 100, 100)),
        HIGHLIGHT_WHITE(Attribute.BACK_COLOR(180, 0, 0)),
        HIGHLIGHT_BLACK(Attribute.BACK_COLOR(130, 0, 0)),
        HIGHLIGHT_KILL_WHITE(Attribute.BACK_COLOR(180, 180, 0)),
        HIGHLIGHT_KILL_BLACK(Attribute.BACK_COLOR(130, 130, 0));

        private Attribute attribute;

        ColorCelda(Attribute attribute) {
            this.attribute = attribute;
        }

        public Attribute getAttribute() {
            return attribute;
        }

    }

//    public boolean isEmpty(){
//
//    }

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
