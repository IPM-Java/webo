package module.bilan.model;

import DBmanager.SQLmanager;
import business.BilanForm;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BilanModel {

    public static void insererBilan(BilanForm bilan) throws Exception
    {
        String sql = "";                    
        try (PreparedStatement stmt = SQLmanager.getInstance().prepareStatement(sql)) {
                //stmt.setString();
                ResultSet rs = stmt.executeQuery();
                stmt.close();               
        } catch (SQLException e) {
            throw new Exception("Problème (insererBilan) : " + e.getMessage());
        }
        insererNotification();
    }
    
    private static void insererNotification() throws Exception
    {
        String sql = "";                    
        try (PreparedStatement stmt = SQLmanager.getInstance().prepareStatement(sql)) {
                //stmt.setString();
                ResultSet rs = stmt.executeQuery();
                stmt.close();               
        } catch (SQLException e) {
            throw new Exception("Problème insererNotification() : " + e.getMessage());
        }       
    }
}
