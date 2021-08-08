package com.xiao.starter.lock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @desc: 功能描述：<分布式锁Redission测试>
 * @author： jianjun.xiao
 * @E-mail： xiaocen65535@163.com
 * @createTime： 2021/8/7 17:17
 */
public class RedissionTest {

    @Test
    public void test() throws Exception {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.1.51:6379");
        // config.useSingleServer().setPassword("redis1234");
        final RedissonClient client = Redisson.create(config);
        RLock lock = client.getLock("seele:task-scheme:userorg-sync1");

        CountDownLatch countDownLatch = new CountDownLatch(10);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                String name = Thread.currentThread().getName();
                System.out.println("尝试加锁：" + name);
                try {
                    /*
                     * 第一个参数为锁等待时间，第二个参数为锁存活时间，第三个参数为时间单位。
                     */
                    boolean b = lock.tryLock(1, 3600, TimeUnit.SECONDS);
                    lock.isHeldByCurrentThread();
                    System.out.println("加锁" + b + "： " + name);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if(lock.isHeldByCurrentThread()){
                        System.out.println("当前持有锁，我就不解");
                    } else {
                        System.out.println(name + "解锁");
                        lock.unlock();
                    }
                }
            });
        }

        countDownLatch.await();
        executorService.shutdown();

    }

}
