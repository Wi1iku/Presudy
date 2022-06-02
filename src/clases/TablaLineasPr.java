/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import ventanas.DialogoClientes.DialogoClientesMod;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import ventanas.DialogoProductos.DialogoProductosMod;
import ventanas.DialogoProductos.DialogoProductosView;
/**
 *
 * @author Wiku
 */
public class TablaLineasPr extends JPanel{
    
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel4 = new JLabel();
    String dato1;
    String dato2;
    String dato3;
    String dato4;
    String dato5;
    String datorow;
    private JPanel panelTabla;
    private Connection con;
    JPopupMenu menu = new JPopupMenu("Menu");
    Color defaultColor = new Color(214, 217, 223);

    public TablaLineasPr(String datorow,String dato1, String dato2, String dato3, String dato4,
            String dato5,Connection con ,JPanel panelTabla) {
        this.setLayout(new java.awt.GridLayout(1, 4));
        this.setPreferredSize(new Dimension(1107, 49));
        this.setSize(new Dimension(1107, 49));
        this.setMaximumSize(new Dimension(1107, 49));
        this.setMinimumSize(new Dimension(1107, 49));
        this.add(jLabel1);
        this.add(jLabel2);
        this.add(jLabel3);
        this.add(jLabel4);
        this.dato1 = dato1;
        this.dato2 = dato2;
        this.dato3 = dato3;
        this.dato4 = dato4;
        this.dato5 = dato5;
        this.datorow = datorow;
        this.panelTabla = panelTabla;
        this.con = con;
        jLabel1.setText(dato1);
        jLabel2.setText(dato2);
        jLabel3.setText(dato4+"%");
        jLabel4.setText(dato5);
        
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        JMenuItem delete = new JMenuItem("Borrar", new ImageIcon(this.getClass().getResource("/res/iconos/iconosmenucontextual/delete.png")));
        JMenuItem modify = new JMenuItem("Modificar", new ImageIcon(this.getClass().getResource("/res/iconos/iconosmenucontextual/modify.png")));
        menu.add(delete);
        menu.add(modify);
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEntered(evt);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExited(evt);
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MouseClicked1st(evt);

            }
        });
        delete.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PreparedStatement st;
                    String sql = "DELETE FROM PRODUCTOS WHERE ROWID =" + datorow + "";
                    st = con.prepareStatement(sql);

                    int input = JOptionPane.showConfirmDialog(null, "Estas seguro que querer eliminar los datos del Producto: " + dato1 + "?", "Alerta", JOptionPane.YES_NO_OPTION);
                    if (input == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Producto: " + dato1 + " borrado", "Alerta", JOptionPane.WARNING_MESSAGE);

                        st.execute();
                    } else {
                        JOptionPane.showMessageDialog(null, "Producto " + dato1 + " no ha sido borrado", "Alerta", JOptionPane.WARNING_MESSAGE);
                    }

                    actualizardatos();

                } catch (Exception ex) {
                    //Logger.getLogger(TablaLineas.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "No se ha podido borrar la entrada");
                }
            }
        });
        modify.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogoProductosMod dialogoProductosMod = new DialogoProductosMod(new javax.swing.JDialog(), true, con, dato1, dato2, dato3, dato4,datorow);

                dialogoProductosMod.setVisible(true);
                dialogoProductosMod.setSize(600, 600);
                dialogoProductosMod.repaint();
                dialogoProductosMod.revalidate();
                actualizardatos();

            }
        });

    }

 public TablaLineasPr() {

    }

    void MouseEntered(java.awt.event.MouseEvent evt) {
        this.setBackground(Color.YELLOW);
    }

    void MouseExited(java.awt.event.MouseEvent evt) {
        this.setBackground(defaultColor);
    }

    void MouseClicked1st(java.awt.event.MouseEvent evt) {
        if ((evt.getModifiers() & InputEvent.BUTTON1_MASK) != 0) {
            DialogoProductosView dialogoProductosViewView = new DialogoProductosView(new javax.swing.JDialog(), true, con, datorow,dato1, dato2, dato3, dato4, dato5);

            dialogoProductosViewView.setVisible(true);
            dialogoProductosViewView.setSize(600, 600);
            dialogoProductosViewView.repaint();
            dialogoProductosViewView.revalidate();
        }
        if ((evt.getModifiers() & InputEvent.BUTTON3_MASK) != 0) {
            menu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }
    @Deprecated
    ArrayList<ArrayList<String>> mostrardatos(String nombreTabla) {
        String sql = "Select from " + nombreTabla.toUpperCase() + " *;";
        Statement st;
        ArrayList<ArrayList<String>> datosmetodo = new ArrayList();

        try {
            st = con.createStatement();
            ResultSet result = st.executeQuery(sql);
            int i = 0;
            while (result.next()) {
                datosmetodo.add(new ArrayList());
                datosmetodo.get(i).add(result.getString(1));
                datosmetodo.get(i).add(result.getString(2));
                datosmetodo.get(i).add(result.getString(3));
                datosmetodo.get(i).add(result.getString(4));
                datosmetodo.get(i).add(result.getString(5));
                i++;

            }
        } catch (SQLException ex) {
            System.out.println("ex");
            System.out.println("error");
            ex.printStackTrace();

        }
        return datosmetodo;
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

}