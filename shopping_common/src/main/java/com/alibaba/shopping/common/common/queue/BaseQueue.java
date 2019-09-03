package com.alibaba.shopping.common.common.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 所有消息队列的基类,组件优于继承
 * */
public class BaseQueue<T> {

	/** 消息队列 */
	private final BlockingQueue<T> queue = new LinkedBlockingQueue<T>();

	/**
	 * 阻塞返回
	 **/
	public T take() {
		try {
			return queue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 非阻塞返回
	 * @return
	 */
	public T poll() {
		return queue.poll();
	}

	/**
	 * 非阻塞存入
	 **/
	public boolean offer(T t) {
		return queue.offer(t);
	}

	/**
	 * 阻塞存入
	 **/
	public void put(T t) {
		try {
			queue.put(t);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getQueueSize() {
		return queue.size();
	}

}
