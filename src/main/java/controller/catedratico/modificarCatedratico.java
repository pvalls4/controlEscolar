package controller.catedratico;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Catedratico;
import model.persist.CatedraticoDao;

@WebServlet(name = "modificarCatedratico", urlPatterns = {"/modificarCatedratico"})
public class modificarCatedratico extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
                CatedraticoDao modelo = new CatedraticoDao();
                List<Catedratico> listaCatedraticos = modelo.listarCatedraticos();
                request.setAttribute("listaCatedraticos", listaCatedraticos);
                RequestDispatcher rd = request.getRequestDispatcher("GestionCatedratico/modificarCatedratico.jsp");
                rd.forward(request, response);
            }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                processRequest(request, response);
                String idOld = request.getParameter("idCatedratico");
                String nuevoNombre = request.getParameter("nuevoNombre");
                CatedraticoDao nuevoCatedratico = new CatedraticoDao();
                nuevoCatedratico.modificarCatedratico(Integer.parseInt(idOld), new Catedratico(nuevoNombre));
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
