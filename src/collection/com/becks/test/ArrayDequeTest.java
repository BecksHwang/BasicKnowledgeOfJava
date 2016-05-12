package collection.com.becks.test;

import java.util.ArrayDeque;

public class ArrayDequeTest {

	public static void main(String[] args) 
    {
        ArrayDeque stack = new ArrayDeque();
        stack.push("Array");
        stack.push("Deque");
        stack.push("Test");

        System.out.println(stack);

        System.out.println(stack.peek());//访问第一个元素，但并不将其pop出"栈"，输出：Test

        System.out.println(stack);

        System.out.println(stack.pop());//pop出第一个元素 输出：Test

        System.out.println(stack);
    }

}
/**
 * 输出： [Test, Deque, Array] 
 * 		 Test 
 *       [Test, Deque, Array] 
 *       Test 
 *       [Deque, Array]
 *       
 * 结论：ArrayDeque起到栈的效果。
 */