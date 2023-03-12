package es.ieslavereda.TAD;

import es.ieslavereda.model.Coordenada;

/**
 * The type Lista se.
 */
public class ListaSE {

    private int size;
    private Node cabeza;
    private Node cola;

    /**
     * Instantiates a new Lista se.
     */
    public ListaSE(){
        size=0;
        cabeza=null;
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty(){
        return cabeza==null;
    }

    /**
     * Size int.
     *
     * @return the int
     */
    public int size(){
        return size;
    }

    /**
     * To array coordenada [ ].
     *
     * @return the coordenada [ ]
     */
    public Coordenada[] toArray(){
        Coordenada[] array = new Coordenada[size];

        Node aux = cabeza;

        for(int i=0;i<size;i++,aux=aux.getNext()){
            array[i]= aux.getInfo();
        }

        return array;
    }

    /**
     * Remove coordenada.
     *
     * @param index the index
     * @return the coordenada
     */
    public Coordenada remove(int index){
        if(index>=size||index<0){
            return null;
        }

        Coordenada value = null;

        if(index==0){
            cabeza = cabeza.getNext();
        }else{
            Node aux = cabeza;
            Node aux2 = cabeza.getNext();

            while(index>1){
                aux=aux2;
                aux2=aux2.getNext();
                index--;
            }
            value = aux2.getInfo();
            aux.setNext(aux2.getNext());
        }

        size--;
        return value;
    }


//    public void addHead(Coordenada numero){
//        Node node = new Node(numero);
//
//        if(cabeza==null) {
//            cabeza = node;
//            cola = node;
//        }else {
//            node.setNext(cabeza);
//            cabeza=node;
//        }
//
//        size++;
//    }

    /**
     * Add tail.
     *
     * @param numero the numero
     */
    public void addTail(Coordenada numero){
        Node node = new Node(numero);

        if(cabeza==null) {
            cabeza = node;
            cola = node;
        }else{
            cola.setNext(node);
            cola = node;
        }
        size++;
    }

    /**
     * Contains boolean.
     *
     * @param numero the numero
     * @return the boolean
     */
    public boolean contains(Coordenada numero){

        boolean encontrado = false;

        Node aux = cabeza;

        while(aux!=null && !encontrado)
            if(aux.getInfo()==numero)
                encontrado = true;
            else
                aux = aux.getNext();

        return encontrado;
    }

    /**
     * Get coordenada.
     *
     * @param index the index
     * @return the coordenada
     */
    public Coordenada get(int index){
        if(index>=size || index<0)
            return null;

        Node aux = cabeza;
        while (index>0){
            aux=aux.getNext();
            index--;
        }

        return aux.getInfo();
    }

    /**
     * Clear.
     */
    public void clear(){
        cabeza =null;
        cola=null;
        size=0;
    }

    /**
     * Add all lista se.
     *
     * @param l the l
     * @return the lista se
     */
    public ListaSE addAll(ListaSE l){

        Node aux = l.cabeza;
        int originalSize = l.size;

        for(int i = 0 ; i < originalSize ; i++, aux = aux.getNext()) {
            addTail(aux.getInfo());
        }
        return this;
    }

//    @Override
//    public boolean equals(Object obj){
//        if(obj instanceof ListaSE){
//            ListaSE l = (ListaSE) obj;
//            if(l.size!=size)
//                return false;
//
//            boolean encontrado = false;
//            Node aux = cabeza;
//            Node aux2 = l.cabeza;
//            while (aux!=null && !encontrado){
//                if(!aux.equals(aux2))
//                    encontrado=true;
//
//                aux = aux.getNext();
//                aux2 = aux2.getNext();
//            }
//
//            return !encontrado;
//        }
//
//        return false;
//    }


    @Override
    public String toString() {
            return "{ size: "+size +", Values: " +((cabeza==null)?"}":cabeza.toString());
    }

}
