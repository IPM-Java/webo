package DBmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLmanager {
    
    private static final String URL = "jdbc:mysql://dbmysql.cwhe7rqtpqtv.eu-west-3.rds.amazonaws.com:3306/projet.dev";
    
    private static final String LOGIN = "application";
    
    private static final String PASSWORD = "applicationipm";
    
    private static Connection connexion;

    public static Connection getInstance() throws Exception
    {
        if (SQLmanager.connexion == null) {
            try {
               Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new Exception(e.getMessage());
            }
            try {
                 SQLmanager.connexion = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            } catch (SQLException e) {
                throw new Exception(e.getMessage());
            }
        }
        return SQLmanager.connexion;
    }   
}
