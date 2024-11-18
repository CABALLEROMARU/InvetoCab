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
import inventocab.Models.ReturnInfoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        this.itemform = itemform;// Initialize the reference
       
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

        conn.setAutoCommit(false); // Begin transaction

        String sql = "UPDATE borrowerdata SET returnedDate = current_date() WHERE borrower_Id = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, data.getBorrowerId());
        ps.executeUpdate();

        conn.commit(); // Commit transaction
        System.out.println("Borrower return updated successfully.");
        
    } catch (Exception e) {
        if (conn != null) {
            try {
                conn.rollback(); // Rollback transaction on error
                System.out.println("Transaction rolled back due to error.");
            } catch (Exception rollbackEx) {
                rollbackEx.printStackTrace();
            }
        }
        e.printStackTrace();
    } finally {
        // Close resources
        try {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.setAutoCommit(true); // Reset auto-commit
                conn.close();
            }
        } catch (Exception closeEx) {
            closeEx.printStackTrace();
        }
    }
}

       private void updateItemQuantity(Connection conn, String itemId, int newQuantity) { 
        String sql = "UPDATE additem SET quantity = ? WHERE item_ID = ?";
        try (PreparedStatement updatePs = conn.prepareStatement(sql)) {
            updatePs.setInt(1, newQuantity);
            updatePs.setString(2, itemId);
            updatePs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
     public void updateReturnDate(String borrowerId, Date returnDate) {
    Connection conn = null; // Declare the connection variable
    PreparedStatement ps = null; // Declare the PreparedStatement
    try {
        // Get the connection
        conn = getConnection();
        if (conn == null) {
            System.out.println("Database connection failed.");
            return;
        }
        
        // SQL UPDATE statement for borrower data
        String sql = "UPDATE borrowerdata SET returnDate = ? WHERE borrower_Id = ?";
        ps = conn.prepareStatement(sql);
        
        // Set parameters
        ps.setDate(1, (java.sql.Date) returnDate);
        ps.setString(2, borrowerId);
        
        // Execute the update
        int rowsUpdated = ps.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Return date updated successfully for borrower ID: " + borrowerId);
        } else {
            System.out.println("No borrower found with ID: " + borrowerId);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Close resources
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    public void addBorrow(List<ReturnInfoModel> borrowedData) {
    Connection conn = null; // Declare the connection variable
    try {
        // Get the connection
        conn = getConnection();
        if (conn == null) {
            System.out.println("Database connection failed.");
            return;
        }
        
        // Disable auto-commit
        conn.setAutoCommit(false);
        
        // SQL INSERT statement for borrower data
        String sql = "INSERT INTO returnitemsdata (borrower_Id, borrowerName, lendererName, borrowDate,borrowReturn, allItemsID, itemId, itemName, quantity,category) VALUES (?, ?, ?, ?, ?, ?, ?,?,?)";
        ps = conn.prepareStatement(sql);
        
        List<ItemsInfoModel> updatedItems = new ArrayList<>(); // List to keep track of updated items
        
        for (ReturnInfoModel itemLoan : borrowedData) {
            // Set common parameters for the borrower
            ps.setString(1, itemLoan.getBorrowerId());
            ps.setString(2, itemLoan.getBorrowerName());
            ps.setString(3, itemLoan.getLenderName());
            ps.setDate(4, new java.sql.Date(itemLoan.getDateRequest().getTime()));
            ps.setDate(5,new java.sql.Date(itemLoan.getDateReturn().getTime()));
            
            
            for (ItemsInfoModel itemData : itemLoan.getCartList()) {
                // Set parameters for each item
                ps.setString(6, itemData.getItemID());
                ps.setString(7, itemData.getItemName());
                ps.setInt(8, itemData.getCartQuantity());
                ps.setString(9,itemData.getCategory());
                
                // Add to batch
                ps.addBatch();
                
                // Update item quantity
//                int newQuantity = itemData.getQuantity() - itemData.getCartQuantity(); // Calculate new quantity
//                updateItemQuantity(conn, itemData.getItemID(), newQuantity); // Pass connection
//                popItemFormInstance.refreshItemUI(itemData.getItemID());
                
                updatedItems.add(itemData);
            }
        }
        
        // Execute batch
        int[] result = ps.executeBatch();
        conn.commit(); // Commit the transaction
        System.out.println("Inserted " + result.length + " records successfully.");
        if (itemform != null) {
            itemform.refreshItemQuantities(updatedItems);
        }
        borrowedData.clear();
    } catch (SQLException e) {
        if (conn != null) {
            try {
                conn.rollback(); 
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        }
        e.printStackTrace();
    } finally {
        // Close resources
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
