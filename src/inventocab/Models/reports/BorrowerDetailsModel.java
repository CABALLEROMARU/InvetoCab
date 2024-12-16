
package inventocab.Models.reports;


public class BorrowerDetailsModel {

    
   

    
   

   
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
    
   
    private String itemName;
    private String quantity;
  

    public BorrowerDetailsModel( String itemName, String quantity,String Category) {
       
        this.itemName = itemName;
        this.quantity = quantity;
       
        
    }
   
    
}
