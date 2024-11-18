/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package inventocab.Forms;


import inventocab.Controller.BorrowerController;
import inventocab.Controller.ItemController;
import inventocab.Event.EventItem;
import inventocab.Items.ItemLogsPop;
import inventocab.Items.ItemPack;
import inventocab.Models.BorrowerInfoModel;
import inventocab.Models.ItemsInfoModel;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.logging.Level; // Import Level from java.util.logging
import java.util.logging.Logger; 
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.SwingUtilities;

/**
 *
 * @author Calyle
 */
public class Form_3 extends javax.swing.JPanel {

     private PopItemForm popItemForm; // Declare instance variables
    private Item_Form itemform;
     private Set<String> seenBorrowerIds;
     
     
     
    public Form_3() throws SQLException, Exception {
        initComponents();
         this.popItemForm = new PopItemForm();
        this.itemform = new Item_Form();
         this.seenBorrowerIds = new HashSet<>(); 
        populateAddDataLogs(this.popItemForm, this.itemform);
    }

    public void PopulateBorrowData(BorrowerInfoModel data) throws SQLException, Exception {
       
      ItemLogsPop logs = new ItemLogsPop();
        logs.setData(data);
        responsiveItem6.add(logs);
        repaint();
        revalidate();
    }

  private boolean isUniqueBorrowerId(String borrowerId) throws SQLException {
    // Assuming you have a method in your BorrowerController to count borrower IDs
    BorrowerController controller = new BorrowerController(popItemForm, itemform);
    int count = controller.countBorrowerId(borrowerId);
    return count == 1; // Return true if there's exactly one borrowerId
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        responsiveItem6 = new inventocab.Swing.ResposiveItem();
        jLabel2 = new javax.swing.JLabel();
        searchText = new inventocab.Swing.SearchText();

        jScrollPane1.setViewportView(responsiveItem6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventocab/icons/search.png"))); // NOI18N

        searchText.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        searchText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(592, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextKeyReleased
        try {
            // Call the SearchEvent method with the text from the searchText field
            SearchEvent(searchText.getText(), popItemForm, itemform);
        } catch (ParseException ex) {
            Logger.getLogger(BorrowLogs.class.getName()).log(Level.SEVERE, null, ex); // Change to BorrowLogs
        } catch (SQLException ex) {
            Logger.getLogger(BorrowLogs.class.getName()).log(Level.SEVERE, null, ex); // Change to BorrowLogs
        }   catch (Exception ex) {
            Logger.getLogger(BorrowLogs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchTextKeyReleased
private void SearchEvent(String search,PopItemForm popItemForm,Item_Form itemform) throws ParseException, SQLException, Exception {
    

   responsiveItem6.removeAll();
  seenBorrowerIds.clear();
    // Create an instance of the BorrowerController
    BorrowerController controller = new BorrowerController(popItemForm, itemform);
    
    // Fetch the borrowed items based on the search query
    List<BorrowerInfoModel> borrowedItems = controller.searchBorrowedItems(search); // No need for casting if the method returns List<BorrowerInfoModel>

    // Populate the UI with search results
    for (BorrowerInfoModel item : borrowedItems) {
        PopulateBorrowData(item); // Populate the UI with the borrowed item data
    }

    // Refresh the UI
    responsiveItem6.revalidate(); // Revalidate the component
    responsiveItem6.repaint(); // Repaint the component
}
public void populateAddDataLogs(PopItemForm popItemForm, Item_Form itemform) throws SQLException, Exception {
        responsiveItem6.removeAll();
    seenBorrowerIds.clear(); 

    BorrowerController controller = new BorrowerController(popItemForm, itemform);
    List<BorrowerInfoModel> allBorrowers = controller.getBorrower(); // Assume this method retrieves all borrowers

    Set<String> uniqueBorrowerIds = new HashSet<>();
    List<BorrowerInfoModel> uniqueBorrowers = new ArrayList<>();

    for (BorrowerInfoModel borrower : allBorrowers) {
        // Add borrowerId to the Set and check if it was added successfully
        if (uniqueBorrowerIds.add(borrower.getBorrowerId())) {
            // If added, it means this borrowerId is unique, so add the borrower to the list
            uniqueBorrowers.add(borrower);
        }
    }

    for (BorrowerInfoModel borrowerInfoModel : uniqueBorrowers) {
        PopulateBorrowData(borrowerInfoModel); // Populate the data for this borrower
    }

    repaint();
    revalidate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private inventocab.Swing.ResposiveItem responsiveItem6;
    private inventocab.Swing.SearchText searchText;
    // End of variables declaration//GEN-END:variables
}
