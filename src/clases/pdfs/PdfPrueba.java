/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.pdfs;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.FileNotFoundException;
public class PdfPrueba {
    private static final File ESTACARPETA = new File("").getAbsoluteFile();
    public static String destino = ESTACARPETA+File.separator+"Pdfs";
    PdfWriter writer;
    String destinoString;
    public PdfPrueba(String destinoString) {
        this.destinoString=destinoString;
        try {
            destino=destino+File.separator+destinoString+".pdf";
            this.writer=new PdfWriter(destino);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);
            document.add(new Paragraph("Helo world"));
            document.close();
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(PanelPresupuesto.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
    
}

