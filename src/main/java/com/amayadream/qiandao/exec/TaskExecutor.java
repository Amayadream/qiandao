package com.amayadream.qiandao.exec;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author :  Amayadream
 * @date :  2017.04.10 21:57
 */
public class TaskExecutor {

    public static void main(String[] args) {
        Storage storage = new Storage();
        Producer p1 = new Producer(storage);
        Producer p2 = new Producer(storage);
        Consumer c1 = new Consumer(storage);
//        Consumer c2 = new Consumer(storage);
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(p1);
        executor.execute(c1);
        executor.execute(p2);
//        executor.execute(c2);
    }

    static class Storage {

        private final Integer MAX_LENGTH = 100;
        private LinkedList<Integer> list = new LinkedList<Integer>();

        public void produce() {
            synchronized (list) {
                while (list.size() >= MAX_LENGTH) {
                    try {
                        System.out.println("当前库存" + list.size() + ", 生产者休眠!");
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.add(new Random(10).nextInt());
                System.out.println("生产者生产了一个产品, 当前库存" + list.size());
                list.notifyAll();
            }
        }

        public void consume() {
            synchronized (list) {
                while (list.size() == 0) {
                    try {
                        System.out.println("当前库存" + list.size() + ", 消费者休眠!");
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.remove();
                System.out.println("消费者消费了一个产品, 当前库存" + list.size());
                list.notifyAll();
            }
        }

    }

    static class Producer implements Runnable {

        private Storage storage;

        public Producer(Storage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    storage.produce();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public Storage getStorage() {
            return storage;
        }

        public void setStorage(Storage storage) {
            this.storage = storage;
        }
    }

    static class Consumer implements Runnable {

        private Storage storage;

        public Consumer(Storage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    storage.consume();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public Storage getStorage() {
            return storage;
        }

        public void setStorage(Storage storage) {
            this.storage = storage;
        }
    }


}
