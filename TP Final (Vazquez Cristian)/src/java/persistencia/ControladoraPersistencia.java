
package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Cliente;
import logica.Empleado;
import logica.FormaDePago;
import logica.PaqueteTuristico;
import logica.Servicio;
import logica.TipoDeServicio;
import logica.Usuario;
import logica.Venta;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {

    UsuarioJpaController usuJPA = new UsuarioJpaController();
    EmpleadoJpaController empleJPA = new EmpleadoJpaController();
    ServicioJpaController servJPA = new ServicioJpaController();   
    TipoDeServicioJpaController tipoServJPA = new TipoDeServicioJpaController();
    ClienteJpaController clienteJPA = new ClienteJpaController();
    PaqueteTuristicoJpaController paqueteJPA= new PaqueteTuristicoJpaController();
    FormaDePagoJpaController formPagoJPA = new FormaDePagoJpaController();
    VentaJpaController ventaJPA = new VentaJpaController();
    
    public void nuevoEmpleado(Empleado emple, Usuario usu) {
       
        usuJPA.create(usu);
        empleJPA.create(emple);
    }
 
    public List <Empleado> traerEmpleado(){
        return empleJPA.findEmpleadoEntities();
    }
    
    public void borrarEmpleado(int id){
       
        try {
            empleJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    public List<Usuario> traerUsuario() {
        return usuJPA.findUsuarioEntities();
    }

    public Empleado buscarEmpleado(int id) {
        return empleJPA.findEmpleado(id);
    }
    
    public void modificarEmpleado(Empleado emple){
        try {
            empleJPA.edit(emple);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarUsuario(int idUsuario) {
        try {
            usuJPA.destroy(idUsuario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearServicio(Servicio serv) {
        servJPA.create(serv);
    }

    public void crearTipoServicio(TipoDeServicio tipoServ) {
        tipoServJPA.create(tipoServ);
    }

    public List<TipoDeServicio> traerTipoServicio() {
        return tipoServJPA.findTipoDeServicioEntities();
        
    }

    public List<Servicio> traerServicio() {
        return servJPA.findServicioEntities();
    }

    public void crearCliente(Cliente cliente) {
        clienteJPA.create(cliente);
    }

    public List<Cliente> traerCliente() {
        return clienteJPA.findClienteEntities();
    }

    public List<PaqueteTuristico> traerPaquete() {
        return paqueteJPA.findPaqueteTuristicoEntities();
    }

    public List<FormaDePago> traerFormaPago() {
        return formPagoJPA.findFormaDePagoEntities();
    }

    public void crearVenta(Venta venta){
        ventaJPA.create(venta);
        
    }

    public void crearFormaPago(FormaDePago formaPago) {
        formPagoJPA.create(formaPago);
    }

    public Servicio buscarServicio(int idServicio) {
        return servJPA.findServicio(idServicio);
    }

    public void crearVentaPaquete(Venta venta, PaqueteTuristico paquete) {
        paqueteJPA.create(paquete);
        ventaJPA.create(venta);
    }

    public void modificarServicio(Servicio serv) {
        try {
            servJPA.edit(serv);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarCliente(int idCliente) {
        try {
            clienteJPA.destroy(idCliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cliente buscarCliente(int idCliente) {
        return clienteJPA.findCliente(idCliente);
    }

    public void modificarCliente(Cliente cliente) {
        try {
            clienteJPA.edit(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarServicio(int idServicio) {
        try {
            servJPA.destroy(idServicio);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
