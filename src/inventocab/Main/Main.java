
package inventocab.Main;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import inventocab.Components.Menu;
import inventocab.Event.Event;
import inventocab.Forms.BorrowLogs;

import inventocab.Forms.Form_3;
import inventocab.Forms.Item_Form;
import inventocab.Forms.PopItemForm;
import static inventocab.Main.Main.main;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import static java.awt.SystemColor.menu;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Main extends javax.swing.JFrame {

 private PopItemForm form;
 private Item_Form item_Form;
 private Form_3 form3;
 private BorrowLogs borrowlogs;
   
    public Main() throws SQLException, Exception {
        initComponents();
//         setSize(Toolkit.getDefaultToolkit().getScreenSize());

      
       form = new PopItemForm();
      /*  test = new test1();*/
         form3 = new Form_3();
         item_Form = new Item_Form();
         borrowlogs = new BorrowLogs();
     
      menu2.addEvent(new Event (){
            @Override
            public void selected(int index) {
                if(index == 0){
                    try {
                        setForm(new PopItemForm());
                    } catch (SQLException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else if (index == 1){
                   if (item_Form != null) {
                try {
                    item_Form.populateAddData(); // Assuming this method refreshes the data
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    setForm(item_Form);
                }else if (index == 2){
                     if (borrowlogs != null) {
                try {
                    borrowlogs.populateAddDataLogs(form, item_Form);// Assuming this method refreshes the data
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }        catch (Exception ex) {
                             Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                         }
            }
                    setForm(borrowlogs);
                }   else if (index == 3){
                    setForm(form3);
                }
                else if (index == 4){
                    int response = JOptionPane.showConfirmDialog(
        null, 
        "Are you sure you want to Log Out?", 
        "Exit Confirmation", 
        JOptionPane.YES_NO_OPTION, 
        JOptionPane.QUESTION_MESSAGE
                    );
                    if (response == JOptionPane.YES_OPTION) {
                        
                        
                        login log = new login();
                        log.setVisible(true);
                             Main.this.dispose();  
                        
}else{
                        
                    }
                
                }else if (index == 5){
                    
                    int response = JOptionPane.showConfirmDialog(
        null, 
        "Are you sure you want to exit?", 
        "Exit Confirmation", 
        JOptionPane.YES_NO_OPTION, 
        JOptionPane.QUESTION_MESSAGE
);

if (response == JOptionPane.YES_OPTION) {
    System.exit(0);
}
                }
            }
          
      });
        
        setForm(new PopItemForm());
        
    
//        
//         if (this.getExtendedState()==Main.MAXIMIZED_BOTH) {
//            this.setExtendedState(Main.NORMAL);
//        }
//        else{
//            this.setExtendedState(Main.MAXIMIZED_BOTH);
//        }
        
       
    
    }
    private void setForm(JComponent com) {
    mainPanel.removeAll();
    if (com != null) {
        mainPanel.add(com);
    }
    mainPanel.repaint();
    mainPanel.revalidate();
}
private void showFrame(JFrame frame) {
    frame.setVisible(true);
    this.dispose(); // Optionally dispose of the current frame if needed
}
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu1 = new inventocab.Components.Menu();
        panelboarder1 = new inventocab.Swing.Panelboarder();
        menu2 = new inventocab.Components.Menu();
        mainPanel = new javax.swing.JPanel();

        javax.swing.GroupLayout menu1Layout = new javax.swing.GroupLayout(menu1);
        menu1.setLayout(menu1Layout);
        menu1Layout.setHorizontalGroup(
            menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 179, Short.MAX_VALUE)
        );
        menu1Layout.setVerticalGroup(
            menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelboarder1.setBackground(new java.awt.Color(231, 231, 231));

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelboarder1Layout = new javax.swing.GroupLayout(panelboarder1);
        panelboarder1.setLayout(panelboarder1Layout);
        panelboarder1Layout.setHorizontalGroup(
            panelboarder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelboarder1Layout.createSequentialGroup()
                .addComponent(menu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE))
        );
        panelboarder1Layout.setVerticalGroup(
            panelboarder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu2, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelboarder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelboarder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("sample/Theme");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatIntelliJLaf.setup();
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Main().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    private inventocab.Components.Menu menu1;
    private inventocab.Components.Menu menu2;
    private inventocab.Swing.Panelboarder panelboarder1;
    // End of variables declaration//GEN-END:variables
}
