import java.util.ArrayList;

public class Parque {
    private String nombre;
    private String codigoIdentificacion;
    private String nombreEncargado;
    private PuntoAcceso[] puntosDeAcceso; 
    private ArrayList<Visitante> visitantes;

    public Parque(String nombre, String codigoIdentificacion, String nombreEncargado) {
        this.nombre = nombre;
        this.codigoIdentificacion = codigoIdentificacion;
        this.nombreEncargado = nombreEncargado;
        this.puntosDeAcceso = new PuntoAcceso[5];
        this.visitantes = new ArrayList<>();
    }

    // --- Puntos de Acceso ---
    public void habilitarPuntoAcceso(int posicion, PuntoAcceso nuevoPunto) {
        if (posicion < 0 || posicion >= 5) throw new IllegalArgumentException("Posición fuera de rango.");
        if (puntosDeAcceso[posicion] != null) throw new IllegalArgumentException("La posición ya está ocupada.");
        puntosDeAcceso[posicion] = nuevoPunto;
    }

    public void cerrarPuntoAcceso(int posicion) {
        if (posicion >= 0 && posicion < 5) puntosDeAcceso[posicion] = null; 
    }

    public void consultarPuntosAcceso() {
        boolean hayPuntos = false;
        for (int i = 0; i < puntosDeAcceso.length; i++) {
            if (puntosDeAcceso[i] != null) {
                System.out.println("Posición " + i + ": " + puntosDeAcceso[i].toString());
                hayPuntos = true;
            }
        }
        if (!hayPuntos) System.out.println("No hay puntos de acceso habilitados.");
    }

    public PuntoAcceso consultarPuntoAcceso(int posicion) {
        if (posicion < 0 || posicion >= 5 || puntosDeAcceso[posicion] == null) {
            System.out.println("Posición inválida o vacía.");
            return null;
        }
        return puntosDeAcceso[posicion];
    }

    public void modificarPuntoAcceso(int posicion, int nuevaCapacidad, String nuevoEstado) {
        PuntoAcceso p = consultarPuntoAcceso(posicion);
        if (p != null) {
            p.setCapacidadMaxima(nuevaCapacidad);
            p.setEstado(nuevoEstado);
            System.out.println("Punto modificado exitosamente.");
        }
    }

    // --- Visitantes ---
    public void registrarVisitante(Visitante nuevoVisitante) {
        if (buscarVisitante(nuevoVisitante.getCodigoEntrada()) != null) {
            throw new IllegalArgumentException("El código de visitante ya existe.");
        }
        visitantes.add(nuevoVisitante);
    }

    public Visitante buscarVisitante(String codigoABuscar) {
        for (Visitante v : visitantes) {
            if (v.getCodigoEntrada().equals(codigoABuscar)) return v;
        }
        return null;
    }

    public void eliminarVisitante(String codigoABuscar) {
        Visitante v = buscarVisitante(codigoABuscar);
        if (v != null) visitantes.remove(v);
    }

    public void consultarVisitantes() {
        if (visitantes.isEmpty()) {
            System.out.println("No hay visitantes registrados.");
            return;
        }
        for (Visitante v : visitantes) System.out.println(v.toString());
    }

    public void modificarVisitante(String codigo, String nombre, int edad, int atracciones, int puntos) {
        Visitante v = buscarVisitante(codigo);
        if (v != null) {
            v.setNombre(nombre);
            v.setEdad(edad);
            v.setAtraccionesVisitadas(atracciones);
            v.setPuntosAcumulados(puntos);
            System.out.println("Visitante modificado.");
        } else {
            System.out.println("Visitante no encontrado.");
        }
    }

    // --- Reportes ---
    public int contarPuntosHabilitados() {
        int cont = 0;
        for (PuntoAcceso p : puntosDeAcceso) {
            if (p != null) cont++;
        }
        return cont;
    }

    public int contarEspaciosDisponibles() {
        return 5 - contarPuntosHabilitados();
    }

    public PuntoAcceso obtenerPuntoMayorCapacidad() {
        PuntoAcceso mayor = null;
        for (PuntoAcceso p : puntosDeAcceso) {
            if (p != null && (mayor == null || p.getCapacidadMaxima() > mayor.getCapacidadMaxima())) {
                mayor = p;
            }
        }
        return mayor;
    }

    public int contarVisitantes() {
        return visitantes.size();
    }

    public Visitante obtenerVisitanteMayorPuntos() {
        if (visitantes.isEmpty()) return null;
        Visitante mayor = visitantes.get(0);
        for (Visitante v : visitantes) {
            if (v.getPuntosAcumulados() > mayor.getPuntosAcumulados()) mayor = v;
        }
        return mayor;
    }

    public Visitante obtenerVisitanteMasAtracciones() {
        if (visitantes.isEmpty()) return null;
        Visitante mayor = visitantes.get(0);
        for (Visitante v : visitantes) {
            if (v.getAtraccionesVisitadas() > mayor.getAtraccionesVisitadas()) mayor = v;
        }
        return mayor;
    }

    public double calcularPromedioEdad() {
        if (visitantes.isEmpty()) return 0;
        double suma = 0;
        for (Visitante v : visitantes) suma += v.getEdad();
        return suma / visitantes.size();
    }
}