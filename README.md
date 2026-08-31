# SpeedFast — Sistema de asignación de repartidores

Prototipo desarrollado para la actividad formativa "Explorando la sobrecarga y sobreescritura en clases derivadas" de Desarrollo Orientado a Objetos II.

## Descripción

SpeedFast es una empresa de reparto a domicilio con tres tipos de servicio: Comida, Encomiendas y Compras Express. Cada uno tiene criterios distintos para asignar repartidor. El proyecto modela esto con una jerarquía de clases y aplica polimorfismo mediante:

- **Sobrescritura (`@Override`)**: `asignarRepartidor()` se comporta distinto según la subclase.
- **Sobrecarga**: `asignarRepartidor(String nombreRepartidor)`, misma operación con una firma distinta, que además valida requisitos propios de cada tipo de pedido.

## Estructura

```
SpeedFast/
└── src/
    ├── model/
    │   ├── Pedido.java            (clase base)
    │   ├── PedidoComida.java
    │   ├── PedidoEncomienda.java
    │   └── PedidoExpress.java
    └── app/
        └── Main.java
```

## Clases

| Clase | Descripción |
|---|---|
| `Pedido` | Clase base: `idPedido`, `direccionEntrega`, `tipoPedido`; define `asignarRepartidor()` genérico y su sobrecarga. |
| `PedidoComida` | Requiere repartidor con mochila térmica. |
| `PedidoEncomienda` | Valida peso y embalaje antes de asignar; si el embalaje no cumple, rechaza la asignación. |
| `PedidoExpress` | Asigna al repartidor más cercano con disponibilidad inmediata. |
| `Main` | Instancia un pedido de cada tipo y prueba ambas versiones del método. |

## Cómo ejecutar

```bash
javac -d bin src/model/*.java src/app/*.java
java -cp bin app.Main
```

### Desde IntelliJ IDEA

1. **File → Open** → selecciona la carpeta `SpeedFast`.
2. Marca `src` como *Sources Root* si no se detecta automáticamente.
3. Ejecuta la clase `Main` (paquete `app`).

## Qué muestra la ejecución

1. Los tres pedidos ejecutan `asignarRepartidor()` sin argumentos, cada uno con su lógica sobrescrita.
2. Los mismos pedidos ejecutan `asignarRepartidor(String)`, mostrando las validaciones específicas de cada tipo.
3. Un caso adicional de encomienda con embalaje incorrecto, para mostrar que la validación realmente bloquea la asignación cuando corresponde.
