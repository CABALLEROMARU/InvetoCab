/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package inventocab.Items;

import inventocab.Models.ItemsInfoModel;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;


public class ItemPack extends javax.swing.JPanel {

   
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
    itemqty.setText(String.valueOf(data.getQuantity())); 
    category.setText(data.getCategory());
    dateReq.setText(dateReqStr);
    dateRec.setText(dateRecStr);

   
    if (data.getImage() != null && data.getImage().getIcon() != null) {
        itemImg.setImage(data.getImage().getIcon());
    } else {
        
        itemImg.setImage(new ImageIcon(getClass().getResource("/inventocab/Icons/defaultImage.png")));
    }
}
    
    public ItemPack() {
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
        itemqty = new javax.swing.JLabel();
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

        itemID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        itemID.setText("jLabel1");

        category.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        category.setText("jLabel1");

        itemName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        itemName.setText("jLabel1");

        itemLoc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        itemLoc.setText("jLabel1");

        itemqty.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        itemqty.setText("jLabel1");

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
                .addComponent(itemImg, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itemName, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itemLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itemqty, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateReq, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateRec, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(itemID, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemName)
                    .addComponent(jLabel1)
                    .addComponent(category)
                    .addComponent(jLabel3)
                    .addComponent(itemLoc)
                    .addComponent(jLabel4)
                    .addComponent(itemqty)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(dateReq)
                    .addComponent(jLabel7)
                    .addComponent(dateRec))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemID, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(itemImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel category;
    private javax.swing.JLabel dateRec;
    private javax.swing.JLabel dateReq;
    private javax.swing.JLabel itemID;
    private inventocab.Swing.PictureBox itemImg;
    private javax.swing.JLabel itemLoc;
    private javax.swing.JLabel itemName;
    private javax.swing.JLabel itemqty;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
