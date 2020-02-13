/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.training.model;

import DBmanager.SQLmanager;
import business.Program;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author iris0
 */
public class ProgressModel {

    public static int afficherExoProgramme(int idC ) throws ClassNotFoundException, SQLException, Exception {

        int nb = 0;
        
        //ArrayList<Program> lPrograms = SeanceModel.lireProgramme(idC);
        
        int idP = 1 ;
//        for (Program program : lPrograms){
//            idP = program.getIdP();}
        
        
        /*----- Requête SQL pour trouver le nb exo total dans le programme-----*/
        String sql = "SELECT  count(ce.IdEx) "
                + "FROM Programme p, contenirSeance cs, Seance s, contenirExercice ce "
                + "WHERE p.IdP = cs.IdP "
                + "AND cs.IdS = s.IdS "
                + "AND s.IdS = ce.IdS "
                + "AND p.IdC =? "
                + "AND p.IdP ="+idP+" " ;
        /*----- Interrogation de la base -----*/
        
        try (PreparedStatement stmt = SQLmanager.getInstance().prepareStatement(sql)) {

            stmt.setInt(1, idC);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {         
                nb =  Integer.parseInt(rs.getString(1));
            }
            
            
        } catch (SQLException e) {
            throw new Exception("Problème de training : programmeModel " + e.getMessage());
        }   
        
        return nb;
    }
    
    public static int realiserExoProgramme(int idC ) throws ClassNotFoundException, SQLException, Exception {

        int nb = 0;
        
        //ArrayList<Program> lPrograms = SeanceModel.lireProgramme(idC);
        
        int idP = 1 ;
//        for (Program program : lPrograms){
//            idP = program.getIdP();}
        
        
        /*----- Requête SQL pour trouver le nb exo total dans le programme-----*/
        String sql = "SELECT  count(r.IdEx) "
                + "FROM Realiser r, OccurSeance os, contenirSeance cs, Seance s "
                + "WHERE r.IdO = os.IdO "
                + "AND os.IdS = s.IdS "
                + "AND s.IdS = cs.IdS "
                + "AND r.IdC =? "
                + "AND cs.IdP ="+idP+" " ;
        /*----- Interrogation de la base -----*/
        
        try (PreparedStatement stmt = SQLmanager.getInstance().prepareStatement(sql)) {

            stmt.setInt(1, idC);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {         
                nb =  Integer.parseInt(rs.getString(1));
            }
            
            
        } catch (SQLException e) {
            throw new Exception("Problème de training : programmeModel " + e.getMessage());
        }   
        
        return nb;
    }
    
    public static float tauxRealiserProgramme(int idC) throws SQLException, Exception {   
        int nbTotal = ProgressModel.afficherExoProgramme(idC);
        int nbReal = ProgressModel.realiserExoProgramme(idC);
        
        float tauxReal = (float) nbReal/nbTotal;
        
        return tauxReal;
    
    }
    
    public static void main(String[] args) {
        try {
            System.out.println(ProgressModel.tauxRealiserProgramme(1));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }
}
