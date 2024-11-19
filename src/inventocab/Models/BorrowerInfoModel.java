/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventocab.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class BorrowerInfoModel {

    /**
     * @return the DateReturn
     */
    public Date getDateReturn() {
        return DateReturn;
    }

    /**
     * @param DateReturn the DateReturn to set
     */
    public void setDateReturn(Date DateReturn) {
        this.DateReturn = DateReturn;
    }

    
    public String getAllItemsID() {
        return AllItemsID;
    }

   
    public void setAllItemsID(String AllItemsID) {
        this.AllItemsID = AllItemsID;
    }

  
   
public List<ItemsInfoModel> getCartList() {
      
        return cartList ;
    }
    

   
    

   
    public void setCartList(List<ItemsInfoModel> cartList) {
        this.cartList = cartList;
    }

    
    public String getBorrowerId() {
        return BorrowerId;
    }

    
    public void setBorrowerId(String borrowerId) {
        this.BorrowerId = borrowerId;
    }

    
    public Date getDateRequest() {
        return DateRequest;
    }

   
    public void setDateRequest(Date Request) {
        this.DateRequest = Request;
    }

   
    public String getBorrowerName() {
        return BorrowerName;
    }

 
    public void setBorrowerName(String BorrowerName) {
        this.BorrowerName = BorrowerName;
    }

    
    public String getLenderName() {
        return LenderName;
    }

    
    public void setLenderName(String LenderName) {
        this.LenderName = LenderName;
    }
public BorrowerInfoModel(){
    
}
    public BorrowerInfoModel(String BorrowerId, String BorrowerName, String LenderName, List<ItemsInfoModel> cartList,Date DateRequest, String AllItemsID) {
         this.BorrowerId = BorrowerId;
           this.BorrowerName = BorrowerName;
            this.LenderName = LenderName;
           this.cartList = cartList;
             this.DateRequest = DateRequest;
             this.AllItemsID = AllItemsID;
             
    }

   
   private String BorrowerId;
  private String BorrowerName;
    private String LenderName;
    private Date DateRequest;
    private String AllItemsID;
    private Date DateReturn;

      private List<ItemsInfoModel>cartList;
      

}
   
    

