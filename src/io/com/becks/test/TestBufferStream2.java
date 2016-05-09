package io.com.becks.test;

import java.io.*;

/**
 * 处理流：你要是对原始的流不满意，你可以在这根管道外面再套其它的管道，套在其它管道之上的流叫处理流。为什么需要处理流呢？这就跟水流里面有杂质，你要过滤它，
 * 你可以再套一层管道过滤这些杂质一样。
 * 
 * 范例：缓冲流（处理流的一种）
 * 先把数据放置到缓冲区上，等到缓冲区满了以后，再一次把缓冲区里面的数据写入到硬盘上或者读取出来，这样可以有效地减少对硬盘的访问次数，有利于保护我们的硬盘。
 */
public class TestBufferStream2 {

	public static void main(String[] args) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/Becks/Documents/io/FileWriter.txt"));
			// 在节点流FileWriter的外面再套一层处理流BufferedWriter
			String s = null;
			for (int i = 0; i < 100; i++) {
				s = String.valueOf(Math.random());// “Math.random()”将会生成一系列介于0～1之间的随机数。
				// static String valueOf(double
				// d)这个valueOf()方法的作用就是把一个double类型的数转换成字符串
				// valueOf()是一个静态方法，所以可以使用“类型.静态方法名”的形式来调用
				bw.write(s);// 把随机数字符串写入到指定文件中
				bw.newLine();// 调用newLine()方法使得每写入一个随机数就换行显示
			}
			bw.flush();// 调用flush()方法清空缓冲区

			BufferedReader br = new BufferedReader(new FileReader("/Users/Becks/Documents/io/FileWriter.txt"));
			// 在节点流FileReader的外面再套一层处理流BufferedReader
			while ((s = br.readLine()) != null) {
				// 使用BufferedReader处理流里面提供String readLine()方法读取文件中的数据时是一行一行读取的
				// 循环结束的条件就是使用readLine()方法读取数据返回的字符串为空值后则表示已经读取到文件的末尾了。
				System.out.println(s);

			}
			bw.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
