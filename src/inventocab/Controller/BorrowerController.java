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
import inventocab.Models.ReturnInfoModel;
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
        this.itemform = itemform;// Initialize the reference
       
    }
  public List<BorrowerInfoModel> getBorrowedItems() throws SQLException {
    List<BorrowerInfoModel> list = new ArrayList<>();
    String sql = "SELECT DISTINCT borrower_Id, borrowerName, allItemsID, itemID, itemName, quantity, category "
               + "FROM borrowerdata "
               + "WHERE quantity > 0"; // Only get items that are borrowed

    try {
        ps = getConnection().prepareStatement(sql);
        rs = ps.executeQuery();

        Map<String, BorrowerInfoModel> borrowerMap = new HashMap<>();

        while (rs.next()) {
            String borrowerId = rs.getString("borrower_Id");
            BorrowerInfoModel borrower = borrowerMap.get(borrowerId);

            // If borrower is not already in the map, create a new one
            if (borrower == null) {
                borrower = new BorrowerInfoModel();
                borrower.setBorrowerId(borrowerId);
                borrower.setBorrowerName(rs.getString("borrowerName"));
                borrower.setAllItemsID(rs.getString("allitemsid"));
                borrower.setCartList(new ArrayList<ItemsInfoModel>());
                borrowerMap.put(borrowerId, borrower); // Store borrower in the map
            }

            // Create an ItemsInfoModel for each item associated with the borrower
            ItemsInfoModel item = new ItemsInfoModel();
            item.setItemID(rs.getString("itemID"));
            item.setItemName(rs.getString("itemName"));
            item.setCartQuantity(rs.getInt("quantity"));
            item.setCategory(rs.getString("category"));

            // Add the item to the borrower's cartList
            borrower.getCartList().add(item);
            
            
        }

        list.addAll(borrowerMap.values()); // Add all borrowers to the list
    } catch (SQLException e) {
        e.printStackTrace();
        throw e; // Rethrow the exception for handling in the calling method
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
//    public List<BorrowerInfoModel> getAllData() throws SQLException {
//    List<BorrowerInfoModel> list = new ArrayList<>();
//    String sql = "SELECT borrower_Id,borrowerName, lendererName, borrowDate,itemID, itemName, quantity, category "     
//                 + "FROM borrowerdata "; 
//
//    try {
//        ps = getConnection().prepareStatement(sql);
//        rs = ps.executeQuery();
//
//        // Use a Map to track existing borrowers
//      
//
//        while (rs.next()) {
//             BorrowerInfoModel borrower = new BorrowerInfoModel();
//            String borrowerId = rs.getString("borrower_Id");
// Map<String, BorrowerInfoModel> borrowerMap = new HashMap<>(); // To track existing borrowers
//            // Check if the borrower already exists in the map
//           
//            if (borrowerMap.containsKey(borrowerId)) {
//                borrower = borrowerMap.get(borrowerId); // Get existing borrower
//            } else{
//                // Create a new BorrowerInfoModel for each unique borrower
//              
//                borrower.setBorrowerId(borrowerId);
//                borrower.setBorrowerName(rs.getString("borrowerName"));
//                borrower.setLenderName(rs.getString("lendererName"));
//                borrower.setDateRequest(rs.getDate("borrowDate"));
//
//                // Initialize the cartList
//                borrower.setCartList(new ArrayList<ItemsInfoModel>());
//
//                // Add the borrower to the list and the map
//                list.add(borrower);
//                borrowerMap.put(borrowerId, borrower); 
//            }
//
//            // Only create and add items if they are not null
//            String itemId = rs.getString("itemID");
//            if (itemId != null) { // Check if itemID is not null
//                ItemsInfoModel item = new ItemsInfoModel();
//                item.setItemID(itemId);
//                item.setItemName(rs.getString("itemName"));
//                item.setCartQuantity(rs.getInt("quantity"));
//                item.setCategory(rs.getString("category"));
//                
//
//                // Add the item to the borrower's cartList
//                borrower.getCartList().add(item);
//            }
//        }
//
//    } catch (SQLException e) {
//        e.printStackTrace();
//        throw e; // Rethrow the exception for handling in the calling method
//    } finally {
//        if (rs != null) {
//            rs.close();
//        }
//        if (ps != null) {
//            ps.close();
//        }
//    }
//
//    return list;
//}


public List<BorrowerInfoModel> getBorrower() throws SQLException {
    List<BorrowerInfoModel> list = new ArrayList<>();
    String sql = """
        SELECT DISTINCT borrower_Id, borrowerName, lendererName, borrowDate 
        FROM borrowerdata
    """;

    String itemSql = """
        SELECT itemID, itemName, quantity, category 
        FROM borrowerdata 
        WHERE borrower_Id = ?
    """;

    try {
        // Prepare the main borrower statement
        ps = getConnection().prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            String borrowerId = rs.getString("borrower_Id");

            // Fetch items associated with this borrower
            PreparedStatement itemPs = getConnection().prepareStatement(itemSql);
            itemPs.setString(1, borrowerId);
            ResultSet itemRs = itemPs.executeQuery();

            List<ItemsInfoModel> cart = new ArrayList<>();
            while (itemRs.next()) {
                ItemsInfoModel cartItem = new ItemsInfoModel();
                
                cartItem.setItemName(itemRs.getString("itemName"));
                cartItem.setQuantity(itemRs.getInt("quantity"));
                cartItem.setCategory(itemRs.getString("category"));
                cart.add(cartItem);
            }
            itemRs.close();
            itemPs.close();

            // Create a new BorrowerInfoModel
            BorrowerInfoModel borrower = new BorrowerInfoModel();
            borrower.setBorrowerId(borrowerId);
            borrower.setBorrowerName(rs.getString("borrowerName"));
            borrower.setLenderName(rs.getString("lendererName"));
            borrower.setDateRequest(rs.getDate("borrowDate")); // Assuming this is a Date field
            borrower.setCartList(cart);

            list.add(borrower);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw e; // Rethrow the exception for handling in the calling method
    } finally {
        // Close the ResultSet and PreparedStatement
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
            throw e; // Rethrow the exception for handling in the calling method
        }

        return count;
    }

public void addBorrow(List<BorrowerInfoModel> borrowedData) {
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
        String sql = "INSERT INTO borrowerdata (borrower_Id, borrowerName, lendererName, borrowDate, allItemsID, itemId, itemName, quantity,category) VALUES (?, ?, ?, ?, ?, ?, ?,?,?)";
        ps = conn.prepareStatement(sql);
        
        List<ItemsInfoModel> updatedItems = new ArrayList<>(); // List to keep track of updated items
        
        for (BorrowerInfoModel itemLoan : borrowedData) {
            // Set common parameters for the borrower
            ps.setString(1, itemLoan.getBorrowerId());
            ps.setString(2, itemLoan.getBorrowerName());
            ps.setString(3, itemLoan.getLenderName());
            ps.setDate(4, new java.sql.Date(itemLoan.getDateRequest().getTime()));
            ps.setString(5, itemLoan.getAllItemsID());// Correctly cast Date
            
            for (ItemsInfoModel itemData : itemLoan.getCartList()) {
                // Set parameters for each item
                ps.setString(6, itemData.getItemID());
                ps.setString(7, itemData.getItemName());
                ps.setInt(8, itemData.getCartQuantity());
                ps.setString(9,itemData.getCategory());
                
                // Add to batch
                ps.addBatch();
                
                // Update item quantity
                int newQuantity = itemData.getQuantity() - itemData.getCartQuantity(); // Calculate new quantity
                updateItemQuantity(conn, itemData.getItemID(), newQuantity); // Pass connection
                popItemFormInstance.refreshItemUI(itemData.getItemID());
                
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



public List<BorrowerInfoModel> searchBorrowedItems(String search) throws SQLException {
    List<BorrowerInfoModel> borrowedItemsList = new ArrayList<>();
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conn = null;

    try {
        // Get the database connection
        conn = getConnection();
        if (conn == null) {
            System.out.println("Database connection failed.");
            return borrowedItemsList;
        }

        // SQL query to search borrowed items by borrowerName, lenderName, or itemName
        String sql = "SELECT borrower_Id, borrowerName, lendererName, borrowDate FROM borrowerdata WHERE (borrowerName LIKE ? OR lendererName LIKE ?  OR itemName LIKE ?)";

        // Prepare the SQL statement
        ps = conn.prepareStatement(sql);
        String searchPattern = "%" + search + "%";
        ps.setString(1, searchPattern);  // Search by borrowerName
        ps.setString(2, searchPattern);  // Search by lendererName
        ps.setString(3, searchPattern);

        // Execute the query
        rs = ps.executeQuery();

        // Iterate through the result set
        while (rs.next()) {
            // Create a new BorrowerInfoModel object and populate it with data from the database
            BorrowerInfoModel borrowerInfo = new BorrowerInfoModel();
            borrowerInfo.setBorrowerId(rs.getString("borrower_Id"));
            borrowerInfo.setBorrowerName(rs.getString("borrowerName"));
            borrowerInfo.setLenderName(rs.getString("lendererName"));
            borrowerInfo.setDateRequest(rs.getDate("borrowDate"));
           

            // Add the borrower info to the list
            borrowedItemsList.add(borrowerInfo);
        }
        return borrowedItemsList;

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Close the ResultSet and PreparedStatement
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

    return borrowedItemsList;  // Return the list of borrowed items
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
           


