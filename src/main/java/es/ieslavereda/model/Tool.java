package es.ieslavereda.model;

public class Tool {

    public static Coordenada[] add(Coordenada[] coordenadas, Coordenada coordenada){
        Coordenada[] aux = new Coordenada[coordenadas.length+1];
        for(int i=0;i<coordenadas.length;i++)
            aux[i]=coordenadas[i];

        aux[aux.length-1]=coordenada;
        return aux;
    }

}
