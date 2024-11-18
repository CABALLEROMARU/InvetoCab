
package inventocab.Items;

import com.formdev.flatlaf.ui.FlatListCellBorder.Selected;
import inventocab.Event.EventItem;
import inventocab.Forms.PopItemForm;

import inventocab.Models.ItemsInfoModel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import raven.modal.ModalDialog;
import raven.modal.component.SimpleModalBorder;
import raven.modal.demo.layout.ResponsiveLayout;

/**
 *
 * @author Calyle
 */
public class ItemsBorrowLogsPop extends javax.swing.JPanel {
     private PopItemForm popItemForm;

    /**
     * @return the selected
     */
     
    public ItemsInfoModel getData() {
        return data;
    }

  
  
    
   private ItemsInfoModel data;
//     Your component initialization code here
//     </editor-fold>
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * @return the data
     */
    

    /**
     * @param data the data to set
     */
    
     

   
    public void setQtyData(int qtyData){
        this.qtyData = qtyData;
        String qtyStr = Integer.toString(qtyData);
        
    }
       private int qtyData;;
    public void setData(ItemsInfoModel data) {
        this.data = data;

        
        
       itemsId.setText(data.getItemID());
        
        itemsName.setText(data.getItemName());
         String cartQtyStr = Integer.toString(data.getCartQuantity());
        quantity.setText(cartQtyStr);
     
        
        category.setText(data.getCategory());
        
        
    }

   private boolean selected;
  

 
    public ItemsBorrowLogsPop() {
        initComponents();
         
        
        
// Method to increase the quantity


// Method to decrease the quantity

    }
// Method to get the current quantity from the text field with validation



    public void setPopItemForm(PopItemForm popItemForm) {
    this.popItemForm = popItemForm;
}

//private void updateQuantityFields(int quantityValue) {
//    if (quantityValue > data.getQuantity()) {
//        JOptionPane.showMessageDialog(this, "Invalid quantity. Maximum available: " + data.getQuantity(), "Error", JOptionPane.ERROR_MESSAGE);
//        quantityField.setText(String.valueOf(data.getQuantity())); // Reset to maximum available quantity
//        return;
//    }
//
//    quantityField.setText(String.valueOf(quantityValue)); // Update the quantity in the jTextField10
//}
public void updateQuantityField(int quantity) {
     System.out.println(" quantity: " + quantity);
      data.setQuantity(quantity);
    this.quantity.setText(String.valueOf(quantity));
}
public void updateQuantity(ItemsInfoModel item, int newQuantity) {
   if (item.getItemID().equals(data.getItemID())) {
        data.setQuantity(newQuantity);
        quantity.setText(String.valueOf(newQuantity));
    }
}


  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        resposiveItem21 = new inventocab.Swing.ResposiveItem2();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        itemsId = new javax.swing.JLabel();
        itemsName = new javax.swing.JLabel();
        quantity = new javax.swing.JLabel();
        category = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        panel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Items ID:");

        jLabel2.setText("Items Name:");

        jLabel3.setText("Category:");

        jLabel4.setText("Quantity:");

        itemsId.setText("jLabel5");

        itemsName.setText("jLabel6");

        quantity.setText("jLabel7");

        category.setText("jLabel8");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemsName)
                    .addComponent(quantity)
                    .addComponent(category))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(itemsId)))
                .addGap(164, 164, 164))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemsId, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemsName)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantity)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(category))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel category;
    private javax.swing.JLabel itemsId;
    private javax.swing.JLabel itemsName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel quantity;
    private inventocab.Swing.ResposiveItem2 resposiveItem21;
    // End of variables declaration//GEN-END:variables

   

   
}
