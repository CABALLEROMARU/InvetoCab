/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventocab.Models;

import java.util.Date;
import java.util.List;


public class BorrowerInfoModel {

    /**
     * @return the Remarks
     */
    public String getRemarks() {
        return Remarks;
    }

    /**
     * @param Remarks the Remarks to set
     */
    public void setRemarks(String Remarks) {
        this.Remarks = Remarks;
    }

    /**
     * @return the ReturnStatus
     */
    public String getReturnStatus() {
        return ReturnStatus;
    }

    /**
     * @param ReturnStatus the ReturnStatus to set
     */
    public void setReturnStatus(String ReturnStatus) {
        this.ReturnStatus = ReturnStatus;
    }

    /**
     * @return the DateRelease
     */
    public Date getDateRelease() {
        return daterelease;
    }

    /**
     * @param DateRelease the DateRelease to set
     */
    public void setDateRelease(Date DateRelease) {
        this.daterelease = DateRelease;
    }

    /**
     * @return the Status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(String Status) {
        this.status = Status;
    }

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

    public BorrowerInfoModel(String borrowerId, String borrowerName, String lenderName, Date dateRequest, Date dateRelease, String status, String returnStatus, String remarks, String allItemsID,  List<ItemsInfoModel> cartList) {
        this.BorrowerId = borrowerId;
        this.BorrowerName = borrowerName;
        this.LenderName = lenderName;
        this.DateRequest = dateRequest;
        this.daterelease = dateRelease;
        this.status = status;
        this.ReturnStatus = returnStatus;
        this.Remarks = remarks;
        this.AllItemsID = allItemsID;
        this.cartList = cartList;
    }

    

    

    

   
    private String BorrowerId;
    private String BorrowerName;
    private String LenderName;
    private Date DateRequest;
    private Date daterelease;
    private String status;
    private String AllItemsID;
    private Date DateReturn;
    private String ReturnStatus;
    private String Remarks;
    private List<ItemsInfoModel>cartList;
      

}
   
    

