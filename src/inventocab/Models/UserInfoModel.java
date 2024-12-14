
package inventocab.Models;


public class UserInfoModel {

   
    public String getUsername() {
        return userName;
    }

    
    public void setUsername(String userName) {
        this.userName = userName;
    }

    
    public char[] getPassword() {
        return Password;
    }

    
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
