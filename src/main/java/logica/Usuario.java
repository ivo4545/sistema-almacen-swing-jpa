
package logica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String numCel;
    private String correo;

    public Usuario() {
    }

    public Usuario(int numUsuario, String nombre, String apellido, String numCel, String correo) {
        this.idUsuario = numUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numCel = numCel;
        this.correo = correo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNumCel() {
        return numCel;
    }

    public String getCorreo() {
        return correo;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNumCel(String numCel) {
        this.numCel = numCel;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
}
