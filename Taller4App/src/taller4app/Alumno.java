/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4app;

/**
 *
 * @author favya
 */
public class Alumno extends Persona{
    
    private int CantAsignaturas;
    private int CantMsjEnviadosProfe;
    

    public Alumno(String rut, String nombre, String apellido, String correo, String Alias, int CantAsignaturas, int CantMsjEnviadosProfe ) {
        super(rut, nombre, apellido, correo, Alias);
        this.CantAsignaturas = CantAsignaturas;
        this.CantMsjEnviadosProfe = CantMsjEnviadosProfe;
  
    }

    public int getCantAsignaturas() {
        return CantAsignaturas;
    }

    public void setCantAsignaturas(int CantAsignaturas) {
        this.CantAsignaturas = CantAsignaturas;
    }

    public int getCantMsjEnviadosProfe() {
        return CantMsjEnviadosProfe;
    }

    public void setCantMsjEnviadosProfe(int CantMsjEnviadosProfe) {
        this.CantMsjEnviadosProfe = CantMsjEnviadosProfe;
    }
    

}
