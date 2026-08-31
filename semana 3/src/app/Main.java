package app;

import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;
import service.ControladorDeEnvios;

public class Main {

    public static void main(String[] args) {

        Pedido pedidoComida = new PedidoComida("P001", "Av. Ramón Picarte 1234, Valdivia", 4);
        Pedido pedidoEncomienda = new PedidoEncomienda("P002", "Los Robles 456, Valdivia", 7);
        Pedido pedidoExpress = new PedidoExpress("P003", "General Lagos 789, Valdivia", 6);

        ControladorDeEnvios controlador = new ControladorDeEnvios();

        System.out.println("=== Asignación de repartidores ===\n");

        // Asignación automática (sobrescritura de asignarRepartidor())
        pedidoComida.asignarRepartidor();
        pedidoEncomienda.asignarRepartidor();

        // Asignación manual (sobrecarga de asignarRepartidor(String))
        pedidoExpress.asignarRepartidor("Ignacio Pardo");

        System.out.println("\n=== Cálculo de tiempos estimados ===\n");

        Pedido[] pedidos = { pedidoComida, pedidoEncomienda, pedidoExpress };
        for (Pedido pedido : pedidos) {
            pedido.mostrarResumen();
            System.out.println("Tiempo estimado de entrega: " + pedido.calcularTiempoEntrega() + " min");
            System.out.println("--------------------------------------------------");
        }

        System.out.println("\n=== Despacho de pedidos ===\n");

        pedidoComida.despachar();
        pedidoEncomienda.despachar();
        controlador.registrarEntrega(pedidoComida);
        controlador.registrarEntrega(pedidoEncomienda);

        System.out.println("\n=== Cancelación de un pedido ===\n");

        pedidoExpress.cancelar();
        controlador.registrarEntrega(pedidoExpress);

        System.out.println("\n=== Historial de entregas ===\n");

        controlador.verHistorial();
    }
}
