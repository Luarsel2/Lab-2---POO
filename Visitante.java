public class Visitante {
    private String codigoEntrada;
    private String nombre;
    private int edad;
    private int atraccionesVisitadas;
    private int puntosAcumulados;

    public Visitante(String codigoEntrada, String nombre, int edad, int atraccionesVisitadas, int puntosAcumulados) {
        if (edad <= 0 || atraccionesVisitadas < 0 || puntosAcumulados < 0) {
            throw new IllegalArgumentException("La edad debe ser > 0, y las atracciones/puntos no pueden ser negativos.");
        }
        this.codigoEntrada = codigoEntrada;
        this.nombre = nombre;
        this.edad = edad;
        this.atraccionesVisitadas = atraccionesVisitadas;
        this.puntosAcumulados = puntosAcumulados;
    }

    public String getCodigoEntrada() { return codigoEntrada; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public int getAtraccionesVisitadas() { return atraccionesVisitadas; }
    public int getPuntosAcumulados() { return puntosAcumulados; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public void setEdad(int edad) {
        if (edad <= 0) throw new IllegalArgumentException("La edad debe ser mayor a 0.");
        this.edad = edad;
    }

    public void setAtraccionesVisitadas(int atraccionesVisitadas) {
        if (atraccionesVisitadas < 0) throw new IllegalArgumentException("No pueden ser negativas.");
        this.atraccionesVisitadas = atraccionesVisitadas;
    }

    public void setPuntosAcumulados(int puntosAcumulados) {
        if (puntosAcumulados < 0) throw new IllegalArgumentException("No pueden ser negativos.");
        this.puntosAcumulados = puntosAcumulados;
    }

    public String toString() {
        return "Visitante [Código: " + codigoEntrada + ", Nombre: " + nombre + ", Puntos: " + puntosAcumulados + "]";
    }
}