/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package inventocab.Forms;

import inventocab.Controller.BorrowerController;
import inventocab.Controller.ItemController;
import inventocab.Controller.ReturnController;
import inventocab.Event.EventItem;
import inventocab.Event.EventItem1;
import inventocab.Items.ItemLogsPop;
import inventocab.Items.ItemPack;
import inventocab.Items.returnpop;
import inventocab.Models.BorrowerInfoModel;
import inventocab.Models.ItemsInfoModel;
import inventocab.Models.ReturnInfoModel;
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
import raven.modal.ModalDialog;
import raven.modal.Toast;
import raven.modal.component.SimpleModalBorder;
import raven.modal.option.Location;
import raven.modal.option.Option;

/**
 *
 * @author Calyle
 */
public  class BorrowLogs extends javax.swing.JPanel {
  
    private PopItemForm popItemForm; // Declare instance variables
    private Item_Form itemform;
     private Set<String> seenBorrowerIds;
    private EventItem1 event;
    private ReturnInfoModel data;
    
   
    public void setEvent(EventItem1 event) {
        this.event = event;
    }
    public BorrowLogs()throws SQLException, Exception {
        initComponents();
         this.popItemForm = new PopItemForm();
        this.itemform = new Item_Form();
         this.seenBorrowerIds = new HashSet<>(); 
        populateAddDataLogs(this.popItemForm, this.itemform);
   
    }
    
    
    public void addborrowedData(BorrowerInfoModel data) throws Exception{
        ItemLogsPop item = new ItemLogsPop();
       
        item.setData(data);
        item.returnbutton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReturnController controler = new ReturnController();
              controler.returnBorrow( data);
                System.out.println("click");
            }
        
        
        });
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                   event.itemClick(item, data);
                }
                
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }
        
        
        });
        responsiveItem5.add(item);
        repaint();
        revalidate();
        
    }
   

  public void PopulateBorrowData(BorrowerInfoModel data) throws SQLException, Exception {
       
      ItemLogsPop logs = new ItemLogsPop();
        logs.setData(data);
        responsiveItem5.add(logs);
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
        responsiveItem5 = new inventocab.Swing.ResposiveItem();
        searchText = new inventocab.Swing.SearchText();
        jLabel2 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(responsiveItem5);

        searchText.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        searchText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextKeyReleased(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventocab/icons/search.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

public void populateAddDataLogs(PopItemForm popItemForm, Item_Form itemform) throws SQLException, Exception {
    
    this.setEvent(new EventItem1(){
        public void itemClick(Component Comp, BorrowerInfoModel data){
            System.out.println("itemclick");
        }

       
    });
        responsiveItem5.removeAll();
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
        addborrowedData(borrowerInfoModel); // Populate the data for this borrower
    }

    repaint();
    revalidate();
    }
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
    

   responsiveItem5.removeAll();
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
    responsiveItem5.revalidate(); // Revalidate the component
    responsiveItem5.repaint(); // Repaint the component
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private inventocab.Swing.ResposiveItem responsiveItem5;
    private inventocab.Swing.SearchText searchText;
    // End of variables declaration//GEN-END:variables

    
}
