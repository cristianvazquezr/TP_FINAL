
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;


@WebServlet(name = "SvUsuario", urlPatterns = {"/SvUsuario"})
public class SvUsuario extends HttpServlet {
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
        
        String usuario = request.getParameter("user");
        String contrasena = request.getParameter("key");
        boolean autorizado = control.verificarUsuario(usuario, contrasena);
        
        //De acuerdo a la sesion busco el Id de usuario y el nombre del empleado        
        int idUsuario = control.buscarIdUsuario(usuario, contrasena);
        String nombreEmpleado = control.buscarNombreEmpleado(idUsuario);
        
        if (autorizado == true){
            HttpSession session = request.getSession(true);
            session.setAttribute("usuario", usuario);
            session.setAttribute("contrasena", contrasena);
            session.setAttribute("idUsuario", idUsuario);
            session.setAttribute("nombreEmpleado", nombreEmpleado);
            response.sendRedirect("index.jsp");
        }
        else{
            
            response.sendRedirect("login.jsp");
            
            request.getSession().setAttribute("sinautorizacion", autorizado);
            //response.sendRedirect("login.jsp");
            
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
