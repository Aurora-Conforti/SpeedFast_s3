package app;

import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;
import model.Repartidor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // --- Pedidos de Camila ---
        Pedido pedido101 = new PedidoComida("101", "Av. Ramón Picarte 1234, Valdivia", 4);
        Pedido pedido102 = new PedidoEncomienda("102", "Los Robles 456, Valdivia", 7);

        // --- Pedidos de Luis ---
        Pedido pedido103 = new PedidoExpress("103", "General Lagos 789, Valdivia", 6);
        Pedido pedido104 = new PedidoComida("104", "Independencia 321, Valdivia", 3);

        // --- Pedidos de Fernanda ---
        Pedido pedido105 = new PedidoEncomienda("105", "Costanera 654, Valdivia", 5);
        Pedido pedido106 = new PedidoExpress("106", "Errázuriz 987, Valdivia", 2);

        Repartidor camila = new Repartidor("Camila", List.of(pedido101, pedido102));
        Repartidor luis = new Repartidor("Luis", List.of(pedido103, pedido104));
        Repartidor fernanda = new Repartidor("Fernanda", List.of(pedido105, pedido106));

        System.out.println("=== SpeedFast - Simulación de entregas concurrentes ===\n");

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(camila);
        executor.submit(luis);
        executor.submit(fernanda);

        // No se aceptan más tareas; se espera a que las actuales terminen.
        executor.shutdown();

        // La simulación continúa hasta que todos los repartidores terminen.
        boolean terminoATiempo = executor.awaitTermination(1, TimeUnit.MINUTES);

        if (terminoATiempo) {
            System.out.println("\n=== Todas las entregas fueron completadas ===");
        } else {
            System.out.println("\n=== Tiempo de espera agotado antes de completar todas las entregas ===");
        }
    }
}
