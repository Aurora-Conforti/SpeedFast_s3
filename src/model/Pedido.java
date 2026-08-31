package model;

/**
 * Clase abstracta que define los atributos y comportamiento comunes
 * a todos los pedidos de SpeedFast.
 */
public abstract class Pedido {

    private String idPedido;
    private String direccionEntrega;
    private double distanciaKm;

    public Pedido(String idPedido, String direccionEntrega, double distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    /**
     * Imprime los datos básicos del pedido.
     */
    public void mostrarResumen() {
        System.out.println("Pedido: " + idPedido);
        System.out.println("Dirección de entrega: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
    }

    /**
     * Cada subclase implementa su propia lógica para calcular el
     * tiempo estimado de entrega, en minutos.
     */
    public abstract double calcularTiempoEntrega();
}
