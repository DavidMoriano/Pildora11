package com.main;

import java.io.File;

import com.model.entities.Article;
import com.stylePdf.PdfStyle;
import com.utils.ExportFile.CsvFile;
import com.utils.ExportFile.PdfFile;
import com.utils.ExportFile.XlsFile;

public class Main {

	public static void main(String[] args) throws Exception {
		String csvFile = "articulosCsv.csv";
		String excelFile = "articulosExcel.xls";
		File pdfStyled = new File(excelFile.split("\\.")[0] + "_estilado.pdf");
		
		Article ar = new Article();
		
		CsvFile.exportarACSV(ar.getListArticle(), csvFile);
		XlsFile.createExcelFile(ar.getListArticle(), excelFile);
		PdfStyle.stylePdf(PdfFile.addPdfFile(excelFile), pdfStyled);
		

	}

}
