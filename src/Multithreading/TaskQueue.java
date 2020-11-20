package Multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//class TaskQueue {
//    Queue<String> queue = new LinkedList<>();
//
//    public synchronized void addTask(String s) {
//        this.queue.add(s);
//        this.notifyAll();// 唤醒在this锁等待的线程
//    }
//
//    public synchronized String getTask() throws InterruptedException {
//        while (queue.isEmpty()) {
//            // 释放this锁:
//            this.wait();
//            // 重新获取this锁
//        }
//        return queue.remove();
//    }
//}
class TaskQueue {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private Queue<String> queue = new LinkedList<>();

    public void addTask(String s) {
        lock.lock();
        try {
            queue.add(s);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public String getTask() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition.await();
            }
            return queue.remove();
        } finally {
            lock.unlock();
        }
    }
}
