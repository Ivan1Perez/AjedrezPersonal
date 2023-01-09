package es.ieslavereda.model;

import com.diogonunes.jcolor.Attribute;
public enum Color {

    BLACK(Attribute.BLACK_TEXT(), Attribute.WHITE_BACK()),
    WHITE(Attribute.TEXT_COLOR(150, 150, 150), Attribute.BLACK_BACK());


    Attribute color;
    Attribute background;
    Color(Attribute color, Attribute background){
        this.color=color;
        this.background = background;
    }

    public Attribute getColor(){
        return color;
    }

    public Attribute getBackground() {
        return background;
    }

    public Color next(){

        if(this.equals(WHITE))
            return BLACK;
        return WHITE;

//        return values()[(ordinal()+1% values().length];

    }
}
