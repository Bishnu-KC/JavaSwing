package com.multithreading.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCancelExample {
	public static void main(String args[]) throws InterruptedException, ExecutionException
	{
		ExecutorService es=Executors.newSingleThreadExecutor();
		long startTime=System.nanoTime();
		Future<String> future=es.submit(()->
		{
			Thread.sleep(2000);
			return "Hello form Callable";
			
		}
		);
		while(!future.isDone())
		{
			System.out.println("Task is still not done...");
			Thread.sleep(200);
			double elapsedTimeInSec=(System.nanoTime()-startTime)/1000000000000.0;
			if(elapsedTimeInSec>1)
			{
				future.cancel(true);
			}
		}
		System.out.println("Task completed ! Retriving the result");
		String result=future.get();
		System.out.println(result);
		es.shutdown();
	}

}
