package Multithreading;

import java.io.Reader;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//public class Counter {
////    public static final Object lock = new Object();
////    //    public static int count=0;
////    private int count = 0;
//
////    public void add(int n) {
////        synchronized (this) {
////            count += n;
////        }
////    }
////
////    public void dec(int n) {
////        synchronized (this) {
////            count -= n;
////        }
////    }
////
////    public int get() {
////        return count;
////    }
//
//    //    public synchronized void add(int n){
////        if (n<0){
////            dec(-n);
////        }
////        else {
////            count+=n;
////        }
////    }
////    public synchronized void dec(int n){
////        count+=n;
////    public void add(int m) {
////        synchronized (lockA) {
////            this.value += m;
////            synchronized(lockB){
////                this.another += m;
////            }
////        }
////    }
////    public void dec(int m) {
////        synchronized(lockA) { // 获得lockB的锁
////            this.another -= m;
////            synchronized(lockB) { // 获得lockA的锁
////                this.value -= m;
////            } // 释放lockA的锁
////        } // 释放lockB的锁‘、\
////    private final Lock lock = new ReentrantLock();
////    private int count;
////
////    public void add(int n) {
////        lock.lock();
////        try {
////            count += n;
////        } finally {
////            lock.unlock();
////        }
////    }
//    private final Lock lock = new ReentrantLock();
//    private int[] counts = new int[10];
//
//    public void inc(int index){
//        lock.lock();
//        try{
//            counts[index]+=1;
//        }finally {
//            lock.unlock();
//        }
//    }
//    public int[] get(){
//        lock.lock();
//        try{
//            return Arrays.copyOf(counts,counts.length);
//        } finally {
//            lock.unlock();
//        }
//    }
//}

public class Counter {
    private final ReadWriteLock rwlock = new ReentrantReadWriteLock();
    private int[] counts = new int[10];
    private final Lock rlock = rwlock.readLock();
    private final Lock wlock = rwlock.writeLock();

    public void inc(int index) {
        wlock.lock();
        try {
            counts[index] += 1;
        } finally {
            wlock.unlock();
        }
    }

    public int[] get() {
        rlock.lock(); // 加读锁
        try {
            return Arrays.copyOf(counts, counts.length);
        } finally {
            rlock.unlock(); // 释放读锁
        }
    }
}


