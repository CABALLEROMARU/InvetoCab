
package inventocab.Models.reports;

import inventocab.Models.ItemsInfoModel;
import java.util.List;


public class ParametersModel {

    
    public List<BorrowerDetailsModel> getField() {
        return field;
    }

    
    public void setField(List<BorrowerDetailsModel> field) {
        this.field = field;
    }

  
    public String getLenderName() {
        return LenderName;
    }

    
    public void setLenderName(String LenderName) {
        this.LenderName = LenderName;
    }

   
    public String getBorrowerId() {
        return BorrowerId;
    }

   
    public void setBorrowerId(String BorrowerId) {
        this.BorrowerId = BorrowerId;
    }

   
    public String getBorrowerName() {
        return BorrowerName;
    }

    
    public void setBorrowerName(String BorrowerName) {
        this.BorrowerName = BorrowerName;
    }

   

    public String getDateRequest() {
        return DateRequest;
    }

   
    public void setDateRequest(String DateRequest) {
        this.DateRequest = DateRequest;
    }

   
    public String getDateReturn() {
        return DateReturn;
    }

    
    public void setDateReturn(String DateReturn) {
        this.DateReturn = DateReturn;
    }

    
   

    public ParametersModel() {
    }

    public ParametersModel(String BorrowerId, String BorrowerName, String LenderName, String DateRequest, String DateReturn, List<BorrowerDetailsModel> field) {
        this.BorrowerId = BorrowerId;
        this.BorrowerName = BorrowerName;
        this.LenderName = LenderName;
        this.DateRequest = DateRequest;
        this.DateReturn = DateReturn;
        this.field = field;
    }
    
    
    
    private String BorrowerId;
    private String BorrowerName;
    private String LenderName;
    private String DateRequest;
    private String DateReturn;
    
    private List<BorrowerDetailsModel>field;
}
