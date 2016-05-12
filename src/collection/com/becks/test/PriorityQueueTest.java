package collection.com.becks.test;

import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();
		pq.add(-1);
		pq.offer(9);
		pq.add(6);
		pq.offer(3);
		//pq.add(null); 不允许插入空，报NullPointerException错误
		System.out.println(pq);
		System.out.println(pq.peek());//输出第一个元素，不删除
		System.out.println(pq);
		System.out.println(pq.poll());//输出第一个元素，并删除
		System.out.println(pq);
	}

}
/**
 * 输出结果： [-1, 3, 6, 9] 
 * 			-1 
 * 			[-1, 3, 6, 9] 
 * 			-1 
 * 			[3, 9, 6]
 * 
 * 结论：PriorityQueue对插入元素进行排序 
 * 	    JDK1.7中PriorityQueue中重写了add(E e)方法，返回offer(E e),所以使用他们是一个效果
 */
