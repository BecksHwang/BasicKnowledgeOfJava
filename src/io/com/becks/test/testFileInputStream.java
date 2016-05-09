package io.com.becks.test;

import java.io.*;

/**
 * 字节流
 * 范例：使用字节流FileInputStream读取文件内容
 * 使用FileInputStream流来读取有中文的内容时，读出来的是乱码，因为使用InputStream流里面的read()
 * 方法读取内容时是一个字节一个字节地读取的，而一个汉字是占用两个字节的，所以读取出来的汉字无法正确显示。
 * 
 */
public class testFileInputStream {

	public static void main(String[] args) {
		int b = 0;
		FileInputStream in =null;
		try {
			in = new FileInputStream("/Users/Becks/Documents/io/FileInputStream.txt");
		} catch (Exception e) {
			System.out.println("找不到文件！");
			System.exit(-1);//系统非正常推出
		}
		int count = 0;//记录取得的字符数
		try {//调用read()方法时会抛异常，所以需要捕获异常
			while ((b = in.read()) != -1) {//-1表示读取到文件末尾
				System.out.print((char)b);//需要强制转换为char类型，不然读出来的是数字
				count++;
			}
			in.close();
			System.out.println();
			System.out.println("读取的字节数量："+ count);
		} catch (Exception e) {
			System.out.println("读取文件错误！");
		}
	}

}
