package com.multithreading.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureAndCallableExample {
	public static void main(String args[]) throws InterruptedException, ExecutionException
	{
		ExecutorService es=Executors.newSingleThreadExecutor();
		Callable<String> callable=()->
		{
			// perform some computatuon
			System.out.println("Entered Callable");
			Thread.sleep(2000);
			return "Hello from callable";
		};
		System.out.println("Submitting callable");
		Future<String> future=es.submit(callable);
		//This line executes immediately
		System.out.println("Do something else while callablle is getting executed");
		System.out.println("Retrive the result of the future");
		
		// future.get() blocks until the result is available
		String result=future.get();
		System.out.println(result);
		es.shutdown();
	}

}
