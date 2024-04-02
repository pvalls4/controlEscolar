package controller.carrera;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Carrera;
import model.persist.CarreraDao;

@WebServlet(name = "modificarCarrera", urlPatterns = {"/modificarCarrera"})
public class modificarCarrera extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
                CarreraDao modelo = new CarreraDao();
                
                //Obtenemos el ID de la carrera a modificar
                int idCarrera = Integer.parseInt(request.getParameter("id"));
                
                Carrera carrera = modelo.buscarCarrera(idCarrera);
                System.out.println("Carrera a modificar: " + carrera);
                
                /*List<Carrera> listaCarreras = modelo.listarCarreras();
                request.setAttribute("listaCarreras", listaCarreras);*/
                
                request.setAttribute("carrera", carrera);
                
                RequestDispatcher rd = request.getRequestDispatcher("GestionCarrera/modificarCarrera.jsp");
                rd.forward(request, response);
            }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                int id = Integer.parseInt(request.getParameter("idCarrera"));
                String nuevoNombre = request.getParameter("nuevoNombre");
                CarreraDao nuevaCarrera = new CarreraDao();
                nuevaCarrera.modificarCarrera(id, new Carrera(nuevoNombre)); // Si <- esto da 1, la consulta se ejecutó correctamente.
                response.sendRedirect("/controlEscolar/listarCarreras");
                
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
