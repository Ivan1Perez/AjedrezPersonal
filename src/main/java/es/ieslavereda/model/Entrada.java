package es.ieslavereda.model;

import java.io.IOException;
import java.util.List;
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
        String col = "";
        int row = 0;
        char secondChar;
        boolean correcto = false;

        do {
            respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("C")) {
                return null;
            }

            if (respuesta.length() != 2) {
                System.out.println("Error: the input must have exactly 2 characters.");
                continue;
            }

            col = String.valueOf(respuesta.charAt(0)).toUpperCase();
            secondChar = respuesta.charAt(1);

            if (col.charAt(0) < 'A' || col.charAt(0) > 'H') {
                System.out.println("Error: the first character must be a letter between A and H.");
                continue;
            }

            if (secondChar < '1' || secondChar > '8') {
                System.out.println("Error: the second character must be a number between 1 and 8.");
                continue;
            }

            row = Character.getNumericValue(secondChar);
            correcto = true;

        } while (!correcto);

        return new Coordenada(col.charAt(0), row);
    }

    public static Piece selectDeletedPiece(List<Piece> pieces){
        Scanner scanner = new Scanner(System.in);
        String input = "";

        int minNumber =0, maxNumber = pieces.size()-1, selectedNumber = 0;
        boolean correct = false;

        while (!correct) {

            input = scanner.nextLine();

            try {
                selectedNumber = Integer.parseInt(input);

                if (selectedNumber < minNumber || selectedNumber > maxNumber) {
                    System.out.println("The number selected must be in between " + minNumber +
                            " and "+  maxNumber + ". Please, try again:");
                }else
                    correct = true;

            } catch (NumberFormatException e) {
                System.out.println("Just numbers allowed here. Try again:");
            }
        }

        return pieces.get(selectedNumber);
    }

    public static String yesOrNotAnswer(){
        Scanner sc = new Scanner(System.in);
        String respuesta = sc.nextLine();

        while(!respuesta.equalsIgnoreCase("Y") && !respuesta.equalsIgnoreCase("N")){
            System.out.println("Wrong answer. Enter [Y] or [N]");
            respuesta = sc.nextLine();
        }

        return respuesta;
    }

}
