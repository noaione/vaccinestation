package apu.oodj.vaccinestation.ModelRenderer;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class VaccineRequestRenderer extends JLabel implements TableCellRenderer {
    public VaccineRequestRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(
        JTable table, Object value, boolean isSelected,
        boolean hasFocus, int row, int column
    ) {
        if (column == 0) {
            String status = (String)value;
            if (status.equals("?")) {
                setBackground(Color.YELLOW);
            } else if (status.equals("✓")) {
                setBackground(Color.GREEN);
            } else {
                setBackground(Color.RED);
            }
        }
        return this;
    }
}
