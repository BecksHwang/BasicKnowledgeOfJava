package RegularExp.com.becks.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class test {

	public static void main(String[] args) {
		dateMatcher("http://gks.mof.gov.cn/201606/t20160616_2322629.html");
		dateMatcher("http://gks.mof.gov.cn/2016-06/16_2322629.html");
		dateMatcher("http://gks.mof.gov.cn/2016/06/16_2322629.html");
	}
	
	public static void dateMatcher(String url){
		String reg = "[1-9]\\d{3}/?-?(((0[13578]|1[02])/?([0-2]\\d|3[01]))|((0[469]|11)/?([0-2]\\d|30))|(02/?([01]\\d|2[0-8])))" ;
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(url);
		if(matcher.find()){
			System.out.println("匹配到日期类型格式：" + matcher.group());
		}else{
			System.out.println("没匹配到！");
		}
	} 
}
