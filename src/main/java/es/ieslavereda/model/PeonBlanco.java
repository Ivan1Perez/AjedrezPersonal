package es.ieslavereda.model;

import java.util.List;

public final class PeonBlanco extends Peon{

    public PeonBlanco(Celda celda){
        super(PieceType.WHITE_PEON, celda);
    }

    @Override
    public void transform() {
        ListaDE<Piece> nonFilteredDeletedPieces = this.getCelda().getTablero().getDeletedPieces().getAll();
        List<Piece> filteredDeletedPieces = Tools.getDeletedPiecesByColor(nonFilteredDeletedPieces, this);
        ListaDE<Piece> remainingPieces = this.getCelda().getTablero().getRemainigPieces().getAll();

        Piece piece = MatchScreen.selectPieceToTransformMessage(filteredDeletedPieces);

        if(piece!=null) {

            switch (piece.getShape()) {
                case WHITE_REINA:
                    Piece reinaBlanca = new ReinaBlanca(getCelda());
                    Tools.addAndRemoveProcess(reinaBlanca, this, nonFilteredDeletedPieces, remainingPieces);
                    celda=null;
                    break;
                case WHITE_TORRE:
                    Piece torreBlanca = new TorreBlanca(getCelda());
                    Tools.addAndRemoveProcess(torreBlanca, this, nonFilteredDeletedPieces, remainingPieces);
                    celda=null;
                    break;
                case WHITE_CABALLO:
                    Piece caballoBlanco = new CaballoBlanco(getCelda());
                    Tools.addAndRemoveProcess(caballoBlanco, this, nonFilteredDeletedPieces, remainingPieces);
                    celda=null;
                    break;
                case WHITE_ALFIL:
                    Piece alfilBlanco = new AlfilBlanco(getCelda());
                    Tools.addAndRemoveProcess(alfilBlanco, this, nonFilteredDeletedPieces, remainingPieces);
                    celda=null;
                    break;
                default:
                    break;
            }
        }
    }

    /*
    case BLACK_REINA:
        new ReinaNegra(getCelda());
        break;
     case BLACK_TORRE:
        new TorreNegra(getCelda());
        break;
    case BLACK_CABALLO:
        new CaballoNegro(getCelda());
        break;
    case BLACK_ALFIL:
        new AlfilNegro(getCelda());
        break;
     */

}
