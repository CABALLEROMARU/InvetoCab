/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventocab.Controller;

import inventocab.Forms.Item_Form;
import inventocab.Forms.PopItemForm;
import inventocab.JDBC.DatabaseConnection;
import inventocab.Models.BorrowerInfoModel;
import inventocab.Models.ItemsInfoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class ReturnController {
    
    private PreparedStatement ps;
    private ResultSet rs;
     private PopItemForm popItemFormInstance; 
    private Item_Form itemform;

    public ReturnController() {
    }
    
    
     public ReturnController(PopItemForm popItemForm,Item_Form itemform) {
        this.popItemFormInstance = popItemForm;
        this.itemform = itemform;
       
    }
    public void retunBorrowQuantity(){
       
    
    }
    public void returnBorrow(BorrowerInfoModel data) {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
        conn = getConnection();
        if (conn == null) {
            System.out.println("Database connection failed.");
            return;
        }

        conn.setAutoCommit(false); 

        String sql = "UPDATE borrowerdata SET returnedDate = current_date() WHERE borrower_Id = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, data.getBorrowerId());
        ps.executeUpdate();
        updateBorrowedQuantity(data);
        conn.commit(); 
        System.out.println("Borrower return updated successfully.");
        
    } catch (Exception e) {
        if (conn != null) {
            try {
                conn.rollback();
                System.out.println("Transaction rolled back due to error.");
            } catch (Exception rollbackEx) {
                rollbackEx.printStackTrace();
            }
        }
        e.printStackTrace();
    } finally {
        
        try {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.setAutoCommit(true); 
                conn.close();
            }
        } catch (Exception closeEx) {
            closeEx.printStackTrace();
        }
    }
}
  public void updateBorrowedQuantity(BorrowerInfoModel data) {
    Connection conn = null; 
    PreparedStatement ps = null; 

    try {
        conn = getConnection();
        if (conn == null) {
            System.out.println("Database connection failed.");
            return;
        }
        
        conn.setAutoCommit(false); 

        String sql = "UPDATE additem SET quantity = quantity + ? WHERE item_ID = ?";
        ps = conn.prepareStatement(sql);

        List<ItemsInfoModel> cartList = data.getCartList();
        for (ItemsInfoModel item : cartList) {
            System.out.println("Updating Item ID: " + item.getItemID() + " with Quantity: " + item.getCartQuantity());
            ps.setInt(1, item.getQuantity());
            ps.setString(2, item.getItemID());
            ps.addBatch();
        }
        
        int[] results = ps.executeBatch();
        conn.commit(); 
        System.out.println("Batch update completed. Rows affected: " + Arrays.toString(results));

    } catch (Exception e) {
        e.printStackTrace();
        if (conn != null) {
            try {
                conn.rollback();
            } catch (Exception rollbackEx) {
                rollbackEx.printStackTrace();
            }
        }
    } finally {
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (Exception closeEx) {
            closeEx.printStackTrace();
        }
    }
}


     
     
     public void updateReturnDate(String borrowerId, Date returnDate) {
    Connection conn = null; 
    PreparedStatement ps = null; 
    try {
       
        conn = getConnection();
        if (conn == null) {
            System.out.println("Database connection failed.");
            return;
        }
        
       
        String sql = "UPDATE borrowerdata SET returnDate = ? WHERE borrower_Id = ?";
        ps = conn.prepareStatement(sql);
        
        
        ps.setDate(1, (java.sql.Date) returnDate);
        ps.setString(2, borrowerId);
        
       
        int rowsUpdated = ps.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Return date updated successfully for borrower ID: " + borrowerId);
        } else {
            System.out.println("No borrower found with ID: " + borrowerId);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
      
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
   public void updateItemQuantity(String itemId, int newQuantity) {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
        conn = getConnection();
        String sql = "UPDATE additem SET quantity = ? WHERE item_ID = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, newQuantity);
        ps.setString(2, itemId);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
   
     private Connection getConnection() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        try {
            return databaseConnection.getConnection(); 
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
