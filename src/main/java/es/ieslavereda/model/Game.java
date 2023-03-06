package es.ieslavereda.model;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {

    Entrada e;
    Tablero t;
    String player1Name, player2Name;
    Color color;
    Player player1, player2;
    Set<Coordenada> coordenadas;
    Coordenada coordenada;

    public Game() {

        e = new Entrada();

    }

    public void start(){
        e.getEmpezar();

        if (e.getEmpezar().equalsIgnoreCase("y")) {
            t = new Tablero();
            insertNames();


            System.out.println("Player [" + player1Name + "] choose color\n" +
                    "White → Press [W]\n" +
                    "Black → Press [B]\n");
            color = e.chooseColor();
            player1 = new Player(player1Name, color);
            if (color == Color.BLACK)
                player2 = new Player(player2Name, Color.WHITE);
            else
                player2 = new Player(player2Name, Color.BLACK);
            t.placePieces(color);

            System.out.println(t + "\n");

            System.out.println(player1.getName() + "'s turn -> " + player1.getColor());
            System.out.println("Which piece do you want to move?");
            System.out.println("Enter a coordinate:");
            coordenada = e.enterCoordenada();
            coordenadas = t.getCelda(coordenada).getPiece().getNextMoves();
            t.highlight(coordenadas);


            System.out.println(t);

        }
    }

    public void insertNames(){
        Scanner sc = new Scanner (System.in);

        System.out.println("Enter player 1 name:");
        player1Name = sc.nextLine();
        System.out.println("Enter player 2 name:");
        player2Name = sc.nextLine();

    }

    public void chooseColor(){

    }
}
