package module.training.model;

import DBmanager.SQLmanager;
import business.Program;
import business.Seance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class SeanceModel {
    
    public static ArrayList<Seance> readSeanceWeek (int idClient) throws Exception {
        String sql = "SELECT oc.IDO, se.NOMS, se.DESCRIPTIF, oc.NUMSEM FROM SEANCE se, OCCURSEANCE oc "
                + "WHERE se.IDS = oc.IDS AND se.IDC = ? ORDER BY oc.NUMSEM ASC;";
        try (PreparedStatement stmt = SQLmanager.getInstance().prepareStatement(sql)) {
            stmt.setInt(1, idClient);           
            ResultSet rs = stmt.executeQuery();          
            ArrayList<Seance> seances = new ArrayList<>();
            while (rs.next()){
                seances.add(
                    new Seance(
                        rs.getInt("IDO"),
                        rs.getString("NOMS"),
                        rs.getInt("NUMSEM"),
                        rs.getString("DESCRIPTIF")
                    )
                );
            }
            rs.close();
            seances = verifierSeance(seances);
            return seances;
        } catch (SQLException e) {
            throw new Exception("Problème de training : programmeModel " + e.getMessage());
        }     
    }
    
    public static Program lireProgramme(int idUser) 
            throws ClassNotFoundException, SQLException, Exception {       
        /*----- Requête SQL -----*/
        String sql = "SELECT IDP, NOMP, DESCRIPTIF FROM PROGRAMME WHERE IDP = ?";     
        /*----- Interrogation de la base -----*/
        try (PreparedStatement stmt = SQLmanager.getInstance().prepareStatement(sql)) {
            stmt.setInt(1, idUser);       
            ResultSet rs = stmt.executeQuery();
            rs.first();
            Program p = new Program(
                    rs.getInt("IDP"),
                    rs.getString("NOMP"),
                    rs.getString("DESCRIPTIF")
                );
            rs.close();
            return p;
        } catch (SQLException e) {
            throw new Exception("Problème de training : programmeModel " + e.getMessage());
        }
    }
              
    public static int getWeekOfYear(String date) throws Exception 
    {
        // transformer le string à la date
        Date d = convertToDate(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        // chercher le numéro de semaine de cette année
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    public static Date convertToDate(String date) throws ParseException 
    { 
        //tranformer la date string à une date utile
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dayDateUtil=df.parse(date);
        //tranformer la date utile à une date sql
        return new java.sql.Date(dayDateUtil.getTime());
    }                        

    /**
     * Vérifie si les séances sont terminées ou non
     * @param seances
     * @throws Exception 
     */
    private static ArrayList<Seance> verifierSeance(ArrayList<Seance> seances) throws Exception {     
        try {
            String sql;
            PreparedStatement stmt;
            Connection cn = SQLmanager.getInstance();
            for (Seance s : seances) {
                sql = "SELECT b.FC1MIN FROM OCCURSEANCE oc ,BILAN b WHERE b.IDB = oc.IDB "
                        + "AND oc.IDO = ?";               
                stmt = cn.prepareStatement(sql);
                stmt.setInt(1, s.getIdO());
                ResultSet rs = stmt.executeQuery(); 
                if (rs.first()) {
                    int v = rs.getInt("FC1MIN");
                    if (v != 0) {
                        s.setCompleted(true);
                    } else {
                        s.setCompleted(false);
                    }                 
                } else {
                    sql = "SELECT e.IDEX FROM OCCURSEANCE oc, EXERCICE e WHERE oc.IDO = e.IDO"
                            + " AND oc.IDO = ? HAVING COUNT(oc.IDO) = ( "
                            + "SELECT COUNT(r.IDEX) FROM REALISER r WHERE r.IDO = ? )";
                    stmt = cn.prepareStatement(sql);
                    stmt.setInt(1, s.getIdO());
                    stmt.setInt(2, s.getIdO());
                    rs = stmt.executeQuery();
                    if (rs.first()) { 
                        s.setCompleted(true);
                    } else {
                        s.setCompleted(false);
                    }
                }
            }
            return seances;
        } catch (SQLException e) {
            throw new Exception("Problème de training : programmeModel " + e.getMessage());
        }
    }
    
    public static void main (String[] s) throws ClassNotFoundException, SQLException, Exception
    {
        for(Seance seance : readSeanceWeek(1)) {
            System.out.println(seance.getNomS());
            System.out.println(seance.getNumSem());
            System.out.println(seance.isCompleted());
        }
    }  
}
