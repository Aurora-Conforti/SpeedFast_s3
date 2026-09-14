package service;

import model.Pedido;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Representa la zona de carga: el recurso compartido desde donde los
 * repartidores retiran pedidos. Como varios hilos (repartidores)
 * acceden a ella simultáneamente, sus métodos están sincronizados
 * (synchronized) sobre el propio objeto ZonaDeCarga, garantizando que
 * solo un hilo a la vez pueda agregar o retirar un pedido. Esto evita
 * que dos repartidores retiren el mismo pedido al mismo tiempo
 * (condición de carrera).
 */
public class ZonaDeCarga {

    private final Queue<Pedido> pedidosPendientes = new LinkedList<>();

    /**
     * Agrega un pedido a la zona de carga. Sincronizado para evitar
     * inconsistencias si se agregan pedidos mientras otro hilo retira.
     */
    public synchronized void agregarPedido(Pedido pedido) {
        pedidosPendientes.add(pedido);
    }

    /**
     * Retira y devuelve el siguiente pedido pendiente de la zona de
     * carga, de forma atómica: al estar sincronizado, ningún otro hilo
     * puede ejecutar retirarPedido() ni agregarPedido() al mismo
     * tiempo, por lo que dos repartidores nunca pueden retirar el
     * mismo pedido. Devuelve null si ya no quedan pedidos pendientes.
     */
    public synchronized Pedido retirarPedido() {
        return pedidosPendientes.poll();
    }

    /**
     * Indica cuántos pedidos quedan pendientes en la zona de carga.
     */
    public synchronized int pedidosRestantes() {
        return pedidosPendientes.size();
    }
}
