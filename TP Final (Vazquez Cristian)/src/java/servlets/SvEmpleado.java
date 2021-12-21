
package servlets;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;


@WebServlet(name = "SvEmpleado", urlPatterns = {"/SvEmpleado"})
public class SvEmpleado extends HttpServlet {
    
Controladora control= new Controladora();
SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

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
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String dni = request.getParameter("dni");
        Date fechaNac=null;
    try {
     fechaNac = formato.parse(request.getParameter("fechaNac"));
    } catch (ParseException ex) {
        Logger.getLogger(SvEmpleado.class.getName()).log(Level.SEVERE, null, ex);
    }
        String nacionalidad = request.getParameter("nacionalidad");
        String celular = request.getParameter("celular");
        String email = request.getParameter("email"); 
        String cargo = request.getParameter("cargo");
        double sueldo = Double.parseDouble(request.getParameter("sueldo"));
        String nomUsuario = request.getParameter("nombreUsuario");
        String contrasena = request.getParameter("contrasena");
        
        control.crearEmpleado(nombre,apellido,direccion,dni,fechaNac,nacionalidad,celular,email,cargo,sueldo,nomUsuario,contrasena);
        
        response.sendRedirect("altaEmpleados.jsp");
   
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
