/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package inventocab.Forms;

import com.formdev.flatlaf.FlatClientProperties;
import inventocab.Controller.ItemController;
import inventocab.Event.EventItem;
import inventocab.Items.ItemPack;
import inventocab.Items.ItemPackInventory;
import inventocab.Items.ItemsBorrow;
import inventocab.Models.ItemsInfoModel;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import raven.modal.ModalDialog;
import raven.modal.Toast;
import raven.modal.component.SimpleModalBorder;
import raven.modal.option.Location;
import raven.modal.option.Option;



public class PopItemForm extends javax.swing.JPanel {

    private List<ItemsInfoModel>cartList = new ArrayList<>();
    public EventItem getEvent() {
        return event;
    }

    public void setEvent(EventItem event) {
        this.event = event;
    }

     private ItemController items = new ItemController();
     private EventItem event;
    public PopItemForm() throws SQLException {
        initComponents();
        init();
        populateData();
       
    }
 public void addBorrow(ItemsInfoModel data){
         ItemsBorrow itemsborrow = new ItemsBorrow();
       itemsborrow.setData(data);
        itemsborrow.addMouseListener(new MouseAdapter() {
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
       resposiveItem2.add(itemsborrow);
        repaint();
        revalidate();
        
    }
    public void AddItems(ItemsInfoModel data){
        ItemPackInventory itemPackInventory = new ItemPackInventory();
        itemPackInventory.setData(data);
        itemPackInventory.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                 if (SwingUtilities.isLeftMouseButton(e)) {
                   event.itemClick(panel, data);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
     
            }
        
        
        });
       resposiveItem21.add(itemPackInventory);
        repaint();
        revalidate();
        
    }
    public void setSelected(Component item){
        for (Component com : resposiveItem21.getComponents()) {
            ItemPackInventory i =(ItemPackInventory)com;
            if (i.isSelected()) {
                i.isSelected();
            }
        }
        ((ItemPackInventory)item).setSelected(true);
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
        header1 = new inventocab.Components.Header();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resposiveItem1 = new inventocab.Swing.ResposiveItem();
        resposiveItem21 = new inventocab.Swing.ResposiveItem2();
        jPanel1 = new javax.swing.JPanel();
        panelGradient1 = new inventocab.Swing.panelGradient();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        resposiveItem2 = new inventocab.Swing.ResposiveItem();

        header1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Item Id");

        resposiveItem1.add(resposiveItem21);

        jScrollPane1.setViewportView(resposiveItem1);

        panelGradient1.setColorPrimario(new java.awt.Color(255, 51, 51));
        panelGradient1.setColorSecundario(new java.awt.Color(255, 153, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Added Items");
        panelGradient1.add(jLabel2);
        jLabel2.setBounds(20, 10, 150, 70);

        jButton1.setBackground(new java.awt.Color(110, 168, 246));
        jButton1.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Borrow");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jButton2.setText("Cancel");

        jLabel3.setText("jLabel1");

        jLabel4.setText("Borrowers Name:");

        jLabel5.setText("Lenders Name:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(resposiveItem2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)))
        );

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(header1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
     Borrow();
    }//GEN-LAST:event_jButton1MouseClicked
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
  private void Borrow(){
    
    BorrowForm borrowform = new BorrowForm();
    ItemController control = new ItemController();
    Option option = ModalDialog.createOption();
    option.getLayoutOption().setSize(-1,1f)
            .setLocation(Location.RIGHT, Location.CENTER)
            .setAnimateDistance(0.7f, 0);
    SimpleModalBorder.Option[] options = new SimpleModalBorder.Option[]{
         new SimpleModalBorder.Option("Cancel",SimpleModalBorder.CANCEL_OPTION),
         new SimpleModalBorder.Option("Borrow",SimpleModalBorder.OK_OPTION),
    };
 ModalDialog.showModal(this,new SimpleModalBorder( borrowform, "Borrow Item", options,
    (controller,action)->{
        if (action==SimpleModalBorder.YES_OPTION) {
           
//             control.addItem(borrowform.getData());
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
private void populateData() throws SQLException{
    this.setEvent(new EventItem() {
        @Override
        public void itemClick(Component com, ItemsInfoModel item) {
            
             int response = JOptionPane.showConfirmDialog(
        null, 
             "Are you sure you want to add?", 
        "Confirmation", 
        JOptionPane.YES_NO_OPTION, 
        JOptionPane.QUESTION_MESSAGE
             );if (response == JOptionPane.YES_OPTION) {
            cartList.add(item);
             }
             System.out.println("Current cartList:");
       for (ItemsInfoModel cartItem : cartList) {
        System.out.println("Item Name: " + cartItem.getCategory() + ", Item ID: " + cartItem.getDescription());
    }
            try {
                populateCart();
            } catch (SQLException ex) {
                Logger.getLogger(PopItemForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    resposiveItem21.removeAll();
    ItemController controller = new ItemController();
    List<ItemsInfoModel>eventlist = controller.getAll();
    for (ItemsInfoModel itemsInfoModel : eventlist) {
        AddItems(itemsInfoModel);
        
    }
    repaint();
    revalidate();
    
}
private void populateCart() throws SQLException{
   
    resposiveItem2.removeAll();
    
    for (ItemsInfoModel itemsInfoModel : cartList) {
       addBorrow(itemsInfoModel);
        
    }
    repaint();
    revalidate();
    
}
 
        
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private inventocab.Components.Header header1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel panel;
    private inventocab.Swing.panelGradient panelGradient1;
    private inventocab.Swing.ResposiveItem resposiveItem1;
    private inventocab.Swing.ResposiveItem resposiveItem2;
    private inventocab.Swing.ResposiveItem2 resposiveItem21;
    // End of variables declaration//GEN-END:variables
}
