package logica;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import persistencia.ControladoraPersistencia;

public class Controladora {

  ControladoraPersistencia controlPers = new ControladoraPersistencia();
  SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 

    public void crearEmpleado(String nombre, String apellido, String direccion, String dni, Date fechaNac, String nacionalidad, String celular, String email, String cargo, double sueldo, String nomUsuario, String contrasena) {
        
        Usuario usu = new Usuario();
        Empleado emple = new Empleado();
        
        
        
        //asigno valores a empleado
        emple.setApellido(apellido);
        emple.setCargo(cargo);
        emple.setNombre(nombre);
        emple.setSueldo(sueldo);
        emple.setDni(dni);
        emple.setEmail(email);
        emple.setDireccion(direccion);
        emple.setNacionalidad(nacionalidad);
        emple.setFecha_nac(fechaNac);
        emple.setCelular(celular);
        //asigno valores a usuario
        usu.setNombreUsuario(nomUsuario);
        usu.setContrasena(contrasena);
        //asigno usuario a empleado
        emple.setUsu(usu);
        
        controlPers.nuevoEmpleado(emple,usu);
    }

    public List<Empleado> traerEmpleado() {
        return controlPers.traerEmpleado();
    }

    public void borrarEmpleado(int id) {
        controlPers.borrarEmpleado(id);
    }
    
    
    public boolean verificarUsuario(String usuario, String contrasena){
        List<Usuario> listaUsuario = controlPers.traerUsuario();
        
        if (listaUsuario!= null){
            for (Usuario usu: listaUsuario){
                if(usu.getNombreUsuario().equals(usuario) && usu.getContrasena().equals(contrasena)){
                    return true;
                }
            }
        }
        return false;
    }
    int idUsu=0;
    public int buscarIdUsuario(String usuario, String contrasena){
        List<Usuario> listaUsuario = controlPers.traerUsuario();
        
        
            for (Usuario usu: listaUsuario){
                if(usu.getNombreUsuario().equals(usuario) && usu.getContrasena().equals(contrasena)){
                   idUsu = usu.getIdUsu();
                }
                else{
                   
                }
    }
    return idUsu;
    }

    public List<Usuario> traerUsuario() {
        return controlPers.traerUsuario();
    }

    public Empleado buscarEmpleado(int id) {
        return controlPers.buscarEmpleado(id);
    }

    public void modificarEmpleado(Empleado emple) {
        controlPers.modificarEmpleado(emple);
    }

    public void borrarUsuario(int idUsuario) {
        controlPers.borrarUsuario(idUsuario);
    }

    public void crearServicio(String nombre, String descripcion, String origen, String destino, double costo) {
        Servicio serv = new Servicio();
        //asigno valores a Servicio
        serv.setNombre(nombre);
        serv.setDescripcion(descripcion);
        serv.setDestino(destino);
        serv.setOrigen(origen);
        serv.setCosto(costo);
        
        controlPers.crearServicio(serv);
        
    }

    public void crearTipoServicio(String nombre) {
        TipoDeServicio tipoS= new TipoDeServicio();
        tipoS.setNombre(nombre);
        
        controlPers.crearTipoServicio(tipoS);
    }

    public List<TipoDeServicio> traerTipoServicio() {
        return controlPers.traerTipoServicio();
    }

    public List<Servicio> traerServicio() {
        return controlPers.traerServicio();
    }

    public void crearCliente(String nombre, String apellido, String dni, String direccion, Date fechaNac, String nacionalidad, String email, String celular) {
        Cliente cliente= new Cliente ();
        
        cliente.setApellido(apellido);
        cliente.setNombre(nombre);
        cliente.setCelular(celular);
        cliente.setDireccion(direccion);
        cliente.setEmail(email);
        cliente.setDni(dni);
        cliente.setNacionalidad(nacionalidad);
        cliente.setFecha_nac(fechaNac);
        
        controlPers.crearCliente(cliente);
 
    }
    String nomEmpleado;
    public String buscarNombreEmpleado(int idUsuario) {
        List<Empleado> listaEmpleados= controlPers.traerEmpleado();
        for(Empleado emple : listaEmpleados){
            Usuario usu = emple.getUsu();
            if(usu.getIdUsu() == idUsuario);
               nomEmpleado = emple.getNombre() + " " + emple.getApellido();
        }
        return nomEmpleado;
    }

    public List<Cliente> traerCliente() {
       return controlPers.traerCliente(); 
    }

    public List<PaqueteTuristico> traerPaquete() {
        return controlPers.traerPaquete(); 
    }

    public List<FormaDePago> traerFormaPago() {
        return controlPers.traerFormaPago(); 
    }

    public void crearVenta(int idServicio, int idCliente, int idUsuario, Date fechaVenta, Date fechaInicial, Date fechaFin, int formaPago, Double costo) {
        
        Venta venta = new Venta();
        Usuario usu = new Usuario();
        Servicio serv= new Servicio();
        FormaDePago formaPag = new FormaDePago();
        Cliente cliente= new Cliente();
        PaqueteTuristico paquete= new PaqueteTuristico();
        //seteo valores para venta
        venta.setFecha_fin(fechaFin);
        venta.setFecha_in(fechaFin);
        venta.setFecha_venta(fechaVenta);
        venta.setMonto(costo);
        //seteo valores para las otras clases
        usu.setIdUsu(idUsuario);
        serv.setCodigo_serv(idServicio);
        formaPag.setId(formaPago);
        cliente.setId_cliente(idCliente);
        //seteo esas clases a venta
        venta.setCliente(cliente);
        venta.setFormaPago(formaPag);
        venta.setServ(serv);
        venta.setUsu(usu);
        
        controlPers.crearVenta(venta);
       
        
        
    }

    public void crearFormaPago(String nombre) {
        FormaDePago formaPago=new FormaDePago();
        formaPago.setNombre(nombre);
       controlPers.crearFormaPago(formaPago);
    }

    public Servicio buscarServicio(int idServicio) {
        return controlPers.buscarServicio(idServicio);
    }

    public void crearVentaPaquete(ArrayList <Servicio> listaServ, int idCliente, int idUsuario, Date fechaVenta, Date fechaInicial, Date fechaFin, int formaPago, double CostoPaquete) {
        
        Venta venta = new Venta();
        Usuario usu = new Usuario();
        
        FormaDePago formaPag = new FormaDePago();
        Cliente cliente= new Cliente();
        PaqueteTuristico paquete= new PaqueteTuristico();
        //seteo valores para venta
        venta.setFecha_fin(fechaFin);
        venta.setFecha_in(fechaFin);
        venta.setFecha_venta(fechaVenta);
        venta.setMonto(CostoPaquete);
        //seteo valores para las otras clases
        usu.setIdUsu(idUsuario);
        paquete.setLista_servicios(listaServ);
        formaPag.setId(formaPago);
        cliente.setId_cliente(idCliente);
        //seteo esas clases a venta
        venta.setCliente(cliente);
        venta.setFormaPago(formaPag);
        venta.setUsu(usu);
        venta.setPaquete(paquete);
       
        controlPers.crearVentaPaquete(venta,paquete);
    }

    public void modificarServicio(int idServ, String nombre, String descripcion, String origen, String destino, double costo) {
        
        Servicio serv = controlPers.buscarServicio(idServ);
 
        serv.setNombre(nombre);
        serv.setDestino(destino);
        serv.setOrigen(origen);
        serv.setDescripcion(descripcion);
        serv.setCosto(costo);
        
        controlPers.modificarServicio(serv);
    }

    public void borrarCliente(int idCliente) {
        controlPers.borrarCliente(idCliente);
    }

    public Cliente buscarCliente(int idCliente) {
        return controlPers.buscarCliente(idCliente);
    }

    public void modificarCliente(int idCliente, String nombre, String apellido, String dni, String direccion, Date fechaNaci, String nacionalidad, String email, String celular) {
       
        Cliente cliente = controlPers.buscarCliente(idCliente);
        cliente.setApellido(apellido);
        cliente.setCelular(celular);
        cliente.setDireccion(direccion);
        cliente.setDni(dni);
        cliente.setEmail(email);
        cliente.setFecha_nac(fechaNaci);
        cliente.setNacionalidad(nacionalidad);
        cliente.setNombre(nombre);
        
        controlPers.modificarCliente(cliente);
        
    }

    public void borrarServicio(int idServicio) {
        controlPers.borrarServicio(idServicio);
    }
        
    
}
