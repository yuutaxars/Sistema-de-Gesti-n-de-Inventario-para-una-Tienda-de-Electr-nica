public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidadEnStock;

    // Constructor
    public Producto(int id, String nombre, String descripcion, double precio, int cantidadEnStock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    // Método para actualizar cantidad en stock
    public void actualizarStock(int cantidad) {
        this.cantidadEnStock -= cantidad;
    }

    // Método para aumentar cantidad en stock
    public void aumentarStock(int cantidad) {
        this.cantidadEnStock += cantidad;
    }
}
