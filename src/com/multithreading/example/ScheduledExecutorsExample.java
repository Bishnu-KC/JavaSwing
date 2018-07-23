package com.multithreading.example;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorsExample {
	public static void main(String args[])
	{
		ScheduledExecutorService obj= Executors.newScheduledThreadPool(1);
		Runnable task=()->
		{
			System.out.println("Executing Task At"+ System.nanoTime());
			
		};
		System.out.println("Submitting task at"+System.nanoTime()+"to be executed after 5 seconds.");
		obj.schedule(task,5,TimeUnit.SECONDS);
		obj.shutdown();
	}

}
