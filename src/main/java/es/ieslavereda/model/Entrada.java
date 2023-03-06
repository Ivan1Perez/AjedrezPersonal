package es.ieslavereda.model;

import java.io.IOException;
import java.util.Scanner;

public class Entrada {

    public Entrada(){

        System.out.println("Start game?\n" +
                "Yes → Press [Y]\n" +
                "No → Press [N]");

    }

    public boolean getEmpezar(){
        Scanner sc = new Scanner(System.in);
        String respuesta;
        boolean correcto = false;

        do{
            respuesta = sc.nextLine();
            if(!respuesta.equalsIgnoreCase("Y") && !respuesta.equalsIgnoreCase("N"))
                System.out.println("Wrong answer. Enter [Y] or [N]:");
            else
                correcto = true;
        }while(!correcto);

        return respuesta.equalsIgnoreCase("y");
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
        String respuesta, example = "";
        String col;
        int row;
        boolean correcto = false;

        do {
            respuesta = sc.nextLine();
            col = String.valueOf(respuesta.charAt(0));
            row = Integer.parseInt(String.valueOf(respuesta.charAt(1)));

            if (respuesta.length() == 2)
                if(!(respuesta.toUpperCase().charAt(0)>'H' || respuesta.toUpperCase().charAt(0)<'A'))
                    if (!(row > 8 || row < 1))
                        correcto = true;
            if(!correcto) {
                example = "'" + (char) Tools.random(72, 65) + Tools.random(9, 1) + "'";
                System.out.println("Error. You have to use the following format: " + example + "\n" +
                        "Column: from [A] to [H]\n" +
                        "Row: from [1] to [9]");
            }

        }while(!correcto);

        return new Coordenada(col.charAt(0), row);
    }


}
