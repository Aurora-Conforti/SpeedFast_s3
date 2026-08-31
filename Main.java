package app;

import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

/**
 * Clase de prueba del sistema SpeedFast. Instancia un pedido de cada
 * tipo y demuestra tanto la sobrescritura de asignarRepartidor()
 * (polimorfismo, usando la referencia de tipo Pedido) como la
 * sobrecarga asignarRepartidor(String) que recibe el nombre del
 * repartidor.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println(" SPEEDFAST - Sistema de asignación de repartidores");
        System.out.println("==================================================\n");

        Pedido pedidoComida = new PedidoComida("P001", "Av. Ramón Picarte 1234, Valdivia", "Restaurante Los Castaños");
        Pedido pedidoEncomienda = new PedidoEncomienda("P002", "Los Robles 456, Valdivia", 3.5, true);
        Pedido pedidoExpress = new PedidoExpress("P003", "General Lagos 789, Valdivia", "Farmacia Cruz Verde", 1.2);

        Pedido[] pedidos = { pedidoComida, pedidoEncomienda, pedidoExpress };

        System.out.println("--- Paso 1: asignarRepartidor() sobrescrito (sin nombre aún) ---\n");
        for (Pedido pedido : pedidos) {
            pedido.asignarRepartidor(); // Java ejecuta la versión de cada subclase (polimorfismo)
        }

        System.out.println("\n--- Paso 2: asignarRepartidor(String) sobrecargado ---\n");
        pedidoComida.asignarRepartidor("Matías Reyes");
        pedidoEncomienda.asignarRepartidor("Fernanda Silva");
        pedidoExpress.asignarRepartidor("Ignacio Pardo");

        System.out.println("\n--- Caso adicional: encomienda con embalaje incorrecto ---\n");
        Pedido pedidoEncomiendaMala = new PedidoEncomienda("P004", "Independencia 321, Valdivia", 8.0, false);
        pedidoEncomiendaMala.asignarRepartidor();
        pedidoEncomiendaMala.asignarRepartidor("Carlos Bravo");

        System.out.println("\n==================================================");
        System.out.println(" Fin de la ejecución");
        System.out.println("==================================================");
    }
}
