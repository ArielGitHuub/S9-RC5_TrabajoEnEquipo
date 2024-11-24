package ElcolchonFeliz;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        hotel.agregarHabitacion(new Habitacion(101, "Individual"));
        hotel.agregarHabitacion(new Habitacion(102, "Individual"));
        hotel.agregarHabitacion(new Habitacion(201, "Doble"));
        hotel.agregarHabitacion(new Habitacion(202, "Doble"));
        hotel.agregarHabitacion(new Habitacion(301, "Suite"));
        hotel.agregarHabitacion(new Habitacion(302, "Suite"));

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nEstado actual del hotel:");
            hotel.mostrarEstadoHabitaciones();

            System.out.print("\nIngrese su nombre: ");
            String nombreCliente = scanner.nextLine();

            String tipoHabitacion = "";
            while (true) {
                System.out.print("Ingrese el tipo de habitación que desea (Individual/Doble/Suite): ");
                tipoHabitacion = scanner.nextLine();
                if (tipoHabitacion.equalsIgnoreCase("Individual") ||
                        tipoHabitacion.equalsIgnoreCase("Doble") ||
                        tipoHabitacion.equalsIgnoreCase("Suite")) {
                    break;
                }
                System.out.println("Tipo de habitación inválido. Por favor, ingrese una opción válida.");
            }

            String fechaIngreso = "";
            while (true) {
                System.out.print("Ingrese la fecha de ingreso (DD-MM-AAAA): ");
                fechaIngreso = scanner.nextLine();
                if (esFechaValida(fechaIngreso)) {
                    break;
                }
                System.out.println("Fecha inválida. Inténtelo de nuevo.");
            }

            String fechaSalida = "";
            while (true) {
                System.out.print("Ingrese la fecha de salida (DD-MM-AAAA): ");
                fechaSalida = scanner.nextLine();
                if (esFechaValida(fechaSalida)) {
                    break;
                }
                System.out.println("Fecha inválida. Inténtelo de nuevo.");
            }

            if (hotel.crearReservaPorTipo(nombreCliente, tipoHabitacion, fechaIngreso, fechaSalida)) {
                System.out.println("Reserva creada exitosamente para " + nombreCliente);
            } else {
                System.out.println("No hay habitaciones disponibles del tipo " + tipoHabitacion);
            }

            System.out.print("\n¿Desea realizar otra reservación? (S/N): ");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("S")) {
                continuar = false;
            }
        }

        System.out.println("\nEstado final del hotel:");
        hotel.mostrarEstadoHabitaciones();
    }

    public static boolean esFechaValida(String fecha) {
        if (fecha.matches("\\d{2}-\\d{2}-\\d{4}")) {
            String[] partes = fecha.split("-");
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int anio = Integer.parseInt(partes[2]);
            if (mes < 1 || mes > 12 || dia < 1 || dia > 31) {
                return false;
            }
            if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
                return false;
            }
            if (mes == 2) {
                boolean esBisiesto = (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
                if ((esBisiesto && dia > 29) || (!esBisiesto && dia > 28)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
