
package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class PaqueteTuristico implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo;
   @Basic
    private double costo_paquete;
    @ManyToMany()
    public List <Servicio> lista_servicios;
    
    
    

    public PaqueteTuristico() {
    }

    public PaqueteTuristico(int codigo, double costo_paquete, List<Servicio> lista_servicios) {
        this.codigo = codigo;
        this.costo_paquete = costo_paquete;
        this.lista_servicios = lista_servicios;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getCosto_paquete() {
        return costo_paquete;
    }

    public void setCosto_paquete(double costo_paquete) {
        this.costo_paquete = costo_paquete;
    }

    public List<Servicio> getLista_servicios() {
        return lista_servicios;
    }

    public void setLista_servicios(List<Servicio> lista_servicios) {
        this.lista_servicios = lista_servicios;
    }

    
}