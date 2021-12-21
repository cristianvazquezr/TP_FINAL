
package logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable {
            
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idUsu;
    @Basic
    private String nombreUsuario;
    private String contrasena;

    
    
    public Usuario() {
    }

    public int getIdUsu() {
        return idUsu;
    }

        public Usuario(int idUsu, String nombreUsuario, String contrasena) {
        this.idUsu = idUsu;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }
    
    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }



}

   