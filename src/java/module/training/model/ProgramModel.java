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
public class ProgramModel {

        public static ArrayList<Program> lireProgramme(int id) throws ClassNotFoundException, SQLException, Exception {

        int idS = SeanceModel.readSeanceIdWeek(id);
        
        /*----- Requête SQL -----*/
        String sql = "SELECT * "
                    + "FROM Programme p, contenirSeance cs "
                    + "WHERE p.IdP = cs.IdP "
                    + "AND p.IdC=? "
                    + "AND cs.IdS=? ";
        
        /*----- Interrogation de la base -----*/
        ArrayList<Program> liste = new ArrayList<>();
        try (PreparedStatement stmt = SQLmanager.getInstance().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setInt(2, idS);
            
            ResultSet rs = stmt.executeQuery();

           while (rs.next()) {
                liste.add(new Program(rs.getInt("IdP") , rs.getString("nomP"), rs.getString("descriptionP")));
                System.out.println(liste.get(0).getNomP());

            }
            return liste;

        } catch (SQLException e) {
            throw new Exception("Problème de training : programmeModel " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {

            System.out.println(ProgramModel.lireProgramme(1));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }  
    
    
}
