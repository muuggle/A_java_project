package Multithreading;

class MyThread extends Thread {
    //    @Override
//    public void run() {
//        int n = 0;
//        while (!isInterrupted()) {
//            n++;
//            System.out.println(n + "hello!");
//        }
//    }
    public void run() {
        Thread hello = new HelloThread();
        hello.start();
        try {
            hello.join();
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
        hello.interrupt();
    }
}