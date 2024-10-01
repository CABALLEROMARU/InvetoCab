/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventocab.Controller;

import java.sql.Connection;
import inventocab.JDBC.DatabaseConnection;
import inventocab.Models.UserInfoModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import inventocab.Models.UserInfoModel;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;


/**
 *
 * @author Calyle
 */
public class AddUserController {
    private DatabaseConnection databaseConnection;
    public AddUserController(){
        databaseConnection = new DatabaseConnection();
    }
   public boolean addUserToDatabase(UserInfoModel data) throws ClassNotFoundException, SQLException{
        String sql =  "INSERT INTO loginsystem (userName, Password) VALUES (?, ?)";
       try (Connection connection = databaseConnection.getConnection();
       PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             
            preparedStatement.setString(1, data.getUsername());
            preparedStatement.setString(2, new String(data.getPassword()));

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(AddUserController.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
            return false;
        
    }
   }
   public UserInfoModel Signin(UserInfoModel data) throws SQLException{
       String sql = "SELECT * FROM loginsystem WHERE userName LIKE ? AND Password LIKE ?";
       try (Connection connection = databaseConnection.getConnection();
             PreparedStatement p = connection.prepareStatement(sql)){
           p.setString(1, data.getUsername());
            p.setString(2, new String(data.getPassword()));

           ResultSet rs = p.executeQuery();
           if(rs.next()){
               return new UserInfoModel(rs.getString("userName"), rs.getString("Password").toCharArray());
               
           }else{
               return null;
           }
    }catch (Exception e){
        e.printStackTrace();
        return null;
    }
   }

   public String encryptPass(String password){
        try {
            MessageDigest digestor = MessageDigest.getInstance("SHA-256");
            byte [] encodeHash = digestor.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder encryptionValue = new StringBuilder(2 * encodeHash.length);
            
             for (int i = 0; i < encodeHash.length; i++) {
                String hexVal = Integer.toHexString(0xff & encodeHash[i]);
                if (hexVal.length() == 1) {
                    encryptionValue.append('0');
                }
                encryptionValue.append(hexVal);
            }
             return encryptionValue.toString();
        } catch (Exception e) {
             return e.getMessage();
        }
    }
}
