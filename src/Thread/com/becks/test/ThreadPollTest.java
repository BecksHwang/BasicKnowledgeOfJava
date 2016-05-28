package Thread.com.becks.test;

import java.util.ArrayDeque;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPollTest {

	public static void main(String[] args) {
		int i = 5;
		Target t = new Target();
		ThreadExecute threadExecute = new ThreadExecute();
		while (i > 0) {
			threadExecute.targetThead(t);
			--i;
		}
		threadExecute.shotdown();
	}

}

class grapTask implements Runnable {
	int count = 5;

	private static Target T;

	grapTask(Target t) {
		this.T = t;

	}

	@Override
	public void run() {
		--count;
		String target = T.getTarget();
		System.out.println("执行抓取任务，抓取：" + target);
		T.priorityQueueP();
		T.setTarget(target);
		if (count >= 0) {
			this.run();
		}

	}

}

class Target {
	private static ArrayDeque<String> targetQueue = new ArrayDeque<String>();

	Target() {
		targetQueue.push("网站9");
		targetQueue.push("网站8");
		targetQueue.push("网站7");
		targetQueue.push("网站6");
		targetQueue.push("网站5");
		targetQueue.push("网站4");
		targetQueue.push("网站3");
		targetQueue.push("网站2");
		targetQueue.push("网站1");
	}

	public void priorityQueueP() {
		System.out.println(targetQueue);
	}

	public synchronized String getTarget() {
		String target = null;
		if (!targetQueue.isEmpty()) {
			// 把目标网址从队列里面取出来
			target = targetQueue.poll();
		}
		return target;
	}

	public synchronized void setTarget(String target) {
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