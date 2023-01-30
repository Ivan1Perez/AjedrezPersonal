package es.ieslavereda.model;

public class ListaDE {

    private int size;
    private Node head;
    private Node tail;

    public ListaDE(){

        size = 0;
        head = null;
        tail = null;

    }

    public void addHead(Piece piece){
        Node node = new Node(piece);

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

    public void addTail(Piece piece){
        Node node = new Node(piece);

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

    public Piece removeHead(){
        Piece piece = head.getInfo();

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

        return piece;
    }

    public Piece removeTail(){
        Piece piece = tail.getInfo();

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

        return piece;
    }


    public int count(Piece.PieceType pieceType){
        Node aux = head;
        int count = 0;

        while(aux!=null){
            if(aux.getInfo().getShape()==pieceType){
                count++;
            }
            aux = aux.getNext();
        }

        return count;
    }

    @Override
    public String toString() {
        String output = "ListaDE{ Size: " + size + ", Values: ";
        Node aux = head;
        while (aux!=null){
            output+=aux + " ";
            aux = aux.getNext();
        }

        return output +"}";
    }

    public String toStringReverse() {
        String output = "ListaDE{ Size: " + size + ", Values: ";
        Node aux = tail;
        while (aux!=null){
            output+=aux + " ";
            aux = aux.getPrevious();
        }

        return output +"}";
    }

    class Node{

        private Piece info;
        private Node next;
        private Node previous;

        public Node(Piece info) {

            this.info = info;

        }

        public Piece getInfo() {
            return info;
        }

        public Node getPrevious() {
            return previous;
        }

        public Node getNext(){
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        @Override
        public String toString() {
            return ""+info;
        }
    }

}
