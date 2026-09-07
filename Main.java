import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Parque parqueActual;

    public static void main(String[] args) {
        crearNuevoParque();
        int opcion = 0;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            ejecutarOpcion(opcion);
        } while (opcion != 13);
    }

    private static int leerEntero(String mensaje) {
        int numero = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensaje);
                numero = scanner.nextInt();
                scanner.nextLine(); 
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero.");
                scanner.nextLine(); 
            }
        }
        return numero;
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Nuevo parque");
        System.out.println("2. Habilitar punto de acceso");
        System.out.println("3. Consultar puntos de acceso");
        System.out.println("4. Consultar un punto de acceso");
        System.out.println("5. Modificar punto de acceso");
        System.out.println("6. Cerrar punto de acceso");
        System.out.println("7. Registrar visitante");
        System.out.println("8. Consultar visitantes");
        System.out.println("9. Buscar visitante");
        System.out.println("10. Modificar visitante");
        System.out.println("11. Eliminar visitante");
        System.out.println("12. Mostrar reporte del parque");
        System.out.println("13. Salir");
    }

    private static void ejecutarOpcion(int opcion) {
        try {
            switch (opcion) {
                case 1: crearNuevoParque(); break;
                case 2: habilitarPunto(); break;
                case 3: parqueActual.consultarPuntosAcceso(); break;
                case 4: consultarPuntoEspecifico(); break;
                case 5: modificarPunto(); break;
                case 6: cerrarPunto(); break;
                case 7: registrarVisitante(); break;
                case 8: parqueActual.consultarVisitantes(); break;
                case 9: buscarVisitante(); break;
                case 10: modificarVisitante(); break;
                case 11: eliminarVisitante(); break;
                case 12: mostrarReporte(); break;
                case 13: System.out.println("Saliendo..."); break;
                default: System.out.println("Opcion no valida.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (opcion != 13) {
                System.out.println("Fin de la operacion " + opcion);
            }
        }
    }

    private static void crearNuevoParque() {
        System.out.println("\n--- Datos del Parque ---");
        System.out.print("Nombre del parque: ");
        String nombre = scanner.nextLine();
        System.out.print("Codigo: ");
        String codigo = scanner.nextLine();
        System.out.print("Encargado: ");
        String encargado = scanner.nextLine();
        parqueActual = new Parque(nombre, codigo, encargado);
    }

    private static void habilitarPunto() {
        int pos = leerEntero("Posición (0-4): ");
        System.out.print("Codigo: ");
        String cod = scanner.nextLine();
        System.out.print("Nombre: ");
        String nom = scanner.nextLine();
        System.out.print("Ubicacion: ");
        String ubi = scanner.nextLine();
        int cap = leerEntero("Capacidad maxima por hora: ");
        System.out.print("Estado: ");
        String est = scanner.nextLine();

        PuntoAcceso nuevo = new PuntoAcceso(cod, nom, ubi, cap, est);
        parqueActual.habilitarPuntoAcceso(pos, nuevo);
    }

    private static void consultarPuntoEspecifico() {
        int pos = leerEntero("Posicion a consultar: ");
        PuntoAcceso p = parqueActual.consultarPuntoAcceso(pos);
        if (p != null) {
            System.out.println(p.toString());
        }
    }

    private static void modificarPunto() {
        int pos = leerEntero("Posicion a modificar: ");
        int cap = leerEntero("Nueva capacidad: ");
        System.out.print("Nuevo estado: ");
        String est = scanner.nextLine();
        parqueActual.modificarPuntoAcceso(pos, cap, est);
    }

    private static void cerrarPunto() {
        int pos = leerEntero("Posicion a cerrar: ");
        parqueActual.cerrarPuntoAcceso(pos);
    }

    private static void registrarVisitante() {
        System.out.print("Codigo de entrada: ");
        String cod = scanner.nextLine();
        System.out.print("Nombre: ");
        String nom = scanner.nextLine();
        int edad = leerEntero("Edad: ");
        int atracciones = leerEntero("Atracciones visitadas: ");
        int puntos = leerEntero("Puntos acumulados: ");

        Visitante v = new Visitante(cod, nom, edad, atracciones, puntos);
        parqueActual.registrarVisitante(v);
    }

    private static void buscarVisitante() {
        System.out.print("Código a buscar: ");
        String cod = scanner.nextLine();
        Visitante v = parqueActual.buscarVisitante(cod);
        if (v != null) {
            System.out.println(v.toString());
        } else {
            System.out.println("Visitante no encontrado.");
        }
    }

    private static void modificarVisitante() {
        System.out.print("Codigo del visitante a modificar: ");
        String cod = scanner.nextLine();
        System.out.print("Nuevo nombre: ");
        String nom = scanner.nextLine();
        int edad = leerEntero("Nueva edad: ");
        int atracciones = leerEntero("Nuevas atracciones: ");
        int puntos = leerEntero("Nuevos puntos: ");

        parqueActual.modificarVisitante(cod, nom, edad, atracciones, puntos);
    }

    private static void eliminarVisitante() {
        System.out.print("Codigo a eliminar: ");
        String cod = scanner.nextLine();
        parqueActual.eliminarVisitante(cod);
    }

    private static void mostrarReporte() {
        System.out.println("\n--- REPORTE ---");
        System.out.println("Puntos habilitados: " + parqueActual.contarPuntosHabilitados());
        System.out.println("Espacios disponibles: " + parqueActual.contarEspaciosDisponibles());
        
        PuntoAcceso mayorCap = parqueActual.obtenerPuntoMayorCapacidad();
        System.out.println("Punto con mayor capacidad: " + (mayorCap != null ? mayorCap.getNombre() : "Ninguno"));

        System.out.println("Visitantes registrados: " + parqueActual.contarVisitantes());

        Visitante masPuntos = parqueActual.obtenerVisitanteMayorPuntos();
        System.out.println("Visitante con mas puntos: " + (masPuntos != null ? masPuntos.getNombre() : "Ninguno"));

        Visitante masAtracciones = parqueActual.obtenerVisitanteMasAtracciones();
        System.out.println("Visitante con mas atracciones: " + (masAtracciones != null ? masAtracciones.getNombre() : "Ninguno"));

        System.out.println("Promedio de edad: " + parqueActual.calcularPromedioEdad());
    }
}