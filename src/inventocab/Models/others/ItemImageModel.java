/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventocab.Models.others;

import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class ItemImageModel {

  
    public Icon getIcon() {
        return icon;
    }

    
    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    
    public File getFile() {
        return file;
    }

    
    public void setFile(File file) {
        this.file = file;
    }

    public ItemImageModel(File path) {
        this.file = path;
    }

    public ItemImageModel(byte [] bytes) {
        if(bytes != null){
            icon= new ImageIcon(bytes);
        }
    }

    public ItemImageModel(Icon icon) {
        this.icon= icon;
    }

    public ItemImageModel() {
    }

   
    
    
    private Icon icon;
    private File file;

    public String getImageFilePath() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
