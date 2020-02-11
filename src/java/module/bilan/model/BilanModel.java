package module.bilan.model;

import DBmanager.SQLmanager;
import business.BilanForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BilanModel {

    public static void insererBilan(BilanForm bilan, int idClient) throws Exception
    {
        // User user = (User)request.getSession().getAttribute("user");
        //boolean isFitness = user.getStatusFitness;       
        boolean isFitness = false;
        
        String sql;
        if (isFitness) {
            sql = "INSERT INTO Bilan (IdO, IdC, fc1min, fc30Flexion, fc5min, Poids, Bras, Poitrine, Traille, Hanches, Cuisses, Comment) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        } else {
            sql = "INSERT INTO Bilan (IdO, IdC, fc1min, fc30Flexion, fc5min, Poids, Comment) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        }                         
        try (PreparedStatement stmt = SQLmanager.getInstance().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) { 
            if (isFitness) {
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
            } else {
                stmt.setInt(1, bilan.getOccurence());
                stmt.setInt(2, idClient);
                stmt.setInt(3, bilan.getFc1());
                stmt.setInt(4, bilan.getFc2());
                stmt.setInt(5, bilan.getFc3());
                stmt.setFloat(6, bilan.getPoids());
                stmt.setString(7, bilan.getComment());
            }
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int idBilan = rs.getInt(1);
                    insererNotification(idClient, idBilan);
                }
                rs.close();
            }
            stmt.close();
            insererExercice(bilan, idClient);
                                       
        } catch (SQLException e) {
            throw new Exception("Problème (insererBilan) : " + e.getMessage());
        }

    }
    
    private static void insererExercice(BilanForm bilan, int idClient) throws Exception
    {
        String sql;                          
        try {
            Connection db = SQLmanager.getInstance();           
            sql = "INSERT INTO Realiser (IdC, IdO, IdEx, DateRealisation, nbRep) VALUES (?, ?, ?, NOW(), ?)";          
            PreparedStatement stmt = SQLmanager.getInstance().prepareStatement(sql);
            stmt.setInt(1, idClient);
            stmt.setInt(2, bilan.getOccurence());
            stmt.setInt(3, 11);
            stmt.setInt(4, bilan.getGainage());
            stmt.executeUpdate();
            
            sql = "INSERT INTO Realiser (IdC, IdO, IdEx, DateRealisation, nbRep) VALUES (?, ?, ?, NOW(), ?)";          
            stmt = SQLmanager.getInstance().prepareStatement(sql);
            stmt.setInt(1, idClient);
            stmt.setInt(2, bilan.getOccurence());
            stmt.setInt(3, 12);
            stmt.setInt(4, bilan.getFente_g());
            stmt.executeUpdate();
            
            sql = "INSERT INTO Realiser (IdC, IdO, IdEx, DateRealisation, nbRep) VALUES (?, ?, ?, NOW(), ?)";          
            stmt = SQLmanager.getInstance().prepareStatement(sql);
            stmt.setInt(1, idClient);
            stmt.setInt(2, bilan.getOccurence());
            stmt.setInt(3, 13);
            stmt.setInt(4, bilan.getFente_d());
            stmt.executeUpdate();
            
            sql = "INSERT INTO Realiser (IdC, IdO, IdEx, DateRealisation, nbRep) VALUES (?, ?, ?, NOW(), ?)";          
            stmt = SQLmanager.getInstance().prepareStatement(sql);
            stmt.setInt(1, idClient);
            stmt.setInt(2, bilan.getOccurence());
            stmt.setInt(3, 14);
            stmt.setInt(4, bilan.getCrunch());
            stmt.executeUpdate();
            
            sql = "INSERT INTO Realiser (IdC, IdO, IdEx, DateRealisation, nbRep) VALUES (?, ?, ?, NOW(), ?)";          
            stmt = SQLmanager.getInstance().prepareStatement(sql);
            stmt.setInt(1, idClient);
            stmt.setInt(2, bilan.getOccurence());
            stmt.setInt(3, 15);
            stmt.setInt(4, bilan.getPompe());
            stmt.executeUpdate();
                    
            sql = "INSERT INTO Realiser (IdC, IdO, IdEx, DateRealisation, nbTemps) VALUES (?, ?, ?, NOW(), ?)";          
            stmt = SQLmanager.getInstance().prepareStatement(sql);
            stmt.setInt(1, idClient);
            stmt.setInt(2, bilan.getOccurence());
            stmt.setInt(3, 16);
            stmt.setInt(4, bilan.getSquat());
            stmt.executeUpdate();
            
            sql = "INSERT INTO Realiser (IdC, IdO, IdEx, DateRealisation, nbTemps) VALUES (?, ?, ?, NOW(), ?)";          
            stmt = SQLmanager.getInstance().prepareStatement(sql);
            stmt.setInt(1, idClient);
            stmt.setInt(2, bilan.getOccurence());
            stmt.setInt(3, 17);
            stmt.setInt(4, bilan.getDips());
            stmt.executeUpdate();
            
            stmt.close();               
        } catch (SQLException e) {
            throw new Exception("Problème insererNotification() : " + e.getMessage());
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
