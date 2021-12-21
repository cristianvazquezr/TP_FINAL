package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Empleado;

@WebServlet(name = "SvVerEmpleados", urlPatterns = {"/SvVerEmpleados"})
public class SvVerEmpleados extends HttpServlet {
 Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
       
        List <Empleado> listaEmpleado = control.traerEmpleado();
        HttpSession session= request.getSession(true);
        session.setAttribute("listaEmpleado", listaEmpleado);
        
        response.sendRedirect("verEmpleados.jsp");
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
