package com.harmony.themis.software.util;

public class TestSleep {
	 
	  public static void main(String[] args) {
	   
	    MyThread2 t1 = new MyThread2("TestSleep");
	    t1.start();
	      
	     for(int i=0 ; i <10; i++)
	              System.out.println("I am Main Thread");
	   }
	 }
	 
	 class MyThread2 extends Thread {
	  
	    MyThread2(String s) {
	     super(s);
	     }
	     
	  public void run() {
	    for(int i = 1; i <= 10; i++) {
	     System.out.println("I am "+getName());
	     try {
	      sleep(1000); //暂停，每一秒输出一次
	      }catch (InterruptedException e) {
	      return;
	     }
	     }
	   }
	  }