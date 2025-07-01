/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package IGU;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.DefaultTableModel;
import logica.AutoCompletarPopup;
import logica.ControladoraLogica;
import logica.Producto;

/**
 *
 * @author ivost
 */
public class VerDatos extends javax.swing.JFrame {
    
    ControladoraLogica control = null;
    /*
    
    
    IMPLEMENTAR LO DE AUTOCOMPLETE EN ESTA TMB
    
    
    */
    
    public VerDatos() {
        
        control = new ControladoraLogica();
        initComponents();
        initAutoComplete();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaProd1 = new javax.swing.JTable();
        txt1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnModif = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        TablaProd1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(TablaProd1);

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        jLabel1.setText("Buscar:");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnModif.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnModif.setText("Modificar Prod.");
        btnModif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnEliminar.setText("Eliminar Prod.");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(314, 314, 314)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnModif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModif, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTabla();        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void btnModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifActionPerformed
        if (TablaProd1.getSelectedRow() != -1){
            int idProd = Integer.parseInt(String.valueOf(TablaProd1.getValueAt(TablaProd1.getSelectedRow(), 5)));
            ModificarDatos panta = new ModificarDatos(idProd);
            panta.txtPrecioCompra.setEditable(true);
            panta.setVisible(true);
            panta.setLocationRelativeTo(null);
            this.dispose();
            
        }
    }//GEN-LAST:event_btnModifActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (TablaProd1.getSelectedRow() != -1){
            int idProd = Integer.parseInt(String.valueOf(TablaProd1.getValueAt(TablaProd1.getSelectedRow(), 5)));
            
            
            control.eliminarprod(idProd);
            JOptionPane.showMessageDialog(null, "El producto se ha eliminado! ");
            
            cargarTabla();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        MenuAdmin panta = new MenuAdmin();
        panta.setVisible(true);
        panta.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    
            public void initAutoComplete() {
   
        /*UTILIZE LOS METODOS DE PopupMenuListener. 
        1- popupMenuWillBecomeVisible(...): se dispara justo antes de que aparezca el menú.
        2- popupMenuWillBecomeInvisible(...): antes de cerrar.
        3- popupMenuCanceled(...): si se cierra de forma cancelada (p. ej. clic afuera)
        
        En este caso utilice el segundo para que, antes de cerrarse se ejecute el codigo que compara lo que hay en txt1 
        con todos los nombres de los productos, cuando se encuentra el nombre del producto de txt1 en la lista,
        setea un modelo de tabla que 
        contiene solo los valores de dicho producto.
        */
        ConsultarProd obj = new ConsultarProd();
        List<String> listaNom = obj.listaNom();
        AutoCompletarPopup autoCompletePopup = new AutoCompletarPopup(txt1, listaNom);
        autoCompletePopup.getPopup().addPopupMenuListener(new PopupMenuListener(){
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                for(String nombre: listaNom){
                    if(nombre.equals(txt1.getText())){
                        
                        DefaultTableModel tablaModelo = new DefaultTableModel();
                            
                            String titulos[] = {"Nombre","Categoria","Cantidad","Precio Venta","Precio compra","ID"};
                            tablaModelo.setColumnIdentifiers(titulos);
                            
                            List<Producto> listaprod = control.traerprod();
                            
                            for(Producto prod:listaprod){
                                
                                if(prod.getNombre().equals(nombre)){
                                    Object[] produc = {prod.getNombre(),prod.getCategoria().getNombre(),prod.getCantidad(),prod.getPrecio_venta()
                                    ,prod.getPrecio_compra(),prod.getIdProducto()};
                                    
                                    tablaModelo.addRow(produc);
                                    TablaProd1.setModel(tablaModelo);
                                    break;
                                    
                                }
                            }
                        
                    }
                }
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {  
                
            } 
            
        });    
    }
    
        
        protected void cargarTabla(){
        
        DefaultTableModel modeloTabla = new DefaultTableModel(){
            
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }           
        };
        
        String titulos[] = {"Nombre","Categoria","Cantidad","Precio Venta","Precio Compra","ID"};
        modeloTabla.setColumnIdentifiers(titulos);
        
        List <Producto> listaProd = control.traerprod();
        
        if (listaProd != null){
            for(Producto prod:listaProd){
                Object[] producto = {prod.getNombre(),prod.getCategoria().getNombre(),prod.getCantidad(),prod.getPrecio_venta()
                                    ,prod.getPrecio_compra(),prod.getIdProducto()};
                
                modeloTabla.addRow(producto);
            }
        }
        
        TablaProd1.setModel(modeloTabla);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaProd1;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModif;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txt1;
    // End of variables declaration//GEN-END:variables
}
