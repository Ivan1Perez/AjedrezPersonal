package es.ieslavereda.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.diogonunes.jcolor.Ansi.colorize;

public class MatchScreen {

    public MatchScreen() {
    }

    public static void turnMessage(Player player, boolean isMovementDone, boolean kingOnTarget){
        if(!isMovementDone)
            System.out.println("Movement canceled");

        System.out.println("It's " + player.getName() + "'s turn -> " + player.getColor());
        if(kingOnTarget)
            System.out.println("Attention! The king is in check!");
        System.out.println("Which piece do you want to move?");
        System.out.println("Enter a coordinate:");
    }

    public static void chooseColorMessage(String name){
        System.out.println("Player [" + name + "] choose color:\n" +
                "White → Press [W]\n" +
                "Black → Press [B]");
    }

    public static void enemyPieceMessage(){
        System.out.println("This is an enemy piece. Please, select one of your pieces:");
    }

    public static void emptyMessage(){
        System.out.println("This cell is empty. Please, select a cell with a piece in it:");
    }

    public static void noMovesAvailableMessage(){
        System.out.println("This piece has no moves availables at the moment. Try with another piece:");
    }

    public static void printBoard(Tablero t){
        System.out.println(t + "\n");
    }

    public static void whereToMoveMessage(Set<Coordenada> coordenadas, boolean firstTry){
        String outputCoordenadas = new ArrayList<>(coordenadas).toString();

        if(firstTry)
            System.out.println("Where do you want to move it?");

        System.out.println("Possible moves: " + outputCoordenadas);
        System.out.println("Enter a coordenate or press [C] to cancel:");
    }

    public static Piece selectPieceToTransformMessage(List<Piece> pieces){
        String outputPieces = "";
        int i = 0;

        if(pieces.size()==0){
            System.out.println("There isn't any available piece at the moment.");
            return null;
        }

        for(Piece p : pieces){
            outputPieces += colorize(" " + p.getShape() + " ", p.getColor().getAttribute(), Celda.ColorCelda.BLACK_CELL.getAttribute());
            outputPieces += " → Press [" + i + "]\n";
            i++;
        }

        System.out.println("You've reached the end of the board.\n" +
                "Do you want to exchange this pawn for one deleted piece?\n" +
                "Yes → Press [Y]\n" +
                "No → Press [N]");

        if(Entrada.yesOrNotAnswer().equalsIgnoreCase("Y")) {
            System.out.println("Select one of the available pieces:\n"
                    + outputPieces);
            return Entrada.selectDeletedPiece(pieces);
        }

        return null;
    }

    public static void winnerMessage(Player player, int totalTurns){

        System.out.println("Checkmate! The game is over.");
        System.out.println("Player [" + player.getName() + " -> " + player.getColor() +"] wins!");
        System.out.println("Total movements: " + totalTurns);
    }

}
