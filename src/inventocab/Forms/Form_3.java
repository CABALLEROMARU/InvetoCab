/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package inventocab.Forms;


import inventocab.Controller.BorrowerController;
import inventocab.Items.ItemRecPopulate;
import inventocab.Models.BorrowerInfoModel;

import java.util.logging.Level; 
import java.util.logging.Logger; 
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Form_3 extends javax.swing.JPanel {

     private PopItemForm popItemForm; 
    private Item_Form itemform;
     private Set<String> seenBorrowerIds;
     
     
     
    public Form_3() throws SQLException, Exception {
        initComponents();
         this.popItemForm = new PopItemForm();
        this.itemform = new Item_Form();
         this.seenBorrowerIds = new HashSet<>(); 
        populateAddDataRec(this.popItemForm, this.itemform);
    }
    public void PopulateBorrowData(BorrowerInfoModel data) throws SQLException, Exception {      
     ItemRecPopulate logs = new ItemRecPopulate();
        logs.setData(data);
        responsiveItem6.add(logs);
        repaint();
        revalidate();
    }

  private boolean isUniqueBorrowerId(String borrowerId) throws SQLException {
   
    BorrowerController controller = new BorrowerController(popItemForm, itemform);
    int count = controller.countBorrowerId(borrowerId);
    return count == 1; 
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        responsiveItem6 = new inventocab.Swing.ResposiveItem();
        jPanel2 = new javax.swing.JPanel();
        searchText = new inventocab.Swing.SearchText();
        jLabel2 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(responsiveItem6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        searchText.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        searchText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextKeyReleased(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventocab/icons/search.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(229, 592, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextKeyReleased
        try {
            
            SearchEvent(searchText.getText(), popItemForm, itemform);
        } catch (ParseException ex) {
            Logger.getLogger(BorrowLogs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BorrowLogs.class.getName()).log(Level.SEVERE, null, ex); 
        }   catch (Exception ex) {
            Logger.getLogger(BorrowLogs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchTextKeyReleased
private void SearchEvent(String search,PopItemForm popItemForm,Item_Form itemform) throws ParseException, SQLException, Exception {
    
   responsiveItem6.removeAll();
  seenBorrowerIds.clear();
    
    BorrowerController controller = new BorrowerController(popItemForm, itemform);
    
    List<BorrowerInfoModel> borrowedItems = controller.searchBorrowedItems(search); 

   
    for (BorrowerInfoModel item : borrowedItems) {
        PopulateBorrowData(item); 
    }

   
    responsiveItem6.revalidate(); 
    responsiveItem6.repaint();
}
public void populateAddDataRec(PopItemForm popItemForm, Item_Form itemform) throws SQLException, Exception {
        responsiveItem6.removeAll();
    seenBorrowerIds.clear(); 

    BorrowerController controller = new BorrowerController(popItemForm, itemform);
    List<BorrowerInfoModel> allBorrowers = controller.getBorrower(); 

    Set<String> uniqueBorrowerIds = new HashSet<>();
    List<BorrowerInfoModel> uniqueBorrowers = new ArrayList<>();

    for (BorrowerInfoModel borrower : allBorrowers) {
      
        if (borrower.getDateReturn() != null && uniqueBorrowerIds.add(borrower.getBorrowerId())) {
          
            uniqueBorrowers.add(borrower);
        }
    }

    for (BorrowerInfoModel borrowerInfoModel : uniqueBorrowers) {
        PopulateBorrowData(borrowerInfoModel); 
    }

    repaint();
    revalidate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private inventocab.Swing.ResposiveItem responsiveItem6;
    private inventocab.Swing.SearchText searchText;
    // End of variables declaration//GEN-END:variables
}
