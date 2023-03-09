package es.ieslavereda.model;

import static es.ieslavereda.model.ReinaNegra.isDeadReinaNegra;

public final class PeonBlanco extends Peon{

    public PeonBlanco(Celda celda){
        super(PieceType.WHITE_PEON, celda);
    }

    @Override
    public void transform() {
        ListaDE<Piece> deletedPieces = this.getCelda().getTablero().getDeletedPieces().getAll();

        MatchScreen.selectPieceToTransformMessage(Tools.getDeletedPiecesByColor(deletedPieces, this.getColor()));
        if(isDeadReinaNegra()) {
            new ReinaBlanca(getCelda());
            celda=null;
        }
    }

}
