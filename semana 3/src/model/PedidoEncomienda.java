package model;

public class PedidoEncomienda extends Pedido {

    public PedidoEncomienda(String idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    /**
     * Tiempo = 20 min + 1.5 min por kilómetro, ajustado a entero.
     */
    @Override
    public double calcularTiempoEntrega() {
        double tiempo = 20 + (1.5 * getDistanciaKm());
        return Math.round(tiempo);
    }

    @Override
    public void asignarRepartidor() {
        setRepartidorAsignado("Repartidor con vehículo de carga (auto-asignado)");
        System.out.println("[Pedido " + getIdPedido() + " - Encomienda] " + getRepartidorAsignado());
    }
}
