package es.ieslavereda.model;

import java.util.Scanner;

public class Entrada {

    public Entrada(){
    }

    public String getEmpezar(){
        Scanner sc = new Scanner(System.in);
        String respuesta = sc.nextLine();

        while(!respuesta.equalsIgnoreCase("Y") && !respuesta.equalsIgnoreCase("N")){
            System.out.println("Respuesta incorrecta. Has de pulsar [Y] o [N]");
            respuesta = sc.nextLine();
        }

        return respuesta;
    }

}
