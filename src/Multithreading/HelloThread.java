package Multithreading;

public class HelloThread extends Thread {
    public volatile boolean running = true;
    //volatile线程间共享变量

    //    public void run() {
//        int n = 0;
//        while (!isInterrupted()) {
//            n++;
//            System.out.println(n + " hello");
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                break;
//            }
//        }
//    }
    public void run() {
        int n = 0;
        while (running) {
            n++;
            System.out.println(n + " hello");
        }
        System.out.println("end!");
    }
}
