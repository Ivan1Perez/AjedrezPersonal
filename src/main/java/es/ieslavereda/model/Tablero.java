package es.ieslavereda.model;

import es.ieslavereda.TAD.ListaSE;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Tablero{

    private IDeletePieceManager deletePieceManager;
    private Map<Coordenada, Celda> mapaTablero;

    public Tablero(){

        this.deletePieceManager = new DeletePieceManagerOwn();
        mapaTablero = new LinkedHashMap<>();
        Coordenada coordenada;

        for(int row = 0; row <=7; row++){
            for(int col=0; col<=7; col++){
                coordenada = new Coordenada((char)('A'+col),row+1);
                mapaTablero.put(coordenada, new Celda(coordenada,this));
            }
        }

    }

    public Celda getCelda(Coordenada coordenada){
        if(coordenada.getFila()<1 || coordenada.getFila()>8)
            return null;
        if(coordenada.getCol()<'A' || coordenada.getCol()>'H')
            return null;
        return mapaTablero.get(coordenada);
    }

    public void placePieces(Color color){
        int whites = 8, blacks = 1, whitePawns = 7, blackPawns = 2;

        if(color==Color.BLACK){
            whites = 1;
            blacks = 8;
            whitePawns = 2;
            blackPawns = 7;
        }

        new TorreNegra(getCelda(new Coordenada('A', blacks)));
        new CaballoNegro(getCelda(new Coordenada('B',blacks)));
        new AlfilNegro(getCelda(new Coordenada('C',blacks)));
        new ReyNegro(getCelda(new Coordenada('E',blacks)));
        new ReinaNegra(getCelda(new Coordenada('D',blacks)));
        new AlfilNegro(getCelda(new Coordenada('F',blacks)));
        new CaballoNegro(getCelda(new Coordenada('G',blacks)));
        new TorreNegra(getCelda(new Coordenada('H', blacks)));
        for(int i = 0 ; i < 8 ; i++){
            new PeonNegro(getCelda(new Coordenada(((char)('A'+ i)), blackPawns)));
            new PeonBlanco(getCelda(new Coordenada(((char)('H'- i)), whitePawns)));
        }
        new TorreBlanca(getCelda(new Coordenada('A',whites)));
        new CaballoBlanco(getCelda(new Coordenada('B',whites)));
        new AlfilBlanco(getCelda(new Coordenada('C', whites)));
        new ReinaBlanca(getCelda(new Coordenada('D',whites)));
        new ReyBlanco(getCelda(new Coordenada('E', whites)));
        new AlfilBlanco(getCelda(new Coordenada('F', whites)));
        new CaballoBlanco(getCelda(new Coordenada('G',whites)));
        new TorreBlanca(getCelda(new Coordenada('H',whites)));
    }


    public void highlight(ListaSE coordenadas){

        for (Coordenada c : coordenadas.toArray())
            getCelda(c).highlight();
    }

    public void resetColors(){
        Collection<Celda> celdas = mapaTablero.values();

        for (Celda celda : celdas) {
            celda.resetColor();
        }
    }

    @Override
    public String toString(){
        String output = "   A  B  C  D  E  F  G  H\n";
        for(int row = 0; row <=7; row++){
            output += (row+1)+" ";
            for(int col=0; col<=7; col++){
                output += mapaTablero.get(new Coordenada((char)('A'+col), row+1));
            }
            output +=" "+(row+1)+"\n";
        }
        output += "   A  B  C  D  E  F  G  H\n";

        output += "\t\t REMAINING PIECES";
        output += "\n" + deletePieceManager.toString() + "\n";

        output += "\t\t DELETED PIECES";
        output += "\n" + deletePieceManager.toString();

        return output;
    }

}
