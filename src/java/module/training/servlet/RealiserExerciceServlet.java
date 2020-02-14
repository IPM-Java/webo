package module.training.servlet;

import business.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import module.training.model.ExerciceModel;

@WebServlet(name = "RealiserExerciceServlet", urlPatterns = {"/RealiserExerciceServlet"})
public class RealiserExerciceServlet extends HttpServlet {

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
            throws ServletException, IOException {
        try {
            String action = (String)request.getParameter("action");
            int idExercice = Integer.valueOf(request.getParameter("exercice"));        
            int idOccurence = Integer.valueOf(request.getParameter("occurence"));
            int idUser = Integer.valueOf(request.getParameter("user"));
            if (action.equals("terminer")) {
                String value = (String)request.getParameter("value");
                ExerciceModel.insererExercice(idExercice, idOccurence, idUser, value, action);  
            } else {
                ExerciceModel.sauterExercice(idExercice, idOccurence, idUser, action); 
            }                    
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //request.setAttribute("error", e);
            //request.getRequestDispatcher("ErrorHandlerServlet").forward(request, response);
        }     
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
    }// </editor-fold>

}
