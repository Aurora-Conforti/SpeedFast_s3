package model;

public class PedidoComida extends Pedido {

    public PedidoComida(String idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    /**
     * Tiempo = 15 min + 2 min por cada kilómetro.
     */
    @Override
    public double calcularTiempoEntrega() {
        return 15 + (2 * getDistanciaKm());
    }

    @Override
    public void asignarRepartidor() {
        setRepartidorAsignado("Repartidor con mochila térmica (auto-asignado)");
        System.out.println("[Pedido " + getIdPedido() + " - Comida] " + getRepartidorAsignado());
    }
}
