package io.com.becks.test;

import java.io.*;

/**
 * 处理流：你要是对原始的流不满意，你可以在这根管道外面再套其它的管道，套在其它管道之上的流叫处理流。为什么需要处理流呢？这就跟水流里面有杂质，你要过滤它，
 * 你可以再套一层管道过滤这些杂质一样。
 * 
 * 范例：打印流（处理流的一种）
 * 
 */
public class TestPrintStream {

	public static void main(String[] args) {
		PrintStream ps = null;
		try {
			FileOutputStream fos = new FileOutputStream("/Users/Becks/Documents/io/log.txt");
			ps = new PrintStream(fos);// 在输出流的外面套接一层打印流，用来控制打印输出
			if (ps != null) {
				System.setOut(ps);// 这里调用setOut()方法改变了输出窗口，以前写System.out.print()默认的输出窗口就是命令行窗口.
				// 但现在使用System.setOut(ps)将打印输出窗口改成了由ps指定的文件里面，通过这样设置以后，打印输出时都会在指定的文件内打印输出
				// 在这里将打印输出窗口设置到了log.txt这个文件里面，所以打印出来的内容会在log.txt这个文件里面看到
			}
			for (char c = 35000; c <= 36000; c++) {
				System.out.print(c + "－");// 把文字打印到log.txt这个文件中去
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
