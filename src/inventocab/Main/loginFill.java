/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package inventocab.Main;

import inventocab.Controller.UserController;
import inventocab.Models.UserInfoModel;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import raven.modal.ModalDialog;
import raven.modal.component.SimpleModalBorder;
import raven.modal.option.Location;
import raven.modal.option.Option;

public class loginFill extends javax.swing.JPanel {

    
    public UserInfoModel getUser() {
          String username = Username.getText();
    char[] password = Password.getPassword();
        return new UserInfoModel(username, password);
    }

   
    public void setUser(UserInfoModel user) {
        this.user = user;
    }

    public loginFill() {
        initComponents();
    }
public void loginFill (){
    Username.grabFocus();
}
public void addEventSignin (ActionListener event){
    cmdSignup.addActionListener(event);
}

   private UserInfoModel user;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Username = new inventocab.Swing.loginTextfield();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Password = new inventocab.Swing.loginPassword();
        jLabel3 = new javax.swing.JLabel();
        loginButton1 = new inventocab.Swing.loginButton();
        cmdSignup = new javax.swing.JButton();

        Username.setText("test");

        jLabel1.setText("User Name");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Login");

        Password.setText("test1");

        jLabel3.setText("Password");

        loginButton1.setBackground(new java.awt.Color(255, 51, 51));
        loginButton1.setForeground(new java.awt.Color(255, 255, 255));
        loginButton1.setText("Log in");
        loginButton1.setColor(new java.awt.Color(255, 51, 51));
        loginButton1.setColorOver(new java.awt.Color(255, 204, 102));
        loginButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        loginButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButton1ActionPerformed(evt);
            }
        });

        cmdSignup.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cmdSignup.setForeground(new java.awt.Color(255, 102, 51));
        cmdSignup.setText("Sign up");
        cmdSignup.setContentAreaFilled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(loginButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmdSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 20, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(loginButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loginButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButton1ActionPerformed
        
        String username = Username.getText();
    char[] password = Password.getPassword();
    UserInfoModel loginUser = new UserInfoModel(username, password);
    UserController controller = new UserController();
        
 

    try {

 UserInfoModel loggedInUser = controller.Login(loginUser);

    if (loggedInUser != null) {
       
        Option option = ModalDialog.createOption();
        option.getLayoutOption()
              
              .setLocation(Location.CENTER, Location.CENTER)
              .setAnimateDistance(0.7f, 0);

        
        SimpleModalBorder.Option[] options = new SimpleModalBorder.Option[]{
            new SimpleModalBorder.Option("Continue", SimpleModalBorder.OK_OPTION)
        };

       
        final login topFrame = (login) SwingUtilities.getWindowAncestor(this);
        Main main = new Main();
 topFrame.setVisible(false);
                        main.setVisible(true);
      

    } else {
       
        JOptionPane.showMessageDialog(this, "Login failed: Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
    }

} catch (Exception e) {
   
    e.printStackTrace();
    JOptionPane.showMessageDialog(this, "An unexpected error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_loginButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private inventocab.Swing.loginPassword Password;
    private inventocab.Swing.loginTextfield Username;
    private javax.swing.JButton cmdSignup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private inventocab.Swing.loginButton loginButton1;
    // End of variables declaration//GEN-END:variables
}
