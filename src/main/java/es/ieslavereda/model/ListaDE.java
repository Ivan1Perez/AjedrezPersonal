package es.ieslavereda.model;

public class ListaDE<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public ListaDE(){

        size = 0;
        head = null;
        tail = null;

    }

    public int getSize() {
        return size;
    }

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

    public String toStringReverse() {
        String output = "ListaDE{ Size: " + size + ", Values: ";
        Node<T> aux = tail;
        while (aux!=null){
            output+=aux + " ";
            aux = aux.getPrevious();
        }

        return output +"}";
    }

     class Node<T>{

        private final T info;
        private Node<T> next;
        private Node<T> previous;

        public Node(T info) {

            this.info = info;

        }

        public T getInfo() {
            return info;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public Node<T> getNext(){
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }

        @Override
        public String toString() {
            return ""+info;
        }
    }

}
