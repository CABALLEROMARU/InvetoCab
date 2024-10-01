
package sample.table;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableCellRenderer;


public class CheckBoxTableHeaderRender extends JCheckBox implements TableCellRenderer {

    private final JTable table;
    private final int column;

    public CheckBoxTableHeaderRender(JTable table, int column) {
        this.table = table;
        this.column = column;
        init();
    }

    private void init() {
        putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$Table.background");
        setHorizontalAlignment(SwingConstants.CENTER);

        table.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    int col = table.columnAtPoint(me.getPoint());
                    if (col == column) {
                        putClientProperty(FlatClientProperties.SELECTED_STATE, null);
                        setSelected(!isSelected());
                        selectedTableRow(isSelected());
                    }
                }
            }
        });

        table.getModel().addTableModelListener((tme) -> {
            if (tme.getColumn() == column || tme.getType() == TableModelEvent.DELETE) {
                     checkRow();
            }
        });
    }
private void checkRow() {
    if (table.getRowCount() == 0) {
        return; // No rows, nothing to check
    }

    Boolean initValue = getBooleanValue(table.getValueAt(0, column));
    if (initValue == null) {
        putClientProperty(FlatClientProperties.SELECTED_STATE, FlatClientProperties.SELECTED_STATE_INDETERMINATE);
        setSelected(false);
        table.getTableHeader().repaint();
        return;
    }

    for (int i = 1; i < table.getRowCount(); i++) {
        Boolean value = getBooleanValue(table.getValueAt(i, column));
        if (value == null || !initValue.equals(value)) {
            putClientProperty(FlatClientProperties.SELECTED_STATE, FlatClientProperties.SELECTED_STATE_INDETERMINATE);
            table.getTableHeader().repaint();
            return;
        }
    }

    putClientProperty(FlatClientProperties.SELECTED_STATE, null);
    setSelected(initValue);
    table.getTableHeader().repaint();
}

private Boolean getBooleanValue(Object value) {
    return value instanceof Boolean ? (Boolean) value : null;
}

    private void selectedTableRow(boolean selected) {
        for (int i = 0; i < table.getRowCount(); i++) {
            table.setValueAt(selected, i, column);
        }
    }

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        return this;
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setColor(UIManager.getColor("TableHeader.bottomSeparatorColor"));
        float size = UIScale.scale(1f);
        g2.fill(new Rectangle2D.Float(0, getHeight() - size, getWidth(), size));
        g2.dispose();
        super.paintComponent(grphcs);
    }
}
