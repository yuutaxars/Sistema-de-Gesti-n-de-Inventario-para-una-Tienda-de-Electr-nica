import java.util.List;

public class Venta {
    private int idVenta;
    private List<Producto> productosVendidos;
    private double totalVenta;
    private String fechaHora;
    private Usuario cliente;

    // Constructor
    public Venta(int idVenta, List<Producto> productosVendidos, double totalVenta, String fechaHora, Usuario cliente) {
        this.idVenta = idVenta;
        this.productosVendidos = productosVendidos;
        this.totalVenta = totalVenta;
        this.fechaHora = fechaHora;
        this.cliente = cliente;
    }

    // Getters y setters
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public List<Producto> getProductosVendidos() {
        return productosVendidos;
    }

    public void setProductosVendidos(List<Producto> productosVendidos) {
        this.productosVendidos = productosVendidos;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    // Método para calcular el total de la venta
    public void calcularTotal() {
        this.totalVenta = 0;
        for (Producto producto : productosVendidos) {
            this.totalVenta += producto.getPrecio();
        }
    }
}
