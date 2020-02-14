package module.bilan.servlet;

import business.BilanForm;
import business.User;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import module.bilan.model.BilanModel;
import utils.TimeHelper;

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
        int programme = user.getProgramme();
        
        BilanForm bilan = instance(request);
              
        BilanModel.insererBilan(bilan, id, programme);               
    }
    
    private BilanForm instance(HttpServletRequest request)
    {
        boolean isFitness = Boolean.valueOf(request.getParameter("isFitness"));
        if (isFitness) {
            return new BilanForm(
                Integer.valueOf(request.getParameter("fc1")),
                Integer.valueOf(request.getParameter("fc2")),
                Integer.valueOf(request.getParameter("fc3")),
                Integer.valueOf(request.getParameter("bras")),
                Integer.valueOf(request.getParameter("poitrine")),
                Integer.valueOf(request.getParameter("taille")),
                Integer.valueOf(request.getParameter("hanches")),
                Integer.valueOf(request.getParameter("cuisses")),
                TimeHelper.toMins(request.getParameter("gainage")),
                Integer.valueOf(request.getParameter("fdroite")),
                Integer.valueOf(request.getParameter("fgauche")),
                Integer.valueOf(request.getParameter("crunch")),
                Integer.valueOf(request.getParameter("pompe")),
                Integer.valueOf(request.getParameter("squat")),
                Integer.valueOf(request.getParameter("dips")),
                Integer.valueOf((String)request.getSession().getAttribute("occurence")),
                Float.valueOf(request.getParameter("poids")),
                (String)request.getParameter("comment")
            );           
        } else {
             return new BilanForm(
                Integer.valueOf(request.getParameter("fc1")),
                Integer.valueOf(request.getParameter("fc2")),
                Integer.valueOf(request.getParameter("fc3")),
                TimeHelper.toMins(request.getParameter("gainage")),
                Integer.valueOf(request.getParameter("fdroite")),
                Integer.valueOf(request.getParameter("fgauche")),
                Integer.valueOf(request.getParameter("crunch")),
                Integer.valueOf(request.getParameter("pompe")),
                Integer.valueOf(request.getParameter("squat")),
                Integer.valueOf(request.getParameter("dips")),
                Integer.valueOf((String)request.getSession().getAttribute("occurence")),
                Float.valueOf(request.getParameter("poids")),
                (String)request.getParameter("comment")
            );           
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
        
        // User user = (User)request.getSession().getAttribute("user");
        //boolean isFitness = user.getStatusFitness;       
        boolean isFitness = false;
        
        request.setAttribute("isFitness", isFitness);
        
        request.getSession().setAttribute("occurence", request.getParameter("occurence"));
        
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(BilanServlet.class.getName()).log(Level.SEVERE, null, ex);
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
