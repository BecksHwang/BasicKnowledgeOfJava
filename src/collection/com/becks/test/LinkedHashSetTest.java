package collection.com.becks.test;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {
	public static void main(String[] args) {
		LinkedHashSet books = new LinkedHashSet();
		books.add("Linked");
		books.add("Hash");
		books.add("Set");
		System.out.println(books);

		// 删除 Java
		books.remove("Hash");
		// 重新添加 Java
		books.add("Hash");
		books.add("Linked");
		System.out.println(books);
	}
}
/**
 * 输出结果：[Linked, Hash, Set] [Linked, Set, Hash]
 * 
 * 结论：元素的顺序总是与添加顺序一致，同时要明白的是，LinkedHashSetTest是HashSet的子类，因此它不允许集合元素重复，
 * 所以即使最后add了一个Linked，但是并没有打印出来说明没有添加成功
 * 
 */