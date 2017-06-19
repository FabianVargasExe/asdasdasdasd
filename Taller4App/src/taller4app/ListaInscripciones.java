
package taller4app;


public class ListaInscripciones {
    
    private NodoInscripcion first;
    
    public ListaInscripciones() {
        first = null;
    }
    
    public void ingresar(Inscripcion m) {
        NodoInscripcion curr = new NodoInscripcion(m);
        if(first == null) {
            first = curr;
        } else {
            NodoInscripcion prev = first;
            while( prev.getNext() != first) {
                prev = prev.getNext();
            }
            prev.setNext(curr);
        }
        curr.setNext(first);
    }
    
    public NodoInscripcion getFirst() {
        return first;
    }
}
