package org.ynn.itextpdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

//为生成的PDF加密，用户通过密码才能查看文件内容
public class createPDFSecurity {

	private static String USER_PASSWORD = "hello";
	private static String OWNER_PASSWORD = "world";
	private static String DEST = "results/security/createPDFSecurity.pdf";
	
	public static void main(String args[]) throws FileNotFoundException, DocumentException{
		File file = new File(DEST);
		file.getParentFile().mkdirs();
		
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(DEST));
		//设置密码和权限
		writer.setEncryption(USER_PASSWORD.getBytes(), 
				OWNER_PASSWORD.getBytes(), PdfWriter.ALLOW_PRINTING, 
				PdfWriter.ENCRYPTION_AES_128);
		
		document.open();
		document.add(new Phrase("set security for pdf!"));
		document.close();
		writer.close();
	}
}
