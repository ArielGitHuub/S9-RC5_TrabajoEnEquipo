package ElcolchonFeliz;

public class Habitacion {
    private int numero;
    private String tipo;
    private boolean disponible;
    private String ocupante;
    private String fechaIngreso;
    private String fechaSalida;

    public Habitacion(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.disponible = true;
        this.ocupante = null;
        this.fechaIngreso = null;
        this.fechaSalida = null;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public String getOcupante() {
        return ocupante;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void ocupar(String cliente, String fechaIngreso, String fechaSalida) {
        this.disponible = false;
        this.ocupante = cliente;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
    }
}
