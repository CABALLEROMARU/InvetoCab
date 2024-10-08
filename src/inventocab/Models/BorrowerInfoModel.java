/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventocab.Models;

/**
 *
 * @author Calyle
 */
public class BorrowerInfoModel {

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

    public BorrowerInfoModel() {
    }

    public BorrowerInfoModel(String BorrowerName, String LenderName) {
        this.BorrowerName = BorrowerName;
        this.LenderName = LenderName;
    }
   
  private String BorrowerName;
    private String LenderName;
    

}
   
    

