package es.ieslavereda.model;

import com.diogonunes.jcolor.Attribute;

/**
 * The enum Color.
 */
public enum Color {
    /**
     * Black color.
     */
    BLACK(Attribute.BLACK_TEXT()),
    /**
     * White color.
     */
    WHITE(Attribute.TEXT_COLOR(255,255,255));

    private Attribute attribute;

    Color(Attribute attribute){
        this.attribute = attribute;
    }

    /**
     * Gets attribute.
     *
     * @return the attribute
     */
    public Attribute getAttribute() {
        return attribute;
    }

    /**
     * Next color.
     *
     * @return the color
     */
    public Color next(){
        if(this.equals(WHITE))
            return BLACK;
        return WHITE;
        //return values()[(ordinal()+1)% values().length];
    }
}
