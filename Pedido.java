package model;

/**
 * Clase base de la jerarquía de pedidos de SpeedFast. Contiene los
 * atributos comunes a cualquier tipo de pedido y un método
 * asignarRepartidor() genérico que cada subclase sobrescribe con su
 * propia lógica de asignación.
 */
public class Pedido {

    private String idPedido;
    private String direccionEntrega;
    private String tipoPedido;

    public Pedido(String idPedido, String direccionEntrega, String tipoPedido) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.tipoPedido = tipoPedido;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    /**
     * Versión genérica (sin repartidor asignado todavía). Las subclases
     * la sobrescriben para aplicar la lógica propia de cada tipo de
     * pedido.
     */
    public void asignarRepartidor() {
        System.out.println("[Pedido " + idPedido + "] Buscando repartidor disponible para "
                + direccionEntrega + "...");
    }

    /**
     * Sobrecarga: versión que recibe el nombre del repartidor ya
     * asignado. La implementación base solo confirma la asignación;
     * cada subclase la sobrescribe para agregar sus propias
     * validaciones (mochila térmica, peso, cercanía, etc.).
     */
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("[Pedido " + idPedido + "] Repartidor asignado: " + nombreRepartidor);
    }
}
