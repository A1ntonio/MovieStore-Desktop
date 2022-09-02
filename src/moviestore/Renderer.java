
package moviestore;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;


public class Renderer extends DefaultListCellRenderer implements ListCellRenderer<Object> {
   @Override
           public Component getListCellRendererComponent(JList<?> list, Object value, int Index, boolean isSelected, boolean cellHasRenderer){
               ImageAndText is = (ImageAndText) value;
               
               setText(is.getname());
               setIcon(is.getImage());
               
               if(isSelected){
                   setBackground(list.getSelectionBackground());
                   setForeground(list.getSelectionForeground());
               }
               else
               {
                   setBackground(list.getBackground());
                   setForeground(list.getForeground());
               }
               setEnabled(true);
               setFont(list.getFont());
               return this;
           }
    
}