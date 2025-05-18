package com.readPdf;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class PdfFile {

    // Método para leer un único PDF y devolver lista de páginas (texto por página)
    public List<String> getPdfContent(String pdf) throws IOException {
        PdfReader lector = new PdfReader(pdf);
        List<String> pdfContent = new ArrayList<>();
        try {
            for (int i = 1; i <= lector.getNumberOfPages(); i++) {
                String texto = PdfTextExtractor.getTextFromPage(lector, i);
                pdfContent.add(texto);
            }
        } catch(Exception e) {
            System.err.println("Error al leer el PDF: " + e.getMessage());
        } finally {
            lector.close();
        }
        return pdfContent;
    }

    // Nuevo método para procesar todos los PDFs en una carpeta
    public List<List<String>> getContentsFromFolder(String folderPath) {
        List<List<String>> contenidosTodosPDF = new ArrayList<>();

        File carpeta = new File(folderPath);
        if (!carpeta.exists() || !carpeta.isDirectory()) {
            System.err.println("La ruta no es una carpeta válida: " + folderPath);
            return contenidosTodosPDF;
        }

        File[] archivosPDF = carpeta.listFiles((dir, nombre) -> nombre.toLowerCase().endsWith(".pdf"));

        if (archivosPDF == null || archivosPDF.length == 0) {
            System.out.println("No se encontraron archivos PDF en la carpeta: " + folderPath);
            return contenidosTodosPDF;
        }

        for (File archivoPDF : archivosPDF) {
            System.out.println("Leyendo archivo: " + archivoPDF.getName());
            try {
                List<String> contenidoPDF = getPdfContent(archivoPDF.getAbsolutePath());
                contenidosTodosPDF.add(contenidoPDF);
            } catch (IOException e) {
                System.err.println("Error leyendo el archivo " + archivoPDF.getName() + ": " + e.getMessage());
            }
        }

        return contenidosTodosPDF;
    }
}
