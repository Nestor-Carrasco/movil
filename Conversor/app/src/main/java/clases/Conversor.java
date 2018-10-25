package clases;

public class Conversor {

    private double dolar;
    private double tasaDeCambio;
    private double pesosChilenos;

    public double convertir(){
        double pesosChilenos = this.dolar * this.tasaDeCambio;
        return pesosChilenos;
    }
    public double getDolar() {
        return dolar;
    }

    public void setDolar(double dolar) {
        this.dolar = dolar;
    }

    public double getTasaDeCambio() {
        return tasaDeCambio;
    }

    public void setTasaDeCambio(double tasaDeCambio) {
        this.tasaDeCambio = tasaDeCambio;
    }

    public double getPesosChilenos() {
        return pesosChilenos;
    }

    public void setPesosChilenos(double pesosChilenos) {
        this.pesosChilenos = pesosChilenos;
    }


}
