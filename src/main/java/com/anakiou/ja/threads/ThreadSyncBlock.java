package com.anakiou.ja.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Worker {

	private Random random = new Random();
	
	private Object lock1 = new Object();
	private Object lock2 = new Object();

	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();

	public void stageOne() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		synchronized (lock1) {
			list1.add(random.nextInt());	
		}
	}

	public void stageTwo() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (lock2) {
			list2.add(random.nextInt());	
		}
	}

	public void process() {
		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}

	public void main() {
		System.out.println("Starting....");

		long start = System.currentTimeMillis();
		Thread t1 = new Thread(new Runnable() {

			public void run() {
				process();
			}

		});
		
		
		
		Thread t2 = new Thread(new Runnable() {

			public void run() {
				process();
			}

		});
		
		t1.start();
		t2.start();
		
		try{
		t1.join();
		t2.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();

		System.out.println("Time taken: " + (end - start));
		System.out.println("List1: " + list1.size() + "; list2: " + list2.size());
	}

}

public class ThreadSyncBlock {
	public static void main(String[] args) {

		Worker worker = new Worker();

		worker.main();
	}

}
