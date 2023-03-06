package es.ieslavereda.model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {

    private Entrada e;
    private Tablero t;
    private String player1Name, player2Name;
    private Color color;
    private final Color startingcolor = Color.WHITE;
    private Player player1, player2;
    private Set<Coordenada> coordenadas;
    private Coordenada coordenada;
    private MatchScreen matchScreen;

    public Game() {

        e = new Entrada();

    }

    public void start(){
        boolean start = e.getEmpezar();

        if (start) {
            t = new Tablero();
            matchScreen = new MatchScreen();
            insertNames();

            System.out.println(t + "\n");

            match();
        }
    }

    public void insertNames(){
        Scanner sc = new Scanner (System.in);

        System.out.println("Enter player 1 name:");
        player1Name = sc.nextLine();
        System.out.println("Enter player 2 name:");
        player2Name = sc.nextLine();

        chooseColor();
    }

    public void chooseColor(){
        matchScreen.chooseColorMessage(player1Name);

        color = e.chooseColor();
        player1 = new Player(player1Name, color);
        if (color == Color.BLACK)
            player2 = new Player(player2Name, Color.WHITE);
        else
            player2 = new Player(player2Name, Color.BLACK);

        t.placePieces(color);
    }

    public void match(){
        boolean end = false;
        int turnCounter = 0;

        do {
            if(turnCounter==0)


            if(color==player1.getColor()){
                matchScreen.turn(player1);
            }
            else
                matchScreen.turn(player2);

            do {
                t.resetColors();
                turn();

                if(coordenadas.size()==0)
                    matchScreen.noMovesAvailableMessage();
                else {
                    t.highlight(coordenadas);
                    System.out.println(t + "\n");
                }
            }while(coordenadas.size()==0);

            color = color.next();

            turnCounter++;
        }while(!end);
    }

    public void turn(){
        Celda celda;

        do {
            coordenada = e.enterCoordenada();
            celda = t.getCelda(coordenada);
            if(celda.isEmpty()) {
                matchScreen.emptyMessage();
                celda = null;
            }
            else if (celda.getPiece().getColor() != color) {
                matchScreen.enemyPieceMessage();
                celda = null;
            }

        }while(celda==null);

        coordenadas = new HashSet<>(celda.getPiece().getNextMoves());

    }

}
