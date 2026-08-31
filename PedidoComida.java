package model;

/**
 * Pedido de comida (restaurantes). Requiere un repartidor con mochila
 * térmica.
 */
public class PedidoComida extends Pedido {

    private String restaurante;

    public PedidoComida(String idPedido, String direccionEntrega, String restaurante) {
        super(idPedido, direccionEntrega, "Comida");
        this.restaurante = restaurante;
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("[Pedido " + getIdPedido() + " - Comida] Pedido de " + restaurante
                + ". Se requiere repartidor con mochila térmica para " + getDireccionEntrega() + ".");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("[Pedido " + getIdPedido() + " - Comida] Repartidor asignado: "
                + nombreRepartidor + ". Validación: cuenta con mochila térmica. Restaurante: " + restaurante + ".");
    }
}
