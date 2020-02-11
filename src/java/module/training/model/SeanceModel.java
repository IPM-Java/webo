/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.training.model;

import DBmanager.SQLmanager;
import business.Seance;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author iris0
 */
public class SeanceModel {

        public static ArrayList<Seance> readSeanceWeek (int idClient) throws Exception {
        
//      int int_idClient = Integer. parseInt(idClient);
        //espace de requête
        PreparedStatement st ;
        
        Date dateToday;
        
        ArrayList al = new ArrayList();
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = sDateFormat.format(new java.util.Date());
        int nbweek = SeanceModel.getWeekOfYear(date);
        
        //Requête SQL
        String sql = " SELECT  o.IdO, s.nomS, o.numSem "
                + " FROM OccurSeance o, Seance s, "
                + " Programme p, contenirSeance cs "
                + " WHERE p.IdC = ? "
                + " and cs.IdP = p.IdP and cs.IdS = s.IdS and s.IdS = o.IdS "
                + " order by o.numSem ASC " ;
                
                //+ " and o.numSem ="+ nbweek +" order by o.numSem ASC ";
        
        
        try (PreparedStatement stmt = SQLmanager.getInstance().prepareStatement(sql)) {

            stmt.setInt(1, idClient);
            
            ResultSet rs = stmt.executeQuery();
            
             while (rs.next()){
                    //al.add(rs.getString(1) + rs.getString(2));
                    
                    al.add(new Seance (rs.getInt("IdO"),rs.getString("nomS"),rs.getInt("numSem")));
                    System.out.println(rs.getInt("numSem"));
                    //al.add(new Seance(rs.getInt(1),rs.getString(2 ),rs.getInt(3))); 
                }
        } catch (SQLException e) {
            throw new Exception("Problème de training : programmeModel " + e.getMessage());
        } 
            return al;        
    }
        
        
       public static int getWeekOfYear(String date) throws Exception {
            // transformer le string à la date
            Date d = convertToDate(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(d);

            // chercher le numéro de semaine de cette année
            return calendar.get(Calendar.WEEK_OF_YEAR);
            }

        public static Date convertToDate(String date) throws ParseException { 

            //tranformer la date string à une date utile
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dayDateUtil=df.parse(date);

            //tranformer la date utile à une date sql
            java.sql.Date dayDateSql = new java.sql.Date(dayDateUtil.getTime());

            return dayDateSql;

         }    
       public static int readSeanceIdWeek (int idClient) throws Exception {
        
//      int int_idClient = Integer. parseInt(idClient);
        //espace de requête
        PreparedStatement st ;
        
        Date dateToday;
        int nb=0;
        
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = sDateFormat.format(new java.util.Date());
        int nbweek = SeanceModel.getWeekOfYear(date);
        
        //Requête SQL
        String sql = " SELECT Distinct o.IdS"
                + " FROM OccurSeance o, Seance s, "
                + " Programme p, contenirSeance cs "
                + " WHERE p.IdC = ? "
                + " and cs.IdP = p.IdP and cs.IdS = s.IdS and s.IdS = o.IdS "
                + " and o.numSem ="+ nbweek +" order by o.numSem ASC ";
        
        
        try (PreparedStatement stmt = SQLmanager.getInstance().prepareStatement(sql)) {

            stmt.setInt(1, idClient);
            
            ResultSet rs = stmt.executeQuery();
            
             while (rs.next()){
                    //al.add(rs.getString(1) + rs.getString(2));
                    nb =rs.getInt(1); 
                }
        } catch (SQLException e) {
            throw new Exception("Problème de training : programmeModel " + e.getMessage());
        } 
            return nb;        
    }        
        
    public static void main (String[] s) throws ClassNotFoundException, SQLException, Exception
		{
                    //ArrayList<Seance> verifySeance = SeanceModel.readSeanceWeek(1);
                    ArrayList<Seance> verifySeance = SeanceModel.readSeanceWeek(1);
                    System.out.println(verifySeance);
                }                    
}
