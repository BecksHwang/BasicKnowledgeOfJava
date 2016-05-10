package collection.com.becks.test;

import java.util.HashSet;

//类A的equals方法总是返回true,但没有重写其hashCode()方法。不能保证当前对象是HashSet中的唯一对象
class A {
	public boolean equals(Object obj) {
		return true;
	}
}

// 类B的hashCode()方法总是返回1,但没有重写其equals()方法。不能保证当前对象是HashSet中的唯一对象
class B {
	public int hashCode() {
		return 1;
	}
}

// 类C的hashCode()方法总是返回2,且有重写其equals()方法
class C {
	public int hashCode() {
		return 2;
	}

	public boolean equals(Object obj) {
		return true;
	}
}

public class HashSetTest {
	public static void main(String[] args) {
		HashSet books = new HashSet();
		// 分别向books集合中添加两个A对象，两个B对象，两个C对象
		books.add(new A());
		books.add(new A());

		books.add(new B());
		books.add(new B());

		books.add(new C());
		books.add(new C());
		System.out.println(books);
	}
}
/**
 * 输出结果： [collection.com.becks.test.B@1, collection.com.becks.test.B@1,
 * collection.com.becks.test.C@2, collection.com.becks.test.A@28b56559,
 * collection.com.becks.test.A@1d10caf0]
 * 
 * 结论：
 * 可以看到HashSet集合判断两个元素相等的标准是1.两个对象通过equals()方法比较相等。2.两个对象的hashCode()方法的返回值相等。
 * HashCode值决定该对象在HashSet中的存储位置。如果两个对象的hashCode相同，但是它们的equlas返回值不同，
 * HashSet会在这个位置用链式结构来保存多个对象。而HashSet访问集合元素时也是根据元素的HashCode值来快速定位的，
 * 这种链式结构会导致性能下降。
 */
