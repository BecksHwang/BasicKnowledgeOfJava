package test.com.becks.entity;

public class C implements A, B {

	@Override
	public void test() {
		System.out.println("C实现AB接口,虽然接口AB有同名的方法，但是都是要具体实现的方法，实现之后只有一个方法了。就是接口实现类里面的方法");
	}

}
