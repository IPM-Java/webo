package module.authentication.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import module.authentication.model.ConnexionProccess;
import utils.FormValidator;

@WebServlet(name = "AuthentificationServlet", urlPatterns = {"/AuthentificationServlet"})
public class AuthentificationServlet extends HttpServlet {
    
    private static final String EMAIL_INPUTS  = "email";    
    private static final String PASSWD_INPUTS   = "password";
    
    private static final String LOGIN_VIEW = "login";
    private static final String TRAINNING_SERVLET = "TrainingHomeServlet";
    
    private static final String KEY_REQUEST_ERRORS = "error_input";
    
    private static final String KEY_REQUEST_AUTH_FAILED = "error_auth";    
    private static final String VALUE_REQUEST_AUTH_FAILED = "Identidiant ou mot de passe incorrect";
    
    private FormValidator validator;
    
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
        
        if (request.getParameter(EMAIL_INPUTS) != null && request.getParameter(PASSWD_INPUTS) != null) {                                  
           this.validator = validateInputs(request);          
            if (this.validator.isValid()) {
                boolean isConnected = ConnexionProccess.toConnect(request);
                if (isConnected) {
                    request.getRequestDispatcher(TRAINNING_SERVLET).forward(request, response);
                } else {
                    request.setAttribute(KEY_REQUEST_AUTH_FAILED, VALUE_REQUEST_AUTH_FAILED);
                    retryAtempt(request, response);
                }                
            } else {
                request.setAttribute(KEY_REQUEST_ERRORS, this.validator.getErrors());
                retryAtempt(request, response);
            }           
        } else {
            request.getRequestDispatcher(LOGIN_VIEW).forward(request, response);  
        }
        
    }
    
    private void retryAtempt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {               
        request.setAttribute(EMAIL_INPUTS, request.getParameter(EMAIL_INPUTS));
        request.setAttribute(PASSWD_INPUTS, request.getParameter(PASSWD_INPUTS));
        request.getRequestDispatcher(LOGIN_VIEW).forward(request, response);       
    }
    
    private static FormValidator validateInputs(HttpServletRequest request) {
        FormValidator validator = new FormValidator();
        validator.isEmpty(EMAIL_INPUTS, request.getParameter(EMAIL_INPUTS));
        validator.isEmpty(PASSWD_INPUTS, request.getParameter(PASSWD_INPUTS));
        return validator;
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
            Logger.getLogger(AuthentificationServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AuthentificationServlet.class.getName()).log(Level.SEVERE, null, ex);
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
