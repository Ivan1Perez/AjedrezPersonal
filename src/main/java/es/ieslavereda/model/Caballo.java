package es.ieslavereda.model;

public abstract class Caballo extends Piece{

    public Caballo(PieceType pieceType, Celda celda){
        super(pieceType, celda);
    }

    @Override
    public Coordenada[] getNextMoves() {
        Coordenada[] coordenadas = new Coordenada[0];
        Tablero tablero = getCelda().getTablero();
        Coordenada position = getCelda().getCoordenada();

        return new Coordenada[0];
    }

}
