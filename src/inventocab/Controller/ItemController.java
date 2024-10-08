/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventocab.Controller;




import com.mysql.cj.jdbc.Blob;
import inventocab.JDBC.DatabaseConnection;
import inventocab.Model.Model_Menu;
import inventocab.Models.ItemsInfoModel;
import inventocab.Models.others.ItemImageModel;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import static java.nio.file.Files.list;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import net.coobird.thumbnailator.Thumbnails;



public class ItemController {
private PreparedStatement ps;
private ResultSet rs;


public List<ItemsInfoModel> getAll()throws SQLException {
        List<ItemsInfoModel>list = new ArrayList<>();
        String sql = "SELECT * FROM additem";
    try {
          ps = prepareStatement(sql); 
        rs = ps.executeQuery(); 
         while (rs.next()) {
            // Create a new ItemsInfoModel for each record in the result set
            ItemsInfoModel item = new ItemsInfoModel();
            item.setItemID(rs.getString("Item_ID"));
            item.setItemName(rs.getString("ItemName"));
            item.setCategory(rs.getString("Category"));
            item.setItemLocation(rs.getString("ItemLocation"));
            item.setQuantity(rs.getInt("Quantity"));
            item.setDateReceive(rs.getDate("DateReceive"));
            item.setDateRequest(rs.getDate("DateRequested"));
            
             Blob blob = (Blob)rs.getBlob("ItemImage");
              ImageIcon icon = null;
            if (blob != null) {
                byte[] imageBytes = blob.getBytes(1, (int) blob.length());
                icon = new ImageIcon(imageBytes);
            }else{
                icon = new ImageIcon(getClass().getResource("/inventocab/Icons/defaultImage.png"));
            }
            ItemImageModel imageModel = new ItemImageModel();
            imageModel.setIcon(icon);
            item.setImage(imageModel);
            
            item.setDescription(rs.getString("Description"));
            
            // Add the item to the list
            list.add(item);
        }
        
        return list;
        
    } catch (Exception e) {
          e.printStackTrace();
        throw e;
    }finally {
        // Close the ResultSet and PreparedStatement
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
    } 
}
  private byte[] getByteImages(File file) throws IOException {
        BufferedImage image = Thumbnails.of(file)
                .width(500)
                .outputQuality(0.7f)
                .asBufferedImage();
        ByteArrayOutputStream out = null;
        try {
            out = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", out);
            byte[] data = out.toByteArray();
            return data;
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
    
    public ItemController() {
        
    }
    
    
    public void addItem(ItemsInfoModel data){
        try {
            String sql = "Insert Into additem (Item_ID,ItemName,Category,ItemLocation,Quantity,ItemImage,Description,DateRequested,DateReceive)VALUES(?,?,?,?,?,?,?,?,?)";
            
            
            ps = prepareStatement(sql);
            ps.setString(1,data.getItemID() );
            ps.setString(2,data.getItemName() );
            ps.setString(3,data.getCategory() );
            ps.setString(4,data.getItemLocation() );
            ps.setInt(5,data.getQuantity() );
            if (data.getImage() != null) {
    File imageFile = data.getImage().getFile();
    if (imageFile != null && imageFile.exists()) {
        ps.setBytes(6, getByteImage(imageFile));
    } else {
        ps.setBytes(6, null);
        System.out.println("Image file does not exist: " + imageFile.getAbsolutePath());
    }
} else {
    ps.setBytes(6, null);
}
            ps.setString(7,data.getDescription());
            ps.setDate(8, (Date) data.getDateRequest());
            ps.setDate(9, (Date) data.getDateReceive());
                 ps.executeUpdate();
                 
        } catch (Exception e) {
        e.printStackTrace();
        }
    }
    
    public void updateItem(ItemsInfoModel data) {
    try {
        // Create the SQL UPDATE statement
        String sql = "UPDATE additem SET ItemName=?, Category=?, ItemLocation=?, Quantity=?, ItemImage=?, Description=?, DateRequested=?, DateReceive=? WHERE Item_ID=?";
        
        // Prepare the statement
        ps = prepareStatement(sql);
        
        // Set the new values
        ps.setString(1, data.getItemName());
        ps.setString(2, data.getCategory());
        ps.setString(3, data.getItemLocation());
        ps.setInt(4, data.getQuantity());
        
        // Handle image update
        if (data.getImage() != null) {
            File imageFile = data.getImage().getFile();
            if (imageFile != null && imageFile.exists()) {
                ps.setBytes(5, getByteImage(imageFile));  // Set image bytes
            } else {
                ps.setBytes(5, null);
                System.out.println("Image file does not exist: " + imageFile.getAbsolutePath());
            }
        } else {
            ps.setBytes(5, null);  // No image update
        }

        // Set remaining fields
        ps.setString(6, data.getDescription());
        ps.setDate(7, (Date) data.getDateRequest());
        ps.setDate(8, (Date) data.getDateReceive());
        
        // Set the condition for which item to update using the item ID
        ps.setString(9, data.getItemID());

        // Execute the update
        ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
     private Connection getConnection() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        try {
            return  databaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
     public void deleteItem(String itemId) {
    try {
        // Create the SQL DELETE statement
        String sql = "DELETE FROM additem WHERE Item_ID=?";
        
        // Prepare the statement
        ps = prepareStatement(sql);
        
        // Set the condition for which item to delete using the item ID
        ps.setString(1, itemId);

        // Execute the delete
        int rowsAffected = ps.executeUpdate();
        
        if (rowsAffected > 0) {
            System.out.println("Item with ID " + itemId + " has been deleted successfully.");
        } else {
            System.out.println("No item found with ID " + itemId);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Close the PreparedStatement and any other resources if necessary
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
   public List<ItemsInfoModel> searchItems(String search) throws SQLException {
    List<ItemsInfoModel> itemsList = new ArrayList<>();
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        // SQL query to search items by ItemName, Category, or ItemLocation including Blob image
        String sql = "SELECT Item_ID, ItemName, Category, ItemLocation, Quantity, Description, DateRequested, DateReceive, ItemImage FROM additem WHERE (ItemName LIKE ? OR Category LIKE ? OR ItemLocation LIKE ?) AND DateDeleted IS NULL";
        
        // Prepare the SQL statement
        ps = getConnection().prepareStatement(sql);
        String searchPattern = "%" + search + "%";
        ps.setString(1, searchPattern);  // Search by ItemName
        ps.setString(2, searchPattern);  // Search by Category
        ps.setString(3, searchPattern);  // Search by ItemLocation

        // Execute the query
        rs = ps.executeQuery();
        
        // Iterate through the result set
        while (rs.next()) {
            // Create a new ItemsInfoModel object and populate it with data from the database
            ItemsInfoModel item = new ItemsInfoModel();
            item.setItemID(rs.getString("Item_ID"));
            item.setItemName(rs.getString("ItemName"));
            item.setCategory(rs.getString("Category"));
            item.setItemLocation(rs.getString("ItemLocation"));
            item.setQuantity(rs.getInt("Quantity"));
            item.setDescription(rs.getString("Description"));
            item.setDateRequest(rs.getDate("DateRequested"));
            item.setDateReceive(rs.getDate("DateReceive"));

           Blob blob = (Blob)rs.getBlob("ItemImage");
              ImageIcon icon = null;
            if (blob != null) {
                byte[] imageBytes = blob.getBytes(1, (int) blob.length());
                icon = new ImageIcon(imageBytes);
            }else{
                icon = new ImageIcon(getClass().getResource("/inventocab/Icons/defaultImage.png"));
            }
            ItemImageModel imageModel = new ItemImageModel();
            imageModel.setIcon(icon);
            item.setImage(imageModel);
            
            item.setDescription(rs.getString("Description"));
            
            // Add the item to the list
            itemsList.add(item);
        }
        return itemsList;
        
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
    }

    return itemsList;  // Return the list of items
}
    private PreparedStatement prepareStatement(String sql) {
        try {
            Connection con = getConnection();
            if (con != null) {
                return con.prepareStatement(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
  private byte[] getByteImage(File file) throws IOException {
   
    String fileName = file.getName();
    String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();

    BufferedImage image = Thumbnails.of(file)
            .width(1000)
            .outputQuality(0.7f)
            .asBufferedImage();

    ByteArrayOutputStream out = null;
    try {
        out = new ByteArrayOutputStream();
        
       
        if ("png".equals(fileExtension)) {
            ImageIO.write(image, "png", out);
        } else {
            
            ImageIO.write(image, "jpg", out);
        }
        
        byte[] data = out.toByteArray();
        System.out.println("Image byte array length: " + data.length);
        return data;
    } finally {
        if (out != null) {
            out.close();
        }
    }
}

    public void updateItem(int itemId, ItemsInfoModel data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


