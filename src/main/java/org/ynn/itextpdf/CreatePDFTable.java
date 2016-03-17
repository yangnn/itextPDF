package org.ynn.itextpdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePDFTable {

	public static final String DEST = "results/tables/createPDFTable.pdf";
	
	public static void main(String args[]) throws FileNotFoundException, DocumentException{
		File file = new File(DEST);
		file.getParentFile().mkdirs();
		createTable(DEST);
	}
	
	//PDF中生成table，并设置table的行数、列数
	public static void createTable(String dest) throws FileNotFoundException, DocumentException{
		Document document = new Document(PageSize.A4.rotate());//设置PDF大小
		PdfWriter.getInstance(document, new FileOutputStream(dest));
		
		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100);//设置表格宽度
		
		PdfPCell cell = new PdfPCell(new Phrase("1,1"));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("1,2"));
		table.addCell(cell);
		
		PdfPCell cell23 = new PdfPCell(new Phrase("1,3and 1,4"));
		cell23.setColspan(2);//占两列
		cell23.setRowspan(2);//占2行
		cell23.setBackgroundColor(GrayColor.PINK);//设置背景颜色
		cell23.setHorizontalAlignment(Element.ALIGN_CENTER);//居中对齐
		table.addCell(cell23);
		
		cell = new PdfPCell(new Phrase("2,1"));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("2,2"));
		table.addCell(cell);
		
		document.open();
		document.add(table);
		document.close();
	}
}
