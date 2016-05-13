package test.com.becks.test;

public class test3 {

	public static void main(String[] args) {
		int i=-1,j=1;
		if(++i<0 && !(j-- > 0)){
			System.out.println("i=" + i + " j=" + j);
		}else{
			System.out.println("j=" + j + " i=" + i);
		}
	}

}
/*
 *输出：j=1 i=0
 *
 *这个题目太容易掉坑里了，&&具有短路功能，因为＋＋i为false,所以后面的j－－并不会执行，j还是原来的1。
 */