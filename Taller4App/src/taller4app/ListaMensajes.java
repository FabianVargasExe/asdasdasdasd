

package taller4app;

public class ListaMensajes {
    
    private NodoMensaje first;
    
    public ListaMensajes() {
        first = null;
    }
    
    public void ingresar(Mensaje m) {
        NodoMensaje curr = new NodoMensaje(m);
        if(first == null) {
            first = curr;
        } else {
            NodoMensaje prev = first;
            while( prev.getNext() != first) {
                prev = prev.getNext();
            }
            prev.setNext(curr);
        }
        curr.setNext(first);
    }
    
    // Elimina segun el emisor
    public boolean eliminar(String d) {
        NodoMensaje curr = first;
        NodoMensaje prev = first;
        if(first != null) {
        while( curr.getNext() != first && !curr.getMensaje().getEmisor().equals(d)) {
            prev = curr;
            curr = curr.getNext();
        }
        NodoMensaje ult = first;
        while( ult.getNext() != first) {
            ult = ult.getNext();
        }
        
        if( curr.getMensaje().getEmisor().equals(d)) {
           if( first.getNext() == first) {
               first = null;
               
           } else {
               if ( curr == first ) {
                   first = first.getNext();
                   ult.setNext(first);
                   
                   
               } else {
                   prev.setNext(curr.getNext());
               }
           }
        }
        return true;
    } else {
            return false;
        }
    }
    public NodoMensaje getFirst() {
        return first;
    }
    
}
