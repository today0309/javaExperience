package com.ztw.io;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor;


/**
 * 从URL中获取PDF
 * 
 * @author Administrator
 *
 */
public class ReadPdfFromURL {

	/**
	 * 从网络Url中下载文件
	 * 
	 * @param urlStr
	 * @param fileName
	 * @param savePath
	 * @throws IOException
	 */
	public static void downLoadByUrl(String urlStr, String fileName, String savePath) throws IOException {
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// 设置超时间为3秒
		conn.setConnectTimeout(5 * 1000);
		// 防止屏蔽程序抓取而返回403错误
		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		// 得到输入流
		InputStream inputStream = conn.getInputStream();
		// 获取自己数组
		byte[] getData = readInputStream(inputStream);
		// 文件保存位置
		File saveDir = new File(savePath);
		if (!saveDir.exists()) {
			saveDir.mkdir();
		}
		File file = new File(saveDir + File.separator + fileName);
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(getData);
		if (fos != null) {
			fos.close();
		}
		if (inputStream != null) {
			inputStream.close();
		}
		System.out.println("info:" + url + " download success");

	}

	/**
	 * 从输入流中获取字节数组
	 * 
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	public static byte[] readInputStream(InputStream inputStream) throws IOException {
		byte[] buffer = new byte[1024];
		int len = 0;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while ((len = inputStream.read(buffer)) != -1) {
			bos.write(buffer, 0, len);
		}
		bos.close();
		return bos.toByteArray();
	}

	public static void pdf2txt(String filename) throws IOException {
		PdfReader reader = new PdfReader(filename); // 读取pdf所使用的输出流
		PdfDocument pdf = new PdfDocument(reader);
		int num = pdf.getNumberOfPages();// 获得页数
		String content = ""; // 存放读取出的文档内容
		for (int i = 1; i <= num; i++) {
			content += PdfTextExtractor.getTextFromPage(pdf.getPage(i)); // 读取第i页的文档内容
		}
		pdf.close();
		PrintWriter writer = new PrintWriter(new FileOutputStream("D:/pdf/test.txt"));//txt文件写入流
		writer.write(content);// 写入文件内容
		writer.flush();
		writer.close();
	}

	public static void main(String[] args) {
		try {
			String url = "http://www.neeq.com.cn/disclosure/2017/2017-06-22/1498119127_781983.pdf";
			downLoadByUrl(url, "test.pdf", "D:/pdf");
			pdf2txt("D:/pdf/test.pdf");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
