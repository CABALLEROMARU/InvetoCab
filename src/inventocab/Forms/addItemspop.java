
package inventocab.Forms;

import com.formdev.flatlaf.util.UIScale;
import inventocab.Models.ItemsInfoModel;
import inventocab.Models.others.ItemImageModel;
import java.awt.Rectangle;
import java.awt.Shape;
import java.io.File;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;
import javaswingdev.picturebox.DefaultPictureBoxRender;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import jnafilechooser.api.JnaFileChooser;
import raven.datetime.component.date.DatePicker;



public class addItemspop extends javax.swing.JPanel {

    
//    public ItemsInfoModel getData() {
//       int quantity = Integer.parseInt(this.quantity.getText());
//        return new ItemsInfoModel(idLbl.getText(), Itemname.getText(),(String) category.getSelectedItem()
//                ,(String) cabinetdr.getSelectedItem(), quantity, itemImageModel, description.getText());
//        
//    }
public ItemsInfoModel getData() {
    try {
        String quantityText = this.quantity.getText();
      
        int quantity = Integer.parseInt(quantityText);  // Parse the quantity if it's a valid integer
         Date dateRequestedData =dateRequested.isDateSelected()? Date.valueOf(dateRequested.getSelectedDate()):null;
     Date dateReceiveData =dateReceive.isDateSelected()?Date.valueOf(dateReceive.getSelectedDate()):null;
        return new ItemsInfoModel(idLbl.getText(), Itemname.getText(), 
                                  (String) category.getSelectedItem(), 
                                  (String) cabinetdr.getSelectedItem(), 
                                  quantity, itemImageModel, description.getText(),dateRequestedData,dateReceiveData);
    } catch (NumberFormatException e) {
      
        System.err.println("Invalid input for quantity: " + this.quantity.getText());
      
        return null;
    }
}

public void processItemData() {
    ItemsInfoModel data = getData();  // getData() might return null

    if (data != null) {
        // Only proceed if data is not null
        System.out.println("Item ID: " + data.getItemID());
        System.out.println("Item Name: " + data.getItemName());
        // Additional operations with the data...
    } else {
        // Handle the case where data is null (invalid input)
        System.err.println("Error: Could not process item data due to invalid input.");
    }
}
    public void setData(ItemsInfoModel data) {
         this.data = data;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateReqStr = dateFormat.format(data.getDateRequest());
         String dateRecStr = dateFormat.format(data.getDateReceive());
        String qty = Integer.toString(data.getQuantity());
        idLbl.setText(data.getItemID());
        cabinetdr.setSelectedItem(data.getItemLocation());
        Itemname.setText(data.getItemName());
        quantity.setText(qty);
      
        category.setSelectedItem(data.getCategory());
        dateReq.setText(dateRecStr);
        dateRec.setText(dateRecStr);
       if (data.getImage() != null && data.getImage().getIcon() != null) {
        itemImage.setImage(data.getImage().getIcon());
    } else {
        // Handle the case where image is null, e.g., set a default image
        itemImage.setImage(new ImageIcon(getClass().getResource("/inventocab/Icons/defaultImage.png")));
    }
    }

   private ItemsInfoModel data;
   private DatePicker dateRequested = new DatePicker();
   private DatePicker dateReceive = new DatePicker();
   
    public addItemspop() {
        initComponents();
        DatePicker();
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String randonID = generateRandomID(Alphabet, 6);
        idLbl.setText(randonID);
        dateRequested.setEditor(dateReq);
    dateReceive.setEditor(dateRec);
    dateRequested.setCloseAfterSelected(true);
    dateReceive.setCloseAfterSelected(true);
    dateReceive.setDateFormat("yyyy-MM-dd");
    dateRequested.setDateFormat("yyyy-MM-dd");
    dateRequested.now();
    dateReceive.now();
  

    
    }
private static String generateRandomID(String candidateChar,int length){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChar.charAt(random.nextInt(candidateChar.length())));
            
        }
        return sb.toString();
        
    }
  
  public void DatePicker() {


 


}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Itemname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        imagepanel = new javax.swing.JPanel();
        itemImage = new inventocab.Swing.PictureBox();
        description = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        category = new javax.swing.JComboBox<>();
        quantity = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dateReq = new javax.swing.JFormattedTextField();
        cabinetdr = new javax.swing.JComboBox<>();
        idLbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dateRec = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Item Name");

        Itemname.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Image");

        javax.swing.GroupLayout imagepanelLayout = new javax.swing.GroupLayout(imagepanel);
        imagepanel.setLayout(imagepanelLayout);
        imagepanelLayout.setHorizontalGroup(
            imagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(itemImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        imagepanelLayout.setVerticalGroup(
            imagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagepanelLayout.createSequentialGroup()
                .addComponent(itemImage, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
        );

        description.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Description");

        jLabel5.setText("Category");

        jLabel6.setText("Cabinet Door");

        category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tools", "Equipments", "Components", "Circuits" }));

        jLabel7.setText("Quantity");

        jLabel8.setText("Date Requested");

        cabinetdr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", " " }));

        idLbl.setText("jLabel3");

        jLabel3.setText("Browse");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel10.setText("Date Receive");

        jToolBar1.setRollover(true);

        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Delete");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jLabel1))
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(description, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imagepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addComponent(quantity, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(category, javax.swing.GroupLayout.Alignment.LEADING, 0, 270, Short.MAX_VALUE)
                            .addComponent(dateReq, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cabinetdr, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateRec, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(2, 2, 2)))
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(idLbl))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(108, Short.MAX_VALUE)
                    .addComponent(Itemname, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(26, 26, 26)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(idLbl)
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(cabinetdr, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateReq, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dateRec, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                .addComponent(imagepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(65, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(Itemname, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(559, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents
private ItemImageModel itemImageModel;
    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
      JnaFileChooser ch = new JnaFileChooser();
     ch.addFilter("image", "png","jpg");
     boolean act = ch.showOpenDialog(SwingUtilities.getWindowAncestor(this));
        if (act) {
            File file = ch.getSelectedFile();
            itemImage.setImage(new ImageIcon(file.getAbsolutePath()));
            itemImageModel = new ItemImageModel(file);
        }
    }//GEN-LAST:event_jLabel3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Itemname;
    private javax.swing.JComboBox<String> cabinetdr;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JFormattedTextField dateRec;
    private javax.swing.JFormattedTextField dateReq;
    private javax.swing.JTextField description;
    private javax.swing.JLabel idLbl;
    private javax.swing.JPanel imagepanel;
    private inventocab.Swing.PictureBox itemImage;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField quantity;
    // End of variables declaration//GEN-END:variables
}
