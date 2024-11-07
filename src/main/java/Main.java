import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Crear usuarios (Ejemplo: el Admin, Vendedor y Gerente)
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("admin", "admin123", "Administrador"));
        usuarios.add(new Usuario("vendedor", "vendedor123", "Vendedor"));
        usuarios.add(new Usuario("gerente", "gerente123", "Gerente"));

        // Crear productos
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, "Laptop", "Laptop de 15 pulgadas", 799.99, 10));
        productos.add(new Producto(2, "Celular", "Smartphone de 6.5 pulgadas", 499.99, 20));

        // Crear ventas
        List<Venta> ventas = new ArrayList<>();
        List<Producto> productosVenta = new ArrayList<>();
        productosVenta.add(productos.get(0));
        ventas.add(new Venta(1, productosVenta, 799.99, "2024-11-07 10:00", usuarios.get(1)));

        // Crear informe
        Informe informe = new Informe();

        // Menú de autenticación
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su nombre de usuario: ");
        String usuarioInput = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasenaInput = scanner.nextLine();

        Usuario usuarioActivo = null;
        if (usuarioInput.equals(usuarios.get(0).getNombreUsuario()) && usuarios.get(0).verificarContrasena(contrasenaInput)) {
            usuarioActivo = usuarios.get(0);
        } else if (usuarioInput.equals(usuarios.get(1).getNombreUsuario()) && usuarios.get(1).verificarContrasena(contrasenaInput)) {
            usuarioActivo = usuarios.get(1);
        } else if (usuarioInput.equals(usuarios.get(2).getNombreUsuario()) && usuarios.get(2).verificarContrasena(contrasenaInput)) {
            usuarioActivo = usuarios.get(2);
        } else {
            System.out.println("Credenciales inválidas.");
            return;
        }

        // Menú principal
        boolean salir = false;
        while (!salir) {
            System.out.println("\nMenú Principal:");
            if (usuarioActivo.tieneRol("Administrador")) {
                System.out.println("1. Gestionar Productos");
                System.out.println("2. Generar Informe de Ventas");
                System.out.println("3. Generar Informe de Inventario");
                System.out.println("4. Gestionar Usuarios");
                System.out.println("5. Salir");
            } else if (usuarioActivo.tieneRol("Vendedor")) {
                System.out.println("1. Ver Inventario");
                System.out.println("2. Realizar Venta");
                System.out.println("3. Salir");
            } else if (usuarioActivo.tieneRol("Gerente")) {
                System.out.println("1. Ver Inventario");
                System.out.println("2. Generar Informe de Ventas");
                System.out.println("3. Salir");
            }

            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    if (usuarioActivo.tieneRol("Administrador")) {
                        // Gestionar productos
                        System.out.println("1. Agregar Producto");
                        System.out.println("2. Ver Productos");
                        System.out.print("Selecciona una opción: ");
                        int opcionProducto = scanner.nextInt();
                        scanner.nextLine();
                        if (opcionProducto == 1) {
                            // Agregar producto
                            System.out.print("Ingrese el nombre del producto: ");
                            String nombre = scanner.nextLine();
                            System.out.print("Ingrese la descripción del producto: ");
                            String descripcion = scanner.nextLine();
                            System.out.print("Ingrese el precio del producto: ");
                            double precio = scanner.nextDouble();
                            System.out.print("Ingrese la cantidad en stock: ");
                            int cantidad = scanner.nextInt();
                            productos.add(new Producto(productos.size() + 1, nombre, descripcion, precio, cantidad));
                            System.out.println("Producto agregado exitosamente.");
                        } else if (opcionProducto == 2) {
                            // Ver productos
                            System.out.println("Productos en inventario:");
                            for (Producto p : productos) {
                                System.out.println("- " + p.getNombre() + ", Stock: " + p.getCantidadEnStock());
                            }
                        }
                    } else if (usuarioActivo.tieneRol("Vendedor")) {
                        // Ver inventario
                        System.out.println("Productos en inventario:");
                        for (Producto p : productos) {
                            System.out.println("- " + p.getNombre() + ", Stock: " + p.getCantidadEnStock());
                        }
                    } else if (usuarioActivo.tieneRol("Gerente")) {
                        // Ver inventario
                        System.out.println("Productos en inventario:");
                        for (Producto p : productos) {
                            System.out.println("- " + p.getNombre() + ", Stock: " + p.getCantidadEnStock());
                        }
                    }
                    break;
                case 2:
                    if (usuarioActivo.tieneRol("Administrador")) {
                        // Generar informe de ventas
                        informe.generarInformeVentas(ventas);
                    } else if (usuarioActivo.tieneRol("Vendedor")) {
                        // Realizar venta
                        System.out.println("Realizando venta...");
                        // Aquí agregamos una venta
                        Venta venta = new Venta(ventas.size() + 1, productosVenta, 799.99, "2024-11-07 10:00", usuarios.get(1));
                        ventas.add(venta);
                        System.out.println("Venta realizada.");
                    } else if (usuarioActivo.tieneRol("Gerente")) {
                        // Generar informe de ventas
                        informe.generarInformeVentas(ventas);
                    }
                    break;
                case 3:
                    if (usuarioActivo.tieneRol("Administrador")) {
                        // Generar informe de inventario
                        informe.generarInformeInventario(productos);
                    } else if (usuarioActivo.tieneRol("Vendedor") || usuarioActivo.tieneRol("Gerente")) {
                        // Salir
                        salir = true;
                        System.out.println("Saliendo...");
                    }
                    break;
                case 4:
                    if (usuarioActivo.tieneRol("Administrador")) {
                        // Gestionar usuarios
                        System.out.println("1. Agregar Usuario");
                        System.out.println("2. Modificar Usuario");
                        System.out.println("3. Eliminar Usuario");
                        System.out.println("4. Ver Usuarios");
                        System.out.print("Selecciona una opción: ");
                        int opcionUsuario = scanner.nextInt();
                        scanner.nextLine();
                        if (opcionUsuario == 1) {
                            UsuarioController.agregarUsuario(usuarios, scanner);
                        } else if (opcionUsuario == 2) {
                            UsuarioController.modificarUsuario(usuarios, scanner);
                        } else if (opcionUsuario == 3) {
                            UsuarioController.eliminarUsuario(usuarios, scanner);
                        } else if (opcionUsuario == 4) {
                            UsuarioController.mostrarUsuarios(usuarios);
                        }
                    }
                    break;
                case 5:
                    salir = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        scanner.close();
    }
}
