package es.ieslavereda.model;

import java.util.List;

public final class PeonNegro extends Peon{
    public PeonNegro(Celda celda){
        super(PieceType.BLACK_PEON, celda);
    }

    @Override
    public void transform() {
        ListaDE<Piece> nonFilteredDeletedPieces = this.getCelda().getTablero().getDeletedPieces().getAll();
        List<Piece> filteredDeletedPieces = Tools.getDeletedPiecesByColor(nonFilteredDeletedPieces, this);
        ListaDE<Piece> remainingPieces = this.getCelda().getTablero().getRemainigPieces().getAll();

        Piece piece = MatchScreen.selectPieceToTransformMessage(filteredDeletedPieces);

        if(piece!=null) {

            switch (piece.getShape()) {
                case BLACK_REINA:
                    Piece reinaNegra = new ReinaNegra(getCelda());
                    Tools.addAndRemoveProcess(reinaNegra, this, nonFilteredDeletedPieces, remainingPieces);
                    celda=null;
                    break;
                case BLACK_TORRE:
                    Piece torreNegra = new TorreNegra(getCelda());
                    Tools.addAndRemoveProcess(torreNegra, this, nonFilteredDeletedPieces, remainingPieces);
                    celda=null;
                    break;
                case BLACK_CABALLO:
                    Piece caballoNegro = new CaballoNegro(getCelda());
                    Tools.addAndRemoveProcess(caballoNegro, this, nonFilteredDeletedPieces, remainingPieces);
                    celda=null;
                    break;
                case BLACK_ALFIL:
                    Piece alfilNegro = new AlfilNegro(getCelda());
                    Tools.addAndRemoveProcess(alfilNegro, this, nonFilteredDeletedPieces, remainingPieces);
                    celda=null;
                    break;
                default:
                    break;
            }
        }
    }
}
