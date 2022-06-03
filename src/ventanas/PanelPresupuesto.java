/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ventanas;

import clases.*;
import clases.pdfs.*;
import java.awt.Component;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Wiku
 */
public class PanelPresupuesto extends javax.swing.JPanel {

    /**
     * Creates new form PanelFacturas
     */
    private ArrayList<ArrayList> datosAgredados = new ArrayList<>();
    public static ArrayList<String> addedobjects = new ArrayList<>();
    private static Connection connection;
    static int iol;
    public PanelPresupuesto(Connection connection) {

        
        this.connection = connection;
        initComponents();

    }
    public static void actualizartablas(){
    ArrayList<ArrayList<String>> datos = mostrardatos("CLIENTES");
        iol = 0;
        for (ArrayList<String> dato : datos) {
            iol++;
            jComboBoxCliente.addItem(dato.get(1));
        }
        datos = mostrardatos("USUARIOS");
        iol = 0;
        for (ArrayList<String> dato : datos) {
            iol++;
            jComboBox1.addItem(dato.get(1)+"  ||  "+dato.get(4));
        }
        actualizarjcomboprod();
    }
    public static void actualizarjcomboprod() {
        int i = 0;
        jComboBoxProducto.removeAllItems();
        jComboBoxProducto.addItem("Nombre Producto");
        ArrayList<ArrayList<String>> datos = mostrardatos("PRODUCTOS");
        for (ArrayList<String> dato : datos) {
            i++;
            if (addedobjects.isEmpty()) {
                jComboBoxProducto.addItem(dato.get(1));
            } else {
                if (isnotinaddedobjets(dato.get(1))) {
                    jComboBoxProducto.addItem(dato.get(1));
                }
            }
        }

        jComboBoxProducto.setSelectedIndex(0);
    }

    private static boolean isnotinaddedobjets(String string) {
        for (String addedobject : addedobjects) {
            String[] addedobjetcArray = addedobject.split("\\|");
            if (string.equals(addedobjetcArray[0])) {
                return false;
            }
        }
        return true;
    }

    private static ArrayList<ArrayList<String>> mostrardatos(String nombretabla) {
        String sql = "SELECT ROWID,* FROM " + nombretabla;
        Statement st;
        ArrayList<ArrayList<String>> datosmetodo = new ArrayList();
        nombretabla = nombretabla.toUpperCase();

        try {

            st = connection.createStatement();
            ResultSet result = st.executeQuery(sql);
            int i = 0;
            if (nombretabla.equals("CLIENTES")) {
                while (result.next()) {
                    datosmetodo.add(new ArrayList());
                    datosmetodo.get(i).add(result.getString(1));
                    datosmetodo.get(i).add(result.getString(2));
                    datosmetodo.get(i).add(result.getString(3));
                    datosmetodo.get(i).add(result.getString(4));
                    datosmetodo.get(i).add(result.getString(5));
                    datosmetodo.get(i).add(result.getString(6));
                    datosmetodo.get(i).add(result.getString(7));
                    datosmetodo.get(i).add(result.getString(8));
                    datosmetodo.get(i).add(result.getString(9));
                    datosmetodo.get(i).add(result.getString(10));
                    datosmetodo.get(i).add(result.getString(11));
                    i++;

                }
            } else if (nombretabla.equals("PRODUCTOS")) {
               
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
            }else if (nombretabla.equals("USUARIOS")) {
               
                while (result.next()) {
                datosmetodo.add(new ArrayList());
                datosmetodo.get(i).add(result.getString(1));
                datosmetodo.get(i).add(result.getString(2));
                datosmetodo.get(i).add(result.getString(3));
                datosmetodo.get(i).add(result.getString(4));
                datosmetodo.get(i).add(result.getString(5));
                datosmetodo.get(i).add(result.getString(6));
                datosmetodo.get(i).add(result.getString(7));
                datosmetodo.get(i).add(result.getString(8));
                datosmetodo.get(i).add(String.valueOf(result.getBoolean(9)));
                i++;
                }
            }
        } catch (SQLException ex) {
            System.out.println("ex");
            System.out.println("error");
            ex.printStackTrace();

        }
        return datosmetodo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxCliente = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxProducto = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelProductos = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jCheckBox1 = new javax.swing.JCheckBox();
        jComboBox1 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(204, 255, 255));
        setPreferredSize(new java.awt.Dimension(1115, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre Cliente" }));
        jComboBoxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxClienteActionPerformed(evt);
            }
        });
        add(jComboBoxCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 460, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nuevo presupuesto");
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 470, 50));

        jComboBoxProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre Producto" }));
        add(jComboBoxProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 460, -1));

        jButton1.setText("Añadir producto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 130, 30));

        jSpinner1.setToolTipText("Numero unidades");
        add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 50, -1));

        jPanel2.setLayout(new java.awt.GridLayout(0, 5));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nombre producto ");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel2.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(jLabel2);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Precio unidades bruto");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(jLabel3);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Numero Unidades");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel4.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(jLabel4);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText(" IVA aplicado");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel5.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(jLabel5);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Precio total con Iva");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel6.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(jLabel6);

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 1090, 40));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanelProductos.setLayout(new java.awt.GridLayout(0, 1));

        jPanel9.setMaximumSize(new java.awt.Dimension(1089, 65));
        jPanel9.setMinimumSize(new java.awt.Dimension(1089, 65));
        jPanel9.setPreferredSize(new java.awt.Dimension(1089, 65));
        jPanelProductos.add(jPanel9);

        jPanel10.setMaximumSize(new java.awt.Dimension(1089, 65));
        jPanel10.setMinimumSize(new java.awt.Dimension(1089, 65));
        jPanel10.setPreferredSize(new java.awt.Dimension(1089, 65));
        jPanelProductos.add(jPanel10);

        jPanel11.setMaximumSize(new java.awt.Dimension(1089, 65));
        jPanel11.setMinimumSize(new java.awt.Dimension(1089, 65));
        jPanel11.setPreferredSize(new java.awt.Dimension(1089, 65));
        jPanelProductos.add(jPanel11);

        jPanel12.setMaximumSize(new java.awt.Dimension(1089, 65));
        jPanel12.setMinimumSize(new java.awt.Dimension(1089, 65));
        jPanel12.setPreferredSize(new java.awt.Dimension(1089, 65));
        jPanelProductos.add(jPanel12);

        jPanel13.setMaximumSize(new java.awt.Dimension(1089, 65));
        jPanel13.setMinimumSize(new java.awt.Dimension(1089, 65));
        jPanel13.setPreferredSize(new java.awt.Dimension(1089, 65));
        jPanelProductos.add(jPanel13);

        jPanel14.setMaximumSize(new java.awt.Dimension(1089, 65));
        jPanel14.setMinimumSize(new java.awt.Dimension(1089, 65));
        jPanel14.setPreferredSize(new java.awt.Dimension(1089, 65));
        jPanelProductos.add(jPanel14);

        jPanel15.setMaximumSize(new java.awt.Dimension(1089, 65));
        jPanel15.setMinimumSize(new java.awt.Dimension(1089, 65));
        jPanel15.setPreferredSize(new java.awt.Dimension(1089, 65));
        jPanelProductos.add(jPanel15);

        jScrollPane1.setViewportView(jPanelProductos);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 1090, 510));

        jButton2.setText("Crear PDF");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 130, 30));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jScrollPane2.setViewportView(jTextArea1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 50, 340, 100));

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Direccion de facturacion misma que direccion cliente");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 340, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre Usuario" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 460, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int numerounidades = (Integer) jSpinner1.getValue();
        addedobjects.add(jComboBoxProducto.getSelectedItem().toString() + "|" + numerounidades);
        jPanelProductos.removeAll();
            
        for (String addedobject : addedobjects) {
            String[] addedobjetcArray = addedobject.split("\\|");
            String sql = "Select ROWID, * from PRODUCTOS where productos.nombreProd='" + addedobjetcArray[0] + "'";
            Statement st;
            ArrayList<ArrayList<String>> datosmetodo = new ArrayList();
            try {
                st = connection.createStatement();
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
            for (ArrayList<String> dato : datosmetodo) {
                datosAgredados.add(new ArrayList());
                jPanelProductos.add(new TablaLineasPresu(dato.get(0), dato.get(1), dato.get(2), dato.get(3), dato.get(4),
                        dato.get(5), Integer.valueOf(addedobjetcArray[1]), connection, jPanelProductos));
                
            }
        }
        if (jPanelProductos.getComponentCount() < 7) {

            int componentstoadd = 7 - jPanelProductos.getComponentCount();
            for (int i = componentstoadd; i > 0; i--) {
                jPanelProductos.add(new TablaVaciaPresu());
            }
        }
        jPanelProductos.repaint();
        jPanelProductos.revalidate();
        actualizarjcomboprod();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.out.println(datosAgredados.size() + "tamañodatosagregados");
        datosAgredados=new ArrayList<>();
            int j = 0;
        for (String addedobject : addedobjects) {
            String[] addedobjetcArray = addedobject.split("\\|");
            String sql = "Select ROWID, * from PRODUCTOS where productos.nombreProd='" + addedobjetcArray[0] + "'";
            Statement st;
            ArrayList<ArrayList<String>> datosmetodo = new ArrayList();
            try {
                st = connection.createStatement();
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
            for (ArrayList<String> dato : datosmetodo) {
                datosAgredados.add(new ArrayList());
                datosAgredados.get(j).add(dato.get(1));
                datosAgredados.get(j).add(dato.get(2));
                datosAgredados.get(j).add(Integer.valueOf(addedobjetcArray[1]));
                datosAgredados.get(j).add(dato.get(4));
                float preciosiniva = Float.valueOf(dato.get(2));
                datosAgredados.get(j).add(String.valueOf(((Float.valueOf(dato.get(2))+(Float.valueOf(dato.get(2))*(Float.valueOf(dato.get(4)))/100)))*Integer.valueOf(addedobjetcArray[1])));
                j++;
            }
        }
        if (jCheckBox1.isSelected()) {
            PdfPresupuesto pdf2 = new PdfPresupuesto("pdfpresu2", jComboBoxCliente.getSelectedItem().toString(),jComboBox1.getSelectedItem().toString() ,datosAgredados, connection);
        } else {
            PdfPresupuesto pdf2 = new PdfPresupuesto("pdfpresu2", jComboBoxCliente.getSelectedItem().toString(),jComboBox1.getSelectedItem().toString(),jTextArea1.getText() ,datosAgredados, connection);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBoxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxClienteActionPerformed
        if ((jComboBoxCliente.getSelectedItem().equals("Nombre Cliente")) || (jComboBox1.getSelectedItem().equals("Nombre Usuario"))) {
            jButton2.setEnabled(false);
        } else {
            jButton2.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBoxClienteActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
            jTextArea1.setEnabled(false);
        } else {
            jTextArea1.setEnabled(true);
            jTextArea1.setText("Introduce direccion de facturacion");
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if ((jComboBoxCliente.getSelectedItem().equals("Nombre Cliente")) || (jComboBox1.getSelectedItem().equals("Nombre Usuario"))) {
            jButton2.setEnabled(false);
        } else {
            jButton2.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private static javax.swing.JComboBox<String> jComboBox1;
    private static javax.swing.JComboBox<String> jComboBoxCliente;
    private static javax.swing.JComboBox<String> jComboBoxProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelProductos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
