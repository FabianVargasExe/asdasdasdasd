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
public class Mensaje {
    
    private String Asunto;
    private String Mensaje;
    private String Emisor;
    private String Destinatario;
    private String Fecha;
    private String hora;

    public Mensaje(String Asunto, String Mensaje, String Emisor, String Destinatario, String Fecha, String hora) {
        this.Asunto = Asunto;
        this.Mensaje = Mensaje;
        this.Emisor = Emisor;
        this.Destinatario = Destinatario;
        this.Fecha = Fecha;
        this.hora = hora;
    }

    public String getAsunto() {
        return Asunto;
    }

    public void setAsunto(String Asunto) {
        this.Asunto = Asunto;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

    public String getEmisor() {
        return Emisor;
    }

    public void setEmisor(String Emisor) {
        this.Emisor = Emisor;
    }

    public String getDestinatario() {
        return Destinatario;
    }

    public void setDestinatario(String Destinatario) {
        this.Destinatario = Destinatario;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    

    
    
    
}
