package mx.edu.equipo3.cafeteria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Guarda los pedidos y calcula el total de la venta.
 */
public class Cafeteria {
    private final List<Pedido> pedidos = new ArrayList<>();

    public void registrarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> obtenerPedidos() {
        return Collections.unmodifiableList(pedidos);
    }

    public double calcularTotal() {
        return pedidos.stream()
                .mapToDouble(Pedido::precio)
                .sum();
    }
}
