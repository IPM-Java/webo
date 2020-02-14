package module.training.servlet;

import business.Exercice;
import business.Program;
import business.Seance;
import business.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import module.training.model.ExerciceModel;
import module.training.model.SeanceModel;

@WebServlet(name = "ExerciceServlet", urlPatterns = {"/ExerciceServlet"})
public class ExerciceServlet extends HttpServlet {

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
        
        try {
            int idOcc = Integer.valueOf(request.getParameter("occurence"));
            ArrayList<Exercice> exercices = ExerciceModel.getListExoSeance(idOcc);
            request.setAttribute("exercices", exercices);
                        
            User user = (User)request.getSession().getAttribute("user");
            int userId = user.getId();
            
            ArrayList<Integer> ids = new ArrayList<>();
            ids.add(idOcc);
            ids.add(userId);
            
            request.setAttribute("ids", ids);
                   
            request.getRequestDispatcher("realiser-seance").forward(request, response);       
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //request.setAttribute("error", e);
            //request.getRequestDispatcher("ErrorHandlerServlet").forward(request, response); 
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ExerciceServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ExerciceServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
