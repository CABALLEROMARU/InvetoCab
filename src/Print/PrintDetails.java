
package Print;

import inventocab.Models.reports.ParametersModel;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;


public class PrintDetails {
     private JasperReport reportInvoice;
      private static PrintDetails instance;
     
      public static PrintDetails getInstance() {
        if (instance == null) {
            instance = new PrintDetails();
        }
        return instance;
    }
     private PrintDetails() {
    }
     public void compileReport() throws JRException {
     
        reportInvoice = JasperCompileManager.compileReport(getClass().getResourceAsStream("/Print/PRINT.jrxml"));
    }
     

     
public void printReportInvoice(ParametersModel data) throws JRException {
    // Create parameters map
    Map<String, Object> para = new HashMap<>();
    para.put("BorrowerId", data.getBorrowerId());
    para.put("BorrowerName", data.getBorrowerName());
    para.put("LenderName", data.getLenderName());
    para.put("DateRequest", data.getDateRequest());
    para.put("DateReturn", data.getDateReturn());

    
    JRBeanCollectionDataSource itemDataSource = new JRBeanCollectionDataSource(data.getField());
   
  
    JasperPrint print = JasperFillManager.fillReport(reportInvoice, para, itemDataSource);
    view(print);
}
      private void view(JasperPrint print) throws JRException {
        JasperViewer.viewReport(print, false);
    }
}
