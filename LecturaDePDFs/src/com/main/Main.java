package com.main;

import java.util.List;

import com.readPdf.PdfFile;

public class Main {
    public static void main(String[] args) {
        PdfFile pdfFile = new PdfFile();

        String rutaCarpeta = "C:\\Users\\usuario\\eclipse-workspace\\AitaOpos\\Temario";

        List<List<String>> todosLosPDFs = pdfFile.getContentsFromFolder(rutaCarpeta);
 
        for (int i = 0; i < todosLosPDFs.size(); i++) {
            System.out.println("PDF " + (i + 1) + ":");
            List<String> paginas = todosLosPDFs.get(i);
            for (int j = 0; j < paginas.size(); j++) {
                System.out.println("Página " + (j + 1) + ":\n" + paginas.get(j));
            }
            System.out.println("----------------------------------");
        }
    }
}

