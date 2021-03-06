/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ventanas.DialogoUsuarios;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import ventanas.DialogoProductos.*;
import ventanas.DialogoClientes.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Wiku
 */
public class DialogoUsuariosMod extends javax.swing.JDialog {
    String datorow;
    String nombreempresa;
    String codPost;
    String localidad;
    String nIF;
    String tel;
    String correo;
    String web;
    Boolean esEmpresa ;
    String imgpath;
    private Connection connection;
    
    
    public DialogoUsuariosMod(javax.swing.JDialog parent, boolean modal, Connection connection,String datorow,
            String dato1,String dato2,String dato3,String dato4,String dato5,String dato6,String dato7,Boolean esEmpresa,String imgpath) {
        super(parent, modal);
        initComponents();
        this.connection=connection;
        this.datorow=datorow;
        this.nombreempresa=dato1;
        this.codPost=dato2;
        this.localidad=dato3;
        this.nIF=dato5;
        this.tel=dato4;
        this.correo=dato6;
        this.web=dato7;
        this.esEmpresa=esEmpresa;
        this.imgpath=imgpath;
        jTextField1.setText(nombreempresa);
        jTextField2.setText(codPost);
        jTextField3.setText(localidad);
        jTextField4.setText(tel);
        jTextField5.setText(nIF);
        jTextField6.setText(correo);
        jTextField7.setText(web);
        jCheckBox1.setSelected(this.esEmpresa);
        
        ImageIcon logo = new javax.swing.ImageIcon(imgpath);
        Image image = logo.getImage();
        image=image.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
        logo = new ImageIcon(image);
        jLabel12.setIcon(logo);
        
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Datos Usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 6, -1, -1));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 483, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Nombre Usuario");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 62, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Codigo postal");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 105, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Localidad");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 148, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("NIF");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 191, -1, -1));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 192, 402, -1));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 149, 402, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 106, 402, -1));

        jTextField1.setText("Obligatorio a??adir...");
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
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 63, 402, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Correo");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 278, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Telefono");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 236, -1, -1));
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 234, 402, -1));

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 276, 402, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("P??gina web");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 320, -1, -1));

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 318, 402, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("??Es una empresa?");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 362, -1, -1));

        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 362, 402, -1));

        jButton1.setText("Modificar Usuario");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 489, 645, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Imagen");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 426, -1, -1));
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 80, 80));

        jButton2.setText("Modificar Imagen");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 420, 190, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
     
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed


    }//GEN-LAST:event_formWindowClosed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        if(jTextField1.getText().equals("Obligatorio a??adir...")){
            jTextField1.setText("");
        }
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
        try{
        Integer.valueOf(jTextField2.getText());
        }catch (Exception ex) {
            jTextField2.setText("0");
        }
        
        try {
            String dati1orig=nombreempresa;

            PreparedStatement st;
            if(!jTextField1.getText().equals(dati1orig)){
                int input=JOptionPane.showConfirmDialog(null,"Aviso, vas a cambiar el nombre de usuario \""+nombreempresa+"\", Estas seguro?");
                if(input==1 || input==2){
                    nombreempresa=dati1orig;
                    //testgit
                }else{

                }
            }
            String sql = "Update usuarios set nombreEmpresa='"+jTextField1.getText()
            + "',codPost="+Integer.valueOf(jTextField2.getText())
            + ",localidad='"+jTextField3.getText()
            + "',NIF='"+jTextField4.getText()
            + "',tel='"+jTextField5.getText()
            + "',correo='"+jTextField6.getText()
            + "',web='"+jTextField7.getText()
            + "',empresa="+jCheckBox1.isSelected()
            +",logopath='"+imgpath+"'"
            +" where ROWID="+datorow+"" ;

            st=connection.prepareStatement(sql);
            st.execute();
            // actualizardatos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al modificar la entrada.");
            System.out.println(e);
        }finally{
            dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
 private String getFileExtension(String fullName) {
    String fileName = new File(fullName).getName();
    int dotIndex = fileName.lastIndexOf('.');
    return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
}
    private boolean isimage(String string){
        string = getFileExtension(string);
        switch(string){
                case "png":
                case "jpg":
                case "jpeg":
                case "tif":
                case "tiff":
                case "bmp":
                case "gif":
                case "raw":
                    return true;
                    
                default:
                    System.out.println("tipo imagen"+string+"no valido");
                    return false;
        }       
    
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String nombre=nombreempresa;
        
        JFileChooser filechooser = new JFileChooser();
        int response=filechooser.showDialog(this, "Elige imagen");
        
        if(response == JFileChooser.APPROVE_OPTION ){
            final File ESTACARPETA = new File("").getAbsoluteFile();
            File file = new File(filechooser.getSelectedFile().getAbsolutePath());
            Path orig = Paths.get(file.getAbsolutePath());
            if(isimage(orig.getFileName().toString())){
            String pathacopy = ESTACARPETA+File.separator+"src"+File.separator+"res"+File.separator+"images"+File.separator+"imagesuser"+File.separator+orig.getFileName();
            System.out.println(pathacopy);
            Path path = Paths.get(pathacopy);
            File path2 = new File(ESTACARPETA+File.separator+"src"+File.separator+"res"+File.separator+"images"+File.separator+"imagesuser"+File.separator+jTextField1.getText()+orig.getFileName());
            System.out.println("");
            try {
                Files.copy(file.toPath(),path2.toPath(),StandardCopyOption.REPLACE_EXISTING);
                imgpath=path2.toPath().toString();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
            
            
        ImageIcon logo = new javax.swing.ImageIcon(imgpath);
        Image image = logo.getImage();
        image=image.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
        logo = new ImageIcon(image);
        jLabel12.setIcon(logo);
        jLabel12.setText("");
        }}
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
