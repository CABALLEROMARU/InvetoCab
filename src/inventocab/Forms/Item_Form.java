/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package inventocab.Forms;

import com.formdev.flatlaf.FlatClientProperties;
import inventocab.Components.Header;
import inventocab.Controller.ItemController;
import inventocab.Event.EventItem;
import inventocab.Items.ItemPack;
import inventocab.Models.ItemsInfoModel;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import raven.modal.ModalDialog;
import raven.modal.Toast;
import raven.modal.component.SimpleModalBorder;
import raven.modal.demo.simple.SimpleMessageModal;
import raven.modal.listener.ModalCallback;
import raven.modal.listener.ModalController;
import raven.modal.option.Location;
import raven.modal.option.Option;



public class Item_Form extends javax.swing.JPanel {

  
    public EventItem getEvent() {
        return event;
    }

    public void setEvent(EventItem event) {
        this.event = event;
    }

     private ItemController items = new ItemController();
     private EventItem event;
    public Item_Form() throws SQLException {
        initComponents();
        init();
        populateData();
    }

    public void AddItems(ItemsInfoModel data){
        ItemPack itemPack = new ItemPack();
        itemPack.setData(data);
        itemPack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                   event.itemClick(panel, data);
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
        resposiveItem1.add(itemPack);
        repaint();
        revalidate();
        
    }
    public void setSelected(Component item){
        for (Component com : resposiveItem1.getComponents()) {
            ItemPack i =(ItemPack)com;
            if (i.isSelected()) {
                i.isSelected();
            }
        }
        ((ItemPack)item).setSelected(true);
    }
    private void init(){
          panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:25;"
                + "background:$Table.background");
    
       
        
      
    }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resposiveItem1 = new inventocab.Swing.ResposiveItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        searchText1 = new inventocab.Swing.SearchText();

        jButton1.setText("ADD ITEMS");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Item Id");

        jScrollPane1.setViewportView(resposiveItem1);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventocab/icons/search.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventocab/icons/menu.png"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        searchText1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        searchText1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchText1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchText1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchText1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchText1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addGap(5, 5, 5))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       addItems();
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchText1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchText1KeyReleased
        try {
            SearchEvent(searchText1.getText());
        } catch (ParseException ex) {
            Logger.getLogger(Item_Form.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Item_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchText1KeyReleased

    
    private void updateItems(ItemsInfoModel data) {
    
    addItemspop popup = new addItemspop();
    popup.setData(data); 
    ItemController control = new ItemController(); 

    Option option = ModalDialog.createOption();
    option.getLayoutOption()
          .setSize(-1, 1f)
          .setLocation(Location.RIGHT, Location.CENTER)
          .setAnimateDistance(0.7f, 0);

  
    SimpleModalBorder.Option[] options = new SimpleModalBorder.Option[]{
        new SimpleModalBorder.Option("Delete", SimpleModalBorder.CANCEL_OPTION),
        new SimpleModalBorder.Option("Update", SimpleModalBorder.OK_OPTION) 
    };

    
    ModalDialog.showModal(this, new SimpleModalBorder(popup, "Update Item", options, 
        (controller, action) -> {
            if (action == SimpleModalBorder.OK_OPTION) { 
                // Update action
                control.updateItem(popup.getData()); 
                Toast.show(this, Toast.Type.SUCCESS, "Item Successfully Updated"); 

              
                try {
                    populateData();
                } catch (SQLException ex) {
                    Logger.getLogger(Item_Form.class.getName()).log(Level.SEVERE, null, ex);
                }
                controller.close(); 
            } else if (action == SimpleModalBorder.CANCEL_OPTION) { 
          
                ModalDialog.showModal(this, new SimpleMessageModal(
                    SimpleMessageModal.Type.WARNING,
                    "Are you sure you want to delete this item?",
                    "Delete Item", SimpleModalBorder.YES_NO_OPTION,
                    new ModalCallback() {
                        @Override
                        public void action(ModalController mc, int i) {
                            if (i == SimpleModalBorder.YES_OPTION) {
                              
                                control.deleteItem(data.getItemID()); 
                                JOptionPane.showMessageDialog(null, "Successfully Deleted");
                                
                             
                                try {
                                    populateData();
                                } catch (SQLException ex) {
                                    Logger.getLogger(Item_Form.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                mc.close(); 
                            } else {
                                mc.close(); 
                            }
                        }
                    }
                ), option);
                controller.close(); 
            }
        }
    ), option);
}
    
    
    
    private void addItems(){
    
    addItemspop popup = new addItemspop();
    ItemController control = new ItemController();
    Option option = ModalDialog.createOption();
    option.getLayoutOption().setSize(-1,1f)
            .setLocation(Location.RIGHT, Location.CENTER)
            .setAnimateDistance(0.7f, 0);
    SimpleModalBorder.Option[] options = new SimpleModalBorder.Option[]{
         new SimpleModalBorder.Option("Cancel",SimpleModalBorder.CANCEL_OPTION),
         new SimpleModalBorder.Option("Save",SimpleModalBorder.OK_OPTION),
    };
 ModalDialog.showModal(this,new SimpleModalBorder( popup, "Add Items", options,
    (controller,action)->{
        if (action==SimpleModalBorder.YES_OPTION) {
           
             control.addItem(popup.getData());
            Toast.show(this,Toast.Type.SUCCESS,"Items Successfully Added");
            try {
                populateData();
            } catch (SQLException ex) {
                Logger.getLogger(Item_Form.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }else{
            controller.close();
        }
    }
    ),option);
}
  private void SearchEvent(String search) throws ParseException, SQLException {
    this.setEvent(new EventItem() {
        @Override
        public void itemClick(Component com, ItemsInfoModel itemsInfoModel) {
            updateItems(itemsInfoModel);
            // You don't need to instantiate ItemController here again
        }
    });

    // Clear the current UI items
     resposiveItem1.removeAll();

    // Fetch search results from the controller
    ItemController controller = new ItemController();
    List<ItemsInfoModel> itemsInfoModels = (List<ItemsInfoModel>) controller.searchItems(search); // Assumes searchItem returns a list

    // Populate the UI with search results
    for (ItemsInfoModel item : itemsInfoModels) {
        AddItems(item); 
        // Corrected 'event' to 'item'
    }

    // Refresh the UI
    
    repaint();
    revalidate();
}
private void populateData() throws SQLException{
    this.setEvent(new EventItem() {
        @Override
        public void itemClick(Component com, ItemsInfoModel data) {
            updateItems(data);
          
        
        }
    });
    resposiveItem1.removeAll();
    ItemController controller = new ItemController();
    List<ItemsInfoModel>eventlist = controller.getAll();
    for (ItemsInfoModel itemsInfoModel : eventlist) {
        AddItems(itemsInfoModel);
    }
    repaint();
    revalidate();
    
}
//   private void SearchEvent(String search) throws ParseException, SQLException{
//            this.setEvent(new EventItem() {
//                @Override
//                public void itemClick(Component com, ItemsInfoModel itemsInfoModel) {
//                    updateItems(itemsInfoModel);
//                    ItemController pop = new ItemController();
//                    
//                    
//                } 
//            });
//          responsiveItem1.removeAll();
//            ItemController controller = new ItemController();
//          
//            List<ItemsInfoModel> itemsInfoModels = controller.searchItem(search);
//    
//    
//              for (ItemsInfoModel item : eventsList) {
//                  addItems(event);
//                 
//                }
//               repaint();
//                  revalidate();
//            
//        }
        
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private inventocab.Swing.ResposiveItem resposiveItem1;
    private inventocab.Swing.SearchText searchText1;
    // End of variables declaration//GEN-END:variables
}
