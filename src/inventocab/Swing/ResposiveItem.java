/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventocab.Swing;

import java.awt.Dimension;
import javax.swing.JPanel;
import raven.modal.demo.layout.ResponsiveLayout;

/**
 *
 * @author Calyle
 */
public class ResposiveItem extends JPanel{

    public ResposiveItem() {
        ResponsiveLayout layout = new ResponsiveLayout(ResponsiveLayout.JustifyContent.FIT_CONTENT, new Dimension(-1,-1));
        layout.setColumn(1);
       
        
        
        setLayout(layout);
    }
    
}
