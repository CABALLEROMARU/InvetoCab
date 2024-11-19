/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventocab.Controller;

import inventocab.Models.UserInfoModel;
import java.sql.SQLException;



public class UserController {
    AddUserController DAO;
    public UserController() {
        this.DAO = new AddUserController();
    }
   public boolean registerUser(UserInfoModel data) throws ClassNotFoundException, SQLException{
       String encryptedPassword = DAO.encryptPass(new String(data.getPassword()));
       data.setPassword(encryptedPassword.toCharArray());
       return DAO.addUserToDatabase(data);
   }
   public UserInfoModel Login(UserInfoModel data) throws SQLException{
       String encryptedPassword = DAO.encryptPass(new String(data.getPassword()));
       data.setPassword(encryptedPassword.toCharArray());
       return this.DAO.Signin(data);
   }
}
