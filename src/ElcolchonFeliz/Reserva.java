package ElcolchonFeliz;

public class Reserva {
    private String cliente;
    private Habitacion habitacion;
    private String fechaIngreso;
    private String fechaSalida;

    public Reserva(String cliente, Habitacion habitacion, String fechaIngreso, String fechaSalida) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        habitacion.ocupar(cliente, fechaIngreso, fechaSalida);
    }

    @Override
    public String toString() {
        return String.format(
                "Reserva para: %s\nHabitación: %s\nFecha de ingreso: %s\nFecha de salida: %s",
                cliente, habitacion, fechaIngreso, fechaSalida);
        }
    }