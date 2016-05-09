package io.com.becks.test;

import java.io.*;

/**
 * 字节流
 * 范例：使用字节流FileOutputStream往文件里写入内容
 * FileInputStream和FileOutputStream这两个流都是字节流，都是以一个字节为单位进行输入和输出的。
 * 所以对于占用2个字节存储空间的字符来说读取出来时就会显示成乱码。
 */
public class testFileOutputStream {

	public static void main(String[] args) {
		int b = 0;
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("/Users/Becks/Documents/io/FileInputStream.txt");
			// 如果写入内容的文件不存在，系统会自动创建一个
			out = new FileOutputStream("/Users/Becks/Documents/io/FileOutputStream.txt");
			while ((b = in.read()) != -1){ // -1表示读取到文件末尾
				out.write(b);// 调用write(int c)方法把读取到的字符全部写入到指定文件中去
			}
			in.close();
			out.close();
		} catch (Exception e) {
			System.out.println("复制文件失败！");
			System.exit(-1);// 系统非正常推出
		}
		System.out.println("文件已经成功复制！");
	}

}
