package es.ieslavereda.model;

public final class ReinaNegra extends Reina{

    public static boolean deadReinaNegra;

    public ReinaNegra(Celda celda) {
        super(PieceType.BLACK_REINA, celda);
    }

    public static boolean isDeadReinaNegra() {
        return deadReinaNegra;
    }

    public static void setDeadReinaNegra(boolean deadReinaNegra) {
        ReinaNegra.deadReinaNegra = deadReinaNegra;
    }
}
