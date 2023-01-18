package es.ieslavereda.model;

public final class PeonBlanco extends Peon{

    public PeonBlanco(Celda celda){
        super(PieceType.WHITE_PEON, celda);
    }

    @Override
    public void transform() {
        new ReinaBlanca(getCelda());
        celda=null;
    }

}
