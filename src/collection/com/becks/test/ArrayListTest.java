package collection.com.becks.test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) 
    {
        List books = new ArrayList();
        //向books集合中添加三个元素
        books.add(new String("Array"));
        books.add(new String("List"));
        books.add(new String("Test"));
        System.out.println(books);

        //将新字符串对象插入在第二个位置
        books.add(1 , new String("List2"));
        for (int i = 0 ; i < books.size() ; i++ )
        {
            System.out.println(books.get(i));
        }

        //删除第三个元素
        books.remove(2);
        System.out.println(books);

        //判断指定元素在List集合中位置：输出1，表明位于第二位
        System.out.println(books.indexOf(new String("List2")));
        //将第二个元素替换成新的字符串对象
        books.set(1, new String("BecksHwang"));
        System.out.println(books);

        //将books集合的第二个元素（包括）
        //到第三个元素（不包括）截取成子集合
        System.out.println(books.subList(1 , 2));
    }

}
/**
 * 1) ensureCapacity(int minCapacity): 将ArrayList集合的Object[]数组长度增加minCapacity 
 * 2) trimToSize(): 调整ArrayList集合的Object[]数组长度为当前元素的个数。程序可以通过此方法来减少ArrayList集合对象占用的内存空间
 */