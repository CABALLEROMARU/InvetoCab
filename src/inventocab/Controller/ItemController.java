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
import java.io.InputStream;
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

   private List<ItemsInfoModel> items = new ArrayList<>();


public List<ItemsInfoModel> getAll()throws SQLException {
        List<ItemsInfoModel>list = new ArrayList<>();
        String sql = "SELECT * FROM additem";
    try {
          ps = prepareStatement(sql); 
        rs = ps.executeQuery(); 
         while (rs.next()) {
           
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
            
           
            list.add(item);
        }
        
        return list;
        
    } catch (Exception e) {
          e.printStackTrace();
        throw e;
    }finally {
       
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
    } 
}
 public List<ItemsInfoModel> getItems() {
        return this.items;
    }
  public void updateItems(List<ItemsInfoModel> newItems) {
        this.items = newItems;
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
    
   
  public void addItem(ItemsInfoModel data) {
    try {
       
        if (data.getItemLocation() == null || data.getItemLocation().isEmpty()) {
            System.out.println("ItemLocation is null or empty, setting a default value.");
            data.setItemLocation("Default Location");
        }

       
        String sql = "INSERT INTO additem (Item_ID, ItemName, Category, ItemLocation, Quantity, ItemImage, Description, DateRequested, DateReceive) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        
        ps = prepareStatement(sql);

        
        ps.setString(1, data.getItemID());
        ps.setString(2, data.getItemName());
        ps.setString(3, data.getCategory());
        ps.setString(4, data.getItemLocation());
        ps.setInt(5, data.getQuantity());

         byte[] imageBytes = null; 
        if (data.getImage() != null) {
           
            File imageFile = data.getImage().getFile();
            
            if (imageFile != null && imageFile.exists()) {
                ps.setBytes(6, getByteImage(imageFile));
            } else {
                ps.setBytes(6, null);
                System.out.println("Image file does not exist: " + imageFile.getAbsolutePath());
            }
            
            if (imageBytes == null) {
            try {
                InputStream defaultImageStream = getClass().getResourceAsStream("/inventocab/Icons/defaultImage.png");
                if (defaultImageStream != null) {
                    imageBytes = defaultImageStream.readAllBytes();
                } else {
                    System.out.println("Default image not found in resources.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        } else {
             
            ps.setBytes(6, null);
        }

     
        ps.setString(7, data.getDescription());
        ps.setDate(8, (Date) data.getDateRequest());
        ps.setDate(9, (Date) data.getDateReceive());

       
        ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public void updateItem(ItemsInfoModel data) {
    try {
      
        String sql = "UPDATE additem SET ItemName=?, Category=?, ItemLocation=?, Quantity=?, ItemImage=?, Description=?, DateRequested=?, DateReceive=? WHERE Item_ID=?";
        
     
        ps = prepareStatement(sql);
        
       
        ps.setString(1, data.getItemName());
        ps.setString(2, data.getCategory());
        ps.setString(3, data.getItemLocation());
        ps.setInt(4, data.getQuantity());
        
       
        if (data.getImage() != null) {
            File imageFile = data.getImage().getFile();
            if (imageFile != null && imageFile.exists()) {
                ps.setBytes(5, getByteImage(imageFile)); 
            } else {
                
                System.out.println("Image file does not exist: " + (imageFile != null ? imageFile.getAbsolutePath() : "null"));
                ps.setBytes(5, null);
            }
        } else {
           
            String existingImageSql = "SELECT ItemImage FROM additem WHERE Item_ID=?";
            PreparedStatement existingImagePs = prepareStatement(existingImageSql);
            existingImagePs.setString(1, data.getItemID());
            ResultSet rs = existingImagePs.executeQuery();
            if (rs.next()) {
                Blob existingBlob = (Blob) rs.getBlob("ItemImage");
                if (existingBlob != null) {
                    ps.setBytes(5, existingBlob.getBytes(1, (int) existingBlob.length()));
                } else {
                    ps.setBytes(5, null);
                }
            }
            rs.close();
            existingImagePs.close();
        }

       
        ps.setString(6, data.getDescription());
        ps.setDate(7, (Date) data.getDateRequest());
        ps.setDate(8, (Date) data.getDateReceive());
        
       
        ps.setString(9, data.getItemID());

        
        ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
       
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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
        
        String sql = "DELETE FROM additem WHERE Item_ID=?";
        
       
        ps = prepareStatement(sql);
        
       
        ps.setString(1, itemId);

      
        int rowsAffected = ps.executeUpdate();
        
        if (rowsAffected > 0) {
            System.out.println("Item with ID " + itemId + " has been deleted successfully.");
        } else {
            System.out.println("No item found with ID " + itemId);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        
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
        
        String sql = "SELECT Item_ID, ItemName, Category, ItemLocation, Quantity, Description, DateRequested, DateReceive, ItemImage FROM additem WHERE (ItemName LIKE ? OR Category LIKE ? OR ItemLocation LIKE ?) AND DateDeleted IS NULL";
        
       
        ps = getConnection().prepareStatement(sql);
        String searchPattern = "%" + search + "%";
        ps.setString(1, searchPattern);  
        ps.setString(2, searchPattern);  
        ps.setString(3, searchPattern);  

       
        rs = ps.executeQuery();
        
      
        while (rs.next()) {
            
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
            
           
            itemsList.add(item);
        }
        return itemsList;
        
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
       
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
    }

    return itemsList; 
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


