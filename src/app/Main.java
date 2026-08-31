package app;

import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

public class Main {

    public static void main(String[] args) {

        Pedido pedidoComida = new PedidoComida("P001", "Av. Ramón Picarte 1234, Valdivia", 4);
        Pedido pedidoEncomienda = new PedidoEncomienda("P002", "Los Robles 456, Valdivia", 7);
        Pedido pedidoExpress = new PedidoExpress("P003", "General Lagos 789, Valdivia", 6);

        Pedido[] pedidos = { pedidoComida, pedidoEncomienda, pedidoExpress };

        for (Pedido pedido : pedidos) {
            pedido.mostrarResumen();
            System.out.println("Tiempo estimado de entrega: " + pedido.calcularTiempoEntrega() + " min");
            System.out.println("--------------------------------------------------");
        }

        System.out.println("\nComparativa de tiempos estimados:");
        for (Pedido pedido : pedidos) {
            System.out.println(pedido.getIdPedido() + " -> " + pedido.calcularTiempoEntrega() + " min");
        }
    }
}
