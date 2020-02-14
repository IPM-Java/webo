package module.training.model;

import DBmanager.SQLmanager;
import business.Exercice;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExerciceModel {
    
    public static ArrayList<Exercice> getListExoSeance(int idOccurence) throws Exception
    {
        String sql = "SELECT e.IDEX, te.IDTY, e.NOMEX, e.DESCRIPTIFEX, e.NBTEMPS, e.NBREP, e.SERIE, e.ORDRE, te.Objectif "
                + "FROM EXERCICE e, OCCURSEANCE oc, TYPE_EX te WHERE e.IDO = oc.IDO AND oc.IDO = ? "
                + "AND te.IDTY = e.IDTY ORDER BY e.ORDRE";
        try (PreparedStatement stmt = SQLmanager.getInstance().prepareStatement(sql)) {
            stmt.setInt(1, idOccurence);           
            ResultSet rs = stmt.executeQuery();          
            ArrayList<Exercice> exercices = new ArrayList<>();
            while (rs.next()){
                exercices.add(
                    new Exercice(
                        rs.getInt("IDEX"),
                        rs.getInt("NBREP"),
                        rs.getInt("NBTEMPS"),
                        rs.getString("NOMEX"),
                        rs.getInt("SERIE"),
                        rs.getInt("ORDRE"),
                        rs.getString("Objectif"),
                        rs.getInt("IDTY")
                    )
                );
            }
            rs.close();
            return exercices;
        } catch (SQLException e) {
            throw new Exception("Problème de training : programmeModel " + e.getMessage());
        }  
    }
    
    public static void insererExercice(int idExercice, int idOcc, int idUser, String value, String action) throws Exception
    {
        String sql = "INSERT INTO REALISER (IDEX, IDC, IDO, DATEREALISATION, DIFFICULTE, status) VALUES "
                + "(?, ?, ?, NOW(), ?, ?);";
        try (PreparedStatement stmt = SQLmanager.getInstance().prepareStatement(sql)) {
            stmt.setInt(1, idExercice);
            stmt.setInt(2, idUser);
            stmt.setInt(3, idOcc);
            stmt.setString(4, value);
            stmt.setString(5, action);
            stmt.executeUpdate();
            stmt.close();               
        } catch (SQLException e) {
            throw new Exception("Problème (insererExercice) : " + e.getMessage());
        }       
    }
    
    public static void sauterExercice(int idExercice, int idOcc, int idUser, String action) throws Exception
    {
        String sql = "INSERT INTO REALISER (IDEX, IDC, IDO, DATEREALISATION, DIFFICULTE, status) VALUES "
                + "(?, ?, ?, NOW(), ?, ?);";
        try (PreparedStatement stmt = SQLmanager.getInstance().prepareStatement(sql)) {
            stmt.setInt(1, idExercice);
            stmt.setInt(2, idUser);
            stmt.setInt(3, idOcc);
            stmt.setString(4, "");
            stmt.setString(5, action);
            stmt.executeUpdate();
            stmt.close();               
        } catch (SQLException e) {
            throw new Exception("Problème (insererExercice) : " + e.getMessage());
        }       
    }
    
    public static void cancelSeance(int id, int occ) throws Exception
    {
        String sql = "DELETE FROM REALISER WHERE IDC = ? AND IDO = ?;";
        try (PreparedStatement stmt = SQLmanager.getInstance().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setInt(2, occ);
            stmt.execute();
            stmt.close();               
        } catch (SQLException e) {
            throw new Exception("Problème (insererExercice) : " + e.getMessage());
        }         
    }
       
}