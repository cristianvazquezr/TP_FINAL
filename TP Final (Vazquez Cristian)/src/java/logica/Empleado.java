
package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class Empleado implements Serializable { 
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id_empleado;
  @Basic
   private String nombre;
   private String apellido;
   private String direccion;
   private String dni;
   private String nacionalidad;
   private String celular;
   private String email;
  @Temporal(javax.persistence.TemporalType.DATE)
   private Date fecha_nac;
  @Basic
   private double sueldo;
   private String cargo;
   @OneToOne
   private Usuario usu;

   
    public Empleado() {
    }

    public Empleado(int id_empleado, String nombre, String apellido, String direccion, String dni, String nacionalidad, String celular, String email, Date fecha_nac, double sueldo, String cargo, Usuario usu) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
        this.nacionalidad = nacionalidad;
        this.celular = celular;
        this.email = email;
        this.fecha_nac = fecha_nac;
        this.sueldo = sueldo;
        this.cargo = cargo;
        this.usu = usu;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    
}

