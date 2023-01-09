package es.ieslavereda.model;

public class Coordenada {

    private int fila;
    private char col;

    public Coordenada(char col, int fila){
        this.col = Character.toUpperCase(col);
        this.fila = fila;
    }

   public Coordenada up(){
        return new Coordenada(col, fila-1);
   }

   public Coordenada down(){
        return new Coordenada(col, fila +1);
   }

   public Coordenada left(){
        return new Coordenada((char)(col-1), fila);
   }

    public Coordenada right(){
        return new Coordenada((char)(col+1), fila);
    }

    public Coordenada upRight(){
        return up().right();
    }

    public Coordenada upLeft(){
        return up().left();
    }

    public Coordenada downRigth(){
        return down().right();
    }

    public Coordenada downLeft(){
        return down().left();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Coordenada){
            Coordenada c = (Coordenada) obj;
            return col == c.col && fila == c.fila;
        }
        return false;
    }

    @Override
    public String toString(){
        return "(" + col + "," + fila + ")";
    }
}
