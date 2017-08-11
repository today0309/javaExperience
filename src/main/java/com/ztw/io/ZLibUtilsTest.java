package com.ztw.io;

/**
 * 2009-9-9
 */

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.junit.Test;

/**
 * ZLib压缩测试用例
 * 
 * @author <a href="mailto:zlex.dongliang@gmail.com">梁栋</a>
 * @version 1.0
 * @since 1.0
 */
public class ZLibUtilsTest {

	@Test
	public final void testBytes() {
		System.err.println("字节压缩／解压缩测试");
		String inputStr = "snowolf@zlex.org;dongliang@zlex.org;zlex.dongliang@zlex.org";
		System.err.println("输入字符串:\t" + inputStr);
		byte[] input = inputStr.getBytes();
		System.err.println("输入字节长度:\t" + input.length);

		byte[] data = ZLibUtils.compress(input);
		System.err.println("压缩后字节长度:\t" + data.length);

		byte[] output = ZLibUtils.decompress(data);
		System.err.println("解压缩后字节长度:\t" + output.length);
		String outputStr = new String(output);
		System.err.println("输出字符串:\t" + outputStr);

		assertEquals(inputStr, outputStr);
	}
	
	public static String[] splitt(String str){
        String strr = str.trim();
        String[] abc = strr.split("[\\p{Space}]+");
        String str1 = abc[0];
        String str2 = abc[1];
        System.out.println(str1);
        System.out.println(str2);
        return abc;
    }

	@Test
	public final void testFile() {
		String filename = "D:/zlibTest/B76DA5AE8EAF045A67B6E64D8A9628AB.txt.zlib";
		File file = new File(filename);
		byte[] output = null;
		try {
			FileInputStream fis = new FileInputStream(file);
			output = ZLibUtils.decompress(fis);
			fis.close();
		} catch (Exception e) {
			fail(e.getMessage());
		}
		try {
			File outFile = new File("D:/zlibTest/B76DA5AE8EAF045A67B6E64D8A9628AB.txt");
			FileOutputStream fos = new FileOutputStream(outFile);
			fos.write(output);
			fos.flush();
			//System.out.println(fos.toString());
			fos.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void test009() throws Exception{
		readTxtFile("D:/zlibTest/B76DA5AE8EAF045A67B6E64D8A9628AB.txt");
	}
	
	public static void readTxtFile(String filePath) {
		String str = "";
		try {
			String encoding = "GBK";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					str += lineTxt;
				}
				read.close();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		System.out.println(str);
	}
     
	
}


