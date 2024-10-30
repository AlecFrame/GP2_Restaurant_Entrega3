
package Modelo;


public class DetallePedido {
    private int idDetalle;
    private Producto producto;
    private Pedido pedido;
    private int cantidad;
    private double total;
    private boolean estado;

    public DetallePedido(int idDetalle, Producto producto, Pedido pedido, int cantidad, double total, boolean estado) {
        this.idDetalle = idDetalle;
        this.producto = producto;
        this.pedido = pedido;
        this.cantidad = cantidad;
        this.total = total;
        this.estado = estado;
    }

    public DetallePedido(Producto producto, Pedido pedido, int cantidad, double total, boolean estado) {
        this.producto = producto;
        this.pedido = pedido;
        this.cantidad = cantidad;
        this.total = total;
        this.estado = estado;
    }

    public DetallePedido(){}

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
