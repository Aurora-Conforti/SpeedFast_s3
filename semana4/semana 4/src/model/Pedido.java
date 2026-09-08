package model;

import interfaces.Cancelable;
import interfaces.Despachable;

/**
 * Clase abstracta que define los atributos y comportamiento comunes
 * a todos los pedidos de SpeedFast. Implementa Despachable y
 * Cancelable, ya que despachar y cancelar son operaciones válidas
 * para cualquier tipo de pedido.
 */
public abstract class Pedido implements Despachable, Cancelable {

    private String idPedido;
    private String direccionEntrega;
    private double distanciaKm;
    private String repartidorAsignado;
    private String estado;

    public Pedido(String idPedido, String direccionEntrega, double distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
        this.repartidorAsignado = null;
        this.estado = "Pendiente";
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

    public String getRepartidorAsignado() {
        return repartidorAsignado;
    }

    protected void setRepartidorAsignado(String repartidorAsignado) {
        this.repartidorAsignado = repartidorAsignado;
    }

    public String getEstado() {
        return estado;
    }

    protected void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Imprime los datos básicos del pedido.
     */
    public void mostrarResumen() {
        System.out.println("Pedido: " + idPedido);
        System.out.println("Dirección de entrega: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
        System.out.println("Estado: " + estado);
    }

    /**
     * Cada subclase implementa su propia lógica para calcular el
     * tiempo estimado de entrega, en minutos.
     */
    public abstract double calcularTiempoEntrega();

    /**
     * Asignación automática de repartidor. Cada subclase sobrescribe
     * este método con su propia lógica.
     */
    public abstract void asignarRepartidor();

    /**
     * Sobrecarga: asignación manual de repartidor indicando su nombre.
     */
    public void asignarRepartidor(String nombreRepartidor) {
        this.repartidorAsignado = nombreRepartidor;
        System.out.println("[Pedido " + idPedido + "] Repartidor asignado manualmente: " + nombreRepartidor);
    }

    @Override
    public void despachar() {
        estado = "Despachado";
        System.out.println("[Pedido " + idPedido + "] Despachado con repartidor: " + repartidorAsignado);
    }

    @Override
    public void cancelar() {
        estado = "Cancelado";
        System.out.println("[Pedido " + idPedido + "] Cancelado.");
    }
}
