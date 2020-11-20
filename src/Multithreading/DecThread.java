package Multithreading;

public class DecThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter1.lock) {
                Counter1.count -= 1;
            }
        }
    }
}

class Counter1 {
    public static final Object lock = new Object();
    public static int count = 0;
}