
package Modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Pedido {
    private int idPedido;
    private Mesero mesero;
    private Mesa mesa;
    private double importe;
    private LocalDate fecha;
    private LocalTime hora;
    private boolean cobrado;
    private boolean estado;

    public Pedido(int idPedido, Mesero mesero, Mesa mesa, double importe, LocalDate fecha, LocalTime hora, boolean cobrado, boolean estado) {
        this.idPedido = idPedido;
        this.mesero = mesero;
        this.mesa = mesa;
        this.importe = importe;
        this.fecha = fecha;
        this.hora = hora;
        this.cobrado = cobrado;
        this.estado = estado;
    }

    public Pedido(Mesero mesero, Mesa mesa, double importe, LocalDate fecha, LocalTime hora, boolean cobrado, boolean estado) {
        this.mesero = mesero;
        this.mesa = mesa;
        this.importe = importe;
        this.fecha = fecha;
        this.hora = hora;
        this.cobrado = cobrado;
        this.estado = estado;
    }

    public Pedido() {
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Mesero getMesero() {
        return mesero;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public boolean isCobrado() {
        return cobrado;
    }

    public void setCobrado(boolean cobrado) {
        this.cobrado = cobrado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", mesero=" + mesero + ", mesa=" + mesa + ", importe=" + importe + ", fecha=" + fecha + ", hora=" + hora + ", cobrado=" + cobrado + ", estado=" + estado + '}';
    }
}