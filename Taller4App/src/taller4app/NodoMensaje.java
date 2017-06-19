

package taller4app;


public class NodoMensaje {
    
    private Mensaje mensaje;
    private NodoMensaje next;
    
    public NodoMensaje(Mensaje mensaje){
       this.mensaje = mensaje;
       next = null;
    }
    
    public Mensaje getMensaje() {
        return mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }

    public NodoMensaje getNext() {
        return next;
    }

    public void setNext(NodoMensaje next) {
        this.next = next;
    }       
}
