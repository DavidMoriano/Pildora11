package com.utils.ExportFile;

import java.io.File;
import java.io.FileOutputStream;
import jxl.Workbook;
import jxl.Sheet;
import jxl.Cell;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;

public class PdfFile {

	public static File addPdfFile(String file) {
		File pdf = null;
		try {
			Workbook workbook = Workbook.getWorkbook(new File(file));
			Sheet sheet = workbook.getSheet(0);
 
			String baseName = file.split("\\.")[0];
			String pdfPath = baseName + ".pdf";
			pdf = new File(pdfPath);
 
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(pdf));
			document.open();
 
			PdfPTable table = new PdfPTable(sheet.getColumns());
 
			for (int row = 0; row < sheet.getRows(); row++) {
				for (int col = 0; col < sheet.getColumns(); col++) {
					Cell cell = sheet.getCell(col, row);
					table.addCell(cell.getContents());
				}
			}
 
			document.add(table);
			document.close();
			workbook.close();

			System.out.println("Archivo "+ pdfPath + " generado");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pdf;
	}
}
