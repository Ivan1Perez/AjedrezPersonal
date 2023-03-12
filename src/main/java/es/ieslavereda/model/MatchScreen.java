package es.ieslavereda.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.diogonunes.jcolor.Ansi.colorize;

/**
 * The type Match screen.
 */
public class MatchScreen {

    /**
     * Instantiates a new Match screen.
     */
    public MatchScreen() {
    }

    /**
     * Turn message.
     *
     * @param player         the player
     * @param isMovementDone the is movement done
     * @param kingOnTarget   the king on target
     */
    public static void turnMessage(Player player, boolean isMovementDone, boolean kingOnTarget){
        if(!isMovementDone)
            System.out.println("Movement canceled");

        System.out.println("It's " + player.getName() + "'s turn -> " + player.getColor());
        if(kingOnTarget)
            System.out.println("Attention! The king is in check!");
        System.out.println("Which piece do you want to move?");
        System.out.println("Enter a coordinate:");
    }

    /**
     * Choose color message.
     *
     * @param name the name
     */
    public static void chooseColorMessage(String name){
        System.out.println("Player [" + name + "] choose color:\n" +
                "White → Press [W]\n" +
                "Black → Press [B]");
    }

    /**
     * Enemy piece message.
     */
    public static void enemyPieceMessage(){
        System.out.println("This is an enemy piece. Please, select one of your pieces:");
    }

    /**
     * Empty message.
     */
    public static void emptyMessage(){
        System.out.println("This cell is empty. Please, select a cell with a piece in it:");
    }

    /**
     * No moves available message.
     */
    public static void noMovesAvailableMessage(){
        System.out.println("This piece has no moves availables at the moment. Try with another piece:");
    }

    /**
     * Print board.
     *
     * @param t the t
     */
    public static void printBoard(Tablero t){
        System.out.println(t + "\n");
    }

    /**
     * Where to move message.
     *
     * @param coordenadas the coordenadas
     * @param firstTry    the first try
     */
    public static void whereToMoveMessage(Set<Coordenada> coordenadas, boolean firstTry){
        String outputCoordenadas = new ArrayList<>(coordenadas).toString();

        if(firstTry)
            System.out.println("Where do you want to move it?");

        System.out.println("Possible moves: " + outputCoordenadas);
        System.out.println("Enter a coordenate or press [C] to cancel:");
    }

    /**
     * Select piece to transform message piece.
     *
     * @param pieces the pieces
     * @return the piece
     */
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

    /**
     * Winner message.
     *
     * @param player     the player
     * @param totalTurns the total turns
     */
    public static void winnerMessage(Player player, int totalTurns){

        System.out.println("Checkmate! The game is over.");
        System.out.println("Player [" + player.getName() + " -> " + player.getColor() +"] wins!");
        System.out.println("Total movements: " + totalTurns);
    }

}
