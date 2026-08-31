package model;

public class PedidoExpress extends Pedido {

    public PedidoExpress(String idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    /**
     * Tiempo = 10 min base; si la distancia es mayor a 5 km, se agregan 5 min extra.
     */
    @Override
    public double calcularTiempoEntrega() {
        double tiempo = 10;
        if (getDistanciaKm() > 5) {
            tiempo += 5;
        }
        return tiempo;
    }
}
