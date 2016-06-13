package test.com.becks.test;

public class testInteger {

	public static void main(String[] args) {
		int a1 = 10;
		int a2 = 1000;
		Integer a3 = 10;
		Integer a32 = 10;
		Integer a4 = 1000;
		Integer a5 = new Integer(10);
		Integer a6 = new Integer(1000);
		Integer a7 = new Integer(1000);
		Integer a8 = new Integer(10);

		boolean b1 = a1 == Integer.valueOf(a1);//true
		boolean b2 = a2 == Integer.valueOf(a2);//true
		boolean b3 = a3 == Integer.valueOf(a1);//true
		boolean b4 = a4 == Integer.valueOf(a2);//false
		boolean b5 = a5 == a3;//false
		boolean b6 = a6 == a7;//false
		boolean b7 = a5 == a8;//false
		boolean b8 = a3 == a32;//true

		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		System.out.println(b5);
		System.out.println(b6);
		System.out.println(b7);
		System.out.println(b8);

	}

}
/**
 * ①无论如何，Integer与new Integer不会相等。不会经历拆箱过程，一个的引用指向堆，而另一个指向专门存放他的内存（常量池），他们的内存地址不一样，所以为false
 * ②两个都是非new出来的Integer，如果数在-128到127之间，则是true,否则为false
 * java在编译Integer i2 = 128的时候,被翻译成-> Integer i2 = Integer.valueOf(128);而valueOf()函数会对-128到127之间的数进行缓存
 * ③两个都是new出来的,都为false
 * ④int和integer(无论new否)比，都为true，因为会把Integer自动拆箱为int再去比。注意：若使用到valueof()需在－128到127之间才有效。
 **/
