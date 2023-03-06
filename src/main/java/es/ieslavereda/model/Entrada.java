package es.ieslavereda.model;

import java.io.IOException;
import java.util.Scanner;

public class Entrada {

    public Entrada(){

        System.out.println("Start game?\n" +
                "Yes → Press [Y]\n" +
                "No → Press [N]");

    }

    public String getEmpezar(){
        Scanner sc = new Scanner(System.in);
        String respuesta = sc.nextLine();

        while(!respuesta.equalsIgnoreCase("Y") && !respuesta.equalsIgnoreCase("N")){
            System.out.println("Wrong answer. Enter [Y] or [N]");
            respuesta = sc.nextLine();
        }

        return respuesta;
    }

    public Color chooseColor(){
        Scanner sc = new Scanner(System.in);
        String respuesta = sc.nextLine();
        Color color;

        while(!respuesta.equalsIgnoreCase("W") && !respuesta.equalsIgnoreCase("B")){
            System.out.println("Wrong answer. Enter [W] or [B]");
            respuesta = sc.nextLine();
        }

        if(respuesta.equalsIgnoreCase("w"))
            color = Color.WHITE;
        else
            color = Color.BLACK;

        return color;
    }

    public Coordenada enterCoordenada(){
        Scanner sc = new Scanner(System.in);
        Coordenada coordenada;
        String respuesta;
        String col;
        int row;
        boolean correcto = false;

        do {
            respuesta = sc.nextLine();
            col = String.valueOf(respuesta.charAt(0));
            row = respuesta.charAt(1);

            if (respuesta.length() == 2)
                if(!(respuesta.toLowerCase().charAt(0)>'H' || respuesta.toLowerCase().charAt(0)<'A'))
                    if (!(respuesta.charAt(1) > 8 || respuesta.charAt(1) < 1))
                        correcto = true;
            else
                System.out.println("Error. Just one letter and one number allowed. Please try again.");

        }while(!correcto);


        return coordenada = new Coordenada(col.charAt(0), row);
    }


}
