package es.ieslavereda.model;

/**
 * The type Lista de.
 *
 * @param <T> the type parameter
 */
public class ListaDE<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    /**
     * Instantiates a new Lista de.
     */
    public ListaDE(){

        size = 0;
        head = null;
        tail = null;

    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Add head.
     *
     * @param info the info
     */
    public void addHead(T info){
        Node<T> node = new Node<>(info);

        if(head==null){
            head = node;
            tail = node;
        }else{
            node.setNext(head);
            head.setPrevious(node);
            head = node;
        }
        size++;
    }

    /**
     * Add tail.
     *
     * @param info the info
     */
    public void addTail(T info){
        Node<T> node = new Node<>(info);

        if(head==null){
            head = node;
            tail = node;
        }else{
            node.setPrevious(tail);
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    /**
     * Remove head t.
     *
     * @return the t
     */
    public T removeHead(){
        T info = head.getInfo();

        if(head==null){
            return null;
        }
        else if(size==1){
            head = null;
            tail = null;
        }else{
            head = head.getNext();
            head.setPrevious(null);
        }

        size--;

        return info;
    }

    /**
     * Remove tail t.
     *
     * @return the t
     */
    public T removeTail(){
        T info = tail.getInfo();

        if(tail==null){
            return null;
        }
        else if(size==1){
            head = null;
            tail = null;
        }else{
            tail = tail.getPrevious();
            tail.setNext(null);
        }

        size--;

        return info;
    }

    /**
     * Remove piece boolean.
     *
     * @param obj the obj
     * @return the boolean
     */
    public boolean removePiece(T obj){
        if (size==0) {
            return false;
        }
        if (head.getInfo().equals(obj)) {
            head = head.getNext();
            size--;
            return true;
        }
        Node<T> aux = head;
        Node<T> aux2 = head.getNext();
        while (aux2 != null) {
            if (aux2.getInfo().equals(obj)) {
                aux.setNext(aux2.getNext());
                size--;
                return true;
            }
            aux = aux2;
            aux2 = aux2.getNext();
        }
        return false;
    }

//    public int count(Piece.PieceType pieceType){
//        Node<T> aux = head;
//        int count = 0;
//
//        while(aux!=null){
//            if(aux.getInfo().getShape()==pieceType){
//                count++;
//            }
//            aux = aux.getNext();
//        }
//
//        return count;
//    }

    /**
     * Get t.
     *
     * @param index the index
     * @return the t
     */
    public T get(int index){
        if(index>=size || index<0)
            return null;

        Node<T> aux = head;
        while (index>0){
            aux=aux.getNext();
            index--;
        }

        return aux.getInfo();
    }

    @Override
    public String toString() {
        String output = "ListaDE{ Size: " + size + ", Values: ";
        Node<T> aux = head;
        while (aux!=null){
            output+=aux + " ";
            aux = aux.getNext();
        }

        return output +"}";
    }

    /**
     * To string reverse string.
     *
     * @return the string
     */
    public String toStringReverse() {
        String output = "ListaDE{ Size: " + size + ", Values: ";
        Node<T> aux = tail;
        while (aux!=null){
            output+=aux + " ";
            aux = aux.getPrevious();
        }

        return output +"}";
    }

    /**
     * The type Node.
     *
     * @param <T> the type parameter
     */
    static class Node<T>{

        private final T info;
        private Node<T> next;
        private Node<T> previous;

        /**
         * Instantiates a new Node.
         *
         * @param info the info
         */
        public Node(T info) {

            this.info = info;

        }

        /**
         * Gets info.
         *
         * @return the info
         */
        public T getInfo() {
            return info;
        }

        /**
         * Gets previous.
         *
         * @return the previous
         */
        public Node<T> getPrevious() {
            return previous;
        }

        /**
         * Get next node.
         *
         * @return the node
         */
        public Node<T> getNext(){
            return next;
        }

        /**
         * Sets next.
         *
         * @param next the next
         */
        public void setNext(Node<T> next) {
            this.next = next;
        }

        /**
         * Sets previous.
         *
         * @param previous the previous
         */
        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }

//        @Override
//        public boolean equals(Object obj){
//            if(obj instanceof Node){
//                Node<?> aux = (Node<?>)obj;
//                return true;
//            }
//            return false;
//        }

        @Override
        public String toString() {
            return ""+info;
        }
    }

}
