package io.com.becks.test;

import java.io.*;

/**
 * 字符流
 * FileReader和FileWriter这两个流都是字符流，都是以一个字符为单位进行输入和输出的。所以读取和写入占用2个字节的字符时都可以正常地显示出来(中文)
 * ，以上是以File(文件)这个类型为例对节点流进行了讲解，所谓的节点流指定就是直接把输入流或输出插入到数据源上，直接往数据源里面写入数据或读取数据。
 */
public class TestFileWriterAndFileReader {

	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("/Users/Becks/Documents/io/FileWriter.txt");
			// 字符的本质是一个无符号的16位整数
			// 字符在计算机内部占用2个字节
			// 这里使用for循环把31000～35000里面的所有整数都输出
			// 这里相当于是把部分的文字都31000～35000内的整数的形式来表示
			for (int c = 31000; c <= 35000; c++) {
				fw.write(c);
				// 使用write(int c)把31000～35000内的整数写入到指定文件内
				// 调用write()方法时，我认为在执行的过程中应该使用了“(char)c”进行强制转换，即把整数转换成字符来显示
				// 因为打开写入数据的文件可以看到，里面显示的数据并不是31000～35000内的整数，而是文字的表示方式
			}
			/*
			 * 使用FileReader(字符流)读取指定文件里面的内容 读取内容时是以一个字符为单位进行读取的
			 */
			int b = 0;
			long count = 0;
			FileReader fr = null;
			fr = new FileReader("/Users/Becks/Documents/io/FileWriter.txt");
			while ((b = fr.read()) != -1) {
				System.out.print((char) b + "－");
				count++;
			}
			System.out.println();
			System.out.println("总共读取了" + count + "个字符");
			fw.close();
			fr.close();
		} catch (Exception e) {

		}
	}

}
