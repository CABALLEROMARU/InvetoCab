/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package inventocab.Items;

import inventocab.Models.ItemsInfoModel;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;


public class ItemPackInventory extends javax.swing.JPanel {

    public void setQuantity(int quantity) {
        this.quantity.setText(String.valueOf(quantity));
    }
    public boolean isSelected() {
        return Selected;
    }

   
    public void setSelected(boolean Selected) {
        this.Selected = Selected;
        repaint();
    }
 
  
    public ItemsInfoModel getData() {
        return data;
    }


    public void setData(ItemsInfoModel data) {
    this.data = data;

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

   
    String dateReqStr = (data.getDateRequest() != null) ? dateFormat.format(data.getDateRequest()) : "N/A"; 
    String dateRecStr = (data.getDateReceive() != null) ? dateFormat.format(data.getDateReceive()) : "N/A"; 

  
    itemID.setText(data.getItemID());
    itemLoc.setText(data.getItemLocation());
    itemName.setText(data.getItemName());
    quantity.setText(String.valueOf(data.getQuantity()));
    category.setText(data.getCategory());
    dateReq.setText(dateReqStr);
    dateRec.setText(dateRecStr);

   
    if (data.getImage() != null && data.getImage().getIcon() != null) {
        itemImg.setImage(data.getImage().getIcon());
    } else {
     
        itemImg.setImage(new ImageIcon(getClass().getResource("/inventocab/Icons/defaultImage.png")));
    }
}
    
    public ItemPackInventory() {
        initComponents();
    }
   private boolean Selected;
   private ItemsInfoModel data;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        itemImg = new inventocab.Swing.PictureBox();
        itemID = new javax.swing.JLabel();
        category = new javax.swing.JLabel();
        itemName = new javax.swing.JLabel();
        itemLoc = new javax.swing.JLabel();
        quantity = new javax.swing.JLabel();
        dateReq = new javax.swing.JLabel();
        dateRec = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        itemID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        itemID.setText("jLabel1");

        category.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        category.setText("jLabel1");

        itemName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        itemName.setText("jLabel1");

        itemLoc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        itemLoc.setText("jLabel1");

        quantity.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        quantity.setText("jLabel1");

        dateReq.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dateReq.setText("jLabel1");

        dateRec.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dateRec.setText("jLabel1");

        jLabel1.setText("Item Name:");

        jLabel2.setText("Item ID:");

        jLabel3.setText("Category:");

        jLabel4.setText("CabinetDoor:");

        jLabel5.setText("Quantity:");

        jLabel6.setText("DateReq:");

        jLabel7.setText("DateRec:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(itemImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7))
                                    .addGap(26, 26, 26))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(59, 59, 59)
                                        .addComponent(itemID, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateRec, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateReq, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(itemName, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(itemLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 9, Short.MAX_VALUE))
                            .addComponent(category, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(itemImg, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemName)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(category))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(itemLoc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(quantity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(dateReq))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(dateRec))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemID, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
 
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel category;
    private javax.swing.JLabel dateRec;
    private javax.swing.JLabel dateReq;
    private javax.swing.JLabel itemID;
    private inventocab.Swing.PictureBox itemImg;
    private javax.swing.JLabel itemLoc;
    private javax.swing.JLabel itemName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel quantity;
    // End of variables declaration//GEN-END:variables
}
