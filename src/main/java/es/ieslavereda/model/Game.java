package es.ieslavereda.model;

import java.util.*;

/**
 * The type Game.
 */
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

    private Map<Celda, Set<Coordenada>> availableMoves;

    /**
     * Instantiates a new Game.
     */
    public Game() {

        e = new Entrada();
        movementDone = true;
        kingOnTarget = false;
        colorKingOnTarget = null;
        availableMoves = new HashMap<>();
        end = false;

    }

    /**
     * Returns true if the movement is done and false if not.
     *
     * @return the boolean
     */
    public boolean isMovementDone() {
        return movementDone;
    }

    /**
     * Sets movement done.
     *
     * @param movementDone the movement done
     */
    public void setMovementDone(boolean movementDone) {
        this.movementDone = movementDone;
    }

    /**
     * Starts the game.
     */
    public void start(){
        boolean start = e.getEmpezar();

        if (start) {
            t = new Tablero();
            insertNames();

            MatchScreen.printBoard(t);

            match();
        }
    }

    /**
     * Insert the names of the players.
     */
    public void insertNames(){
        Scanner sc = new Scanner (System.in);

        System.out.println("Enter player 1 name:");
        player1Name = sc.nextLine();
        System.out.println("Enter player 2 name:");
        player2Name = sc.nextLine();

        chooseColor();
    }

    /**
     * Gets the color choosen by the first player and sets it for the second one.
     */
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

    /**
     * Match.
     */
    public void match(){
        int turnCounter = 0;
        Color currentPlayerColor;
        Player currentPlayer;
        boolean currentPlayerHasKingOnTarget = false;

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

    /**
     * Turn.
     */
    public void turn(){
        Celda celda = selectCell();

        if(coordenadas.size()==0)
            MatchScreen.noMovesAvailableMessage();
        else {
            t.highlight(coordenadas);
            MatchScreen.printBoard(t);
            //A continuación el usuario selecciona el movimiento o cancela el mover esa pieza
            selectMovement(celda);
            t.resetColors();
            if(movementDone){
                isKingOnTarget(false, t);
                if(kingOnTarget)
                    if(colorKingOnTarget!=color)
                        isCheckmate();
            }
            MatchScreen.printBoard(t);
        }
    }

    /**
     * Select cell celda.
     *
     * @return the celda
     */
    public Celda selectCell(){
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

        return celda;
    }

    /**
     * Select movement.
     *
     * @param celda the celda
     */
    public void selectMovement(Celda celda){
        boolean firstTry = true;
        Coordenada coordenadaEncontrada = null, coordenadaAux;
        Map<Celda, Set<Coordenada>> mapaCoordsAvailable;
        Set<Coordenada> coordenatesOfCellAvailable = new HashSet<>();


        do{
            if(kingOnTarget && colorKingOnTarget == color) {
                mapaCoordsAvailable = new HashMap<>(availableMoves);
                for(Set<Coordenada> coordenadaSet : mapaCoordsAvailable.values())
                    coordenatesOfCellAvailable.addAll(coordenadaSet);
            }else {
                mapaCoordsAvailable = new HashMap<>();
                mapaCoordsAvailable.put(celda, coordenadas);
            }

            MatchScreen.whereToMoveMessage(coordenadas, firstTry);
            //Si la coordenada es null significa que se ha pulsado 'C' (cancelar).
            coordenadaAux = e.enterCoordenada();
            if(coordenadaAux!=null){
                if(mapaCoordsAvailable.containsKey(celda)){
                    for(Coordenada coordenadaSet1 : mapaCoordsAvailable.get(celda)) {
                        if (coordenadaAux.equals(coordenadaSet1))
                            coordenadaEncontrada = coordenadaAux;
                        else
                            System.out.println("The king is in check. You have to select another movement or another piece.");
                    }
                }else {
                    if (kingOnTarget && colorKingOnTarget == color)
                        System.out.println("The king is in check. You have to select another movement or another piece.");
                }

                firstTry = false;
            } else{
                System.out.println("Error. Please, select one of the possible moves.");
            }

        }while(coordenadaEncontrada==null && coordenadaAux!=null);

        if(coordenadaEncontrada!=null) {
            placeMovement(coordenadaEncontrada);
            t.getCelda(coordenada).getPiece().moveTo(coordenadaEncontrada);
            setMovementDone(true);
        }else
            setMovementDone(false);

    }

    /**
     * Place movement.
     *
     * @param coordenada the coordenada
     */
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

    /**
     * Is king on target.
     *
     * @param checkMateOnUse the check mate on use
     * @param tablero        the tablero
     */
    public void isKingOnTarget(boolean checkMateOnUse, Tablero tablero){
        Map<Coordenada, Celda> mapaTablero = new HashMap<>(tablero.getMapaTablero());
        Celda celda;
        Coordenada coordendaRey = null;
        List<Coordenada> allPossibleMovesByColor = filterCoordenatesByColor();
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
                if(!checkMateOnUse)
                    t.highlightKing(c1);
                kingFound = true;
            }

        if (kingFound)
            kingOnTarget = true;
        else
            kingOnTarget = false;

    }

    /**
     * Filter coordenates by color list.
     *
     * @return the list
     */
    public List<Coordenada> filterCoordenatesByColor(){
        List<Coordenada> allPossibleMovesByColor = new ArrayList<>();

        for(Celda c : t.getMapaTablero().values()){
            if(c.getPiece()!=null)
                //Obtenemos todos los posibles movimientos de las piezas del color en turno
                if(c.getPiece().getColor()==color)
                    allPossibleMovesByColor.addAll(c.getPiece().getNextMoves());
        }

        return allPossibleMovesByColor;
    }

    /**
     * Is checkmate.
     */
    public void isCheckmate() {
//----------------------------------------------------------------------------------------------------------------
        //Instanciamos nuevo tablero con las posiciones de las piezas como se encuentran ahora
        Tablero tableroAux = new Tablero();
        tableroAux.setMapaTablero(t.getMapaTablero());
//----------------------------------------------------------------------------------------------------------------
        Map<Celda, Set<Coordenada>> cellsMovementsByColor = new HashMap<>(getEveryCellMovementsByColor());
        Coordenada originalPosition;
        Set<Coordenada> possibleMovesOfCellByColor;
        Piece piece;
        boolean notCheckMate = false;
        Map<Celda, Set<Coordenada>> availableMovesByCells = new HashMap<>();
        Set<Coordenada> coordenateSet;

        // Realizamos cada uno de los movimientos del jugador contrario
        // y verificamos si el rey sigue en jaque después de cada uno de ellos

        for (Celda celda : cellsMovementsByColor.keySet()) {
            possibleMovesOfCellByColor = cellsMovementsByColor.get(celda);
            originalPosition = celda.getCoordenada();
            coordenateSet = new HashSet<>();

            // Iteramos sobre las coordenadas y realizamos cada movimiento en un tablero auxiliar
            for (Coordenada coord : possibleMovesOfCellByColor) {
                if (!(tableroAux.getMapaTablero().get(celda.getCoordenada()).isEmpty())) {
                    piece = tableroAux.getMapaTablero().get(celda.getCoordenada()).getPiece();
                    piece.moveTo(coord);

                    // Verificamos si el rey sigue en jaque después del movimiento
                    isKingOnTarget(true, tableroAux);
                    if (!kingOnTarget) {
                        notCheckMate = true;
                        coordenateSet.add(coord);
                    }
                    //Volvemos a poner esta pieza en la posición en la que estaba.
                    piece.moveTo(originalPosition);
                }
            }
            if (coordenateSet.size() > 0)
                availableMovesByCells.put(celda, coordenateSet);
        }

        // Si en todas las jugadas el rey sigue en jaque, hay jaque mate y se acaba la partida.
        if(notCheckMate){
            kingOnTarget = true;
            availableMoves = new HashMap<>(availableMovesByCells);
        }
        else{
            availableMoves = new HashMap<>();
            end = true;
        }

    }

    /**
     * Get every cell movements by color map.
     *
     * @return the map
     */
    public Map<Celda, Set<Coordenada>> getEveryCellMovementsByColor(){
        Map<Celda, Set<Coordenada>> cellsMovementsByColor = new HashMap<>();

        for(Celda celda : t.getMapaTablero().values()){
            if(celda.getPiece()!=null && celda.getPiece().getColor()!=color)
                cellsMovementsByColor.put(celda, celda.getPiece().getNextMoves());
        }

        return cellsMovementsByColor;
    }

}
