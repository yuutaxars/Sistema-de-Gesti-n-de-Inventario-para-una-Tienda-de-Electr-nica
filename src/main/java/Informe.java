import java.util.List;

public class Informe {
    // Método para generar informe de ventas
    public void generarInformeVentas(List<Venta> ventas) {
        System.out.println("\nInforme de Ventas:");
        for (Venta venta : ventas) {
            System.out.println("Venta ID: " + venta.getIdVenta());
            System.out.println("Cliente: " + venta.getCliente().getNombreUsuario());
            System.out.println("Fecha: " + venta.getFechaHora());
            System.out.println("Total: " + venta.getTotalVenta());
            System.out.println("Productos vendidos:");
            for (Producto producto : venta.getProductosVendidos()) {
                System.out.println("- " + producto.getNombre());
            }
            System.out.println();
        }
    }

    // Método para generar informe de inventario
    public void generarInformeInventario(List<Producto> productos) {
        System.out.println("\nInforme de Inventario:");
        for (Producto producto : productos) {
            System.out.println("Producto: " + producto.getNombre());
            System.out.println("Stock disponible: " + producto.getCantidadEnStock());
            System.out.println();
        }
    }
}
