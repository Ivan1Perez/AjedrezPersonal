package es.ieslavereda.model;

public class Tools {

    public static int random(int max, int min) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

}
