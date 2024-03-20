package controller.alumno;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Alumno;
import model.Carrera;
import model.persist.AlumnoDao;
import model.persist.CarreraDao;

@WebServlet(name = "crearAlumno", urlPatterns = {"/crearAlumno"})
public class crearAlumno extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
                CarreraDao modelo = new CarreraDao();
                List<Carrera> listaCarreras = modelo.listarCarreras();
                request.setAttribute("listaCarreras", listaCarreras);
                System.out.println(listaCarreras);
            RequestDispatcher rd = request.getRequestDispatcher("GestionAlumno/crearAlumno.jsp");
            rd.forward(request, response);
        }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                processRequest(request, response);
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String email = request.getParameter("email");
                String idCarrera = request.getParameter("idCarrera");
                AlumnoDao nuevoAlumno = new AlumnoDao();
                System.out.println(nuevoAlumno.agregarAlumno(new Alumno(nombre, apellido, email, Integer.parseInt(idCarrera))));
            }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
