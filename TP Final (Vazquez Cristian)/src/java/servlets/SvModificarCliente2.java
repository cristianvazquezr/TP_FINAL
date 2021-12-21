
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
import logica.Empleado;

@WebServlet(name = "SvModificarCliente2", urlPatterns = {"/SvModificarCliente2"})
public class SvModificarCliente2 extends HttpServlet {
   SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
   Controladora control = new Controladora();
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        int idCliente = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String direccion = request.getParameter("nombre");
        Date fechaNaci = null;
        try {
            fechaNaci = formato.parse(request.getParameter("fechaNac"));
        } catch (ParseException ex) {
            Logger.getLogger(SvClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        String nacionalidad = request.getParameter("nacionalidad");
        String email = request.getParameter("email");
        String celular = request.getParameter("celular");
        
        control.modificarCliente(idCliente,nombre,apellido,dni,direccion,fechaNaci,nacionalidad,email,celular);
        
        
         List <Cliente> listaCliente = control.traerCliente();
        HttpSession session= request.getSession();
        session.setAttribute("listaCliente", listaCliente);
        
        response.sendRedirect("verCliente.jsp");
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
