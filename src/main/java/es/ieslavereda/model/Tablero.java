package es.ieslavereda.model;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * The type Tablero.
 */
public class Tablero{

    private IDeletePieceManager remainigPieces;
    private IDeletePieceManager deletedPieces;
    private boolean whitesUp;
    private Map<Coordenada, Celda> mapaTablero;

    /**
     * Instantiates a new Tablero.
     */
    public Tablero(){

        whitesUp = false;
        this.remainigPieces = new DeletePieceManagerOwn();
        this.deletedPieces = new DeletePieceManagerOwn();
        mapaTablero = new LinkedHashMap<>();
        Coordenada coordenada;


        for(int row = 0; row <=7; row++){
            for(int col=0; col<=7; col++){
                coordenada = new Coordenada((char)('A'+col),row+1);
                mapaTablero.put(coordenada, new Celda(coordenada,this));
            }
        }

    }

    /**
     * Is whites up boolean.
     *
     * @return the boolean
     */
    public boolean isWhitesUp() {
        return whitesUp;
    }

    /**
     * Get celda celda.
     *
     * @param coordenada the coordenada
     * @return the celda
     */
    public Celda getCelda(Coordenada coordenada){
        if(coordenada.getFila()<1 || coordenada.getFila()>8)
            return null;
        if(coordenada.getCol()<'A' || coordenada.getCol()>'H')
            return null;
        return mapaTablero.get(coordenada);
    }

    /**
     * Gets remainig pieces.
     *
     * @return the remainig pieces
     */
    public IDeletePieceManager getRemainigPieces() {
        return remainigPieces;
    }

    /**
     * Gets deleted pieces.
     *
     * @return the deleted pieces
     */
    public IDeletePieceManager getDeletedPieces() {
        return deletedPieces;
    }

    /**
     * Gets mapa tablero.
     *
     * @return the mapa tablero
     */
    public Map<Coordenada, Celda> getMapaTablero() {
        return mapaTablero;
    }

    /**
     * Sets mapa tablero.
     *
     * @param mapaTablero the mapa tablero
     */
    public void setMapaTablero(Map<Coordenada, Celda> mapaTablero) {
        this.mapaTablero = mapaTablero;
    }

    /**
     * Place pieces.
     *
     * @param color the color
     */
    public void placePieces(Color color){
        int whites = 8, blacks = 1, whitePawns = 7, blackPawns = 2;
        char queenPosition = 'D', kingPosition = 'E';

        if(color==Color.BLACK){
            whitesUp = true;
            whites = 1;
            blacks = 8;
            whitePawns = 2;
            blackPawns = 7;
            queenPosition = 'E';
            kingPosition = 'D';
        }
//---------------------------- PARA DEMOSTRACIÓN----------------------------------------------------------------
//        deletedPieces.add(new CaballoBlanco(getCelda(new Coordenada('A', blacks))));
//        deletedPieces.add(new AlfilBlanco(getCelda(new Coordenada('A', blacks))));
//        deletedPieces.add(new ReyBlanco(getCelda(new Coordenada('A', blacks))));
//        deletedPieces.add(new ReinaBlanca(getCelda(new Coordenada('A', blacks))));
//        deletedPieces.add(new AlfilBlanco(getCelda(new Coordenada('A', blacks))));
//        deletedPieces.add(new CaballoBlanco(getCelda(new Coordenada('A', blacks))));
//        deletedPieces.add(new TorreNegra(getCelda(new Coordenada('A', blacks))));
//
//        getRemainigPieces().add(new PeonBlanco(getCelda(new Coordenada(((char)('H')), 2))));
//        getRemainigPieces().add(new PeonBlanco(getCelda(new Coordenada(((char)('E')), 2))));
//        getRemainigPieces().add(new PeonNegro(getCelda(new Coordenada(((char)('D')), 7))));
//---------------------------- PARA DEMOSTRACIÓN---------------------------------------------------------------


        getRemainigPieces().add(new TorreNegra(getCelda(new Coordenada('A', blacks))));
        getRemainigPieces().add(new CaballoNegro(getCelda(new Coordenada('B',blacks))));
        getRemainigPieces().add(new AlfilNegro(getCelda(new Coordenada('C',blacks))));
        getRemainigPieces().add(new ReyNegro(getCelda(new Coordenada(kingPosition,blacks))));
        getRemainigPieces().add(new ReinaNegra(getCelda(new Coordenada(queenPosition,blacks))));
        getRemainigPieces().add(new AlfilNegro(getCelda(new Coordenada('F',blacks))));
        getRemainigPieces().add(new CaballoNegro(getCelda(new Coordenada('G',blacks))));
        getRemainigPieces().add(new TorreNegra(getCelda(new Coordenada('H', blacks))));
        for(int i = 0 ; i < 8 ; i++){
            getRemainigPieces().add(new PeonNegro(getCelda(new Coordenada(((char)('A'+ i)), blackPawns))));
            getRemainigPieces().add(new PeonBlanco(getCelda(new Coordenada(((char)('H'- i)), whitePawns))));
        }
        getRemainigPieces().add(new TorreBlanca(getCelda(new Coordenada('A',whites))));
        getRemainigPieces().add(new CaballoBlanco(getCelda(new Coordenada('B',whites))));
        getRemainigPieces().add(new AlfilBlanco(getCelda(new Coordenada('C', whites))));
        getRemainigPieces().add(new ReinaBlanca(getCelda(new Coordenada(queenPosition,whites))));
        getRemainigPieces().add(new ReyBlanco(getCelda(new Coordenada(kingPosition, whites))));
        getRemainigPieces().add(new AlfilBlanco(getCelda(new Coordenada('F', whites))));
        getRemainigPieces().add(new CaballoBlanco(getCelda(new Coordenada('G',whites))));
        getRemainigPieces().add(new TorreBlanca(getCelda(new Coordenada('H',whites))));
    }

    /**
     * Highlight king.
     *
     * @param coordenada the coordenada
     */
    public void highlightKing(Coordenada coordenada){
        getCelda(coordenada).highlight();
    }

    /**
     * Highlight.
     *
     * @param coordenadas the coordenadas
     */
    public void highlight(Set<Coordenada> coordenadas){

        for (Coordenada c : coordenadas)
            getCelda(c).highlight();
    }

    /**
     * Reset colors.
     */
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
        output += "\n" + remainigPieces.toString() + "\n";

        output += "\t\t DELETED PIECES";
        output += "\n" + deletedPieces.toString();

        return output;
    }

}
