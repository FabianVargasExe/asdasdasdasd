


package taller4app;



public class Inscripcion {
     
    private String Alias;
    private String CodigoAsig;

    public Inscripcion(String Alias, String CodigoAsig) {
        this.Alias = Alias;
        this.CodigoAsig = CodigoAsig;
    }

    public String getAlias() {
        return Alias;
    }

    public void setAlias(String Alias) {
        this.Alias = Alias;
    }

    public String getCodigoAsig() {
        return CodigoAsig;
    }

    public void setCodigoAsig(String CodigoAsig) {
        this.CodigoAsig = CodigoAsig;
    }     
}
