package module.performance.model;

import DBmanager.SQLmanager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import business.Bilan;
import java.sql.Date;

/**
 * Classe de lecture des bilans
 */
public class BilanModel {
  
   public static ArrayList<Bilan> lireBilan(int id) throws ClassNotFoundException, SQLException, Exception {

        /*----- Requête SQL -----*/
        String sql = "SELECT * FROM TR_EFFECTUERBILAN WHERE IDCLIENT = ?";

        /*----- Interrogation de la base -----*/
        ArrayList<Bilan> liste = new ArrayList<>();
        
        try (PreparedStatement stmt = SQLmanager.getInstance().prepareStatement(sql)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    liste.add(new Bilan(rs.getInt("IDS"), rs.getDate("DATEOCCPROG"), rs.getInt("FC5MINS"), rs.getInt("FC30FLEXIONS"), rs.getInt("FC1MIN")));
                }
                stmt.close();
                return liste;
        } catch (SQLException e) {
            throw new Exception("Problème " + e.getMessage());
        }        
    }

}
