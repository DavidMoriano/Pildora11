package com.stylePdf;

import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.Phrase;

import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;

public class PdfStyle { //Si quiero estilar la tabla, tengo que usar otro paquete
    public static void stylePdf(File input, File output) throws Exception {
        PdfReader reader = new PdfReader(input.getAbsolutePath());
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(output));

        int n = reader.getNumberOfPages();
        Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.WHITE);
        Font footerFont = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.GRAY);

        for (int i = 1; i <= n; i++) {
            PdfContentByte over = stamper.getOverContent(i);

            over.saveState();
            over.setColorFill(new BaseColor(0, 121, 182)); 
            over.rectangle(0, reader.getPageSize(i).getHeight() - 30, 
                           reader.getPageSize(i).getWidth(), 30);
            over.fill();
            over.restoreState();

            ColumnText.showTextAligned(
                over, Element.ALIGN_LEFT,
                new Phrase("Mi Documento Estilizado", headerFont),
                40, reader.getPageSize(i).getHeight() - 18, 0
            );

            ColumnText.showTextAligned(
                over, Element.ALIGN_RIGHT,
                new Phrase(String.format("Página %d de %d", i, n), footerFont),
                reader.getPageSize(i).getWidth() / 2, 20, 0
            );
        }

        stamper.close();
        reader.close();
        System.out.println("Archivo " + output + " generado");
    }
}

