package com.multithreading.example;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulaeExample {
	public static void main(String args[])
	{
		ScheduledExecutorService obj=Executors.newScheduledThreadPool(1);
		Runnable task=()->
		{
			System.out.println("Executing Task At"+ System.nanoTime());
		};
		System.out.println("scheduling task to be executed every 2 seconds with an initial delay of 0 seconds");
		obj.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS);
	}

}
