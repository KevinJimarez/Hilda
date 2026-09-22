package mx.edu.equipo3.cafeteria;

/**
 * Ejemplo académico para explicar la fase Build de DevOps con Maven.
 */
public class App {

    public static void main(String[] args) {
        // Primero creo la cafetería, que será la encargada de guardar los pedidos.
        Cafeteria cafeteria = new Cafeteria();

        // Después registro dos pedidos de ejemplo. Así la demostración siempre es rápida y repetible.
        cafeteria.registrarPedido(new Pedido("Ana", "Café americano", 35.00));
        cafeteria.registrarPedido(new Pedido("Luis", "Sándwich", 65.00));

        // Finalmente muestro los datos que quedaron dentro de la aplicación.
        System.out.println("=== PEDIDOS DE CAFETERÍA ===");
        for (Pedido pedido : cafeteria.obtenerPedidos()) {
            System.out.printf("%s pidió %s - $%.2f%n",
                    pedido.cliente(), pedido.producto(), pedido.precio());
        }
        System.out.printf("Total de la venta: $%.2f%n", cafeteria.calcularTotal());
    }
}
