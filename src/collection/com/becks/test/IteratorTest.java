package collection.com.becks.test;

import java.util.*;

public class IteratorTest {

	public static void main(String[] args) {
		
		System.out.println("ArrayList:");
		List books1 = new ArrayList();
        //向books集合中添加三个元素
        books1.add(new String("Array"));
        books1.add(new String("List"));
        books1.add(new String("Test"));
        Iterator it1 = books1.iterator();
		while(it1.hasNext()){
			System.out.println(it1.next());
		}
		
		System.out.println("LinkedList:");
		LinkedList books2 = new LinkedList();
		// 将字符串元素加入队列的尾部(双端队列)
		books2.offer("Test");
		// 将一个字符串元素加入栈的顶部(双端队列)
		books2.push("List");
		// 将字符串元素添加到队列的头(相当于栈的顶部)
		books2.offerFirst("Linked");
        Iterator it2 = books2.iterator();
		while(it2.hasNext()){
			System.out.println(it2.next());
		}
		
		System.out.println("HashSet:");
		HashSet books3 = new HashSet();
		books3.add("Iterator");
		books3.add("Test");
		books3.add("BecksHwang");
		Iterator it3 = books3.iterator();
		while(it3.hasNext()){
			System.out.println(it3.next());
		}
		
		System.out.println("LinkedHashSet:");
		LinkedHashSet books4 = new LinkedHashSet();
		books4.add("Linked");
		books4.add("Hash");
		books4.add("Set");
		Iterator it4 = books4.iterator();
		while(it4.hasNext()){
			System.out.println(it4.next());
		}
		
		System.out.println("ArrayDeque:");
		ArrayDeque stack = new ArrayDeque();
        stack.push("Array");
        stack.push("Deque");
        stack.push("Test");
        Iterator it5 = stack.iterator();
		while(it5.hasNext()){
			System.out.println(it5.next());
		}
		
		System.out.println("PriorityQueue:");
		PriorityQueue pq = new PriorityQueue();
		pq.add(-1);
		pq.offer(9);
		pq.add(6);
		pq.offer(3);
		Iterator it6 = pq.iterator();
		while(it6.hasNext()){
			System.out.println(it6.next());
		}
		
		System.out.println("Stack:");
		Stack s = new Stack();
		// 依次将三个元素push入"栈"
		s.push("Stack");
		s.push("Test");
		s.push("BecksHwang");
		Iterator it7 = s.iterator();
		while(it7.hasNext()){
			System.out.println(it7.next());
		}
	}
}
/*
 * Collection接口继承了Iterable接口，所以其子类都可以用Iterator去遍历
 */
 