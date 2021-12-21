
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Cliente;
import logica.Controladora;
import logica.FormaDePago;
import logica.PaqueteTuristico;
import logica.Servicio;
import logica.Usuario;


@WebServlet(name = "SvVenta", urlPatterns = {"/SvVenta"})
public class SvVenta extends HttpServlet {
    Controladora control = new Controladora();
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        HttpSession session = request.getSession();
        List <Servicio> listServicios = control.traerServicio();
        session.setAttribute("listServicios", listServicios);
        
        List <Cliente> listClientes = control.traerCliente();
        session.setAttribute("listClientes", listClientes);
        
        List <Usuario> listUsuarios = control.traerUsuario();
        session.setAttribute("listUsuarios", listUsuarios);
                
        List <FormaDePago> listFormaPago = control.traerFormaPago();
        session.setAttribute("listFormaPago", listFormaPago);
        
         response.sendRedirect("nuevaVentaSer.jsp");
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        HttpSession session = request.getSession(true);
        int idServicio = Integer.parseInt(request.getParameter("idServicio"));
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        int idUsuario =(int) session.getAttribute("idUsuario");
        Date fechaVenta = null;
        try {
        fechaVenta = formato.parse(request.getParameter("fechaVenta"));
        } catch (ParseException ex) {
            Logger.getLogger(SvVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date fechaInicial = null;
        try {
         fechaInicial = formato.parse(request.getParameter("fechaIn"));
        } catch (ParseException ex) {
            Logger.getLogger(SvVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date fechaFin = null;
        try {
         fechaFin = formato.parse(request.getParameter("fechaFin"));
        } catch (ParseException ex) {
            Logger.getLogger(SvVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        int formaPago = Integer.parseInt(request.getParameter("idFormaPago"));
        //busco el servicio con el ID de servicio para traer el costo del servicio
        Servicio serv = control.buscarServicio(idServicio);
        Double costo = serv.getCosto();

        control.crearVenta(idServicio,idCliente, idUsuario, fechaVenta, fechaInicial, fechaFin,formaPago,costo);
        
        response.sendRedirect("nuevaVentaSer.jsp");
    }
    
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
