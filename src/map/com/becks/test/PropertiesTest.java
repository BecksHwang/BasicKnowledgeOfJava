package map.com.becks.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		Properties props = new Properties();
		// 向Properties中增加属性
		props.setProperty("username", "beckshwang");
		props.setProperty("password", "123456");

		try {
			// 将Properties中的key-value对保存到a.ini文件中,如果没有该文件，会创建一个
			props.store(new FileOutputStream("a.ini"), "comment line");
			// 将Properties中的key-value对保存到a.xml文件中,如果没有该文件，会创建一个
			props.store(new FileOutputStream("a.xml"), "comment line");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 新建Properties对象
		Properties props2 = new Properties();
		Properties props3 = new Properties();
		// 向Properties中增加属性
		props2.setProperty("gender", "male");

		// 将文件中的key-value对追加到props中
		try {
			props2.load(new FileInputStream("a.ini"));
			props3.load(new FileInputStream("a.xml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(props2);
		System.out.println(props3);
	}

}
/**
 * Properties可以把key-value对以XML文件的形式保存起来，也可以从XML文件中加载key-value对
 */
