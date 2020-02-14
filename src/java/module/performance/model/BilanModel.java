package module.performance.model;

import DBmanager.SQLmanager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import business.Bilan;
import business.Exercice;

/**
 * Classe de lecture des bilans
 */
public class BilanModel {
    
    public static ArrayList<Bilan> lireBilan(int id) throws ClassNotFoundException, SQLException, Exception {
        String sql = "SELECT * "
                + "FROM Bilan b, OccurSeance o, Realiser r, Exercice e "
                + "where b.IdO = r.IdO "
                + "AND o.IdO = r.IdO "
                + "AND r.IdEx = e.IdEx "
                + "AND b.IdC = ? "
                + "group BY o.IdO; ";
        

        ArrayList<Bilan> bilans = new ArrayList<>();
        try (PreparedStatement stmt = SQLmanager.getInstance().prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Bilan bilan = new Bilan(
                       rs.getInt("IdB"),
                       rs.getInt("IdO"),
                       rs.getDate("DateRealisation"),
                       rs.getInt("fc5min"),
                       rs.getInt("fc30Flexion"),
                       rs.getInt("fc1min"),
                       rs.getInt("Poids"),
                       rs.getInt("IdEx"),
                       rs.getInt("nbRep"),
                       rs.getInt("nbTemps"),
                       rs.getString("nomEx"),
                       rs.getFloat("Bras"),
                       rs.getFloat("Poitrine"),
                       rs.getFloat("Taille"),
                       rs.getFloat("Hanches"),
                       rs.getFloat("Cuisses")
                );
                bilan.setExercices(lireExercice(bilan.getIdB()));
                bilans.add(bilan);
            }
            return bilans;
        } catch (SQLException e) {
            throw new Exception("Problème " + e.getMessage());
        }
    }

     public static ArrayList<Exercice> lireExercice(int id) throws ClassNotFoundException, SQLException, Exception {
        String sql2 = "SELECT * "
            + "FROM Bilan b, OccurSeance o, Realiser r, Exercice e "
            + "where b.IdO = r.IdO "
            + "AND o.IdO = r.IdO "
            + "AND r.IdEx = e.IdEx "
            + "AND b.IdB = ?; ";       

        ArrayList<Exercice> exercice = new ArrayList<>();
        try (PreparedStatement stmt = SQLmanager.getInstance().prepareStatement(sql2)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
               exercice.add(new Exercice(rs.getInt("IdEx"),
                       rs.getInt("nbRep"),
                       rs.getInt("nbTemps"),
                       rs.getString("nomEx")
               ));
            }
            return exercice;
        } catch (SQLException e) {
            throw new Exception("Problème " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        try {
            System.out.println(BilanModel.lireBilan(2));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

