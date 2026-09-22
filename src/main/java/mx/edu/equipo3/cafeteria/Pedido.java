package mx.edu.equipo3.cafeteria;

/**
 * Representa un pedido muy sencillo de la cafetería.
 */
public record Pedido(String cliente, String producto, double precio) {

    public Pedido {
        if (cliente == null || cliente.isBlank()) {
            throw new IllegalArgumentException("El cliente es obligatorio");
        }
        if (producto == null || producto.isBlank()) {
            throw new IllegalArgumentException("El producto es obligatorio");
        }
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero");
        }
    }
}
