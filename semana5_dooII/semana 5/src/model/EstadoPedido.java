package model;

/**
 * Estados posibles de un pedido dentro del proceso de reparto.
 * Usar un enum en vez de String evita errores de tipeo y mejora
 * la legibilidad del código, tal como pide el enunciado.
 */
public enum EstadoPedido {
    PENDIENTE,
    EN_REPARTO,
    ENTREGADO
}
