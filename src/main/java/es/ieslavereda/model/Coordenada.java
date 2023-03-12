package es.ieslavereda.model;

/**
 * The type Coordenada.
 */
public class Coordenada{

    private int fila;
    private char col;

    /**
     * Instantiates a new Coordenada.
     */
    public Coordenada() {
    }

    /**
     * Instantiates a new Coordenada.
     *
     * @param col  the col
     * @param fila the fila
     */
    public Coordenada(char col, int fila){
        this.col = Character.toUpperCase(col);
        this.fila = fila;
    }

    /**
     * Gets fila.
     *
     * @return the fila
     */
    public int getFila() {
        return fila;
    }

    /**
     * Gets col.
     *
     * @return the col
     */
    public char getCol() {
        return col;
    }

    /**
     * Sets fila.
     *
     * @param fila the fila
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     * Sets col.
     *
     * @param col the col
     */
    public void setCol(char col) {
        this.col = Character.toUpperCase(col);
    }

    /**
     * Up coordenada.
     *
     * @return the coordenada
     */
    public Coordenada up(){
        return new Coordenada(col, fila-1);
   }

    /**
     * Down coordenada.
     *
     * @return the coordenada
     */
    public Coordenada down(){
        return new Coordenada(col, fila +1);
   }

    /**
     * Left coordenada.
     *
     * @return the coordenada
     */
    public Coordenada left(){
        return new Coordenada((char)(col-1), fila);
   }

    /**
     * Right coordenada.
     *
     * @return the coordenada
     */
    public Coordenada right(){
        return new Coordenada((char)(col+1), fila);
    }

    /**
     * Up right coordenada.
     *
     * @return the coordenada
     */
    public Coordenada upRight(){
        return up().right();
    }

    /**
     * Up left coordenada.
     *
     * @return the coordenada
     */
    public Coordenada upLeft(){
        return up().left();
    }

    /**
     * Down rigth coordenada.
     *
     * @return the coordenada
     */
    public Coordenada downRigth(){
        return down().right();
    }

    /**
     * Down left coordenada.
     *
     * @return the coordenada
     */
    public Coordenada downLeft(){
        return down().left();
    }

    @Override
    public int hashCode() {
        return fila+col;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Coordenada){
            Coordenada c = (Coordenada) obj;
            return col == c.col && fila == c.fila;
        }
        return false;
    }

    @Override
    public String toString(){
        return "(" + col + "," + fila + ")";
    }
}
