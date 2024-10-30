
package Modelo;

public class Mesero {
    private int dniMesero;
    private String nombre;
    private String apellido;
    private boolean estado;

    public Mesero(int dniMesero, String nombre, String apellido, boolean estado) {
        this.dniMesero = dniMesero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
    }

    public Mesero(String nombre, String apellido, boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
    }

    public Mesero() {
    }

    public int getDniMesero() {
        return dniMesero;
    }

    public void setDniMesero(int dniMesero) {
        this.dniMesero = dniMesero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Mesero{" + "dniMesero=" + dniMesero + ", nombre=" + nombre + ", apellido=" + apellido + ", estado=" + estado + '}';
    }

    public void setMesaAsignada(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setReemplazando(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}