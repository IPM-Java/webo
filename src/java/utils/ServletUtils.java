package utils;

import javax.servlet.http.HttpServletRequest;

public class ServletUtils {
    
    private static String getFieldValue(HttpServletRequest request, String field) {
        String valeur = request.getParameter(field);
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    } 
    
}
