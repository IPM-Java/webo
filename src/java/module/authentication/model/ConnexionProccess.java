package module.authentication.model;

import DBmanager.SQLmanager;
import business.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

public class ConnexionProccess {
    
    private static final String MAIL_INPUT = "email";    
    private static final String PASSWD_INPUT = "password";
    
    private static final String KEY_SESSION_USER = "user";
      
    public static boolean toConnect(HttpServletRequest request)throws Exception {        
        boolean isConnect = false;
        String sql = "SELECT c.IDC, c.NOMC, c.PRENOMC, u.MAILU, u.IDR, u.MDPU, c.DATENAISSANCE, c.IDP "
                + "FROM UTILISATEUR u, CLIENT c "
                + "WHERE u.IDU = c.IDU "
                + "AND MAILU = ?";                    
        try (PreparedStatement stmt = SQLmanager.getInstance().prepareStatement(sql)) {
                stmt.setString(1, getFieldValue(request, MAIL_INPUT));
                ResultSet rs = stmt.executeQuery();
                if (rs.first()) {
                    if (rs.getString("MDPU").equals(getFieldValue(request, PASSWD_INPUT))) {
                        request.getSession().setAttribute(KEY_SESSION_USER, hydrate(rs));
                        isConnect = true;
                    }
                }
                stmt.close();
                return isConnect;
        } catch (SQLException e) {
            throw new Exception("Problème " + e.getMessage());
        }
    }
    
    private static String getFieldValue(HttpServletRequest request, String field) {
        String valeur = request.getParameter(field);
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
    
    public static User hydrate(ResultSet rs) throws SQLException {
        return new User(rs.getInt("IDC"),
            rs.getString("NOMC"),
            rs.getString("PRENOMC"),
            rs.getString("MAILU"),
            true,
            rs.getInt("IDR"),
            rs.getDate("DATENAISSANCE"),
            rs.getInt("IDP")
        );     
    }    
}
