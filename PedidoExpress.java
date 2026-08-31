package model;

/**
 * Compra express (supermercado o farmacia). Debe asignarse al
 * repartidor más cercano con disponibilidad inmediata.
 */
public class PedidoExpress extends Pedido {

    private String tipoTienda;
    private double distanciaRepartidorKm;

    public PedidoExpress(String idPedido, String direccionEntrega, String tipoTienda, double distanciaRepartidorKm) {
        super(idPedido, direccionEntrega, "Compra Express");
        this.tipoTienda = tipoTienda;
        this.distanciaRepartidorKm = distanciaRepartidorKm;
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("[Pedido " + getIdPedido() + " - Compra Express] Compra en " + tipoTienda
                + ". Buscando repartidor más cercano con disponibilidad inmediata para "
                + getDireccionEntrega() + ".");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("[Pedido " + getIdPedido() + " - Compra Express] Repartidor asignado: "
                + nombreRepartidor + " (a " + distanciaRepartidorKm + " km, disponibilidad inmediata). Tienda: "
                + tipoTienda + ".");
    }
}
