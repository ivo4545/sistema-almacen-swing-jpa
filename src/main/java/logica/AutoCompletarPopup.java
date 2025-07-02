/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;




public class AutoCompletarPopup {
    
    private final JTextField tf;
    private final JPopupMenu popup = new JPopupMenu();
    private final List<String> data;

    public AutoCompletarPopup(JTextField tf, List<String> data) {
        this.tf = tf;
        this.data = data;
        configListeners();
    }

private void configListeners() {
    tf.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) { update(); }
        @Override
        public void removeUpdate(DocumentEvent e) { update(); }
        @Override
        public void changedUpdate(DocumentEvent e) { update(); }

        private void update() {
            popup.removeAll();
            String text = tf.getText().toLowerCase();

            if (text.isEmpty()) {
                popup.setVisible(false);
                return;
            }

          
            for (int i = 0; i < data.size(); i++) {
                String s = data.get(i);
                if (s.toLowerCase().startsWith(text)) {
                    // Por cada coincidencia, creamos y configuramos el item
                    JMenuItem item = new JMenuItem(s);
                    item.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            tf.setText(s);
                            popup.setVisible(false);
                        }
                    });
                    popup.add(item);
                }
            }

            // Mostrar el popup en su posición
            popup.show(tf, 0, tf.getHeight());
        }
    });
}

    public JPopupMenu getPopup() {
        return popup;
    }
    
    
    
    
    
}
