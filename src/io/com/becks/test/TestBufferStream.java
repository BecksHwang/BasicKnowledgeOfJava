package io.com.becks.test;

import java.io.*;

/**
 * 处理流：你要是对原始的流不满意，你可以在这根管道外面再套其它的管道，套在其它管道之上的流叫处理流。为什么需要处理流呢？这就跟水流里面有杂质，你要过滤它，
 * 你可以再套一层管道过滤这些杂质一样。
 * 
 * 范例：缓冲流（处理流的一种）
 * 先把数据放置到缓冲区上，等到缓冲区满了以后，再一次把缓冲区里面的数据写入到硬盘上或者读取出来，这样可以有效地减少对硬盘的访问次数，有利于保护我们的硬盘。
 */
public class TestBufferStream {

	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("/Users/Becks/Documents/io/FileInputStream.txt");
			// 在FileInputStream节点流的外面套接一层处理流BufferedInputStream
			BufferedInputStream bis = new BufferedInputStream(fis);
			int c = 0;
			System.out.println((char) bis.read());
			System.out.println((char) bis.read());
			bis.mark(100);// 在第100个字符处做一个标记
			for (int i = 0; i <= 10 && (c = bis.read()) != -1; i++) {
				System.out.print((char) c);
			}
			System.out.println();
			bis.reset();// 重新回到原来标记的地方
			for (int i = 0; i <= 10 && (c = bis.read()) != -1; i++) {
				System.out.print((char) c);
			}
			bis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}
