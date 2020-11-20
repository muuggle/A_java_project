package Multithreading;


public class AddThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter1.lock) {
                Counter1.count += 1;
            }
        }
    }
}


