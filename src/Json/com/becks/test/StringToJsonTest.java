package Json.com.becks.test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class StringToJsonTest {

	public static void main(String[] args) {
		String str = "{people:[{name:'becsk',age:18},{name:'hwang',age:19}]}";
		System.out.println(str);
		JSONObject jo = JSONObject.fromObject(str);
		JSONArray ja = jo.getJSONArray("people");
		for (int i = 0; i < ja.size(); i++) {
			JSONObject jso = (JSONObject) ja.get(i);
			System.out.println(jso.getString("name"));
		}
	}

}
/* 报错：Exception in thread "main" java.lang.NoClassDefFoundError:
 * 
 * 原因：jar包引用不完全
 * 
 * 解决办法：引用jar包 commons-lang-2.3.jar
 * 					ezmorp-1.0.3.jar
 * 					commons-beanutils-1.7.0.jar
 * 					commons-collections-3.2.1.jar
 * 					commons-httpclient-3.1.jar
 * 					commons-logging-1.1.1.jar
 */
