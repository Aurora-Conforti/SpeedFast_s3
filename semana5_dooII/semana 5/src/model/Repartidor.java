package model;

import service.ZonaDeCarga;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Representa a un repartidor que retira pedidos de la zona de carga
 * compartida y los entrega, funcionando como un hilo independiente.
 * Cada repartidor retira pedidos de a uno hasta que la zona de carga
 * se queda sin pedidos pendientes.
 */
public class Repartidor implements Runnable {

    private String nombre;
    private ZonaDeCarga zonaDeCarga;

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        Pedido pedido;

        // Mientras la zona de carga tenga pedidos disponibles, los retira uno a uno.
        while ((pedido = zonaDeCarga.retirarPedido()) != null) {

            pedido.setEstado(EstadoPedido.EN_REPARTO);
            System.out.println("[" + nombre + "] Retiró el pedido #" + pedido.getId()
                    + " (" + pedido.getDireccionEntrega() + "). Estado: " + pedido.getEstado());

            try {
                // Simula el tiempo de entrega con una pausa aleatoria (1 a 3 segundos).
                int tiempoSimuladoMs = ThreadLocalRandom.current().nextInt(1000, 3000);
                Thread.sleep(tiempoSimuladoMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("[" + nombre + "] Entrega interrumpida.");
                return;
            }

            pedido.setEstado(EstadoPedido.ENTREGADO);
            System.out.println("[" + nombre + "] Pedido #" + pedido.getId()
                    + " entregado. Estado final: " + pedido.getEstado());
        }

        System.out.println("[" + nombre + "] No quedan más pedidos en la zona de carga. Finaliza turno.");
    }
}
