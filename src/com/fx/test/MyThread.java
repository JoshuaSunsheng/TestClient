package com.fx.test;

import java.util.concurrent.CountDownLatch;

public class MyThread  implements Runnable {


    private CountDownLatch countDownLatch;  //多线程结束后，执行后面的代码（计算时间、数量）

    public MyThread( CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void run() {

        try{
            NewTestMain.OuterPushOrder();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            countDownLatch.countDown();
        }
    }
}
