
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
import logica.Controladora;
import logica.Empleado;

@WebServlet(name = "SvModificarEmpleado2", urlPatterns = {"/SvModificarEmpleado2"})
public class SvModificarEmpleado2 extends HttpServlet {
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    Controladora control=new Controladora();

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
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
        
        int id= Integer.parseInt(request.getParameter("id"));
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
        
        Empleado emple = control.buscarEmpleado(id);
        emple.setApellido(apellido);
        emple.setNombre(nombre);
        emple.setCargo(cargo);
        emple.setCelular(celular);
        emple.setEmail(email);
        emple.setFecha_nac(fechaNac);
        emple.setNacionalidad(nacionalidad);
        emple.setSueldo(sueldo);
        emple.setDni(dni);
        emple.setDireccion(direccion);
        control.modificarEmpleado(emple);
        
        
        List <Empleado> listaEmpleado = control.traerEmpleado();
        HttpSession session= request.getSession();
        session.setAttribute("listaEmpleado", listaEmpleado);
        
        response.sendRedirect("verEmpleados.jsp");
    }
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
