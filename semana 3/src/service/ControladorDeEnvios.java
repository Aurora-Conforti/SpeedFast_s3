package service;

import interfaces.Rastreable;
import model.Pedido;

import java.util.ArrayList;

/**
 * Controla el historial de entregas realizadas. Implementa Rastreable
 * para desacoplar la responsabilidad de historial de las clases de
 * pedido.
 */
public class ControladorDeEnvios implements Rastreable {

    private ArrayList<Pedido> historialEntregas;

    public ControladorDeEnvios() {
        this.historialEntregas = new ArrayList<>();
    }

    public void registrarEntrega(Pedido pedido) {
        historialEntregas.add(pedido);
    }

    @Override
    public void verHistorial() {
        System.out.println("Historial de entregas realizadas:");
        if (historialEntregas.isEmpty()) {
            System.out.println("(sin entregas registradas)");
            return;
        }
        for (Pedido pedido : historialEntregas) {
            System.out.println("- " + pedido.getIdPedido() + " | " + pedido.getDireccionEntrega()
                    + " | Estado: " + pedido.getEstado());
        }
    }
}
