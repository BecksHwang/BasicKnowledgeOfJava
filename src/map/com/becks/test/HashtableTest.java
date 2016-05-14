package map.com.becks.test;

import java.util.*;

class A {
	int count;

	public A(int count) {
		this.count = count;
	}

	// 根据count的值来判断两个对象是否相等。
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj != null && obj.getClass() == A.class) {
			A a = (A) obj;
			return this.count == a.count;
		}
		return false;
	}

	// 根据count来返回hashCode值。
	public int hashCode() {
		return this.count;
	}
}

class B {
	// 重写equals()方法，B对象与任何对象通过equals()方法比较都相等
	public boolean equals(Object obj) {
		return true;
	}
}

public class HashtableTest {
	public static void main(String[] args) {
		Hashtable ht = new Hashtable();
		ht.put(new A(1), "Hashtable");
		ht.put(new A(2), "Test");
		ht.put(new A(3), new B());
		System.out.println(ht);

		/*
		 * Hashtable的containsValue()方法使用e.value.equal("字符串")作比较，返回ture,
		 * Hashtable就认为它们是相等的value。 由于Hashtable中有一个B对象，
		 * 所以它与任何对象通过equals比较都返回ture，输出true。
		 */
		System.out.println(ht.containsValue("测试字符串"));

		// 只要两个A对象的count相等，它们通过equals比较返回true，且hashCode相等
		// Hashtable即认为它们是相同的key，所以下面输出true。
		System.out.println(ht.containsKey(new A(2)));

		// 下面语句可以删除最后一个key-value对
		ht.remove(new A(3));

		// 通过返回Hashtable的所有key组成的Set集合，
		// 从而遍历Hashtable每个key-value对
		for (Object key : ht.keySet()) {
			System.out.print(key + "---->");
			System.out.print(ht.get(key) + "\n");
		}

		HashMap hm = new HashMap();
		hm.put(new A(4), "HashMap");
		hm.put(new A(5), "Test");
		hm.put(new A(6), new B());
		System.out.println(hm);

		/*
		 * HashMap的containsValue()方法使用 “字符串”.equals(e.value)作比较，返回ture,
		 * HashMap就认为它们是相等的value。 虽然HashMap中有一个B对象， 但是返回的是false。
		 */
		System.out.println(hm.containsValue("测试字符串"));

		// 只要两个A对象的count相等，它们通过equals比较返回true，且hashCode相等
		// Hashtable即认为它们是相同的key，所以下面输出true。
		System.out.println(hm.containsKey(new A(5)));

		// 下面语句可以删除最后一个key-value对
		hm.remove(new A(6));

		// 通过返回Hashtable的所有key组成的Set集合，
		// 从而遍历Hashtable每个key-value对
		for (Object key : hm.keySet()) {
			System.out.print(key + "---->");
			System.out.print(hm.get(key) + "\n");
		}
	}
}