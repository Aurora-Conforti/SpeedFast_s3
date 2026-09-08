package model;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Representa a un repartidor de SpeedFast. Implementa Runnable para
 * que cada repartidor pueda ejecutarse como un hilo independiente,
 * procesando su propia lista de pedidos de forma concurrente respecto
 * a los demás repartidores.
 */
public class Repartidor implements Runnable {

    private String nombre;
    private List<Pedido> pedidosAsignados;

    public Repartidor(String nombre, List<Pedido> pedidosAsignados) {
        this.nombre = nombre;
        this.pedidosAsignados = pedidosAsignados;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pedido> getPedidosAsignados() {
        return pedidosAsignados;
    }

    /**
     * Ejecuta la entrega secuencial de los pedidos asignados a este
     * repartidor. Cada pedido se procesa uno tras otro dentro del
     * mismo hilo, pero distintos repartidores (distintos hilos) se
     * ejecutan de forma simultánea entre sí.
     */
    @Override
    public void run() {
        for (Pedido pedido : pedidosAsignados) {
            System.out.println("[Repartidor: " + nombre + "] Entregando "
                    + pedido.getClass().getSimpleName() + " #" + pedido.getIdPedido() + "...");

            pedido.asignarRepartidor(nombre);

            try {
                // Simula el tiempo de entrega con una pausa aleatoria (entre 1 y 4 segundos)
                int tiempoSimuladoMs = ThreadLocalRandom.current().nextInt(1000, 4000);
                Thread.sleep(tiempoSimuladoMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("[Repartidor: " + nombre + "] Entrega interrumpida.");
                return;
            }

            pedido.despachar();
            System.out.println("[Repartidor: " + nombre + "] Pedido #" + pedido.getIdPedido() + " entregado.");
        }

        System.out.println("[Repartidor: " + nombre + "] Finalizó todas sus entregas.");
    }
}
