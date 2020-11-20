package Multithreading;

//public class Main {
//    public static void main(String[] args) {
////        Thread t=new MyThread();
////        Thread t = new Thread(new MyRunnable());
////        Thread t = new Thread(() -> {
////            System.out.println("start new thread!");
////        });
////        t.start();
//
//        System.out.println("main start...");
//        Thread  t= new Thread(() -> {
//            System.out.println("thread run...");
//            System.out.println("thread end.");
//        });
//        t.start();
//        System.out.println("main end...");
//    }
//}

//public class Main {
//    public static void main(String[] args) {
//        System.out.println("main start...");
//        Thread t = new Thread(() -> {
//            System.out.println("thread run...");
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                System.out.println("thread end.");
//            }
//        });
//        t.start();
//        try {
//            Thread.sleep(20);
//        } catch (InterruptedException ignored) {
//        }
//        System.out.println("main end...");
//    }
//}

//public class Main {
//    public static void main(String[] args) throws Exception {
//        Thread t = new Thread(() -> {
//            System.out.println("hsjdhjias");
//        });
//        System.out.println("start");
//        t.start();
//        t.join();
//        System.out.println("end");
//    }
//}

//public class Main {
//    public static void main(String[] args) throws InterruptedException {
////        Thread t = new MyThread();
////        t.start();
////        Thread.sleep(1000);
////        t.interrupt(); // 中断t线程
////        t.join();// 等待t线程结束
////        System.out.println("end");
//
//        HelloThread t=new HelloThread();
//        t.start();
//        Thread.sleep(10);
//        t.running=false;
//    }
//}

//public class Main {
//
//    public static void main(String[] args) {
//        Thread t = new Thread1();
//        // 如果注释下一行，观察Thread1的执行情况:
//        t.setDaemon(true);
//        t.start();
//        System.out.println("main: wait 3 sec...");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//        }
//        System.out.println("main: end.");
//    }
//
//}
//
//class Thread1 extends Thread {
//
//    public void run() {
//        for (;;) {
//            System.out.println("Thread-1: running...");
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//            }
//        }
//    }
//}
//线程同步
//public class Main {
//    public static void main(String[] args) throws Exception {
//        var add=new AddThread();
//        var dec =new DecThread();
//        add.start();
//        dec.start();
//        add.join();
//        dec.join();
//        System.out.println(Counter.count);
//    }
//}

//public class Main {
//    public static void main(String[] args) throws Exception {
//        var ts = new Thread[]{new AddStudentThread(), new DecStudentThread(),
//                new AddTeacherThread(), new DecTeacherThread()};
//        for (var t : ts) {
//            t.start();
//        }
//        for (var t : ts) {
//            t.join();
//        }
//        System.out.println(Counter1.studentCount);
//        System.out.println(Counter1.teacherCount);
//    }
//}
//
//
//class Counter1{
//    public static final Object lockstudent=new Object();
//    public static final Object lockteacher=new Object();
//    public static int studentCount=0;
//    public static int teacherCount=0;
//
//}
//class AddStudentThread extends Thread {
//    public void run() {
//        for (int i=0; i<10000; i++) {
//            synchronized(Counter1.lockstudent) {
//                Counter1.studentCount += 1;
//            }
//        }
//    }
//}
//
//class DecStudentThread extends Thread {
//    public void run() {
//        for (int i=0; i<10000; i++) {
//            synchronized(Counter1.lockstudent) {
//                Counter1.studentCount -= 1;
//            }
//        }
//    }
//}
//
//class AddTeacherThread extends Thread {
//    public void run() {
//        for (int i=0; i<10000; i++) {
//            synchronized(Counter1.lockteacher) {
//                Counter1.teacherCount += 1;
//            }
//        }
//    }
//}
//
//class DecTeacherThread extends Thread {
//    public void run() {
//        for (int i=0; i<10000; i++) {
//            synchronized(Counter1.lockteacher) {
//                Counter1.teacherCount -= 1;
//            }
//        }
//    }
//}

//public class Main {
//
//    static final Object LOCK_A = new Object();
//    static final Object LOCK_B = new Object();
//
//    public static void main(String[] args) {
//        new Thread1().start();
//        new Thread2().start();
//    }
//
//    static void sleep1s() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//class Thread1 extends Thread {
//
//    public void run() {
//        System.out.println("Thread-1: try get lock A...");
//        synchronized (Main.LOCK_A) {
//            System.out.println("Thread-1: lock A got.");
//            Main.sleep1s();
//            System.out.println("Thread-1: try get lock B...");
//            synchronized (Main.LOCK_B) {
//                System.out.println("Thread-1: lock B got.");
//                Main.sleep1s();
//            }
//            System.out.println("Thread-1: lock B released.");
//        }
//        System.out.println("Thread-1: lock A released.");
//    }
//}
//
//class Thread2 extends Thread {
//
//    public void run() {
//        System.out.println("Thread-2: try get lock B...");
//        synchronized (Main.LOCK_A) {
//            System.out.println("Thread-2: lock B got.");
//            Main.sleep1s();
//            System.out.println("Thread-2: try get lock A...");
//            synchronized (Main.LOCK_B) {
//                System.out.println("Thread-2: lock A got.");
//                Main.sleep1s();
//            }
//            System.out.println("Thread-2: lock A released.");
//        }
//        System.out.println("Thread-2: lock B released.");
//    }
//}


import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.Random;


//public class Main {
//    public static void main(String[] args) throws InterruptedException {
//        var q = new TaskQueue();
//        var ts = new ArrayList<Thread>();
//        for (int i = 0; i < 5; i++) {
//            var t = new Thread() {
//                public void run() {
//                    // 执行task:
//                    while (true) {
//                        try {
//                            String s = q.getTask();
//                            System.out.println("execute task: " + s);
//                        } catch (InterruptedException e) {
//                            return;
//                        }
//                    }
//                }
//
//            };
//            t.start();
//            ts.add(t);
//        }
//        var add = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                // 放入task:
//                String s = "t-" + Math.random();
//                System.out.println("add task: " + s);
//                q.addTask(s);
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                }
//            }
//        });
//        add.start();
//        add.join();
//        Thread.sleep(100);
//        for (var t : ts) {
//            t.interrupt();
//        }
//    }
//}

//public class Main {
//    public static void main(String[] args) {
//        ExecutorService es = Executors.newCachedThreadPool();
//        for (int i = 0; i < 6; i++) {
//            es.submit(new Task("" + i));
//        }
//        es.shutdown();
//    }
//}

//public class Main {
//    public static void main(String[] args) {
//        ExecutorService es = Executors.newFixedThreadPool(4);
//        for (int i = 0; i < 6; i++) {
//            es.submit(new Task1("" + i));
//        }
//        es.shutdown();
//    }
//}
//
//class Task1 implements Runnable {
//
//    private final String name;
//
//    public Task1(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public void run() {
//        System.out.println("start task " + name);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//        }
//        System.out.println("end task " + name);
//    }
//}

//public class Main {
//    public static void main(String[] args) throws Exception {
//        // 创建异步执行任务:
//        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(Main::fetchPrice);
//        // 如果执行成功:
//        cf.thenAccept((result) -> {
//            System.out.println("price: " + result);
//        });
//        // 如果执行异常:
//        cf.exceptionally((e) -> {
//            e.printStackTrace();
//            return null;
//        });
//        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭
//        Thread.sleep(200);
//    }
//
//    static Double fetchPrice() {
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//        }
//        if (Math.random() < 0.3) {
//            throw new RuntimeException("fetch price failed!");
//        }
//        return 5 + Math.random() * 20;
//    }
//}

//public class Main {
//    public static void main(String[] args) throws Exception {
//        //第一个任务
//        CompletableFuture<String> cfQuery = CompletableFuture.supplyAsync(() -> {
//            return queryCode("zhongguoshiyou");
//        });
//        // cfQuery成功后继续执行下一个任务:
//        CompletableFuture<Double> cfFetch = cfQuery.thenApplyAsync((code) -> {
//            return fetchPrice(code);
//        });
//        // cfFetch成功后打印结果:
//        cfFetch.thenAccept((result) -> {
//            System.out.println("price: " + result);
//        });
//        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
//        Thread.sleep(2000);
//    }
//
//    static String queryCode(String name) {
//        try {
//            Thread.sleep(100);
//
//        } catch (InterruptedException e) {
//        }
//        return "501857";
//    }
//
//    static Double fetchPrice(String code) {
//        try {
//            Thread.sleep(100);
//
//        } catch (InterruptedException e) {
//
//        }
//        return 5 + Math.random() * 20;
//    }
//}

//public class Main {
//    public static void main(String[] args) throws Exception {
//        // 两个CompletableFuture执行异步查询:
//        CompletableFuture<String> cfQueryFromSina = CompletableFuture.supplyAsync(() -> {
//            return queryCode("中国石油", "https://finance.sina.com.cn/code/");
//        });
//        CompletableFuture<String> cfQueryFrom163 = CompletableFuture.supplyAsync(() -> {
//            return queryCode("中国石油", "https://money.163.com/code/");
//        });
//
//        // 用anyOf合并为一个新的CompletableFuture:
//        CompletableFuture<Object> cfQuery = CompletableFuture.anyOf(cfQueryFromSina, cfQueryFrom163);
//
//        // 两个CompletableFuture执行异步查询:
//        CompletableFuture<Double> cfFetchFromSina = cfQuery.thenApplyAsync((code) -> {
//            return fetchPrice((String) code, "https://finance.sina.com.cn/price/");
//        });
//        CompletableFuture<Double> cfFetchFrom163 = cfQuery.thenApplyAsync((code) -> {
//            return fetchPrice((String) code, "https://money.163.com/price/");
//        });
//
//        // 用anyOf合并为一个新的CompletableFuture:
//        CompletableFuture<Object> cfFetch = CompletableFuture.anyOf(cfFetchFromSina, cfFetchFrom163);
//
//        // 最终结果:
//        cfFetch.thenAccept((result) -> {
//            System.out.println("price: " + result);
//        });
//        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
//        Thread.sleep(2000);
//    }
//
//    static String queryCode(String name, String url) {
//        System.out.println("query code from " + url + "...");
//        try {
//            Thread.sleep((long) Math.random() * 1000);
//        } catch (InterruptedException e) {
//        }
//        return "601857";
//    }
//
//    static Double fetchPrice(String code, String url) {
//        System.out.println("query price from " + url + "...");
//        try {
//            Thread.sleep((long) Math.random() * 1000);
//        } catch (InterruptedException e) {
//        }
//        return 5 + Math.random() * 20;
//    }
//}
//public class Main {
//    public static void main(String[] args) throws Exception {
//        // 创建2000个随机数组成的数组:
//        long[] array = new long[2000];
//        long expectedsum = 0;
//        for (int i = 0; i < array.length; i++) {
//            array[i] = random();
//            expectedsum += array[i];
//        }
//        System.out.println("Expected sum: " + expectedsum);
//        // fork/join:
//        ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
//        long starttime = System.currentTimeMillis();
//        Long result = ForkJoinPool.commonPool().invoke(task);
//        long endTime = System.currentTimeMillis();
//        System.out.println("Fork/join sum: " + result + " in " + (endTime - starttime) + " ms.");
//    }
//
//    static Random random = new Random(0);
//
//    static long random() {
//        return random.nextInt(10000);
//    }
//}
//
//class SumTask extends RecursiveTask<Long> {
//    static final int THRESHOLD = 500;
//    long[] array;
//    int start;
//    int end;
//
//    SumTask(long[] array, int start, int end) {
//        this.array = array;
//        this.start = start;
//        this.end = end;
//    }
//    @Override
//    protected Long compute() {
//        if (end - start <= THRESHOLD) {
//            // 如果任务足够小,直接计算:
//            long sum = 0;
//            for (int i = start; i < end; i++) {
//                sum += this.array[i];
//                // 故意放慢计算速度:
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException ignored) {
//                }
//            }
//            return sum;
//        }
//        // 任务太大,一分为二:
//        int middle = (end + start) / 2;
//        System.out.printf("split %d~%d ==> %d~%d, %d~%d%n", start, end, start, middle, middle, end);
//        SumTask subtask1 = new SumTask(this.array, start, middle);
//        SumTask subtask2 = new SumTask(this.array, middle, end);
//        invokeAll(subtask1, subtask2);
//        Long subresult1 = subtask1.join();
//        Long subresult2 = subtask2.join();
//        Long result = subresult1 + subresult2;
//        System.out.println("result = " + subresult1 + " + " + subresult2 + " ==> " + result);
//        return result;
//    }
//}

public class Main {
    public static void main(String[] args) throws Exception {
        log("start main...");
        new Thread(() -> {
            log("run task...");
        }).start();
        new Thread(() -> {
            log("print...");
        }).start();
        log("end main.");
    }

    static void log(String s) {
        System.out.println(Thread.currentThread().getName() + ": " + s);
    }
}

