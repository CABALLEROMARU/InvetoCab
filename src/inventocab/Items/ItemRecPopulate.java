/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package inventocab.Items;

import inventocab.Controller.BorrowerController;
import inventocab.Forms.Item_Form;
import inventocab.Forms.PopItemForm;
import inventocab.Models.BorrowerInfoModel;
import inventocab.Models.ItemsInfoModel;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import raven.datetime.component.date.DatePicker;

/**
 *
 * @author Calyle
 */
public class ItemRecPopulate extends javax.swing.JPanel {
    private BorrowerInfoModel data;
 private ItemsInfoModel items;
 
 public BorrowerInfoModel getData() {
        return data;
    }
 private List<ItemsInfoModel>cartList = new ArrayList<>();
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
    

    
}
     private DatePicker dateRequested = new DatePicker();
    public ItemRecPopulate() throws SQLException, Exception {
        initComponents();
        
         PopItemForm popItemForm = new PopItemForm();
        Item_Form itemform = new Item_Form();
        populateAddDataLogs(popItemForm, itemform);
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String randonID = generateRandomID(Alphabet, 6);
        borId.setText(randonID);
          
        datePicker1.setCloseAfterSelected(true);
        datePicker1.setEditor(dateRet);
        
          dateRequested.setEditor(dateRet);
    
    dateRequested.setCloseAfterSelected(true);
    
   
    dateRequested.setDateFormat("yyyy-MM-dd");
    dateRequested.now();
    }
     private static String generateRandomID(String candidateChar,int length){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChar.charAt(random.nextInt(candidateChar.length())));
            
        }
        return sb.toString();
        
    }
     public void PopulateBorrowItems(ItemsInfoModel data){
       ItemsBorrowLogsPop logs = new ItemsBorrowLogsPop();
       logs.setData(data);
       
        resposiveItem4.add(logs);
         repaint();
         revalidate();
        
    }
 
 
// public void populateAddDataLogs(PopItemForm popItemForm, Item_Form itemform) throws SQLException, Exception {
//        resposiveItem4.removeAll(); // Clear previous items
//        BorrowerController controller = new BorrowerController(popItemForm, itemform);
//        
//        // Get all borrowers
//        List<BorrowerInfoModel> CartList = controller.getBorrower(); // Assuming this method exists
//
//        // Populate filtered borrowed items based on the existing borrowed items
//        populateFilteredBorrowedItems(CartList, popItemForm,itemform);
//         repaint(); // Refresh the UI
//        revalidate();
//    }
//public void populateFilteredBorrowedItems(List<BorrowerInfoModel> cartList, PopItemForm popItemForm, Item_Form itemForm) throws SQLException {
//    resposiveItem4.removeAll(); // Clear previous items
//
//    // Get borrowed items
//    BorrowerController controller = new BorrowerController(popItemForm, itemForm);
//    List<BorrowerInfoModel> borrowedItemsList = controller.getBorrowedItems();
//    if (borrowedItemsList == null) {
//        System.out.println("No borrowed items found.");
//        return; // Exit the method if the list is null
//    }
//
//    System.out.println("Borrower: " + borrowedItemsList.size());
//    // Create a set of borrowed IDs for quick lookup
//    Set<String> borrowedIdsSet = new HashSet<>();
//    for (BorrowerInfoModel borrower : borrowedItemsList) {
//        borrowedIdsSet.add(borrower.getBorrowerId());
//    }
//
//    // Iterate through all borrowers and check if they have borrowed items
//    for (BorrowerInfoModel borrower : cartList) {
//        // Check if the borrower ID matches the current borrower
//        if (borrowedIdsSet.contains(borrower.getBorrowerId())) {
//            // Populate the UI with the borrowed items for this borrower
//            List<ItemsInfoModel> borrowedItems = borrower.getCartList();
//            
//            if (borrowedItems != null) {
//                for (ItemsInfoModel item : borrowedItems) {
//                    // Only add items to the responsiveItem4 if the borrowerId matches
//                    if (itemBelongsToBorrower(data, borrower.getBorrowerId())) {
//                        PopulateBorrowItems(item);
//                    }
//                }
//            } else {
//                System.out.println("Borrowed items list is null for borrower ID: " + borrower.getBorrowerId());
//            }
//        }
//    }
//
//    repaint(); // Refresh the UI
//    revalidate();
//}
//
//// Helper method to check if the item belongs to the specified borrower
//private boolean itemBelongsToBorrower(BorrowerInfoModel data, String borrowerId) {
//    // Assuming the ItemsInfoModel has a method to get the borrower ID or related info
//    return data.getBorrowerId() != null && data.getBorrowerId().equals(borrowerId);
//}
 
   public void populateAddDataLogs(PopItemForm popItemForm, Item_Form itemform) throws SQLException, Exception {
    resposiveItem4.removeAll(); // Clear previous items
    BorrowerController controller = new BorrowerController(popItemForm, itemform);
    List<BorrowerInfoModel> eventlist = controller.getBorrowedItems(); // Get all borrowed data

    // Set to track unique BorrowerIds
    Set<String> uniqueBorrowerIds = new HashSet<>();

    // Iterate through the list of borrowed items
    for (BorrowerInfoModel borrowerInfoModel : eventlist) {
        String borrowerId = borrowerInfoModel.getBorrowerId();
        
        // Check if this BorrowerId has already been processed
        if (!uniqueBorrowerIds.contains(borrowerId)) {
            uniqueBorrowerIds.add(borrowerId); // Add to the set to track processed BorrowerIds
            
            // Populate the UI with the borrowed items for this BorrowerId
            List<ItemsInfoModel> borrowedItems = borrowerInfoModel.getCartList(); // Get items borrowed by the borrower
            for (ItemsInfoModel item : borrowedItems) {
                PopulateBorrowItems(item); // Pass the individual item to the method
            }
        }
    }

    repaint(); // Refresh the UI
    revalidate();
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resposiveItem4 = new inventocab.Swing.ResposiveItem();
        borId = new javax.swing.JLabel();

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

        resposiveItem4.setMinimumSize(new java.awt.Dimension(263, 125));
        jScrollPane1.setViewportView(resposiveItem4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        borId.setText("jLabel8");

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
                    .addComponent(dateRet, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateBOR, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lenName, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(borName, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(borId)
                .addGap(107, 107, 107)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dateBOR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(dateRet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lenName;
    private inventocab.Swing.ResposiveItem resposiveItem4;
    // End of variables declaration//GEN-END:variables
}
