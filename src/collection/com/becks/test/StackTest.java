package collection.com.becks.test;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack s = new Stack();
		// 依次将三个元素push入"栈"
		s.push("Stack");
		s.push("Test");
		s.push("BecksHwang");

		// 输出：[Stack, Test, BecksHwang]
		System.out.println(s);

		// 访问第一个元素，但并不将其pop出"栈"，输出：BecksHwang
		System.out.println(s.peek());

		// 依然输出：[Stack, Test, BecksHwang]
		System.out.println(s);

		// pop出最后一个入栈元素(弹出、删除)，输出：BecksHwang
		System.out.println(s.pop());

		// 输出：[Stack, Test]
		System.out.println(s);
	}

}
/**
 *符合“栈”先进后出的特点
 */