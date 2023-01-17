package es.ieslavereda.model;

public class Torre extends Piece{

    private Coordenada[] coordenadas;

    public Torre(PieceType pieceType, Celda celda){
        super (pieceType, celda);
    }

    @Override
    public Coordenada[] getNextMoves(){
        coordenadas = new Coordenada[0];
        Coordenada position = getCelda().getCoordenada();
        Coordenada c;

        //Up
        c = position.up();
        check(c);

        return coordenadas;
    }

    public void check(Coordenada c){
        Tablero tablero = getCelda().getTablero();

        if(tablero.getCelda(c)!=null){
            if(tablero.getCelda(c).isEmpty())
                coordenadas = Tool.add(coordenadas,c);
            else if(tablero.getCelda(c).getPiece().getColor()!=getColor())
                coordenadas = Tool.add(coordenadas, c);
        }
    }

}
