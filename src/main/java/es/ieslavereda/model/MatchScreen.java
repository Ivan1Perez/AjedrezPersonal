package es.ieslavereda.model;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class MatchScreen {

    private Game game;
    public MatchScreen(Game game) {
        this.game = game;
    }

    public void turnMessage(Player player){
        if(!game.isMovementDone())
            System.out.println("Movement canceled");

        System.out.println("It's " + player.getName() + "'s turn -> " + player.getColor());
        System.out.println("Which piece do you want to move?");
        System.out.println("Enter a coordinate:");
    }

    public void chooseColorMessage(String name){
        System.out.println("Player [" + name + "] choose color:\n" +
                "White → Press [W]\n" +
                "Black → Press [B]");
    }

    public void enemyPieceMessage(){
        System.out.println("This is an enemy piece. Please, select one of your pieces:");
    }

    public void emptyMessage(){
        System.out.println("This cell is empty. Please, select a cell with a piece in it:");
    }

    public void noMovesAvailableMessage(){
        System.out.println("This piece has no moves availables at the moment. Try with another piece:");
    }

    public void printBoard(Tablero t){
        System.out.println(t + "\n");
    }

    public void whereToMoveMessage(Set<Coordenada> coordenadas, boolean firstTry){
        String outputCoordenadas = new ArrayList<>(coordenadas).toString();

        if(firstTry)
            System.out.println("Where do you want to move it?");

        System.out.println("Possible moves: " + outputCoordenadas);
        System.out.println("Enter a coordenate or press [C] to cancel:");
    }



}
