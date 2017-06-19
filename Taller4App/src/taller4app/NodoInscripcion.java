

package taller4app;


public class NodoInscripcion {
    

    private Inscripcion inscripcion;   
    private NodoInscripcion next; 


    public NodoInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
        next = null;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    public NodoInscripcion getNext() {
        return next;
    }

    public void setNext(NodoInscripcion next) {
        this.next = next;
    }
  
}


