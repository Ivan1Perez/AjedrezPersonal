package es.ieslavereda.model;

public final class PeonNegro extends Peon{
    public PeonNegro(Celda celda){
        super(PieceType.BLACK_PEON, celda);
    }


    @Override
    public Coordenada[] getNextMoves(){
        return new Coordenada[0];
    }

    @Override
    public void transform() {
        new ReinaNegra(getCelda());
        celda=null;
    }
}
