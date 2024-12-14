
package inventocab.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnection {
 private static DatabaseConnection instance;
    private Connection connection;

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
    public DatabaseConnection() {
        
        
    }
     public Connection getConnection() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/inventocab_db", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            java.util.logging.Logger.getLogger(DatabaseConnection.class.getName()).log(java.util.logging.Level.SEVERE, null, e);

        return null;
    }
    }
      public void closeConnection(Connection connection){
        try{
            if (connection != null&& !connection.isClosed()){
               connection.close(); 
            }
        } catch (SQLException e){
          e.printStackTrace();
        }
    }
}
