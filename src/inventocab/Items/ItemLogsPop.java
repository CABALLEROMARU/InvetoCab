
package inventocab.Items;

import inventocab.Controller.ReturnController;
import inventocab.Event.EventItem;
import inventocab.Forms.Item_Form;
import inventocab.Forms.PopItemForm;
import inventocab.Models.BorrowerInfoModel;
import inventocab.Models.ItemsInfoModel;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import raven.datetime.component.date.DatePicker;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;


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
  

public BorrowerInfoModel getReturnData() {
    try {
        // Retrieve the selected return status from the JComboBox
        String returnStatusText = (String) returnstatus.getSelectedItem();
        
        // Retrieve remarks from the JTextField
        String remarksText = remarks.getText();
        
        // Retrieve other necessary data from the UI components
        String borrowerId = borId.getText();
        String borrowerNameText = borName.getText();
        String lenderNameText = lenName.getText();
        
        // Ensure cartList is populated
        if (cartList == null || cartList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cart list cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        // Create and return the BorrowerInfoModel
        return new BorrowerInfoModel(borrowerId, borrowerNameText, lenderNameText, null, null, null, returnStatusText, remarksText, "", cartList);
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "An error occurred while retrieving data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }
}
  
 public void setData(BorrowerInfoModel data) {
    this.data = data;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
String dateBorStr = (data.getDateRequest()!= null) ? dateFormat.format(data.getDateRequest()) : "N/A";
String dateRelStr = (data.getDateRelease()!= null) ? dateFormat.format(data.getDateRelease()) : "N/A";
 
    // Populate UI components with data
    borId.setText(data.getBorrowerId());
    borName.setText(data.getBorrowerName());
    lenName.setText(data.getLenderName());
    dateBOR.setText( dateBorStr);
    daterel.setText(dateRelStr);
    status.setText(data.getStatus());
    // Populate other fields...

    // Populate the cartList
    List<ItemsInfoModel> cartList = data.getCartList();
    this.cartList = cartList; // Ensure this is set correctly

    // Populate the listItemField with item details
    if (cartList != null && !cartList.isEmpty()) {
        StringBuilder itemsText = new StringBuilder();
        for (ItemsInfoModel item : cartList) {
            itemsText.append("Name: ").append(item.getItemName()).append("\n")
                     .append("Category: ").append(item.getCategory()).append("\n")
                     .append("Quantity: ").append(item.getQuantity())
                     .append("\n").append("\n"); 
        }
        listItemField.setText(itemsText.toString());
    } else {
        listItemField.setText("No items in the list");
    }
}
 
 private DatePicker dateRequested = new DatePicker();
       private DatePicker dateReleased = new DatePicker();
     private DatePicker dateReturned = new DatePicker();
    public ItemLogsPop() throws SQLException, Exception {
        initComponents();
     
         PopItemForm popItemForm = new PopItemForm();
        Item_Form itemform = new Item_Form();
       
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String randonID = generateRandomID(Alphabet, 6);
        borId.setText(randonID);
        datePicker1.setCloseAfterSelected(true);
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
        borName = new javax.swing.JLabel();
        lenName = new javax.swing.JLabel();
        dateBOR = new javax.swing.JLabel();
        returnbutton = new javax.swing.JButton();
        borId = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listItemField = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        daterel = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        returnstatus = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        remarks = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Borrower's Name:");

        jLabel2.setText("Custodian's Name:");

        jLabel3.setText("Date Filed:");

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

        listItemField.setEditable(false);
        jScrollPane1.setViewportView(listItemField);

        jLabel4.setText("Date Release:");

        jLabel5.setText("Borrowed Item Status:");

        daterel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        daterel.setText("jLabel6");

        status.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        status.setText("jLabel7");

        jLabel6.setText("Item Return Status:");

        returnstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1- Good", "2- Replacement", "3- Unavailable", "4- Loss", " " }));

        jLabel7.setText("Remarks:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(borId, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(47, 47, 47)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(63, 63, 63)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(115, 115, 115)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateBOR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(borName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(2, 2, 2))
                                    .addComponent(lenName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(36, 36, 36)))
                        .addGap(182, 182, 182))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(daterel)
                            .addComponent(status)
                            .addComponent(returnstatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(remarks))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113)
                .addComponent(returnbutton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(borName)
                    .addComponent(borId, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lenName))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dateBOR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(daterel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(status))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(returnstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(remarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(returnbutton))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void returnbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnbuttonActionPerformed
     // Get the return data from the item logs pop
    BorrowerInfoModel returnData = getReturnData(); // Assuming you have this method in ItemLogsPop

    if (returnData != null) {
        // Validate remarks
        String remarksText = remarks.getText().trim(); // Get the trimmed text from the remarks field
        if (remarksText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Remarks field must contain data.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit if remarks are empty
        }

        // Proceed with the return operation
        ReturnController controller = new ReturnController();
        controller.returnBorrow(returnData);

        // Optionally, refresh the UI or perform other actions after the return
        try {
            // Refresh the logs after returning
            // For example:
            // BorrowLogs.populateAddDataLogs(popItemForm, itemform);
        } catch (Exception ex) {
            Logger.getLogger(ItemLogsPop.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Failed to retrieve return data.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_returnbuttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel borId;
    private javax.swing.JLabel borName;
    private javax.swing.JLabel dateBOR;
    private raven.datetime.component.date.DatePicker datePicker1;
    private javax.swing.JLabel daterel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lenName;
    private javax.swing.JTextPane listItemField;
    private javax.swing.JTextField remarks;
    private javax.swing.JButton returnbutton;
    private javax.swing.JComboBox<String> returnstatus;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
