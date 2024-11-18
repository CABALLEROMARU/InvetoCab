/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package inventocab.Items;

import inventocab.Controller.BorrowerController;
import inventocab.Controller.ItemController;
import inventocab.Controller.ReturnController;
import inventocab.Event.EventItem;
import inventocab.Forms.BorrowLogs;
import inventocab.Forms.Item_Form;
import inventocab.Forms.PopItemForm;
import inventocab.Forms.addItemspop;
import inventocab.Models.BorrowerInfoModel;
import inventocab.Models.ItemsInfoModel;
import inventocab.Models.ReturnInfoModel;
import java.awt.Component;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import raven.datetime.component.date.DatePicker;
import raven.modal.ModalDialog;
import raven.modal.Toast;
import raven.modal.component.SimpleModalBorder;
import raven.modal.demo.simple.SimpleMessageModal;
import raven.modal.listener.ModalCallback;
import raven.modal.listener.ModalController;
import raven.modal.option.Location;
import raven.modal.option.Option;

/**
 *
 * @author Calyle
 */
public class ItemLogsPop extends javax.swing.JPanel {
    private BorrowerInfoModel data;
 private ItemsInfoModel items;
  private Item_Form itemForm; 
 private EventItem event;
  private List<ItemsInfoModel>cartList = new ArrayList<>();
  

 public EventItem getEvent() {
        return event;
    }

    public void setEvent(EventItem event) {
        this.event = event;
    }
  
  public String getDateReturned() {
  
    return dateRet.getText().trim();
}
  

 
 public void setData(BorrowerInfoModel data) {
    this.data = data;

    // Initialize the date format
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // Check if the dateRequest is null and format accordingly
    String dateReqStr = (data.getDateRequest() != null) ? dateFormat.format(data.getDateRequest()) : "N/A"; // Default value for null

    // Set the text fields
    borId.setText(data.getBorrowerId());
    borName.setText(data.getBorrowerName());
    lenName.setText(data.getLenderName());
    dateBOR.setText(dateReqStr);

    // Process cartList to display itemName, category, and quantity
    List<ItemsInfoModel> cartList = data.getCartList();
    if (cartList != null && !cartList.isEmpty()) {
        StringBuilder itemsText = new StringBuilder();
        for (ItemsInfoModel item : cartList) {
            itemsText.append("Name: ").append(item.getItemName()).append("\n")
                     .append("Category: ").append(item.getCategory()).append("\n")
                     .append("Quantity: ").append(item.getQuantity())
                     .append("\n").append("\n"); // Add a newline for each item
        }
        listItemField.setText(itemsText.toString());
    } else {
        listItemField.setText("No items in the list");
    }
}

     private DatePicker dateReturned = new DatePicker();
    public ItemLogsPop() throws SQLException, Exception {
        initComponents();
     
         PopItemForm popItemForm = new PopItemForm();
        Item_Form itemform = new Item_Form();
       
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String randonID = generateRandomID(Alphabet, 6);
        borId.setText(randonID);
          
        datePicker1.setCloseAfterSelected(true);
        datePicker1.setEditor(dateRet);
        
          dateReturned.setEditor(dateRet);
    
    dateReturned.setCloseAfterSelected(true);
    
   
    dateReturned.setDateFormat("yyyy-MM-dd");
    dateReturned.now();
    }
    
     private static String generateRandomID(String candidateChar,int length){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChar.charAt(random.nextInt(candidateChar.length())));
            
        }
        return sb.toString();
        
    }
    
     
    public JButton returnbutton(){
        return returnbutton;
    }
 
 

 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datePicker1 = new raven.datetime.component.date.DatePicker();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        borName = new javax.swing.JLabel();
        lenName = new javax.swing.JLabel();
        dateBOR = new javax.swing.JLabel();
        dateRet = new javax.swing.JFormattedTextField();
        returnbutton = new javax.swing.JButton();
        borId = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listItemField = new javax.swing.JTextPane();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Borrower's Name:");

        jLabel2.setText("Lenderer's Name:");

        jLabel3.setText("Date Borrowed:");

        jLabel4.setText("Date Return:");

        borName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        borName.setText("jLabel5");

        lenName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lenName.setText("jLabel6");

        dateBOR.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dateBOR.setText("jLabel7");

        returnbutton.setBackground(new java.awt.Color(110, 168, 246));
        returnbutton.setForeground(new java.awt.Color(255, 255, 255));
        returnbutton.setText("Return");
        returnbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnbuttonActionPerformed(evt);
            }
        });

        borId.setText("jLabel8");

        jScrollPane1.setViewportView(listItemField);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateRet, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lenName, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(borName, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(borId))
                    .addComponent(dateBOR, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(147, 147, 147)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(returnbutton)
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(borName)
                    .addComponent(borId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lenName))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dateBOR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(dateRet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(returnbutton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void returnbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnbuttonActionPerformed


    }//GEN-LAST:event_returnbuttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel borId;
    private javax.swing.JLabel borName;
    private javax.swing.JLabel dateBOR;
    private raven.datetime.component.date.DatePicker datePicker1;
    private javax.swing.JFormattedTextField dateRet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lenName;
    private javax.swing.JTextPane listItemField;
    private javax.swing.JButton returnbutton;
    // End of variables declaration//GEN-END:variables
}
