package es.ieslavereda.model;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import static es.ieslavereda.model.ReinaNegra.isDeadReinaNegra;

public final class PeonBlanco extends Peon{

    public PeonBlanco(Celda celda){
        super(PieceType.WHITE_PEON, celda);
    }

    @Override
    public void transform() {
        ListaDE<Piece> nonFilteredPieces = this.getCelda().getTablero().getDeletedPieces().getAll();
        List<Piece> filteredPieces = Tools.getDeletedPiecesByColor(nonFilteredPieces, this.getColor());

        Piece piece = MatchScreen.selectPieceToTransformMessage(filteredPieces);

        if(piece!=null) {

            switch (piece.getShape()) {
                case WHITE_REINA:
                    new ReinaBlanca(getCelda());
                    this.getCelda().getTablero().getDeletedPieces().removePiece(new ReinaBlanca(getCelda()));
                    celda=null;
                    break;
                case WHITE_TORRE:
                    new TorreBlanca(getCelda());
                    celda=null;
                    break;
                case WHITE_CABALLO:
                    new CaballoBlanco(getCelda());
                    celda=null;
                    break;
                case WHITE_ALFIL:
                    new AlfilBlanco(getCelda());
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
