
package inventocab.Models.reports;


public class BorrowerDetailsModel {

    
    public String getItemId() {
        return itemId;
    }

    
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    
    public String getCategory() {
        return category;
    }

    
    public void setCategory(String Category) {
        this.category = Category;
    }

    
   

   
    public String getItemName() {
        return itemName;
    }

    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    
    public String getQuantity() {
        return quantity;
    }

   
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

   
    

    public BorrowerDetailsModel() {
    }
    
    private String itemId;
    private String itemName;
    private String quantity;
   private String category;

    public BorrowerDetailsModel(String itemId, String itemName, String quantity,String Category) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.category = Category;
        
    }
   
    
}
