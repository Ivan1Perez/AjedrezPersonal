package es.ieslavereda.model;

public final class ReinaBlanca extends Reina{

    public static boolean deadReinaBlanca;

    public ReinaBlanca(Celda celda){
        super(PieceType.WHITE_REINA, celda);
        deadReinaBlanca = false;
    }

    public static boolean isDeadReinaBlanca() {
        return deadReinaBlanca;
    }

    public static void setDeadReinaBlanca(boolean deadReinaBlanca) {
        ReinaBlanca.deadReinaBlanca = deadReinaBlanca;
    }
}
