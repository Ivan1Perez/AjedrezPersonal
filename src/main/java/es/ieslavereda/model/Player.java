package es.ieslavereda.model;

/**
 * The type Player.
 */
public class Player {

    /**
     * The Name.
     */
    String name;
    /**
     * The Color.
     */
    Color color;

    /**
     * Instantiates a new Player.
     *
     * @param name  the name
     * @param color the color
     */
    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
