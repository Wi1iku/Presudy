/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ventanas.DialogoProductos;

import clases.TablaLineasPr;
import ventanas.DialogoClientes.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Wiku
 */
public class DialogoProductosAdd extends javax.swing.JDialog {
    JPanel panelTabla;
    Connection con;
    private Connection connection;
    int numeroentrada;
    /**
     * Creates new form DialogoModify
     */
    
    public DialogoProductosAdd(javax.swing.JDialog parent, boolean modal, Connection connection,JPanel jPanel) {
        super(parent, modal);
        initComponents();
        this.connection=connection;
        this.panelTabla=jPanel;
        this.con=connection;
        numeroentrada=1;
        
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Añadir Producto");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Nombre Producto");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Precio Unidad");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("IVA");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("PrecioIVA");

        jTextField4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField4FocusLost(evt);
            }
        });

        jTextField3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField3FocusLost(evt);
            }
        });

        jTextField2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });

        jTextField1.setText("Obligatorio añadir...");
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jButton1.setText("Añadir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 228, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(236, 236, 236))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                                    .addComponent(jTextField2)
                                    .addComponent(jTextField3)
                                    .addComponent(jTextField4))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
     
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed


    }//GEN-LAST:event_formWindowClosed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        if(jTextField1.getText().contains("Obligatorio añadir...")){
                jTextField1.setText("");
            }    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        if(jTextField1.getText().equals("Obligatorio añadir...")){
            jTextField1.setText("");
        }
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            
            String sql="test";
            System.out.println(sql+"ssssssssssssssssssssssssssssssssssssssssss");

            PreparedStatement st;
            sql="Insert into productos values('"+jTextField1.getText()+"','"+Float.valueOf(jTextField2.getText())+"','"+Float.valueOf(jTextField4.getText())+"','"+Integer.valueOf(jTextField3.getText())+"','"+Timestamp.valueOf(LocalDateTime.now())+"')";
            System.out.println(sql);
            st=connection.prepareStatement(sql);
            st.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error al modificar la entrada.");
            System.out.println(ex);
            ex.printStackTrace();
        }finally{
            actualizardatos();
            dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    private boolean isnumber(String check){
        if(!jTextField3.getText().equals("") || !jTextField3.getText().equals("") ){
        try {
            Float.parseFloat(check);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
        return false;
}
    
    
    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
if(jTextField1.getText().contains("Obligatorio añadir...") && jTextField1.hasFocus()){
                jTextField1.setText("");
            }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
        try {
            if (!jTextField3.getText().equals("") && !jTextField3.getText().equals("") && isnumber(jTextField3.getText())) {
           float preciocIva=(Float.valueOf(jTextField2.getText())*(Float.valueOf(jTextField3.getText())/100))+Float.valueOf(jTextField2.getText());
           jTextField4.setText(String.valueOf(preciocIva));   
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jTextField2FocusLost

    private void jTextField3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusLost
        try {
            if (!jTextField2.getText().equals("") && !jTextField2.getText().equals("") && isnumber(jTextField2.getText())) {
           float preciocIva=(Float.valueOf(jTextField2.getText())*(Float.valueOf(jTextField3.getText())/100))+Float.valueOf(jTextField2.getText());
           jTextField4.setText(String.valueOf(preciocIva));   
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jTextField3FocusLost

    private void jTextField4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusLost
        try {
            if (!jTextField3.getText().equals("") && !jTextField3.getText().equals("") && isnumber(jTextField3.getText())) {
           float preciosIva=(Float.valueOf(jTextField4.getText()))/((Float.valueOf(jTextField3.getText())/100)+1);
           jTextField2.setText(String.valueOf(preciosIva));   
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jTextField4FocusLost
void actualizardatos() {
        ArrayList<ArrayList<String>> datosmetodo = new ArrayList();
        int heightpanel = 0;
        panelTabla.removeAll();
        datosmetodo = mostrardatos("Productos", con);
        System.out.println(datosmetodo.size() + "numero de filas1");
        for (ArrayList<String> dato : datosmetodo) {
            // System.out.println("test1");
            panelTabla.add(new TablaLineasPr(dato.get(0), dato.get(1), dato.get(2), dato.get(3), dato.get(4),
                    dato.get(5),con, panelTabla));

            //heightpanel+=38;
            // System.out.println("test1");
        }for (int i = panelTabla.getComponentCount(); i < 10; i++) {
                    panelTabla.add(new JPanel());
                }
        panelTabla.repaint();
        panelTabla.revalidate();
        //System.out.println(datosmetodo.size()+"numero de filas2");
    }
ArrayList<ArrayList<String>> mostrardatos(String nombreTabla, Connection con) {
        String sql = "Select ROWID, * from " + nombreTabla.toUpperCase() + ";";
        Statement st;
        ArrayList<ArrayList<String>> datosmetodo = new ArrayList();

        try {
            st = con.createStatement();
            System.out.println(sql);
            ResultSet result = st.executeQuery(sql);
            int i = 0;
            while (result.next()) {
                datosmetodo.add(new ArrayList());
                datosmetodo.get(i).add(result.getString(1));
                datosmetodo.get(i).add(result.getString(2));
                datosmetodo.get(i).add(result.getString(3));
                datosmetodo.get(i).add(result.getString(4));
                datosmetodo.get(i).add(result.getString(5));
                datosmetodo.get(i).add(result.getString(6));
                i++;

            }
        } catch (SQLException ex) {
            System.out.println("ex");
            System.out.println("error");
            ex.printStackTrace();

        }
        
        return datosmetodo;
    }
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogoClientesAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogoClientesAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogoClientesAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogoClientesAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             
                DialogoClientesAdd dialog = new DialogoClientesAdd(new javax.swing.JDialog(), true, dato1,dato2,dato3,dato4,connection);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                      
                    }
                });
                
                dialog.setVisible(true);
            }
        });
    } */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
