package Json.com.becks.test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class StringToJsonTest {

	public static void main(String[] args) {
		String str = "{people:[{name:becsk,age:18},{name:hwang,age:19}]}";
		JSONObject jo = JSONObject.fromObject(str);
		JSONArray ja = jo.getJSONArray("people");
		for (int i = 0; i < ja.size(); i++) {
			JSONObject jso = (JSONObject) ja.get(i);
			System.out.println(jso.getString("name"));
		}
	}

}
