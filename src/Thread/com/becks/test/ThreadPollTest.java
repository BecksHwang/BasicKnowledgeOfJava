package Thread.com.becks.test;

import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPollTest {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 10, 200, TimeUnit.SECONDS, new ArrayBlockingQueue(5));
		PriorityQueue<String> targetQueue = new PriorityQueue<String>();
		targetQueue.offer("网站1");
		targetQueue.offer("网站2");
		targetQueue.offer("网站3");
		targetQueue.offer("网站4");
		targetQueue.offer("网站5");
		targetQueue.offer("网站6");
		targetQueue.offer("网站7");
		targetQueue.offer("网站8");
		targetQueue.offer("网站9");
		targetQueue.offer("网站10");
		System.out.println(targetQueue);
		for (String target : targetQueue) {
			executor.execute(new grapTask(target));
			System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
		             executor.getQueue().size()+"，已执行完的任务数目："+executor.getCompletedTaskCount());
		}
	}

}

class grapTask implements Runnable {

	private String target;

	grapTask(String target) {
		this.target = target;
	}

	@Override
	public void run() {
		System.out.println("执行抓取任务，抓取：" + target);
	}
}