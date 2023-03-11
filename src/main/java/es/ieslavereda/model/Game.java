package es.ieslavereda.model;

import java.util.*;

public class Game {

    private Entrada e;
    private Tablero t;
    private String player1Name, player2Name;
    private Color color;
    private Player player1, player2;
    private Set<Coordenada> coordenadas;
    private Coordenada coordenada;
    private boolean movementDone;
    private boolean kingOnTarget;
    private Color colorKingOnTarget;
    public boolean end;

    public Game() {

        e = new Entrada();
        movementDone = true;
        kingOnTarget = false;
        colorKingOnTarget = null;
        end = false;

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
        int turnCounter = 0;
        Color currentPlayerColor;
        Player currentPlayer;
        boolean currentPlayerHasKingOnTarget;

        do {
            if (turnCounter == 0) {
                currentPlayerColor = player1.getColor();
                currentPlayer = player1;

                if (currentPlayerColor == Color.BLACK) {
                    color = Color.WHITE;
                    currentPlayer = player2;
                }

                MatchScreen.turnMessage(currentPlayer, isMovementDone(), kingOnTarget);
            } else {
                currentPlayer = color == player1.getColor() ? player1 : player2;
                currentPlayerHasKingOnTarget = kingOnTarget && colorKingOnTarget == color;

                MatchScreen.turnMessage(currentPlayer, isMovementDone(), currentPlayerHasKingOnTarget);
            }
            do {
                turn();
            }while(coordenadas.size()==0);

            if(!movementDone)
                continue;

            color = color.next();
            turnCounter++;
        }while(!end);

        MatchScreen.winnerMessage(currentPlayer, turnCounter);

    }

    public void turn(){
        selectCell();

        if(coordenadas.size()==0)
            MatchScreen.noMovesAvailableMessage();
        else {
            t.highlight(coordenadas);
            MatchScreen.printBoard(t);
            //A continuación el usuario selecciona el movimiento o cancela el mover esa pieza
            selectMovement();
            t.resetColors();
            isKingOnTarget();
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
            placeMovement(coordenadaEncontrada);
            t.getCelda(coordenada).getPiece().moveTo(coordenadaEncontrada);
            setMovementDone(true);
        }else
            setMovementDone(false);

    }

    public void placeMovement(Coordenada coordenada){
        Piece piece;
        if(!(t.getCelda(coordenada).isEmpty())) {
            piece = t.getCelda(coordenada).getPiece();
            t.getDeletedPieces().add(piece);
            t.getRemainigPieces().removePiece(piece);
            if(piece instanceof Rey)
                end = true;
        }
    }

    public void isKingOnTarget(){
        Map<Coordenada, Celda> mapaTablero = t.getMapaTablero();
        Celda celda;
        Coordenada coordendaRey = null;
        List<Coordenada> allPossibleMovesByColor = filterCoordenatesByColor(mapaTablero);
        Class<? extends Rey> claseRey;
        boolean kingFound = false;

        //Obtenemos la clase 'ReyBlanco'/'ReyNegro' contrarias al color del jugador en turno
        if (color == Color.WHITE) {
            claseRey = ReyNegro.class;
            colorKingOnTarget = Color.BLACK;
        } else {
            claseRey = ReyBlanco.class;
            colorKingOnTarget = Color.WHITE;
        }

        for(Coordenada c : mapaTablero.keySet()){
            celda = mapaTablero.get(c);
            if(claseRey.isInstance(celda.getPiece())) {
                coordendaRey = c;
            }
        }
        for(Coordenada c1 : allPossibleMovesByColor)
            if (c1.equals(coordendaRey)){
                t.highlightKing(c1);
                kingFound = true;
            }

        if (kingFound)
            kingOnTarget = true;
        else
            kingOnTarget = false;
    }

    public List<Coordenada> filterCoordenatesByColor(Map<Coordenada, Celda> mapaTablero){
        List<Coordenada> allPossibleMovesByColor = new ArrayList<>();

        for(Celda c : mapaTablero.values()){
            if(c.getPiece()!=null)
                //Obtenemos todos los posibles movimientos de las piezas del color en turno
                if(c.getPiece().getColor()==color)
                    allPossibleMovesByColor.addAll(c.getPiece().getNextMoves());
        }

        return allPossibleMovesByColor;
    }

}
