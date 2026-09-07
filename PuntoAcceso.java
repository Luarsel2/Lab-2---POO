public class PuntoAcceso {
    private String codigo;
    private String nombre;
    private String ubicacion;
    private int capacidadMaxima;
    private String estado;

    public PuntoAcceso(String codigo, String nombre, String ubicacion, int capacidadMaxima, String estado) {
        if (capacidadMaxima <= 0) {
            throw new IllegalArgumentException("La capacidad máxima por hora debe ser mayor que 0.");
        }
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidadMaxima = capacidadMaxima;
        this.estado = estado;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getUbicacion() { return ubicacion; }
    public int getCapacidadMaxima() { return capacidadMaxima; }
    public String getEstado() { return estado; }

    public void setCapacidadMaxima(int capacidadMaxima) {
        if (capacidadMaxima <= 0) {
            throw new IllegalArgumentException("La nueva capacidad debe ser mayor que 0.");
        }
        this.capacidadMaxima = capacidadMaxima;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String toString() {
        return "Punto [Código: " + codigo + ", Nombre: " + nombre + ", Capacidad: " + capacidadMaxima + ", Estado: " + estado + "]";
    }
}