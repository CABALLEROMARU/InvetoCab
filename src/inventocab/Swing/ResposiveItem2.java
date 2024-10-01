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
public class ResposiveItem2 extends JPanel{

    public ResposiveItem2() {
        ResponsiveLayout layout = new ResponsiveLayout(ResponsiveLayout.JustifyContent.FIT_CONTENT, new Dimension(-1,-1));
        layout.setColumn(3);
        layout.setSize(new Dimension(180, 396));
        
        setLayout(layout);
    }
    
}
