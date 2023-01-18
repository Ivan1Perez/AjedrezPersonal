package es.ieslavereda.model;

import es.ieslavereda.Tool;

public abstract class Alfil extends Piece{

    private Coordenada[] coordenadas;

    public Alfil(PieceType pieceType, Celda celda){
        super(pieceType, celda);
    }

    public static Coordenada[] getNextMovesAsAlfil(Piece p){
        Coordenada[] coordenadas = new Coordenada[0];
        Celda celda = p.getCelda();
        Tablero tablero = celda.getTablero();
        Color color = p.getColor();

        Coordenada original = celda.getCoordenada();
        Coordenada c;

        //UpLeft
        c = original.upLeft();
        while(tablero.getCelda(c)!=null && tablero.getCelda(c).isEmpty()) {
            coordenadas = Tool.add(coordenadas, c);
            c = c.upLeft();
        }
        if(tablero.getCelda(c)!=null && tablero.getCelda(c).getPiece().getColor()!=p.getColor())
            coordenadas = Tool.add(coordenadas, c);

        //UpRight
        c = original.upRight();
        while(tablero.getCelda(c)!=null && tablero.getCelda(c).isEmpty()) {
            coordenadas = Tool.add(coordenadas, c);
            c = c.upRight();
        }
        if(tablero.getCelda(c)!=null && tablero.getCelda(c).getPiece().getColor()!=p.getColor())
            coordenadas = Tool.add(coordenadas, c);

        //DownLeft
        c = original.downLeft();
        while(tablero.getCelda(c)!=null && tablero.getCelda(c).isEmpty()) {
            coordenadas = Tool.add(coordenadas, c);
            c = c.downLeft();
        }
        if(tablero.getCelda(c)!=null && tablero.getCelda(c).getPiece().getColor()!=p.getColor())
            coordenadas = Tool.add(coordenadas, c);

        //DownRight
        c = original.downRigth();
        while(tablero.getCelda(c)!=null && tablero.getCelda(c).isEmpty()) {
            coordenadas = Tool.add(coordenadas, c);
            c = c.downRigth();
        }
        if(tablero.getCelda(c)!=null && tablero.getCelda(c).getPiece().getColor()!=p.getColor())
            coordenadas = Tool.add(coordenadas, c);


        return coordenadas;
    }

    @Override
    public Coordenada[] getNextMoves(){
        return getNextMovesAsAlfil(this);
    }

}
