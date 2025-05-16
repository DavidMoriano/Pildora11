package com.utils.ExportFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.model.entities.Article;

public class CsvFile {
	public static void exportarACSV(List<Article> articulos, String file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
        	Article a1 = new Article();
            writer.write(a1.headerString());
            for (Article a : articulos) {
                writer.write(a.toString());
            }
            System.out.println("Archivo " + file + " generado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
