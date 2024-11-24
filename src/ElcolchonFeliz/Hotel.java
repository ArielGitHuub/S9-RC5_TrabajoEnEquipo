package ElcolchonFeliz;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Habitacion> habitaciones;
    private List<Reserva> reservas;

    public Hotel() {
        this.habitaciones = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    public boolean crearReservaPorTipo(String cliente, String tipoHabitacion, String fechaIngreso, String fechaSalida) {
        Habitacion habitacion = buscarHabitacionPorTipo(tipoHabitacion);
        if (habitacion != null) {
            reservas.add(new Reserva(cliente, habitacion, fechaIngreso, fechaSalida));
            return true;
        }
        return false;
    }

    private Habitacion buscarHabitacionPorTipo(String tipo) {
        for (Habitacion h : habitaciones) {
            if (h.isDisponible() && h.getTipo().equalsIgnoreCase(tipo)) {
                return h;
            }
        }
        return null;
    }

    public void mostrarEstadoHabitaciones() {
        System.out.println("\nEstado actual de las habitaciones:");
        for (Habitacion h : habitaciones) {
            if (h.isDisponible()) {
                System.out.printf("Habitación %d (%s) - Disponible%n", h.getNumero(), h.getTipo());
            } else {
                System.out.printf("Habitación %d (%s) - Ocupada por: %s, Fecha de ingreso: %s, Fecha de salida: %s%n",
                        h.getNumero(),
                        h.getTipo(),
                        h.getOcupante(),
                        h.getFechaIngreso(),
                        h.getFechaSalida());
            }
        }
    }
}
