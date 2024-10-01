/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventocab.Models;

/**
 *
 * @author Calyle
 */
public class UserInfoModel {

    /**
     * @return the username
     */
    public String getUsername() {
        return userName;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public char[] getPassword() {
        return Password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(char[] Password) {
        this.Password = Password;
    }

    public UserInfoModel(String username, char[] password) {
        this.userName = username;
        this.Password = password;
    }
    
    private String userName;
    private char[] Password;
}
