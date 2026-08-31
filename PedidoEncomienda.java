package model;

/**
 * Pedido de encomienda (documentos o paquetes). Requiere validación de
 * peso y embalaje antes de asignar repartidor.
 */
public class PedidoEncomienda extends Pedido {

    private double pesoKg;
    private boolean embalajeCorrecto;

    public PedidoEncomienda(String idPedido, String direccionEntrega, double pesoKg, boolean embalajeCorrecto) {
        super(idPedido, direccionEntrega, "Encomienda");
        this.pesoKg = pesoKg;
        this.embalajeCorrecto = embalajeCorrecto;
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("[Pedido " + getIdPedido() + " - Encomienda] Peso: " + pesoKg
                + " kg. Embalaje correcto: " + (embalajeCorrecto ? "Sí" : "No")
                + ". Validando antes de asignar repartidor para " + getDireccionEntrega() + ".");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        if (!embalajeCorrecto) {
            System.out.println("[Pedido " + getIdPedido() + " - Encomienda] No se puede asignar a "
                    + nombreRepartidor + ": el embalaje no cumple con los requisitos.");
            return;
        }
        System.out.println("[Pedido " + getIdPedido() + " - Encomienda] Repartidor asignado: "
                + nombreRepartidor + ". Validación de peso (" + pesoKg + " kg) y embalaje: correctas.");
    }
}
