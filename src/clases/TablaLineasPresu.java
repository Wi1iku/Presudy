/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
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
import ventanas.DialogoProductos.DialogoProductosView;
import ventanas.PanelPresupuesto;
import static ventanas.PanelPresupuesto.actualizarjcomboprod;
import static ventanas.PanelPresupuesto.addedobjects;

/**
 *
 * @author Wiku
 */
public class TablaLineasPresu extends JPanel{
     private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel4 = new JLabel();
     private JLabel jLabel5 = new JLabel();
    String dato1;
    String dato2;
    String dato3;
    String dato4;
    String dato5;
    String datorow;
    int numerounidades;
    
    private JPanel panelTabla;
    private Connection con;
    JPopupMenu menu = new JPopupMenu("Menu");
    Color defaultColor = new Color(214, 217, 223);

    public TablaLineasPresu(String datorow,String dato1, String dato2, String dato3, String dato4,String dato5,int numerounidades,Connection con ,JPanel panelTabla) {
        this.setLayout(new java.awt.GridLayout(1, 4));
        this.dato1 = dato1;
        this.dato2 = dato2;
        this.dato3 = dato3;
        this.dato4 = dato4;
        this.dato5 = dato5;
        this.datorow = datorow;
        this.numerounidades=numerounidades;
        this.panelTabla = panelTabla;
        this.con = con;
        Dimension d = new Dimension(1089, 65);
        this.setSize(d);
        this.setPreferredSize(d);
        this.setMaximumSize(d);
        this.setMinimumSize(d);
        this.setBackground(new Color(214, 217, 223));
        this.add(jLabel1);
        this.add(jLabel2);
        this.add(jLabel3);
        this.add(jLabel4);
        this.add(jLabel5);
        jLabel1.setText(dato1);
        jLabel2.setText(dato2);
        jLabel3.setText(String.valueOf(numerounidades));
        jLabel4.setText(dato4);
        float iva = Float.valueOf(dato4)/100;
        float preciociva= Float.valueOf(dato2)+(Float.valueOf(dato2)*iva);
        jLabel5.setText(String.valueOf(preciociva*numerounidades));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JMenuItem delete = new JMenuItem("Borrar", new ImageIcon(this.getClass().getResource("/res/iconos/iconosmenucontextual/delete.png")));
        menu.add(delete);
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
                    
                    int input = JOptionPane.showConfirmDialog(null, "Estas seguro la linea de: " + dato1 + "?", "Alerta", JOptionPane.YES_NO_OPTION);
                    if (input == JOptionPane.YES_OPTION) {
                        int numeroborrar=addedobjects.indexOf(dato1+"\\|"+numerounidades);
                        if (numeroborrar<0 && addedobjects.size()>0){
                        numeroborrar=0;
                        }
                        System.out.println(PanelPresupuesto.addedobjects.remove(numeroborrar));
                        for (String addedobject : addedobjects) {
                            System.out.println(addedobject+222222222);
                        }
                        System.out.println(addedobjects.size()+"aaaaaaaaaaaa");
                        JOptionPane.showMessageDialog(null, "Producto: " + dato1 + " borrado", "Alerta", JOptionPane.WARNING_MESSAGE);
                        actualizardatos();

                    } else {
                        JOptionPane.showMessageDialog(null, "Producto " + dato1 + " no ha sido borrado", "Alerta", JOptionPane.WARNING_MESSAGE);
                    }

                    

                } catch (Exception ex) {
                    //Logger.getLogger(TablaLineas.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "No se ha podido borrar la entrada");
                }
                //actualizardatos();
            }
        }); 
    }

    public String getjLabel1() {
        return jLabel1.getText();
    }

    public String getjLabel2() {
        return jLabel2.getText();
    }

    public String getjLabel3() {
        return jLabel3.getText();
    }

    public String getjLabel4() {
        return jLabel4.getText();
    }

    public String getjLabel5() {
        return jLabel5.getText();
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
private void actualizardatos() {
        System.out.println("testodes1");
        panelTabla.removeAll();
        for (String addedobject : PanelPresupuesto.addedobjects) {
            ArrayList<String> dato = new ArrayList();
            System.out.println(addedobject+"addededededed");
            System.out.println("lñlñlñlñlñl");
        String[] addedobjetcArray = addedobject.split("\\|");
        String sql= "Select ROWID, * from PRODUCTOS where productos.nombreProd='"+addedobjetcArray[0]+"'";
        Statement st;
            try {
            st = con.createStatement();
            ResultSet result = st.executeQuery(sql);
            int i = 0;
            while (result.next()) {
                dato.add(result.getString(1));
                dato.add(result.getString(2));
                dato.add(result.getString(3));
                dato.add(result.getString(4));
                dato.add(result.getString(5));
                dato.add(result.getString(6));
                i++;

            }

        } catch (SQLException ex) {
            System.out.println("ex");
            System.out.println("error");
            ex.printStackTrace();

        }
  
            panelTabla.add(new TablaLineasPresu(dato.get(0), dato.get(1), dato.get(2), dato.get(3), dato.get(4),
                    dato.get(5),Integer.valueOf(addedobjetcArray[1]),con, panelTabla));

        }
        
        if (panelTabla.getComponentCount()<7) {
            
            int componentstoadd = 7-panelTabla.getComponentCount();
            for (int i = componentstoadd; i > 0; i--) {
                panelTabla.add(new TablaVaciaPresu());
            }
        }
        
        panelTabla.repaint();
        panelTabla.revalidate();
        actualizarjcomboprod();
     }   
}