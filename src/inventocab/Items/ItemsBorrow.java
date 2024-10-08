
package inventocab.Items;

import com.formdev.flatlaf.ui.FlatListCellBorder.Selected;
import inventocab.Models.ItemsInfoModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Calyle
 */
public class ItemsBorrow extends javax.swing.JPanel {

    /**
     * @return the selected
     */
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
    public ItemsInfoModel getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(ItemsInfoModel data) {
        this.data = data;
        
        
        String qty = Integer.toString(data.getQuantity());
       itemsId.setText(data.getItemID());
        
        itemsName.setText(data.getItemName());
        quantity.setText(qty);
       
        category.setText(data.getCategory());
    }

   private boolean selected;
   private ItemsInfoModel data;
   
 
    public ItemsBorrow() {
        initComponents();
        
         jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            increaseQuantity();
        }
    });
    
    // ActionListener for decreasing the quantity
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            decreaseQuantity();
        }
    });
    
    // ActionListener for manually inputting the quantity
    jTextField10.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            updateQuantityFromTextField();
        }
    });
}

// Method to increase the quantity
private void increaseQuantity() {
    int currentQuantity = getCurrentQuantityFromTextField(); // Get validated quantity from text field
    currentQuantity++; // Increase the quantity
    updateQuantityFields(currentQuantity); // Update all fields
}

// Method to decrease the quantity
private void decreaseQuantity() {
    int currentQuantity = getCurrentQuantityFromTextField(); // Get validated quantity from text field
    if (currentQuantity > 1) {
        currentQuantity--; // Decrease the quantity
    }
    updateQuantityFields(currentQuantity); // Update all fields
}

// Method to update quantity from the text field (manual input)
private void updateQuantityFromTextField() {
    int inputQuantity = getCurrentQuantityFromTextField(); // Get validated quantity from text field
    if (inputQuantity > 0) {
        updateQuantityFields(inputQuantity); // Update if input is valid (greater than 0)
    } else {
        jTextField10.setText("1"); // Set to 1 if invalid
    }
}

// Method to get the current quantity from the text field with validation
private int getCurrentQuantityFromTextField() {
    String text = jTextField10.getText().trim(); // Get the text and trim any whitespace
    
    // Check if the text field is empty or contains invalid data
    if (text.isEmpty()) {
        return 1; // Default to 1 if empty
    }
    
    try {
        // Try to parse the text as an integer
        return Integer.parseInt(text);
    } catch (NumberFormatException e) {
        // If the input is invalid, default to 1
        jTextField10.setText("1");
        return 1;
    }
}

// Method to update all quantity-related fields and the data model
private void updateQuantityFields(int quantityValue) {

  try {
        int inputQuantity = Integer.parseInt(jTextField10.getText()); // Get the quantity from the text field
        
        // Check if input exceeds available quantity
        if (inputQuantity == data.getQuantity()) {
            // Notify the user or handle invalid input
            jTextField10.setText(String.valueOf(data.getQuantity())); // Reset to maximum available quantity
            JOptionPane.showMessageDialog(this, "Invalid quantity. Maximum available: " + data.getQuantity(), "Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method early to avoid further processing
        } 
        
        // Validate input to be positive
        if (inputQuantity <= 0) {
            jTextField10.setText("1"); // Set to 1 if invalid
        } else {
            data.setQuantity(quantityValue);
            updateQuantityFields(inputQuantity); // Update if input is valid
        }
        
    } catch (NumberFormatException e) {
        jTextField10.setText("1");
    }
}

   private int qnty = 1;
  
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
        jTextField10 = new javax.swing.JTextField();

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

        jTextField10.setEditable(false);
        jTextField10.setOpaque(true);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(23, 23, 23)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(category)
                    .addComponent(itemsName)
                    .addComponent(itemsId)
                    .addComponent(quantity))
                .addGap(0, 128, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(1, 1, 1)
                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton1)
                .addGap(5, 5, 5))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemsId)
                    .addComponent(jLabel1))
                .addGap(10, 10, 10)
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
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private javax.swing.JLabel itemsId;
    private javax.swing.JLabel itemsName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel quantity;
    private inventocab.Swing.ResposiveItem2 resposiveItem21;
    // End of variables declaration//GEN-END:variables
}
