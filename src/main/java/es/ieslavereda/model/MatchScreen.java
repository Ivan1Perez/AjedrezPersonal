package es.ieslavereda.model;

public class MatchScreen {

    public MatchScreen() {

    }

    public void turn(Player player){
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

}
