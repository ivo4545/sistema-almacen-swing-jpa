/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author ivost
 */

@Entity
public class Categoria implements Serializable{    
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idCategoria;
    @Column(unique = true)
    private String nombre;
    private int cantidadDeProductos;

    
    public Categoria() {}
    
  public Categoria(int id,String nombre){
      
      this.nombre = nombre;
      this.idCategoria = id;
      this.cantidadDeProductos = 0;
 
  }

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getNombre() {
        return nombre;
    }
    @Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || !(o instanceof Categoria)) return false;
    Categoria c = (Categoria) o;
    return this.getIdCategoria() == c.getIdCategoria(); // o nombre si el ID no importa
}

@Override
public int hashCode() {
    return Objects.hash(getIdCategoria());
}

    public int getCantidadDeProductos() {
        return cantidadDeProductos;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidadDeProductos(int cantidadDeProductos) {
        this.cantidadDeProductos = cantidadDeProductos;
    }

    @Override
    public String toString() {
        return nombre;
    }



    
  
}
