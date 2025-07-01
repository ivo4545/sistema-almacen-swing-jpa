
package logica;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Producto{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idProducto;
    private String nombre;
    private BigDecimal precio_compra;
    private BigDecimal precio_venta;
    private int cantidad;
    @ManyToOne
    private Categoria categoria;

    public Producto() {
    }

    public Producto(int idProducto, String nombre, BigDecimal precio_compra, BigDecimal precio_venta, int cantidad, Categoria categoria) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public BigDecimal getPrecio_compra() {
        return precio_compra;
    }

    public BigDecimal getPrecio_venta() {
        return precio_venta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio_compra(BigDecimal precio_compra) {
        this.precio_compra = precio_compra;
    }

    public void setPrecio_venta(BigDecimal precio_venta) {
        this.precio_venta = precio_venta;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
    
}
