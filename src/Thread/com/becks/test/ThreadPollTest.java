package Thread.com.becks.test;

import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPollTest {

	public static void main(String[] args) {
		Target t = new Target();
		ThreadExecute threadExecute = new ThreadExecute();
		threadExecute.targetThead(t);
	}

}

class grapTask implements Runnable {

	private Target T;

	grapTask(Target t) {
		this.T = t;

	}

	@Override
	public void run() {
		String target = T.getTarget();
		System.out.println("执行抓取任务，抓取：" + target);
		T.priorityQueueP();
		T.setTarget(target);
		this.run();
	}

}

class Target {
	private PriorityQueue<String> targetQueue = new PriorityQueue<String>();

	Target() {
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
	}
	
	public void priorityQueueP(){
		System.out.println(targetQueue);
	}

	public String getTarget() {
		String target = null;
		if (!targetQueue.isEmpty()) {
			// 把目标网址从队列里面取出来
			target = targetQueue.poll();
		}
		return target;
	}

	public void setTarget(String target) {
		// 把目标网址加入队列
		targetQueue.add(target);
	}
}

class ThreadExecute {
	private ThreadPoolExecutor executor;

	ThreadExecute() {
		executor = new ThreadPoolExecutor(3, 10, 200, TimeUnit.SECONDS, new ArrayBlockingQueue(5));
	}

	// 启动抓取线程
	public void targetThead(Target t) {
		executor.execute(new grapTask(t));
		System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" + executor.getQueue().size()
				+ "，已执行完的任务数目：" + executor.getCompletedTaskCount());
	}

	// 关闭连接池
	public void shotdown() {
		executor.shutdown();
	}
}