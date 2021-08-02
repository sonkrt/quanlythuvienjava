/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Asus
 */
public class CustomHeaderTable extends JLabel implements TableCellRenderer{

    public CustomHeaderTable() {
        setFont(new Font("Calibri", Font.BOLD, 14));
        setOpaque(true);
        setForeground(Color.WHITE);
        setBackground(Color.red);
        setBorder(BorderFactory.createEtchedBorder());
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
         setText(value.toString());
         return this;
    }
    
}
