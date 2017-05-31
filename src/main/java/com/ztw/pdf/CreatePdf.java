package com.ztw.pdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePdf {

	@Test
	public void test001() {
		try {
			File file = new File("D:\\createFile\\test\\");
			if(!file.exists()){
				file.mkdirs();
			}
			
			Document document = new Document();
			BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
			Font font = new Font(bfChinese, 10, Font.NORMAL);
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file + "hello.pdf"));
			document.open();
			document.add(new Paragraph("asdnasasndsa杀到哪都能进萨达就算本地A Hello World PDF document中文测试.", font));
			document.close();
			writer.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
