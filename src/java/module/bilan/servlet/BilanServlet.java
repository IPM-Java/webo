package module.bilan.servlet;

import business.BilanForm;
import business.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import module.bilan.model.BilanModel;
import utils.FormValidator;

@WebServlet(name = "BilanServlet", urlPatterns = {"/BilanServlet"})
public class BilanServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {       
        User user = (User)request.getSession().getAttribute("user");
        int id = user.getId();
        
        BilanForm bilan = hydrate(request);
        
        BilanModel.insererBilan(bilan);
        
        
    }
    
    private BilanForm hydrate(HttpServletRequest request)
    {
        return new BilanForm(
            (int)request.getAttribute("fc1"),
            (int)request.getAttribute("fc2"),
            (int)request.getAttribute("fc3"),
            (float)request.getAttribute("bras"),
            (float)request.getAttribute("poitrine"),
            (float)request.getAttribute("taille"),
            (float)request.getAttribute("hanches"),
            (float)request.getAttribute("cuisses"),
            (int)request.getAttribute("gainage"),
            (int)request.getAttribute("fdroite"),
            (int)request.getAttribute("fgauche"),
            (int)request.getAttribute("crunch"),
            (int)request.getAttribute("pompe"),
            (int)request.getAttribute("squat"),
            (int)request.getAttribute("dips")
        );
    }

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
        request.getRequestDispatcher("realiser-bilan").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
