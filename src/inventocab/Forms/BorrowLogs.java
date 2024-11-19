/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package inventocab.Forms;

import inventocab.Controller.BorrowerController;
import inventocab.Controller.ItemController;
import inventocab.Controller.ReturnController;
import inventocab.Event.EventItem;

import inventocab.Items.ItemLogsPop;
import inventocab.Items.ItemPack;
import inventocab.Items.ItemRecPopulate;

import inventocab.Models.BorrowerInfoModel;
import inventocab.Models.ItemsInfoModel;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level; 
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


public  class BorrowLogs extends javax.swing.JPanel {
  
    private PopItemForm popItemForm;
    private Item_Form itemform;
     private Set<String> seenBorrowerIds;
     private Form_3 form3;
     private EventItem event;
     
   
 
    
   
   
    public BorrowLogs()throws SQLException, Exception {
        initComponents();
         this.popItemForm = new PopItemForm();
        this.itemform = new Item_Form();
        this.form3 = new Form_3();
         this.seenBorrowerIds = new HashSet<>(); 
        populateAddDataLogs(this.popItemForm, this.itemform);
       
   
    }
    
    public EventItem getEvent() {
        return event;
    }

    public void setEvent(EventItem event) {
        this.event = event;
    }
    
    public void addborrowedData(BorrowerInfoModel data) throws Exception{
        ItemLogsPop item = new ItemLogsPop();
        
       
        item.setData(data);
        item.returnbutton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReturnController controler = new ReturnController();
              controler.returnBorrow( data);
               
                try {
                    populateAddDataLogs(popItemForm, itemform);
                } catch (Exception ex) {
                    Logger.getLogger(BorrowLogs.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    Form_3 form = new Form_3();
                    form.populateAddDataRec(popItemForm, itemform);
                } catch (Exception ex) {
                    Logger.getLogger(BorrowLogs.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("click");
            }
        
        
        });
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    try {
                        Form_3 form = new Form_3();
                        form.populateAddDataRec(popItemForm, itemform);
                        
                      
                        
                    } catch (Exception ex) {
                        Logger.getLogger(BorrowLogs.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
   
    BorrowerController controller = new BorrowerController(popItemForm, itemform);
    int count = controller.countBorrowerId(borrowerId);
    return count == 1; 
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
    
   

        responsiveItem5.removeAll();
    seenBorrowerIds.clear(); 

    BorrowerController controller = new BorrowerController(popItemForm, itemform);
    List<BorrowerInfoModel> allBorrowers = controller.getBorrower(); 

    Set<String> uniqueBorrowerIds = new HashSet<>();
    List<BorrowerInfoModel> uniqueBorrowers = new ArrayList<>();

    for (BorrowerInfoModel borrower : allBorrowers) {   
        if (borrower.getDateReturn() == null &&  uniqueBorrowerIds.add(borrower.getBorrowerId())) {
            uniqueBorrowers.add(borrower);
        }
    }

    for (BorrowerInfoModel borrowerInfoModel : uniqueBorrowers) {
        addborrowedData(borrowerInfoModel); 
    }

    repaint();
    revalidate();
    }
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
    

   responsiveItem5.removeAll();
  seenBorrowerIds.clear();
   
    BorrowerController controller = new BorrowerController(popItemForm, itemform);
    
   
    List<BorrowerInfoModel> borrowedItems = controller.searchBorrowedItems(search); 

    
    for (BorrowerInfoModel item : borrowedItems) {
        PopulateBorrowData(item); 
    }

    
    responsiveItem5.revalidate(); 
    responsiveItem5.repaint(); 
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private inventocab.Swing.ResposiveItem responsiveItem5;
    private inventocab.Swing.SearchText searchText;
    // End of variables declaration//GEN-END:variables

    
}
