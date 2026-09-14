package model;

/**
 * Representa un pedido dentro del sistema de reparto de SpeedFast.
 * Internamente el estado se guarda como EstadoPedido (enum), pero se
 * expone además un setEstado(String) tal como pide el enunciado, para
 * mayor flexibilidad al actualizar el estado desde otras partes del
 * sistema.
 */
public class Pedido {

    private int id;
    private String direccionEntrega;
    private EstadoPedido estado;

    public Pedido(int id, String direccionEntrega) {
        this.id = id;
        this.direccionEntrega = direccionEntrega;
        this.estado = EstadoPedido.PENDIENTE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido nuevoEstado) {
        this.estado = nuevoEstado;
    }

    /**
     * Actualiza el estado del pedido a partir de un texto (por ejemplo,
     * "EN_REPARTO" o "ENTREGADO"), convirtiéndolo internamente al enum
     * correspondiente.
     */
    public void setEstado(String nuevoEstado) {
        this.estado = EstadoPedido.valueOf(nuevoEstado);
    }

    @Override
    public String toString() {
        return "Pedido{id=" + id + ", direccionEntrega='" + direccionEntrega
                + "', estado=" + estado + "}";
    }
}
