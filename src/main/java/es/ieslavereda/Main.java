package es.ieslavereda;
import java.util.Scanner;
import es.ieslavereda.TAD.ListaSE;
import java.io.IOException;
import es.ieslavereda.model.*;

//Check

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);
        Tablero t;
        String player1Name, player2Name;
        Color color;
        Player player1, player2;
        Entrada e = new Entrada();
        if(e.getEmpezar().equalsIgnoreCase("y")){
            t = new Tablero();

            System.out.println("Enter player 1 name:");
            player1Name = sc.nextLine();
            System.out.println("Enter player 2 name:");
            player2Name = sc.nextLine();
            System.out.println("Player [" + player1Name + "] choose color\n" +
                    "White → Press [W]\n" +
                    "Black → Press [B]\n");
            color = e.chooseColor();
            player1 = new Player(player1Name, color);
            if(color==Color.BLACK)
                player2 = new Player(player2Name, Color.WHITE);
            else
                player2 = new Player(player2Name, Color.BLACK);
            t.placePieces(color);

            System.out.println(t + "\n");

            System.out.println(player1.getName() + "'s turn -> " + player1.getColor());
            System.out.println("Which piece do you want to move?");
            System.out.println("Enter a coordinate:\n");

            System.out.println(t);

        }




//        t.getCelda(new Coordenada('D', 7)).getPiece().moveTo(new Coordenada('D', 5));
//        t.getCelda(new Coordenada('D', 2)).getPiece().moveTo(new Coordenada('D', 4));
//        t.getCelda(new Coordenada('E', 2)).getPiece().moveTo(new Coordenada('E', 3));
//        t.getCelda(new Coordenada('F', 2)).getPiece().moveTo(new Coordenada('F', 4));
//        t.getCelda(new Coordenada('E', 7)).getPiece().moveTo(new Coordenada('E', 5));
//        t.getCelda(new Coordenada('H', 1)).getPiece().moveTo(new Coordenada('H', 5));
//
//
//        ListaSE coordenadas = t.getCelda(new Coordenada('E',5)).getPiece().getNextMoves();
//        t.highlight(coordenadas);
//        System.out.println(t);
//
//        System.out.print("Coordenadas: ");
//        for(Coordenada c : coordenadas.toArray()) {
//            System.out.print(c + " ");
//        }
//
//        System.out.println("\n");
//
//        t.getCelda(new Coordenada('E', 5)).getPiece().moveTo(new Coordenada('F', 4));
//        t.resetColors();
//        coordenadas = t.getCelda(new Coordenada('F',4)).getPiece().getNextMoves();
//        t.highlight(coordenadas);
//        System.out.println(t);
//
//        System.out.print("Coordenadas: ");
//        for(Coordenada c : coordenadas.toArray()) {
//            System.out.print(c + " ");
//        }

    }


}