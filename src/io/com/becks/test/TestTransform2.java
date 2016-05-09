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
public class TestTransform2 {

	public static void main(String[] args) {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			// System.in这里的in是一个标准的输入流，用来接收从键盘输入的数据
			BufferedReader br = new BufferedReader(isr);
			String s = null;
			s = br.readLine();// 使用readLine()方法把读取到的一行字符串保存到字符串变量s中去
			while (s != null) {
				System.out.println(s.toUpperCase());// 把保存在内存s中的字符串打印出来
				s = br.readLine();// 在循环体内继续接收从键盘的输入
				if (s.equalsIgnoreCase("exit")) {
					// 只要输入exit循环就结束，就会退出
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
