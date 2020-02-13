package module.bilan.model;

import DBmanager.SQLmanager;
import business.BilanForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BilanModel {

    public static void insererBilan(BilanForm bilan, int idClient, int programme) throws Exception
    {
        String sql;
        if (programme == 3) {
            sql = "INSERT INTO BILAN (IDO, IDC, FC1MIN, FC30FLEXION, FC5MIN, POIDS, "
                    + "BRAS, POITRINE, TAILLE, HANCHES, CUISSES, COMMENT, GAINAGE, FENTESG, "
                    + "FENTESD, CRUNCH, POMPES, SQUATS, DIPS);"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        } else {
            sql = "INSERT INTO Bilan (IDO, IDC, FC1MIN, FC30FLEXION, FC5MIN, POIDS, COMMENT, "
                    + "GAINAGE, FENTESG, FENTESD, CRUNCH, POMPES, SQUATS, DIPS) VALUES "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        }                         
        try (PreparedStatement stmt = SQLmanager.getInstance().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) { 
            if (programme == 3) {
                stmt.setInt(1, bilan.getOccurence());
                stmt.setInt(2, idClient);
                stmt.setInt(3, bilan.getFc1());
                stmt.setInt(4, bilan.getFc2());
                stmt.setInt(5, bilan.getFc3());
                stmt.setFloat(6, bilan.getPoids());
                stmt.setInt(7, bilan.getBras());
                stmt.setInt(8, bilan.getPoitrine());
                stmt.setInt(9, bilan.getTaille());
                stmt.setInt(10, bilan.getHanches());
                stmt.setInt(11, bilan.getJambes());
                stmt.setString(12, bilan.getComment());
                stmt.setInt(13, bilan.getGainage());
                stmt.setInt(14, bilan.getFente_g());
                stmt.setInt(15, bilan.getFente_d());
                stmt.setInt(16, bilan.getCrunch());
                stmt.setInt(17, bilan.getPompe());
                stmt.setInt(4, bilan.getSquat());
                stmt.setInt(18, bilan.getDips());
            } else {
                stmt.setInt(1, bilan.getOccurence());
                stmt.setInt(2, idClient);
                stmt.setInt(3, bilan.getFc1());
                stmt.setInt(4, bilan.getFc2());
                stmt.setInt(5, bilan.getFc3());
                stmt.setFloat(6, bilan.getPoids());
                stmt.setString(7, bilan.getComment());
                stmt.setInt(8, bilan.getGainage());
                stmt.setInt(9, bilan.getFente_g());
                stmt.setInt(10, bilan.getFente_d());
                stmt.setInt(11, bilan.getCrunch());
                stmt.setInt(12, bilan.getPompe());
                stmt.setInt(13, bilan.getSquat());
                stmt.setInt(14, bilan.getDips());
            }
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int idBilan = rs.getInt(1);
                    //insererNotification(idClient, idBilan);
                }
                rs.close();
            }
            stmt.close();
                                       
        } catch (SQLException e) {
            throw new Exception("Problème (insererBilan) : " + e.getMessage());
        }

    }
    
    private static void insererNotification(int idClient, int idBilan) throws Exception {
        String sql = "INSERT INTO Notification (IdC, IdB, DateHeureBilan, Vu) VALUES (?, ?, NOW(), 0)";
        try (PreparedStatement stmt = SQLmanager.getInstance().prepareStatement(sql)) {
            stmt.setInt(1, idClient);
            stmt.setInt(2, idBilan);
            stmt.executeUpdate();
            stmt.close();               
        } catch (SQLException e) {
            throw new Exception("Problème (insererBilan) : " + e.getMessage());
        }
    }
    
}
