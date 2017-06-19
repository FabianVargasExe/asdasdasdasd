

package taller4app;


public class Profesor extends Persona{
    
    private int CantMsjRecibidos;
    private int CantMsjEnviados;

    public Profesor(String rut, String nombre, String apellido, String correo, String Alias, int CantMsjRecibidos, int CantMsjEnviados) {
        super(rut, nombre, apellido, correo, Alias);
        this.CantMsjRecibidos = CantMsjRecibidos;
        this.CantMsjEnviados = CantMsjEnviados;
    }

    public int getCantMsjRecibidos() {
        return CantMsjRecibidos;
    }

    public void setCantMsjRecibidos(int CantMsjRecibidos) {
        this.CantMsjRecibidos = CantMsjRecibidos;
    }

    public int getCantMsjEnviados() {
        return CantMsjEnviados;
    }

    public void setCantMsjEnviados(int CantMsjEnviados) {
        this.CantMsjEnviados = CantMsjEnviados;
    }
        
    
}
