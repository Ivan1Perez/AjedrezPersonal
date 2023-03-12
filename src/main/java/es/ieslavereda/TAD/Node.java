package es.ieslavereda.TAD;

import es.ieslavereda.model.Coordenada;

/**
 * The type Node.
 */
public class Node {

    private Coordenada info;
    private Node next;

    /**
     * Instantiates a new Node.
     *
     * @param info the info
     */
    public Node(Coordenada info){
        this.info = info;
        this.next = null;
    }

    /**
     * Gets info.
     *
     * @return the info
     */
    public Coordenada getInfo() {
        return info;
    }

    /**
     * Sets info.
     *
     * @param info the info
     */
    public void setInfo(Coordenada info) {
        this.info = info;
    }

    /**
     * Gets next.
     *
     * @return the next
     */
    public Node getNext() {
        return next;
    }

    /**
     * Sets next.
     *
     * @param next the next
     */
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
        return info + ((next!=null)?", "+next.toString():"");
    }

}
