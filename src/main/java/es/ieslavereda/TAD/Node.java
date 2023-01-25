package es.ieslavereda.TAD;

import es.ieslavereda.model.Coordenada;

public class Node {

    private Coordenada info;
    private Node next;

    public Node(Coordenada info){
        this.info = info;
        this.next = null;
    }

    public Coordenada getInfo() {
        return info;
    }

    public void setInfo(Coordenada info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Node){
            Node aux = (Node)obj;
            return aux.info==info;
        }
        return false;
    }

    @Override
    public String toString() {
        return info + ((next!=null)?" "+next.toString():"");
    }

}
