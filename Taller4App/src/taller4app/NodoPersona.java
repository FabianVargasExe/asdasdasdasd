


package taller4app;


public class NodoPersona {
    
    Persona persona;
    private NodoPersona next;
    private NodoPersona prev;

    public NodoPersona(Persona persona) {
        this.persona = persona;
        next = null;
        prev = null;
    }

    public Persona getPersona() {
        return persona;
    }
    public NodoPersona getNext() {
        return next;
    }

    public void setNext(NodoPersona next) {
        this.next = next;
    }

    public NodoPersona getPrev() {
        return prev;
    }

    public void setPrev(NodoPersona prev) {
        this.prev = prev;
    } 
    
}
