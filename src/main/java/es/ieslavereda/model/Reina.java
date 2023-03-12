package es.ieslavereda.model;

import es.ieslavereda.TAD.ListaSE;
import es.ieslavereda.Tool;

import java.util.HashSet;
import java.util.Set;

/**
 * The type Reina.
 */
public abstract class Reina extends Piece{

    /**
     * Instantiates a new Reina.
     */
    public Reina() {
    }

    /**
     * Instantiates a new Reina.
     *
     * @param pieceType the piece type
     * @param celda     the celda
     */
    public Reina(PieceType pieceType, Celda celda){
        super(pieceType,celda);
    }

    @Override
    public Set<Coordenada> getNextMoves() {
        Set<Coordenada> coordFinal = new HashSet<>();

        Set<Coordenada> coordTorre = Torre.getNextMovesAsTorre(this);
        Set<Coordenada> coordAlfil = Alfil.getNextMovesAsAlfil(this);

        coordFinal.addAll(coordTorre);
        coordFinal.addAll(coordAlfil);
        return coordFinal;
    }

}
