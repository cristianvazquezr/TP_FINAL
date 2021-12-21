package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Servicio;


@WebServlet(name = "SvModificarServicio2", urlPatterns = {"/SvModificarServicio2"})
public class SvModificarServicio2 extends HttpServlet {
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
        
        int     idServ=Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombreServ");
        String descripcion = request.getParameter("descrServ");
        String origen = request.getParameter("origen");
        String destino = request.getParameter("destino");
        double costo = Double.parseDouble(request.getParameter("costo"));
        
        
        control.modificarServicio(idServ,nombre,descripcion,origen,destino,costo);
        
        
         HttpSession session = request.getSession();
        List <Servicio> listaservicio= control.traerServicio();
        session.setAttribute("listServ", listaservicio);
        
               
        response.sendRedirect("verServicios.jsp");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
