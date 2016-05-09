package io.com.becks.test;

import java.io.*;

/**
 * 处理流：你要是对原始的流不满意，你可以在这根管道外面再套其它的管道，套在其它管道之上的流叫处理流。为什么需要处理流呢？这就跟水流里面有杂质，你要过滤它，
 * 你可以再套一层管道过滤这些杂质一样。
 * 
 * 范例：转换流（处理流的一种）
 * 转换流非常的有用，它可以把一个字节流转换成一个字符流，转换流有两种，一种叫InputStreamReader，另一种叫OutputStreamWriter
 * 。InputStream是字节流，Reader是字符流，InputStreamReader就是把InputStream转换成Reader。
 * OutputStream是字节流，Writer是字符流，OutputStreamWriter就是把OutputStream转换成Writer。
 * 把OutputStream转换成Writer之后就可以一个字符一个字符地通过管道写入数据了，而且还可以写入字符串。
 * 我们如果用一个FileOutputStream流往文件里面写东西，得要一个字节一个字节地写进去，
 * 但是如果我们在FileOutputStream流上面套上一个字符转换流，那我们就可以一个字符串一个字符串地写进去。
 */
public class TestTransform1 {

	public static void main(String[] args) {
		try {
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("/Users/Becks/Documents/io/char.txt"));
			osw.write("JavaIo");// 把字符串写入到指定的文件中去
			System.out.println(osw.getEncoding());// 使用getEncoding()方法取得当前系统的默认字符编码
			osw.close();
			osw = new OutputStreamWriter(new FileOutputStream("/Users/Becks/Documents/io/char.txt", true), "utf-8");
			// 如果在调用FileOutputStream的构造方法时没有加入true，那么新加入的字符串就会替换掉原来写入的字符串，在调用构造方法时指定了字符的编码
			osw.write("JavaIo");// 再次向指定的文件写入字符串，新写入的字符串加入到原来字符串的后面
			System.out.println(osw.getEncoding());
			osw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
