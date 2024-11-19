
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
import javax.swing.JButton;
import javax.swing.JOptionPane;
import raven.modal.ModalDialog;
import raven.modal.component.SimpleModalBorder;
import raven.modal.demo.layout.ResponsiveLayout;


public class ItemsBorrow extends javax.swing.JPanel {
     private PopItemForm popItemForm;

    
     
    public ItemsInfoModel getData() {
        return data;
    }

  
   public javax.swing.JTextField getJTextField10() {
    return quantityField;
}
    
   private ItemsInfoModel data;

    public boolean isSelected() {
        return selected;
    }

    
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

   
    

    
    
     

   
    public void setQtyData(int qtyData){
        this.qtyData = qtyData;
        String qtyStr = Integer.toString(qtyData);
        quantityField.setText(qtyStr);
    }
       private int qtyData;;
    public void setData(ItemsInfoModel data) {
        this.data = data;

        
        String qty = Integer.toString(data.getQuantity());
       itemsId.setText(data.getItemID());
        
        itemsName.setText(data.getItemName());
        quantity.setText(qty);
        String cartQtyStr = Integer.toString(data.getCartQuantity());
        quantityField.setText(cartQtyStr);
        category.setText(data.getCategory());
        
    }

   private boolean selected;
  

 
    public ItemsBorrow() {
        initComponents();
         
        
         jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            increaseQuantity();
        }
    });
    
    
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            decreaseQuantity();
        }
    });
    
    
   
    quantityField.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            updateQuantityFromTextField();
        }
    });
    deleteBut.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
       
        int result = JOptionPane.showConfirmDialog(ItemsBorrow.this, "Are you sure you want to remove this item?", "Confirm", JOptionPane.YES_NO_OPTION);
        
        if (result == JOptionPane.YES_OPTION) {
          
            if (popItemForm != null) {
                popItemForm.removeItem(ItemsBorrow.this);
            }
        }
    }
});
}
public JButton getAddbtn(){
    return jButton1;
}
public JButton getMinusbtn(){
    return jButton2;
}
public JButton getRemovebtn(){
    return deleteBut;
}


private void increaseQuantity() {
    int currentQuantity = getCurrentQuantityFromTextField(); 
    if (currentQuantity < data.getQuantity()) {
        currentQuantity++; 
    } else {
        JOptionPane.showMessageDialog(this, "Invalid quantity. Maximum available: " + data.getQuantity(), "Error", JOptionPane.ERROR_MESSAGE);
        quantityField.setText(String.valueOf(data.getQuantity())); 
        return;
    }
    updateQuantityFields(currentQuantity); 
}


private void decreaseQuantity() {
    int currentQuantity = getCurrentQuantityFromTextField(); 
    if (currentQuantity > 1) {
        currentQuantity--; 
    }
    updateQuantityFields(currentQuantity); 
}


private void updateQuantityFromTextField() {
    int inputQuantity = getCurrentQuantityFromTextField(); 
    if (inputQuantity > 0) {
        updateQuantityFields(inputQuantity);
    } else {
        quantityField.setText("1"); 
    }
}


private int getCurrentQuantityFromTextField() {
    String text = quantityField.getText().trim(); 
    
  
    if (text.isEmpty()) {
        return 1; 
    }
    
    try {
        
        return Integer.parseInt(text);
    } catch (NumberFormatException e) {
       
        quantityField.setText("1");
        return 1;
    }
}


    public void setPopItemForm(PopItemForm popItemForm) {
    this.popItemForm = popItemForm;
}

private void updateQuantityFields(int quantityValue) {
    if (quantityValue > data.getQuantity()) {
        JOptionPane.showMessageDialog(this, "Invalid quantity. Maximum available: " + data.getQuantity(), "Error", JOptionPane.ERROR_MESSAGE);
        quantityField.setText(String.valueOf(data.getQuantity())); 
        return;
    }

    quantityField.setText(String.valueOf(quantityValue)); 
}
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        itemsId = new javax.swing.JLabel();
        itemsName = new javax.swing.JLabel();
        quantity = new javax.swing.JLabel();
        category = new javax.swing.JLabel();
        quantityField = new javax.swing.JTextField();
        deleteBut = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        panel.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(0, 102, 204));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText(">");

        jButton2.setBackground(new java.awt.Color(0, 102, 204));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("<");

        jLabel1.setText("Items ID:");

        jLabel2.setText("Items Name:");

        jLabel3.setText("Category:");

        jLabel4.setText("Quantity:");

        itemsId.setText("jLabel5");

        itemsName.setText("jLabel6");

        quantity.setText("jLabel7");

        category.setText("jLabel8");

        quantityField.setEditable(false);
        quantityField.setOpaque(true);

        deleteBut.setForeground(new java.awt.Color(204, 204, 204));
        deleteBut.setText("X");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(23, 23, 23)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(category)
                            .addComponent(itemsName)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(itemsId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                                .addComponent(deleteBut, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(quantity)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(1, 1, 1)
                        .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemsId, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBut))
                .addGap(6, 6, 6)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemsName)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantity)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(category)
                    .addComponent(jLabel3))
                .addGap(1, 1, 1)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel category;
    private javax.swing.JButton deleteBut;
    private javax.swing.JLabel itemsId;
    private javax.swing.JLabel itemsName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel quantity;
    public javax.swing.JTextField quantityField;
    private inventocab.Swing.ResposiveItem2 resposiveItem21;
    // End of variables declaration//GEN-END:variables

   

   
}
