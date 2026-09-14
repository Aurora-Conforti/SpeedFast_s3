package app;

import model.Pedido;
import model.Repartidor;
import service.ZonaDeCarga;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("=== SpeedFast - Sincronización de zona de carga ===\n");

        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();

        // Se agregan al menos 5 pedidos al sistema.
        zonaDeCarga.agregarPedido(new Pedido(1, "Av. Ramón Picarte 1234, Valdivia"));
        zonaDeCarga.agregarPedido(new Pedido(2, "Los Robles 456, Valdivia"));
        zonaDeCarga.agregarPedido(new Pedido(3, "General Lagos 789, Valdivia"));
        zonaDeCarga.agregarPedido(new Pedido(4, "Independencia 321, Valdivia"));
        zonaDeCarga.agregarPedido(new Pedido(5, "Costanera 654, Valdivia"));
        zonaDeCarga.agregarPedido(new Pedido(6, "Errázuriz 987, Valdivia"));

        System.out.println("Pedidos cargados en la zona de carga: " + zonaDeCarga.pedidosRestantes() + "\n");

        Repartidor camila = new Repartidor("Camila", zonaDeCarga);
        Repartidor luis = new Repartidor("Luis", zonaDeCarga);
        Repartidor fernanda = new Repartidor("Fernanda", zonaDeCarga);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(camila);
        executor.submit(luis);
        executor.submit(fernanda);

        executor.shutdown();
        boolean terminoATiempo = executor.awaitTermination(1, TimeUnit.MINUTES);

        if (terminoATiempo) {
            System.out.println("\nTodos los pedidos han sido entregados correctamente");
        } else {
            System.out.println("\nTiempo de espera agotado antes de completar todas las entregas");
        }
    }
}
