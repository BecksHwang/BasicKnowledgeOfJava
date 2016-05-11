package test.com.becks.test;

public class test1 {
	
	public static void main(String[] args) {
		int i=0;
		addI(i);
		i++;
		System.out.println(i);//输出结果明明是1，今天的小哥偏说是0，还说他写过－。－
	}
	
	static void addI(int i){
		i++;
	}

}
