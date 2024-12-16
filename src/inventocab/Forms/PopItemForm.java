/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package inventocab.Forms;

import com.formdev.flatlaf.FlatClientProperties;
import inventocab.Controller.BorrowerController;
import inventocab.Controller.ItemController;
import inventocab.Event.EventItem;
import inventocab.Items.ItemLogsPop;
import inventocab.Items.ItemPackInventory;
import inventocab.Items.ItemsBorrow;
import inventocab.Models.BorrowerInfoModel;
import inventocab.Models.ItemsInfoModel;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import raven.datetime.component.date.DatePicker;
import raven.modal.ModalDialog;
import raven.modal.Toast;
import raven.modal.component.SimpleModalBorder;
import raven.modal.demo.simple.SimpleMessageModal;
import raven.modal.listener.ModalCallback;
import raven.modal.listener.ModalController;
import raven.modal.option.Location;
import raven.modal.option.Option;



public class PopItemForm extends javax.swing.JPanel {
  private javax.swing.JTextField itemsId;
    private javax.swing.JTextField itemsName; 
    private javax.swing.JTextField jTextField10; 
     private ItemsBorrow borrowInstance;
    private Item_Form itemForm; 
    
    private List<ItemsInfoModel>cartList = new ArrayList<>();

    
      ItemsBorrow borrow = new ItemsBorrow();
      
   private EventItem cartEvent;
   private EventItem event;
    public PopItemForm(ItemsBorrow borrowInstance,Item_Form itemForm) {
    this.borrowInstance = borrowInstance;
     this.itemForm = itemForm;
}
    
    
   

public BorrowerInfoModel getData() {
    try {
        LocalDate requestedDate = dateRequested.isDateSelected() ? dateRequested.getSelectedDate() : null;
        LocalDate releaseDate = dateReleased.isDateSelected() ? dateReleased.getSelectedDate() : null;

        Date dateRequestedData = requestedDate != null ? Date.valueOf(requestedDate) : null;
        Date dateReleaseData = releaseDate != null ? Date.valueOf(releaseDate) : null;

        String borrowerId = BorId.getText();
        String borrowerNameText = borrowerName.getText();
        String lenderNameText = lenderername.getText();
        String statusText = (String) status.getSelectedItem();
        String returnStatusText =null;
        String remarks = null;
        String allItemsID = allitemsID.getText();
        
        BorrowerInfoModel borrowerInfo = new BorrowerInfoModel(
        borrowerId,
        borrowerNameText,
        lenderNameText,
        dateRequestedData,
        dateReleaseData,
        statusText,
        returnStatusText,
                remarks,
        allItemsID,
        cartList
    );

        // Debugging output
       

        if (borrowerId.isEmpty() || borrowerNameText.isEmpty() || lenderNameText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields must be filled out.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (cartList == null || cartList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cart list cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return null; 
        }

        // Create a new BorrowerInfoModel
        return new BorrowerInfoModel(borrowerId, borrowerNameText, lenderNameText, dateRequestedData, dateReleaseData, statusText,returnStatusText,remarks, allItemsID, cartList);
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "An error occurred while retrieving data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }
}

    public void setEvent(EventItem event) {
        this.event = event;
    }
     public EventItem getCartEvent() {
        return cartEvent;
    }

    public void setCartEvent(EventItem cartEvent) {
        this.cartEvent = cartEvent;
    }

     private ItemController items = new ItemController();
    
       private DatePicker dateRequested = new DatePicker();
       private DatePicker dateReleased = new DatePicker();
       
    public PopItemForm() throws SQLException {
        initComponents();
        init();
        populateData();
          String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String randomID = generateRandomID(Alphabet, 6);
        BorId.setText(randomID);
        allitemsID.setText(randomID);
        
        datePicker1.setCloseAfterSelected(true);
        datePicker1.setEditor(dateBor);
        
          dateRequested.setEditor(dateBor);
    
    dateRequested.setCloseAfterSelected(true);
    
   
    dateRequested.setDateFormat("yyyy-MM-dd");
    dateRequested.now();
   
 datePicker2.setCloseAfterSelected(true);
    datePicker2.setEditor(daterel);

    dateReleased.setEditor(daterel);
    dateReleased.setCloseAfterSelected(true);
    dateReleased.setDateFormat("yyyy-MM-dd");

    LocalDate nextEligibleDate = calculateNextEligibleDate(3);
    dateReleased.setSelectedDate(nextEligibleDate);
    }
    
     private LocalDate calculateNextEligibleDate(int daysToAdd) {
    LocalDate date = LocalDate.now();
    int addedDays = 0;

    while (addedDays < daysToAdd) {
        date = date.plusDays(1);
      
        if (date.getDayOfWeek() != DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY) {
            addedDays++;
        }
    }
    return date;
     }
   private static String generateRandomID(String candidateChar,int length){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChar.charAt(random.nextInt(candidateChar.length())));
            
        }
        return sb.toString();
        
    }
  
   
   public void updateQuantity(ItemsInfoModel item, int newQuantity) {
    System.out.println("updateQuantity called with item ID: " + item.getItemID() + " and new quantity: " + newQuantity);
    for (Component com : resposiveItem21.getComponents()) {
        ItemPackInventory i = (ItemPackInventory) com;
        if (i.getData().getItemID().equals(item.getItemID())) {
            if (newQuantity <= i.getData().getQuantity()) {
                i.getData().setQuantity(newQuantity);
                i.setQuantity(newQuantity);
               
                for (Component borrowCom : resposiveItem2.getComponents()) {
                    ItemsBorrow borrow = (ItemsBorrow) borrowCom;
                    if (borrow.getData().getItemID().equals(item.getItemID())) {
                        System.out.println("Found ItemsBorrow component for item ID: " + item.getItemID());
                        borrow.updateQuantityField(newQuantity);
                    } else {
                        
                        borrow.updateQuantityField(borrow.getData().getQuantity());
                    }
                }
            } else {
              
            }
        }
    }
    repaint();
    revalidate();
}
   
   public void addCartData(ItemsInfoModel data) {
    ItemsBorrow cartItem = new ItemsBorrow();
    cartItem.setData(data);
    
    
    int cartIndex = cartList.indexOf(data);
    
    if (cartIndex == -1) {
       
        data.setCartQuantity(1); 
        cartList.add(data); 
    } else {
       
        cartList.set(cartIndex, data); 
    }

    
    cartItem.setQtyData(data.getCartQuantity());

   
    cartItem.getRemovebtn().addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int cartIndexdata = cartList.indexOf(data);
            if (cartIndexdata != -1) {
                cartList.remove(cartIndexdata);
                resposiveItem2.remove(cartItem);
                repaint();
                revalidate();
            }
        }
    });

    cartItem.getAddbtn().addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (cartIndex != -1) {
                int newQty = data.getCartQuantity() + 1; 
                data.setCartQuantity(newQty);
                cartItem.setQtyData(newQty);
                cartList.set(cartIndex, data);
            }
        }
    });

    cartItem.getMinusbtn().addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (cartIndex != -1) {
                if (data.getCartQuantity() > 1) {
                    int newQty = data.getCartQuantity() - 1; 
                    data.setCartQuantity(newQty);
                    cartItem.setQtyData(newQty);
                    cartList.set(cartIndex, data);
                }
            }
        }
    });

    cartItem.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e)) {
              
                
            }
        }
    });

    resposiveItem2.add(cartItem);
    repaint();
    revalidate();
}

   
public void addBorrow(ItemsInfoModel data) throws SQLException {
   

    ItemsBorrow itemsborrow = new ItemsBorrow();
    itemsborrow.setData(data);
    itemsborrow.setPopItemForm(this);
    itemsborrow.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e)) {
                if (!cartList.contains(data)) {
    event.itemClick(itemsborrow, data);
    itemsborrow.setEnabled(false);
} else {
   
    JOptionPane.showMessageDialog(null, "Item has already been added to the cart");
}        
            }else if (cartList.stream().anyMatch(item -> item.getItemID().equals(data.getItemID()))){
                JOptionPane.showMessageDialog(itemsborrow, "Item is already added in the list", "Error", JOptionPane.ERROR_MESSAGE);
        return;
                
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

    
    if (!Arrays.stream(resposiveItem2.getComponents())
            .anyMatch(com -> ((ItemsBorrow) com).getData().getItemID().equals(data.getItemID()))) {
        resposiveItem2.add(itemsborrow);
    }

   
    for (Component com : resposiveItem2.getComponents()) {
        ItemsBorrow borrow = (ItemsBorrow) com;
        if (!borrow.getData().getItemID().equals(data.getItemID())) {
          
            borrow.updateQuantityField(borrow.getData().getQuantity());
        }
    }
    
    repaint();
    revalidate();
}


  public void refreshItemUI(String itemId) {
        for (Component com : resposiveItem21.getComponents()) {
            ItemPackInventory itemPackInventory = (ItemPackInventory) com;
            if (itemPackInventory.getData().getItemID().equals(itemId)) {
               
                itemPackInventory.setQuantity(itemPackInventory.getData().getQuantity());
                break; 
            }
        }
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
                   event.itemClick(itemPackInventory, data);
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
    public void removeItem(ItemsBorrow item) {
   
    resposiveItem2.remove(item);
    
   
    revalidate();
    repaint();
}
    
    private ItemsBorrow findItemsBorrowByItemId(String itemId) {
    for (Component comp : resposiveItem2.getComponents()) {
        if (comp instanceof ItemsBorrow) {
            ItemsBorrow itemsBorrow = (ItemsBorrow) comp;
            if (itemsBorrow.getData().getItemID().equals(itemId)) {
                return itemsBorrow;
            }
        }
    }
    return null; // Not found
}

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datePicker1 = new raven.datetime.component.date.DatePicker();
        datePicker2 = new raven.datetime.component.date.DatePicker();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resposiveItem1 = new inventocab.Swing.ResposiveItem();
        resposiveItem21 = new inventocab.Swing.ResposiveItem2();
        jPanel1 = new javax.swing.JPanel();
        panelGradient1 = new inventocab.Swing.panelGradient();
        jLabel2 = new javax.swing.JLabel();
        borrowBut = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        BorId = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        borrowerName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lenderername = new javax.swing.JTextField();
        dateBor = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        allitemsID = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        daterel = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        resposiveItem2 = new inventocab.Swing.ResposiveItem();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        search = new inventocab.Swing.SearchText();

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

        borrowBut.setBackground(new java.awt.Color(110, 168, 246));
        borrowBut.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        borrowBut.setForeground(new java.awt.Color(255, 255, 255));
        borrowBut.setText("Borrow");
        borrowBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowButActionPerformed(evt);
            }
        });

        cancel.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        BorId.setText("jLabel1");

        jLabel4.setText("Borrower's Name:");

        jLabel5.setText("Costudian's Name:");

        jLabel8.setText("Date File:");

        allitemsID.setText("jLabel3");

        jLabel3.setText("Date Release:");

        jLabel7.setText("Item Status:");

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 - New ", "2 - Good Condition", "3 - Slightly Damaged", "4 - Highly Damaged " }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BorId, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(allitemsID, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lenderername, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(dateBor)
                    .addComponent(daterel)
                    .addComponent(status, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(borrowerName))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(borrowerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lenderername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateBor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(daterel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(BorId, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(allitemsID, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane2.setViewportView(resposiveItem2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(borrowBut, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))
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
                    .addComponent(cancel)
                    .addComponent(borrowBut)))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventocab/icons/search.png"))); // NOI18N

        search.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        search.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
   try {
       
           searchEvent(search.getText());
        } catch (ParseException ex) {
            Logger.getLogger(PopItemForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PopItemForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchKeyReleased
 private List<BorrowerInfoModel> borrowedData = new ArrayList<>();
    private void borrowButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowButActionPerformed
  // Get the current date
//    LocalDate currentDate = LocalDate.now();
//    
//    // Check if the current day is Saturday or Sunday
//    if (currentDate.getDayOfWeek() == DayOfWeek.SATURDAY || currentDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
//        JOptionPane.showMessageDialog(null, "Borrowing is not allowed on weekends (Saturday and Sunday).", "Error", JOptionPane.ERROR_MESSAGE);
//        return; // Exit the method if it's a weekend
//    }
//        
        
        BorrowerController control = new BorrowerController(this, itemForm);
  
      Item_Form itemform = null;
      try {
          itemform = new Item_Form();
      } catch (SQLException ex) {
          Logger.getLogger(PopItemForm.class.getName()).log(Level.SEVERE, null, ex);
      }
    for (ItemsInfoModel item : cartList) {
        ItemsBorrow itemsBorrow = findItemsBorrowByItemId(item.getItemID());
        if (itemsBorrow != null) {
            int quantityInField = Integer.parseInt(itemsBorrow.getJTextField10().getText().trim());
            if (quantityInField <= 0) {
                JOptionPane.showMessageDialog(null, "Unable to borrow. Quantity must be greater than 0.", "Error", JOptionPane.ERROR_MESSAGE);
                return; 
            }
        }
    }     

    BorrowerInfoModel borrowerInfo = getData(); // Ensure this is called

    if (borrowerInfo != null && !borrowerInfo.getCartList().isEmpty()) {
        List<BorrowerInfoModel> borrowerList = new ArrayList<>();
        for (ItemsInfoModel item : borrowerInfo.getCartList()) {
            Date dateRelease = borrowerInfo.getDateRelease() != null ? new Date(borrowerInfo.getDateRelease().getTime()) : null;
            Date dateRequest = borrowerInfo.getDateRequest() != null ? new Date(borrowerInfo.getDateRequest().getTime()) : null;

            // Create a new BorrowerInfoModel instance
            BorrowerInfoModel newBorrower = new BorrowerInfoModel(
                borrowerInfo.getBorrowerId(),
                borrowerInfo.getBorrowerName(),
                borrowerInfo.getLenderName(),
                dateRequest, // Ensure this is a Date
                dateRelease,  // Ensure this is a Date
                borrowerInfo.getStatus(),
                borrowerInfo.getReturnStatus(),
                borrowerInfo.getRemarks(),
                borrowerInfo.getAllItemsID(),
                List.of(item) // Ensure this is a List<ItemsInfoModel>
            );
            borrowerList.add(newBorrower);
        }
           
        // Call the addBorrow method to insert the data into the database
        control.addBorrow(borrowerList);
      
        if (itemForm != null) {
            itemForm.refreshItemQuantities(borrowerInfo.getCartList());
        }
        try {
            itemform.populateAddData();
        } catch (SQLException ex) {
            Logger.getLogger(PopItemForm.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        JOptionPane.showMessageDialog(null, "Your borrowed items are being processed. " + "\n" + "Please come back after 3 days to receive the items.", "Success", JOptionPane.INFORMATION_MESSAGE);
        
      try {
            populateData();
        } catch (SQLException ex) {
            Logger.getLogger(PopItemForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Clear the cartList after successful borrowing
        cartList.clear();
         try {
            populateCart(); // Refresh the cart display
        } catch (SQLException ex) {
            Logger.getLogger(PopItemForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Failed to add borrow data. Please check the input.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_borrowButActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
      cartList.clear();
       cartList.removeAll(cartList);
      try {
          populateCart();
      } catch (SQLException ex) {
          Logger.getLogger(PopItemForm.class.getName()).log(Level.SEVERE, null, ex);
      }
    }//GEN-LAST:event_cancelActionPerformed

// 

    
 
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
    
    
  private void searchEvent(String search) throws ParseException, SQLException {
    this.setEvent(new EventItem() {
        @Override
        public void itemClick(Component com, ItemsInfoModel itemsInfoModel) {
           
          int response = JOptionPane.showConfirmDialog(
        null, 
             "Are you sure you want to add?", 
        "Confirmation", 
        JOptionPane.YES_NO_OPTION, 
        JOptionPane.QUESTION_MESSAGE
             );if (response == JOptionPane.YES_OPTION) {
            cartList.add(itemsInfoModel);
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
    List<ItemsInfoModel> itemsInfoModels = (List<ItemsInfoModel>) controller.searchItems(search); 

  
    for (ItemsInfoModel item : itemsInfoModels) {
        AddItems(item); 
      
    }

  
    
    repaint();
    revalidate();
}
 void populateData() throws SQLException{
    this.setEvent(new EventItem() {
        @Override
        public void itemClick(Component com, ItemsInfoModel item) {
              if (item.getQuantity() == 0) {
                    JOptionPane.showMessageDialog(null, "Item is out of stock", "Out of Stock", JOptionPane.WARNING_MESSAGE);
                    return;
                }
             if (cartList.contains(item)) {
                JOptionPane.showMessageDialog(null, "Item is already in Cart");
                return;
            }
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
         
        System.out.println("Item Name: " + cartItem.getItemName() + ", Item ID: " + cartItem.getItemID());
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

        addCartData(itemsInfoModel);
    }
    repaint();
    revalidate();
    
}
 
        
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BorId;
    private javax.swing.JLabel allitemsID;
    private javax.swing.JButton borrowBut;
    private javax.swing.JTextField borrowerName;
    private javax.swing.JButton cancel;
    private javax.swing.JFormattedTextField dateBor;
    private raven.datetime.component.date.DatePicker datePicker1;
    private raven.datetime.component.date.DatePicker datePicker2;
    private javax.swing.JFormattedTextField daterel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lenderername;
    private javax.swing.JPanel panel;
    private inventocab.Swing.panelGradient panelGradient1;
    private inventocab.Swing.ResposiveItem resposiveItem1;
    private inventocab.Swing.ResposiveItem resposiveItem2;
    private inventocab.Swing.ResposiveItem2 resposiveItem21;
    private inventocab.Swing.SearchText search;
    private javax.swing.JComboBox<String> status;
    // End of variables declaration//GEN-END:variables

   
}
