package es.ieslavereda.model;

public class Partida {

    private Tablero t;
    private String empezar;

    public Partida(String empezar){
        this.empezar = empezar;

        if(empezar.equalsIgnoreCase("y")){
            System.out.println("Empezando nueva Partida\n");
            this.t = new Tablero();
            System.out.println(t);
        }else
            System.out.println("Hasta luego.");

    }


}
