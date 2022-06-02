/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ventanas;


import clases.TablaLineasUsers;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JPanel;
import ventanas.DialogoUsuarios.DialogoUsuariosAdd;

/**
 *
 * @author Wiku
 */
public class PanelUsers extends javax.swing.JPanel {

    Connection connection;

    public PanelUsers(Connection connection) {
        this.connection = connection;
        initComponents();

        ArrayList<ArrayList<String>> datosmetodo = new ArrayList();
        datosmetodo = mostrardatos();
        //Añadir labels al scroll
        //System.out.println("ready to index");
        //System.out.println(datosmetodo.size());
        if (datosmetodo.size() > 0) {
            //System.out.println(datosmetodo.get(0).size()+"aaaaaaaaaaa");

            //TODO esta vacio el array
            for (ArrayList<String> dato : datosmetodo) {

                if (dato.size() > 0) {
                    panelLabels.add(new TablaLineasUsers(dato.get(0), dato.get(1), dato.get(2), dato.get(3), dato.get(4), dato.get(5), dato.get(6), dato.get(7), Boolean.valueOf(dato.get(8)),connection, panelLabels));
     
                }
                
            }for (int i = panelLabels.getComponentCount(); i < 6; i++) {
                    panelLabels.add(new JPanel());
                }
        }

    }

    private ArrayList<ArrayList<String>> mostrardatos() {
        String sql = "select rowid, * from usuarios;";
        Statement st;
        ArrayList<ArrayList<String>> datosmetodo = new ArrayList();

        for (ArrayList<String> dato : datosmetodo) {
            //datos.add(new ArrayList());
        }
        try {
            st = connection.createStatement();
            ResultSet result = st.executeQuery(sql);
            System.out.println(sql);
            int i = 0;
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        delete = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelLabels = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        panelDefaukt = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        delete.setText("jMenuItem1");
        jPopupMenu1.add(delete);

        setBackground(new java.awt.Color(255, 153, 102));
        setPreferredSize(new java.awt.Dimension(1115, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panelLabels.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane1.setViewportView(panelLabels);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 1110, 490));

        jButton1.setText("Añadir Usuario");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 270, 50));

        panelDefaukt.setLayout(new java.awt.GridLayout(0, 3));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nombre");
        jLabel1.setToolTipText("");
        panelDefaukt.add(jLabel1);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Telefono");
        jLabel2.setToolTipText("");
        panelDefaukt.add(jLabel2);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Correo");
        jLabel3.setToolTipText("");
        panelDefaukt.add(jLabel3);

        add(panelDefaukt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1110, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DialogoUsuariosAdd dialogoClientesAdd = new DialogoUsuariosAdd(new javax.swing.JDialog(), true, connection, panelLabels);
        dialogoClientesAdd.setVisible(true);
  
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem delete;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelDefaukt;
    private javax.swing.JPanel panelLabels;
    // End of variables declaration//GEN-END:variables
}
