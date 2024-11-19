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


public class ItemRecPopulate extends javax.swing.JPanel {
    private BorrowerInfoModel data;
 private ItemsInfoModel items;
 
 public BorrowerInfoModel getData() {
        return data;
    }
 private List<ItemsInfoModel>cartList = new ArrayList<>();
  public void setData(BorrowerInfoModel data) {
    this.data = data;

   
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    
    String dateReqStr = (data.getDateRequest() != null) ? dateFormat.format(data.getDateRequest()) : "N/A"; 
   String dateRet = (data.getDateReturn()!= null) ? dateFormat.format(data.getDateReturn()): "N/A";

    
    borId.setText(data.getBorrowerId());
   
    borName.setText(data.getBorrowerName());
    lenName.setText(data.getLenderName());
    
    dateBOR.setText(dateReqStr);
    dateret.setText(dateRet);
    
     List<ItemsInfoModel> cartList = data.getCartList();
    if (cartList != null && !cartList.isEmpty()) {
        StringBuilder itemsText = new StringBuilder();
        for (ItemsInfoModel item : cartList) {
            itemsText.append("Name: ").append(item.getItemName()).append("\n")
                     .append("Category: ").append(item.getCategory()).append("\n")
                     .append("Quantity: ").append(item.getQuantity())
                     .append("\n").append("\n"); 
        }
        listPaneList.setText(itemsText.toString());
    } else {
        listPaneList.setText("No items in the list");
    }
    

    
}
     
    public ItemRecPopulate() throws SQLException, Exception {
        initComponents();
        
         PopItemForm popItemForm = new PopItemForm();
        Item_Form itemform = new Item_Form();
        populateAddDataLogs(popItemForm, itemform);
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String randonID = generateRandomID(Alphabet, 6);
        borId.setText(randonID);
          
        
    }
     private static String generateRandomID(String candidateChar,int length){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChar.charAt(random.nextInt(candidateChar.length())));
            
        }
        return sb.toString();
        
    }

 
 

 
   public void populateAddDataLogs(PopItemForm popItemForm, Item_Form itemform) throws SQLException, Exception {
   
    BorrowerController controller = new BorrowerController(popItemForm, itemform);
    List<BorrowerInfoModel> eventlist = controller.getBorrowedItems(); 

 
    Set<String> uniqueBorrowerIds = new HashSet<>();

   
    for (BorrowerInfoModel borrowerInfoModel : eventlist) {
        String borrowerId = borrowerInfoModel.getBorrowerId();
        
       
        if (!uniqueBorrowerIds.contains(borrowerId)) {
            uniqueBorrowerIds.add(borrowerId); 
            
            
            List<ItemsInfoModel> borrowedItems = borrowerInfoModel.getCartList();
            for (ItemsInfoModel item : borrowedItems) {
//                PopulateBorrowItems(item); 
            }
        }
    }

    repaint();
    revalidate();
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datePicker1 = new raven.datetime.component.date.DatePicker();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        borName = new javax.swing.JLabel();
        lenName = new javax.swing.JLabel();
        dateBOR = new javax.swing.JLabel();
        borId = new javax.swing.JLabel();
        dateret = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listPaneList = new javax.swing.JTextPane();

        jLabel5.setText("jLabel5");

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

        borId.setText("jLabel8");

        dateret.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dateret.setText("jLabel7");

        jScrollPane2.setViewportView(listPaneList);

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
                    .addComponent(dateret, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateBOR, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lenName, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(borName, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(borId, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(146, 146, 146)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dateBOR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dateret))
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel borId;
    private javax.swing.JLabel borName;
    private javax.swing.JLabel dateBOR;
    private raven.datetime.component.date.DatePicker datePicker1;
    private javax.swing.JLabel dateret;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lenName;
    private javax.swing.JTextPane listPaneList;
    // End of variables declaration//GEN-END:variables
}
