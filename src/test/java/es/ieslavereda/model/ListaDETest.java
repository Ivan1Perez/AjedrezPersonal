//package es.ieslavereda.model;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.function.Executable;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ListaDETest {
//
//    private static Tablero tablero;
//
//    @BeforeAll
//    public static void init(){
//        tablero = new Tablero();
//    }
//
//    @Test
//    void addHead(){
//        ListaDE lista = new ListaDE();
//        lista.addHead(new ReinaBlanca(new Celda(new Coordenada('a', 2),tablero)));
//        lista.addHead(new ReinaNegra(new Celda(new Coordenada('b', 3), tablero)));
//        lista.addHead(new TorreBlanca(new Celda(new Coordenada('c', 5), tablero)));
//        lista.addHead(new TorreNegra(new Celda(new Coordenada('d', 4), tablero)));
//
//        assertDoesNotThrow(new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                System.out.println(lista);
//                System.out.println(lista.toStringReverse());
//            }
//        });
//    }
//
//    @Test
//    void addTail(){
//        ListaDE lista = new ListaDE();
//        lista.addTail(new ReinaBlanca(new Celda(new Coordenada( 'a', 2),tablero)));
//        lista.addTail(new ReinaNegra(new Celda(new Coordenada( 'b', 1),tablero)));
//        lista.addTail(new TorreBlanca(new Celda(new Coordenada( 'c', 3),tablero)));
//        lista.addTail(new TorreNegra(new Celda(new Coordenada( 'd', 4),tablero)));
//
//        assertDoesNotThrow(new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                System.out.println(lista);
//                System.out.println(lista.toStringReverse());
//            }
//        });
//    }
//
//    @Test
//    @DisplayName("Test de la eliminación por la cabeza")
//    void removeHead(){
//        ListaDE lista = new ListaDE();
//        lista.addTail(new ReinaBlanca(new Celda(new Coordenada( 'a', 2),tablero)));
//        lista.addTail(new ReinaNegra(new Celda(new Coordenada( 'b', 1),tablero)));
//        lista.addTail(new TorreBlanca(new Celda(new Coordenada( 'c', 3),tablero)));
//        lista.addTail(new TorreNegra(new Celda(new Coordenada( 'd', 4),tablero)));
//
//        assertDoesNotThrow(new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                System.out.println(lista);
//                System.out.println(lista.toStringReverse());
//                System.out.println(lista.removeHead());
//                System.out.println(lista);
//                System.out.println(lista.toStringReverse());
//                System.out.println(lista.removeHead());
//                System.out.println(lista);
//                System.out.println(lista.toStringReverse());
//                System.out.println(lista.removeHead());
//                System.out.println(lista);
//                System.out.println(lista.toStringReverse());
//                System.out.println(lista.removeHead());
//            }
//        });
//    }
//
//    @Test
//    void count(){
//        ListaDE lista = new ListaDE();
//        lista.addTail(new ReinaBlanca(new Celda(new Coordenada( 'a', 2),tablero)));
//        lista.addTail(new ReinaNegra(new Celda(new Coordenada( 'b', 1),tablero)));
//        lista.addTail(new ReinaNegra(new Celda(new Coordenada( 'b', 1),tablero)));
//        lista.addTail(new TorreBlanca(new Celda(new Coordenada( 'c', 3),tablero)));
//        lista.addTail(new TorreBlanca(new Celda(new Coordenada( 'c', 3),tablero)));
//        lista.addTail(new TorreBlanca(new Celda(new Coordenada( 'c', 3),tablero)));
//
//        assertAll(new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                assertEquals(1, lista.count(Piece.PieceType.WHITE_REINA));
//                assertEquals(2, lista.count(Piece.PieceType.BLACK_REINA));
//                assertEquals(3, lista.count(Piece.PieceType.WHITE_TORRE));
//            }
//        });
//    }
//
//
//}