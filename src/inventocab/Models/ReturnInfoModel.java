/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventocab.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Calyle
 */
public class ReturnInfoModel {

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

    /**
     * @return the AllItemsID
     */
   

    /**
     * @return the DateReturn
     */
   
public List<ItemsInfoModel> getCartList() {
        // Ensure that cartList is never null; return an empty list if it is
        return cartList ;
    }
    

    /**
     * @return the cartList
     */
    

    /**
     * @param cartList the cartList to set
     */
    public void setCartList(List<ItemsInfoModel> cartList) {
        this.cartList = cartList;
    }

    /**
     * @return the borrowerId
     */
    public String getBorrowerId() {
        return BorrowerId;
    }

    /**
     * @param borrowerId the borrowerId to set
     */
    public void setBorrowerId(String borrowerId) {
        this.BorrowerId = borrowerId;
    }

    /**
     * @return the Request
     */
    public Date getDateRequest() {
        return DateRequest;
    }

    /**
     * @param Request the Request to set
     */
    public void setDateRequest(Date Request) {
        this.DateRequest = Request;
    }

    /**
     * @return the BorrowerName
     */
    public String getBorrowerName() {
        return BorrowerName;
    }

    /**
     * @param BorrowerName the BorrowerName to set
     */
    public void setBorrowerName(String BorrowerName) {
        this.BorrowerName = BorrowerName;
    }

    /**
     * @return the LenderName
     */
    public String getLenderName() {
        return LenderName;
    }

    /**
     * @param LenderName the LenderName to set
     */
    public void setLenderName(String LenderName) {
        this.LenderName = LenderName;
    }
public ReturnInfoModel(){
    
}
    public ReturnInfoModel(String BorrowerId, String BorrowerName, String LenderName, List<ItemsInfoModel> cartList,Date DateRequest, Date DateReturn) {
         this.BorrowerId = BorrowerId;
           this.BorrowerName = BorrowerName;
            this.LenderName = LenderName;
           this.cartList = cartList;
             this.DateRequest = DateRequest;
            
             this.DateReturn = DateReturn;
             
    }

   
   private String BorrowerId;
  private String BorrowerName;
    private String LenderName;
    private Date DateRequest;
   
    private Date DateReturn;
      private List<ItemsInfoModel>cartList = new ArrayList <>();
      

}
   
    

