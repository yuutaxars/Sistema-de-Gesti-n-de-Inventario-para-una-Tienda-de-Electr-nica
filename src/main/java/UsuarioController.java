import java.util.List;
import java.util.Scanner;

public class UsuarioController {

    // Método para agregar un nuevo usuario
    public static void agregarUsuario(List<Usuario> usuarios, Scanner scanner) {
        System.out.print("Ingrese el nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingrese la contraseña: ");
        String contrasena = scanner.nextLine();
        System.out.print("Ingrese el rol (Administrador, Vendedor, Gerente): ");
        String rol = scanner.nextLine();

        Usuario nuevoUsuario = new Usuario(nombreUsuario, contrasena, rol);
        usuarios.add(nuevoUsuario);
        System.out.println("Usuario agregado exitosamente.");
    }

    // Método para modificar un usuario existente
    public static void modificarUsuario(List<Usuario> usuarios, Scanner scanner) {
        System.out.print("Ingrese el nombre de usuario a modificar: ");
        String nombreUsuario = scanner.nextLine();
        Usuario usuario = buscarUsuario(usuarios, nombreUsuario);

        if (usuario != null) {
            System.out.print("Ingrese la nueva contraseña: ");
            String nuevaContrasena = scanner.nextLine();
            System.out.print("Ingrese el nuevo rol (Administrador, Vendedor, Gerente): ");
            String nuevoRol = scanner.nextLine();

            usuario.setContrasena(nuevaContrasena);
            usuario.setRol(nuevoRol);
            System.out.println("Usuario modificado exitosamente.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    // Método para eliminar un usuario
    public static void eliminarUsuario(List<Usuario> usuarios, Scanner scanner) {
        System.out.print("Ingrese el nombre de usuario a eliminar: ");
        String nombreUsuario = scanner.nextLine();
        Usuario usuario = buscarUsuario(usuarios, nombreUsuario);

        if (usuario != null) {
            usuarios.remove(usuario);
            System.out.println("Usuario eliminado exitosamente.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    // Método para buscar un usuario por nombre
    public static Usuario buscarUsuario(List<Usuario> usuarios, String nombreUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
                return usuario;
            }
        }
        return null; // Si no se encuentra el usuario
    }

    // Método para mostrar todos los usuarios
    public static void mostrarUsuarios(List<Usuario> usuarios) {
        System.out.println("Usuarios registrados:");
        for (Usuario usuario : usuarios) {
            System.out.println("Usuario: " + usuario.getNombreUsuario() + ", Rol: " + usuario.getRol());
        }
    }
}

