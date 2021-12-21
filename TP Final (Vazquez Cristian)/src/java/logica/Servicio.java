
package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Servicio implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo_serv;
    @Basic
    private String nombre;
    private String descripcion;
    private String destino;
    private String origen;
    private double costo;
    @ManyToMany
    private List<PaqueteTuristico> paquete;

    public Servicio() {  
    }

    public Servicio(int codigo_serv, String nombre, String descripcion, String destino, String origen, double costo, List<PaqueteTuristico> paquete) {
        this.codigo_serv = codigo_serv;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.destino = destino;
        this.origen = origen;
        this.costo = costo;
        this.paquete = paquete;
    }

    public int getCodigo_serv() {
        return codigo_serv;
    }

    public void setCodigo_serv(int codigo_serv) {
        this.codigo_serv = codigo_serv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public List<PaqueteTuristico> getPaquete() {
        return paquete;
    }

    public void setPaquete(List<PaqueteTuristico> paquete) {
        this.paquete = paquete;
    }

   
    }

   