
package Modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {
    private int idReserva;
    private Mesa mesa;
    private String dni_cliente;
    private String apellido;
    private LocalDate fecha;
    private LocalTime hora_desde;
    private LocalTime hora_hasta;
    private String vigencia;
    private boolean estado;

    public Reserva(int idReserva, Mesa mesa, String dni_cliente, String apellido, LocalDate fecha, LocalTime hora_desde, LocalTime hora_hasta, String vigencia, boolean estado) {
        this.idReserva = idReserva;
        this.mesa = mesa;
        this.dni_cliente = dni_cliente;
        this.apellido = apellido;
        this.fecha = fecha;
        this.hora_desde = hora_desde;
        this.hora_hasta = hora_hasta;
        this.vigencia = vigencia;
        this.estado = estado;
    }

    public Reserva(Mesa mesa, String dni_cliente, String apellido, LocalDate fecha, LocalTime hora_desde, LocalTime hora_hasta, String vigencia, boolean estado) {
        this.mesa = mesa;
        this.dni_cliente = dni_cliente;
        this.apellido = apellido;
        this.fecha = fecha;
        this.hora_desde = hora_desde;
        this.hora_hasta = hora_hasta;
        this.vigencia = vigencia;
        this.estado = estado;
    }

    public Reserva() {
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public String getDni_cliente() {
        return dni_cliente;
    }

    public void setDni_cliente(String dni_cliente) {
        this.dni_cliente = dni_cliente;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora_desde() {
        return hora_desde;
    }

    public void setHora_desde(LocalTime hora_desde) {
        this.hora_desde = hora_desde;
    }

    public LocalTime getHora_hasta() {
        return hora_hasta;
    }

    public void setHora_hasta(LocalTime hora_hasta) {
        this.hora_hasta = hora_hasta;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", mesa=" + mesa + ", dni_cliente=" + dni_cliente + ", apellido=" + apellido + ", fecha=" + fecha + ", hora_desde=" + hora_desde + ", hora_hasta=" + hora_hasta + ", vigencia=" + vigencia + ", estado=" + estado + '}';
    }
}
