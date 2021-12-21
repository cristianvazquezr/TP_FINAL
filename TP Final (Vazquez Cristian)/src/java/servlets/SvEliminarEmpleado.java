
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Empleado;


@WebServlet(name = "SvEliminarEmpleado", urlPatterns = {"/SvEliminarEmpleado"})
public class SvEliminarEmpleado extends HttpServlet {
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
        
        /*elimino el usuario asociado al empleado eliminado. guardo el IdUsuario en un input no visible
        y luego lo elimino*/
        
        int id = Integer.parseInt(request.getParameter("id"));
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        control.borrarEmpleado(id);
        control.borrarUsuario(idUsuario);
         
        
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
