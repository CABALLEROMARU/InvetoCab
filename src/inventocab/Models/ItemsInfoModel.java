
package inventocab.Models;

import inventocab.Models.others.ItemImageModel;
import java.util.Date;
import javax.swing.ImageIcon;


public class ItemsInfoModel {

   
    public ImageIcon getIcon() {
        return icon;
    }

   
    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

  
    public int getCartQuantity() {
        return cartQuantity;
    }

  
    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
    }

    
    public Date getDateRequest() {
        return dateRequest;
    }

   
    public void setDateRequest(Date dateRequest) {
        this.dateRequest = dateRequest;
    }

    
    public Date getDateReceive() {
        return dateReceive;
    }

    
    public void setDateReceive(Date dateReceive) {
        this.dateReceive = dateReceive;
    }

    public ItemImageModel getImage() {
        return image;
    }

   
    public void setImage(ItemImageModel image) {
        this.image = image;
    }

    
    public String getItemID() {
        return itemID;
    }

  
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    
    public String getItemName() {
        return itemName;
    }

   
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    
    public String getCategory() {
        return category;
    }

   
    public void setCategory(String category) {
        this.category = category;
    }

   
    public String getItemLocation() {
        return itemLocation;
    }

  
    public void setItemLocation(String itemLocation) {
        this.itemLocation = itemLocation;
    }

    
    public int getQuantity() {
        return quantity;
    }

    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

   
    public String getDescription() {
        return description;
    }

   
    public void setDescription(String description) {
        this.description = description;
    }

    public ItemsInfoModel(String itemID, String itemName, String category, String itemLocation, int quantity, ItemImageModel image, String descriptiom, Date dateRequest, Date dateReceive) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.category = category;
        this.itemLocation = itemLocation;
        this.quantity = quantity;
        this.image = image;
        this.description = description;
        this.dateRequest = dateRequest;
        this.dateReceive = dateReceive;
    }

  
    

    public ItemsInfoModel() {
        
    }

     
    private String itemID;
    private String itemName;
    private String category;
    private String itemLocation;
    private int quantity;
    private ItemImageModel image;
   private String description;
   private Date dateRequest;
   private Date dateReceive;
   private ImageIcon icon;
  
   
   private int cartQuantity;

// public Object[] toTableRow(int rowNum) {
//        
//        
//        return new Object[]{false, rowNum, this ,itemID, category,itemLocation,quantity,image};
//    }
//
//    @Override
//    public String toString() {
//        return itemName;
//    }

}

