package Modelo;

public class Mesa {
    private int numeroMesa;   
    private int capacidad;   
    private boolean estado;    
    private String ocupada;
    private Mesero mesero;

    public Mesa(int numeroMesa, int capacidad, boolean estado, String ocupada, Mesero mesero) {
        this.numeroMesa = numeroMesa;
        this.capacidad = capacidad;
        this.estado = estado;
        this.ocupada = ocupada;
        this.mesero = mesero;
    }

    public Mesa(int capacidad, boolean estado, String ocupada, Mesero mesero) {
        this.capacidad = capacidad;
        this.estado = estado;
        this.ocupada = ocupada;
        this.mesero = mesero;
    }

    public Mesa() {
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getOcupada() {
        return ocupada;
    }

    public void setOcupada(String ocupada) {
        this.ocupada = ocupada;
    }

    public Mesero getMesero() {
        return mesero;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }

    @Override
    public String toString() {
        return "Mesa{" + "numeroMesa=" + numeroMesa + ", capacidad=" + capacidad + ", estado=" + estado + ", ocupada=" + ocupada + ", mesero=" + mesero + '}';
    }
}