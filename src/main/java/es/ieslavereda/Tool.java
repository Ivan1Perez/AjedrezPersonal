package es.ieslavereda;

import es.ieslavereda.model.Coordenada;

/**
 * The type Tool.
 */
public class Tool {

    /**
     * Add coordenada [ ].
     *
     * @param coordenadas the coordenadas
     * @param coordenada  the coordenada
     * @return the coordenada [ ]
     */
    public static Coordenada[] add(Coordenada[] coordenadas, Coordenada coordenada){
        Coordenada[] aux = new Coordenada[coordenadas.length+1];
        for(int i=0;i<coordenadas.length;i++)
            aux[i]=coordenadas[i];

        aux[aux.length-1]=coordenada;
        return aux;
    }

    /**
     * Merge coordenada [ ].
     *
     * @param c1 the c 1
     * @param c2 the c 2
     * @return the coordenada [ ]
     */
    public static Coordenada[]  merge(Coordenada[] c1,Coordenada[] c2){
        Coordenada[] aux = new Coordenada[c1.length+c2.length];
        for(int i=0;i<c1.length;i++)
            aux[i]=c1[i];
        for(int i=0;i<c2.length;i++)
            aux[c1.length+i]=c2[i];
        return aux;
    }

}
