package mx.edu.equipo3.cafeteria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CafeteriaTest {

    @Test
    void calculaElTotalDeLosPedidos() {
        // Esta prueba demuestra que Maven puede verificar el código antes de crear el JAR.
        Cafeteria cafeteria = new Cafeteria();
        cafeteria.registrarPedido(new Pedido("Ana", "Café americano", 35.00));
        cafeteria.registrarPedido(new Pedido("Luis", "Sándwich", 65.00));

        assertEquals(100.00, cafeteria.calcularTotal(), 0.001);
        assertEquals(2, cafeteria.obtenerPedidos().size());
    }

    @Test
    void rechazaUnPrecioInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> new Pedido("Ana", "Café americano", 0));
    }
}
