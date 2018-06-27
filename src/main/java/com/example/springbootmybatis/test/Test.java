package com.example.springbootmybatis.test;

import com.google.gson.Gson;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Test1 test1=new Test1();
        Test2 test2=new Test2();
        Thread t1=new Thread(test1);
        t1.setName("test1");
        Thread t2=new Thread(test2);
        t2.setName("test2");
        t1.start();
        t2.start();

    }
}


class Test1 implements Runnable{
    @Override
    public void run() {
        while (true) {
            try {
                print();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    //同步锁，为了保证程序
    public synchronized void   print(){
        System.out.print("a");
        System.out.print("b");
        System.out.print("c");
        System.out.print("d"+System.lineSeparator());
        System.out.println(Thread.currentThread().getName());
    }
}
class Test2 implements Runnable{
    @Override
    public void run() {
        while (true) {
            try {
                print();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    //同步锁
    public  synchronized  void print(){
        System.out.print("A");
        System.out.print("B");
        System.out.print("C");
        System.out.print("D"+System.lineSeparator());
        System.out.println(Thread.currentThread().getName());
    }
}

