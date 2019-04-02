package com.fx.test;

import java.util.concurrent.*;

public class MyThreadTestMain {


    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

        long beginTime = System.currentTimeMillis();//开始系统时间

        //线程池
        ExecutorService pool = Executors.newCachedThreadPool();
        //设置集合点为93
        final int count = 1;
        CountDownLatch countDownLatch = new CountDownLatch(count);//与countDownLatch.await();实现运行完所有线程之后才执行后面的操作
//        final CyclicBarrier barrier = new CyclicBarrier(count);  //与barrier.await() 实现并发;
        //创建100个线程
        for(int i = 0; i < count; i++){

            MyThread target = new MyThread(countDownLatch);
//            barrier.await();
            pool.execute(target);
        }

        pool.shutdown();
        try {
            countDownLatch.await();  //这一步是为了将全部线程任务执行完以后，开始执行后面的任务（计算时间，数量）
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis(); //结束时间
        System.out.println(count + " 个  接口请求总耗时 ： "+(endTime-beginTime)+"-----平均耗时为"+ ((endTime-beginTime)/count));
    }

}
