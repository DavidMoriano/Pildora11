package com.utils.ExportFile;

import java.io.File;
import java.util.List;

import com.model.entities.Article;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class XlsFile {
	public static void createExcelFile(List<Article> articleList, String file) {
		 try {
	            WritableWorkbook workbook = Workbook.createWorkbook(new File(file));
	            WritableSheet sheet = workbook.createSheet("Artículos", 0);

	            // Encabezados
	            sheet.addCell(new Label(0, 0, "ID"));
	            sheet.addCell(new Label(1, 0, "Nombre"));
	            sheet.addCell(new Label(2, 0, "Fungible"));
	            sheet.addCell(new Label(3, 0, "Valor"));

	            // Datos
	            for (int i = 0; i < articleList.size(); i++) {
	                Article a = articleList.get(i);
	                sheet.addCell(new Label(0, i + 1, a.getId()));
	                sheet.addCell(new Label(1, i + 1, a.getName()));
	                sheet.addCell(new Label(2, i + 1, String.valueOf(a.isFungible())));
	                sheet.addCell(new Label(3, i + 1, a.getValue()));
	            }

	            workbook.write();
	            workbook.close();
	            System.out.println("Archivo " + file + " generado.");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
}
