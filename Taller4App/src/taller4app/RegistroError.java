


package taller4app;


public class RegistroError {
    
    private String Categoria;
    private String Campo;
    private String ValorCampo;
    private int tipo;

    public RegistroError(String Categoria, String Campo, String ValorCampo, int tipo) {
        this.Categoria = Categoria;
        this.Campo = Campo;
        this.ValorCampo = ValorCampo;
    }
    public String errorEncontrato(){
        if (tipo == 1){
            return "El rut no es valido";
        }
        if (tipo == 2){
            return "El codigo no es numerico";
        }
        if (tipo == 3){
            return "El Correo no es valido";
        }
        if (tipo == 4){
            return "El rut no es valido (No es numerico)";
        }
       
        
        return Categoria;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getCampo() {
        return Campo;
    }

    public void setCampo(String Campo) {
        this.Campo = Campo;
    }

    public String getValorCampo() {
        return ValorCampo;
    }

    public void setValorCampo(String ValorCampo) {
        this.ValorCampo = ValorCampo;
    }
    
    
    
}
