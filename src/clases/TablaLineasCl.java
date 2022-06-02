/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.Color;
import java.awt.Dimension;
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
import ventanas.DialogoClientes.DialogoClientesView;

/**
 *
 * @author Wiku
 */
public class TablaLineasCl extends JPanel {

    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel4 = new JLabel();
    String dato1;
    String dato2;
    String dato3;
    String dato4;
    String dato5;
    String dato6;
    String dato7;
    String dato8;
    String dato9;
    String dato10;
    private JPanel panelTabla;
    private Connection con;
    JPopupMenu menu = new JPopupMenu("Menu");
    Color defaultColor = new Color(214, 217, 223);

    public TablaLineasCl(String dato1, String dato2, String dato3, String dato4, String dato5, String dato6, String dato7, String dato8, String dato9, String dato10, Connection con, JPanel panelTabla) {
        this.setLayout(new java.awt.GridLayout(1, 4));
        this.add(jLabel1);
        this.setPreferredSize(new Dimension(1107, 49));
        this.setSize(new Dimension(1107, 49));
        this.setMaximumSize(new Dimension(1107, 49));
        this.setMinimumSize(new Dimension(1107, 49));
        this.add(jLabel2);
        this.add(jLabel3);
        this.add(jLabel4);
        this.dato1 = dato1;
        this.dato2 = dato2;
        this.dato3 = dato3;
        this.dato4 = dato4;
        this.dato5 = dato5;
        this.dato6 = dato6;
        this.dato7 = dato7;
        this.dato8 = dato8;
        this.dato9 = dato9;
        this.dato10 = dato10;
        this.panelTabla = panelTabla;
        this.con = con;
        jLabel1.setText(dato1);
        jLabel2.setText(dato2);
        jLabel3.setText(dato3);
        jLabel4.setText(dato4);
        
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JMenuItem delete = new JMenuItem("Borrar", new ImageIcon(this.getClass().getResource("/res/iconos/iconosmenucontextual/delete.png")));
        JMenuItem modify = new JMenuItem("Modificar", new ImageIcon(this.getClass().getResource("/res/iconos/iconosmenucontextual/modify.png")));
        menu.add(delete);
        menu.add(modify);
        //this.add(menu); esto si se añade mueve el texto
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
                    String sql = "DELETE FROM clientes WHERE Clientes.nombreCliente ='" + dato1 + "'";
                    st = con.prepareStatement(sql);

                    int input = JOptionPane.showConfirmDialog(null, "Estas seguro que querer eliminar los datos del Cliente: " + dato1 + "?", "Alerta", JOptionPane.YES_NO_OPTION);
                    if (input == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Cliente: " + dato1 + " borrado", "Alerta", JOptionPane.WARNING_MESSAGE);

                        st.execute();
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente " + dato1 + " no ha sido borrado", "Alerta", JOptionPane.WARNING_MESSAGE);
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
                DialogoClientesMod dialogoClientesMod = new DialogoClientesMod(new javax.swing.JDialog(), true, con, dato1, dato2, dato3, dato4, dato5, dato6, dato8, dato9, dato10);

                dialogoClientesMod.setVisible(true);
                dialogoClientesMod.setSize(600, 600);
                dialogoClientesMod.repaint();
                dialogoClientesMod.revalidate();
                actualizardatos();

            }
        });

    }

    public TablaLineasCl() {

    }

    void MouseEntered(java.awt.event.MouseEvent evt) {
        this.setBackground(Color.YELLOW);
    }

    void MouseExited(java.awt.event.MouseEvent evt) {
        this.setBackground(defaultColor);
    }

    void MouseClicked1st(java.awt.event.MouseEvent evt) {
        if ((evt.getModifiers() & InputEvent.BUTTON1_MASK) != 0) {
            DialogoClientesView dialogoClientesView = new DialogoClientesView(new javax.swing.JDialog(), true, con, dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10);

            dialogoClientesView.setVisible(true);
            dialogoClientesView.setSize(600, 600);
            dialogoClientesView.repaint();
            dialogoClientesView.revalidate();
        }
        if ((evt.getModifiers() & InputEvent.BUTTON3_MASK) != 0) {
            menu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }

    ArrayList<ArrayList<String>> mostrardatos(String nombreTabla) {
        String sql = "Select from " + nombreTabla.toUpperCase() + " *;";
        Statement st;
        ArrayList<ArrayList<String>> datosmetodo = new ArrayList();

        try {
            System.out.println(con + "222222");
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
                datosmetodo.get(i).add(result.getString(6));
                datosmetodo.get(i).add(result.getString(7));
                datosmetodo.get(i).add(result.getString(8));
                datosmetodo.get(i).add(result.getString(9));
                datosmetodo.get(i).add(result.getString(10));
                datosmetodo.get(i).add(result.getString(11));
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
            System.out.println(con + "222222");
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
                datosmetodo.get(i).add(result.getString(7));
                datosmetodo.get(i).add(result.getString(8));
                datosmetodo.get(i).add(result.getString(9));
                datosmetodo.get(i).add(result.getString(10));
                datosmetodo.get(i).add(result.getString(11));
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
        datosmetodo = mostrardatos("Clientes", con);
        System.out.println(datosmetodo.size() + "numero de filas1");
        for (ArrayList<String> dato : datosmetodo) {
            // System.out.println("test1");
            panelTabla.add(new TablaLineasCl(dato.get(1), dato.get(2), dato.get(3), dato.get(4), dato.get(5),
                    dato.get(6), dato.get(7), dato.get(8), dato.get(9), dato.get(10), con, panelTabla));

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
