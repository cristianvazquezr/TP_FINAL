
package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class Venta implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int num_venta;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_venta;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_in;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_fin;
    @Basic
    private double monto;
    @ManyToOne
    private Usuario usu;
    @ManyToOne
    private PaqueteTuristico paquete;
    @OneToOne
    private Servicio serv;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private FormaDePago formaPago;

    public Venta() {
    }

    public Venta(int num_venta, Date fecha_venta, Date fecha_in, Date fecha_fin, double monto, Usuario usu, PaqueteTuristico paquete, Servicio serv, Cliente cliente, FormaDePago formaPago) {
        this.num_venta = num_venta;
        this.fecha_venta = fecha_venta;
        this.fecha_in = fecha_in;
        this.fecha_fin = fecha_fin;
        this.monto = monto;
        this.usu = usu;
        this.paquete = paquete;
        this.serv = serv;
        this.cliente = cliente;
        this.formaPago = formaPago;
    }

    public int getNum_venta() {
        return num_venta;
    }

    public void setNum_venta(int num_venta) {
        this.num_venta = num_venta;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public Date getFecha_in() {
        return fecha_in;
    }

    public void setFecha_in(Date fecha_in) {
        this.fecha_in = fecha_in;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public PaqueteTuristico getPaquete() {
        return paquete;
    }

    public void setPaquete(PaqueteTuristico paquete) {
        this.paquete = paquete;
    }

    public Servicio getServ() {
        return serv;
    }

    public void setServ(Servicio serv) {
        this.serv = serv;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public FormaDePago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaDePago formaPago) {
        this.formaPago = formaPago;
    }

    
}