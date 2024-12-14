/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package inventocab.Items;


import Print.PrintDetails;
import inventocab.Controller.BorrowerController;
import inventocab.Forms.Item_Form;
import inventocab.Forms.PopItemForm;
import inventocab.JDBC.DatabaseConnection;
import inventocab.Models.BorrowerInfoModel;
import inventocab.Models.ItemsInfoModel;
import inventocab.Models.reports.BorrowerDetailsModel;
import inventocab.Models.reports.ParametersModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class ItemRecPopulate extends javax.swing.JPanel {
    private BorrowerInfoModel data;
 private ItemsInfoModel items;
 private PreparedStatement ps;
    private ResultSet rs;
 
 public BorrowerInfoModel getData() {
        return data;
    }
 private List<ItemsInfoModel>cartList = new ArrayList<>();
 
  public void setData(BorrowerInfoModel data) {
    this.data = data;

   
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    
    String dateReqStr = (data.getDateRequest() != null) ? dateFormat.format(data.getDateRequest()) : "N/A"; 
   String dateRet = (data.getDateReturn()!= null) ? dateFormat.format(data.getDateReturn()): "N/A";
    String dateRelStr = (data.getDateRelease() != null) ? dateFormat.format(data.getDateRelease()) : "N/A"; // Ensure this is set correctly
    String statusStr = (data.getStatus() != null) ? data.getStatus() : "N/A";
    String returnStatusStr = (data.getReturnStatus() != null) ? data.getReturnStatus() : "N/A"; // Ensure this is set correctly
    String remarksStr = (data.getRemarks() != null) ? data.getRemarks() : "N/A"; // Ensure this is set correctly
    
    borId.setText(data.getBorrowerId());
   
    borName.setText(data.getBorrowerName());
    lenName.setText(data.getLenderName());
    
    dateBOR.setText(dateReqStr);
    dateret.setText(dateRet);
     dateRel.setText(dateRelStr); // Populate the date release
    Relstatus.setText(statusStr); 
     returnstatus.setText(returnStatusStr); // Populate return status
    remarks.setText(remarksStr); // Populate remarks
    
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
        try {
            DatabaseConnection.getInstance().getConnection();
            PrintDetails.getInstance().compileReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
         
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
        print = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dateRel = new javax.swing.JLabel();
        Relstatus = new javax.swing.JLabel();
        returnstatus = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        remarks = new javax.swing.JLabel();

        jLabel5.setText("jLabel5");

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Borrower's Name:");

        jLabel2.setText("Custodian's Name:");

        jLabel3.setText("Date Filed:");

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

        listPaneList.setEditable(false);
        jScrollPane2.setViewportView(listPaneList);

        print.setForeground(new java.awt.Color(255, 255, 255));
        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventocab/icons/icons8-print-50 (1)4.png"))); // NOI18N
        print.setOpaque(true);
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        jLabel6.setText("Date Release:");

        jLabel7.setText("Item Release Status:");

        jLabel8.setText("Item Returned Status:");

        dateRel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dateRel.setText("jLabel9");

        Relstatus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Relstatus.setText("jLabel10");

        returnstatus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        returnstatus.setText("jLabel11");

        jLabel9.setText("Remarks:");

        remarks.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        remarks.setText("jLabel10");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(returnstatus)
                                    .addComponent(Relstatus)
                                    .addComponent(dateRel)
                                    .addComponent(dateret, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateBOR, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lenName, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(borName, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(borId, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(remarks))
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137)
                        .addComponent(print))
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(dateRel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(Relstatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(returnstatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(remarks))
                        .addGap(0, 7, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(print)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
 try {
       
        String borrowerId = borId.getText();
        String borrowerName = borName.getText();
        
        
        ParametersModel borrowerInfo = getBorrowerDetails(borrowerId,borrowerName);
       
        if (borrowerInfo != null) {
            
            PrintDetails.getInstance().printReportInvoice(borrowerInfo);
        } else {
            
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_printActionPerformed

 public ParametersModel getBorrowerDetails(String borrowerId, String borrowerName) throws SQLException {
 
    String sql = """
        SELECT borrower_Id, borrowerName, lendererName, borrowDate, returnedDate 
        FROM borrowerdata
        WHERE borrower_Id = ? AND borrowerName = ?
    """;
    String itemSql = """
        SELECT itemId, itemName, quantity, Category 
        FROM borrowerdata
        WHERE borrower_Id = ?
    """;

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conn = DatabaseConnection.getInstance().getConnection();

      
        ps = conn.prepareStatement(sql);
        ps.setString(1, borrowerId);
        ps.setString(2, borrowerName);
        rs = ps.executeQuery();

        if (rs.next()) {
            List<BorrowerDetailsModel> cart = new ArrayList<>();
            ParametersModel data = new ParametersModel();

            data.setBorrowerId(borrowerId);
            data.setBorrowerName(borrowerName);
            data.setLenderName(rs.getString("lendererName"));

           
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String borrowDateString = dateFormat.format(rs.getDate("borrowDate"));
            String returnedDateString = rs.getDate("returnedDate") != null
                ? dateFormat.format(rs.getDate("returnedDate"))
                : null;

            data.setDateRequest(borrowDateString);
            data.setDateReturn(returnedDateString);

            
            try (PreparedStatement pd = conn.prepareStatement(itemSql)) {
                pd.setString(1, borrowerId);
                try (ResultSet itemRs = pd.executeQuery()) {
                    while (itemRs.next()) {
                        BorrowerDetailsModel borrowerDetailsModel = new BorrowerDetailsModel();
                        borrowerDetailsModel.setItemId(itemRs.getString("itemId"));
                        borrowerDetailsModel.setItemName(itemRs.getString("itemName"));
                        borrowerDetailsModel.setQuantity(itemRs.getString("quantity"));
                        borrowerDetailsModel.setCategory(itemRs.getString("Category"));
                        cart.add(borrowerDetailsModel);
                        
                    }
                    data.setField(cart); 
                }
            }

            return data; 
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw e;
    } finally {
        if (rs != null) rs.close();
        if (ps != null) ps.close();
        if (conn != null) conn.close();
    }

    return null; 
}

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Relstatus;
    private javax.swing.JLabel borId;
    private javax.swing.JLabel borName;
    private javax.swing.JLabel dateBOR;
    private raven.datetime.component.date.DatePicker datePicker1;
    private javax.swing.JLabel dateRel;
    private javax.swing.JLabel dateret;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lenName;
    private javax.swing.JTextPane listPaneList;
    private javax.swing.JButton print;
    private javax.swing.JLabel remarks;
    private javax.swing.JLabel returnstatus;
    // End of variables declaration//GEN-END:variables
}
