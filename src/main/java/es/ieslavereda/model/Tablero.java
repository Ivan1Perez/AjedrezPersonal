package es.ieslavereda.model;

public class Tablero {

    private Celda[][] celdas;
    private Piece piece;

    public Tablero(){
        celdas = new Celda[8][8];

        for(int row = 0; row <=7; row++){
            for(int col=0; col<=7; col++){
                celdas[row][col] = new Celda(new Coordenada((char)('A'+col),row+1),this);
            }
        }

    }

    public Celda getCelda(Coordenada coordenada){
        if(coordenada.getFila()<1 || coordenada.getFila()>8)
            return null;
        if(coordenada.getCol()<'A' || coordenada.getCol()>'H')
            return null;
        return celdas[coordenada.getFila()-1][coordenada.getCol()-'A'];
    }

    public void placePieces(){
        Piece p = new CaballoBlanco(getCelda(new Coordenada('G',8)));
        p.putInYourPlace();
    }

    @Override
    public String toString(){
        String output = "   A  B  C  D  E  F  G  H\n";
        for(int row = 0; row <=7; row++){
            output += (row+1)+" ";
            for(int col=0; col<=7; col++)
                output += celdas[row][col];
            output +=" "+(row+1)+"\n";
        }
        output += "   A  B  C  D  E  F  G  H";

        return output;
    }

}
