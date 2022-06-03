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
import ventanas.DialogoUsuarios.*;
/**
 *
 * @author Wiku
 */
public class TablaLineasUsers extends JPanel{
    
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    String nombreEmpresa;
    String codPost;
    String localidad;
    String nif;
    String telefono;
    String correo;
    String web;
    Boolean esEmpresa;
    String datorow;
    String imgpath;
    private JPanel panelTabla;
    private Connection con;
    JPopupMenu menu = new JPopupMenu("Menu");
    Color defaultColor = new Color(214, 217, 223);

    public TablaLineasUsers(String datorow,String nombreEmpresa, String codPost, String localidad, String nif, String telefono, String correo, String web,Boolean esEmpresa,String imgpath,Connection con ,JPanel panelTabla) {
        this.setLayout(new java.awt.GridLayout(1, 4));
        jLabel1.setPreferredSize(new Dimension(85, 48));
        this.add(jLabel1);
        this.add(jLabel2);
        this.add(jLabel3);
        this.nombreEmpresa = nombreEmpresa;
        this.codPost=codPost;
        this.localidad=localidad;
        this.nif=nif;
        this.esEmpresa=esEmpresa;
        this.telefono = telefono;
        this.correo = correo;
        this.web=web;
        this.panelTabla = panelTabla;
        this.con = con;
        this.imgpath=imgpath;
        jLabel1.setText(this.nombreEmpresa);
        jLabel2.setText(this.telefono);
        jLabel3.setText(this.correo);
        
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Dimension d = new Dimension(1107,82);
        this.setSize(d);
        this.setMaximumSize(d);
        this.setMinimumSize(d);
        this.setPreferredSize(d);
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
                    String sql = "DELETE FROM usuarios WHERE ROWID =" + datorow + "";
                    st = con.prepareStatement(sql);

                    int input = JOptionPane.showConfirmDialog(null, "Estas seguro que querer eliminar los datos del Usuario: " + nombreEmpresa + "?", "Alerta", JOptionPane.YES_NO_OPTION);
                    if (input == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Usuario: " + nombreEmpresa + " borrado", "Alerta", JOptionPane.WARNING_MESSAGE);

                        st.execute();
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario: " + nombreEmpresa + " no ha sido borrado", "Alerta", JOptionPane.WARNING_MESSAGE);
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
                DialogoUsuariosMod dialogoProductosMod = new DialogoUsuariosMod(new javax.swing.JDialog(), true, con, datorow,nombreEmpresa, codPost, localidad, nif, telefono,correo,web,esEmpresa);

                dialogoProductosMod.setVisible(true);
                dialogoProductosMod.setSize(600, 600);
                dialogoProductosMod.repaint();
                dialogoProductosMod.revalidate();
                actualizardatos();

            }
        });

    }

 public TablaLineasUsers() {

    }

    void MouseEntered(java.awt.event.MouseEvent evt) {
        this.setBackground(Color.YELLOW);
    }

    void MouseExited(java.awt.event.MouseEvent evt) {
        this.setBackground(defaultColor);
    }

    void MouseClicked1st(java.awt.event.MouseEvent evt) {
        if ((evt.getModifiers() & InputEvent.BUTTON1_MASK) != 0) {
            DialogoUsuariosView dialogoUsuariosView = new DialogoUsuariosView(new javax.swing.JDialog(), true, con, datorow,nombreEmpresa, codPost, localidad, nif, telefono,correo,web,esEmpresa,imgpath);

            dialogoUsuariosView.setVisible(true);
            dialogoUsuariosView.setSize(600, 600);
            dialogoUsuariosView.repaint();
            dialogoUsuariosView.revalidate();
        }
        if ((evt.getModifiers() & InputEvent.BUTTON3_MASK) != 0) {
            menu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
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
                datosmetodo.get(i).add(result.getString(7));
                datosmetodo.get(i).add(result.getString(8));
                datosmetodo.get(i).add(String.valueOf(result.getBoolean(9)));
                datosmetodo.get(i).add(result.getString(10));
                
                
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
        datosmetodo = mostrardatos("usuarios", con);
        for (ArrayList<String> dato : datosmetodo) {
            // System.out.println("test1");
            panelTabla.add(new TablaLineasUsers(dato.get(0), dato.get(1), dato.get(2), dato.get(3), dato.get(4), dato.get(5), dato.get(6), dato.get(7), Boolean.valueOf(dato.get(8)),dato.get(9),con, panelTabla));
            
            //heightpanel+=38;
            // System.out.println("test1");
        }
        for (int i = panelTabla.getComponentCount(); i < 6; i++) {
                    panelTabla.add(new JPanel());
                }
        panelTabla.repaint();
        panelTabla.revalidate();
        //System.out.println(datosmetodo.size()+"numero de filas2");
    }

}