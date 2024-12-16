
package inventocab.Models.reports;

import inventocab.Models.ItemsInfoModel;
import java.util.Date;
import java.util.List;


public class ParametersModel {

    /**
     * @return the Daterelease
     */
    public String getDaterelease() {
        return Daterelease;
    }

    /**
     * @param Daterelease the Daterelease to set
     */
    public void setDaterelease(String Daterelease) {
        this.Daterelease = Daterelease;
    }

    /**
     * @return the Daterelease
     */
   

    /**
     * @return the Status
     */
    public String getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(String Status) {
        this.Status = Status;
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

    public ParametersModel(String BorrowerId, String BorrowerName, String LenderName, String DateRequest, String DateReturn, String Daterelease, String Status, String ReturnStatus, String Remarks, List<BorrowerDetailsModel> field) {
        this.BorrowerId = BorrowerId;
        this.BorrowerName = BorrowerName;
        this.LenderName = LenderName;
        this.DateRequest = DateRequest;
        this.DateReturn = DateReturn;
        this.Daterelease = Daterelease;
        this.Status = Status;
        this.ReturnStatus = ReturnStatus;
        this.Remarks = Remarks;
        this.field = field;
    }

   

   
    
    
    
    private String BorrowerId;
    private String BorrowerName;
    private String LenderName;
    private String DateRequest;
    private String DateReturn;
    private String Daterelease;
    private String Status;
    private String ReturnStatus;
    private String Remarks;
    private List<BorrowerDetailsModel>field;
}
