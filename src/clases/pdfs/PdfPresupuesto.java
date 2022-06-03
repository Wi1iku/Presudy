/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.pdfs;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.DeviceCmyk;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.draw.DashedLine;
import com.itextpdf.kernel.pdf.canvas.draw.DottedLine;
import com.itextpdf.kernel.pdf.canvas.draw.ILineDrawer;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.LineSeparator;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javax.swing.text.Element;
public class PdfPresupuesto {
    private static final File ESTACARPETA = new File("").getAbsoluteFile();
    private String logoemp=ESTACARPETA+File.separator+"src"+File.separator+"res"+File.separator+"images"+File.separator+"company.jpg";
    public String destino;
    PdfWriter writer;
    String destinoString;
    Connection connection;
    Boolean empresa;
    String facturacionString;
    ArrayList<String> arrayListcliente;
    NumberFormat currencyformatter;
    
    ArrayList<String> arrayListUsuario;
    public PdfPresupuesto(String destinoString,String nombreCliente,String nombreUsuario,ArrayList<ArrayList> datosAgregados,Connection connection) {
        destino = ESTACARPETA+File.separator+"Pdfs";
        this.destinoString=destinoString;
        currencyformatter= NumberFormat.getCurrencyInstance();
        arrayListcliente=new ArrayList<>();
        arrayListUsuario = new ArrayList<>();
        Image logo = null;
        try {
            destino=destino+File.separator+destinoString+(Instant.now()).toEpochMilli()+".pdf";
            this.writer=new PdfWriter(destino);
            this.connection=connection;
            
            PdfDocument pdf = new PdfDocument(writer);
            Document document;
            document = new Document(pdf, PageSize.A4);
            document.setMargins(20, 20, 20, 15);
            
            
            SolidLine lineDrawer = new SolidLine();
            lineDrawer.setColor(com.itextpdf.kernel.color.Color.convertCmykToRgb(DeviceCmyk.BLACK));
            LineSeparator lineahorSeparator= new LineSeparator(lineDrawer);
            Table tablecliente1 = new Table(new float[]{30,40,30});
            Table tablecliente2 = new Table(new float[]{40,30,30});
            Table facturacion = new Table(new float[]{100});
            Table prods = new Table(new float[]{20,20,20,20,20});
            Table userTable = new Table(new float[]{17,17,32,17,17});
            userTable.setWidthPercent(40);
            tablecliente1.setWidthPercent(100);
            tablecliente2.setWidthPercent(100);
            facturacion.setWidthPercent(100);
            prods.setWidthPercent(100);
            //Table table = new Table(new float[]{5,4,2,2,4});
            //table.setWidth(75);
            System.out.println(nombreCliente);
            String sql="Select * from Clientes WHERE clientes.nombreCliente='"+nombreCliente+"'";
            System.out.println(sql+"pronblemaaaaaaaaaaaaaaaaaa");
            Statement st;
            try {
                st = connection.createStatement();
                ResultSet result = st.executeQuery(sql);
                while (result.next()) {
                    arrayListcliente.add(result.getString(1));
                    arrayListcliente.add(result.getString(2));
                    arrayListcliente.add(result.getString(6));
                    arrayListcliente.add(result.getString(4));
                    arrayListcliente.add(result.getString(5));
                    arrayListcliente.add(result.getString(10));
                    arrayListcliente.add(result.getString(2));
                    arrayListcliente.add(result.getString(8));
                    arrayListcliente.add(result.getString(9));
                    arrayListcliente.add(result.getString(10));
                    arrayListcliente.add(result.getString(3));
                    
                }
                
   
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            int j=0;
                for (String listcliente : arrayListcliente) {
                    if(listcliente.isEmpty()){
                        arrayListcliente.set(j,"null");
                        
                    }
                    j++;
                }
                String []arrayuser= nombreUsuario.split(" +\\|\\| +");
                sql="Select * from USUARIOS WHERE (USUARIOS.nombreEmpresa='"+arrayuser[0]+"' AND USUARIOS.NIF='"+arrayuser[1]+"')";
                System.out.println(sql);
            try {
                st = connection.createStatement();
                ResultSet result = st.executeQuery(sql);
                while (result.next()) {
                    
                arrayListUsuario.add(result.getString(1));
                arrayListUsuario.add(result.getString(2));
                arrayListUsuario.add(result.getString(3));
                arrayListUsuario.add(result.getString(4));
                arrayListUsuario.add(result.getString(5));
                arrayListUsuario.add(result.getString(6));
                arrayListUsuario.add(result.getString(7));
                arrayListUsuario.add(String.valueOf(result.getBoolean(8)));
                arrayListUsuario.add(result.getString(9));
                empresa=result.getBoolean(8);
                
                }
                
   
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            j=0;
                for (String listcliente : arrayListUsuario) {
                    if(listcliente.isEmpty()){
                        arrayListUsuario.set(j,"null");
                        
                    }
                    j++;
                }
            String datospersonales;
            if (!arrayListUsuario.get(8).equals("")) {
                logoemp=arrayListUsuario.get(8);
            }
            try {
                logo = new Image(ImageDataFactory.create(logoemp));
            } catch (Exception e) {
                e.printStackTrace();
            }
            logo.scaleToFit(150, 150);
            if(empresa){
            datospersonales="Razon social\\|Domicilio fiscal\\|NIF\\|Telefono\\|Correo Elec.";
            }else{
            datospersonales="Nombre\\|Domicilio\\|DNI/NIE\\|Telefono\\|Correo Elec.";
            }
            List listuser= new List().setListSymbol("");
            listuser.add(new ListItem(arrayListUsuario.get(0)))
                    .add(new ListItem(arrayListUsuario.get(6)+" "+arrayListUsuario.get(2)))
                    .add(new ListItem(arrayListUsuario.get(3)))
                    .add(new ListItem(arrayListUsuario.get(4)))
                    .add(new ListItem(arrayListUsuario.get(5)));
            Table tablaprin = new Table(new float[]{60,40});
            tablaprin.addCell(getCell(logo,TextAlignment.LEFT))
                    .addCell(getCell(listuser, TextAlignment.RIGHT));
            tablaprin.setWidthPercent(100);
            process(userTable, datospersonales, false);
            String datosuser=arrayListUsuario.get(0)+"\\|"+arrayListUsuario.get(6)+" "+arrayListUsuario.get(2)+"\\|"+arrayListUsuario.get(3)+"\\|"+arrayListUsuario.get(4)+"\\|"+arrayListUsuario.get(5);
            process(userTable, datosuser, false);
            String datoscliente1 = "Nombre Cliente\\|Direccion\\|DNI/NIE";
            process(tablecliente1, datoscliente1, false);
            String stringcliente1 = arrayListcliente.get(0)+"\\|"+arrayListcliente.get(1)+"\\|"+arrayListcliente.get(2);
            process(tablecliente1, stringcliente1, false);
            String datoscliente2 = "E-Mail\\|Teléfono\\|Codigo postal";
            process(tablecliente2, datoscliente2, false);
            String stringcliente2 = arrayListcliente.get(3)+"\\|"+arrayListcliente.get(4)+"\\|"+arrayListcliente.get(5);
            process(tablecliente2, stringcliente2, false);
            String direccionfacturacion;
            direccionfacturacion=arrayListcliente.get(6)+" "+arrayListcliente.get(7)+" "+arrayListcliente.get(8)+" "+arrayListcliente.get(9)+" "+arrayListcliente.get(10);
            String dfacturacion = "Direccion de facturacion";
            process(facturacion, dfacturacion, false);
            process(facturacion, direccionfacturacion, false);
            String tablaprods ="Nombre Producto\\|Precio Unidad\\|Numero Unidades\\|Iva Aplicado\\|Precio total c/IVA";
            process(prods, tablaprods, true);
            
            
            float preciototalapagar=0;
            
            for (ArrayList datosAgregado : datosAgregados) {
                String datosaprocesar = datosAgregado.get(0)+"\\|"+currencyformatter.format(Float.valueOf(String.valueOf(datosAgregado.get(1))))+"\\|"+datosAgregado.get(2)+"\\|"+datosAgregado.get(3)+"%"+"\\|"+currencyformatter.format(Float.valueOf(String.valueOf(datosAgregado.get(4))));
                process(prods, datosaprocesar, false);
                preciototalapagar=preciototalapagar+Float.valueOf(datosAgregado.get(4).toString());
            }
            Table precioapagar = new Table(new float[]{100});
            precioapagar.setWidthPercent(25);
            precioapagar.setTextAlignment(TextAlignment.CENTER);
            precioapagar.setHorizontalAlignment(HorizontalAlignment.RIGHT);
            process(precioapagar, "Precio total a pagar", false);
            process(precioapagar, currencyformatter.format(preciototalapagar), false);
            listuser.setHorizontalAlignment(HorizontalAlignment.RIGHT);
            document.add(tablaprin);
            
            document.add(lineahorSeparator.setMargins(20, 0, 5, 0));
            document.add(tablecliente1);
            document.add(tablecliente2.setMargins(20, 0, 15, 0));
            document.add(facturacion.setMargins(0, 0, 20, 0));
            document.add(prods);
            document.add(precioapagar.setMargins(20, 0, 15, 0));
            document.close();
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(PanelPresupuesto.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
    public PdfPresupuesto(String destinoString,String nombreCliente,String facturacionString,String nombreUsuario,ArrayList<ArrayList> datosAgregados,Connection connection) {
        destino = ESTACARPETA+File.separator+"Pdfs";
        this.destinoString=destinoString;
        this.facturacionString=facturacionString;
        arrayListcliente=new ArrayList<>();
        arrayListUsuario = new ArrayList<>();
        Image logo = null;
        try {
            destino=destino+File.separator+destinoString+(Instant.now()).toEpochMilli()+".pdf";
            this.writer=new PdfWriter(destino);
            this.connection=connection;
            try {
                logo = new Image(ImageDataFactory.create(logoemp));
            } catch (Exception e) {
                e.printStackTrace();
            }
            PdfDocument pdf = new PdfDocument(writer);
            Document document;
            document = new Document(pdf, PageSize.A4);
            document.setMargins(20, 20, 20, 15);
            
            SolidLine lineDrawer = new SolidLine();
            lineDrawer.setColor(com.itextpdf.kernel.color.Color.convertCmykToRgb(DeviceCmyk.BLACK));
            LineSeparator lineahorSeparator= new LineSeparator(lineDrawer);
            Table tablecliente1 = new Table(new float[]{30,40,30});
            Table tablecliente2 = new Table(new float[]{40,30,30});
            Table facturacion = new Table(new float[]{100});
            Table prods = new Table(new float[]{20,20,20,20,20});
            Table userTable = new Table(new float[]{17,17,32,17,17});
            userTable.setWidthPercent(40);
            tablecliente1.setWidthPercent(100);
            tablecliente2.setWidthPercent(100);
            facturacion.setWidthPercent(100);
            prods.setWidthPercent(100);
            //Table table = new Table(new float[]{5,4,2,2,4});
            //table.setWidth(75);
            System.out.println(nombreCliente);
            String sql="Select * from Clientes WHERE clientes.nombreCliente='"+nombreCliente+"'";
            Statement st;
            try {
                st = connection.createStatement();
                ResultSet result = st.executeQuery(sql);
                while (result.next()) {
                    arrayListcliente.add(result.getString(1));
                    arrayListcliente.add(result.getString(2));
                    arrayListcliente.add(result.getString(6));
                    arrayListcliente.add(result.getString(4));
                    arrayListcliente.add(result.getString(5));
                    arrayListcliente.add(result.getString(10));
                    arrayListcliente.add(result.getString(2));
                    arrayListcliente.add(result.getString(8));
                    arrayListcliente.add(result.getString(9));
                    arrayListcliente.add(result.getString(10));
                    arrayListcliente.add(result.getString(3));
                    
                }
                
   
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            int j=0;
                for (String listcliente : arrayListcliente) {
                    if(listcliente.isEmpty()){
                        arrayListcliente.set(j,"null");
                        
                    }
                    j++;
                }
                String []arrayuser= nombreUsuario.split(" +\\|\\| +");
                sql="Select * from USUARIOS WHERE (USUARIOS.nombreEmpresa='"+arrayuser[0]+"' AND USUARIOS.NIF='"+arrayuser[1]+"')";
                System.out.println(sql);
            try {
                st = connection.createStatement();
                ResultSet result = st.executeQuery(sql);
                while (result.next()) {
                    
                arrayListUsuario.add(result.getString(1));
                arrayListUsuario.add(result.getString(2));
                arrayListUsuario.add(result.getString(3));
                arrayListUsuario.add(result.getString(4));
                arrayListUsuario.add(result.getString(5));
                arrayListUsuario.add(result.getString(6));
                arrayListUsuario.add(result.getString(7));
                arrayListUsuario.add(String.valueOf(result.getBoolean(8)));
                
                empresa=result.getBoolean(8);
                }
                
   
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            j=0;
                for (String listcliente : arrayListUsuario) {
                    if(listcliente.isEmpty()){
                        arrayListUsuario.set(j,"null");
                        
                    }
                    j++;
                }
            String datospersonales;
            if (!arrayListUsuario.get(8).equals("")) {
                logoemp=arrayListUsuario.get(8);
            }
            try {
                logo = new Image(ImageDataFactory.create(logoemp));
            } catch (Exception e) {
                e.printStackTrace();
            }
            logo.scaleToFit(150, 150);
            if(empresa){
            datospersonales="Razon social\\|Domicilio fiscal\\|NIF\\|Telefono\\|Correo Elec.";
            }else{
            datospersonales="Nombre\\|Domicilio\\|DNI/NIE\\|Telefono\\|Correo Elec.";
            }
            List listuser= new List().setListSymbol("");
            listuser.add(new ListItem(arrayListUsuario.get(0)))
                    .add(new ListItem(arrayListUsuario.get(6)+" "+arrayListUsuario.get(2)))
                    .add(new ListItem(arrayListUsuario.get(3)))
                    .add(new ListItem(arrayListUsuario.get(4)))
                    .add(new ListItem(arrayListUsuario.get(5)));
            Table tablaprin = new Table(new float[]{60,40});
            tablaprin.addCell(getCell(logo,TextAlignment.LEFT))
                    .addCell(getCell(listuser, TextAlignment.RIGHT));
            tablaprin.setWidthPercent(100);
            process(userTable, datospersonales, false);
            String datosuser=arrayListUsuario.get(0)+"\\|"+arrayListUsuario.get(6)+" "+arrayListUsuario.get(2)+"\\|"+arrayListUsuario.get(3)+"\\|"+arrayListUsuario.get(4)+"\\|"+arrayListUsuario.get(5);
            process(userTable, datosuser, false);
            String datoscliente1 = "Nombre Cliente\\|Direccion\\|DNI/NIE";
            process(tablecliente1, datoscliente1, false);
            String stringcliente1 = arrayListcliente.get(0)+"\\|"+arrayListcliente.get(1)+"\\|"+arrayListcliente.get(2);
            process(tablecliente1, stringcliente1, false);
            String datoscliente2 = "E-Mail\\|Teléfono\\|Codigo postal";
            process(tablecliente2, datoscliente2, false);
            String stringcliente2 = arrayListcliente.get(3)+"\\|"+arrayListcliente.get(4)+"\\|"+arrayListcliente.get(5);
            process(tablecliente2, stringcliente2, false);
            String direccionfacturacion;
            direccionfacturacion=facturacionString;
            String dfacturacion = "Direccion de facturacion";
            process(facturacion, dfacturacion, false);
            process(facturacion, direccionfacturacion, false);
            String tablaprods ="Nombre Producto\\|Precio Unidad\\|Numero Unidades\\|Iva Aplicado\\|Precio total c/IVA";
            process(prods, tablaprods, true);
            
            
            float preciototalapagar=0;
            
            for (ArrayList datosAgregado : datosAgregados) {
                String datosaprocesar = datosAgregado.get(0)+"\\|"+currencyformatter.format(Float.valueOf(String.valueOf(datosAgregado.get(1))))+"\\|"+datosAgregado.get(2)+"\\|"+datosAgregado.get(3)+"%"+"\\|"+currencyformatter.format(Float.valueOf(String.valueOf(datosAgregado.get(4))));
                process(prods, datosaprocesar, false);
                preciototalapagar=preciototalapagar+Float.valueOf(datosAgregado.get(4).toString());
            }
            Table precioapagar = new Table(new float[]{100});
            precioapagar.setWidthPercent(25);
            precioapagar.setTextAlignment(TextAlignment.CENTER);
            precioapagar.setHorizontalAlignment(HorizontalAlignment.RIGHT);
            process(precioapagar, "Precio total a pagar", false);
            process(precioapagar, currencyformatter.format(preciototalapagar), false);
            listuser.setHorizontalAlignment(HorizontalAlignment.RIGHT);
            document.add(tablaprin);
            
            document.add(lineahorSeparator.setMargins(20, 0, 5, 0));
            document.add(tablecliente1);
            document.add(tablecliente2.setMargins(20, 0, 15, 0));
            document.add(facturacion.setMargins(0, 0, 20, 0));
            document.add(prods);
            document.add(precioapagar.setMargins(20, 0, 15, 0));
            document.close();
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(PanelPresupuesto.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
    private Cell getCell(List text, TextAlignment alignment) {
    Cell cell = new Cell().add((text));
    cell.setPadding(0);
    cell.setTextAlignment(alignment);
    cell.setBorder(Border.NO_BORDER);
    return cell;
    }
    private Cell getCell(Image logo, TextAlignment alignment) {
    Cell cell = new Cell().add(logo);
    cell.setPadding(0);
    cell.setTextAlignment(alignment);
    cell.setBorder(Border.NO_BORDER);
    return cell;
}
    
    
    

    private void process(Table table, String stroing, boolean isHeader){
        StringTokenizer tokenizer = new StringTokenizer(stroing,"\\|");
        while(tokenizer.hasMoreTokens()){
        if(isHeader){
        Cell cell1 = new Cell().add(new Paragraph(tokenizer.nextToken()));
        cell1.setTextAlignment(TextAlignment.CENTER);
        table.addHeaderCell(cell1);
        
        }else{
        Cell cell1 = new Cell().add(new Paragraph(tokenizer.nextToken()));
        cell1.setTextAlignment(TextAlignment.CENTER);
        table.addHeaderCell(cell1);
        }
        }
    }
}

