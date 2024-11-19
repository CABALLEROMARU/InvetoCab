/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventocab.Controller;

import inventocab.Forms.Item_Form;
import java.sql.Connection; // Correct import for SQL Connection
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import inventocab.Forms.PopItemForm;
import inventocab.Items.ItemLogsPop;
import inventocab.JDBC.DatabaseConnection;
import inventocab.Models.BorrowerInfoModel;
import inventocab.Models.ItemsInfoModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BorrowerController {
    private PreparedStatement ps;
    private ResultSet rs;
    private PopItemForm popItemFormInstance; 
    private Item_Form itemform;


    public BorrowerController(PopItemForm popItemForm,Item_Form itemform) {
        this.popItemFormInstance = popItemForm;
        this.itemform = itemform;
       
    }
  public List<BorrowerInfoModel> getBorrowedItems() throws SQLException {
    List<BorrowerInfoModel> list = new ArrayList<>();
    String sql = "SELECT DISTINCT borrower_Id, borrowerName, allItemsID, itemID, itemName, quantity, category "
               + "FROM borrowerdata "
               + "WHERE quantity > 0"; 

    try {
        ps = getConnection().prepareStatement(sql);
        rs = ps.executeQuery();

        Map<String, BorrowerInfoModel> borrowerMap = new HashMap<>();

        while (rs.next()) {
            String borrowerId = rs.getString("borrower_Id");
            BorrowerInfoModel borrower = borrowerMap.get(borrowerId);

          
            if (borrower == null) {
                borrower = new BorrowerInfoModel();
                borrower.setBorrowerId(borrowerId);
                borrower.setBorrowerName(rs.getString("borrowerName"));
                borrower.setAllItemsID(rs.getString("allitemsid"));
                borrower.setCartList(new ArrayList<ItemsInfoModel>());
                borrowerMap.put(borrowerId, borrower);
            }

           
            ItemsInfoModel item = new ItemsInfoModel();
            item.setItemID(rs.getString("itemID"));
            item.setItemName(rs.getString("itemName"));
            item.setCartQuantity(rs.getInt("quantity"));
            item.setCategory(rs.getString("category"));

            
            borrower.getCartList().add(item);
            
            
        }

        list.addAll(borrowerMap.values()); 
    } catch (SQLException e) {
        e.printStackTrace();
        throw e; 
    } finally {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
    }

    return list;
}



public List<BorrowerInfoModel> getBorrower() throws SQLException {
    List<BorrowerInfoModel> list = new ArrayList<>();
    String sql = """
        SELECT DISTINCT borrower_Id, borrowerName, lendererName, borrowDate ,returnedDate
        FROM borrowerdata
    """;

    String itemSql = """
        SELECT itemID, itemName, quantity, category 
        FROM borrowerdata 
        WHERE borrower_Id = ?
    """;

    try {
       
        ps = getConnection().prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            String borrowerId = rs.getString("borrower_Id");

            
            PreparedStatement itemPs = getConnection().prepareStatement(itemSql);
            itemPs.setString(1, borrowerId);
            ResultSet itemRs = itemPs.executeQuery();

            List<ItemsInfoModel> cart = new ArrayList<>();
            while (itemRs.next()) {
                ItemsInfoModel cartItem = new ItemsInfoModel();
                cartItem.setItemID(itemRs.getString("itemID"));
                cartItem.setItemName(itemRs.getString("itemName"));
                cartItem.setQuantity(itemRs.getInt("quantity"));
                cartItem.setCategory(itemRs.getString("category"));
                cart.add(cartItem);
            }
            itemRs.close();
            itemPs.close();

            
            BorrowerInfoModel borrower = new BorrowerInfoModel();
            borrower.setBorrowerId(borrowerId);
            borrower.setBorrowerName(rs.getString("borrowerName"));
            borrower.setLenderName(rs.getString("lendererName"));
            borrower.setDateRequest(rs.getDate("borrowDate")); 
            borrower.setDateReturn(rs.getDate("returnedDate"));
            borrower.setCartList(cart);

            list.add(borrower);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw e;
    } finally {
       
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
    }

    return list;
}


public int countBorrowerId(String borrowerId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM borrowerdata WHERE borrower_Id = ?";
        int count = 0;

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, borrowerId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; 
        }

        return count;
    }

public void addBorrow(List<BorrowerInfoModel> borrowedData) {
    Connection conn = null;
    try {
      
        conn = getConnection();
        if (conn == null) {
            System.out.println("Database connection failed.");
            return;
        }
        
       
        conn.setAutoCommit(false);
        
        
        String sql = "INSERT INTO borrowerdata (borrower_Id, borrowerName, lendererName, borrowDate, allItemsID, itemId, itemName, quantity,category) VALUES (?, ?, ?, ?, ?, ?, ?,?,?)";
        ps = conn.prepareStatement(sql);
        
        List<ItemsInfoModel> updatedItems = new ArrayList<>(); 
        
        for (BorrowerInfoModel itemLoan : borrowedData) {
            
            ps.setString(1, itemLoan.getBorrowerId());
            ps.setString(2, itemLoan.getBorrowerName());
            ps.setString(3, itemLoan.getLenderName());
            ps.setDate(4, new java.sql.Date(itemLoan.getDateRequest().getTime()));
            ps.setString(5, itemLoan.getAllItemsID());
            
            for (ItemsInfoModel itemData : itemLoan.getCartList()) {
                
                ps.setString(6, itemData.getItemID());
                ps.setString(7, itemData.getItemName());
                ps.setInt(8, itemData.getCartQuantity());
                ps.setString(9,itemData.getCategory());
                
                
                ps.addBatch();
                
                
                int newQuantity = itemData.getQuantity() - itemData.getCartQuantity(); 
                updateItemQuantity(conn, itemData.getItemID(), newQuantity); 
                popItemFormInstance.refreshItemUI(itemData.getItemID());
                
                updatedItems.add(itemData);
            }
        }
        
       
        int[] result = ps.executeBatch();
        conn.commit(); 
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
       
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



public List<BorrowerInfoModel> searchBorrowedItems(String search) throws SQLException {
    List<BorrowerInfoModel> borrowedItemsList = new ArrayList<>();
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conn = null;

    try {
       
        conn = getConnection();
        if (conn == null) {
            System.out.println("Database connection failed.");
            return borrowedItemsList;
        }

        
        String sql = "SELECT borrower_Id, borrowerName, lendererName, borrowDate FROM borrowerdata WHERE (borrowerName LIKE ? OR lendererName LIKE ?  OR itemName LIKE ?)";

       
        ps = conn.prepareStatement(sql);
        String searchPattern = "%" + search + "%";
        ps.setString(1, searchPattern); 
        ps.setString(2, searchPattern); 
        ps.setString(3, searchPattern);

       
        rs = ps.executeQuery();

        
        while (rs.next()) {
            
            BorrowerInfoModel borrowerInfo = new BorrowerInfoModel();
            borrowerInfo.setBorrowerId(rs.getString("borrower_Id"));
            borrowerInfo.setBorrowerName(rs.getString("borrowerName"));
            borrowerInfo.setLenderName(rs.getString("lendererName"));
            borrowerInfo.setDateRequest(rs.getDate("borrowDate"));
           

           
            borrowedItemsList.add(borrowerInfo);
        }
        return borrowedItemsList;

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    return borrowedItemsList;  
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
           


