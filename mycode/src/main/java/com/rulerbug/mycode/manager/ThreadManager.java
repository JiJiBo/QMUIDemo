package com.rulerbug.mycode.manager;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

public class ThreadManager {
	private static ThreadPool threadPool;

	public static ThreadPool getInstance() {
		if (threadPool == null) {
			synchronized (ThreadManager.class) {
				if (threadPool == null) {
					int CpuCount = Runtime.getRuntime().availableProcessors();
					CpuCount *= 5;
					threadPool = new ThreadPool(CpuCount, CpuCount, 1L);
				}
			}
		}
		return threadPool;
	}

	public static class ThreadPool {

		private int corePoolSize;
		private int maximumPoolSize;
		private long keepAliveTime;

		private ThreadPoolExecutor executor;

		// 构造方法
		private ThreadPool(int corePoolSize, int maximumPoolSize,
				long keepAliveTime) {

			this.corePoolSize = corePoolSize;
			this.maximumPoolSize = maximumPoolSize;
			this.keepAliveTime = keepAliveTime;
		}

		public void execute(Runnable r) {
			if (executor == null) {
				// 新建线程池
				executor = new ThreadPoolExecutor(corePoolSize,
						maximumPoolSize, keepAliveTime, TimeUnit.SECONDS,
						new LinkedBlockingQueue<Runnable>(),
						Executors.defaultThreadFactory(), new AbortPolicy());
			}

			executor.execute(r);
		}

		public void cancel(Runnable r) {
			if (executor != null) {
				executor.getQueue().remove(r);
			}
		}
	}
}
