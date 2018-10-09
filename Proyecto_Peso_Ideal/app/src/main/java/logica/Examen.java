package logica;

public class Examen {

    private String nombre;
    private int    edad;
    private int    pesoActual;
    private int    pesoIdeal;
    private String estadoPeso;

    public String desidirEstadoPeso(){

        pesoIdeal = edad*2+8;

        if (pesoActual == pesoIdeal){

            estadoPeso = "en tu peso ideal";

        } else {

            if (pesoActual < pesoIdeal){

                estadoPeso = "bajo tu peso ideal";

            }else {

                estadoPeso = "sobre tu peso ideal";

            }

        }

        return estadoPeso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(int pesoActual) {
        this.pesoActual = pesoActual;
    }

    public int getPesoIdeal(){
        return pesoIdeal;
    }

    public void setPesoIdeal(){
        this.pesoIdeal = pesoIdeal;
    }

    public String getEstadoPeso(){
        return estadoPeso;
    }

    public void setEstadoPeso(){
        this.estadoPeso = estadoPeso;
    }

}
