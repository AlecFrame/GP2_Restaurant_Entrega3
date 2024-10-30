
package Modelo;


public class Producto {
    private int codigo;
    private String nombre;
    private double precio;
    private boolean estado;
    private int stock;
    private String categoria;

    public Producto(int codigo, String nombre, double precio, boolean estado, int stock, String categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.estado = estado;
        this.stock = stock;
        this.categoria = categoria;
    }

    public Producto(String nombre, double precio, boolean estado, int stock, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.estado = estado;
        this.stock = stock;
        this.categoria = categoria;
    }
    
    
    public Producto(){}

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", estado=" + estado + ", stock=" + stock + ", categoria=" + categoria + '}';
    }
}
