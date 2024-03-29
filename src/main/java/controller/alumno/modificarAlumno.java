package controller.alumno;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Carrera;
import model.persist.CarreraDao;

@WebServlet(name = "modificarAlumno", urlPatterns = {"/modificarAlumno"})
public class modificarAlumno extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        /*AlumnoDao modelo = new AlumnoDao();
        List<Alumno> listaAlumnos = modelo.listarAlumnos();
        request.setAttribute("listaAlumnos", listaAlumnos);*/
        RequestDispatcher rd = request.getRequestDispatcher("GestionAlumno/modificarAlumno.jsp");
        rd.forward(request, response);
    }
    
    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                processRequest(request, response);
                String nombre = request.getParameter("antiguoNombre");
                String nuevoNombre = request.getParameter("nuevoNombre");
                CarreraDao nuevaCarrera = new CarreraDao();
                nuevaCarrera.modificarCarrera(new Carrera(nombre), new Carrera(nuevoNombre));
            }*/

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
