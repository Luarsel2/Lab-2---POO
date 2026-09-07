public class Visitante {
<<<<<<< HEAD
    private String codigoEntrada;
    private String nombre;
    private int edad;
    private int atraccionesVisitadas;
    private int puntosAcumulados;

    
    public Visitante(String codigoEntrada, String nombre, int edad, int atraccionesVisitadas, int puntosAcumulados) {
        //validaciones
        if (edad <= 0) {
            throw new IllegalArgumentException("Error: La edad debe ser mayor que 0.");
        }
        if (atraccionesVisitadas < 0) {
            throw new IllegalArgumentException("Error: La cantidad de atracciones no puede ser negativa.");
        }
        if (puntosAcumulados < 0) {
            throw new IllegalArgumentException("Error: Los puntos acumulados no pueden ser negativos.");
        }
        
        this.codigoEntrada = codigoEntrada;
        this.nombre = nombre;
        this.edad = edad;
        this.atraccionesVisitadas = atraccionesVisitadas;
        this.puntosAcumulados = puntosAcumulados;
    }

    // getters
    public String getCodigoEntrada() { return codigoEntrada; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public int getAtraccionesVisitadas() { return atraccionesVisitadas; }
    public int getPuntosAcumulados() { return puntosAcumulados; }

    // setters
    
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    public void setEdad(int edad) {
        if (edad <= 0) {
            throw new IllegalArgumentException("Error: La edad debe ser mayor que 0.");
        }
        this.edad = edad;
    }

    public void setAtraccionesVisitadas(int atraccionesVisitadas) {
        if (atraccionesVisitadas < 0) {
            throw new IllegalArgumentException("Error: La cantidad de atracciones no puede ser negativa.");
        }
        this.atraccionesVisitadas = atraccionesVisitadas;
    }

    public void setPuntosAcumulados(int puntosAcumulados) {
        if (puntosAcumulados < 0) {
            throw new IllegalArgumentException("Error: Los puntos acumulados no pueden ser negativos.");
        }
        this.puntosAcumulados = puntosAcumulados;
    }
}
    
}
