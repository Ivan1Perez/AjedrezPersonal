package es.ieslavereda.model;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {

    private Entrada e;
    private Tablero t;
    private String player1Name, player2Name;
    private Color color;
    private Player player1, player2;
    private Set<Coordenada> coordenadas;
    Coordenada coordenada;
    private boolean movementDone;

    public Game() {

        e = new Entrada();
        movementDone = true;

    }

    public boolean isMovementDone() {
        return movementDone;
    }

    public void setMovementDone(boolean movementDone) {
        this.movementDone = movementDone;
    }

    public void start(){
        boolean start = e.getEmpezar();

        if (start) {
            t = new Tablero();
            insertNames();

            MatchScreen.printBoard(t);

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
        MatchScreen.chooseColorMessage(player1Name);

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
            if(turnCounter==0) {
                if (player1.getColor() == Color.WHITE)
                    MatchScreen.turnMessage(player1, isMovementDone());
                else {
                    MatchScreen.turnMessage(player2, isMovementDone());
                    color = Color.WHITE;
                }
            }else if(color==player1.getColor()){
                MatchScreen.turnMessage(player1, isMovementDone());
            }
            else
                MatchScreen.turnMessage(player2, isMovementDone());

            do {
                turn();
            }while(coordenadas.size()==0);

            if(!movementDone)
                continue;

            color = color.next();
            turnCounter++;
        }while(!end);
    }

    public void turn(){
        selectCell();

        if(coordenadas.size()==0)
            MatchScreen.noMovesAvailableMessage();
        else {
            t.highlight(coordenadas);
            MatchScreen.printBoard(t);
            //A continuación el usuairo selecciona el movimiento o cancela el mover esa pieza
            selectMovement();
            t.resetColors();
            MatchScreen.printBoard(t);
        }

    }

    public void selectCell(){
        Celda celda;

        do {
            coordenada = e.enterCoordenada();
            celda = t.getCelda(coordenada);
            if(celda.isEmpty()) {
                MatchScreen.emptyMessage();
                celda = null;
            }
            else if (celda.getPiece().getColor() != color) {
                MatchScreen.enemyPieceMessage();
                celda = null;
            }

        }while(celda==null);

        coordenadas = new HashSet<>(celda.getPiece().getNextMoves());

    }

    public void selectMovement(){
        Piece piece;
        boolean firstTry = true;
        Coordenada coordenadaEncontrada = null, coordenadaAux;

        do{
            MatchScreen.whereToMoveMessage(coordenadas, firstTry);
            //Si la coordenada es null significa que se ha pulsado 'C' (cancelar).
            coordenadaAux = e.enterCoordenada();
            if(coordenadaAux!=null){
                if(coordenadas.contains(coordenadaAux)){
                    coordenadaEncontrada = coordenadaAux;
                }
                else
                    System.out.println("Error. Please, select one of the possible moves.");

                firstTry = false;
            }

        }while(coordenadaEncontrada==null && coordenadaAux!=null);

        if(coordenadaEncontrada!=null) {
            if(!(t.getCelda(coordenadaEncontrada).isEmpty())) {
                piece = t.getCelda(coordenadaEncontrada).getPiece();
                addKilledPiece(piece);
            }
            t.getCelda(coordenada).getPiece().moveTo(coordenadaEncontrada);
            setMovementDone(true);
        }else
            setMovementDone(false);

    }

    public void addKilledPiece(Piece piece){
        t.getDeletedPieces().add(piece);

        if(piece instanceof Reina) {
            if (piece instanceof ReinaBlanca)
                ReinaBlanca.setDeadReinaBlanca(true);
            else if (piece instanceof ReinaNegra)
                ReinaNegra.setDeadReinaNegra(true);
        }
    }

}
